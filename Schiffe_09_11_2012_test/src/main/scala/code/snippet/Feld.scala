package code 
package snippet 

import scala.xml.{NodeSeq, Text}
import schiffe._
import net.liftweb.util._
import net.liftweb.common._
import java.util.Date
import code.lib._
import Helpers._
import net.liftweb.http.SHtml
import net.liftweb.http.js.JsCmds.Alert
import net.liftweb.http.js.JsCmds.Confirm
import net.liftweb.http.js.JsCmd
import net.liftweb.http.js.JE.JsRaw
import net.liftweb.http.js.JsCmds
import net.liftweb.http.S

class Feld {
  


def createSchiffe = 
<table class="schiffeAuswahl" >
<tbody width="300" height="300">
  {  var aktuelleLaenge = 0 }
  
  {var schlachtschiff_icon = "images/Schlachtschiff.png"
  var kreuzer_icon = "images/Kreuzer.png"
  var uboot_icon ="images/UBoot.png"
  var zerstoerer_icon = "images/Zerstoerer.png"
  var z_einzeln = false
  var z = false
        var u = false
        var k = false
         var z1_gross = false
        var z2_gross = false
        var z3_gross = false
        var z4_gross = false
        var u1_gross = false
        var u2_gross = false
        var u3_gross = false
        var k1_gross = false
        var k2_gross = false
        var s_gross = false}
        
  {Schiffe.controller.getSize match{
    case 2 => 
       <tr><td><button id="z_klein" onClick="setSchiffBackground(this);" style="background-color:white; text-align:center; vertical-align:middle; font-size:25px; height: 50px; width: 200px;" name="zerstoerer_klein" type="button" value="Zerstörer">
      <table><tr><td>
       <img src="images\Zerstoerer.png"  alt="Zerstoerer" ></img></td><td> Zerstörer</td></tr></table>
        
      
        </button></td></tr>
      
    case 5 =>
      <tr><td><button id="z_mittel" onClick="setSchiffBackground(this);" name="zerstoerer_mittel" type="button" value="Zerstoerer" style="background-color:white; text-align:center; vertical-align:middle; font-size:18px; height: 81px; width:241px;" >
      <table><tr><td>
       <img src="images\Zerstoerer.png"  alt="Zerstoerer" ></img></td><td>Zerstörer</td></tr></table>
        
      
        </button>
</td></tr>
      <tr><td><button id="u_mittel" onClick="setSchiffBackground(this);" style="background-color:white; text-align:center; vertical-align:middle; font-size:18px; height: 81px; width: 241px;" name="uboot_mittel" type="button" value="U-Boot">
      <table><tr><td>
       <img src="images\UBoot.png"  alt="U-Boot" ></img></td><td>U-Boot</td></tr></table>
      
        </button> </td></tr>
      <tr><td><button id="k_mittel" width="300" onClick="setSchiffBackground(this);" style="background-color:white; text-align:center; vertical-align:middle; font-size:18px; height: 81px; width: 241px;" name="kreuzer_mittel" type="button" value="Kreuzer">
      <table><tr><td>
       <img src="images\Kreuzer.png"  alt="Kreuzer" ></img></td><td>Kreuzer</td></tr></table>
        
      
        </button></td></tr>
      
    case 10 =>
     <tr><td><button id="z1" onClick="setSchiffBackground(this);" style="background-color:white; text-align:center; vertical-align:middle; font-size:15px; height: 47px; width: 330px;" name="zerstoerer1_gross" type="button" value="1.ter Zerstörer">
      <table><tr><td>
       <img src="images\Zerstoerer.png"  alt="Zerstoerer_1" ></img></td><td>1.ter Zerstörer</td></tr></table>
      
        </button></td></tr>
      <tr><td><button id="z2" onClick="setSchiffBackground(this);" style="background-color:white; text-align:center; vertical-align:middle; font-size:15px; height: 47px; width: 330px;" name="zerstoerer2_gross" type="button" value="2.ter Zerstörer">
      <table><tr><td>
       <img src="images\Zerstoerer.png"  alt="Zerstoerer_2" ></img></td><td>2.ter Zerstörer
        
      </td></tr></table>
        </button></td></tr>
      <tr><td><button id="z3" onClick="setSchiffBackground(this);" style="background-color:white; text-align:center; vertical-align:middle; font-size:15px; height: 47px; width: 330px;" name="zerstoerer3_gross" type="button" value="3.ter Zerstörer">
      <table><tr><td>
       <img src="images\Zerstoerer.png"  alt="Zerstoerer_3" ></img></td><td>3.ter Zerstörer
        
      </td></tr></table>
        </button></td></tr>
      <tr><td><button id="z4" onClick="setSchiffBackground(this);" style="background-color:white; text-align:center; vertical-align:middle; font-size:15px; height: 47px; width: 330px;" name="zerstoerer4_gross" type="button" value="4.ter Zerstörer">
     <table><tr><td>
       <img src="images\Zerstoerer.png"  alt="Zerstoerer_4" ></img></td><td>4.ter Zerstörer
        
      </td></tr></table>
        </button></td></tr>
      <tr><td><button id="u1" onClick="setSchiffBackground(this);" style="background-color:white; text-align:center; vertical-align:middle; font-size:15px; height: 47px; width: 330px;" name="uboot1_gross" type="button" value="1.tes U-Boot">
      <table><tr><td>
       <img src="images\UBoot.png"  alt="U-Boot_1" ></img></td><td>1.tes U-Boot
      </td></tr></table>
        </button> </td></tr>
      <tr><td><button id="u2" onClick="setSchiffBackground(this);" style="background-color:white; text-align:center; vertical-align:middle; font-size:15px; height: 47px; width: 330px;" name="uboot2_gross" type="button" value="2.tes U-Boot">
      <table><tr><td>
       <img src="images\UBoot.png"  alt="U-Boot_2" ></img></td><td>2.tes U-Boot
      </td></tr></table>
        </button> </td></tr>
      <tr><td><button id="u3" onClick="setSchiffBackground(this);" style="background-color:white; text-align:center; vertical-align:middle; font-size:15px; height: 47px; width: 330px;" name="uboot3_gross" type="button" value="3.tes U-Boot">
      <table><tr><td>
       <img src="images\UBoot.png"  alt="U-Boot_3" ></img></td><td>3.tes U-Boot
      </td></tr></table>
        </button> </td></tr>
      <tr><td><button id="k1" onClick="setSchiffBackground(this);" style="background-color:white; text-align:center; vertical-align:middle; font-size:15px; height: 47px; width: 330px;" name="kreuzer1_gross" type="button" value="1.ter Kreuzer">
      <table><tr><td>
       <img src="images\Kreuzer.png"  alt="Kreuzer_1" ></img></td><td>1.ter Kreuzer
        
      </td></tr></table>
        </button></td></tr>
      <tr><td><button id="k2" onClick="setSchiffBackground(this);" style="background-color:white; text-align:center; vertical-align:middle; font-size:15px; height: 47px; width: 330px;" name="kreuzer2_gross" type="button" value="2.ter Kreuzer">
      <table><tr><td>
       <img src="images\Kreuzer.png"  alt="Kreuzer_2" ></img></td><td>2.ter Kreuzer
        
     </td></tr></table>
        </button></td></tr>
      <tr><td><button id="s" onClick="setSchiffBackground(this);" style="background-color:white; text-align:center; vertical-align:middle; font-size:15px; height: 47px; width: 330px;" name="schlachtschiff_gross" type="button" value="Schlachtschiff">
      <table><tr><td>
       <img src="images\Schlachtschiff.png"  alt="Schlachtschiff" ></img></td><td>Schlachtschiff
        
      </td></tr></table>
        </button></td></tr>
  }
  }
 </tbody>
</table>
    
   


  def createUserFeld = {
  <table class="grid" border="1" bordercolor="blue" cellspacing="0" cellpadding="0">
   {
    
         for (row <- 0 until Schiffe.controller.getSize) yield {
          <tr border="0">
            {
              for (column <- 0 until Schiffe.controller.getSize) yield {
                var gesetzt = Schiffe.controller.cell(row, column).getGesetzt
                var getroffen = Schiffe.controller.cell(row, column).getGetroffen
                if (gesetzt) {
                  if(getroffen){
                    <td style="height: 48px; width: 48px;" border="0">
                    <button onClick="setStart(this)" id="button" border="0" style="background-color:red; text-align:center; vertical-align:center; font-size:20px; height: 48px; width: 48px;" type="button">
                      
                    </button>
                  </td>
                  }else{
                  <td style="height: 48px; width: 48px;" border="0">
                    <button onClick="setStart(this)" id="button" border="0" style="background-color:green; text-align:center; vertical-align:center; font-size:20px; height: 48px; width: 48px;" type="button">
                     
                    </button>
                  </td>
                  }
                }else{
                  if(getroffen){
                    <td style="height: 48px; width: 48px;" border="0">
                    <button onClick="setStart(this)" id="button" border="0" style="background-color:black; text-align:center; vertical-align:center; font-size:20px; height: 48px; width: 48px;" type="button">
                      
                    </button>
                  </td>
                    
                  }else{
                    <td style="height: 48px; width: 48px;" border="0">
                    <button onClick="setStart(this)" id="button" border="0" style="background-color:gray; text-align:center; vertical-align:center; font-size:20px; height: 48px; width: 48px;" type="button">
                     
                    </button>
                  </td>
                  }
                }

                    
                     }
                  
                  }
             </tr>
         }
     }
     </table>
   }   

   def createPcFeld = {
  <table class="grid" border="1" bordercolor="blue" cellspacing="0" cellpadding="0">
   {
    
         for (row <- 0 until Schiffe.controller.getSize) yield {
             <tr>
                  { for (column <- 0 until Schiffe.controller.getSize) yield {
                    var gesetzt = Schiffe.pccontroller.cell(row, column).getGesetzt
                    var getroffen = Schiffe.controller.cell(row, column).getGetroffen
                if (gesetzt) {
                  if(getroffen){
                    <td style="height: 48px; width: 48px;" border="0"><form method="post">
                    <input class={"lift:ChatIn.hit?reihe=" + row + ";spalte=" + column} id="button" border="0" style="background-color:red; text-align:center; vertical-align:center; font-size:20px; height: 48px; width: 48px;" type="submit">
                      
                    </input>
</form>
                  </td>
                  }else{
                  <td style="height: 48px; width: 48px;" border="0">
                    <form method="post"><input class={"lift:ChatIn.hit?reihe=" + row + ";spalte=" + column} id="button" border="0" style="background-color:gray; text-align:center; vertical-align:center; font-size:20px; height: 48px; width: 48px;" type="submit">
                     
                    </input></form>
                  </td>
                  }
                }else{
                  if(getroffen){
                    <td style="height: 48px; width: 48px;" border="0">
                    <form method="post"><input class={"lift:ChatIn.hit?reihe=" + row + ";spalte=" + column} id="button" border="0" style="background-color:black; text-align:center; vertical-align:center; font-size:20px; height: 48px; width: 48px;" type="submit">
                      
                    </input></form>
                  </td>
                    
                  }else{
                    <td style="height: 48px; width: 48px;" border="0">
                    <form method="post"><input class={"lift:ChatIn.hit?reihe=" + row + ";spalte=" + column} id="button" border="0" style="background-color:gray; text-align:center; vertical-align:center; font-size:20px; height: 48px; width: 48px;" type="submit">
                     
                    </input></form>
                  </td>
                  }
                }

                    
                     }
                  
                  }
             </tr>
         }
     }
     </table>
   }   
   def schiffeSetzen(reihe: Int, spalte: Int): JsCmd = 
     Alert("OOUUZUZUZ")
   JsCmds.SetHtml("HHHHH Gesetzt", createPcFeld)
}
