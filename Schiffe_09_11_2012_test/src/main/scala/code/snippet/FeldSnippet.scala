package code.snippet

import net.liftweb._
import util._
import Helpers._
import http._
import js.JsCmds._

import schiffe._

class FeldSnippet {
   def render = {
      <table class="feld">{
         for (reihe <- 0 until Schiffe.Controller.getSize) yield {
             <tr>
                  { for (spalte <- 0 until Schiffe.Controller.getSize) yield {
                     <td class={"lift:ZelleSnippet?reihe="+reihe+"&spalte="+spalte}></td>
                     }
                  
                  }
             </tr>
         }
     }
     </table>
   }           
}