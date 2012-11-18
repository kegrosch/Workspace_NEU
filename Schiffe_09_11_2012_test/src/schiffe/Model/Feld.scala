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

  def set(reihe: Int, spalte: Int) = {
//   var feld = new Feld(anzahl)
    for(i <- 0 until anzahl-1){
      for(j <- 0 until anzahl-1)
      if(zellen(i)(j).getReihe == reihe){
//        println("REIHEEEEEEEEEEEEEEEEEE")
        if(zellen(i)(j).getSpalte==spalte){
      
        var zell = zellen(2)(2)
        var schiff = new Schiff(2, zell, zellen) 
        schiff.setzen
//        println("NNNNNNNNNNNN")
        
//        var feld = (zellen.updated(i, zell.gesetzt=true))
//        
//        return feld
        }
      
    
      }else{
//        feld
//        println("OOOOOOOOOOOOO")
      }
      
    }
//   println("PPPPPPPPPP")
//    feld
    
     
//    schiff.setzen
    
  
  
  
  
   
   
 
  }

  override def toString = {
    val lineseparator = ("+-" + ("-" * (anzahl))) *anzahl + "+\n"
    val line = ("| " + "x ") * anzahl + "|\n"
    var box = "\n" + (lineseparator + (line)) * anzahl + lineseparator
    for (reihe <- 0 to anzahl-1) {
      for(spalte <- 0 to anzahl-1){
//        if(zellen(reihe)(spalte).gesetzt == true){
//          box = box.replace()
//        }
      (box = box.replaceFirst("x ", zellen(reihe)(spalte).gesetzt.toString()))
//      (box = box.replaceAll("x ", zellen(reihe)(spalte).gesetzt.toString()))
      (box = box.replaceFirst("false", "     "))
//      (box = box.replaceAll("false", "  "))
      (box = box.replaceFirst("true", "  X  "))
//      (box = box.replaceAll("true", " X "))
    }
    }
    box
  }
}