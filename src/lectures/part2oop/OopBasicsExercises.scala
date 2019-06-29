package lectures.part2oop

import java.time.Year

/*
  Exercise: create a Novel and Writer class.

  Writer: first name, surname, year of birth,
    method: fullname

  Novel: name, year of release, author
    methods:
      - authorAge() = age when book released
      - isWrittenBy(Writer)
      - copy(Int) = new instance of Novel with new year of release
 */

class Writer(firstName: String, lastName: String, val yearOfBirth: Year) {

  def fullName(): String = s"$firstName $lastName"
}


class Novel(val name: String, val yearReleased: Year, val author: Writer) {

  /** Returns the author's age at time of publication. */
  def authorAge(): Int = yearReleased.compareTo(author.yearOfBirth)

  def isWrittenBy(candidate: Writer): Boolean = {
    candidate.fullName().equals(author.fullName())
  }

  def copy(newYearOfPublication: Year): Novel = {
    new Novel(name, newYearOfPublication, author)
  }
}

object DemoNovel extends App {
  val grrMartin = new Writer("George", "Martin", Year.of(1948))
  println(s"Author: $grrMartin")
  println(s"Name: ${grrMartin.fullName()}")

  val got = new Novel("A Game Of Thrones", Year.of(1996), grrMartin)
  println(s"Book: $got")
  println(s"Book by GRRM: ${got.isWrittenBy(grrMartin)}")
  println(s"Book published: ${got.yearReleased}")
  println(s"Book author age when released: ${got.authorAge()}")
  val newEditionGot = got.copy(Year.of(2018))
  println(s"New edition released: ${newEditionGot.yearReleased}")
  println(s"New edition author age when released: ${newEditionGot.authorAge()}")
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
