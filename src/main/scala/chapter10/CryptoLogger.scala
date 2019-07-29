package chapter10

class CryptoLogger extends Logger {

  var key : Int = 3

  def this(key : Int) {
    this()
    this.key = key
  }

  override def log(message: String): Unit = {
    //message.map(c => (c + key).toChar)
    println(for (c <- message) yield (c + key).toChar)
  }
}
