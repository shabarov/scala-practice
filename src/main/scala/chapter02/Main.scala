package chapter02

object Main extends App {
  // ex01
  def signum(n : Int) : Int = if (n == 0) 0 else if (n > 0) 1 else -1

  println("More than 0 = " + signum(10))
  println("Less than 0 = " + signum(-10))
  println("Zero = " + signum(0))

  def signum2(n: Int): Int = {
    if (n < 0) -1
    else if (n > 0) 1
    else 0
  }

  println("More than 0 = " + signum2(10))
  println("Less than 0 = " + signum2(-10))
  println("Zero = " + signum2(0))

  //ex02
  def empty() {}
  def empty2() {()}
  val e: Unit = empty()
  val e2: Unit = empty2()
  println(e.getClass)
  println(e2.getClass)

  //ex03
  var y = 0
  var x: Unit = {}
  y = 1
  x = y = 1

  //ex04
  for (i <- 10 to 1 by -1) println(i)

  //ex05
  def countdown(n : Int) : Unit = for (i <- n to 0 by -1) println(i)
  countdown(11)

  //ex06
  import scala.language.postfixOps
  def unicodeProduct(s : String): Long = {
    var res : Long = 1L
    for (c <- s) res *= c.toInt
    res
  }

  val hello = "Hello"
  println(unicodeProduct(hello))

  //ex07
  val product1 = hello.map(_.toLong).fold(1L){(z, i) => z*i}
  val product2 = hello.foldLeft(1L)(_ * _)
  println(s"Product1 = $product1")
  println(s"Product2 = $product2")

  //ex09
  def product3(s : String): Long = {
    if (s.length == 1) s(0).toLong else {
      s.head.toLong * product3(s.drop(1))
    }
  }

  println(hello.head)
  println(hello.drop(1))

  println(product3(hello))

  //ex10
  def factor(x : Int, n : Int) : Double = {
    if (n == 0) 1
    else if (n < 0) 1 / factor(x, -n)
    else if (n % 2 == 0) {
      val tmp = factor(x, n / 2)
      tmp * tmp
    }
    else x * factor(x, n - 1)
  }

  println("Factor 5^3 = " + factor(5, 3))

}
