// Databricks notebook source
// DBTITLE 1,program to add two numbers
def add(a:Int,b:Int){
 var sum = a + b
  println("the sum of "+a+" and "+b+": "+sum)
}

// COMMAND ----------

add(4,6)


// COMMAND ----------

// DBTITLE 1,Maximum of two numbers in Scala
def max(a:Int,b:Int){
  if(a>b){
    println("the greatest number is:"+a);
  }else
  println("the greatest number is:"+b);
}

// COMMAND ----------

max(2,5)

// COMMAND ----------

// DBTITLE 1,Factorial of a number
def factorial(n: Int): Int = {
  var fact = 1
  for (i <- 1 to n) {
    fact = fact * i
  }
  println("The factorial of " + n + " is " + fact)
  fact
}

// COMMAND ----------

factorial(4)

// COMMAND ----------

// DBTITLE 1,simple interest
def interest(amount:Int,rate:Float,year:Int){
  var interest = (amount *rate*year)/100;
  println("The simple interest is "+interest)
}

// COMMAND ----------

interest(45000,7,2)

// COMMAND ----------

// DBTITLE 1,compound interest
def compound(amount: Int, rate: Float, year: Int) {
  val compound = amount * math.pow(1 + rate / 100, year) - amount
  println("The compound interest is " + compound)
}

// COMMAND ----------

compound(45000,10,2)

// COMMAND ----------

// DBTITLE 1,Area of circle
def area(radii:Double){
  var area:Double = 3.14 *radii*radii;
  println("The area of circle with radius "+radii+" is "+area)
}

// COMMAND ----------

area(3.14)

// COMMAND ----------

// DBTITLE 1,Find sum of array
def Sumarray(num:Array[Int]){
  var sum =0;
  for(i<-0 until num.length){
    sum = num(i)+sum;
    }
  println("The sum of array is : "+sum)
}

// COMMAND ----------

Sumarray(Array(2, 3))

// COMMAND ----------

// DBTITLE 1,Reverse words in a given String 
def reverse(word:String){
  for(ch<-word.reverseIterator){
       println(ch)
  }
}

// COMMAND ----------

// DBTITLE 1,Reverse words in a given String 
def reverse(word:String){
  for(i<-word.length-1 to 0 by -1){
    println(word(i))
  }
}

// COMMAND ----------

reverse("mashir")

// COMMAND ----------

// DBTITLE 1,ASCII Value of a character
def ascii(ch:Char){
  var num = ch.toInt
  println(num)
}

// COMMAND ----------

ascii('c')

// COMMAND ----------



// COMMAND ----------

// DBTITLE 1,Sum of square of first natural number
def sum(n:Int){
  var sum =0
  for(i<-1 to n){
    sum = i*i+sum
     }
  println("The sum of square of first natural number : "+sum)
}

// COMMAND ----------

sum(3)

// COMMAND ----------

// DBTITLE 1,Cube sum of first n natural numbers
def sum(n:Int){
  var sum =0
  for(i<-1 to n){
    sum = i*i*i+sum
     }
  println("The sum of square of first natural number : "+sum)
}

// COMMAND ----------

sum(5)

// COMMAND ----------

// DBTITLE 1,Sum of elements in list
def sumadd(num:List[Int]){
  var sum =0
  for(i<-0 to num.length-1){
    sum=sum+num(i)
  }
  println("The sum of elements in list is :"+sum)
}

// COMMAND ----------

sumadd(List(1, 2, 3, 4))

// COMMAND ----------

// DBTITLE 1,Multiply all numbers in the list
def multiple(num:List[Int]){
  var prod = 1
  for(i<-0 to num.length-1){
    prod=prod*num(i)   
  }
  println("The multple of numbers in list is: "+prod)
}


// COMMAND ----------

multiple(List(1,2,2,4))

// COMMAND ----------

// DBTITLE 1,Scala | Reversing a List
def reverse(num:List[Int]){
  for(i<-num.length-1 to 0 by -1){
println(num(i))  
  }
}

// COMMAND ----------

reverse(List(7,2,4,9))

// COMMAND ----------

// DBTITLE 1,Scala program to print even numbers in a list
def even(num:List[Int]){
  for(i<-0 to num.length-1){
if(num(i)%2==0){
  println(num(i))
} 
  }
}

// COMMAND ----------

even(List(1,4,5,6,8,9))

// COMMAND ----------

// DBTITLE 1,Scala program to print odd numbers in a list
def odd(num:List[Int]){
  for(i<-0 to num.length-1){
if(num(i)%2!=0){
  println(num(i))
} 
  }
}

// COMMAND ----------

odd(List(1,3,6,8,7))

// COMMAND ----------

// DBTITLE 1,Print all even numbers in a range
def everange(start:Int,end:Int){
  for(i<-start to end){
    if (i%2==0){
      println(i)
    }
  }
}

// COMMAND ----------

everange(5,16)

// COMMAND ----------

// DBTITLE 1,Print all odd numbers in a range
def oddrange(start:Int,end:Int){
  for(i<-start to end){
    if (i%2!=0){
      println(i)
    }
  }
}

// COMMAND ----------

oddrange(6,25)

// COMMAND ----------

// DBTITLE 1,Print all positive numbers in a range 
def posrange(start:Int,end:Int){
  for(i<-start to end){
    if(i>0)
    {
      println(i)
    }
  }
}

// COMMAND ----------

posrange(-100,22)

// COMMAND ----------

// DBTITLE 1,Scala program to print all negative numbers in a range
def nevrange(start:Int,end:Int){
  for(i<-start to end){
    if(i<0)
    {
      println(i)
    }
  }
}

// COMMAND ----------

nevrange(-25,20)

// COMMAND ----------

// DBTITLE 1,Scala program to print positive numbers in a list 
def posList(num:List[Int]){
  for(i<-0 to num.length-1){
    if(num(i)>0){
      println(num(i))
    }
  }
}

// COMMAND ----------

posList(List(-1,2,3,-43,8))

// COMMAND ----------

// DBTITLE 1,Scala program to print negative numbers in a list
def negList(num:List[Int]){
  for(i<-0 to num.length-1){
    if(num(i)<0){
      println(num(i))
    }
  }
}

// COMMAND ----------

negList(List(-1,2,3,-43,8))

// COMMAND ----------

// DBTITLE 1,find length of list
def lnt(list:List[Int]){
  println(list.length)
}

// COMMAND ----------

lnt(List(1,7,8,0,9))

// COMMAND ----------

// DBTITLE 1,Scala | Ways to check if element exists in list
def check(item:Int){
  var list = List(2,4,6,8,9,10)
      if(list.contains(item)){
      println("The item is present" )}
        else{ println("Item not present")
            }
  }

// COMMAND ----------

check(3)

// COMMAND ----------

def checking(item:Int){
  var liste = List(2,3,4,6,8)
    for(i<-0 to liste.length-1){
      if(item==liste(i)){
        println("The item is present at "+i)
      }
    }
  }

// COMMAND ----------

// DBTITLE 1,Sum of number digits in List
def sum(list:List[Int]){
var sum =0
  for(i<-0 to list.length-1){
  sum=sum+list(i)
}
  println("The sum of elements in list :"+sum)
}

// COMMAND ----------

sum(List(1,8,9,76))

// COMMAND ----------

// DBTITLE 1,Scala program to find smallest number in a list
def minimum(list:List[Int]){
  println("The minimum element in list is "+list.min)
}

// COMMAND ----------

minimum((List(12,15,3,5,2)))

// COMMAND ----------

// DBTITLE 1,Scala program to find largest number in a list
def maximum(list:List[Int]){
  println("The largest element in list is "+list.max)
}

// COMMAND ----------

maximum(List(2,5,4,8,99))

// COMMAND ----------

def maximum(list:Array[Int]){
  println("The largest element in list is "+list.max)
}

// COMMAND ----------

maximum(Array(2,5,4,8,99))

// COMMAND ----------

// DBTITLE 1,Second largest element in list
def maximum(list:List[Int]){
  var sort=list.sorted
  println("The largest element in list is "+sort(sort.length-2))
}

// COMMAND ----------

maximum(List(5,3,32,23))

// COMMAND ----------

// DBTITLE 1,N largest element in list
def maximum(list:List[Int],range:Int){
  var sort=list.sorted
  println("The largest "+range+" element in list is "+sort(sort.length-range))
}

// COMMAND ----------

maximum(List(2,7,8,4,2,3,3),1)

// COMMAND ----------

// DBTITLE 1,Scala program to find Cumulative sum of a list
def cumulativeSum(lst: List[Int]) {
var sum = 0;
  for(i<- 0 to lst.length-1){
    sum=sum+lst(i)
    println(sum)
  }
}


// COMMAND ----------

cumulativeSum(List(8,9,6,4))

// COMMAND ----------

// DBTITLE 1,Find length of a string in Scala 
def length(word:String){
  println("The length is "+word.length)
}

// COMMAND ----------

def length(word:String){
   println(word.size)
}

// COMMAND ----------

length("Master")

// COMMAND ----------



// COMMAND ----------

// DBTITLE 1,Permutation of a given string using inbuilt function
def permut(word:String){
for(ch<-word.permutations){
  println(ch)
}
}

// COMMAND ----------

permut("abc")

// COMMAND ----------

// DBTITLE 1,Scala program to print even length words in a string
def even(input: String) {
  for (word <- input.split(" ")) {
    if (word.length % 2 == 0) {
      print(word+" ")
    }
  }
}


// COMMAND ----------

even("rocky is greate")

// COMMAND ----------

// DBTITLE 1,Scala Program to Split the array and add the first part to the end
def first(num:Array[Int]){
 var mid = (num.length-1)/2
 var last = num.length
 var array1=num.slice(0,mid+1)
      println("1st Array after splitting:"+ array1.mkString(","))
 var array2=num.slice(mid,last)
      println("2nd Array after splitting:"+ array2.mkString(","))
println("Sum of arrays:")
  for(i<-0 to mid){
  var sum =0
  sum = array1(i)+array2(i)
  print(sum+ " ")
}


  }



// COMMAND ----------

first(Array(2,8,7,5,6,3))

// COMMAND ----------

// DBTITLE 1,Scala program to check if a string is palindrome or not
def palindrome(item: String){
  if(item == item.reverse){
    println(item+" is palindrome String")
  }else {
     println(item+" is not palindrome String")
  }
}

// COMMAND ----------

palindrome("masam")

// COMMAND ----------

// DBTITLE 1,Scala | Check if a Substring is Present in a Given String
def substring(item:String,found:String){
  var flag = false
  if(item.contains(found)){
    println(!flag)
  }
  else println(flag)
}

// COMMAND ----------

substring("This is project","is")

// COMMAND ----------

// DBTITLE 1,Scala Program for Find reminder of array multiplication divided by n
def multiple(item:Array[Int],n:Int)
{
  var prod = 1
  for(i<-0 to item.length-1)
  {
    prod = prod *item(i)
  }
  var div = prod/n
  println(div)
  
}

// COMMAND ----------

multiple((Array(4,5,6,7)),7)

// COMMAND ----------

// DBTITLE 1,Scala – Replace all occurrences of a substring in a string
def replace(words:String,item:String,titem:String){
  var newstr = words.replaceAll(item,titem)
  println(newstr)
}

// COMMAND ----------

replace("hello this is hello","hello","hye")

// COMMAND ----------

// DBTITLE 1,Scala – Replace multiple words with K
def replace(str: String, words: Seq[String]): String = {
  val pattern = words.mkString("|")
  str.replaceAll(pattern, "K")
}


// COMMAND ----------

replace("this is mashir",Seq("is", "this"))

// COMMAND ----------

// DBTITLE 1,Scala | Check if a given string is binary string or not
def isBinaryString(s: String): Boolean = {
  s.forall(c => c == '0' || c == '1')
}

// COMMAND ----------

isBinaryString("010101")

// COMMAND ----------

// DBTITLE 1,Scala program to accept the strings which contains all vowels
def isvowelString(str:String):Boolean={
    val vowels = Set('a', 'e', 'i', 'o', 'u')
  vowels.subsetOf(str.toSet)

}

// COMMAND ----------

isvowelString("my name is ootury")

// COMMAND ----------

// DBTITLE 1,Scala | Cloning or Copying a list
def cloning(list:List[Int]){
  var cloned = List(list:_*)
  for(i<-0 to list.length-1){
    print(list(i)+" ")
  }
}

// COMMAND ----------

cloning(List(2,3,4,6,4))

// COMMAND ----------

// DBTITLE 1,Scala – Convert Snake case to Pascal case
def camel(str:String) {
  var res = str.split("_").map(_.capitalize).mkString("")
  println(res)
}


// COMMAND ----------

camel("geeks_for_geeks")

// COMMAND ----------

// DBTITLE 1,Scala program to check whether a number is Prime or not
def isPrime(num: Int) {
  if(num==1){
    println(num+" is not prime number")
  } 
  else if(num==2) {
    println(num+" is prime number")
  } 
  else {
    var prime = true
    for(x <- 2 to num-1){
      if(num%x==0){
        prime = false
      }
    }
    if(prime) {
      println(num+" is prime number")
    } else {
      println(num+" is not prime number")
    }
  }
}


// COMMAND ----------

isPrime(2)

// COMMAND ----------

// DBTITLE 1,Scala program to print all Prime numbers in an Interval
def range(start:Int,end:Int) {
  for (i <- start to end) {
    var prime = true
    for (j <- 2 until i) {
      if (i % j == 0) {
        prime = false
      }
    }
    if (prime && i > 1) {
      println(i)
    } 
  }
}


// COMMAND ----------

range(1,100)

// COMMAND ----------

// DBTITLE 1,Scala program to split and join a string
def stjoin(str:String){
  var wsplit = str.split(" ").mkString(",")
  println(wsplit)
}

// COMMAND ----------

stjoin("Hye this is Mashir")

// COMMAND ----------

// DBTITLE 1,Ways to remove i’th character from string in Scala
def remove(str:String,i:Int){
  val newStr = str.take(i) + str.drop(i+1)
  println(newStr)
}

// COMMAND ----------

remove("Hello this is",3)

// COMMAND ----------

// DBTITLE 1,Remove all duplicates from a given string in Scala
  def remove(str:String){
  var duplicate = str.distinct.mkString("")
    println(duplicate)
  }

// COMMAND ----------

remove("aabbcc")

// COMMAND ----------

// DBTITLE 1,Scala | Check for URL in a String
def urlcheck(str: String): Boolean = {
  val url = Array("http", "//", "/", "www")
  for (i <- 0 until url.length) {
    if (str.contains(url(i))) {
      return true
    }
  }
  false
}


// COMMAND ----------

urlcheck("Some examples for HTTP URIs with query components:http://example.com/foo?bar")

// COMMAND ----------

// DBTITLE 1,Find words which are greater than given length k
def findWordsGreaterThanK(words: List[String], k: Int): List[String] = {
  words.filter(_.length > k)
}


// COMMAND ----------

findWordsGreaterThanK(List("banana","apple","mnbvcxz"),5)

// COMMAND ----------

// DBTITLE 1,Scala | Remove empty tuples from a list
def findempty(word: List[String]): List[String] = {
  word.filter(_.length != 0)
}


// COMMAND ----------

findempty(List("apple","","kgf","rabbit"))

// COMMAND ----------

// DBTITLE 1,Break a list into chunks of size N in Scala
def breakList(lst: List[Int], n: Int): List[List[Int]] = {
  if (n <= 0) List(lst)
  else lst.grouped(n).toList
}


// COMMAND ----------

breakList(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),5)

// COMMAND ----------

// DBTITLE 1,Scala Program to check Armstrong Number
def isArmstrong(n: Int): Boolean = {
  val str = n.toString
  val numDigits = n.toString.length
  var sum = 0
  for (i <- str) {
    sum += math.pow(i.asDigit, numDigits).toInt
  }
  return(n == sum)
}


// COMMAND ----------

isArmstrong(123)

// COMMAND ----------

// DBTITLE 1,Remove multiple elements from a list in Scala
def remove(progLang: List[String]) {
    
        println("Programming Languages: " + progLang)
        
        var newLang = progLang.filter(_<"S")
        
        println("Programming Languages: " + newLang)
       
    }

// COMMAND ----------

remove(List("C++", "Java", "Scala", "Python"))

// COMMAND ----------

// DBTITLE 1,Scala program to interchange first and last elements in a list
def inter(lst: List[Int]): List[Int] = {
  if (lst.isEmpty || lst.size == 1) lst // Return the original list if it's empty or contains only one element
  else (lst.last :: lst.tail.init ):+ lst.head// Swap the first and last elements and return the new list
}


// COMMAND ----------

inter(List(7,5,9,2))

// COMMAND ----------

// DBTITLE 1,Scala – Remove empty List from List
def clear(list: List[List[Int]]): List[List[Int]] = {
  val filtered = list.filterNot(_.isEmpty)
  filtered
}

val input = List(List(1, 2), List(), List(3), List(), List(4, 5))
val output = clear(input)
println(output)


// COMMAND ----------

// DBTITLE 1,Scala Program for array rotation
def rotateArray(arr: Array[Int], k: Int): Array[Int] = {
  val n = arr.length
  val shift = k % n
  arr.slice(shift, n) ++ arr.slice(0, shift)
}


// COMMAND ----------

rotateArray(Array(1,2,3,4,5),2)

// COMMAND ----------

// DBTITLE 1,Scala Program for Reversal algorithm for array rotation
def reverseArray(arr: Array[Int], start: Int, end: Int): Unit = {
  var i = start
  var j = end
  while (i < j) {
    val temp = arr(i)
    arr(i) = arr(j)
    arr(j) = temp
    i += 1
    j -= 1
  }
}

def rotateArray(arr: Array[Int], d: Int): Array[Int] = {
  val n = arr.length
  reverseArray(arr, 0, n-1)
  reverseArray(arr, 0, n-d-1)
  reverseArray(arr, n-d, n-1)
  arr
}


// COMMAND ----------

rotateArray(Array(1, 2, 3, 4, 5), 2)

// COMMAND ----------

// DBTITLE 1,Scala | Program to check if a string contains any special character
def containsSpecialChar(s: String): Boolean = {
  val pattern = "[^a-zA-Z0-9]".r
  pattern.findFirstMatchIn(s).isDefined
}


// COMMAND ----------

containsSpecialChar("m@st$r")

// COMMAND ----------

// DBTITLE 1,Scala Counter| Find all duplicate characters in string
def findDuplicates(str: String): Set[Char] = {
  str.foldLeft((Set[Char](), Set[Char]())) { case ((singles, duplicates), ch) =>
    if (singles.contains(ch)) (singles - ch, duplicates + ch)
    else (singles + ch, duplicates)
  }._2
}


// COMMAND ----------

findDuplicates("master is great")

// COMMAND ----------

// DBTITLE 1,Scala | Program to print duplicates from a list of integers
def findDuplicates(lst: List[Int]): List[Int] = {
  lst.groupBy(identity).collect { case (x, group) if group.length > 1 => x }.toList
}


// COMMAND ----------

findDuplicates(List(1,2,3,2,4,4,5))

// COMMAND ----------

// DBTITLE 1,Scala | Count occurrences of an element in a list
def countOccurrences(lst: List[Int], element: Int): Int = {
  lst.count(_ == element)
}


// COMMAND ----------

countOccurrences(List(1,2,3,4,4,4),4)

// COMMAND ----------

// DBTITLE 1,Scala – Words Frequency in String Shorthands
def wordFrequency(s: String): Map[String, Int] = {
  s.split("\\W+")
    .foldLeft(Map.empty[String, Int]) { (freq, word) =>
      freq + (word.toLowerCase -> (freq.getOrElse(word.toLowerCase, 0) + 1))
    }
}


// COMMAND ----------

wordFrequency("This is Mashir and this is")

// COMMAND ----------

// DBTITLE 1,Scala – Least Frequent Character in String
def leastFrequentChar(s: String): Option[Char] = {
  val charCounts = s.groupBy(identity).mapValues(_.length)
  if (charCounts.isEmpty) None else Some(charCounts.minBy(_._2)._1)
}


// COMMAND ----------

leastFrequentChar("This is this is the")

// COMMAND ----------

// DBTITLE 1,Scala | Maximum frequency character in String
def greatFrequentChar(s: String): Option[Char] = {
  val charCounts = s.groupBy(identity).mapValues(_.length)
  if (charCounts.isEmpty) None else Some(charCounts.maxBy(_._2)._1)
}


// COMMAND ----------

greatFrequentChar("This is this is the")

// COMMAND ----------

// DBTITLE 1,Scala | Count the Number of matching characters in a pair of string
def countMatchingChars(s1: String, s2: String): Int = {
  s1.intersect(s2).length
}


// COMMAND ----------

countMatchingChars("master","mashir")

// COMMAND ----------

// DBTITLE 1,Scala program to find uncommon words from two Strings
def uncommonWords(str1: String, str2: String): List[String] = {
  val words1 = str1.split("\\W+").map(_.toLowerCase).toSet
  val words2 = str2.split("\\W+").map(_.toLowerCase).toSet
  val uncommon = (words1 diff words2) ++ (words2 diff words1)
  uncommon.toList
}


// COMMAND ----------

uncommonWords("This is the Rabbit","Rabbit is the animal")

// COMMAND ----------

// DBTITLE 1,Scala – Replace duplicate Occurrence in String
def replaceDuplicate(str: String): String = {
  str.foldLeft("") { 
    case (result, char) if result.lastOption.contains(char) => result 
    case (result, char) => result + char 
  }
}


// COMMAND ----------

replaceDuplicate("aabbbccddeeee")

// COMMAND ----------

// DBTITLE 1,String slicing in Scala to rotate a string
def rotateString(s: String, n: Int): String = {
  val m = if (s.isEmpty) 0 else n % s.length
  s.slice(m, s.length) + s.slice(0, m)
}


// COMMAND ----------

rotateString("master is great",2)

// COMMAND ----------

// DBTITLE 1,String slicing in Scala to check if a string can become empty by recursive deletion
def canBecomeEmpty(s: String, substrings: List[String]): Boolean = {
  val pattern = substrings.mkString("|")
  pattern.r.replaceAllIn(s, "") == ""
}


// COMMAND ----------

canBecomeEmpty("master",List("master","steve","rogers","major"))

// COMMAND ----------

// DBTITLE 1,Execute a String of Code in Scala
import scala.reflect.runtime.universe._
import scala.tools.reflect.ToolBox

def executeCode(code: String): Any = {
  val tb = runtimeMirror(getClass.getClassLoader).mkToolBox()
  val tree = tb.parse(code)
  val compiledCode = tb.compile(tree)
  compiledCode()
}


// COMMAND ----------

executeCode("println(\"Hello\")")

// COMMAND ----------

// DBTITLE 1,Scala Program for n-th Fibonacci number
def fibonacci(n: Int): Int = {
  if (n <= 1) {
    n
  } else {
    fibonacci(n - 1) + fibonacci(n - 2)
  }
}


// COMMAND ----------

fibonacci(7)

// COMMAND ----------

// DBTITLE 1,Scala Program for How to check if a given number is Fibonacci number?
def isFibonacci(n: Int): Boolean = {
  var a = 0
  var b = 1
  while (b < n) {
    val temp = b
    b = a + b
    a = temp
  }
  b == n
}


// COMMAND ----------

isFibonacci(13)

// COMMAND ----------

def Multiple(n: Int, multiple: Int): Int = {
  var a = 0
  var b = 1
  var i = 0
  while (i < n) {
    val temp = b
    b = a + b
    a = temp
    if (b % multiple == 0) {
      i += 1
    }
  }
  a
}


// COMMAND ----------

Multiple(3,2)

// COMMAND ----------

// DBTITLE 1,Scala Program to check if given array is Monotonic
def isMonotonic(arr: Array[Int]): Boolean = {
  var isNonDecreasing = true
  var isNonIncreasing = true
  
  for (i <- 1 until arr.length) {
    if (arr(i) < arr(i - 1)) {
      isNonDecreasing = false
    }
    if (arr(i) > arr(i - 1)) {
      isNonIncreasing = false
    }
  }
  
  isNonDecreasing || isNonIncreasing
}


// COMMAND ----------

isMonotonic(Array(1,3,5,6,9))

// COMMAND ----------

// DBTITLE 1,Different ways to clear a list in Scala-
def emptyList(myList: List[Int]): List[Int] = {
  List.empty[Int]
}


// COMMAND ----------

emptyList(List(1,2,3,4))

// COMMAND ----------

def dropList(myList: List[Int]): List[Int] = {
myList.drop(myList.length) 
}

// COMMAND ----------

dropList(List(1,2,3,4))

// COMMAND ----------

def filterList(myList: List[Int]): List[Int] = {
myList.filter(_ => false) 
}

// COMMAND ----------

filterList(List(2,4,5,6))

// COMMAND ----------

def takeList(myList: List[Int]): List[Int] = {
myList.take(0) 
}

// COMMAND ----------

takeList(List(2,4,5,6))

// COMMAND ----------

// DBTITLE 1,Generating random strings until a given string is generated
import scala.util.Random

def generateRandomString(targetString: String, maxLength: Int): String = {
  val charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
  val targetLength = targetString.length
  var generatedString = ""
  while (generatedString != targetString) {
    generatedString = Random.alphanumeric.take(maxLength).filter(_.isLetterOrDigit).mkString
    if (generatedString.length > targetLength) {
      generatedString = generatedString.take(targetLength)
    }
  }
  generatedString
}


// COMMAND ----------

val targetString = "hello"
val maxLength = 10
val generatedString = generateRandomString(targetString, maxLength)
println(generatedString)


// COMMAND ----------

// DBTITLE 1,Scala | Sort the values of first list using second list
def sortListUsingAnotherList(list1: List[Int], list2: List[Int]): List[Int] = {
  val map2 = list2.zipWithIndex.toMap
  list1.sortBy(map2.getOrElse(_, Int.MaxValue))
}


// COMMAND ----------

// DBTITLE 1,Scala program to swap two elements in a list
def swapElements(list: List[Int], index1: Int, index2: Int): List[Int] = {
  val element1 = list(index1)
  val element2 = list(index2)
  list.updated(index1, element2).updated(index2, element1)
}


// COMMAND ----------

swapElements(List(1,2,3,4,5),1,3)
