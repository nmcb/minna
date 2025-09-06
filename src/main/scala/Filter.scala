
import scala.annotation.tailrec

trait Sized[A]:
  def size(a: A): Int


def filterWithSize[A : Sized](p: Int => Int => Boolean)(l: List[A], n: Int): List[A] =
  @tailrec
  def loop(l: List[A], result: List[A] = List.empty): List[A] =
    l match
      case a :: as => if p(summon[Sized[A]].size(a))(n) then loop(as, result :+ a) else loop(as, result)
      case Nil     => result
  loop(l)

given Sized[String]:
  def size(s: String): Int = s.length

given Sized[List[?]]:
  def size(l: List[?]): Int = l.size

@main def run(): Unit =

  def filterMinSize = filterWithSize[String](a => b => a >= b)
  def filterMaxSize = filterWithSize[List[?]](a => b => a <= b)

  println(filterMinSize(List("a", "aa", "aaa"), 2))
  println(filterMaxSize(List(List(), List(1), List(1,2), List(1,2,3)), 2))




