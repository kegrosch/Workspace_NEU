package schiffe.Model

class Zelle (row: Int, col: Int){
  
  var gesetzt= false
  var reihe = row
  var spalte = col
  
 def setzen (inhalt: Boolean){
  gesetzt = inhalt
  
  }
  
  def getReihe: Int = reihe
  def getSpalte: Int = spalte
  def getGesetzt: Boolean = gesetzt
  
  
//  def equals(that:Zelle) = this.value == that.value
//  def ==(v: Int) = if (value == v) true else false
//  def isSet = value != 0
//  override def toString = gesetzt.toString.replace('0', ' ')

}