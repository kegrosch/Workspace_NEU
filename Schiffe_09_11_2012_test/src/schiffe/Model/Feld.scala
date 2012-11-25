package schiffe.Model

import scala.math.sqrt
import scala.util.Random

class Feld(anzahl: Int) {
  require(List(2, 5, 10).contains(anzahl))
  var zellen = Array.ofDim[Zelle](anzahl, anzahl)
  
  var anzahlZellen = anzahl*anzahl-1
  var spielfertig = false
  var zaehlerhit =0 

 //Zellen generieren
 
  for(i <- 0 to anzahl-1){
    for(j <- 0 to anzahl-1){
      zellen(i)(j) = new Zelle(i,j)
      
    }
  }

def reset: Feld = new Feld(size); 
def solve: Feld = {
for(i <- 0 to anzahl-1){
    for(j <- 0 to anzahl-1){
      zellen(i)(j).open = true
      
    }
  }
return this
}
val size = sqrt(zellen.size).toInt

def zelle(reihe: Int, spalte: Int) = (reihe, spalte)

def hit(reihe: Int, spalte: Int):Boolean = {
  if(zellen(reihe-1)(spalte-1).getOpen==false & reihe <=anzahl-1 & spalte <= anzahl -1){
    zellen(reihe-1)(spalte-1).open=true
    if(zellen(reihe-1)(spalte-1).getGesetzt==true )
      zaehlerhit = zaehlerhit +1 
    return true
  }
  else
    return false
}
def zellegetroffen(reihe: Int, spalte: Int): Boolean={
  if(zellen(reihe-1)(spalte-1).getOpen==true & zellen(reihe-1)(spalte-1).getGesetzt==true)
    return true
    else return false
    }
//def spielfertig{
//  if(anzahl==2 & zaehlerhit==2){
//    spielfertig= true
//  }
//  if(anzahl==5 & zaehlerhit==9){
//    spielfertig= true
//  }
//  if(anzahl==10 & zaehlerhit==30){
//    spielfertig= true
//  }
//    
//}

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