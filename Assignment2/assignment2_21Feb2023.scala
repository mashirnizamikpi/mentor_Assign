// Databricks notebook source
// DBTITLE 1,Program whether number is prime or not
def isPrime(i: Int): Boolean =
    if (i % i != 0)
       false
   else
        true

// COMMAND ----------

// DBTITLE 1,Result whether prime or not
isPrime(46)

// COMMAND ----------

// DBTITLE 1,Program for n-th Fibonacci number
def fibonacci(n: Int): Int = {
  if (n <= 1) n
  else fibonacci(n-1) + fibonacci(n-2)
}


// COMMAND ----------

// DBTITLE 1,Result for n-th Fibonacci number
fibonacci(9)

// COMMAND ----------

// DBTITLE 1,Program if a given number is Fibonacci number
def isPerfectSquare(n: Int): Boolean = {
  val sqrtN = math.sqrt(n)
  (sqrtN * sqrtN) == n
}

def isFibonacci(n: Int): Boolean = {
  isPerfectSquare(5 * n * n + 4) || isPerfectSquare(5 * n * n - 4)
}

// COMMAND ----------

// DBTITLE 1,Result if a given number is Fibonacci number
isFibonacci(144)

// COMMAND ----------

// DBTITLE 1,Program for nth multiple of a number in Fibonacci Series
def findNthMultiple(n: Int, k: Int): Int = {
  def fibonacci(m: Int): Int = {
    if (m == 0) 0
    else if (m == 1) 1
    else fibonacci(m - 1) + fibonacci(m - 2)
  }

  val multiple = fibonacci(n) * k
  multiple
}


// COMMAND ----------

// DBTITLE 1,Result for nth multiple of a number in Fibonacci Series
findNthMultiple(1,6)

// COMMAND ----------

// DBTITLE 1,Program to print ASCII Value of a character
def printASCIIValue(c: Char): Unit = {
  val asciiValue = c.toInt
  println(s"The ASCII value of $c is: $asciiValue")
}

// COMMAND ----------

// DBTITLE 1,Resukt to print ASCII Value of a character
printASCIIValue('a')

// COMMAND ----------

// DBTITLE 1,Program for Sum of squares of first n natural numbers
def sumOfSquares(n: Int): Int = {
  (1 to n).map(i => i * i).sum
}


// COMMAND ----------

// DBTITLE 1,Resukt for Sum of squares of first n natural numbers
sumOfSquares(4)

// COMMAND ----------

// DBTITLE 1,Program for Sum of cube of first n natural numbers
def sumOfCubes(n: Int): Int = {
  (1 to n).map(i => i * i * i).sum
}

// COMMAND ----------

// DBTITLE 1,Program for Sum of cube of first n natural numbers
sumOfCubes(3)
