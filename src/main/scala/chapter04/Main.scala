package chapter04

import java.util.Scanner
import java.util
import scala.collection.immutable.SortedMap

object Main extends App {

  //ex01
  val prices = Map("hat" -> 10.3, "shorts" -> 3.4, "jeans" -> 6.8)
  val discount = 0.9
  val priceWithDiscount = prices.map { case (k, v) => k -> discount * v }
  val pricesWithDiscount2 = prices.mapValues(f => f * discount)
  println("With discount=" + pricesWithDiscount2.mkString(", "))

  //ex02
  val words = new scala.collection.mutable.HashMap[String, Int]
  //val in = new Scanner(Thread.currentThread().getContextClassLoader.getResourceAsStream("ch04ex02.txt"))
  processFile(w => words(w) = words.getOrElse(w, 0) + 1)
  println(words.mkString(", "))

  //ex03
  var words2 = Map[String, Int]()
  processFile(w => words2 += w -> (words2.getOrElse(w,0) + 1))
  println(words2.mkString(", "))

  //ex04
  var words3 = SortedMap[String, Int]()
  processFile(w => words3 += w -> (words3.getOrElse(w,0) + 1))
  println(words3.mkString(", "))

  //ex05
  var words4 = new util.TreeMap[String, Int]()
  //processFile(w => words4(w) = words4.getOrElse(w,0) + 1)
  //println(words4.mkString(", "))

  println("Hello".zip("World").mkString("\n"))


  def processFile(process: String => Unit): Unit = {
    val in = new Scanner(getClass.getResourceAsStream("/ch04ex02.txt"))
    try {
      while (in.hasNext()) {
        val word = in.next()
        //if (w.contains(word)) w.update(word, w(word) + 1)
        //else w.put(word, 1)
        process(word)
      }
    } finally {
      in.close()
    }
  }

}
