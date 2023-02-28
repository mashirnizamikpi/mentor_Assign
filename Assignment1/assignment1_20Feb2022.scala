// Databricks notebook source
// DBTITLE 1,Importing the Packages
import org.apache.spark.sql.functions.desc//Packages of descending
import org.apache.spark.sql.functions.{col}  //Packages of column
import org.apache.spark.sql.functions.rank
import org.apache.spark.sql.expressions.Window

// COMMAND ----------

// DBTITLE 1,Path Declaration
val path = "/FileStore/tables/assign1.json"

// COMMAND ----------

// DBTITLE 1,Read the file from DBFS
val employeeDF = sqlContext.read.option("header", "true").option("inferSchema", "true").json(path)

// COMMAND ----------

// DBTITLE 1,Schema of the table
employeeDF.printSchema() 

// COMMAND ----------

// DBTITLE 1,Total number of records
print(employeeDF.count())


// COMMAND ----------

// DBTITLE 1,Exploding the nested JSON 
val empDF=employeeDF.select($"EMPID",$"dept",$"empname",$"salary",$"address.*") //Splitting the address in city and state
empDF.show()

// COMMAND ----------

// DBTITLE 1,Employee name and his/her department
employeeDF.select($"empname",$"dept").show()

// COMMAND ----------

// DBTITLE 1,Find out high salaried employee -- Approach 1
val maxsalary=empDF.orderBy(desc("salary")).limit(1)
maxsalary.show()

// COMMAND ----------

// DBTITLE 1,Find out high salaried employee -- Approach 2
val window = Window.orderBy(desc("salary"))
val rank_df = empDF.withColumn("Rank@High-Salary", rank().over(window))
rank_df.show()

// COMMAND ----------

// DBTITLE 1,Hike of 20,000 for annual appraisal cycle - new column with updated salary
val updatempDF = empDF.withColumn("Updated_Salary",col("salary")+20000)
 updatempDF.show(false)


// COMMAND ----------

// DBTITLE 1,Saving results of new data frame to file system (DBFS)
updatempDF.write.mode(SaveMode.Overwrite).format("json").save("s3://kpi-batch5/Mashir/Assignment1/")
