package schiffe.Model

import scala.math.sqrt
import scala.util.Random

class Feld(anzahl: Int) {
  var zellen = Array.ofDim[Zelle](anzahl, anzahl)
  
  var anzahlZellen = anzahl*anzahl-1

 //Zellen generieren
 
  for(i <- 0 to anzahl-1){
    for(j <- 0 to anzahl-1){
      zellen(i)(j) = new Zelle(i,j)
      
    }
  }
  

val size = sqrt(zellen.size).toInt

  def zelle(reihe: Int, spalte: Int) = (reihe, spalte)


  override def toString = {
    val lineseparator = ("+-" + ("--" * (anzahl/2))) *anzahl + "+\n"
    val line = ("|" + (" " * (anzahl/2))+("x"+(" " * (anzahl/2) ))) * anzahl + "|\n"
    var box = "\n" + (lineseparator + (line)) * anzahl + lineseparator
    for (reihe <- 0 to anzahl-1) {
      for(spalte <- 0 to anzahl-1){

      (box = box.replaceFirst("x", zellen(reihe)(spalte).gesetzt.toString()))
      (box = box.replaceFirst("false", " "))
      (box = box.replaceFirst("true", "X"))

    }
    }
    box
  }
}