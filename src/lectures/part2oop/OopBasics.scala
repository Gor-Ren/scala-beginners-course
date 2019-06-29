package lectures.part2oop

import java.time.Year

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

  Writer: first name, surname, year of birth,
    method: fullname

  Novel: name, year of release, author
    methods:
      - authorAge
      - isWrittenBy(Writer)
      - copy(Int) = new instance of Novel with new year of release
 */

class Writer(firstName: String, lastName: String, val birthYear: Year) {

  def fullName(): String = s"$firstName $lastName"
}


class Novel(val name: String, val yearReleased: Year, val author: Writer) {

  def authorAge(): Int = Year.now().compareTo(author.birthYear)

  def isWrittenBy(candidate: Writer): Boolean = {
    candidate.fullName().equals(author.fullName())
  }

  def copy(yearReleased: Int): Novel = {
    new Novel(name, Year.of(yearReleased), author)
  }
}

object DemoNovel extends App {
  val grMartin = new Writer("George", "Martin", Year.of(1961))
  println(s"Author: $grMartin")
  println(s"Name: ${grMartin.fullName()}")

  val got = new Novel("A Game Of Thrones", Year.of(1998), grMartin)
  println(s"Book: $got")
  println(s"Book by GRM: ${got.isWrittenBy(grMartin)}")
  println(s"Book published: ${got.yearReleased}")
  println(s"Book author age: ${got.authorAge()}")
  val newEditionGot = got.copy(2018)
  println(s"New edition released: ${newEditionGot.yearReleased}")
  println(s"New edition author age: still ${newEditionGot.authorAge()}")
}

/*
  Exercise: Counter class
    - receives an Int
    - method to return current count
    - method to increment/decrement (returning new Counter)
    - overloaded increment(Int)/decrement(Int) which move by input amount
 */

class Counter(val count: Int) {

  def increment(incrementBy: Int): Counter = {
    new Counter(this.count + incrementBy)
  }

  def increment(): Counter = {
    increment(1)
  }

  def decrement(decrementBy: Int): Counter = {
    new Counter(this.count - decrementBy)
  }

  def decrement(): Counter = {
    decrement(1)
  }
}

object DemoCounter extends App {
  var counter = new Counter(0)
  println(s"Current count: ${counter.count}")
  counter = counter.increment(5)
  println(s"Increment by 5: ${counter.count}")
  counter = counter.decrement()
  println(s"Decrement one: ${counter.count}")
}
