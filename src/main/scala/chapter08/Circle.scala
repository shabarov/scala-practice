package chapter08

class Circle (val r : Double) extends Shape {

  override def square(): Double = scala.math.Pi * r * r

}
