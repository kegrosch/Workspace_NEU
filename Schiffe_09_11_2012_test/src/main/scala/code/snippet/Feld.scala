package code 
package snippet 

import scala.xml.{NodeSeq, Text}
import schiffe._
import net.liftweb.util._
import net.liftweb.common._
import java.util.Date
import code.lib._
import Helpers._
import net.liftweb.http.SHtml
import net.liftweb.http.js.JsCmds.Alert
import net.liftweb.http.js.JsCmds.Confirm
import net.liftweb.http.js.JsCmd
import net.liftweb.http.js.JE.JsRaw
import net.liftweb.http.js.JsCmds

class Feld {
  
//var anzahl = Schiffe.controller.getSize
//
//
//def getFeld = "#feld *" #> createFeld(anzahl)
//def getFeld = "#feld *" #> <tr><td>GGGGGG</td><td>HHHHH</td></tr><tr><td>JJJJJ</td><td>KKKKK</td></tr>;




  def createUserFeld = {
  <table class="grid" border="1" cellspacing="10" cellpadding="8">
   {
    
         for (row <- 0 until Schiffe.controller.getSize) yield {
             <tr>
                  { for (column <- 0 until Schiffe.controller.getSize) yield {
                    var gesetzt = Schiffe.controller.cell(row, column).getGesetzt
//                    {<td class={"reihe="+row+"&column="+column}>{if(gesetzt)"X"else " "}</td>
                    <td width="20px" class="candidate" id="Nblock">{if(gesetzt)"   X   "else "   X   "}</td>
                     }
                  
                  }
             </tr>
         }
     }
     </table>
   }   
   def createPcFeld = {
  <table class="grid" border="1" cellspacing="10" cellpadding="8">
   {
    
         for (row <- 0 until Schiffe.controller.getSize) yield {
             <tr>
                  { for (column <- 0 until Schiffe.controller.getSize) yield {
                    {var gesetzt = Schiffe.controller.cell(row, column).getGesetzt}
//                    {<td class={"reihe="+row+"&column="+column}>{if(gesetzt)"X"else " "}</td>
                    <td width="20px" class="candidate" id="Nblock">{SHtml.ajaxButton("Hallo", () => schiffeSetzen(row, column))}</td>
                    }
                    
                  }
                  
                  
             </tr>
         }
     }
     </table>
   }
   
   def schiffeSetzen(reihe: Int, spalte: Int): JsCmd = 
     Alert("OOUUZUZUZ")
   JsCmds.SetHtml("HHHHH Gesetzt", createPcFeld)
}
