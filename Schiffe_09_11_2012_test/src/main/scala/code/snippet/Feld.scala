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

class Feld {
  


def createSchiffe = 
<table class="schiffeAuswahl" border="1" >

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
      
        
      
    
       <tr><td width="350" height="60"><button name="zerstoerer_klein" type="button" value="Zerstörer">
      <p>
       <img src="images\Zerstoerer.png"  alt="Zerstoerer" ></img>
        
      </p>
        </button></td></tr>


    
    case 5 =>
    case 10 =>
    
  }
  }
 
</table>
    
   


  def createUserFeld = {
  <table class="grid" border="1" cellspacing="10" cellpadding="8">
   {
    
         for (row <- 0 until Schiffe.controller.getSize) yield {
             <tr>
                  { for (column <- 0 until Schiffe.controller.getSize) yield {
                    var gesetzt = Schiffe.controller.cell(row, column).getGesetzt
//                    {<td class={"reihe="+row+"&column="+column}>{if(gesetzt)"X"else " "}</td>
                    <td width="20px" class="candidate" id="Nblock">{if(gesetzt)"   X   "else "   X   "}</td>
                     }
                  
                  }
             </tr>
         }
     }
     </table>
   }   
   def createPcFeld = {
  <table class="grid" border="1" cellspacing="10" cellpadding="8">
   {
    
         for (row <- 0 until Schiffe.controller.getSize) yield {
             <tr>
                  { for (column <- 0 until Schiffe.controller.getSize) yield {
                    var gesetzt = Schiffe.controller.cell(row, column).getGesetzt
                    <td  id={"reihe="+row+"&column="+column}>{if(gesetzt)"X"else " "}
                   <form>         
                   <input type="submit" value=" "/>
                    </form>
</td>
                   
                  }
                  //class={"lift:SchiffeSetzen.neuStarten("+ row + "," + column + ",2,5)"} 
                  
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
