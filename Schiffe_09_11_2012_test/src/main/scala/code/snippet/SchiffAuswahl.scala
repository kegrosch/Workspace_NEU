package code
package snippet

import net.liftweb.http.js.JE.JsFunc
import net.liftweb.http.js.JsCmd
import code.comet.SchiffeServer
import scala.xml.NodeSeq
import schiffe.Schiffe
import net.liftweb.http.S


object SchiffAuswahl {
  var z_klein = false
  var z_mittel = false
  var u_mittel = false
  var k_mittel = false
  var z1 = false
  var z2 = false
  var z3 = false
  var z4 = false
  var u1 = false
  var u2 = false
  var u3 = false
  var k1 = false
  var k2 = false
  var s = false
  
  def schiffe(in: NodeSeq):NodeSeq = {
    Schiffe.controller.getSize match{
      case 2 => if(z_klein==false){<option value="Zerstörer">Zerstörer</option>}else{ <div></div>}
       
      case 5 => <option value="Zerstörer">Zerstörer</option><option value="U-Boot">U-Boot</option><option value="Kreuzer">Kreuzer</option>
        
      case 10 => <option value="Zerstörer">Zerstörer 1</option><option value="Zerstörer">Zerstörer 2</option><option value="Zerstörer">Zerstörer 3</option><option value="Zerstörer">Zerstörer 4</option><option value="U-Boot">U-Boot 1</option><option value="U-Boot">U-Boot 2</option><option value="U-Boot">U-Boot 3</option><option value="Kreuzer">Kreuzer 1</option><option value="Kreuzer">Kreuzer 2</option><option value="Schlachtschiff">Schlachtschiff</option>
    }
    
    
  }
  
def startButtonReihe(in: NodeSeq):NodeSeq = {
  Schiffe.controller.getSize match{
      case 2 => <option>1</option><option>2</option>
      case 5 => <option>1</option><option>2</option><option>3</option><option>4</option><option>5</option>
        
      case 10 => <option>1</option><option>2</option><option>3</option><option>4</option><option>5</option><option>6</option><option>7</option><option>8</option><option>9</option><option>10</option>
    }
  
  
}
def startButtonSpalte(in: NodeSeq):NodeSeq = {
  Schiffe.controller.getSize match{
      case 2 => <option>1</option><option>2</option>
      case 5 => <option>1</option><option>2</option><option>3</option><option>4</option><option>5</option>
        
      case 10 => <option>1</option><option>2</option><option>3</option><option>4</option><option>5</option><option>6</option><option>7</option><option>8</option><option>9</option><option>10</option>
    }
  
  
}
  
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
//		"button [onClick]" #> SHtml.ajaxInvoke()
//  
//  }

//val jsFunc: JsFunc = Function("myFunc")("param1", "param2") {case param1 :: param2 :: Nil =>
  
//}
}
