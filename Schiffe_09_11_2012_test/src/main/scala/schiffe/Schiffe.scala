package schiffe
import schiffe._
import schiffe.View._
import schiffe.Controller._
import schiffe.Model._

object Schiffe {
  val controller = new Controller(new Feld(5))
  val pccontroller = new Controller(new Feld(5))
  val userTui = new Tui(controller, pccontroller)
  val userGui = new GUI(controller, pccontroller)
  //MAIN KLASSE
  def main(args: Array[String]) {

    //    userGui.spiel(5)
    userGui.visible = true

    while ((userTui.readInput(readLine())) == true) {}

  }

}