package code 
package snippet 

import scala.xml.{NodeSeq, Text}
import schiffe._
import net.liftweb.util._
import net.liftweb.common._
import java.util.Date
import code.lib._
import Helpers._
import schiffe.Controller.Controller
import schiffe.View._
import schiffe.Model._
import net.liftweb.http.SHtml

class Feldunktionsleiste {
 
   def exampleTwo() = {
    val controller = new Controller(new schiffe.Model.Feld(5))
    val pccontroller = new Controller(new schiffe.Model.Feld(5))
    val userTui=new Tui(controller, pccontroller)
    val userGui = new GUI(controller, pccontroller)
    userGui.visible = true
     while((userTui.readInput(readLine()))==true){}

//  bind("example",xhtml,
//    "neuStarten" -> SHtml.button("neuStartet") )
  
}
}