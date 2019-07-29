package chapter09

import java.io.{File, PrintWriter}

import scala.io.{Source}

object Main extends App {

  //ex01
  def reverseFileLines(pathToReadFile : String, pathToWriteFile : String) : Unit = {
    val source = Source.fromResource(pathToReadFile)
    val writer = new PrintWriter(new File(pathToWriteFile))
    try {
      val lines = source.getLines().toArray.reverse
      for (l <- lines) {
        writer.println(l)
      }
    } finally {
      writer.close()
      source.close()
    }
  }

  reverseFileLines("ch09ex01R.txt", "/tmp/scala_horstman_temp/ch09ex01W.txt")

}
