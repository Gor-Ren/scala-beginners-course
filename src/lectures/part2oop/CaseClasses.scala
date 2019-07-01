package lectures.part2oop

object CaseClasses extends App {
  /*
   * Case Classes
   *
   * shorthand for defining a lot of boilerplate
   * e.g. equals, hashcode, toString, companion object
   * good for quickly defining basic data-holding classes
   */

  // declared like so:
  case class Person(name: String, age: Int)

  /*
   * Functionality
   */

  // 1. class parameters are fields
  val jim = Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  println(jim)  // N.B. compiler inserts .toString, just like Java

  // 3. equals and hashcode implemented
  val jim2 = Person("Jim", 34)
  println(jim == jim2)

  // 4. useful copy() method
  val jim3 = jim.copy(age = 35)
  println(jim3.age)

  // 5. companion object, with apply method same as constructor
  val thePerson = Person
  val mary = thePerson("Mary", 24)

  // 6. case classes are serialisable
  // useful for distributed systems e.g. with Akka

  // 7. case classes have extractor patterns; they can be used in pattern matching
  // pattern matching is covered later :)

  /*
   * case object
   */
  case object UnitedKingdom {
    def description: String = "GB and NI"
  }
}
