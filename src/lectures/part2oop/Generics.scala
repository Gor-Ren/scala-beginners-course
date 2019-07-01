package lectures.part2oop

object Generics extends App {

  class MyList[E] {  // [E] denotes generic type A
  }

  class MyMap[K, V]  // multiple generic types

  trait MyGenericTrait[E]  // traits can also be parameterised with types

  val listOfInts = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {
    def empty[E]: MyList[E] = ???  // method signature parameterised by type E (no implementation)
  }

  val emptyListOfIntegers = MyList.empty[Int]

  /*
   * Variance problem
   */
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // Question: does a List[Cat] extend List[Animal]?
  // Possibilities:
  //
  //   1. yes: make the list "covariant"
  class CovariantList[+E]  // the "+" makes the generic type parameter covariant

  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // however, the compiler must now enforce certain rules to prevent pollution of the cat list
  // e.g. it must disallow animalList.add(new Dog)

  //   2. no: make the list "invariant"
  class InvariantList[E]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]  // RHS type will not accept Cat or Dog

  //   3. hell no: make the list "contravariant"
  class Trainer[-E]  // the "-" makes the type param contravariant
  // less intuitive, but the idea that we want a trainer of cats, and happen to provide a trainer of animals, works:
  val trainer: Trainer[Cat] = new Trainer[Animal]

  /*
   * Bounded types
   */
  class Crate[A <: Animal](animal: A)  // type A, which is a subtype of Animal

  val dogCrate = new Crate(new Dog)  // N.B. generic type has been inferred!

  // covariant collections with bounded types solve the problem of "polluting" the list with wrong type
  class MyOtherList[+A] {
    def add[B >: A](element: B): MyOtherList[B] = ???  // we will return a list of the common super type
  }

  val catList: MyOtherList[Animal] = new MyOtherList[Cat]
  val mixedList: MyOtherList[Animal] = catList.add(new Dog)  // dynamic type has become MyOtherList[Animal]
}
