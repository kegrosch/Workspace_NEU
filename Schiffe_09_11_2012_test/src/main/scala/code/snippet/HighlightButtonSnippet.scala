package code
package snippet

import net.liftweb.http.SHtml
import net.liftweb.http.js.JsCmd
import net.liftweb.util.Helpers._
import scala.xml.NodeSeq
import scala.xml.Group

import comet.SudokuServer

class HighlightButtonSnippet {

  def ajaxFunc0 : JsCmd = SudokuServer ! "0"
  def ajaxFunc1 : JsCmd = SudokuServer ! "1"
  def ajaxFunc2 : JsCmd = SudokuServer ! "2"
  def ajaxFunc3 : JsCmd = SudokuServer ! "3"
  def ajaxFunc4 : JsCmd = SudokuServer ! "4"
  def ajaxFunc5 : JsCmd = SudokuServer ! "5"
  def ajaxFunc6 : JsCmd = SudokuServer ! "6"
  def ajaxFunc7 : JsCmd = SudokuServer ! "7"
  def ajaxFunc8 : JsCmd = SudokuServer ! "8"
  def ajaxFunc9 : JsCmd = SudokuServer ! "9"

  def renderAjaxButton(html: Group): NodeSeq = {
    bind("highlight", html,         
            "button0" -> SHtml.ajaxButton("0", ajaxFunc0 _),
            "button1" -> SHtml.ajaxButton("1", ajaxFunc1 _),
            "button2" -> SHtml.ajaxButton("2", ajaxFunc2 _),
            "button3" -> SHtml.ajaxButton("3", ajaxFunc3 _),
            "button4" -> SHtml.ajaxButton("4", ajaxFunc4 _),
            "button5" -> SHtml.ajaxButton("5", ajaxFunc5 _),
            "button6" -> SHtml.ajaxButton("6", ajaxFunc6 _),
            "button7" -> SHtml.ajaxButton("7", ajaxFunc7 _),
            "button8" -> SHtml.ajaxButton("8", ajaxFunc8 _),
            "button9" -> SHtml.ajaxButton("9", ajaxFunc9 _)
        )
  }

}