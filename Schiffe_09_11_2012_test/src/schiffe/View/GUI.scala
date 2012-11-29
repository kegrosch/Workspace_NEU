package schiffe.View
import schiffe.Controller.Controller
import scala.swing._
import scala.swing.Swing.LineBorder
import scala.swing.event._
import schiffe.Controller.FeldResize

class GUI(controller: Controller) extends Frame {

  listenTo(controller)
  reactions += {
    case e: FeldResize => resize(e.newSize)
//    case e: CellChanged => redraw
  }
  title = "Schiffe Versenken"
  var spielGroesse = controller.feld.zellen.length
  def spiel(spielSize: Int) = {
  val InitialfarbeSpieler = new Color(200, 200, 255)
  val InitialfarbeComputer = new Color(224, 224, 255)
  val SchiffgesetztSpieler = new Color(192, 255, 192)
  val SchiffgetroffenSpieler = new Color(190, 245, 170)
  val SchiffNichtgetroffenSpieler = new Color(150, 160, 162)
  val SchiffgetroffenComputer = new Color(40, 160, 145)
  val SchiffNichtgetroffenComputer = new Color(120, 190, 110)
  val SchiffgesetztComputerwennsolved= new Color(105, 101, 130)
  val labelcomp = new Label { text = "Spielfeld des Computers" }
  val labelsp = new Label { text = "Ihr Spielfeld" }
    contents = new BorderPanel {
  
    add(new FlowPanel{
    contents += new Button("Spiel neu Starten")
    contents += new Button("Spielgrösse 2")
    contents += new Button("Spielgrösse 5")
    contents += new Button("Spielgrösse 10")
    contents += new Button("Spiel lösen")
    
    }, BorderPanel.Position.North)
    add(new GridPanel(spielSize, spielSize) {
      for (i <- 1 to (spielSize)) {
        for (j <- 1 to (spielSize)) {
          var button = new Button("")
          button.background_=(java.awt.Color.BLUE)
          button.preferredSize_=(new Dimension(60,60))
          contents += button
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