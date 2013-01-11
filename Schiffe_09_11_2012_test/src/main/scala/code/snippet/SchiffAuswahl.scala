package code
package snippet

import net.liftweb._
import util._
import Helpers._
import http._
import js.JsCmds._
import schiffe._
import net.liftweb.http.js.JsCmds
import scala.xml.NodeSeq

object SchiffAuswahl {
  
//  def render = {
//    
//    "@zerstoerer_mittel [onclick]" #> SHtml.ajaxInvoke (() => {
////      info("Data confirmed!")
//      Alert("JJJJJJ")
//      JsCmds.Alert("We saved your \nName: %s\nLast name: %s\nAge: %s") &
//      JsCmds.JsHideId("finish")
//    })
//    
//  }
//  def render = "@zerstoerer_mittel [onclick]" #> SHtml.ajaxInvoke(() => {ChatIn.buttonClicked; println("click"); JsCmds.Alert("Hi");Alert("UUUUU")} )

  
  def render(in: NodeSeq): NodeSeq = {

var naem = S.param("zerstoerer_mittel")
S.notice("NNNN" + naem)

  in
}
  def click(in: NodeSeq):NodeSeq = {
    
    <button class="lift:SchiffAuswahl.render" onClick='lift:SchiffAuswahl.render' id="zerstoerer_mittel" name="zerstoerer_mittel" type="button" value="Zerst�rer" style="background-color:red; text-align:center; vertical-align:middle; font-size:35px" >
      
       <img src="images\Zerstoerer.png"  alt="Zerstoerer" ></img> Zerstoerer
        
      
        </button>

  }
}

