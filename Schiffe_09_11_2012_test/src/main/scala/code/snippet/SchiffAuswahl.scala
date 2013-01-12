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
  def render = "@zerstoerer_mittel [onfocus]" #> SHtml.ajaxInvoke(() => {ChatIn.buttonClicked; println("click"); JsCmds.Alert("Hi");Alert("UUUUU")} )


  def click(in: NodeSeq):NodeSeq = {
    
    <button onFocus="javascript:setSchiffButtonsColor()" id="zerstoerer_mittel" name="zerstoerer_mittel" type="button" value="Zerstoerer" style="background-color:white; text-align:center; vertical-align:middle; font-size:35px" >
      
       <img src="images\Zerstoerer.png"  alt="Zerstoerer" ></img> Zerstoerer
        
      
        </button>

  }
}

