package schiffe.View
import schiffe.Controller.Controller
import scala.swing._
import scala.swing.Swing.LineBorder
import scala.swing.event._
import schiffe.Controller.FeldResize
import schiffe.Controller.CellChanged
class CellClicked(val row: Int, val column: Int) extends Event

class GUI(controller: Controller, pccontroller: Controller) extends Frame {

  var groesse = controller.feld.zellen.length
  listenTo(controller, pccontroller)
  var cells = Array.ofDim[Button](groesse, groesse)
  var computercells = Array.ofDim[Button](groesse, groesse)

  //  reactions += {
  //    case e: FeldResize => resize(e.newSize)
  //    //    case e: CellChanged => redraw
  //  }
  title = "Schiffe Versenken"

  def spielfeldPc = new GridPanel(groesse, groesse) {
    border = LineBorder(java.awt.Color.WHITE, 2)
    for (k <- 0 to (groesse - 1)) {
      for (l <- 0 to (groesse - 1)) {
        cells(k)(l) = new Button{
          background_=(java.awt.Color.BLACK)
           preferredSize_=(new Dimension(60,60))
        } 
        
        contents += cells(k)(l)
        listenTo(cells(k)(l))
      }
    }

  }
  def spielfeldUser(groesse: Int) = new GridPanel(groesse, groesse) {
    border = LineBorder(java.awt.Color.WHITE, 2)
    for (i <- 0 to (groesse - 1)) {
      for (j <- 0 to (groesse - 1)) {
        cells(i)(j) = new Button{
          background_=(java.awt.Color.BLUE)
           preferredSize_=(new Dimension(60,60))
        } 
        
        contents += cells(i)(j)
        listenTo(cells(i)(j))
        repaint
      }
      repaint
    }
    repaint
  }   
 
    var statusline = new Label(controller.statusText)
    val titelpc = new Label { text = "Spielfeld des Computers" }
    val titelUser = new Label { text = "Ihr Spielfeld" }
    val neustarten = new Button {//Button zum Neustarten des Spiels
      action = Action("Spiel neu Starten") {
        controller.reset
        pccontroller.reset
        statusline.text = controller.statusText
      }
    }
    val spiel2 = new Button {//Button zu aendern der Spielfeldgröße auf 2
      action = Action("Spielgrösse 2") {
        if (groesse == 2) {
          statusline.text = "Spielfeld ist schon 2 Zellen gross"
        } else {
          groesse = 2
          controller.setSize(2)
          newSize(2)
          redraw
          
          
        }
      }
    }
    val spiel5 = new Button {//Button zu ändern der Spielfeldgröße auf 5
      action = Action("Spielgrösse 5") {
        if (groesse == 5) {
          statusline.text = "Spielfeld ist schon 5 Zellen gross"
        } else

          newSize(5)
        groesse = 5
        repaint

      }
    }
    val spiel10 = new Button {//Button zu ändern der Spielfeldgröße auf 10

      action = Action("Spielgrösse 10") {
        if (groesse == 10) {
          statusline.text = "Spielfeld ist schon 10 Zellen gross"
        } else {
          if (controller.getFeldGesetzt() == false) {
//                       controller.setSize(10); pccontroller.setSize(10)

            newSize(10)
            groesse = 10
            repaint
          } else
            statusline.text = "Sie haben die Zellen schon gesetzt"

        }
      }
    }
    val loesen = new Button {//Button zum Lösen des Spiels
      action = Action("Spiel lösen") {
        pccontroller.solve
        statusline.text = controller.statusText
      }
    }

     def funktionsleiste = new FlowPanel{
    contents += neustarten
        contents += spiel2
        contents += spiel5
        contents += spiel10
        contents += loesen
        contents += statusline
  }
    contents = new BorderPanel {

      add(funktionsleiste, BorderPanel.Position.North)
      
      add(new FlowPanel { //Überschrift für die beiden Spielfelder

        contents += titelUser
        contents += titelpc

      }, BorderPanel.Position.South)

      add(spielfeldUser(groesse), BorderPanel.Position.West)
      add(new FlowPanel(), BorderPanel.Position.Center)
      add(spielfeldPc, BorderPanel.Position.East)
      
visible = true

  reactions += {
    case e: FeldResize => resize(e.newSize)
    
    		
    
    case CellChanged => redraw
  }
    }

  



  def resize(newSize: Int) = {
    cells = Array.ofDim[Button](newSize, newSize)
    computercells = Array.ofDim[Button](newSize, newSize)
    
    contents = new BorderPanel {
      add(funktionsleiste, BorderPanel.Position.North)      
      add(new FlowPanel { //Überschrift für die beiden Spielfelder
        contents += titelUser
        contents += titelpc
      }, BorderPanel.Position.South)
      add(spielfeldUser(newSize), BorderPanel.Position.West)
      add(new FlowPanel(), BorderPanel.Position.Center)
      add(spielfeldPc, BorderPanel.Position.East)
      
  }
    repaint()
  }
  
  def redraw = {
    for (row <- 0 until controller.feld.zellen.length; column <- 0 until controller.feld.zellen.length) {
//      cells(row)(column).redraw
//      computercells(row)(column).redraw
    }  
    statusline.text = controller.statusText
    repaint
  }
  
    def newSize(newSize: Int){
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