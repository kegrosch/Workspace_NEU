package schiffe.View
import scala.swing._
import scala.swing.event._
import schiffe.Controller.Controller
import schiffe.Model.Zelle

class SpielerPanel(controller: Controller, size: Int) {
  var spielSize = size
  var startButtonGesetzt = false

  var richtungButtonGesetzt = false
  var startReihe = 0
  var startSpalte = 0
  var richtung = 0
  var userFeld = new GridPanel(_,_)

  val InitialfarbeSpieler = new Color(200, 200, 255)
  val Schiffgesetzt = new Color(192, 255, 192)
  val Schiffgetroffen = new Color(190, 245, 170)
  val SchiffNichtgetroffen = new Color(150, 160, 162)
  var buttons = Array.ofDim[Button](size, size)
  def getZelle(reihe: Int, spalte: Int): Zelle = controller.cell(reihe, spalte)

  def spielfeld(size: Int): GridPanel = {

    var userFeld = new GridPanel(spielSize, spielSize) {
      background = java.awt.Color.BLACK
      for (i <- 0 to (spielSize - 1)) {
        for (j <- 0 to (spielSize - 1)) {
          buttons(i)(j) = new Button {

            if (((controller.feld.zellen(i)(j).getGesetzt == true))) {
              background = Schiffgesetzt
              preferredSize_=(new Dimension(60, 60))
            } else {
              background = InitialfarbeSpieler
              preferredSize_=(new Dimension(60, 60))
            }
            reactions += {
              case ButtonClicked(buttons) =>
                if (startButtonSetzen(i, j, 3, spielSize) == true) {
                  background = java.awt.Color.RED
                  preferredSize_=(new Dimension(60, 60))
                }
            }

          }
          contents += buttons(i)(j)

        }
        repaint
      }

      def redraw(newSize: Int) = {
        contents.clear()

      }
    }
return userFeld
  }
  def setSize(newSize: Int) = {
    spielSize = newSize
    spielfeld(newSize)
    spielSize = newSize
    spielfeld(newSize).repaint()

  }
  def redraw(newSize: Int) = {

    spielSize = newSize
    spielfeld(newSize).repaint()
    for (i <- 0 to (newSize - 1)) {
      for (j <- 0 to (newSize - 1)) {
        setBackground(buttons(i)(j), i, j)
       
      }
    }
//    spielfeld(newSize).redraw(newSize)

    this.spielfeld(newSize).repaint()

  }

  def setBackground(button: Button, reihe: Int, spalte: Int) {

    if (controller.feld.zellen(reihe)(spalte).getGesetzt == true) {
      println("GESETZT")
      buttons(reihe)(spalte).background_=(java.awt.Color.RED)
      buttons(reihe)(spalte).preferredSize_=(new Dimension(60, 60))

    } else {
      println(" NICHT GESETZT")
      buttons(reihe)(spalte).background_=(java.awt.Color.WHITE)
      buttons(reihe)(spalte).preferredSize_=(new Dimension(60, 60))
    }
    buttons(reihe)(spalte).repaint()
  }
  def startButtonSetzen(reihe: Int, spalte: Int, laenge: Int, groesse: Int): Boolean = {

    if (startButtonGesetzt == true) {
      richtungButtonGesetzt = true
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
          return false
        } else {
          if (spalte > startSpalte) { //schiff geht nach rechts
            richtung = 2
          } else { //schiff geht nach links
            richtung = 3
          }
        }

      }
      if ((schiffeSetzen(reihe, spalte, richtung, laenge, groesse)) == true) {
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
    if (controller.set(laenge, reihe + 1, spalte + 1, richtung, (groesse - 1)) == true) {

      richtungButtonGesetzt = false
      startButtonGesetzt = false
      return true
    } else {
      return false
    }

  }
}
//var buttons = Array.ofDim[Button](size, size)
//def myCell = controller.cell(row, column)
//
//val cellButton = new Button {
//  preferredSize_=(new Dimension(60,60))
//  opaque=true
//  background = if (myCell.getGesetzt & myCell.getGetroffen) Schiffgetroffen
//  else {
//    if(!myCell.getGesetzt & myCell.getGetroffen)
//    SchiffNichtgetroffen
//    else {
//      if(myCell.getGesetzt & !myCell.getGetroffen)
//        Schiffgesetzt
//        else InitialfarbeSpieler
//    }
//  }
//  
//  }
//  contents += cellButton
//  listenTo(cellButton)
// def redraw = {
//  
//
//    repaint
//  }
// def setBackground(p: Panel) = p.background = if (myCell.getGesetzt & myCell.getGetroffen) Schiffgetroffen
//  else if(!myCell.getGesetzt & myCell.getGetroffen)
//    SchiffNichtgetroffen
//    else if(myCell.getGesetzt & !myCell.getGetroffen)
//        Schiffgesetzt
//        else InitialfarbeSpieler
//    
//  }