package chapter05

class BankAccount {
  private var balance = 0 : BigDecimal
  def deposit(v : BigDecimal): Unit = {
    balance += v
  }

  def withdraw(v : BigDecimal) : Unit = {
    if (balance < v) {
      throw new IllegalArgumentException("Balance is not enough")
    }
    balance -= v
  }

  def current: BigDecimal = balance

  override def toString: String = "Bank Account = " + balance
}
