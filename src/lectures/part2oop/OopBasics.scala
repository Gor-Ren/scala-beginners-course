package lectures.part2oop

object OopBasics extends App {

  val person = new Person("John", 55)
  println(person)
  println(person.age)  // a field

  person.greet("Tom")
}

// constructor
// class parameters (constructor params) are not fields
// we can make the params fields by adding val or var to declaration
class Person(name: String, val age: Int) {
  // class body
  // can have val/var definitions, function definitions, expressions, and so on
  // can do anything here that can be done in a block expression

  val s = 2  // now usable as a field

  println(1 + 3)  // executed at every instantiation

  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")
  // we used 'this.' to specify we meant the field

  // overloading method
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple constructors
  def this(name: String) = this(name, 0)
  // limitation: an auxiliary constructor's implementation must be to call another constructor
  // in this case we could more easily have used a default param
}

/*
  Exercise: create a Novel and Writer class.

  Writer: first name, surname, year,
    method: fullname

  Novel: name, year of release, author
    methods:
      - authorAge
      - isWrittenBy(Writer)
      - copy(Int) = new instance of Novel with new year of release
 */


/*
  Exercise: Counter class
    - receives an Int
    - method to return current count
    - method to increment/decrement (returning new Counter)
    - overloaded increment(Int)/decrement(Int) which move by input amount
 */
