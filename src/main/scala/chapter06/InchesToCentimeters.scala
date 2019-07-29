package chapter06

object InchesToCentimeters extends UnitConversions {
  override def convert(v: Double): Double = v * 1.5
}
