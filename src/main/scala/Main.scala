object Main:

  private def A(m: Int, n: Int): Int =
    (m, n) match
      case (0, _) => n + 1
      case (_, 0) => A(m - 1, 1)
      case (_, _) => A(m - 1, A(m, n - 1))

  def main(args: Array[String]): Unit =
    val result: Int = A(4, 1)
    assert(result == 65533)
