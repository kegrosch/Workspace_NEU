package schiffe.Controller
import schiffe.Model._
import schiffe.util._

class Controller (var feld: Feld) extends Observable{
  
//  def available(row: Int, col: Int) = feld.available(row, col)
  def zelle(row: Int, col: Int) = feld.zelle(row, col)
//  def createRandom={
//    feld = feld.createRandom(grid.size)
//    notifyObservers
//  }
//  def parseFromString(s:String) = {
//    feld = feld.parseFromString(s)
//    notifyObservers
//  }
//  def reset = {
//    feld = feld.reset
//    notifyObservers
//  }
  def setSize(newSize: Int) = {
    feld = new Feld(newSize)
    notifyObservers
  }
  def set(row: Int, col: Int, value: Int) = {
    feld = feld.set(row, col, value)
    notifyObservers
  }
//  def solve = {
//    val (success, g) = feld.solve
//    feld = g  
//    notifyObservers
//    (success, Feld.steps)
//  }
//  def valid = feld.valid

//  	def set
  

}