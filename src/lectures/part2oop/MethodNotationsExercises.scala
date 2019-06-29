package lectures.part2oop

object MethodNotationsExercises extends App {

  class Person(val name: String, favouriteMovie: String, val age: Int) {

    def +(person: Person): String = s"${this.name} and ${person.name}"

    def +(nickname: String) = new Person(s"$name ($nickname)", favouriteMovie, age)

    def unary_+ = new Person(name, favouriteMovie, age + 1)

    def learns(skill: String) = s"$name learns $skill"

    def learnsScala: String = this learns "Scala"

    def apply() = s"Hi, my name is $name and I like $favouriteMovie"

    def apply(times: Int) = s"$name watched $favouriteMovie $times times"
  }

  val timmy = new Person("Timmy", "Star Wars: Episode IV - A New Hope", 33)

  /*
    1. Overload the + operator for Person class
       mary + "the rockstar" => new Person "Mary (the rockstar)"
   */
  val timmyNickname = timmy + "the clean"
  println(s"${timmyNickname.name}")


  /*
    2. Add an age to the Person class
       Add a unary + operator => new Person with age + 1
       +mary => mary with age incremented  (conceptually equivalent to Java's ++ operator)
   */
  println(s"Current age: ${timmy.age}\nNext year age: ${(+timmy).age}")


  /*
    3. Add a "learns" method in Person, => "Mary learns Scala"
       Add a learnsScala method, calls learns method with "Scala"
       Use it in postfix notation
   */
  println(timmy learns "how to cook")
  println(timmy learnsScala)


  /*
    4. Overload the apply method
       mary.apply(2) => "Mary watched inception 2 times"
   */
  println(timmy(3))
}
