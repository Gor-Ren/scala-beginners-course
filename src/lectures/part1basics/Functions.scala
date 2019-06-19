package lectures.part1basics

object Functions extends App {

  // def is the keyword to declare function
  def myFunction(a: String, b: Int): String =
    a + " " + b

  // a function consists of a single expression
  // this includes code blocks, which is also an Expression
  def myBlockFunction(a: String, b: Int): String = {
    a + " " + b
  }

  def parameterlessFunction(): Int = 42

  println(myFunction("hello", 3))
  println(parameterlessFunction())  // N.B. missing the parens returns same result

  def myRecursiveFunction(myString: String, n: Int): String = {
    if (n == 1) myString
    else myString + myRecursiveFunction(myString, n - 1)
  }
  // we can rely on type inference for functions, EXCEPT when they are recursive
  // but it's best practice to always specify

  println(myRecursiveFunction("hello", 4))

  // fundamentally, we use recursion instead of loops
  // DO NOT WRITE IMPERATIVE (LOOPING) CODE WITH SCALA!

  // a "void" function:
  def mySideEffectFunction(toPrint: String): Unit = println(toPrint)

  // code blocks have their own scope. We can define auxilliary functions inside
  def myBigFunction(n: Int): Int = {
    def myNestedFunction(a: Int, b: Int): Int = a + b

    myNestedFunction(n, n - 1)
  }
  println(myBigFunction(4))

  // QUESTIONS

  /*
   1. A greeting function (name, age) "Hi, my name is $name and I am $age years old
  */

  def greeting(name: String, age: Int): String = {
    "Hi, my name is " + name + " and I am " + age + " years old."
  }

  println(greeting("Luna", 3))

  /*
   2. Factorial function: 1 * 2 * 3 * ... * n
  */

  def factorial(n: Int): Int = {
    if (n < 0) throw new IllegalArgumentException("input must be non-negative")
    else if (n <= 1) 1
    else n * factorial(n - 1)
  }

  println(factorial(0))
  println(factorial(3))
  println(factorial(5))
//  println(factorial(-1))

  /*
   3. Fibonnacci function: f(1) = 1, f(2) = 2, f(n) = f(n-1) + f(n-2)
  */

  def fib(n: Int): Int = {
    if (n < 0) throw new IllegalArgumentException("input must be non-negative")
    else if (n == 0) 0
    else if (n == 1) 1
    else fib(n - 1) + fib(n - 2)
  }

  println(fib(5))

  /*
   4. Prime testing function: Int -> Boolean
  */

  // naive solution without optimisation
  def isPrime(candidate: Int): Boolean = {
    /**
      * Returns true if candidate is divisible by any integer between 2 and upTo
      *
      * @param candidate the value to be tested
      * @param upTo the maximum divisor to be tested
      * @return true if candidate is divisible by any value between 2 and upTo, else false
      */
    def isDivisibleByAny(candidate: Int, upTo: Int): Boolean = {
      if (upTo == 1) false
      else if (candidate % upTo == 0) true
      else isDivisibleByAny(candidate, upTo - 1)
    }

    /**
      * Calculates the integer square root of n, rounding down if necessary
      *
      * @param n the value for which a square root will be calculated
      * @return the square root of n if it is a perfect square, or its square root rounded down
      */
    def integerSqrt(n: Int): Int = {
      Math.floor(Math.sqrt(n)).toInt
    }

    if (candidate < 0) throw new IllegalArgumentException("input must be non-negative")
    else if (candidate == 0) false
    else if (candidate == 1 || candidate == 2) true
    else !isDivisibleByAny(candidate, integerSqrt(candidate))
    // check whether all nums from 2 to sqrt(candidate) are divisible into it?
  }

  def printIsPrimeUpTo(n: Int): Unit = {
    if (n > 0) {
      println("Is " + n + " prime? " + isPrime(n))
      printIsPrimeUpTo(n - 1)
    }
  }

  printIsPrimeUpTo(30)
}
