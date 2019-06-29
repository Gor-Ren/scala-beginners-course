package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favouriteMovie: String) {

    def likes(movie: String): Boolean = movie == favouriteMovie

    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    // we can define methods using operators
    def +(person: Person): String = s"${this.name} and ${person.name}"

    // we can define our own unary operator behaviour
    def unary_! : String = s"$name: WOOHOO!"

    // parameterless - may be used with postfix notation
    def isAlive: Boolean = true

    // the parens are important here
    def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"
  }

  /*
    Infix Notation

    (Only allowed for single-operator methods)
  */
  val mary = new Person("Mary", "Inception")
  println(s"Mary likes Inception?: ${mary.likes("Inception")}")
  // equivalent using infix notation / operator notation
  println(s"Mary likes Inception?: ${mary likes "Inception"}")

  // "operators" in Scala
  val tom = new Person("Edward", "Fight Club")
  println(mary hangOutWith tom)
  println(mary + tom)

  // we can use this principle in reverse: call operators using method dot notation,
  println(1.+(2))
  // all operators are methods!

  /*
    Prefix Notation

    (Only allowed for - + ~ !)
  */
  val x = -1  // the "negative" sign is a unary operator
  val y = 1.unary_-  // equivalent
  // unary_ prefix only works with - + ~ !
  println(!mary)

  /*
    Postfix Notation

    (Only allowed for parameterless methods)
   */
  println(mary.isAlive)
  // we can use postfix notation on paramaterless method
  println(mary isAlive)
  // the difference isn't big, and it isn't often used

  /*
    Apply
   */
  println(mary.apply())
  println(mary())  // equivalent! The compiler looks for an .apply() method
  println(mary apply)  // also works, because apply has no params, although violates style conventions
}
