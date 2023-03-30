// Databricks notebook source
// DBTITLE 1,Char at position 0,10,15 and string length
def output(str: String): Unit = {
  println(s"The character at position 0 is:"+str.charAt(0))
  println(s"The character at position 10 is: "+str.charAt(10))
    println(s"The character at position 15 is: "+str.charAt(15))
  println("Length of the string:"+ str.length)
 
}


// COMMAND ----------

output("Scala Exercises!")

// COMMAND ----------

// DBTITLE 1,Concat of two strings
def concat(str1:String,str2:String):String={
  val add = str1.concat(str2)
  add
}

// COMMAND ----------

concat("Scala Exercises and ","Python Exercises")

// COMMAND ----------

// DBTITLE 1,String in lowercase and uppercase
def cases(str:String)={
  println("Original String:"+str)
println("String in lowercase:"+str.toLowerCase)
  println("String in uppercase:"+str.toUpperCase)
}

// COMMAND ----------

cases("The Quick BroWn FoX!")

// COMMAND ----------

// DBTITLE 1,Reverse every string in sentence
def reverseWords(input: String): String = {
  val words = input.split(" ")
  val reversedWords = words.map(_.reverse)
  reversedWords.mkString(" ")
}


// COMMAND ----------

reverseWords("This is a test string")

// COMMAND ----------

// DBTITLE 1,Rotations of two strings
def combine(str1:String,str2:String)={
  println("The given strings are:"+str1+" and "+str2)
  println("The concatination of 1st string twice is:"+str1.concat(str1))
if(str1.concat(str1).contains(str2)==true){
  println("The 2nd string CDABA  exists in the new string.")
  println("Strings are rotations of each other")
}
else{
  println("Strings are not rotations of each other")
}
}

// COMMAND ----------

combine("ABACD","CDABA")

// COMMAND ----------

// DBTITLE 1,swap last two characters
def given(str:String)={
  println("The given strings is: "+str)
  val swoto = str.substring(0,str.length-2)
  println("The string after swap last two characters are:"+swoto+str.charAt(str.length-1)+str.charAt(str.length-2))
}


// COMMAND ----------

given("string")

// COMMAND ----------

// DBTITLE 1,Substring by index
def specify(str:String,n:Int)={
  println("The given strings is: "+str)
  println("The given numbers is: "+n)
  println("The new string is: "+str.substring(0,n)+str.substring(str.length-4,str.length))
}

// COMMAND ----------

specify("welcome",3)
specify("Scala Programming",4)

// COMMAND ----------

// DBTITLE 1,Concat and repeat n times the both strings
def times(str1: String, str2: String, n: Int) = {
  println("The given strings are: " + str1 + " and " + str2)
  println("Number of times to be repeated: " + n)
  println("The new string is: " + str1.concat(str2) * n)
}


// COMMAND ----------

times("try","best",3)

// COMMAND ----------

// DBTITLE 1,repeat every char in string
def doubleChars(str: String): String = {
  str.flatMap(c => s"$c$c")
}


// COMMAND ----------

doubleChars("welcome")

// COMMAND ----------

// DBTITLE 1,three times of sum of items
def sum(a:Int,b:Int):Int={
  var add:Int=0
  if(a==b){
    add=3*(a+b)
  }
  else{
   add=a+b
  }
  add
}

// COMMAND ----------

sum(3,3)

// COMMAND ----------

// DBTITLE 1,Triple of item minus 51
def triple(n:Int):Int={
  var add:Int=0
  if(n>51){
    add=3*(n-51)
  }else{
    add=math.abs(n-51)
  }
  add
  
}

// COMMAND ----------

triple(32)

// COMMAND ----------

// DBTITLE 1,Check sum is 30 or one of element is 30
def check(a:Int,b:Int):Boolean={
  if(a==30||b==30){
    return true
  } else if((a+b)==30){
    return true
  }
  else false
}

// COMMAND ----------

check(15,16)

// COMMAND ----------

// DBTITLE 1,Check number by 100 and 300
def checkNumber(n: Int): Boolean = {
  val diffFrom100 = math.abs(n - 100)
  val diffFrom300 = math.abs(n - 300)
  if(diffFrom100 <= 20 || diffFrom300 <= 20){
    return true
  }else false
}


// COMMAND ----------

// DBTITLE 1,Add if to string
def addIfToString(s: String): String = {
  if (s.startsWith("if")) {
    s 
  } else {
    "if" + s 
  }
}


// COMMAND ----------

addIfToString("ifmaster")

// COMMAND ----------

// DBTITLE 1,Remove char at index
def removeCharAt(s: String, pos: Int): String = {
  if (pos < 0 || pos >= s.length) {
    s 
  } else {
    s.substring(0, pos) + s.substring(pos + 1)
  }
}


// COMMAND ----------

removeCharAt("master",2)

// COMMAND ----------

// DBTITLE 1,exchnage the first and last char of String
def exchange(s:String):String={
  var ex = s(s.length-1)+s.substring(1,s.length-1)+s(0)
ex
}

// COMMAND ----------

exchange("mashir")

// COMMAND ----------

// DBTITLE 1,Copy front element four times
def copyFront(str: String): String = {
  if (str.length < 2) {
    str
  } else {
    val front = str.substring(0, 2)
    front * 4
  }
}


// COMMAND ----------

copyFront("master")

// COMMAND ----------

// DBTITLE 1,Add last element to first and last to the string
def addLastChar(str: String): String = {
  if (str.length < 1) {
    str 
  } else {
    val lastChar = str.charAt(str.length - 1)
    lastChar + str + lastChar 
  }
}


// COMMAND ----------

addLastChar("ready")

// COMMAND ----------

// DBTITLE 1,Multiple of 3 or 7
def multiple(a:Int):Boolean={
  if(a%3==0||a%7==0){
    return true
  }
  else false
}

// COMMAND ----------

// DBTITLE 1,repeat First Three
def repeatFirstThree(str: String): String = {
  val firstThree = str.substring(0,3)
  firstThree + firstThree + firstThree 
}


// COMMAND ----------

repeatFirstThree("master")

// COMMAND ----------

// DBTITLE 1,String starts with Sc
def check(str: String): Boolean = {
  if (str.startsWith("Sc")) {
    true
  } else {
    false
  }
}


// COMMAND ----------

// DBTITLE 1,check Temperatures from 0 to 100
def checkTemperatures(temp1: Int, temp2: Int): Boolean = {
  (temp1 < 0 && temp2 > 100) || (temp1 > 100 && temp2 < 0)
}


// COMMAND ----------

// DBTITLE 1,Check range from 100 to 200
def checkRange(num1: Int, num2: Int): Boolean = {
  (num1 >= 100 && num1 <= 200) || (num2 >= 100 && num2 <= 200)
}


// COMMAND ----------

// DBTITLE 1,Check range from 20 to 50
def checkRange(num1: Int, num2: Int, num3: Int): Boolean = {
  (num1 >= 20 && num1 <= 50) || (num2 >= 20 && num2 <= 50) || (num3 >= 20 && num3 <= 50)
}


// COMMAND ----------

// DBTITLE 1,Check range from 20 to 50
def checkRange(num1: Int, num2: Int): Boolean = {
  (num1 >= 20 && num1 <= 50) || (num2 >= 20 && num2 <= 50)
}


// COMMAND ----------

// DBTITLE 1,Remove yt from the string
def checkString(str: String): String = {
  if (str.length() >= 2 && str.substring(1, 3) == "yt") {
    return str.substring(0, 1) + str.substring(3)
  } else {
    return str
  }
}


// COMMAND ----------

checkString("yytade")

// COMMAND ----------

// DBTITLE 1,Largest of three numbers
def findLargest(num1: Int, num2: Int, num3: Int): Int = {
  if (num1 >= num2 && num1 >= num3) {
    return num1
  } else if (num2 >= num1 && num2 >= num3) {
    return num2
  } else {
    return num3
  }
}


// COMMAND ----------

// DBTITLE 1,find Nearest To 100
def findNearestTo100(num1: Int, num2: Int): Int = {
  val dist1 = Math.abs(num1 - 100)
  val dist2 = Math.abs(num2 - 100)
  if (dist1 < dist2) {
    return num1
  } else if (dist2 < dist1) {
    return num2
  } else {
    return 0
  }
}


// COMMAND ----------

// DBTITLE 1,Find Larger In Range between 40 to 50 and 50 to 60
def checkRanges(num1: Int, num2: Int): Boolean = {
  val inRange1 = num1 >= 40 && num1 <= 50 && num2 >= 40 && num2 <= 50
  val inRange2 = num1 >= 50 && num1 <= 60 && num2 >= 50 && num2 <= 60
  return inRange1 || inRange2
}


// COMMAND ----------

// DBTITLE 1,Find Larger In Range between 20 to 30
def findLargerInRange(num1: Int, num2: Int): Int = {
  if ((num1 >= 20 && num1 <= 30) && (num2 >= 20 && num2 <= 30)) {
    return Math.max(num1, num2)
  } else {
    return 0
  }
}


// COMMAND ----------

// DBTITLE 1,check Character Count with 2 to 4
def checkCharacterCount(str: String, ch: String): String = {
  if (ch.isEmpty) {
    str
  } else {
    val count = str.count(_ == ch.charAt(0))
    if (count >= 2 && count <= 4) {
      "true"
    } else {
      "false"
    }
  }
}


// COMMAND ----------

checkCharacterCount("mmmajd","m")

// COMMAND ----------

// DBTITLE 1,check Last Digit
def checkLastDigit(num1: Int, num2: Int): Boolean = {
  return (num1 % 10) == (num2 % 10)
}


// COMMAND ----------

// DBTITLE 1,Convert last Four To Upper
def convertLastFourToUpper(str: String): String = {
  if (str.length() < 4) {
    return str.toUpperCase()
  } else {
    val lastFour = str.substring(str.length() - 4)
    return str.substring(0, str.length() - 4) + lastFour.toUpperCase()
  }
}


// COMMAND ----------

// DBTITLE 1,Copy string n times
def copyString(str: String, n: Int): String = {
  var result = ""
  for (i <- 1 to n) {
    result += str
  }
  return result
}


// COMMAND ----------

copyString("masr",4)

// COMMAND ----------

// DBTITLE 1,Unicode of string at index
def getCharCodePoint(str: String, index: Int): Int = {
  return str.codePointAt(index)
}


// COMMAND ----------

getCharCodePoint("master",2)

// COMMAND ----------

// DBTITLE 1,compare Strings
def compareStrings(str1: String, str2: String): Int = {
  return str1.compareTo(str2)
}


// COMMAND ----------

// DBTITLE 1,contains Sequence
def containsSequence(str: String, seq: String): Boolean = {
  str.contains(seq)
}


// COMMAND ----------

containsSequence("master","m")

// COMMAND ----------

// DBTITLE 1,String from array of character
def createString(charArray: Array[Char]): String = {
  return new String(charArray)
}

// COMMAND ----------

createString(Array('h','e','l','l','o'))

// COMMAND ----------

// DBTITLE 1,Ends with suffix
def endsWith(str: String, suffix: String): Boolean = {
  return str.endsWith(suffix)
}


// COMMAND ----------

endsWith("maskhan","khan")

// COMMAND ----------

// DBTITLE 1,Equal Strings
def isSame(str1: String, str2: String): Boolean = {
  if(str1 == str2) true else false
}

// COMMAND ----------

// DBTITLE 1,compare Strings in Ignore Case
def compareStringsIgnoreCase(str1: String, str2: String): Boolean = {
  str1.toLowerCase() == str2.toLowerCase()
}

// COMMAND ----------

// DBTITLE 1,Replace old char with new char
def replaceChar(str: String, oldChar: Char, newChar: Char): String = {
  str.map(c => if (c == oldChar) newChar else c)
}


// COMMAND ----------

replaceChar("master",'m','d')

// COMMAND ----------

// DBTITLE 1,Substring of string
def getSubstring(str: String, start: Int, end: Int): String = {
  str.substring(start, end)
}


// COMMAND ----------

// DBTITLE 1,Trim the string
def trimWhitespace(str: String): String = {
  return str.trim()
}

// COMMAND ----------

// DBTITLE 1,Remove duplicates from string
def removeDuplicates(str: String): String = {
  var result=""
  for (ch <- str) {
    if (!result.contains(ch)) {
      result += ch
    }
  }
  result
}


// COMMAND ----------

removeDuplicates("mmasttter")

// COMMAND ----------

// DBTITLE 1,Max occuring character
def maxOccurringChar(str: String): Char = {
  val charCount = scala.collection.mutable.Map[Char, Int]()
  
  // count the occurrences of each character
  for (c <- str) {
    if (charCount.contains(c)) {
      charCount(c) += 1
    } else {
      charCount(c) = 1
    }
  }
  
  // find the character with the maximum count
  charCount.maxBy(_._2)._1
}


// COMMAND ----------

// DBTITLE 1,Reverse the string in sentence
def reverseWords(str: String): String = {
  str.split(" ").map(_.reverse).mkString(" ")
}


// COMMAND ----------

// DBTITLE 1,Count duplicates from the string
def countDuplicates(inputString: String): Unit = {
  val chars = inputString.toCharArray
  val occurredChars = scala.collection.mutable.Set[Char]()
  val duplicateChars = scala.collection.mutable.Set[Char]()
  for (char <- chars) {
    if (occurredChars.contains(char)) {
      duplicateChars.add(char)
    } else {
      occurredChars.add(char)
    }
  }
  println("Duplicates: " + duplicateChars.mkString(", "))
}


// COMMAND ----------

// DBTITLE 1,Append and Omit the strings
def appendAndOmit(str1: String, str2: String): String = {
  if (str1.last == str2.head) str1 + str2.tail
  else str1 + str2
}

// COMMAND ----------

// DBTITLE 1,Ends with specified suffix
def endsWithSpecified(str: String, suffix: String): Boolean = {
  if (str.length < 2 || suffix.length != 2) {
    false
  } else {
    str.takeRight(2) == suffix
  }
}


// COMMAND ----------

// DBTITLE 1,Append Strings
def appendStrings(s1: String, s2: String): String = {
  val len1 = s1.length()
  val len2 = s2.length()
  if (len1 > len2) {
    s1.substring(len1 - len2) + s2
  } else if (len2 > len1) {
    s1 + s2.substring(len2 - len1)
  } else {
    s1 + s2
  }
}


// COMMAND ----------

// DBTITLE 1,create New String
def createNewString(str: String, n: Int): String = {
  val length = str.length()
  if (n >= length / 2) {
    str
  } else {
    val first = str.substring(0, n)
    val last = str.substring(length - n, length)
    first + last
  }
}


// COMMAND ----------

// DBTITLE 1,check Ends With First Two
def checkEndsWithFirstTwo(str: String): Boolean = {
  val len = str.length()
  if (len < 2) {
    false
  } else {
    str.substring(len - 2) == str.substring(0, 2)
  }
}


// COMMAND ----------

// DBTITLE 1,remove First And Last Char If Same
def removeFirstAndLastCharIfSame(str: String): String = {
  if (str.length() < 2) str
  else if (str.charAt(0) == str.charAt(str.length() - 1)) str.substring(1, str.length() - 1)
  else str
}

// COMMAND ----------

// DBTITLE 1,Replace g and h with empty 
def removeFirstTwo(str: String): String = {
  if (str.length < 2) {
    return str
  }
  
  val firstChar = str.charAt(0)
  val secondChar = str.charAt(1)
  
  if (firstChar == 'g' && secondChar == 'h') {
    return str.substring(0, 1) + str.substring(2)
  } else if (firstChar == 'g') {
    return str.substring(0, 1) + str.substring(2)
  } else if (secondChar == 'h') {
    return str.substring(1)
  } else {
    return str.substring(2)
  }
}


// COMMAND ----------

// DBTITLE 1,Remove character from string
def removeChars(str: String, ch: Char): String = {
  if (str.length >= 2 && (str.charAt(0) == ch || str.charAt(1) == ch)) {
    if (str.charAt(0) == ch && str.charAt(1) == ch) {
      str.substring(2)
    } else if (str.charAt(0) == ch) {
      str.substring(1)
    } else {
      str.charAt(0) + str.substring(2)
    }
  } else {
    str
  }
}

// COMMAND ----------

// DBTITLE 1,remove Adjacent Chars
def removeAdjacentChars(s: String, c: Char): String = {
  s.replaceAll(s"(.)?$c(.)?", "")
}


// COMMAND ----------

removeAdjacentChars("master",'t')

// COMMAND ----------

// DBTITLE 1,ends With Ignore Case
def endsWithIgnoreCase(s1: String, s2: String): Boolean = {
  val len1 = s1.length
  val len2 = s2.length
  
  if (len1 < len2) {
    return s2.toLowerCase.endsWith(s1.toLowerCase)
  } else {
    return s1.toLowerCase.endsWith(s2.toLowerCase)
  }
}



// COMMAND ----------

// DBTITLE 1,check Substring Before Period
def checkSubstringBeforePeriod(str: String, substr: String): Boolean = {
  val index = str.indexOf('.')
  if (index == -1) false // period not found
  else {
    val substringBeforePeriod = str.substring(0, index)
    substringBeforePeriod.contains(substr)
  }
}


// COMMAND ----------

// DBTITLE 1,Prefix appears
def prefixAppears(s: String, n: Int): Boolean = {
  val prefix = s.take(n)
  val rest = s.drop(n)
  rest.contains(prefix)
}


// COMMAND ----------

// DBTITLE 1,is Substring In Middle
def isSubstringInMiddle(mainString: String, subString: String): Boolean = {
  val mainLength = mainString.length
  val subLength = subString.length
  if (mainLength < subLength + 2) return false // Not enough room for substring in middle
  val middleIndex = mainLength / 2
  if (mainLength % 2 == 0) { // Even length string
    if (mainString.substring(middleIndex - 1, middleIndex + subLength - 1) == subString) return true
  } else { // Odd length string
    if (mainString.substring(middleIndex - 1, middleIndex + subLength - 1) == subString) return true
    if (mainString.substring(middleIndex, middleIndex + subLength) == subString) return true
  }
  false
}


// COMMAND ----------

// DBTITLE 1,count Substrings
def countSubstrings(inputString: String): Int = {
  val regex = "li.e".r
  regex.findAllMatchIn(inputString).length
}


// COMMAND ----------

countSubstrings("li.e")

// COMMAND ----------

// DBTITLE 1,remove Second Char From Z to G
def removeSecondCharFromZtoG(s: String): String = {
  val result = new StringBuilder()
  var i = 0
  while (i < s.length) {
    if (i <= s.length - 3 && s(i) == 'z' && s(i + 2) == 'g') {
      result.append(s(i))
      result.append(s(i + 1))
      i += 2
    } else {
      result.append(s(i))
    }
    i += 1
  }
  result.toString()
}


// COMMAND ----------

// DBTITLE 1,check Before After
def checkBeforeAfter(string: String, ch: Char): Boolean = {
  val index = string.indexOf(ch)
  if (index < 1 || index == string.length - 1) false
  else string(index - 1) == string(index + 1)
}


// COMMAND ----------

// DBTITLE 1,check occurences of string
def checkOccurrences(str: String, sub1: String, sub2: String): Boolean = {
  val count1 = str.sliding(3).count(_ == sub1) // count occurrences of sub1
  val count2 = str.sliding(4).count(_ == sub2) // count occurrences of sub2
  count1 == count2 // check if the counts are equal
}


// COMMAND ----------

// DBTITLE 1,merge string
def mergeStrings(str1: String, str2: String): String = {
  var result = ""
  val maxLength = if (str1.length > str2.length) str1.length else str2.length
  for (i <- 0 until maxLength) {
    if (i < str1.length) result += str1.charAt(i)
    if (i < str2.length) result += str2.charAt(i)
  }
  result
}


// COMMAND ----------

// DBTITLE 1,string using yield
def stringPattern(str: String): String = {
  val n = str.length
  (for (i <- n to 1 by -1) yield str.substring(0, i)).mkString("")
}


// COMMAND ----------

// DBTITLE 1,remove string with new string
def newString(str: String): String = {
  if (str.length < 3) return str
  
  val sb = new StringBuilder()
  
  for (i <- 1 until str.length - 1) {
    if (str(i) != str(i - 1) && str(i) != str(i + 1)) {
      sb.append(str(i - 1))
      sb.append(str(i + 1))
    }
  }
  
  sb.toString()
}

// Example usage
println(newString("abcabcabc")) // Output: bcbcbc
println(newString("xyaabcdefgabcz")) // Output: xybefgz


// COMMAND ----------

// DBTITLE 1,Count Triples
def countTriples(str: String): Int = {
  var count = 0
  for (i <- 0 until str.length - 2) {
    if (str(i) == str(i+1) && str(i) == str(i+2)) {
      count += 1
    }
  }
  count
}


// COMMAND ----------

// DBTITLE 1,Happy
def isHappy(ch: Char, str: String): Boolean = {
  for (i <- 1 until str.length - 1) {
    if (str(i) == ch && (str(i - 1) == ch || str(i + 1) == ch)) {
      return true
    }
  }
  false
}


// COMMAND ----------

// DBTITLE 1,sum of integer in string
def sumOfNumbers(str: String): Int = {
  val numberRegex = """\d+""".r
  var sum = 0
  for (number <- numberRegex.findAllIn(str)) {
    sum += number.toInt
  }
  sum
}


// COMMAND ----------

// DBTITLE 1,count Substring Appearances
def countSubstringAppearances(str: String, substr1: String, substr2: String): Int = {
  val regex = (substr1 + "|" + substr2).r
  regex.findAllMatchIn(str).length
}


// COMMAND ----------

def sumArray(arr: Array[Int]): Int = {
  var sum = arr.reduce(_+_)
  sum
}


// COMMAND ----------

def isFirstOrLast(arr: Array[Int], num: Int): Boolean = {
  arr.head == num || arr.last == num
}


// COMMAND ----------

def average(arr: Array[Double]): Double = {
  var sum = arr.reduce(_+_)
  sum / arr.length
}


// COMMAND ----------

def isFirstAndLastEqual(arr: Array[Int]): Boolean = {
  arr.head == arr.last
}


// COMMAND ----------

def findIndex(arr: Array[Int], num: Int): Int = {
  for (i <- arr.indices) {
    if (arr(i) == num) {
      return i
    }
  }
  -1 // if num not found
}


// COMMAND ----------

def areFirstAndLastEqual(arr1: Array[Int], arr2: Array[Int]): Boolean = {
  arr1.head == arr2.head || arr1.last == arr2.last
}


// COMMAND ----------

// DBTITLE 1,remove element from array
def removeElement(arr: Array[Int], num: Int): Array[Int] = {
  arr.filter(_ != num)
}


// COMMAND ----------

removeElement(Array(1,2,3,4,5,6),4)

// COMMAND ----------

def rotateLeft(arr: Array[Int]): Array[Int] = {
  val first = arr.head
  arr.tail :+ first
}


// COMMAND ----------

def findMaxAndMin(arr: Array[Int]): (Int, Int) = {
  (arr.max, arr.min)
}


// COMMAND ----------

// DBTITLE 1,sum last three of array
def sumLastThree(arr: Array[Int]): Int = {
  if (arr.isEmpty) {
    0
  } else if (arr.length < 3) {
    sumArray(arr)
  } else {
    arr.slice(arr.length - 3, arr.length).sum
  }
}


// COMMAND ----------

// DBTITLE 1,new array
def createNewArray(arr1: Array[Int], arr2: Array[Int], arr3: Array[Int]): Array[Int] = {
  Array(arr1(2), arr2(2), arr3(2))
}


// COMMAND ----------

def reverseArray(arr: Array[Int]): Array[Int] = {
  arr.reverse
}


// COMMAND ----------

// DBTITLE 1,check number
def checkNumbers(arr: Array[Int]): Boolean = {
  arr.contains(4) || arr.contains(7)
}


// COMMAND ----------

// DBTITLE 1,find max value
def findMaxValue(arr: Array[Int]): Int = {
  val first = arr(0)
  val middle = arr(arr.length/2)
  val last = arr(arr.length-1)
  
  List(first, middle, last).max
}


// COMMAND ----------

// DBTITLE 1,common elements
def findCommonElements(arr1: Array[Int], arr2: Array[Int]): Array[Int] = {
  arr1.intersect(arr2)
}


// COMMAND ----------

// DBTITLE 1,intersection of arrays
def findCommonElements(arr1: Array[String], arr2: Array[String]): Array[String] = {
  arr1.intersect(arr2)
}


// COMMAND ----------

def removeDuplicates(arr: Array[String]): Array[String] = {
  arr.distinct
}


// COMMAND ----------

def removeDuplicates(arr: Array[Int]): Array[Int] = {
  arr.distinct
}


// COMMAND ----------

// DBTITLE 1,find Second Largest
def findSecondLargest(arr: Array[Int]): Int = {
  arr.distinct.sorted.reverse(1)
}


// COMMAND ----------

// DBTITLE 1,find second smallest
def findSecondSmallest(arr: Array[Int]): Option[Int] = {
  val distinctArr = arr.distinct
  if (distinctArr.length < 2) {
    None
  } else {
    Some(distinctArr.sorted(Ordering[Int]).apply(1))
  }
}


// COMMAND ----------

// DBTITLE 1,remove duplicates
def removeDuplicates(arr: Array[String]): Array[String] = {
  var uniqueSet = Set[String]()
  for (elem <- arr) {
    uniqueSet += elem
  }
  uniqueSet.toArray
}


// COMMAND ----------

// DBTITLE 1,remove duplicates
def removeDuplicates(arr: Array[Int]): Array[Int] = {
  var uniqueSet = Set[Int]()
  for (elem <- arr) {
    uniqueSet += elem
  }
  uniqueSet.toArray
}


// COMMAND ----------

removeDuplicates(Array(1,2,3,3,4,5,5))

// COMMAND ----------

// DBTITLE 1,test equality
def testEquality(arr1: Array[Int], arr2: Array[Int]): Boolean = {
  if (arr1.length != arr2.length) false
  else {
    var result = true
    for (i <- arr1.indices) {
      if (arr1(i) != arr2(i)) {
        result = false
      }
    }
    result
  }
}


// COMMAND ----------

// DBTITLE 1,find missing numbers
def findMissingNumber(arr: Array[Int]): Int = {
  val sum = (arr.length + 1) * (arr.length + 2) / 2
  val arrSum = arr.sum
  sum - arrSum
}


// COMMAND ----------

// DBTITLE 1,count even and odd
def countEvenOdd(arr: Array[Int]): (Int, Int) = {
  var evenCount = 0
  var oddCount = 0
  for (i <- arr.indices) {
    if (arr(i) % 2 == 0) evenCount += 1
    else oddCount += 1
  }
  (evenCount, oddCount)
}


// COMMAND ----------

def difference(arr: Array[Int]): Int = {
  val min = arr.min
  val max = arr.max
  max - min
}


// COMMAND ----------

// DBTITLE 1,average
def average(arr: Array[Int]): Double = {
  val min = arr.min
  val max = arr.max
  val sum = arr.sum - min - max
  val n = arr.length - 2
  sum.toDouble / n
}


// COMMAND ----------

// DBTITLE 1,remove duplicates
def removeDuplicates(arr: Array[Int]): Int = {
  if (arr.length == 0) return 0
  var i = 0
  for (j <- 1 until arr.length) {
    if (arr(j) != arr(i)) {
      i += 1
      arr(i) = arr(j)
    }
  }
  i + 1
}


// COMMAND ----------

// DBTITLE 1,smallest in srray
def findSmallest(arr: Array[Int]): (Int, Int) = {
  var smallest = Int.MaxValue
  var secondSmallest = Int.MaxValue
  for (i <- arr.indices) {
    if (arr(i) < smallest) {
      secondSmallest = smallest
      smallest = arr(i)
    }
    else if (arr(i) < secondSmallest && arr(i) != smallest) {
      secondSmallest = arr(i)
    }
  }
  (smallest, secondSmallest)
}


// COMMAND ----------

// DBTITLE 1,segregate the array
def segregate(arr: Array[Int]): Array[Int] = {
  var i = 0
  var j = arr.length - 1
  while (i < j) {
    while (arr(i) == 0 && i < j) {
      i += 1
    }
    while (arr(j) == 1 && i < j) {
      j -= 1
    }
    if (i < j) {
      arr(i) = 0
      arr(j) = 1
      i += 1
      j -= 1
    }
  }
  arr
}


// COMMAND ----------

// DBTITLE 1,count traingle
def countTriangle(arr: Array[Int]): Int = {
  val n = arr.length
  var count = 0
  for (i <- 0 until n-2) {
   var k = i+2
   for (j <- i+1 until n-1) {
    while (k < n && arr(i) + arr(j) > arr(k))
     k += 1
    count += k-j-1
   }
  }
  count
 }

// COMMAND ----------

// DBTITLE 1,seperate even and odd
def separateEvenOdd(nums: Array[Int]): Array[Int] = {
  val evenNums = nums.filter(_ % 2 == 0)
  val oddNums = nums.filter(_ % 2 != 0)
  evenNums ++ oddNums
}


// COMMAND ----------

// DBTITLE 1,Next greatest
def nextGreatest(nums: Array[Int]): Array[Int] = {
  val len = nums.length
  val res = new Array[Int](len)
  var max = -1
  for (i <- len - 1 to 0 by -1) {
    res(i) = max
    max = max.max(nums(i))
  }
  res
}


// COMMAND ----------

// DBTITLE 1,find pairs
def findPairs(nums: Array[Int], target: Int): Array[(Int, Int)] = {
  val set = nums.toSet
  nums.flatMap(x => set.find(y => y == target - x).map(y => (x, y)))
}


// COMMAND ----------

// DBTITLE 1,Max product
def maxProduct(nums: Array[Int]): (Int, Int, Int) = {
  nums.combinations(2).map { case Array(a, b) => (a, b, a * b) }.maxBy(_._3)
}


// COMMAND ----------

// DBTITLE 1,Rearrange the array
def rearrange(nums: Array[Int]): Array[Int] = {
  val sorted = nums.sorted
  val res = new Array[Int](nums.length)
  for (i <- nums.indices by 2) {
    res(i) = sorted(i / 2)
  }
  for (i <- nums.indices.reverse by 2) {
    res(i) = sorted((nums.length + i) / 2)
  }
  res
}


// COMMAND ----------

// DBTITLE 1,max difference
def maxDifference(nums: Array[Int]): Int = {
  var maxDiff = Int.MinValue
  var minVal = nums(0)
  for (i <- 1 until nums.length) {
    maxDiff = math.max(maxDiff, nums(i) - minVal)
    minVal = math.min(minVal, nums(i))
  }
  return maxDiff
}


// COMMAND ----------

// DBTITLE 1,max subarray sum
def maxSubarraySum(nums: Array[Int]): Int = {
  var maxSoFar = nums(0)
  var maxEndingHere = nums(0)
  for (i <- 1 until nums.length) {
    maxEndingHere = math.max(maxEndingHere + nums(i), nums(i))
    maxSoFar = math.max(maxSoFar, maxEndingHere)
  }
  return maxSoFar
}


// COMMAND ----------

// DBTITLE 1,Min subarray sum
def minSubarraySum(nums: Array[Int], k: Int): Int = {
  var minSum = Int.MaxValue
  var currSum = 0
  for (i <- 0 until nums.length) {
    currSum += nums(i)
    if (i >= k-1) {
      minSum = math.min(minSum, currSum)
      currSum -= nums(i-k+1)
    }
  }
  return minSum
}


// COMMAND ----------

val list6 = List.tabulate(5)(_ + 1)

// Lisp style
val list1 = List(1, 2, 3, 4, 5)
println(list1)

// Java style
val list2 = ListBuffer[Int]()
list2 += 1
list2 += 2
list2 += 3
list2 += 4
list2 += 5
println(list2.toList)

// Range list
val list3 = ListBuffer(1, 2, 3, 4, 5)
println(list3)

// Uniform list
val list4 = List.fill(5)("Hello")
println(list4)

// Tabulate list
val list5 = List.tabulate(5)(_ + 1)
println(list5)


// COMMAND ----------

// DBTITLE 1,adding element to list
import scala.collection.mutable.ListBuffer

def addElementsToList[Int](list: ListBuffer[Int], element: Int*): Unit = {
  list ++= element
}

def addElementsToList[Int](list: List[Int], element: Int*): List[Int] = {
  list ++ element
}



// COMMAND ----------

import scala.collection.mutable.ListBuffer

def removeElementsFromList(list: ListBuffer[Int], elements: Int*): Unit = {
  for (element <- elements) {
    list -= element
  }
}

def removeElementsFromList(list: List[Int], elements: Int*): List[Int] = {
  list.filterNot(elements.contains)
}


// COMMAND ----------

// DBTITLE 1,delete elements from list
def deleteElementsFromList[Int](list: List[Int], elements: Int*): List[Int] = {
  list diff elements
}

// COMMAND ----------

def iterateList(list: List[Int]): (Int, Int) = {
var sum =list.reduce(_+_)
  var product =list.reduce(_*_)
  (sum, product)
}

// COMMAND ----------

def findMinMax(list: List[Int]): (Int, Int) = {
  (list.min, list.max)
}

// COMMAND ----------

// DBTITLE 1,remove duplicates
def removeDuplicates(list: List[Int]): List[Int] = {
  list.foldLeft(List.empty[Int]) { (uniqueList, elem) =>
    if (uniqueList.contains(elem)) uniqueList
    else elem :: uniqueList
  }.reverse
}



// COMMAND ----------

// DBTITLE 1,Empty list
def isEmpty(list: List[Int]): Boolean = list match {
  case Nil => true
  case _ => false
}


// COMMAND ----------

// DBTITLE 1,list difference
def listDifference[A](list1: List[A], list2: List[A]): List[A] = {
  list1.filterNot(list2.contains)
}

val list1 = List(1, 2, 3, 4, 5)
val list2 = List(3, 4, 5, 6, 7)

println(listDifference(list1, list2)) // Output: List(1, 2)


// COMMAND ----------

def firstAndLast(list: List[Int]): (Int, Int) = {
  (list.head, list.last)
}

// COMMAND ----------

// DBTITLE 1,Add n times
import scala.collection.mutable.ListBuffer

  def addNTimes(lst: List[Int], n: Int): List[Int] = {
    val result = ListBuffer[Int]()
    for (num <- lst) {
      for (i <- 1 to n) {
        result += num
      }
    }
    result.toList
  }

// COMMAND ----------

def evenOddList(list: List[Int]): (List[Int], List[Int]) = {
  val evenList = list.filter(_ % 2 == 0)
  val oddList = list.filter(_ % 2 != 0)
  (evenList, oddList)
}


// COMMAND ----------

// DBTITLE 1,Find nth element
def findNthElement(list: List[Int], n: Int): Int = {
  if (n >= 0 && n < list.length) {
    list(n)
  } else {
    throw new IndexOutOfBoundsException("Index out of range")
  }
}

// COMMAND ----------

def findLastElement(list: List[Int]): Int = {
  list.last
}


// COMMAND ----------

// DBTITLE 1,reverse the list
def reverseList(list: List[Int]): List[Int] = {
  list.reverse
}


// COMMAND ----------

// DBTITLE 1,palindrome list
def isPalindrome(list: List[Int]): Boolean = {
  list == list.reverse
}

// COMMAND ----------

// DBTITLE 1,flatten list
def flattenList(list: List[List[Int]]): List[Int] = {
  list.flatten
}

// COMMAND ----------

// DBTITLE 1,triplicate Adjacent Elements
def triplicateAdjacentElements(list: List[Int]): List[Int] = {
  if(list.size < 2) list
  else {
    list.head :: List.fill(3)(list.tail.head) ::: triplicateAdjacentElements(list.tail.tail)
  }
}


// COMMAND ----------

// DBTITLE 1, add N Times To List
def addNTimesToList(list: List[Int], n: Int): List[Int] = {
  list.flatMap(List.fill(n)(_))
}


// COMMAND ----------

// DBTITLE 1,Subslist of list
def containsSublist[A](list: List[A], sublist: List[A]): Boolean = {
  list.sliding(sublist.length).exists(sub => sub == sublist)
}


// COMMAND ----------

// DBTITLE 1,Count number with occurences
def countOccurrences(list: List[Int]): Map[Int, Int] = {
  list.groupBy(identity).mapValues(_.size)
}


// COMMAND ----------

// DBTITLE 1,List split at half
def splitList(list: List[Int], index: Int): (List[Int], List[Int]) = {
  list.splitAt(index)
}


// COMMAND ----------

splitList(List(1,2,3,4,5,6,7,8),4)

// COMMAND ----------

// DBTITLE 1,Length of list
def length(list: List[Int]): Int = {
  list.length
}


// COMMAND ----------

length(List(1,2,3,4,5))
