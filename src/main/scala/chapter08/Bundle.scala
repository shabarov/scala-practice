package chapter08

import scala.collection.mutable.ArrayBuffer

class Bundle extends Item {

  var items : ArrayBuffer[Item] = new ArrayBuffer[Item]()

  def add(item : Item) : Bundle = {
    items += item
    this
  }

  override def price: Double = items.map(_.price).sum

  override def descr: String = items.map(_.descr).mkString(", ")

}

object Bundle {
  def apply(): Bundle = new Bundle()
}
