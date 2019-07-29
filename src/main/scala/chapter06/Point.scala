package chapter06

class Point (val x : Int, val y : Int) {

}

object Point {
  def apply(x: Int, y: Int): Point = new Point(x, y)
}
