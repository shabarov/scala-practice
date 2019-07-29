package chapter08

class CheckingAccount(initialBalance : Double) extends BankAccount(initialBalance) {
  override def deposit(amount: Double): Double = {
    super.deposit(amount - 1)
  }

  override def withdraw(amount: Double): Double = super.withdraw(amount - 1)
}
