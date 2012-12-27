package schiffe.View
import schiffe.Controller.Controller
import scala.swing._
import scala.swing.Swing.LineBorder
import scala.swing.event._
import schiffe.Controller.FeldResize

class GUI(controller: Controller, pccontroller: Controller) extends Frame {

  listenTo(controller, pccontroller)

  //  reactions += {
  //    case e: FeldResize => resize(e.newSize)
  //    //    case e: CellChanged => redraw
  //  }
  title = "Schiffe Versenken"
    
   

  def spiel(spielSize: Int) = {
    var groesse = spielSize
    var statusline = new Label { text = controller.statusText }
    val titelpc = new Label { text = "Spielfeld des Computers" }
    val titelUser = new Label { text = "Ihr Spielfeld" }
    val neustarten = new Button {//Button zum Neustarten des Spiels
      action = Action("Spiel neu Starten") {
        controller.reset
        pccontroller.reset
        statusline.text = controller.statusText
      }
    }
    val spiel2 = new Button {//Button zu ändern der Spielfeldgröße auf 2
      action = Action("Spielgrösse 2") {
        if (groesse == 2) {
          statusline.text = "Spielfeld ist schon 2 Zellen gross"
        } else {
          resize(2)
          groesse = 2
        }
      }
    }
    val spiel5 = new Button {//Button zu ändern der Spielfeldgröße auf 5
      action = Action("Spielgrösse 5") {
        if (groesse == 5) {
          statusline.text = "Spielfeld ist schon 5 Zellen gross"
        } else

          resize(5)
        groesse = 5

      }
    }
    val spiel10 = new Button {//Button zu ändern der Spielfeldgröße auf 10
      action = Action("Spielgrösse 10") {
        if (groesse == 10) {
          statusline.text = "Spielfeld ist schon 10 Zellen gross"
        } else {
          if (controller.getFeldGesetzt() == false) {
            //           controller.setSize(10); pccontroller.setSize(10)

            resize(10)
            groesse = 10
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

    var cells = Array.ofDim[SpielerPanel](groesse, groesse)
    var computercells = Array.ofDim[PCPanel](groesse, groesse)
    contents = new BorderPanel {

      add(new FlowPanel { //Leiste im oberen Bereich mit Größenänderung, Neu Starten und Lösen

        contents += neustarten
        contents += spiel2
        contents += spiel5
        contents += spiel10
        contents += loesen
        contents += statusline

      }, BorderPanel.Position.North)
      
      add(new FlowPanel { //Überschrift für die beiden Spielfelder

        contents += titelUser
        contents += titelpc

      }, BorderPanel.Position.South)

      add(spielfeldUser(groesse), BorderPanel.Position.West)
      add(new FlowPanel(), BorderPanel.Position.Center)
      add(spielfeldPc(groesse), BorderPanel.Position.East)
      
      
      
      
//
//      listenTo(neustarten, loesen, spiel5, spiel10)

      //      reactions += {
      //        case ButtonClicked(`neustarten`) => 
      //          controller.reset
      //          pccontroller.reset
      //          statusline.text = controller.statusText
      //            
      //        case ButtonClicked(`loesen`) => 
      //          pccontroller.solve
      //          statusline.text = controller.statusText
      //             
      //        case ButtonClicked(`spiel2`) => 
      //          if (spielSize == 2) {
      //            //         statusline.text="Spielfeld ist schon 2 Zellen gross"
      //            controller.statusText = "Spielfeld ist schon 2 Zellen gross"
      //          } else {
      //
      //            //         statusline.text="SPIELFELDGRÖ?E WIRD GEÄNDERT"
      //            controller.statusText = "SPIELFELDGRÖ?E WIRD GEÄNDERT"
      //            println("SPIELFELDGRÖ?E WIRD GEÄNDERT")
      //            resize(2)
      //            
      //          }
      //              
      //        case ButtonClicked(`spiel5`) => 
      //          if (spielSize == 5) {
      //            statusline.text = "Spielfeld ist schon 5 Zellen gross"
      //          } else
      //
      //            resize(5)
      //        
      //     
      //        case ButtonClicked(`spiel10`) => 
      //          if (spielSize == 10) {
      //            statusline.text = "Spielfeld ist schon 10 Zellen gross"
      //          } else {
      //            if (controller.getFeldGesetzt() == false) {
      //              //           controller.setSize(10); pccontroller.setSize(10)
      //
      //              resize(10)
      //            } else
      //              statusline.text = "Sie haben die Zellen schon gesetzt"
      //          
      //        }
      //
      //      }
    }

  }

  def spielfeldUser(groesse: Int):GridPanel = {
   var cells = Array.ofDim[SpielerPanel](groesse, groesse)
   new GridPanel(groesse, groesse){ 
     border = LineBorder(java.awt.Color.WHITE, 2)
        for (i <- 0 to (groesse - 1)) {
          for (j <- 0 to (groesse - 1)) {
            var spielerPanel = new SpielerPanel(i, j, controller)
            spielerPanel.background_=(java.awt.Color.BLUE)
            cells(i)(j) = spielerPanel
            contents += spielerPanel
            listenTo(spielerPanel)

          }

        }
  }
    
  }
  def spielfeldPc(groesse: Int):GridPanel = {
    var computercells = Array.ofDim[PCPanel](groesse, groesse)
   new GridPanel(groesse, groesse){
    border = LineBorder(java.awt.Color.WHITE, 2)
        for (k <- 0 to (groesse - 1)) {
          for (l <- 0 to (groesse - 1)) {
            var PCPanel = new PCPanel(k, l, pccontroller)
            PCPanel.background_=(java.awt.Color.BLACK)
            computercells(k)(l) = PCPanel
            contents += PCPanel
            listenTo(PCPanel)
          }
        }
        }
  }
  def resize(newSize: Int) {
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