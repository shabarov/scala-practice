package chapter03

import scala.collection.mutable.ArrayBuffer

object Main {
  def main(args : Array[String]) : Unit = {
    //ex01
    println("Array = " + fill(10).mkString)

    //ex02
    println("Pairs = " + replacePairs(Array(1,2,3,4,5)).mkString(", "))

    //ex03
    println("Pairs = " + replacePairs2(Array(1,2,3,4,5)).mkString(", "))

    //ex04
    println("Sort = " + sortPositiveNegative(Array(3,6,-6,-3,5,-7)).mkString(", "))

    //ex07
    println((Array(1,1,6,7,4,3,3,3,0).distinct).mkString)

    //ex08
    println(deleteNegatives(ArrayBuffer(4,6,-1,7,-3,8,-9)).mkString(", "))
  }

  def fill(n : Int) : Array[Int] = {
    val a = new Array[Int](n)
    for (i <- 0 until n) a(i) = i
    a
  }

  def replacePairs(a : Array[Int]) : Array[Int] = {
    for (i <- 0 until (a.length - 1, 2)) {
      if (i != (a.length - 1)) {
        var tmp = a(i)
        a(i) = a(i + 1)
        a(i+1) = tmp
      }
    }
    a
  }

  def replacePairs2(a : Array[Int]): IndexedSeq[Int] = {
    for (i <- a.indices) yield a {
      if (i == (a.length - 1)) i else if (i % 2 != 1) {
        i + 1
      } else i-1
    }
  }

  def sortPositiveNegative(a : Array[Int]): Array[Int] = {
    var b = new ArrayBuffer[Int]()
    b ++= a.filter(_ >= 0)
    b ++= a.filter(_ < 0)
    b.toArray
  }

  def deleteNegatives(a : ArrayBuffer[Int]) : ArrayBuffer[Int] = {
    val indexes = a.filter(_ < 0).map(e => a.indexOf(e)).drop(1)
    for (j <- indexes.indices.reverse) a.remove(indexes(j))
    a
  }
}
