package schiffe.Controller
import schiffe.Model.Feld
import schiffe.util._
import schiffe.Model.Schiff
import schiffe.Model.Zelle

class Controller (var feld: Feld) extends Observable{
  
//  def available(row: Int, col: Int) = feld.available(row, col)
//  def zelle(row: Int, col: Int) = feld.zelle(row, col)
//  def createRandom={
//    feld = feld.createRandom(grid.size)
//    notifyObservers
//  }
//  def parseFromString(s:String) = {
//    feld = feld.parseFromString(s)
//    notifyObservers
//  }
  def reset = {
    feld = feld.reset
    notifyObservers
  }
  def solve ={
    field=field.solve
    notifyObservers
  }
  def hit:Boolean ={
    field=field.hit
    notifyObservers
  }
  def zellegetroffen: Boolean={
    field=field.zellegetroffen
    notifyObservers
  }
  def setSize(newSize: Int) = {
    feld = new Feld(newSize)
    notifyObservers
  }
   def spielfertig: Boolean= {
    feld = field.spielfertig
    notifyObservers
  }
  def set(laenge: Int, row: Int, col: Int, richtung: Int, groesse: Int):Boolean = {
    var startZelle = feld.zellen(row-1)(col-1)
    var schiff = new Schiff(laenge, startZelle, feld.zellen)
    var freiGesetzt = schiff.setzen(richtung, groesse)
    notifyObservers
    freiGesetzt
    
//    println("Schiff gesetzt")
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