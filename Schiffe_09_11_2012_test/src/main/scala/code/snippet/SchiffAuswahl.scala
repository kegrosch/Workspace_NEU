package code
package snippet

import net.liftweb._
import util._
import Helpers._
import http._
import js.JsCmds._
import schiffe._
import net.liftweb.http.js.JsCmds

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
  def render = "zerstoerer_mittel [onclick]" #> SHtml.ajaxInvoke(() => {println("click"); JsCmds.Alert("Hi")} )

}