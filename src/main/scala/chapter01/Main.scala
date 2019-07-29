package chapter01

import scala.util.Random
import scala.math.abs
import scala.language.postfixOps

object Main extends App {

  // ex8
  val a = BigInt(abs(Random.nextInt()))
  println("New random dir name = " + a.toString(36))
  println("One more rand name = " + BigInt.probablePrime(100, Random).toString(36))

  // ex9
  private val str = "Some string"
  println("First char = " + str(0))
  println("First char = " + (str charAt 0))
  println("First char = " + (str head))
  println("Last char = " + (str last))
  println("Last char = " + str.charAt(str.length - 1))

  // ex10
  println("First 3 characters = " + str.take(3))
  println("Right 3 characters = " + str.takeRight(3))
  println("Drop 3 characters = " + str.drop(3))
  println("Drop right 3 characters = " + str.dropRight(3))

}
