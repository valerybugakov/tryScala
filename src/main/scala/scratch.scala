object Scratch {
  Map.empty ++ (2004 to 2014).map( _ -> "Omg" )

  // Declares anonymous (inaccessible) class
  // creates a single instance of the class named Main
  // also comes with .apply .unapply features
  object Main {
    println("Hello, World!")

    val woot = "omg"
  }

  val res = Main
  println(s"Ololo ${res.woot}")

  object Test extends App {
    println("It's a test!")
  }

  Test.main(Array.empty)

  // Prints all prime numbers from 1 to 100
  def isPrime(n: Int) = n != 1 && (2 until n).forall(n % _ != 0)
  (1 to 100).filter(isPrime)

  // Case class provides getter and setter for constructor params
  // and an ability to instantiate the class without new keyword
  case class A(value: Int) {
    def double: Int = (A.magicNumber + value) * 2
  }

  // Companion object represents static methods of the classs
  object A {
    private def magicNumber = 3
  }

  trait C {
    def foo = 1
  }

  val a = A(7)
  a.double
  a == A(7) // compare values
  a eq A(7) // compare pointers

  trait D extends C {
    override def foo = 2
  }

  trait F extends C {
    override def foo = 3
  }

  // Multiple inheritance diamond problem resolved by traits order
  class E extends F with D

  val e = new E
  e.foo

  // Sealed means that all implementation classes should be listed
  // in the same file where trait is defined
  sealed trait User
  case class LoggedUsed(name: String) extends User
  case class Guest(name: String) extends User

  val user: User = Guest("Bob")

  // Under the hood simple instance of checks
  user match {
    case LoggedUsed(name) => println("logged user here")
    case Guest(name) => println("guest here")
  }


  // Infix operators
  // List[A] = Nil | Cons(A, List[A])
  1 :: 2 :: 3 :: Nil
  Nil.::(3).::(2).::(1)

  // Case classes recursive pattern matching
  case class Z[T](i: T)
  Z(Z(1)) match {
    case Z(Z(x)) => x
    case Z(x) => x
  }

  // Optional type matching
  def sqrt(i: Int): Option[Int] = None
  sqrt(3) match {
    case Some(x) => x
    case None => println("Nothing here")
  }

  // Infix list matching
  1 :: 2 :: Nil match {
    case 1 :: _ => println("Got 1")
    case ::(x, _) => x
    case _ =>
  }

  // Generics example
  class G[T]
  def foo[T](t: Seq[T]): T = t.head

  foo(List(1, 2, 3))
}