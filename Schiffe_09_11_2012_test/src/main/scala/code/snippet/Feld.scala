package code 
package snippet 

import scala.xml.{NodeSeq, Text}
import schiffe._
import net.liftweb.util._
import net.liftweb.common._
import java.util.Date
import code.lib._
import Helpers._

class Feld {
  
//var anzahl = Schiffe.controller.getSize
//
//
//def getFeld = "#feld *" #> createFeld(anzahl)
//def getFeld = "#feld *" #> <tr><td>GGGGGG</td><td>HHHHH</td></tr><tr><td>JJJJJ</td><td>KKKKK</td></tr>;




  def createFeld = {
  <table class="feld">{
         for (row <- 0 until Schiffe.controller.getSize) yield {
             <tr>
                  { for (column <- 0 until Schiffe.controller.getSize) yield {
                     <td class={"reihe="+row+"&column="+column}>{"reihe="+row+"&column="+column}</td>
                     }
                  
                  }
             </tr>
         }
     }
     </table>
   }           
}

