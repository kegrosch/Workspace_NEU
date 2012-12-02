package schiffe.View
import scala.swing._
import scala.swing.event._
import schiffe.Controller.Controller

class SpielerPanel (row: Int, column: Int, controller: Controller) extends FlowPanel {
val InitialfarbeSpieler = new Color(200, 200, 255)
val Schiffgesetzt = new Color(192, 255, 192)
val Schiffgetroffen = new Color(190, 245, 170)
val SchiffNichtgetroffen = new Color(150, 160, 162)
def myCell = controller.cell(row, column)

val cellButton = new Button {
  preferredSize_=(new Dimension(60,60))
  opaque=true
  background = if (myCell.getGesetzt & myCell.getGetroffen) Schiffgetroffen
  else {
    if(!myCell.getGesetzt & myCell.getGetroffen)
    SchiffNichtgetroffen
    else {
      if(myCell.getGesetzt & !myCell.getGetroffen)
        Schiffgesetzt
        else InitialfarbeSpieler
    }
  }
  
  }
  contents += cellButton
  listenTo(cellButton)
}