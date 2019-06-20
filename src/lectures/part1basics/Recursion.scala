package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println("Computing factorial " + n + ", need factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)

      result
    }
  }

  println(factorial(10))
  // causes a stack overflow!
//  println(factorial(10000))

  def accumulatorFactorial(n: Int): BigInt = {
    @tailrec  // makes compiler enforce that function is tail recursive
    def factorialHelper(x: Int, accumulator: BigInt): BigInt= {
      if (x <= 1) accumulator
      else factorialHelper(x - 1, x * accumulator)  // tail recursion
    }
    factorialHelper(n, 1)
  }

  // does not overflow stack due to tail recursion
  println(accumulatorFactorial(10000))

  // use tail recursion instead of loops

  /*
    1. Implement a tail recursive concatenate a string n times
   */

  def repeat(s: String, times: Int): String = {
    @tailrec
    def repeatHelper(s: String, times: Int, accumulator: String): String = {
      if (times <= 0) accumulator
      else repeatHelper(s, times - 1, accumulator + s)
    }

    if (times <= 0) throw new IllegalArgumentException("times must not be negative: " + times)
    repeatHelper(s, times, "")
  }

  println(repeat("Scala", 3))

  /*
    2. Implement a tail recursive IsPrime
   */
  def isPrime(candidate: Int): Boolean = {
    @tailrec
    def isPrimeUpTo(n: Int, max: Int, primeSoFar: Boolean): Boolean = {
      if (!primeSoFar) false
      else if (max <= 1) primeSoFar
      else isPrimeUpTo(n, max - 1, primeSoFar && (n % max != 0))
    }
    if (candidate <= 0) throw new IllegalArgumentException("candidate must be positive")
    else isPrimeUpTo(candidate, candidate - 1, primeSoFar = true)
  }

  def evaluateIsPrime(candidate: Int): Unit = {
    println("Is " + candidate + " prime?: " + isPrime(candidate))
  }

  evaluateIsPrime(2)
  evaluateIsPrime(13)
  evaluateIsPrime(21)
  evaluateIsPrime(29)

  /*
    3. Implement a tail recursive Fibonacci function
   */
  def fib(n: Int): Int = {
    /**
      * Helper; calculates the next x Fib numbers, given a current and previous Fib nums
      *
      * @param x the Fibonacci number to calculate
      * @param lastFibNum the previous fib num in the series
      * @param secondLastFibNum the second last Fib num in the series
      * @return the xth Fibonacci number
      */
    @tailrec
    def fibHelper(x: Int, lastFibNum: Int, secondLastFibNum: Int): Int = {
      if (x > n) lastFibNum
      else fibHelper(
        x + 1,
        lastFibNum + secondLastFibNum,  // the next fib number
        lastFibNum  // update the last fib number
      )
    }

    if (n < 0) throw new IllegalArgumentException("input must be non-negative")
    else if (n == 0) 0
    else if (n == 1) 1
    else fibHelper(2, 1, 0)
  }

  println(fib(5))
  println(fib(10))
}

// video 16:02
