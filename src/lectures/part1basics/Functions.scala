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

  /*
   2. Factorial function: 1 * 2 * 3 * ... * n
  */

  /*
   3. Fibonnacci function: f(1) = 1, f(2) = 2, f(n) = f(n-1) + f(n-2)
  */

  /*
   4. Prime testing function: Int -> Boolean
  */
}
