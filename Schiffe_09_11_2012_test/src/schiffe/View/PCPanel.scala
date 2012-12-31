package schiffe.View
import scala.swing._
import scala.swing.event._
import schiffe.Controller.Controller
import schiffe.Model.Zelle

class PCPanel (pccontroller: Controller, size: Int){
var spielSize = size
val InitialfarbeComputer = new Color(224, 224, 255)
val Schiffgetroffen = new Color(190, 245, 170)
val SchiffNichtgetroffen = new Color(150, 160, 162)
var buttons = Array.ofDim[Button](size, size)
def getZelle(reihe: Int, spalte: Int): Zelle = pccontroller.cell(reihe, spalte)

def spielfeld(size: Int, spielSize: Int) = new GridPanel(spielSize, spielSize){
  
  background = java.awt.Color.BLACK
  for(i <- 0 to (spielSize-1)){
    for(j <- 0 to (spielSize-1)){
      buttons(i)(j) = new Button{
        background = InitialfarbeComputer
        preferredSize_=(new Dimension(60,60))
      }
        contents += buttons(i)(j)
      
    }
  }  
    repaint
  }
def setSize(newSize: Int) ={
  spielSize = newSize
  spielfeld(newSize, spielSize)
  
  
}
def redraw ={
//  spielSize = newSize
  spielfeld(spielSize, spielSize).repaint()
  
  
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
