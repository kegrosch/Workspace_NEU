package code
package snippet

import net.liftweb._
import util._
import Helpers._
import http._
import js.JsCmds._
import schiffe._

object SchiffAuswahl {
  
  def render = {
    "button [onClick]" #> 
    SHtml.ajaxInvoke(() => {
      Schiffe.controller.hit(1,1)
      Alert("JJJJJJJJJJJJJ")
      Alert("JJJJJJJJJJJJJ")
    })
  }

}