package schiffe.View
import schiffe.Controller.Controller
import scala.swing.Frame
import scala.swing.MainFrame
import scala.swing.Label
import scala.swing.SimpleSwingApplication
import scala.swing.GridPanel
import scala.swing.Button
import scala.swing.FlowPanel
import scala.swing.BorderPanel

class GUI (controller: Controller) extends SimpleSwingApplication{
  
  listenTo(controller)
  var spielGroesse = controller.feld.zellen.length
  var aktionsleiste = new FlowPanel()
  var spielfelder = new FlowPanel()
  var spielfeldUser = new GridPanel(spielGroesse, spielGroesse)
  var spielfeldPc = new GridPanel(spielGroesse, spielGroesse)
  
  
  def top = new MainFrame{
    title = "Schiffe Versenken"
    aktionsleiste.contents += aktionsleisteButtons
    spielfeld(spielfeldUser)
    spielfeld(spielfeldPc)
  
    spielfelder.contents += spielfeldUser
    spielfelder.contents += spielfeldPc
  
    var hauptfenster = new BorderPanel(){
    	contents += aktionsleiste
    }
    
    contents = spielfelder
  }
    
  
    
  def aktionsleisteButtons = {
    new Button("Spiel neu Starten")
    new Button("Spielgrösse 2")
    new Button("Spielgrösse 5")
    new Button("Spielgrösse 10")
    
  }
  def spielfeld(panel: GridPanel) = {
      for(i <- 1 to (spielGroesse)){
        for(j <- 1 to (spielGroesse)){
    panel.contents += new Button(i + " , " + j)
        }
      }

    }
     

}