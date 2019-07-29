package chapter12

object Main extends App {
  //ex01
  def values(fun : (Int) => Int, low : Int, high : Int) : Seq[(Int, Int)] = {
    for (i <- low to high) yield (i, fun(i))
  }
  println(values(x => x * x, -5, 5).mkString(", "))

  //ex02
  val a = Array(0,-1,4,2)
  //a.reduceLeft((a,b) => if (a > b) a else b))
  println(a.reduceLeft(Integer.max(_, _)))

  //ex03
  def factorial(n : Int) : Int = {
    if (n <= 1) 1
    (1 to n).reduceLeft((a,b)=>a*b)
  }
  println(factorial(4))

  //ex04
  def factorial2(n : Int) : Int = {
    (1 to n).foldLeft(1)((a,b)=>a*b)
  }
  println(factorial2(-1))

  //ex05
  def largest(fun : (Int) => Int, seq : Seq[Int]) : Int = {
    seq.map(fun).max
  }
  println(largest((x) => 10 * x - x * x, 1 to 10))

  //ex07
  def adjustToPair(fun : (Int, Int) => Int): ((Int, Int)) => Int = {
    (pair : (Int, Int)) => fun(pair._1, pair._2)
  }

  println(adjustToPair(_ * _)((6, 7)))
}
