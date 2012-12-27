package schiffe.View
import scala.swing._
import scala.swing.event._
import schiffe.Controller.Controller
import schiffe.Model.Zelle

class SpielerPanel (controller: Controller, size: Int){
  var spielSize = size

val InitialfarbeSpieler = new Color(200, 200, 255)
val Schiffgesetzt = new Color(192, 255, 192)
val Schiffgetroffen = new Color(190, 245, 170)
val SchiffNichtgetroffen = new Color(150, 160, 162)
var buttons = Array.ofDim[Button](size, size)
def getZelle(reihe: Int, spalte: Int): Zelle = controller.cell(reihe, spalte)

def spielfeld(size: Int) = new GridPanel(spielSize, spielSize){
background = java.awt.Color.BLACK
  for(i <- 0 to (spielSize-1)){
    for(j <- 0 to (spielSize-1)){
      buttons(i)(j) = new Button{
        background = InitialfarbeSpieler
        preferredSize_=(new Dimension(60,60))
      }
        contents += buttons(i)(j)
      
    }
  }  
    repaint
  }
def setSize(newSize: Int) ={
  spielSize = newSize
  spielfeld(newSize)
  
  
}
def redraw(newSize: Int) ={
  spielSize = newSize
  spielfeld(newSize).repaint()
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