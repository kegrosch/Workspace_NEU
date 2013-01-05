package code.snippet

import net.liftweb._
import util._
import Helpers._
import http._
import js.JsCmds._

import schiffe._

class FeldSnippet {
   def render = {
      <table class="grid">{
         for (row <- 0 until Schiffe.controller.getSize) yield {
             <tr>
                  { for (column <- 0 until Schiffe.controller.getSize) yield {
                     <td class={"lift:ZelleSnippet?row="+row+"&column="+column}></td>
                     }
                  
                  }
             </tr>
         }
     }
     </table>
   }           
}