
trait Lengthy[A]:
  def length(a: A): Int


def filterMinLength[A : Lengthy](l: List[A], n: Int, p: Int => Int => Boolean, acc: List[A] = List.empty): List[A] =
  val lengthy = implicitly[Lengthy[A]]
  l match
    case a :: as => if p(lengthy.length(a))(n) then filterMinLength(as, n, p, acc :+ a) else filterMinLength(as, n, p, acc)
    case Nil                      => acc

given Lengthy[String]:
  def length(a: String): Int = a.length

given [A] => Lengthy[List[A]]:
  def length(a: List[A]): Int = a.length


val add: (Int, Int) => Int =
  (a, b) => a + b

@main def run(): Unit =
  println(filterMinLength(List("a", "aa", "aaa"), 2, (a: Int) => (b: Int) => a >= b))
  println(filterMinLength(List(List(), List(1), List(1,2), List(1,2,3)), 2, (a: Int) => (b: Int) => a <= b))

  println(add(1, 2))




