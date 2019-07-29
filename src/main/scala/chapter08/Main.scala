package chapter08

import scala.collection.mutable.ListBuffer

object Main extends App {

  val b = new Bundle()
  val i : SimpleItem = new SimpleItem(1, "SI-1")

  println(b.getClass)
  b.add(i).add(new SimpleItem(2, "SI-2"))

  println(b.price)
  println(b.descr)

  var l = new ListBuffer[Shape]()
  l += new Circle(2) += new Rectangle(1,3)
  println(l.size)
  println(l.map(_.square()).fold(0.0)((l1, r1) => l1 + r1))


}
