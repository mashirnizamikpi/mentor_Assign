// Databricks notebook source
// DBTITLE 1,Importing the packages
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql._
import org.apache.spark.sql.functions.desc
import org.apache.log4j.Logger //importing the logger package

// COMMAND ----------

// DBTITLE 1,Variable declaration
val path1 = "/FileStore/tables/loan.csv"
val path2 = "/FileStore/tables/credit_card.csv"
val path3 = "/FileStore/tables/txn.csv"
val csvformat = "csv"
val logger = Logger.getLogger(getClass.getName)  //logger variable declaration

// COMMAND ----------

// DBTITLE 1,Import file function
def importBigDataFile(filePath: String, format: String) = {
  try{ //exception handling
  spark.read.format(format)
    .option("header", "true")
    .option("inferSchema", "true").option("multiline", "true")
    .load(filePath)
}
  catch {
    case ex: Exception =>
      logger.error(s"Failed to import file at path $filePath", ex) //logger message
      spark.emptyDataFrame //return the empty dataframe or query
  }
}

// COMMAND ----------

// DBTITLE 1,Loan Dataset
val loandata = importBigDataFile(path1,csvformat)

// COMMAND ----------

// DBTITLE 1,Schema of Loan Dataset
loandata.printSchema()

// COMMAND ----------

// DBTITLE 1,Show only 5 rows
loandata.show(5)

// COMMAND ----------

// DBTITLE 1,Total columns
loandata.columns.length

// COMMAND ----------

// DBTITLE 1,Total rows
loandata.count()

// COMMAND ----------

// DBTITLE 1,count distinct rows
loandata.distinct().count()

// COMMAND ----------

// DBTITLE 1,number of loans in each category
loandata.groupBy("Loan Category").count().orderBy(desc("count")).show(false)


// COMMAND ----------

// DBTITLE 1,number of people who have taken more than 1 lack loan
val loancount = loandata.filter(loandata("Loan Amount")>"1,00,000").count()

// COMMAND ----------

// DBTITLE 1,number of people with income greater than 60000 rupees
loandata.filter(loandata("Income")>"60000").count()

// COMMAND ----------

// DBTITLE 1,number of people with 2 or more returned cheques and income less than 50000
loandata.filter((loandata(" Returned Cheque")>"1") && (loandata("Income")<"50000")).count()


// COMMAND ----------

// DBTITLE 1,number of people with 2 or more returned cheques and are single
loandata.filter((loandata(" Returned Cheque")>"1") && (loandata("Marital Status")<"SINGLE")).count()

// COMMAND ----------

// DBTITLE 1,number of people with expenditure over 50000 a month 
loandata.filter(loandata("Expenditure") > "50000").show()


// COMMAND ----------

// DBTITLE 1,Load Credit Card Dataset
val creditdata = importBigDataFile(path2,csvformat)

// COMMAND ----------

// DBTITLE 1,Schema of Credit Data
creditdata.printSchema()

// COMMAND ----------

// DBTITLE 1,Toal columns
creditdata.columns.length

// COMMAND ----------

// DBTITLE 1,Total rows in credit dataset
creditdata.count()

// COMMAND ----------

// DBTITLE 1,count distinct rows
creditdata.distinct().count()

// COMMAND ----------

// DBTITLE 1,Show only top 5 rows of credit dataset
creditdata.show(5)

// COMMAND ----------

// DBTITLE 1,number of members who are elgible for credit card
creditdata.filter(creditdata("CreditScore")>700).count()

// COMMAND ----------

// DBTITLE 1,number of members who are  elgible and active in the bank
creditdata.filter((creditdata("IsActiveMember")===1) && (creditdata("CreditScore")>700)).count()


// COMMAND ----------

// DBTITLE 1,credit card users in Spain
creditdata.filter(creditdata("Geography")==="Spain").show()


// COMMAND ----------

// DBTITLE 1,count the data where estimated salary > 1,00,000 
creditdata.filter(creditdata("EstimatedSalary") > 100000 && creditdata("Exited") === 1).count()


// COMMAND ----------

// DBTITLE 1,count the data where estimated salary < 1,00,000 
creditdata.filter((creditdata("EstimatedSalary")<100000) && (creditdata("NumOfProducts")>1)).count()

// COMMAND ----------

// DBTITLE 1,Load transaction dataset
val txndata = importBigDataFile(path3,csvformat)

// COMMAND ----------

// DBTITLE 1,Schema of transaction dataframe
txndata.printSchema()

// COMMAND ----------

// DBTITLE 1,Count of transaction on every account
txndata.groupBy("Account No").count().show()


// COMMAND ----------

// DBTITLE 1,Maximum withdrawal amount
txndata.groupBy("Account No").max(" WITHDRAWAL AMT ").orderBy(desc("max( WITHDRAWAL AMT )")).show(false)


// COMMAND ----------

// DBTITLE 1,MINIMUM WITHDRAWAL AMOUNT OF AN ACCOUNT
txndata.groupBy("Account No").min(" WITHDRAWAL AMT ").orderBy("min( WITHDRAWAL AMT )").show()


// COMMAND ----------

// DBTITLE 1,MAXIMUM DEPOSIT AMOUNT OF AN ACCOUNT
txndata.groupBy("Account No").max(" DEPOSIT AMT ").orderBy(desc("max( DEPOSIT AMT )")).show(false)


// COMMAND ----------

// DBTITLE 1,MINIMUM DEPOSIT AMOUNT OF AN ACCOUNT
txndata.groupBy("Account No").min(" DEPOSIT AMT ").orderBy("min( DEPOSIT AMT )").show()


// COMMAND ----------

// DBTITLE 1,sum of balance in every bank account
txndata.groupBy("Account No").sum("BALANCE AMT").show()


// COMMAND ----------

// DBTITLE 1,Number of transaction on each date
txndata.groupBy("VALUE DATE").count().orderBy(desc("count")).show(false)

// COMMAND ----------

// DBTITLE 1,List of customers with withdrawal amount more than 1 lakh
txndata.select("Account No","TRANSACTION DETAILS"," WITHDRAWAL AMT ").filter(txndata(" WITHDRAWAL AMT ")>100000).show()

