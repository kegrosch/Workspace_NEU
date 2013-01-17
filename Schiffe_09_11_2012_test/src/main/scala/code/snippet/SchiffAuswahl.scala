package code
package snippet

import net.liftweb.http.js.JE.JsFunc
import net.liftweb.http.js.JsCmd
import code.comet.SchiffeServer
import scala.xml.NodeSeq
import schiffe.Schiffe
import net.liftweb.http.S
import net.liftweb.http.js._
import JsCmds._


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
  
  def isSet ={
    Schiffe.controller.getSize match{
      case 2 =>{
         if(z_klein==true){
      <input type="hidden"/>
    }else{
      <form id="form2" class="lift:SchiffSetzen?form=post">
							<select name="typ">
								<option name="typ" value="set">Schiffe setzen</option>
								<option name="typ" value="hit">Schiessen</option>
							</select>
					
						
						<select name="schiff"><option class="lift:SchiffAuswahl.schiffe"></option></select>

					
						<select name="reihe"><option class="lift:SchiffAuswahl.startButtonReihe"></option></select>
					
						<select name="spalte"> <option class="lift:SchiffAuswahl.startButtonSpalte"></option></select>
					<select name="richtung">
							<option>rechts</option>
							<option>links</option>
							<option>oben</option>
							<option>unten</option>
					</select>
					<input type="submit" value="Schiff setzen"/>
					</form>
    }
        
      }
      case 5 =>{
         if(z_mittel==true && u_mittel==true && k_mittel==true){
      <input type="hidden"/>
    }else{
      <form id="form2" class="lift:SchiffSetzen?form=post">
							<select name="typ">
								<option name="typ" value="set">Schiffe setzen</option>
								<option name="typ" value="hit">Schiessen</option>
							</select>
					
						
						<select name="schiff"><option class="lift:SchiffAuswahl.schiffe"></option></select>

					
						<select name="reihe"><option class="lift:SchiffAuswahl.startButtonReihe"></option></select>
					
						<select name="spalte"> <option class="lift:SchiffAuswahl.startButtonSpalte"></option></select>
					<select name="richtung">
							<option>rechts</option>
							<option>links</option>
							<option>oben</option>
							<option>unten</option>
					</select>
					<input type="submit" value="Schiff setzen"/>
					</form>
    }
        
      }
      case 10 =>{
         if(z1==true && z2==true && z4==true && u1==true && u2==true && u3==true &&k1==true && k2==true && s==true){
      <input type="hidden"/>
    }else{
      <form id="form2" class="lift:SchiffSetzen?form=post">
							<select name="typ">
								<option name="typ" value="set">Schiffe setzen</option>
								<option name="typ" value="hit">Schiessen</option>
							</select>
					
						
						<select name="schiff"><option class="lift:SchiffAuswahl.schiffe"></option></select>

					
						<select name="reihe"><option class="lift:SchiffAuswahl.startButtonReihe"></option></select>
					
						<select name="spalte"> <option class="lift:SchiffAuswahl.startButtonSpalte"></option></select>
					<select name="richtung">
							<option>rechts</option>
							<option>links</option>
							<option>oben</option>
							<option>unten</option>
					</select>
					<input type="submit" value="Schiff setzen"/>
					</form>
    }
        
      }
    }
   
  }
  def schiffe(in: NodeSeq):NodeSeq = {
    Schiffe.controller.getSize match{
      case 2 => <option id="z_klein" value="Zerstörer">Zerstörer</option>
       
      case 5 => <option id="z_mittel" value="Zerstörer">Zerstörer</option><option id="u_mittel" value="U-Boot">U-Boot</option><option id="k_mittel" value="Kreuzer">Kreuzer</option>
        
      case 10 => <option id="z1" value="Zerstörer">Zerstörer 1</option><option id="z2" value="Zerstörer">Zerstörer 2</option><option id="z3" value="Zerstörer">Zerstörer 3</option><option id="z4" value="Zerstörer">Zerstörer 4</option><option id="u2" value="U-Boot">U-Boot 1</option><option id="u2" value="U-Boot">U-Boot 2</option><option id="u3" value="U-Boot">U-Boot 3</option><option id="k1" value="Kreuzer">Kreuzer 1</option><option id="k2" value="Kreuzer">Kreuzer 2</option><option id="s" value="Schlachtschiff">Schlachtschiff</option>
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
