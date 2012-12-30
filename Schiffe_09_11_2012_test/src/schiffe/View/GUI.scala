package schiffe.View
import schiffe.Controller.Controller
import scala.swing._
import scala.swing.Swing.LineBorder
import scala.swing.event._
import schiffe.Controller.FeldResize
import schiffe.Controller.CellChanged
import javax.swing.ImageIcon
class CellClicked(val row: Int, val column: Int) extends Event

class GUI(controller: Controller, pccontroller: Controller) extends Frame {
  listenTo(controller, pccontroller)
   var groesse = controller.feld.zellen.length
 var cells = new SpielerPanel(controller, groesse)

  var computercells = new PCPanel(pccontroller, groesse)

  
  title = "Schiffe Versenken"
  def spielfeldPc = new PCPanel(pccontroller, groesse)
  def spielfeldPcButtons = spielfeldPc.spielfeld(groesse, groesse)
//    def spielfeldUser = new SpielerPanel(controller, groesse)
  def spielfeldUserButtons = new SpielerPanel(controller, groesse)

  


  var statusline = new Label(controller.statusText)
  val titelpc = new Label { text = "Spielfeld des Computers" }
  val titelUser = new Label { text = "Ihr Spielfeld" }
  val neustarten = new Button { //Button zum Neustarten des Spiels
    action = Action("Spiel neu Starten") {
      controller.reset
      pccontroller.reset
      statusline.text = controller.statusText
    }
  }
  val spiel2 = new Button { //Button zu aendern der Spielfeldgr��e auf 2
    action = Action("Spielgr�sse 2") {
      if (groesse == 2) {
        statusline.text = "Spielfeld ist schon 2 Zellen gross"
      } else {
        groesse = 2

        newSize(2)

//        redraw

      }
    }
  }
  val spiel5 = new Button { //Button zu �ndern der Spielfeldgr��e auf 5
    action = Action("Spielgr�sse 5") {
      if (groesse == 5) {
        statusline.text = "Spielfeld ist schon 5 Zellen gross"
      } else
    	  groesse = 5
        newSize(5)
//      redraw

    }
  }
  val spiel10 = new Button { //Button zu �ndern der Spielfeldgr��e auf 10

    action = Action("Spielgr�sse 10") {
      if (groesse == 10) {
        statusline.text = "Spielfeld ist schon 10 Zellen gross"
      } else {
        if (controller.getFeldGesetzt() == false) {
          //                       controller.setSize(10); pccontroller.setSize(10)
        	groesse = 10
          newSize(10)
//          redraw
        } else
          statusline.text = "Sie haben die Zellen schon gesetzt"

      }
    }
  }
  val loesen = new Button { //Button zum L�sen des Spiels
    action = Action("Spiel l�sen") {
      pccontroller.solve
      statusline.text = controller.statusText
    }
  }

  def funktionsleiste = new FlowPanel {
    contents += neustarten
    contents += spiel2
    contents += spiel5
    contents += spiel10
    contents += loesen
    contents += statusline
  }
  def schiffleiste(groesse: Int) = new SchiffPanel(groesse)
  def schiffleiste_Grid = schiffleiste(groesse).schiffleiste
  contents = new BorderPanel {

    add(funktionsleiste, BorderPanel.Position.North)

    add(new FlowPanel { //�berschrift f�r die beiden Spielfelder

      contents += titelUser
      contents += titelpc

    }, BorderPanel.Position.South)

    add(spielfeldUserButtons, BorderPanel.Position.West)
    add(schiffleiste_Grid, BorderPanel.Position.Center)
    add(spielfeldPcButtons, BorderPanel.Position.East)

    visible = true

    
  }
reactions += {
      case e: FeldResize => resize(e.newSize)

      case CellChanged => redraw
    }
  def resize(newSize: Int) = {
  groesse = newSize
  
// cells.setSize(newSize)
cells = new SpielerPanel(controller, newSize)
  
computercells = new PCPanel(pccontroller, newSize)

//cells.createButtons

//

    contents = new BorderPanel {
      add(funktionsleiste, BorderPanel.Position.North)
      add(new FlowPanel { //�berschrift f�r die beiden Spielfelder
        contents += titelUser
        contents += titelpc
      }, BorderPanel.Position.South)
      add(cells, BorderPanel.Position.West)
      add(schiffleiste(newSize).schiffleiste, BorderPanel.Position.Center)
      add(spielfeldPcButtons, BorderPanel.Position.East)

    }
//    repaint()
  }

  def redraw = {
//    var anzahl = controller.feld.zellen.length
//    for(i <- 0 to (anzahl-1)){
//      for(j <- 0 to (anzahl-1)){
//        println("reihe: " + i)
//        println("spalte: "+ j)
//        spielfeldUser.setBackground(spielfeldUser.buttons(i)(j),i,j)
//      }
//    }
// cells.contents.clear()
    
//      cells = new SpielerPanel(controller, groesse)

//    computercells.repaint()
//    spielfeldUser.redraw(controller.feld.zellen.length)
//    spielfeldPc.redraw(pccontroller.feld.zellen.length)
//    spielfeldUserButtons.repaint()
//    spielfeldPcButtons.repaint()
//    
//    
//    
//    
//    statusline.text = controller.statusText
//    repaint()
  }

  def newSize(newSize: Int) {
    groesse = newSize
    cells.contents.clear()
    controller.setSize(newSize)
    pccontroller.setSize(newSize)
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
  //    new Button("Spielgr�sse 2")
  //    new Button("Spielgr�sse 5")
  //    new Button("Spielgr�sse 10")
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