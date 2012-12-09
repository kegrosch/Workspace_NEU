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
 
  
  def spiel(spielSize: Int) = {
  
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
    add(new FlowPanel{
    
    contents += labelsp
    contents += labelcomp
     
    }, BorderPanel.Position.South)
   
    add(new GridPanel(spielSize, spielSize) {
      border = LineBorder(java.awt.Color.WHITE, 2)
      for (i <- 0 to (spielSize-1)) {
        for (j <- 0 to (spielSize-1)) {
         var spielerPanel = new SpielerPanel(i,j, controller)
         spielerPanel.background_=(java.awt.Color.BLUE)
           cells(i)(j) = spielerPanel
         contents += spielerPanel
         listenTo(spielerPanel)
         

        }
        
      }

    }, BorderPanel.Position.West)
    add(new FlowPanel(), BorderPanel.Position.Center)
    add(new GridPanel(spielSize, spielSize){
       border = LineBorder(java.awt.Color.WHITE, 2)
      for (k <-0 to (spielSize-1)) {
        for (l <- 0 to (spielSize-1)) {
         var PCPanel = new PCPanel(k,l, pccontroller)
         PCPanel.background_=(java.awt.Color.BLACK)
           computercells(k)(l) = PCPanel
         contents += PCPanel
         listenTo(PCPanel)
        }
      }
      
    }, BorderPanel.Position.East)
 listenTo(neustarten)
 listenTo(loesen)
  listenTo(spiel2)
  listenTo(spiel5)
   listenTo( spiel10)
 reactions += {
 case ButtonClicked(neustarten) => {controller.reset
   pccontroller.reset
    statusline.text = controller.statusText}
    }
    reactions += {
 case ButtonClicked(loesen) => {pccontroller.solve
    statusline.text = controller.statusText}
    }
   reactions += {
     case ButtonClicked(spiel2) =>{
       if(spielSize==2){
         statusline.text="Spielfeld ist schon 2 Zellen gross"
       }
       else
      resize(2)
    }
   }
    reactions += {
    case ButtonClicked(spiel5) =>{
       if(spielSize==5){
         statusline.text="Spielfeld ist schon 5 Zellen gross"
       }
       else
      resize(5)
    }
   }
    reactions += {
     case ButtonClicked(spiel10) =>{
    if(spielSize==10){
         statusline.text="Spielfeld ist schon 10 Zellen gross"
       }
       else{
         if(controller.getFeldGesetzt()==false){
           controller.setSize(10); pccontroller.setSize(10)
                   
         resize(10) }
         else 
           statusline.text="Sie haben die Zellen schon gesetzt"
       }
     }   
    
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