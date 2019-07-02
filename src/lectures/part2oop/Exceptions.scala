package lectures.part2oop

object Exceptions extends App {

  val x: String = null
  // throws NPE:
//  println(x.length)

//  val weirdValue: Nothing = throw new NullPointerException  // an expression, like everything in Scala
  // nothing is a subclass of everything, so we can do this:
//  val anotherWeirdValue: String = throw new NullPointerException
  // in other words, we can throw exception from methods of any return type

  // throwable classes extend Throwable
  // main subclasses are Exception and Error, just like Java

  /*
   * Catching exceptions
   */
  def getInt(throwException: Boolean): Int = {
    if (throwException) throw new RuntimeException
    else 42
  }

  try {
    // code that might throw
    getInt(true)
  } catch {
    case e: RuntimeException => println("Caught an NPE")
  } finally {
    // code executed no matter what
    println("finally")
  }

  // what is the value of a try-catch-finally?
  val tryBlockVal = try {
    5
  } catch {
    case e: RuntimeException => println("hi")
  } finally {
    // finally is optional and does not influence return type
    // finally used only for side-effects
    "test"
  }
  // the compiler unifies the try's return type (Int) with the catch's (Unit) and settles on AnyVal

  // We can define own exceptions
  class MyException extends Exception
  val exception = new MyException

  /*
   * Exercise
   *
   * PocketCalculator class, with methods:
   *   - add(x, y)
   *   - subtract(x, y)
   *   - multiply(x, y)
   *   - divide(x, y)
   *
   * Throw:
   *   - OverflowException if add(x,y) exceeds Int.MAX_VALUE
   *   - UnderflowException if subtract(x,y) exceeds Int.MIN_VALUE
   *   - MathCalculationException for division by zero
   */
  class OverflowException extends Exception
  class UnderflowException extends Exception
  class MathCalculationException extends Exception

//  class PocketCalculator {
//    def add(x: Long, y: Long): Int = {
//      val result = x + y
//      if (result > Int.MaxValue) throw new OverflowException
//      else if (result < Int.MinValue) throw new UnderflowException
//      else result.toInt
//    }
//
//    def subtract(x: Long, y: Long): Int = {
//      add(x, -y)
//    }
//
//    def multiply(x: Long, y: Long): Int = {
//
//    }
//  }
}
