package code
package snippet

import net.liftweb.http.SHtml
import net.liftweb.http.js.JsCmd
import net.liftweb.util.Helpers._
import scala.xml.NodeSeq
import scala.xml.Group

import comet.SchiffeServer

class HighlightButtonSnippet{

  def ajaxFuncNeuStarten : JsCmd = SchiffeServer ! "neuStarten"
  def ajaxFuncGroesse2 : JsCmd = SchiffeServer ! "groesse2"
  def ajaxFuncGroesse5 : JsCmd = SchiffeServer ! "groesse5"
  def ajaxFuncGroesse10 : JsCmd = SchiffeServer ! "groesse10"
  def ajaxFuncLoesen : JsCmd = SchiffeServer ! "loesen"


  def renderAjaxButton(html: Group): NodeSeq = {
    bind("highlight", html,         
            "neuStarten" -> SHtml.ajaxButton("neuStarten", ajaxFuncNeuStarten _),
            "groesse2" -> SHtml.ajaxButton("groesse2", ajaxFuncGroesse2 _),
            "groesse5" -> SHtml.ajaxButton("groesse5", ajaxFuncGroesse5 _),
            "groesse10" -> SHtml.ajaxButton("groesse10", ajaxFuncGroesse10 _),
            "loesen" -> SHtml.ajaxButton("loesen", ajaxFuncLoesen _)
            
        )
  }

}