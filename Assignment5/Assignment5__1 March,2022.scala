// Databricks notebook source
// DBTITLE 1,Variable declaration
val map = Map(1000->"M", 900->"CM", 500->"D", 400->"CD", 100->"C", 90->"XC", 50->"L", 40->"XL",11->"XI", 10->"X", 9->"IX", 4->"IV", 1->"I")
val maps = Map('2'->"abc", '3'->"def", '4'->"ghi", '5'->"jkl", '6'->"mno", '7'->"pqrs", '8'->"tuv", '9'->"wxyz") //Key-Map Value pairs

// COMMAND ----------

// DBTITLE 1,Reverse Integer - Approach 1
object Solution {
  def reverse(x: Int): Int = {
    try {
      val str = x.abs.toString.reverse //use reverse function
      val res = str.toInt //For conversion to int
      res
    } catch {
      case e: Exception => 0
      }
  }
}


// COMMAND ----------

// DBTITLE 1,Output
Solution.reverse(123)

// COMMAND ----------

// DBTITLE 1,Reverse Integer - Approach 2
object Solution {
  def reversed(x: Int): Int = {
    try {
      val res = x.abs.toString.reverse.toInt
      if (res < Int.MinValue || res > Int.MaxValue) 0 //reverse condition not apply
      else res
    } catch {
      case e: Exception => 0
      }
  }
}


// COMMAND ----------

// DBTITLE 1,Output
Solution.reversed(123)

// COMMAND ----------

// DBTITLE 1,Palindrome Number -Approach 1
object Solution {
  def isPalindrome(x: Int): Boolean = {
   try { if (x < 0) false
    else {
      val str = x.toString //First convert int to string
      str == str.reverse //Use reverse function for reverse
    } } catch {
      case e: Exception => false
      }
        
    }
  }


// COMMAND ----------

// DBTITLE 1,Output
Solution.isPalindrome(121)

// COMMAND ----------

// DBTITLE 1,Palindrome Number -Approach 2
object Solution {
def isPalindrome2(x: Int): Boolean = {
  try {
    val reversed = x.toString.reverse.toInt //Convert to string then reverse and then convert to int 
    x == reversed
  } catch {
    case ex: NumberFormatException => false
  }
} }


// COMMAND ----------

// DBTITLE 1,Output
Solution.isPalindrome2(123)

// COMMAND ----------

// DBTITLE 1,Integer to Roman -Approach 1
def intToRoman(num: Int): String = {
 try { var result = ""
  var n = num
  map.foreach { //Use for each case 
    case (key, value) =>
      while(n >= key) {
        result += value
        n -= key
      }
  }
  result
}
  catch {
    case ex: Exception => "false"
}
}


// COMMAND ----------

// DBTITLE 1,Output
Solution.intToRoman(25)

// COMMAND ----------

// DBTITLE 1,Integer to Roman -Approach 2
def intToRoman(num: Int): String = {
  try {
    var result = ""
  var n = num
  for(key <- map.keys) { //Using the for loop
    while(n >= key) {
      result += map(key)
      n -= key
    }
  }
  result
}
  catch {
    case ex: Exception => "false"
}
}



// COMMAND ----------

// DBTITLE 1,Output


// COMMAND ----------

// DBTITLE 1,Longest Common Prefix - Approach 1
def longestCommonPrefix(strs: Array[String]): String = {
try {    var prefix = strs(0) //initialize variable prefix
    for(i <- 1 until strs.length){
        while(strs(i).indexOf(prefix) != 0){
            prefix = prefix.substring(0, prefix.length-1)  //use till length of prefix
            if(prefix.isEmpty) return ""
        }
    }
    prefix
    }
  catch {
    case ex: Exception => "false"
}
}


// COMMAND ----------

// DBTITLE 1,Output
longestCommonPrefix(Array("flower","flow","flight"))

// COMMAND ----------

// DBTITLE 1,Longest Common Prefix - Approach 2
  def approach2(strs: Array[String]): String = {
try {  if (strs == null || strs.length == 0) return ""

    for (i <- 0 until strs(0).length) {
      val c = strs(0).charAt(i)
      for (j <- 1 until strs.length) {
        if (i == strs(j).length || strs(j).charAt(i) != c)
          return strs(0).substring(0, i)
      }
    }
    strs(0)
  }
      catch {
    case ex: Exception => "false"
}
}


// COMMAND ----------

// DBTITLE 1,Letter Combinations of a Phone Number - Approach 1
 def letterCombinations2(digits: String): List[String] = {
    digits.foldLeft(List("")) { (combinations, digit) =>
      for {
        combination <- combinations
        letter <- maps(digit)
      } yield combination + letter
    }.filter(_.nonEmpty)
  }

// COMMAND ----------

// DBTITLE 1,Output
letterCombinations2("23")

// COMMAND ----------

// DBTITLE 1,Letter Combinations of a Phone Number - Approach 2
  def letterCombinations3(digits: String): List[String] = {
    if (digits.isEmpty) {
      List.empty
    } else {
      digits.foldLeft(List("")) { (combinations, digit) =>
        combinations.flatMap(combination => maps(digit).map(letter => combination + letter))
      }.filter(_.nonEmpty)
    }
  }

// COMMAND ----------

// DBTITLE 1,Output
letterCombinations3("63")
