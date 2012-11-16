package schiffe
import schiffe._
import schiffe.View._
import schiffe.Controller._
import schiffe.Model._

object Schiffe {
  
  def main(args: Array[String]) {
    val tui=new Tui(new Controller(new Feld(5)))
    while((tui.readInput(readLine()))){}
      
      }


}