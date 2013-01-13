package code
package snippet

import net.liftweb.http.js.JE.JsFunc


object SchiffAuswahl {
  
//  def ajaxFunc1 : JsCmd = SchiffeServer ! "1"
//  def ajaxFunc2 : JsCmd = SchiffeServer ! "1"

//def renderAjaxButton(html: Group): NodeSeq = {
//    bind("highlight", html,         
//            "zerstoerer_mittel" -> SHtml.ajaxButton("Zerstörer", ajaxFunc1 _),
//            "uboot_mittel" -> SHtml.ajaxButton("U-Boot", ajaxFunc1 _),
//             
//            "kreuzer_mittel" -> SHtml.ajaxButton("U-Boot", ajaxFunc1 _)
//        
  
//) }
  
//def render = {
// "button [onClick]" #> SHtml.ajaxInvoke(JsCmds.("style" -> "backgroundColor:red"))
//  
//  }

val jsFunc: JsFunc = Function("myFunc")("param1", "param2") {case param1 :: param2 :: Nil =>
  
}
}
