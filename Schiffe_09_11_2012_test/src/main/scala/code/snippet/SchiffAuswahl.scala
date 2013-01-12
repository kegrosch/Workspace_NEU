package code
package snippet
import _root_.net.liftweb.http.js.{JE,JsCmd,JsCmds}
import net.liftweb._
import util._
import Helpers._
import http._
import js.JsCmds._
import code.comet.SchiffeServer


object SchiffAuswahl {
  
  def ajaxFunc1 : JsCmd = SchiffeServer ! "1"
  def ajaxFunc2 : JsCmd = SchiffeServer ! "1"

//def renderAjaxButton(html: Group): NodeSeq = {
//    bind("highlight", html,         
//            "zerstoerer_mittel" -> SHtml.ajaxButton("Zerstörer", ajaxFunc1 _),
//            "uboot_mittel" -> SHtml.ajaxButton("U-Boot", ajaxFunc1 _),
//             
//            "kreuzer_mittel" -> SHtml.ajaxButton("U-Boot", ajaxFunc1 _)
//        
  
//) }
  
def render = {
 "button [onClick]" #> SHtml.onSubmit(("style"->"backgroundColor:red"))
  
  }

}
