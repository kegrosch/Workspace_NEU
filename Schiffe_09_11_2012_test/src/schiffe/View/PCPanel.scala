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
def redraw(newSize: Int) ={
  spielSize = newSize
  spielfeld(newSize, spielSize).repaint()
  
  
}


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
