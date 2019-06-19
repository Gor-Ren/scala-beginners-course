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
  //println(factorial(1000000))

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

    repeatHelper(s, times, "")
  }

  println(repeat("Scala", 3))

  /*
    2. Implement a tail recursive IsPrime
   */

  /*
    3. Implement a tail recusrive Fibonacci function
   */
}
