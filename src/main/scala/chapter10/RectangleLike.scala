package chapter10

trait RectangleLike {
  def translate(x : Int, y: Int) : Unit = {
    //do something...
    println("Translate, X = " + getX)
  }
  def grow(x : Int, y : Int) : Unit = {
    //do something...
    println("Grow, Y = " + getY)
  }
  def getX: Double
  def getY: Double
}
