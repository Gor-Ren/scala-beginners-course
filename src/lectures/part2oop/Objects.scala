package lectures.part2oop


object Objects extends App {

  // Scala does not have class-level functionality ("static")
  // instead, we can define vals vars and methods inside objects, which are singletons
  object Person {
    // "static" / "class"-level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // we can put factory methods in here
    def from(other: Person) = new Person(other.name)
    // we can use "apply" as factory method for constructor-like syntax
    def apply(other: Person) = new Person(other.name)
  }

  class Person(val name: String) {
    // instance-level functionality
  }

  // we refer to a class and object of same name as "companions"
  // everything we access is either from (a) the singleton instance, or (b) instances of the class
  // companions can access each other's private members

  println(Person.N_EYES)
  println(Person canFly)

  // Scala objects are singletons
  val mary = Person  // N.B. absence of "new". We are referring to the singleton
  val john = Person
  println(mary, john)  // same memory location
  println(s"Are mary and john the same instance?: ${mary == john}")

  val tarence = new Person("Tarence")
  val phillip = new Person("Phillip")
  println(s"Are tarence and philip the same instance?: ${tarence == phillip}")

  // using object factory methods:
  val otherTarence = Person.from(tarence)
  val anotherTarence = Person(tarence)  // uses the "apply" factory method

  /*
    Scala Applications ("App")
   */

  // Apps are just Scala objects with the method:
  // def main(args: Array[String]): Unit
  // this is equivalent to a Java static main entry point
}
