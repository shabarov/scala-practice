package chapter11

class BitSequence(private var value : Long) {

  def this(stringValue : String) {
    this(Integer.parseInt(stringValue, 2))

  }

  def apply(bit : Int) : Int = if ((value & mask(bit)) > 0) 1 else 0

  def update(bit : Int, newValue : Int) : BitSequence = {
    if (newValue == 1) value |= mask(bit) else value &= ~mask(bit)
    this
  }

  private def mask(i : Int) : Long = 1L << i

  override def toString: String = //scala.runtime.RichLong.toBinaryString(value)
  java.lang.Long.toBinaryString(value)
}
