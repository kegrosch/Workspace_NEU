package schiffe
import schiffe._
import schiffe.View._
import schiffe.Controller._
import schiffe.Model._

object Schiffe {
  
  def main(args: Array[String]) {
    val controller = new Controller(new Feld(5))
    val userTui=new Tui(controller)
    val userGui = new GUI(controller)
    
    while((userTui.readInput(readLine()))==true){}
   
      
    
    
      }

  

}