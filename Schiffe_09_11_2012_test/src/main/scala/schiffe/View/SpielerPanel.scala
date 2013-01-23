package schiffe.View
import scala.swing._
import scala.swing.event._
import schiffe.Controller.Controller
import schiffe.Model.Zelle
import schiffe.Controller.CellChanged
import scala.swing.Button
import schiffe.View.SchiffPanel
import schiffe.View.SchiffPanel

class SpielerPanel(controller: Controller, size: Int, schiffPanel: SchiffPanel, computercells: PCPanel) extends GridPanel(size, size) {

  listenTo(schiffPanel)
   var anzahlGesetzteSchiffe = 0
  var schiffGesetzt = false
  var spielSize = size
  var schiffLaenge = 0
  var startButtonGesetzt = false
  var richtungButtonGesetzt = false
  var startReihe = 0
  var startSpalte = 0
  var richtung = 0
  

  val InitialfarbeSpieler = new Color(200, 200, 255)
  val Schiffgesetzt = new Color(192, 255, 192)
  val Schiffgetroffen = new Color(190, 245, 170)
  val SchiffNichtgetroffen = new Color(150, 160, 162)

  var alleButtons = Array.ofDim[Button](size, size)
  reactions += {
    case e: SetSchiff => {
      schiffLaenge = e.laenge

    }
  }

  def getZelle(reihe: Int, spalte: Int): Zelle = {

    return controller.cell(reihe, spalte)
  }
  var reihe = 0
  var spalte = 0

  def button(a: Int, b: Int) = new Button {
    reihe = a
    spalte = b
    preferredSize = new Dimension(60, 60)

    background = java.awt.Color.GRAY

    reactions += {
      case e: CellChanged =>


        setBackground

      case ButtonClicked(buttons) =>

        if (startButtonSetzen(a, b, schiffPanel.aktuelleLaenge, spielSize) == true) {
          if (schiffGesetzt == true) {
            background = java.awt.Color.GREEN
            schiffPanel.aktuellerButton.visible_=(false)
            schiffGesetzt = false
            setBackground
          } else {
            background = java.awt.Color.RED
            preferredSize_=(new Dimension(60, 60))

          }
        } else {
          setBackground
        }

    }
    listenTo(controller)

  }

  def createButtons {

    contents.clear()
    background = java.awt.Color.BLACK

    for (m <- 0 to (alleButtons.length - 1)) {
      for (n <- 0 to (alleButtons.length - 1)) {

        var buttons = button(m, n)

        alleButtons(m)(n) = buttons
        contents += buttons

      }

    }

  }
  createButtons
  def setSize(newSize: Int) = {
    alleButtons = Array.ofDim[Button](newSize, newSize)
    spielSize = newSize

    spielSize = newSize

  }
  def redraw = {

    contents.clear()
    alleButtons = Array.ofDim[Button](spielSize, spielSize)
    createButtons
  
    repaint


  }
  def setAlleButtonSize(anzahl: Int) = {

    alleButtons = Array.ofDim[Button](anzahl, anzahl)
    createButtons

  }
  def setBackground = {
    while (alleButtons.length != controller.feld.zellen.length) {
      setAlleButtonSize(controller.feld.zellen.length)
    }

    for (k <- 0 to (alleButtons.length - 1)) {
      for (l <- 0 to (alleButtons.length - 1)) {

        if (getZelle(k, l).getGesetzt == true) {
          if (getZelle(k, l).getGetroffen == true) {
            alleButtons(k)(l).background = java.awt.Color.RED
          } else {
            alleButtons(k)(l).background = java.awt.Color.GREEN
          }
        } else {
          if (getZelle(k, l).getGetroffen == true) {
            alleButtons(k)(l).background = java.awt.Color.BLACK
          } else {
            alleButtons(k)(l).background = java.awt.Color.GRAY
          }

        }
      }
    }

  }
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
   anzahlGesetzteSchiffe = anzahlGesetzteSchiffe+1
                 controller.feld.zellen.length match{
          case 2 =>
            if(anzahlGesetzteSchiffe == 1){controller.setFeldGesetzt(true)
//              computercells.pcSchiffeSetzen(controller.feld.zellen.length)
//              publish(new CellChanged)
            }
          case 5 =>
            if(anzahlGesetzteSchiffe == 3){
              controller.setFeldGesetzt(true)
//              computercells.pcSchiffeSetzen(controller.feld.zellen.length)
//              publish(new CellChanged)
            }
          case 10 =>
            if(anzahlGesetzteSchiffe == 10){controller.setFeldGesetzt(true)
//              computercells.pcSchiffeSetzen(controller.feld.zellen.length)
//              publish(new CellChanged)
            }
        }
    if (controller.set(laenge, reihe, spalte, richtung, (groesse - 1)) == true) {

      
      setBackground
      richtungButtonGesetzt = false
      startButtonGesetzt = false
      schiffGesetzt = true
      return true
    } else {
      return false
    }

  }
}

