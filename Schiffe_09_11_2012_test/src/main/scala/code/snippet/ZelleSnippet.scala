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
    val reiheString = S.attr("reihe") openOr "reihe is not defined"
    val reihe = reiheString.toInt
    val spalteString = S.attr("spalte") openOr "spalte is not defined"
    val spalte = spalteString.toInt
    var blockname = "";
    var str:String = "Zelle"
    val myCell = Schiffe.Controller.cell(reihe,spalte)
    def setCell(str: String) :JsCmd = {SchiffeServer ! reiheString+spalteString+str}
    def showCell(str:String) :JsCmd = {SchiffeServer ! reiheString+spalteString}
    
    if (blockname == "") blockname = "C"
    blockname += "block";
  
    val value = if (Schiffe.Controller.cell(reihe,spalte).getGesetzt) "gesetzt" else 
                if (Schiffe.Controller.cell(reihe,spalte).getGetroffen) "getroffen" else "normal"

            <td id={ blockname }>
              <div class="cellouter">
                <div id={modus} class="cellborder">
                 value
                </div>
              </div>
            </td>
  

  }

}