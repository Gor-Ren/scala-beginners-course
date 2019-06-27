package lectures.part1basics

object StringOperations extends App {

  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toUpperCase())
  println(str.length)

  val aNumberString = "2"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z')  // append and prepend ops
  println(str.reverse)
  println(str.take(2))

  // Scala-specific: String interpolation

  // S-interpolators
  val name = "Gordon"
  val age = 99
  val greeting = s"Hello, my name is $name and I am $age years old"
  println(greeting)

  // use braces for an expression
  val anotherGreeting = s"Actually I am ${age + 1} years old"
  println(anotherGreeting)

  // F-interpolators
  // like S-interpolators, but can also receive printf-like formats
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per minute"
  println(myth)

  // raw-interpolator
  // doesn't escape values
  println(raw"This is a \n newline")
  // however, it doesn't un-escape values from interpolated variables:
  val escaped = "This is a \n newline"
  println(raw"$escaped")
}
