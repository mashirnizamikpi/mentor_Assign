// Databricks notebook source
// DBTITLE 1,Importing the packages
import org.apache.log4j.Logger //Logger Packages
import org.apache.spark.sql
import org.apache.spark.sql.functions.{col,desc,coalesce}
import org.apache.spark.sql.functions.{when} //Conditional packages
import org.apache.spark.sql.functions.max
import org.apache.spark.sql.expressions.Window //window packages
import org.apache.spark.sql.functions.{row_number} //Row Number Packages
import org.apache.spark.sql.functions.{sum}

// COMMAND ----------

// DBTITLE 1,Path and variable declaration
var path1 = "/FileStore/trial/tweets.csv"
var path2 = "/FileStore/trial/corona_dataset_latest.csv"
var format = "csv"
val logger = Logger.getLogger(getClass.getName)  //logger variable declaration
var temp_table = "loanstats"
var table_name = "loanstatus_sel"
var par_name = "lc_loan_data1"

// COMMAND ----------

// DBTITLE 1,Importing the file function
def importBigDataFile(path: String, format: String) = {
  try{ //exception handling
  spark.read.format(format)
    .option("header", "true")
    .option("inferSchema", "true").option("multiline", "true")
    .load(path)
}
  catch {
    case ex: Exception =>
      logger.error(s"Failed to import file at path $path", ex) //logger message
      spark.emptyDataFrame //return the empty dataframe or query
  }
}

// COMMAND ----------

// DBTITLE 1,Load the twitter dataset
var twitter_df = importBigDataFile(path1,format)
twitter_df.show()

// COMMAND ----------

// DBTITLE 1,load the corona dataset
var corona_df = importBigDataFile(path2,format)
corona_df.show()

// COMMAND ----------

// DBTITLE 1,Total rows in corona dataframe
corona_df.count()

// COMMAND ----------

// DBTITLE 1,Show only USA  country
twitter_df.filter("country = 'USA'").show()

// COMMAND ----------

// DBTITLE 1,Show data where country is USA and location starts with New
twitter_df.filter("country = 'USA' and location like 'New%'").show()

// COMMAND ----------

// DBTITLE 1,Only USA country explaination
var tw_filter_df = twitter_df.filter("country = 'USA'")
tw_filter_df.explain() //Explain is used for explain the datafraem

// COMMAND ----------

// DBTITLE 1,Explaination of data where country is USA and location stasrts with New
tw_filter_df = twitter_df.filter("country = 'USA' and location like '% New%'")
tw_filter_df.explain()


// COMMAND ----------

// DBTITLE 1,Show only top 5 rows
twitter_df.show(5)

// COMMAND ----------

// DBTITLE 1,Show data where location starts with N
val tw_filter_df = twitter_df.filter(col("location").startsWith("N"))
tw_filter_df.explain()

// COMMAND ----------

// DBTITLE 1,Show only top 5 rows
tw_filter_df.show(5)

// COMMAND ----------

// DBTITLE 1,First column of dataframe
twitter_df.first()

// COMMAND ----------

// DBTITLE 1,Show only top 5 rows of dataset
twitter_df.take(5)

// COMMAND ----------

// DBTITLE 1,Show only text and user 
twitter_df.select("text","user").show()

// COMMAND ----------

// DBTITLE 1,First five texts of this RDD
val textRdd = twitter_df.rdd.map(row => row.getString(row.fieldIndex("text")).split(" ")) //split the twitter data into text
val firstFiveRows = textRdd.take(5)

// COMMAND ----------

// DBTITLE 1,First 1000 text of this RDD
val textRdd = twitter_df.rdd.flatMap(row => row.getString(row.fieldIndex("text")).split(" ")) //split the text of the twitter
val firstThousandWords = textRdd.take(1000)

// COMMAND ----------

// DBTITLE 1,Sort date by desc
corona_df.filter("Country = 'US'").orderBy(desc("Date")).show()

// COMMAND ----------

// DBTITLE 1,City in Order
corona_df.filter("Country = 'US'").orderBy(("City")).show()

// COMMAND ----------

// DBTITLE 1,Sort by date and confirmed columns
corona_df.filter("Country = 'US'").sortWithinPartitions(desc("Date"),col("Confirmed")).show()

// COMMAND ----------

// DBTITLE 1,Describe the dataframe
corona_df.describe().show()

// COMMAND ----------

// DBTITLE 1,Schema of corna dataframe
corona_df.printSchema()

// COMMAND ----------

// DBTITLE 1,Sort by confirmed columns where confirmed > 10
corona_df.filter("Confirmed>10 and Country= 'US'").orderBy(desc("Confirmed")).show()

// COMMAND ----------

// DBTITLE 1,max date of dataframe
val result = corona_df.agg(max("Date").as("max_date"), max("Confirmed").as("max_confirmed")).collect()


// COMMAND ----------

// DBTITLE 1,macimum date
var max_date = corona_df.agg(max("Date")).head().get(0) //only show maximum date
print(max_date)


// COMMAND ----------

// DBTITLE 1,Group by country and state_cleaned
corona_df.groupBy(col("Country"), col("State_Cleaned"))
  .agg(max(col("Date"))) //Country wise maximum date
  .show()

// COMMAND ----------

// DBTITLE 1,Inner join
val maxDateDf = corona_df.groupBy(col("Country"), col("State_Cleaned"))
  .agg(max(col("Date")).alias("Date"))

corona_df.join(maxDateDf, Seq("Country", "State_Cleaned", "Date"), "inner") //Inner join the previous data
  .sort(col("Confirmed"))
  .show()

// COMMAND ----------

// DBTITLE 1,Show data over partition
val ws = Window.partitionBy(col("Country"), col("State_Cleaned"))
  .orderBy(col("Date").desc)

corona_df.withColumn("row_num", row_number().over(ws)) //over the window specification
  .show()

// COMMAND ----------

// DBTITLE 1,sort the dataframe where row_num=1
val ws = Window.partitionBy(col("Country"), col("State_Cleaned"))
  .orderBy(col("Date").desc)

corona_df.withColumn("row_num", row_number().over(ws)) //over the window specification
  .where(col("row_num") === 1)
  .show(false)

// COMMAND ----------

// DBTITLE 1,Inner join the dataframe
val corona_max_df = corona_df.join(corona_df.groupBy(col("Country"), col("State_Cleaned")).agg(max(col("Date")).alias("Date")),
  Seq("Country", "State_Cleaned", "Date"),"inner").sort(col("Confirmed")) //Inner join the previous data
corona_max_df.show()


// COMMAND ----------

// DBTITLE 1,Dtaframe by creating pivot table

corona_df.groupBy(col("Country"))
  .pivot("Date") //show date wise and confirmed cases
  .agg(sum(col("Confirmed")))
  .show()


// COMMAND ----------

corona_df.filter(col("Country") === "US")
  .groupBy(col("State"))
  .pivot("Date") // Show datawise data
  .count()
  .show()


// COMMAND ----------

// DBTITLE 1,Total country wise recovered and death caes
corona_max_df.groupBy(col("Country"))
  .agg(sum(col("Confirmed")),sum(col("Recovered")),sum(col("Death")))
  .orderBy(col("sum(Confirmed)").desc) //order by total confirmed cases in desc
  .show()

// COMMAND ----------

// DBTITLE 1,Show only Italy country 
corona_df.filter("Country == 'Italy'").orderBy(desc("Date")).show()

// COMMAND ----------

// DBTITLE 1,Corona Active Cases
val resultDF = corona_df
  .withColumn("Active", $"Confirmed" - $"Recovered" - $"Death") //Active cases  = (confirmed - recovered -death)cases 
  .sort(desc("Active")) //sort Active by desc
resultDF.show()
