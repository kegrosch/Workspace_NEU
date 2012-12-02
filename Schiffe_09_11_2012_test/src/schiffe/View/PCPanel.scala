package schiffe.View
import scala.swing._
import scala.swing.event._
import schiffe.Controller.Controller

class PCPanel (row: Int, column: Int, pccontroller: Controller) extends FlowPanel {
val InitialfarbeComputer = new Color(224, 224, 255)
val Schiffgetroffen = new Color(190, 245, 170)
val SchiffNichtgetroffen = new Color(150, 160, 162)
def myCell = pccontroller.cell(row, column)

val cellButton = new Button {
  preferredSize_=(new Dimension(60,60))
  opaque=true
  background = if (myCell.getGesetzt & myCell.getGetroffen) Schiffgetroffen
  else {
    if(!myCell.getGesetzt & myCell.getGetroffen)
    SchiffNichtgetroffen
     else InitialfarbeComputer
    
  }
}
}