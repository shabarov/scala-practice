package chapter17

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Random, Success}

object Main extends App {

  //ex01
  val f = Future {
    Thread.sleep(1000)
    0
  }
  f.onComplete {
    case Success(v) => println(s"Success = $v")
    case Failure(exception) => println(exception.getMessage)
  }

  for (n1 <- Future {
    Thread.sleep(1000);
    2
  }; n2 <- Future {
    Thread.sleep(1000);
    40
  }) {
    println("Future sum result = " + (n1 + n2))
  }

  val f1 = Future {
    Thread.sleep(1000)
    10
  }

  val f2 = Future {
    Thread.sleep(1000)
    10
  }

  val res = f1.flatMap(n1 => f2.map(n2 => n1 + n2))

  doSomeWork()

  println(s"Future flatMap Result = $res")

  def doSomeWork(): Unit = {
    println("Doing some other work...")
    Thread.sleep(4000)
    println("Finish some work")
  }

  //ex02
  def f_(x: Int) = Future[String] {
    "" + x + "." + x
  }

  def g_(y: String) = Future[Double] {
    y.toDouble
  }

  val g_compose_f = doInOrder(f_, g_)
  g_compose_f(1).foreach(n => println(s"Composed result = ${n}"))

  doSomeWork()

  def doInOrder[T, U, V](f: (T) => Future[U], g: U => Future[V]): (T) => Future[V] = {
    (x: T) => {
      f(x) flatMap (q => g(q))
    }
  }

  //ex03
  def f3(x: String) = Future {
    x + "one! "
  }

  def f4(x: String) = Future {
    x + "two! "
  }

  def f5(x: String) = Future {
    x + "three!"
  }

  val compose_multiple = doInOrder2(f3, f4, f5)
  compose_multiple("start! ").foreach(n => println(s"Multiple composed result = ${n}"))

  doSomeWork()

  def doInOrder2[T](r: (T) => Future[T], f: ((T) => Future[T])*): (T) => Future[T] = {
    (x: T) => {
      var t = r(x)
      for (u <- f) t = t.flatMap(n1 => u(n1))
      t
    }
  }

  //ex05
  def f6(x: Int) = Future {
    x
  }

  def f7(x: Int) = Future {
    x
  }

  getFutureSequence(Seq(f6(1), f7(2))).foreach(n => println(s"Future sequence = ${n}"))

  def getFutureSequence[T](f: Seq[Future[T]]): Future[Seq[T]] = {
    Future.sequence(f)
  }

  //ex06
  val r = new Random()
  val repeatResult = repeat(() => {
    val next = r.nextInt(10); println(s"Next Int = ${next}"); Thread.sleep(1000); next
  }, (t: Int) => t > 5)
  repeatResult.foreach(n => println("Repeat res = " + n))

  doSomeWork()

  def repeat[T](action: () => T, until: T => Boolean): Future[T] = {
    Future {
      var res: T = null.asInstanceOf[T]
      while (!until({
        res = action(); res
      })) {}
      res
    }
  }

}
