package code
package snippet

import net.liftweb.http.SHtml
import net.liftweb.http.js.JsCmd
import net.liftweb.util.Helpers._
import scala.xml.NodeSeq
import scala.xml.Group
import _root_.net.liftweb.http.SHtml._
import scala.xml.Text
import net.liftweb.util.Log
import net.liftweb.http.js.JsCmds.SetHtml
import net.liftweb.http.js.JsCmds.Alert
import schiffe.Schiffe


object SchiffeSetzen {
     var anzahlGesetzteSchiffe = 0
  var schiffGesetzt = false
  var startButtonGesetzt = false
  var richtungButtonGesetzt = false
    var startReihe = 0
  var startSpalte = 0
  var richtung = 0
  
    def render = SHtml.onSubmit(s => {
//    SchiffeSetzen ! s
//    SetValById("chat_in", "")
  })
  
    def neuStarten(reihe: Int, spalte:Int, laenge: Int, groesse:Int) = SHtml.onSubmit(s =>{
    startButtonSetzen(reihe, spalte, laenge, groesse)
  })
 def startButtonSetzen(reihe: Int, spalte: Int, laenge: Int, groesse: Int): Boolean = {

    if (startButtonGesetzt == true) {
      richtungButtonGesetzt = true

      if (reihe < startReihe - 1 || reihe > startReihe + 1) {
        richtungButtonGesetzt = false
        return false
      } else {
        if (spalte < startSpalte - 1 || spalte > startSpalte + 1) {
            richtungButtonGesetzt = false
            return false
          } else {
        if (spalte == startSpalte) {

          if (reihe == startReihe) {
            return false
          } else {
            if (reihe > startReihe) { //schiff geht nach unten
              richtung = 1
            } else { //schiff geht nach oben
              richtung = 0
            }
          }

        } else {
          
            if (reihe == startReihe) {

              if (spalte > startSpalte) { //schiff geht nach rechts
                richtung = 2
              } else { //schiff geht nach links
                richtung = 3
              }
            } else {
              if (spalte > startSpalte) { //schiff geht nach rechts
                richtung = 2
              } else { //schiff geht nach links
                richtung = 3
              }
            }
          }
        }
      }

      if ((schiffeSetzen(startReihe+1, startSpalte+1, richtung, laenge, groesse)) == true) {
        anzahlGesetzteSchiffe = anzahlGesetzteSchiffe+1
        groesse match{
          case 2 =>
            if(anzahlGesetzteSchiffe == 1){Schiffe.controller.setFeldGesetzt(true)
             pcSchiffeSetzen(Schiffe.controller.feld.zellen.length)
            }
          case 5 =>
            if(anzahlGesetzteSchiffe == 3){
              Schiffe.controller.setFeldGesetzt(true)
              pcSchiffeSetzen(Schiffe.controller.feld.zellen.length)
            }
          case 10 =>
            if(anzahlGesetzteSchiffe == 10){Schiffe.controller.setFeldGesetzt(true)
              pcSchiffeSetzen(Schiffe.controller.feld.zellen.length)
            }
        }
        
        return true
      } else {
        return false
      }

    } else {

      startReihe = reihe
      startSpalte = spalte
      startButtonGesetzt = true
      return true
    }

  }

  def schiffeSetzen(reihe: Int, spalte: Int, richtung: Int, laenge: Int, groesse: Int): Boolean = {
  
    if (Schiffe.controller.set(laenge, reihe, spalte, richtung, (groesse - 1)) == true) {

//      setBackground
      richtungButtonGesetzt = false
      startButtonGesetzt = false
      schiffGesetzt = true
      return true
    } else {
      return false
    }

  }

  def pcSchiffeSetzen(size: Int) = {
//    println("dddddddddd")
    size match {

      case 2 => Schiffe.pccontroller.setcomputerschiff2
      case 5 => Schiffe.pccontroller.setcomputerschiff5
      case 10 => Schiffe.pccontroller.setcomputerschiff10
      
//      publish(CellChanged)
    }
  }
  
}