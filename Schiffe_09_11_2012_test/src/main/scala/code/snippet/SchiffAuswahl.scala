package code
package snippet
import _root_.net.liftweb.http.js.{JE,JsCmd,JsCmds}
import net.liftweb.http.SHtml
import net.liftweb.http.js.JsCmd
import net.liftweb.util.Helpers._
import scala.xml.NodeSeq
import scala.xml.Group
import code.comet.SchiffeServer
import net.liftweb.http.js.JE.Str


class SchiffAuswahl {
  
  def ajaxFunc1 : JsCmd = SchiffeServer ! "1"
  def ajaxFunc2 : JsCmd = SchiffeServer ! "1"

def renderAjaxButton(html: Group): NodeSeq = {
    bind("highlight", html,         
            "zerstoerer_mittel" -> SHtml.ajaxButton("Zerstörer", ajaxFunc1 _),
            "uboot_mittel" -> SHtml.ajaxButton("U-Boot", ajaxFunc1 _),
             
            "kreuzer_mittel" -> SHtml.ajaxButton("U-Boot", ajaxFunc1 _)
              
) }
}
