package chapter11

import scala.math.Integral.Implicits._

object Main extends App {

  //ex07
  private val sequence = new BitSequence("10101")
  println("Bit # 5 = " + sequence.apply(4))
  println("Set bit # 2 = " + sequence.update(1, 1))
  println("Set bit # 1 = " + sequence.update(0, 0))

  println(long2BinaryString(9))

  def long2BinaryString(value: Long): String = {
    val sb = new StringBuilder()
    var buf : Long = value
    while (buf > 0) {
      val (q, r) = buf /% 2
      sb.append(r)
      buf = q
    }
    sb.toString().reverse
  }

}
