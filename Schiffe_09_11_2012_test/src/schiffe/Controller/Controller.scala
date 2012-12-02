package schiffe.Controller
import schiffe.Model.Feld
import schiffe.util._
import schiffe.Model.Schiff
import schiffe.Model.Zelle
import scala.swing.Publisher
import scala.swing.event.Event
case class FeldResize(newSize:Int) extends Event

class Controller (var feld: Feld) extends Publisher{
  
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
  var statusText="Bitte setzen Sie Schiffe"
  def reset = {
    feld = feld.reset
    statusText="Spiel zurückgesetzt"
//    notifyObservers
  }
  def solve ={
    feld= feld.solve
//    notifyObservers
    statusText="Spiel beendet"
  }
  def hit(reihe: Int, spalte: Int): Boolean ={
    println("REIHE: " + reihe + " Spalte: " + spalte) 
    return feld.hit(reihe-1, spalte-1)
//    notifyObservers
  }

  def setSize(newSize: Int) = {
    feld = new Feld(newSize)
    publish(new FeldResize(newSize))
//    notifyObservers
  }
 def getSize: Int = feld.size.toInt
 def spielfertig: Boolean= {
    if(feld.spielFertig == true){
      return true
    }else{
      return false
    }
//    notifyObservers
  }
  def set(laenge: Int, row: Int, col: Int, richtung: Int, groesse: Int):Boolean = {
    var startZelle = feld.zellen(row-1)(col-1)
    var schiff = new Schiff(laenge, startZelle, feld.zellen)
    var freiGesetzt = schiff.setzen(richtung, groesse)
//    notifyObservers
    return freiGesetzt
    
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
  def updateFeld(feld: Feld){
    this.feld = feld
  }
  def cell(row: Int, col: Int) = feld.cell(row, col)

}