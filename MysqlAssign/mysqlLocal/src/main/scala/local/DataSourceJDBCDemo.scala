package local

import org.apache.spark.sql.SparkSession;
import java.util.Properties;

object DataSourceJDBCDemo {

  def main(args: Array[String]){

    val spark = SparkSession.builder().appName("SparkJDBCDemo").master("local[1]").getOrCreate()


    val schemaName = "kpi"
    val tableName ="employee"
    val userName = "root"
    val pass = "root"

    val jdbcUrl = s"jdbc:mysql://localhost:3306/${schemaName}"
    val connectionProperties = new Properties()

    connectionProperties.setProperty("user", userName)
    connectionProperties.setProperty("password", pass)

    val mySqlDF = spark.read.jdbc(jdbcUrl, tableName, connectionProperties)

    mySqlDF.printSchema()

    mySqlDF.show()


  }
}