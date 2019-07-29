package chapter06

object Main extends App {

  //ex01
  println(Conversions.inchesToCentimeters(10))

  val a = 0x0000FF
  println(a.getClass.toString)
  println(a)

  val b = MyEnum.FIRST
  println(b.id)
  println(b.toString)


}
