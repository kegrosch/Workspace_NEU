package schiffe.View
import schiffe.Controller.Controller
import scala.swing._
import scala.swing.Swing.LineBorder
import scala.swing.event._
import schiffe.Controller.FeldResize
import schiffe.Controller.CellChanged
import javax.swing.ImageIcon
import schiffe.Controller.SpielFertig
import schiffe.Controller.SchiffGesetzt

class CellClicked(val row: Int, val column: Int) extends Event

class GUI(controller: Controller, pccontroller: Controller) extends Frame {

  var groesse = controller.feld.zellen.length

  var schiffsleiste = new SchiffPanel(groesse)
  def setSchiffleiste(groesse: Int): SchiffPanel = {
    schiffsleiste = new SchiffPanel(groesse)
    listenTo(schiffsleiste)
    schiffsleiste
  }
  //  def schiffleiste_Grid = schiffleiste(groesse).schiffleiste
  listenTo(controller, pccontroller, schiffsleiste)
  var cells = new SpielerPanel(controller, groesse, schiffsleiste, computercells)
  var computercells = new PCPanel(pccontroller, groesse, controller)
  computercells.pcSchiffeSetzen(groesse)
  title = "Schiffe Versenken"

  //  def spielfeldPc = new PCPanel(pccontroller, groesse)
  def spielfeldPcButtons(groesse: Int): PCPanel = {
    computercells = new PCPanel(pccontroller, groesse, controller)
    //    pcSchiffeSetzen(groesse)
    computercells
    //   spielfeldPc.spielfeld(groesse, groesse) 
  }

  //    def spielfeldUser = new SpielerPanel(controller, groesse)
  def spielfeldUserButtons(groesse: Int): SpielerPanel = {
    schiffsleiste = setSchiffleiste(groesse)
    cells = new SpielerPanel(controller, groesse, schiffsleiste, computercells)
    cells
  }

  var statusline = new Label(controller.statusText)
  val titelpc = new Label { text = "Spielfeld des Computers" }
  val titelUser = new Label { text = "Ihr Spielfeld" }
  val neustarten = new Button { //Button zum Neustarten des Spiels
    action = Action("Spiel neu Starten") {
      controller.reset
      pccontroller.reset
      computercells.pcSchiffeSetzen(groesse)

      statusline.text = controller.statusText
      //      computercells.pcSchiffeSetzen(pccontroller.feld.zellen.length)
    }
  }
  val spiel2 = new Button { //Button zu aendern der Spielfeldgroe�e auf 2
    action = Action("Spielgroesse 2") {
      if (groesse == 2) {
        controller.setStatusText("Spielfeld ist schon 2 Zellen gross")
      } else {

        if (controller.getFeldGesetzt() == false) {
          groesse = 2
          controller.reset
          pccontroller.reset

          newSize(2)
          computercells.pcSchiffeSetzen(2)
        } else
          controller.setStatusText("Die Schiffe sind schon gesetzt. Keine Groessenaenderung moeglich")

        //        redraw

      }
      statusline.text = controller.statusText
    }
  }
  val spiel5 = new Button { //Button zu aendern der Spielfeldgroe�e auf 5
    action = Action("Spielgroesse 5") {
      if (groesse == 5) {

        controller.setStatusText("Spielfeld ist schon 5 Zellen gross")
      } else {
        if (controller.getFeldGesetzt() == false) {

          groesse = 5
          controller.reset
          pccontroller.reset

          newSize(5)
          computercells.pcSchiffeSetzen(5)
        } else
          controller.setStatusText("Die Schiffe sind schon gesetzt. Keine Groessenaenderung moeglich")
      }
      //      redraw
      statusline.text = controller.statusText
    }
  }
  val spiel10 = new Button { //Button zu aendern der Spielfeldgroe�e auf 10

    action = Action("Spielgroesse 10") {
      if (groesse == 10) {
        controller.setStatusText("Spielfeld ist schon 10 Zellen gross")
      } else {
        if (controller.getFeldGesetzt() == false) {
          //                       controller.setSize(10); pccontroller.setSize(10)

          groesse = 10
          controller.reset
          pccontroller.reset

          newSize(10)
          computercells.pcSchiffeSetzen(10)
          //          redraw
        } else
          controller.setStatusText("Sie haben die Schiffe schon gesetzt")

      }
      statusline.text = controller.statusText
    }
  }
  val loesen = new Button { //Button zum Loesen des Spiels
    action = Action("Spiel loesen") {
      pccontroller.solve
      controller.solve
      controller.setFeldGesetzt(false)
      pccontroller.setFeldGesetzt(false)

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

  contents = new BorderPanel {

    add(funktionsleiste, BorderPanel.Position.North)

    add(new FlowPanel { //ueberschrift fuer die beiden Spielfelder

      contents += titelUser
      contents += titelpc

    }, BorderPanel.Position.South)

    add(spielfeldUserButtons(groesse), BorderPanel.Position.West)
    add(schiffsleiste.schiffleiste, BorderPanel.Position.Center)

    add(spielfeldPcButtons(groesse), BorderPanel.Position.East)

    visible = true

  }
  listenTo(schiffsleiste)
  reactions += {

    case e: FeldResize => resize(e.newSize)

    case e: CellChanged => redraw

    case SpielFertig => endGame

  }

  def endGame = {

    if (controller.feld.spielFertig == true) {
      schiffsleiste = setSchiffleiste(groesse)
      //      cells = new SpielerPanel(controller, groesse, schiffsleiste)
      //        computercells = new PCPanel(pccontroller, groesse, controller)
      contents = new BorderPanel {
        add(funktionsleiste, BorderPanel.Position.North)
        add(new FlowPanel { //ueberschrift fuer die beiden Spielfelder
          contents += titelUser
          contents += titelpc
        }, BorderPanel.Position.South)
        add(cells, BorderPanel.Position.West)
        add(endGamePanel, BorderPanel.Position.Center)
        add(computercells, BorderPanel.Position.East)
      }
    } else {
      if (pccontroller.feld.spielFertig == true) {
        schiffsleiste = setSchiffleiste(groesse)
        //        cells = new SpielerPanel(controller, groesse, schiffsleiste)
        //        computercells = new PCPanel(pccontroller, groesse, controller)
        contents = new BorderPanel {
          add(funktionsleiste, BorderPanel.Position.North)
          add(new FlowPanel { //ueberschrift fuer die beiden Spielfelder
            contents += titelUser
            contents += titelpc
          }, BorderPanel.Position.South)
          add(cells, BorderPanel.Position.West)
          add(endGamePanel, BorderPanel.Position.Center)
          add(computercells, BorderPanel.Position.East)
        }
      }
    }
  }

  def endGamePanel: Button = {
    var ende = new Button //var ende = new Label("Spiel ist vorbei",new ImageIcon("c:\\test\\test.png"),Alignment.Right)
    if (controller.feld.spielFertig == true) {
      ende = new Button("Spiel ist vorbei\n Der PC hat gewonnen")
    } else {
      ende = new Button("Spiel ist vorbei\n Sie haben gewonnen")
    }
    ende
  }
  def resize(newSize: Int) = {
    //    println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH")
    groesse = newSize

    // cells.setSize(newSize)
    setSchiffleiste(newSize)
    cells = new SpielerPanel(controller, newSize, schiffsleiste, computercells)
    cells.setAlleButtonSize(newSize)
    computercells = new PCPanel(pccontroller, newSize, controller)
    computercells.setAlleButtonSize(newSize)

    contents = new BorderPanel {
      add(funktionsleiste, BorderPanel.Position.North)
      add(new FlowPanel { //ueberschrift fuer die beiden Spielfelder
        contents += titelUser
        contents += titelpc
      }, BorderPanel.Position.South)
      add(cells, BorderPanel.Position.West)
      add(schiffsleiste.schiffleiste, BorderPanel.Position.Center)
      add(computercells, BorderPanel.Position.East)

    }
    //    repaint()
  }

  def redraw = {

    if (controller.feld.spielFertig == true) {
      schiffsleiste = setSchiffleiste(groesse)
      controller.setFeldGesetzt(false)
      pccontroller.setFeldGesetzt(false)
      //      cells = new SpielerPanel(controller, groesse, schiffsleiste)
      //        computercells = new PCPanel(pccontroller, groesse, controller)
      contents = new BorderPanel {
        add(funktionsleiste, BorderPanel.Position.North)
        add(new FlowPanel { //ueberschrift fuer die beiden Spielfelder
          contents += titelUser
          contents += titelpc
        }, BorderPanel.Position.South)
        add(cells, BorderPanel.Position.West)
        add(endGamePanel, BorderPanel.Position.Center)
        add(computercells, BorderPanel.Position.East)
      }
    } else {
      if (pccontroller.feld.spielFertig == true) {

        schiffsleiste = setSchiffleiste(groesse)
        //        cells = new SpielerPanel(controller, groesse, schiffsleiste)
        //        computercells = new PCPanel(pccontroller, groesse, controller)
        contents = new BorderPanel {
          add(funktionsleiste, BorderPanel.Position.North)
          add(new FlowPanel { //ueberschrift fuer die beiden Spielfelder
            contents += titelUser
            contents += titelpc
          }, BorderPanel.Position.South)
          add(cells, BorderPanel.Position.West)
          add(endGamePanel, BorderPanel.Position.Center)
          add(computercells, BorderPanel.Position.East)
        }
      } else {

        schiffsleiste = setSchiffleiste(groesse)
        cells = new SpielerPanel(controller, groesse, schiffsleiste, computercells)
        computercells = new PCPanel(pccontroller, groesse, controller)
      }
    }

    repaint()
  }

  def newSize(newSize: Int) {
    groesse = newSize
    cells.contents.clear()
    computercells.contents.clear()
    controller.reset
    controller.setSize(newSize)
    pccontroller.reset
    pccontroller.setSize(newSize)
  }

}