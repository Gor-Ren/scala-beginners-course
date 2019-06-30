package lectures.part2oop

import java.util.NoSuchElementException

/**
  * An immutable, singly-linked list of integers.
  */
abstract class MyList[+E] {

  /*
   * Exercise: implement class with methods:
   *   head = first element
   *   tail = rest of the list
   *   isEmpty = true is list empty, else false
   *   add(Int) => new list with element appended to end
   *   toString => a string representation of the list
   */
  def head: E
  def tail: MyList[E]
  def isEmpty: Boolean
  def add[F >: E](element: F): MyList[F]
  def elementsToString: String
  override def toString: String = s"[$elementsToString]"
}

class Empty[+E] extends MyList[E] {  // we make it an object since it can be a singleton
  override def head: E = throw new NoSuchElementException("List is empty")

  override def tail: MyList[E] = throw new NoSuchElementException("List is empty")

  override def isEmpty = true

  override def add[F >: E](element: F) = new Cons[F](element)

  override def elementsToString: String = ""
}

class Cons[+E](override val head: E, override val tail: MyList[E] = new Empty[E]) extends MyList[E] {
  // something cool happened: overrode "value methods" head and tail with vals in signature

  override def isEmpty = false

  override def add[F >: E](element: F) = new Cons(element, this)

  override def elementsToString: String = {
    if (tail.isEmpty) head.toString
    else head.toString + " " + tail.elementsToString
  }
}

object MyListTest extends App {
  val singletonList = new Cons[Int](1)
  println(singletonList.head)

  val list = new Cons[Int](2, singletonList)
  println(list.head)
  println(list.add(3).head)
  println(list.tail)

  println(list.add(3).add(4).add(0))

  val strings = new Cons[String]("hello", new Cons[String]("there"))
  println(strings)

  val covariantStrings: MyList[String] = new Cons[String]("test")
  val mixed = covariantStrings.add(2)  // type has become MyList[Any] due to covariance
  println(mixed)

  val variousStuff = new Cons[Any]("hello", new Cons[Any](5))
  println(variousStuff.add(2.5F))
}
