package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat(): Unit
  }

  // anonymous class... just like Java
  val anonAnimal: Animal = new Animal {
    override def eat(): Unit = println("anonymous animal >:)")
  }
  // behind the scenes, the compiler creates a full class declaration with name
  // AnonymousClasses$$anon$1
  println("Anonymous class: " + anonAnimal.getClass)
}
