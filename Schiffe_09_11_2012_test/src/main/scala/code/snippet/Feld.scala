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
  <table class="grid" border="1">
    <colgroup width="200" span="5"></colgroup>{
    
         for (row <- 0 until Schiffe.controller.getSize) yield {
             <tr>
                  { for (column <- 0 until Schiffe.controller.getSize) yield {
                    var gesetzt = Schiffe.controller.cell(row, column).getGesetzt
//                    {<td class={"reihe="+row+"&column="+column}>{if(gesetzt)"X"else " "}</td>
                    <td width="500px" class="candidate" id="Nblock">{if(gesetzt)"X"else " "}</td>
                     }
                  
                  }
             </tr>
         }
     }
     </table>
   }           
}

