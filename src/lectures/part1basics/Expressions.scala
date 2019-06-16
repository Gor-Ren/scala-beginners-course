package lectures.part1basics

object Expressions extends App {

  val x: Int = 1 + 2  // an expression
  println(x)

  println(2 + 3 * 4)  // mul takes precedence over add

   /*
   operators:
    arithmetic: + - * /
    bitwise: & | ^ << >> >>> (last one is right shift with zero extension, Scala-specific)
    equality and ordering: == != > >= < <=
    boolean: ! && ||
   */

  var myVariable = 2
  myVariable += 3  // can also use -= *= /=

  // Instructions (DO) vs. Expressions (VALUE)

  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3  // IF Expression, not Instruction; returns a value
  println(aConditionedValue)

  // an Instruction - looping in an imperative style - don't do this!
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }  // returns type Unit

  // EVERYTHING in Scala is an Expression! E.g.
  val aWeirdValue: Unit = myVariable = 3  // inferred type is 'Unit', Unit is equivalent to void
  println(aWeirdValue)

  // side effects: println(), whiles, reassigning

  // Code blocks
  val myCodeBlock = {  // surround by curly braces
    val y = 2
    val z = y + 1  // variables are scoped inside code block only!
    if (z > 2) "hello" else "goodbye"
  }
  // value of the whole block is value of its last Expression, in this case String

  // QUESTIONS
  // 1. what is the difference between "hello world" vs println("hello world")

    // "hello world" is a String, println("hello world") is an Expression of type Unit which causes
    // the side-effect of printing the value to the terminal

  // 2. what is the value of:
  // a.
  val someValue = {
    2 < 3
  }
    // ans - Boolean: true

  // b.
  val otherValue = {
    if (someValue) 239 else 986
    42
  }
    // ans - Int: 42  (because it's the last line of the code block)
}
