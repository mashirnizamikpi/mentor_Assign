// Databricks notebook source
// DBTITLE 1,Importing the packages
import org.apache.spark.sql.DataFrame 
import org.apache.spark.sql.functions._
import org.apache.spark.sql.functions.{avg, col}
import org.apache.log4j.Logger //importing Logger packages 
import org.apache.spark.sql.functions.{year, to_date} //importing year and to_date for conversion
import org.apache.spark.sql.types.{DateType, IntegerType}

// COMMAND ----------

// DBTITLE 1,Path and format variable declaration
val csvpath = "/FileStore/tables/owid_covid_data.csv"
val csvformat="csv"
val logger = Logger.getLogger(getClass.getName) //for declaring the logger

// COMMAND ----------

// DBTITLE 1,Import file function
def importFile(filePath: String, format: String)= {
  try{                      //exception handling
  spark.read.format(format)
  .option("header", "true")
  .option("inferSchema", "true")
    .load(filePath)
}catch {
    case ex: Exception =>
      logger.error(s"Failed to import file at path $filePath", ex) //logger message in the case of failure of operation
      spark.emptyDataFrame //return an empty dataframe or query
  }
}

// COMMAND ----------

// DBTITLE 1,Use csv path and format in function
val dataFrame = importFile(csvpath,csvformat)

// COMMAND ----------

// DBTITLE 1,Schema of the dataframe
dataFrame.printSchema()

// COMMAND ----------

// DBTITLE 1,Display the Dataframe
display(dataFrame)

// COMMAND ----------

// DBTITLE 1,Filter first 100 rows
val filteredData = dataFrame.limit(100)

// COMMAND ----------

// DBTITLE 1,Display first 100 rows
display(filteredData)

// COMMAND ----------

// DBTITLE 1,Show continent wise case count
val result = dataFrame.groupBy("continent").agg(sum("total_cases").alias("total_cases")).show()

// COMMAND ----------

// DBTITLE 1,Show location wise case count
val result = dataFrame.groupBy("location").agg(sum("total_cases").alias("total_cases"))
display(result)

// COMMAND ----------

// DBTITLE 1,Add new column year in dataframe
val dfWithYear = dataFrame.withColumn("year", year(col("date")))
display(dfWithYear)

// COMMAND ----------

// DBTITLE 1,Check Year wise which year has more cases in which location
val maxCasesRow = dfWithYear.groupBy("year", "location").agg(sum("total_cases").alias("total_cases")).orderBy(desc("total_cases")).first()
val maxYear = maxCasesRow.getAs[Int]("year") //Get the year into int format
val maxLocation = maxCasesRow.getAs[String]("location")  //Get the location into string format

println(s"${maxLocation} has the more cases in ${maxYear}")

// COMMAND ----------

// DBTITLE 1,location is having good or maximum handwashing_facilities 
val maxCasesRow = dfWithYear.groupBy("location").agg(sum("handwashing_facilities").alias("handwashing_facilities")).orderBy(desc("handwashing_facilities")).first()
val GdLocation = maxCasesRow.getAs[String]("location")
println(s"${GdLocation} has the good handwashing facilities ")


// COMMAND ----------

// DBTITLE 1,write into diffent files in dbfs -- Approach 1
dfWithYear
  .repartition($"year")
  .write
  .partitionBy("Year") //By partitioning the dataframe
  .mode("overwrite")
  .format("csv")
  .save("/FileStore/trial/datewise")

// COMMAND ----------

// DBTITLE 1,separate DF for each year's data and write into diffent files in dbfs 


// COMMAND ----------

// DBTITLE 1,Total years in data
val distinctYears = dfWithYear.select("year").distinct()
display(distinctYears)

// COMMAND ----------

// DBTITLE 1,Function for separate DF for each year's data
def separateByYear(year: Int)= {
  try{dfWithYear.filter(col("year") === year) //exception handling 
}
 catch {
    case ex: Exception =>
      logger.error(s"Failed to filter $year", ex) //logger message
      spark.emptyDataFrame //return an empty dataframe or query
  }
}

// COMMAND ----------

// DBTITLE 1,Daraframe for year 2023 
val year23Frame = separateByYear(2023)
display(year23Frame)

// COMMAND ----------

// DBTITLE 1,Daraframe for year 2022
val year22Frame = separateByYear(2022)
display(year22Frame)

// COMMAND ----------

// DBTITLE 1,Daraframe for year 2021
val year21Frame = separateByYear(2021)
display(year21Frame)

// COMMAND ----------

// DBTITLE 1,Dataframe for year 2020
val year20Frame = separateByYear(2020)
display(year20Frame)

// COMMAND ----------

// DBTITLE 1,Saving the dataframe into DBFS by overwriting
year20Frame.write.mode(SaveMode.Overwrite).format("csv").save("/FileStore/collection/yearwise/2020")
year21Frame.write.mode(SaveMode.Overwrite).format("csv").save("/FileStore/collection/yearwise/2021")
year22Frame.write.mode(SaveMode.Overwrite).format("csv").save("/FileStore/collection/yearwise/2022")
year23Frame.write.mode(SaveMode.Overwrite).format("csv").save("/FileStore/collection/yearwise/2023")

// COMMAND ----------

// DBTITLE 1,Show distinct continents in dataframe
val distinctContinents = dataFrame.select("continent").distinct()
display(distinctContinents)

// COMMAND ----------

// DBTITLE 1, Separate DF for each continent's data and write into diffent files in DBFS -Approach 1


// COMMAND ----------

// DBTITLE 1,Function for Separate DF for each continent's data 
def filterByContinent(continent: String) = {
  try{ //exception handling
  dataFrame.filter(col("Continent") === continent)
}
catch {
    case ex: Exception =>
      logger.error(s"Failed to get $continent", ex) //logger message
      spark.emptyDataFrame //return an empty dataframe or query
  }
}

// COMMAND ----------

// DBTITLE 1,Dataframe for Europe
var Europe = (filterByContinent("Europe"))
display(Europe)

// COMMAND ----------

// DBTITLE 1,Dataframe for Africa
var Africa = (filterByContinent("Africa"))
display(Africa)

// COMMAND ----------

// DBTITLE 1,Dataframe for South America
var SouthAmerica = (filterByContinent("South America"))
display(SouthAmerica)

// COMMAND ----------

// DBTITLE 1,Dataframe for North America
var NorthAmerica = (filterByContinent("North America"))
display(NorthAmerica)

// COMMAND ----------

// DBTITLE 1,Dataframe for Oceania
var Oceania = (filterByContinent("Oceania"))
display(Oceania)

// COMMAND ----------

// DBTITLE 1,Dataframe for Asia
var Asia = (filterByContinent("Asia"))
display(Asia)

// COMMAND ----------

// DBTITLE 1,Save the Continent dataframe in DBFS by overwriting
Europe.write.mode(SaveMode.Overwrite).format("csv").save("/FileStore/collection/continents/Europe")
Africa.write.mode(SaveMode.Overwrite).format("csv").save("/FileStore/collection/continents/Africa")
SouthAmerica.write.mode(SaveMode.Overwrite).format("csv").save("/FileStore/collection/continents/SouthAmerica")
NorthAmerica.write.mode(SaveMode.Overwrite).format("csv").save("/FileStore/collection/continents/NorthAmerica")
Oceania.write.mode(SaveMode.Overwrite).format("csv").save("/FileStore/collection/continents/Oceania")
Asia.write.mode(SaveMode.Overwrite).format("csv").save("/FileStore/collection/continents/Asia")
