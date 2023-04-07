// Databricks notebook source
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._
import org.apache.spark.sql.{Column, DataFrame}
import org.apache.spark.sql.types._


// COMMAND ----------

val dr:DataFrame=spark.read.option("multiline", "true").json("/FileStore/companydata.json")

// COMMAND ----------

def flattenDataframe(df: DataFrame): DataFrame = {
  val fields = df.schema.fields
  val fieldNames = fields.map(x => x.name)
  val length = fields.length
  for (i <- 0 to fields.length - 1) {
    val field = fields(i)
    val fieldtype = field.dataType
    val fieldName = field.name
    if (fieldtype.isInstanceOf[ArrayType]) {
      val fieldEx = fieldNames.filter(_ != fieldName)
      val fieldExplode = fieldEx ++ Array(s"explode_outer($fieldName) as $fieldName")
      val explodedDf = df.selectExpr(fieldExplode: _*)
      return flattenDataframe(explodedDf)
    } else if (fieldtype.isInstanceOf[StructType]) {
      val child = fieldtype.asInstanceOf[StructType].fieldNames.map(childname => fieldName + "." + childname)
      val newfield = fieldNames.filter(_ != fieldName) ++ child
      val renamedcols = newfield.map(x => (col(x.toString()).as(x.toString().replace(".", "_"))))
      val explodedf = df.select(renamedcols: _*)
      return flattenDataframe(explodedf)
    }
  }
  df
}


// COMMAND ----------

val ln = flattenDataframe(dr)

// COMMAND ----------

display(ln)

// COMMAND ----------

ln.count()
