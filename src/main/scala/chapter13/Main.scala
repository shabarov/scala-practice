package chapter13

import scala.collection.mutable

object Main extends App {
  //ex01
  def indexes(str : String) : mutable.Map[Char, mutable.Set[Int]] = {
    val m = new mutable.HashMap[Char, mutable.Set[Int]]()
    for (i <- str.indices) {
      val c = str(i)
      m(c) = m.getOrElse(c, new mutable.TreeSet[Int]()) + i
    }
    m
  }

  println(indexes("Mississippi").mkString(", "))

}
