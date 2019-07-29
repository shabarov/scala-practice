package chapter08

class Rectangle (val x : Double, val y : Double) extends Shape {

  override def square(): Double = x * y
}
