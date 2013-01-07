package code.snippet
import net.liftweb.http.js.JsCmd
import net.liftweb.http.js.JsCmds.Alert
import net.liftweb.http.SHtml

class SchiffeSetzen {

  def onClick(reihe: Int, spalte: Int):JsCmd = {
    Alert("You Click: " + reihe + " " + spalte)
  }
  
  def render = {
   
//    "#clickable [onClick]" #> SHtml.onEvent(onClick(5,7))
    
  }
  
  
}