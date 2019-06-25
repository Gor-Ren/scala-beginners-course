package lectures.part1basics

object CallByNameVsValue extends App {

  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  // arrow tells compiler param is called by name
  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime())  // prints same value twice!
  calledByName(System.nanoTime())  // prints two different values!

  // in call by value, expression is evaluated and value passed in
  // in call by name, expression is passed in and evaluated each time

  def infinite(): Int = 1 + infinite  // causes overflow when eval'd

  def printFirst(x: Int, y: => Int): Unit = println(x)  // ignores 2nd arg

  // stack overflow because infinite is passed by value and overflow when evaluated
  //printFirst(infinite(), 34)

  // prints 34 because infinite is passed by name and never evaluated:
  printFirst(34, infinite())
}
