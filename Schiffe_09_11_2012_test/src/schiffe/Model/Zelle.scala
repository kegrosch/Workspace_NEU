package schiffe.Model

class Zelle (val value: Int, val given: Boolean = false, val showCandidates: Boolean = false) {

  def equals(that:Zelle) = this.value == that.value
  def ==(v: Int) = if (value == v) true else false
  def isSet = value != 0
  override def toString = value.toString.replace('0', ' ')

}