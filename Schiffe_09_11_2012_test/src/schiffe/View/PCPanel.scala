package schiffe.View
import scala.swing._
import scala.swing.event._
import schiffe.Controller.Controller
import schiffe.Model.Zelle
import schiffe.Controller.CellChanged


class PCPanel(pccontroller: Controller, size: Int, controller: Controller) extends GridPanel(size, size) {
  var spielSize = size
  val InitialfarbeComputer = new Color(224, 224, 255)
  val Schiffgetroffen = new Color(190, 245, 170)
  val SchiffNichtgetroffen = new Color(150, 160, 162)
  //var buttons = Array.ofDim[Button](size, size)
  var alleButtons = Array.ofDim[Button](size, size)
  def getZelle(reihe: Int, spalte: Int): Zelle = pccontroller.cell(reihe, spalte)

  var reihe = 0
  var spalte = 0

  def button(a: Int, b: Int) = new Button {
    reihe = a
    spalte = b
    preferredSize = new Dimension(60, 60)
    background = java.awt.Color.GRAY

    reactions += {
      case CellChanged =>
        setBackground

      case ButtonClicked(buttons) =>
        pccontroller.hit(a + 1, b + 1)
        pcHit
        setBackground

    }
    listenTo(pccontroller)

  }
  def pcHit = {
    var pcHit = false
    while (pcHit == false) {

      var startReihe = scala.util.Random.nextInt(controller.feld.zellen.length) + 1
      var startSpalte = scala.util.Random.nextInt(controller.feld.zellen.length) + 1
      if (controller.feld.zellen(startReihe - 1)(startSpalte - 1).getGetroffen == false) {
        controller.hit(startReihe, startSpalte)
        pcHit = true

      } else {
        pcHit = false
      }

    }
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

    //pcSchiffeSetzen(alleButtons.length)
  }

  createButtons
  def setSize(newSize: Int) = {
    alleButtons = Array.ofDim[Button](newSize, newSize)
    spielSize = newSize
    //    pcSchiffeSetzen(alleButtons.length)

  }

  def redraw = {

    contents.clear()
    alleButtons = Array.ofDim[Button](spielSize, spielSize)
    createButtons
    //pcSchiffeSetzen(alleButtons.length)
    repaint

  }
  def setAlleButtonSize(anzahl: Int) = {

    alleButtons = Array.ofDim[Button](anzahl, anzahl)

    createButtons

  }
  //def spielfeld(size: Int, spielSize: Int) = new GridPanel(spielSize, spielSize){
  //  
  //  background = java.awt.Color.BLACK
  //  for(i <- 0 to (spielSize-1)){
  //    for(j <- 0 to (spielSize-1)){
  //      buttons(i)(j) = new Button{
  //        background = InitialfarbeComputer
  //        preferredSize_=(new Dimension(60,60))
  //            reactions += {
  //      case CellChanged =>
  //        
  //
  //        setBackground
  //
  //      case ButtonClicked(buttons) =>
  //
  //        pccontroller.hit(i+1,j+1)
  //
  //    }
  //    listenTo(pccontroller)
  //
  //  }
  //      
  //        contents += buttons(i)(j)
  //      
  //    }
  //  }  
  //    repaint
  //  }
  //def setSize(newSize: Int) ={
  //  spielSize = newSize
  //  spielfeld(newSize, spielSize)
  //  
  //  
  //}
  //def redraw ={
  ////  spielSize = newSize
  //  spielfeld(spielSize, spielSize).repaint()
  //  
  //  
  //}
  def pcSchiffeSetzen(size: Int) = {
    println("dddddddddd")
    size match {

      case 2 => pccontroller.setcomputerschiff2
      case 5 => pccontroller.setcomputerschiff5
      case 10 => pccontroller.setcomputerschiff10
    }
  }
  def setBackground = {
    while (alleButtons.length != pccontroller.feld.zellen.length) {
      setAlleButtonSize(pccontroller.feld.zellen.length)
    }
    //        println("BUTTONS: " + alleButtons.length)
    for (k <- 0 to (alleButtons.length - 1)) {
      for (l <- 0 to (alleButtons.length - 1)) {
        //        println("K: " + k)
        //        println("L: "+ l)
        if (getZelle(k, l).getGesetzt == true) {
          if (getZelle(k, l).getGetroffen == true) {
            alleButtons(k)(l).background = java.awt.Color.RED
          } else {
            alleButtons(k)(l).background = java.awt.Color.GRAY
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

  //def setBackground = {
  //    while (alleButtons.length != controller.feld.zellen.length) {
  //      setAlleButtonSize(controller.feld.zellen.length)
  //    }
  //    //    println("BUTTONS: " + alleButtons.length)
  //    for (k <- 0 to (alleButtons.length - 1)) {
  //      for (l <- 0 to (alleButtons.length - 1)) {
  //        //        println("K: " + k)
  //        //        println("L: "+ l)
  //        if (getZelle(k, l).getGesetzt == true) {
  //          if (getZelle(k, l).getGetroffen == true) {
  //            alleButtons(k)(l).background = java.awt.Color.RED
  //          } else {
  //            alleButtons(k)(l).background = java.awt.Color.GREEN
  //          }
  //        } else {
  //          if (getZelle(k, l).getGetroffen == true) {
  //            alleButtons(k)(l).background = java.awt.Color.BLACK
  //          } else {
  //            alleButtons(k)(l).background = java.awt.Color.GRAY
  //          }
  //
  //        }
  //      }
  //    }
  //
  //  }
  //val cellButton = new Button {
  //  preferredSize_=(new Dimension(60,60))
  //  opaque=true
  //  background = if (myCell.getGesetzt & myCell.getGetroffen) Schiffgetroffen
  //  else {
  //    if(!myCell.getGesetzt & myCell.getGetroffen)  SchiffNichtgetroffen
  //     else InitialfarbeComputer
  //    
  //  }
  //}
  // contents += cellButton
  //  listenTo(cellButton)
  // 
  // def redraw = {
  // 
  //    
  //    repaint
  //  }
  // def setBackground(p: Panel) = p.background = if (myCell.getGetroffen && !myCell.getGesetzt) SchiffNichtgetroffen
  //  else if (myCell.getGetroffen && myCell.getGesetzt) Schiffgetroffen
  //  else InitialfarbeComputer

}
