package code
package snippet

import net.liftweb.http.js.JE.JsFunc
import net.liftweb.http.js.JsCmd
import code.comet.SchiffeServer
import scala.xml.NodeSeq
import schiffe.Schiffe
import net.liftweb.http.S


object SchiffAuswahl {
  
  def setzen(in: NodeSeq):NodeSeq = {
    
   
 

    for {
      r <- S.request if r.post_? 
      typ <- S.param("type") 
      schiff <- S.param("schiff") 
      reihe <- S.param("reihe")
      spalte <- S.param("spalte")
      richtung <- S.param("richtung")
    } 
      typ match{
        case "set" => 
          schiff match{
            case "Zerstörer" =>
              var laenge = 2
            case "U-Boot" =>
              var laenge = 3
            case "Kreuzer" =>
              var laenge = 4
            case "Schlachtschiff" =>
              var laenge = 5
          }
        richtung match{
          case "oben" =>
            var richtung = 2
          case "unten" =>
            var richtung = 1
          case "rechts" =>
            var richtung = 2
          case "links" =>
            var richtung = 3
        }
         Schiffe.controller.set(laenge, reihe, spalte, richtung, (groesse - 1)) == true
 
          
        case "hit" =>
      }
      
     {



      S.notice("Name: "+name)
      S.notice("Age: "+age)
      S.redirectTo("/")
    }

    in
  
}
  
  def schiffe(in: NodeSeq):NodeSeq = {
    Schiffe.controller.getSize match{
      case 2 => <select name="schiff"><option>Zerstörer</option></select>
      case 5 => <select name="schiff"><option>Zerstörer</option><option>U-Boot</option><option>Kreuzer</option></select>
        
      case 10 => <select name="schiff"><option>Zerstörer 1</option><option>Zerstörer 2</option><option>Zerstörer 3</option><option>Zerstörer 4</option><option>U-Boot 1</option><option>U-Boot 2</option><option>U-Boot 3</option><option>Kreuzer 1</option><option>Kreuzer 2</option><option>Schlachtschiff</option></select>
    }
    
    
  }
  
def startButtonReihe(in: NodeSeq):NodeSeq = {
  Schiffe.controller.getSize match{
      case 2 => <select name="reihe"><option>1</option><option>2</option></select>
      case 5 => <select name="reihe"><option>1</option><option>2</option><option>3</option><option>4</option><option>5</option></select>
        
      case 10 => <select name="reihe"><option>1</option><option>2</option><option>3</option><option>4</option><option>5</option><option>6</option><option>7</option><option>8</option><option>9</option><option>10</option></select>
    }
  
  
}
def startButtonSpalte(in: NodeSeq):NodeSeq = {
  Schiffe.controller.getSize match{
      case 2 => <select name="spalte"><option>1</option><option>2</option></select>
      case 5 => <select name="spalte"><option>1</option><option>2</option><option>3</option><option>4</option><option>5</option></select>
        
      case 10 => <select name="spalte"><option>1</option><option>2</option><option>3</option><option>4</option><option>5</option><option>6</option><option>7</option><option>8</option><option>9</option><option>10</option></select>
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
