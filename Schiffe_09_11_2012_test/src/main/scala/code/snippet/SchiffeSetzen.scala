package code
package snippet

import net.liftweb.http.SHtml
import net.liftweb.http.js.JsCmd
import net.liftweb.util.Helpers._
import scala.xml.NodeSeq
import scala.xml.Group
import _root_.net.liftweb.http.SHtml._
import scala.xml.Text
import net.liftweb.util.Log
import net.liftweb.http.js.JsCmds.SetHtml
import net.liftweb.http.js.JsCmds.Alert


class SchiffeSetzen {
  
  
  def schiffeSetzen(html: NodeSeq) : NodeSeq = {
    bind("hello", html, "button" -> ajaxButton(Text("Press me"), {() => 
    Log.info("Got an AJAX call")
    SetHtml("my-div", Text("That�s it")) 
  }))
}

  def onClick(reihe: Int, spalte: Int):JsCmd = {
    Alert("You Click: " + reihe + " " + spalte)
  }
  

  
  
  
//    def render = {
//  <table class="grid" border="1" cellspacing="10" cellpadding="8">
//   {
//    
//         for (row <- 0 until Schiffe.controller.getSize) yield {
//             <tr>
//                  { for (column <- 0 until Schiffe.controller.getSize) yield {
//                    {var gesetzt = Schiffe.controller.cell(row, column).getGesetzt}
////                    {<td class={"reihe="+row+"&column="+column}>{if(gesetzt)"X"else " "}</td>
//                    <td width="20px" class="candidate" id="Nblock">{SHtml.ajaxButton("Zelle", schiffeSetzen(row, column)_)}</td>
//                    }
//                    
//                  }
                  
                  
//             </tr>
//         }
//     }
//     </table>
//   }
//  
  
  
}