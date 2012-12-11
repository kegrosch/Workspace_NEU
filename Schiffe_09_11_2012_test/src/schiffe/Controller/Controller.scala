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
  var feldGesetzt = false
  def getFeldGesetzt() :Boolean={
    return feldGesetzt
  }
  def setFeldGesetzt(gesetzt:Boolean) ={
    this.feldGesetzt =gesetzt
  }
  def reset = {
    feld = feld.reset
    feldGesetzt = false
   alleGesetzt = false
   zaehlerAlleGesetzt = 0
   zaehlerGesetzt = 0
  schiffGesetzt = false
    statusText="Spiel zur�ckgesetzt"
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

def setcomputerschiff2={
  while (getFeldGesetzt == false) {
              var startReihe = scala.util.Random.nextInt(2 - 1) + 1
              var startSpalte = scala.util.Random.nextInt(2 - 1) + 1
              var ersteZelle = feld.cell(startReihe,startSpalte)

              if (set(2, startReihe, startSpalte, 5, (getSize - 1)) == true) {
                setFeldGesetzt(true)
                 statusText= "Computerschiffe gesetzt"
              } else {
               setFeldGesetzt(false)
                
              }

            }
}
  var alleGesetzt = false
  var zaehlerAlleGesetzt = 0
  var zaehlerGesetzt = 0
  var schiffGesetzt = false
  def setcomputerschiff5= {
           
            while (alleGesetzt == false) {
              //Schiffe f�r Computer setzen
              
              while (schiffGesetzt == false) {
                if (zaehlerGesetzt >= 10) {
                  schiffGesetzt = true
                }
                var startReihe = scala.util.Random.nextInt(5 - 1) + 1
                var startSpalte = scala.util.Random.nextInt(5 - 1) + 1
                var ersteZelle = feld.cell(startReihe, startSpalte)

                if (set(4, startReihe, startSpalte, 5, (getSize - 1)) == true) {
                  schiffGesetzt = true
                  zaehlerAlleGesetzt = zaehlerAlleGesetzt + 1
                } else {
                  schiffGesetzt = false
                  zaehlerGesetzt = zaehlerGesetzt + 1
                }
                
              }

              schiffGesetzt = false
              zaehlerGesetzt = 0

              while (schiffGesetzt == false) {
                if (zaehlerGesetzt >= 50) {
                  schiffGesetzt = true
                }
                var startReihe = scala.util.Random.nextInt(5 - 1) + 1
                var startSpalte = scala.util.Random.nextInt(5 - 1) + 1
                var ersteZelle = feld.cell(startReihe,startSpalte)

                if (set(3, startReihe, startSpalte, 5, (getSize - 1)) == true) {
                  schiffGesetzt = true
                  zaehlerAlleGesetzt = zaehlerAlleGesetzt + 1

                } else {
                  schiffGesetzt = false
                  zaehlerGesetzt = zaehlerGesetzt + 1

                }
                
              }
              schiffGesetzt = false
              zaehlerGesetzt = 0

 
               zaehlerGesetzt = 0

                while (schiffGesetzt == false) {
                  if (zaehlerGesetzt >= 50) {
                    schiffGesetzt = true
                  }else{
                  var startReihe = scala.util.Random.nextInt(5 - 1) + 1
                  var startSpalte = scala.util.Random.nextInt(5 - 1) + 1
                  var ersteZelle = feld.cell(startReihe, startSpalte)

                  if (set(2, startReihe, startSpalte, 5, (getSize - 1)) == true) {
                    schiffGesetzt = true
                    zaehlerAlleGesetzt = zaehlerAlleGesetzt + 1

                  } else {
                    schiffGesetzt = false
                    zaehlerGesetzt = zaehlerGesetzt + 1

                  }
                  }
                }
                schiffGesetzt = false
             
              if (zaehlerAlleGesetzt == 3) {

                alleGesetzt = true
                statusText= "Computerschiffe gesetzt"
                setFeldGesetzt(true)
              }else{

                reset
               
               alleGesetzt = false
               
              }
            }
  }
  def setcomputerschiff10{
    while (alleGesetzt == false) {
      while (schiffGesetzt == false) {
              if (zaehlerGesetzt >= 10) {
                  schiffGesetzt = true
                }
              var startReihe = scala.util.Random.nextInt(10 - 1) + 1
              var startSpalte = scala.util.Random.nextInt(10 - 1) + 1
              var ersteZelle = feld.cell(startReihe,startSpalte)

              if (set(5, startReihe, startSpalte, 5, (getSize - 1)) == true) {
                schiffGesetzt = true
                zaehlerAlleGesetzt = zaehlerAlleGesetzt + 1
//                println("SCHIFF-5-OKAY")

              } else {
                schiffGesetzt = false
                zaehlerGesetzt = zaehlerGesetzt + 1

//                println("SCHIFF-5-SCHLECHT")
                println(zaehlerGesetzt)
              }
            }
            zaehlerGesetzt = 0
            schiffGesetzt = false
            for (k <- 1 to 2) {
              
              while (schiffGesetzt == false) {
                if (zaehlerGesetzt >= 50) {
                  schiffGesetzt = true
                }else{
                var startReihe = scala.util.Random.nextInt(10 - 1) + 1
                var startSpalte = scala.util.Random.nextInt(10 - 1) + 1
                var ersteZelle = feld.cell(startReihe, startSpalte)

                if (set(4, startReihe, startSpalte, 5, (getSize - 1)) == true) {
                  schiffGesetzt = true
                  zaehlerAlleGesetzt = zaehlerAlleGesetzt + 1
//                  println("SCHIFF-4-OKAY")
                } else {
                  schiffGesetzt = false
                  zaehlerGesetzt = zaehlerGesetzt + 1
//                  println("SCHIFF-4-SCHLECHT")
                println(zaehlerGesetzt)

                }
              
              
                }
              }
              zaehlerGesetzt = 0
              schiffGesetzt = false
            }
zaehlerGesetzt = 0
            for (k <- 1 to 3) {

              while (schiffGesetzt == false) {
                if (zaehlerGesetzt >= 50) {
                  schiffGesetzt = true
                }else{
                var startReihe = scala.util.Random.nextInt(10 - 1) + 1
                var startSpalte = scala.util.Random.nextInt(10 - 1) + 1
                var ersteZelle = feld.cell(startReihe, startSpalte)

                if (set(3, startReihe, startSpalte, 5, (getSize - 1)) == true) {
                  schiffGesetzt = true
                  zaehlerAlleGesetzt = zaehlerAlleGesetzt + 1
//                  println("SCHIFF-3-OKAY")
                } else {
                  schiffGesetzt = false
                  zaehlerGesetzt = zaehlerGesetzt + 1
//                  println("SCHIFF-3-SCHLECHT")
                println(zaehlerGesetzt)
                }

              
              
              
                }
              }
              schiffGesetzt = false
              
              zaehlerGesetzt = 0
            }
zaehlerGesetzt = 0
            for (k <- 1 to 4) {

              while (schiffGesetzt == false) {
                if (zaehlerGesetzt >= 50) {
                  schiffGesetzt = true
                }else{
                var startReihe = scala.util.Random.nextInt(10 - 1) + 1
                var startSpalte = scala.util.Random.nextInt(10 - 1) + 1
                

                if (set(2, startReihe, startSpalte, 5, (getSize - 1)) == true) {

                  schiffGesetzt = true
                  zaehlerAlleGesetzt = zaehlerAlleGesetzt + 1
                } else {
                  schiffGesetzt = false
                  zaehlerGesetzt = zaehlerGesetzt + 1
                }

              }
              
              }
              zaehlerGesetzt = 0
              schiffGesetzt = false
            }
zaehlerGesetzt = 0
if (zaehlerAlleGesetzt == 10) {

                alleGesetzt = true
                statusText= "Computerschiffe gesetzt"
                  setFeldGesetzt(true)
              }else{
//                println("RESET")
                reset
               
               alleGesetzt = false
               
              }
            }
    }
  
  
  
}
