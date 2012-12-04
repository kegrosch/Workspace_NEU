package schiffe.View
import schiffe.Controller.Controller
import scala.swing._
import scala.swing.Swing.LineBorder
import scala.swing.event._
import schiffe.Controller.FeldResize

class GUI(controller: Controller, pccontroller:Controller) extends Frame {

  listenTo(controller)
   listenTo(pccontroller)
  reactions += {
    case e: FeldResize => resize(e.newSize)
//    case e: CellChanged => redraw
  }
  title = "Schiffe Versenken"
  var spielGroesse = controller.feld.zellen.length
  
  def spiel(spielSize: Int) = {
  val InitialfarbeSpieler = new Color(200, 200, 255)
  val InitialfarbeComputer = new Color(224, 224, 255)
  val Schiffgesetzt = new Color(192, 255, 192)
  val Schiffgetroffen = new Color(190, 245, 170)
  val SchiffNichtgetroffen = new Color(150, 160, 162)
  val labelcomp = new Label { text = "Spielfeld des Computers" }
  val labelsp = new Label { text = "Ihr Spielfeld" }
  val neustarten = new Button("Spiel neu Starten")
  val spiel2 = new Button("Spielgrösse 2")
  val spiel5 = new Button("Spielgrösse 5")
  val spiel10 = new Button("Spielgrösse 10")
  val loesen = new Button("Spiel lösen")
  var statusline = new Label{text =controller.statusText}
  var cells = Array.ofDim[SpielerPanel](controller.getSize, controller.getSize)
  var computercells = Array.ofDim[PCPanel](pccontroller.getSize, pccontroller.getSize)
    contents = new BorderPanel {
  
    add(new FlowPanel{
    
    contents += neustarten
    contents += spiel2
    contents += spiel5
    contents += spiel10
    contents += loesen
    contents += statusline
     
    }, BorderPanel.Position.North)
    add(new GridPanel(spielSize, spielSize) {
      for (i <- 0 to (spielGroesse-1)) {
        for (j <- 0 to (spielGroesse-1)) {
          var button = new Button("")
          button.background_=(java.awt.Color.BLUE)
          button.preferredSize_=(new Dimension(60,60))
         contents += button
          // var spielerPanel = new SpielerPanel(i,j, controller)
        //  cells(i)(j) = spielerPanel
        // contents += spielerPanel

        }
        
      }

    }, BorderPanel.Position.West)
    add(new FlowPanel(), BorderPanel.Position.Center)
    add(new GridPanel(spielSize, spielSize){
      for (i <- 1 to (spielSize)) {
        for (j <- 1 to (spielSize)) {
          var button = new Button("")
          button.background_=(java.awt.Color.BLACK)
          button.preferredSize_=(new Dimension(60,60))
          contents += button
        }
      }
      
    }, BorderPanel.Position.East)
 listenTo(neustarten)
 listenTo(loesen)
 reactions += {
 case ButtonClicked(neustarten) => {controller.reset
    statusline.text = controller.statusText}
    }
    reactions += {
 case ButtonClicked(loesen) => {controller.solve
    statusline.text = controller.statusText}
    }
 }

  
  }
  def resize(newSize: Int){
    spiel(newSize)
  }
//  var zellen = controller.feld.zellen
//  
//  var aktionsleiste = new FlowPanel()
//  var spielfelder = new FlowPanel()
//  var spielfeldUser = new GridPanel(spielGroesse, spielGroesse)
//  var spielfeldPc = new GridPanel(spielGroesse, spielGroesse)
//  
//  def gridPanel = new GridPanel(spielGroesse, spielGroesse) {
//    border = LineBorder(java.awt.Color.BLACK, 2)
//    background = java.awt.Color.BLACK
//    for (outerRow <- 0 until spielGroesse; outerColumn <- 0 until spielGroesse) {
//      contents += new GridPanel(spielGroesse, spielGroesse) {
//        border = LineBorder(java.awt.Color.BLACK, 2)
//        for (innerRow <- 0 until spielGroesse; innerColumn <- 0 until spielGroesse) {
//          val x = outerRow * spielGroesse + innerRow
//          val y = outerColumn * spielGroesse + innerColumn
//          val cellPanel = new CellPanel(x, y, controller)
//          cells(x)(y) = cellPanel
//          contents += cellPanel
//          listenTo(cellPanel)
//        }
//      }
//    }
//  }
//  
//  
//  def top = new MainFrame{
//    
//    aktionsleiste.contents += aktionsleisteButtons
//    spielfeld(spielfeldUser)
//    spielfeld(spielfeldPc)
//  
//    spielfelder.contents += spielfeldUser
//    spielfelder.contents += spielfeldPc
//  
//    var hauptfenster = new BorderPanel(){
//    	
//    }
//    
//    contents = spielfelder
//  }
//    
//  
//    
//  def aktionsleisteButtons = {
//    new Button("Spiel neu Starten")
//    new Button("Spielgrösse 2")
//    new Button("Spielgrösse 5")
//    new Button("Spielgrösse 10")
//    
//  }
//  def spielfeld(panel: GridPanel) = {
//      for(i <- 1 to (spielGroesse)){
//        for(j <- 1 to (spielGroesse)){
//    panel.contents += new Button(i + " , " + j)
//        }
//      }
//
//    }
     

}