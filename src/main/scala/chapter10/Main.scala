package chapter10

import java.awt.geom.Ellipse2D

import scala.collection.BitSet

object Main extends App {

  //ex01
  val egg = new Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
  egg.translate(10, -10)
  egg.grow(10, 20)

  //ex03
  val bs = BitSet(0,1,3,128)
  println(bs.mkString(", "))
  val buf = new StringBuilder
  for (i <- 0 to bs.max) buf.append(if (bs(i)) "1" else "0")
  println(buf)

  //ex04
  var l : Logger = new CryptoLogger()
  l.log("abcd")

}
