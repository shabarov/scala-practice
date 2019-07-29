package chapter05

import scala.beans.BeanProperty

class Student {
  @BeanProperty
  var name : String = ""
  @BeanProperty
  var id : Long = 0L

}
