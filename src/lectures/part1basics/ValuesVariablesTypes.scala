package lectures.part1basics

object ValuesVariablesTypes extends App {

  val x: Int = 42
  // vals are immutable!
  println(x)

  val y = 5
  // compiler can infer val type - declaration is optional
  println(y);  // semicolons are allowed, but discouraged

  val myString: String = "hello"
  val anotherString = "goodbye"

  val myBool: Boolean = false

  val myChar: Char = 'x'  // single quote marks declare char, just like Java

  val anInt: Int = x
  val myShort: Short = 13  // compiler will complain if number is too large for a short
  val myLong: Long = 5555555555555555L  // 'L' marker denotes long, just like Java
  val myFloat: Float = 2.0f  // 'f' marker denotes float (32 bits representation)
  val myDouble: Double = 3.14  // double doesn't need a marker, it's default - has 64 bit rep

  // variables
  var myVariable: Int = 4
  myVariable = 5  // mutable

  // we will generally prefer vals over vars
}
