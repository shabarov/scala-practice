package chapter05

object Main extends App {

  //Ex02
  val ba = new BankAccount
  ba.deposit(1000)
  ba.withdraw(100)
  println(ba)
  println(ba.current)

  private val student = new Student
  var name = student.getName
  student.setName("qqq")

  var me = new Employee(123)

}
