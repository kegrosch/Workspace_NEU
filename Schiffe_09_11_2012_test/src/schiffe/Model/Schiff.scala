package schiffe.Model

class Schiff (val cs: Vector[Zelle]) {
  def zelle(index: Int) = cs(index)
  def toIntSet:Set[Int] = cs.filterNot(_.value==0).map(_.value).toSet
  def toIntList:List[Int] = cs.filterNot(_.value==0).map(_.value).toList
  def valid = this.toIntList == this.toIntSet.toList 



}