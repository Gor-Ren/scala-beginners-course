package lectures.part2oop

object Inheritance extends App {

  class Animal {
    val animalType = "wild"
    def eat(): Unit = println("nom nom nom")  // side effects => use parens on method signature
  }

  // single class inheritance
  class Cat extends Animal
  // inherits non-private fields and methods; if we marked "eat" as private, we couldn't call

  val cat = new Cat
  cat.eat()

  /*
   * Constructors and inheritance
   */
  class Person(name: String, age: Int)
  // when extending with different constructor signature, we need to specify super constructor call
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  /*
   * Overriding
   */
  class Dog extends Animal {
    override val animalType: String = "domesticated"
    override def eat(): Unit = {
      super.eat()  // same as Java
      println("crunch crunch")
    }
  }
  val dog = new Dog
  dog.eat()

  // we can override fields in constructor
  class Cow(override val animalType: String) extends Animal
  val cow = new Cow("farmable")
  println(cow.animalType)

  /*
   * Type substitution (polymorphism)
   */
  val unknownAnimal: Animal = new Dog
  unknownAnimal.eat()  // uses dog implementation of eat

  /*
   * Preventing overrides
   *
   * 1. use "final" modifier on member
   * 2. use final on class
   * 3. seal the class using "sealed" modifier
   *      allows classes to be extended in same file, but not outside
   *      used when you want to exhaustively specify all subclasses
   */
}
