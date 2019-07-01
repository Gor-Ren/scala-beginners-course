package lectures.part2oop

import java.util.NoSuchElementException

/**
  * An immutable, singly-linked list of integers.
  */
abstract class MyList {

  /*
   * Exercise: implement class with methods:
   *   head = first element
   *   tail = rest of the list
   *   isEmpty = true is list empty, else false
   *   add(Int) => new list with element appended to end
   *   toString => a string representation of the list
   */
  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element: Int): MyList
  def elementsToString: String
  override def toString: String = s"[$elementsToString]"
}

case object Empty extends MyList {  // we make it an object since it can be a singleton
  override def head: Int = throw new NoSuchElementException("List is empty")

  override def tail: MyList = throw new NoSuchElementException("List is empty")

  override def isEmpty = true

  override def add(element: Int) = Cons(element)

  override def elementsToString: String = ""
}

case class Cons(override val head: Int, override val tail: MyList = Empty) extends MyList {
  // something cool happened: overrode "value methods" head and tail with vals in signature

  override def isEmpty = false

  override def add(element: Int) = Cons(element, this)

  override def elementsToString: String = {
    if (tail.isEmpty) head.toString
    else head.toString + " " + tail.elementsToString
  }
}

object MyListTest extends App {
  val singletonList = Cons(1)
  println(singletonList.head)

  val list = Cons(2, singletonList)
  println(list.head)
  println(list.add(3).head)
  println(list.tail)

  println(list.add(3).add(4).add(0))
}
