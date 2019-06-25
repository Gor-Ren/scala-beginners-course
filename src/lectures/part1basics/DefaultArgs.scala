package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  @tailrec
  def tailRecursiveFactorial(n: Int, accumulator: Int): Int = {
    if (n <= 1) accumulator
    else tailRecursiveFactorial(n - 1, n * accumulator)
  }

  // we always want to call our function with accumulator of 1
  println(tailRecursiveFactorial(10, 1))

  // this pollutes the function signature
  // we could use a wrapper function to hide this detail
  // alternatively, we can use a default arg:

  def defaultFactorial(n: Int, accumulator: Int = 1): Int = {
    if (n <= 1) accumulator
    else tailRecursiveFactorial(n - 1, n * accumulator)
  }

  println(defaultFactorial(10))

  // but we are restricted to giving default values for trailing args only
  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = {
    // arbitrary implementation details
    println("saving picture")
  }

  // ...and the compiler expected us to provide args in leading order
  //savePicture(800)  // width 800 cannot be passed ahead of format

  /*
    To work around this we can:
    1. pass in all leading args
    savePicture("jpg", 800)

    2. name the args
    savePicture(width = 600)
   */
  savePicture(width = 600)

  // tl;dr: it's like Python. woop.

  // we can swap around args that don't have defaults using names
  def twoParams(x: Int, y: Int): Unit = {}
  twoParams(y = 2, x = 1)
}
