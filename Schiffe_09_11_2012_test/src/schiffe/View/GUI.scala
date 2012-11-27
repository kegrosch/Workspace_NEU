package schiffe.View
import schiffe.Controller.Controller
import scala.swing.Frame
import scala.swing.MainFrame

class GUI (controller: Controller) extends Frame{
  
  listenTo(controller)
  def top = new MainFrame{
    title = "Schiffe Versenken"
      
  }
     

}