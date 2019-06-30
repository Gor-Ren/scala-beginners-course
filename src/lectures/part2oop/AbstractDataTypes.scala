package lectures.part2oop

object AbstractDataTypes extends App {

  // abstract classes can have unimplemented members, but cannot be instantiated
  abstract class Animal {
    val creatureType: String
    def eat(): Unit
  }

  // the compiler enforces that we must implement abstract members
  class Dog extends Animal {
    override val creatureType: String = "domesticated"

    def eat(): Unit = println("crunch crunch")  // the override keyword is optional since abstract
  }

  /*
   * Traits
   */
  trait Carnivore {
    // can have abstract members
    def eat(animal: Animal): Unit
    // and concrete members
    val preferredMeal: String = "meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {  // can have multiple traits
    override val creatureType: String = "predator"

    override def eat(): Unit = println("...")
    // must implement trait's members
    override def eat(animal: Animal): Unit = println(s"The croc ate the ${animal.getClass.getName}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)  // not my proudest programming moment

  /*
   * Traits vs Abstract Classes
   *
   * 1. Traits do not have constructor parameters
   * 2. Multiple traits may be inherited by a class
   * 3. traits = behaviour, abstract class = "thing"
   */
}
