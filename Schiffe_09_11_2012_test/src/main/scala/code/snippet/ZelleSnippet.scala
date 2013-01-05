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
    val block:Int = Schiffe.controller.getSize
    val rowString = S.attr("row") openOr "row is not defined"
    val row = rowString.toInt
    val columnString = S.attr("column") openOr "column is not defined"
    val column = columnString.toInt
    var blockname = "";
    var str:String = "cell"
    val myCell = Schiffe.controller.cell(row,column)
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
    var modus =  if (Schiffe.controller.cell(row,column).getGesetzt) "given" else 
                if (Schiffe.controller.cell(row,column).getGetroffen) "highlighted" else "normal"
    val value = Schiffe.controller.cell(row,column).toString



  }

}