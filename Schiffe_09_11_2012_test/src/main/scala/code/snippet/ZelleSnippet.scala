package code
package 
snippet

import net.liftweb._
import util._
import Helpers._
import http._
import js.JsCmds._
import net.liftweb.http.SHtml
import net.liftweb.http.js.JsCmd
import net.liftweb.http.js.JE.Str

import schiffe._
import comet.SchiffeServer

class ZelleSnippet {

  def render = {
    val block:Int = Schiffe.Controller.getSize()
    val rowString = S.attr("row") openOr "row is not defined"
    val row = rowString.toInt
    val columnString = S.attr("column") openOr "column is not defined"
    val column = columnString.toInt
    var blockname = "";
    var str:String = "Zelle"
    val myCell = Schiffe.Controller.cell(row,column)
    def setCell(str: String) :JsCmd = {SchiffeServer ! rowString+columnString+str}
    def showCell(str:String) :JsCmd = {SchiffeServer ! rowString+columnString}
    row % block match {
      case 0 => blockname = "N"
      case 1 => blockname = if(block == 2) "S" else ""
      case 2 => blockname = "S"
      
    }
    column % block match {
      case 0 => blockname = blockname + "W"
      case 1 => blockname = blockname + (if(block == 2) "E" else "")
      case 2 => blockname = blockname + "E"
      
    }
    if (blockname == "") blockname = "C"
    blockname += "block";
    var modus =  if (Schiffe.Controller.cell(row,column).isGiven) "given" else 
                if (Schiffe.Controller.cell(row,column).isHighlighted) "highlighted" else "normal"
    val value = Schiffe.Controller.cell(row,column).toString

    if ((myCell.isShowingCandidates || Schiffe.Controller.showAllCandidates) && !myCell.isSet) {
            <td id={ blockname }>
              <div class="cellouter">
                <div id={modus} class="cellborder">
                  <div class="cell">
                    <table class="candidate" align="center">
                      <tr>
                        <td class="candidatecell" onclick={SHtml.ajaxCall("1", setCell _)._2.toJsCmd}>{if (Schiffe.Controller.available(row, column).contains(1)) "1" else " "}</td>
                        <td class="candidatecell" onclick={SHtml.ajaxCall("2", setCell _)._2.toJsCmd}>{if (Sudoku.controller.available(row, column).contains(2)) "2" else " "}</td>
                        <td class="candidatecell" onclick={SHtml.ajaxCall("3", setCell _)._2.toJsCmd}>{if (Sudoku.controller.available(row, column).contains(3)) "3" else " "}</td>
                      </tr>
                      <tr>
                        <td class="candidatecell" onclick={SHtml.ajaxCall("4", setCell _)._2.toJsCmd}>{if (Sudoku.controller.available(row, column).contains(4)) "4" else " "}</td>
                        <td class="candidatecell" onclick={SHtml.ajaxCall("5", setCell _)._2.toJsCmd}>{if (Sudoku.controller.available(row, column).contains(5)) "5" else " "}</td>
                        <td class="candidatecell" onclick={SHtml.ajaxCall("6", setCell _)._2.toJsCmd}>{if (Sudoku.controller.available(row, column).contains(6)) "6" else " "}</td>
                      </tr>
                      <tr>
                        <td class="candidatecell" onclick={SHtml.ajaxCall("7", setCell _)._2.toJsCmd}>{if (Sudoku.controller.available(row, column).contains(7)) "7" else " "}</td>
                        <td class="candidatecell" onclick={SHtml.ajaxCall("8", setCell _)._2.toJsCmd}>{if (Sudoku.controller.available(row, column).contains(8)) "8" else " "}</td>
                        <td class="candidatecell" onclick={SHtml.ajaxCall("9", setCell _)._2.toJsCmd}>{if (Sudoku.controller.available(row, column).contains(9)) "9" else " "}</td>
                      </tr> 
                    </table>
                  </div>
                </div>
              </div>
            </td>
    } else {
    <td id={ blockname }>
      <div class="cellouter">
        <div id={modus} class="cellborder">
          <div class="cell" onclick={SHtml.ajaxCall(str.toString, showCell _)._2.toJsCmd}>{ value } </div>
        </div>
      </div>
    </td>
    }

  }

}