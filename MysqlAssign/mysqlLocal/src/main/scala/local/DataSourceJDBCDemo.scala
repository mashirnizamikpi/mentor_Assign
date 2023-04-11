package local

import org.apache.spark.sql.{DataFrame, SparkSession}
import java.util.Properties

object DataSourceJDBCDemo {

  def readJdbcTable(schemaName: String, tableName: String, userName: String, pass: String): DataFrame = {
    val spark = SparkSession.builder().appName("SparkJDBCDemo").master("local[1]").getOrCreate()

    val jdbcUrl = s"jdbc:mysql://localhost:3306/${schemaName}"
    val connectionProperties = new Properties()

    connectionProperties.setProperty("user", userName)
    connectionProperties.setProperty("password", pass)

    val mySqlDF = spark.read.jdbc(jdbcUrl, tableName, connectionProperties)

    mySqlDF.printSchema()
    mySqlDF.show()

    mySqlDF
  }

  def main(args: Array[String]): Unit = {
    val schemaName = "kpi"
    val tableName ="employee"
    val userName = "root"
    val pass = "root"

    val mySqlDF = readJdbcTable(schemaName, tableName, userName, pass)
  }
}
