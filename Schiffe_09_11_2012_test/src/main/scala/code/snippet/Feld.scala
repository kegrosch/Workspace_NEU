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
       <tr><td><button style="background-color:white; text-align:center; vertical-align:middle; font-size:35px" name="zerstoerer_klein" type="button" value="Zerstörer">
      <p>
       <img src="images\Zerstoerer.png"  alt="Zerstoerer" ></img> Zerstörer
        
      </p>
        </button></td></tr>
      
    case 5 =>
      <tr><td><button style="background-color:white; text-align:center; vertical-align:middle; font-size:35px" name="zerstoerer_mittel" type="button" value="Zerstörer">
      <p>
       <img src="images\Zerstoerer.png"  alt="Zerstoerer" ></img> Zerstörer
        
      </p>
        </button></td></tr>
      <tr><td><button style="background-color:white; text-align:center; vertical-align:middle; font-size:35px" name="uboot_mittel" type="button" value="U-Boot">
      
       <img src="images\UBoot.png"  alt="U-Boot" ></img> U-Boot
      
        </button> </td></tr>
      <tr><td><button style="background-color:white; text-align:center; vertical-align:middle; font-size:35px" name="kreuzer_mittel" type="button" value="Kreuzer">
      <p>
       <img src="images\Kreuzer.png"  alt="Kreuzer" ></img> Kreuzer
        
      </p>
        </button></td></tr>
      
    case 10 =>
     <tr><td><button style="background-color:white; text-align:center; vertical-align:middle; font-size:35px" name="zerstoerer1_gross" type="button" value="1.ter Zerstörer">
      <p>
       <img src="images\Zerstoerer.png"  alt="Zerstoerer_1" ></img> 1.ter Zerstörer
        
      </p>
        </button></td></tr>
      <tr><td><button style="background-color:white; text-align:center; vertical-align:middle; font-size:35px" name="zerstoerer2_gross" type="button" value="2.ter Zerstörer">
      <p>
       <img src="images\Zerstoerer.png"  alt="Zerstoerer_2" ></img> 2.ter Zerstörer
        
      </p>
        </button></td></tr>
      <tr><td><button style="background-color:white; text-align:center; vertical-align:middle; font-size:35px" name="zerstoerer3_gross" type="button" value="3.ter Zerstörer">
      <p>
       <img src="images\Zerstoerer.png"  alt="Zerstoerer_3" ></img> 3.ter Zerstörer
        
      </p>
        </button></td></tr>
      <tr><td><button style="background-color:white; text-align:center; vertical-align:middle; font-size:35px" name="zerstoerer4_gross" type="button" value="4.ter Zerstörer">
      <p>
       <img src="images\Zerstoerer.png"  alt="Zerstoerer_4" ></img> 4.ter Zerstörer
        
      </p>
        </button></td></tr>
      <tr><td><button style="background-color:white; text-align:center; vertical-align:middle; font-size:35px" name="uboot1_gross" type="button" value="1.tes U-Boot">
      
       <img src="images\UBoot.png"  alt="U-Boot_1" ></img> 1.tes U-Boot
      
        </button> </td></tr>
      <tr><td><button style="background-color:white; text-align:center; vertical-align:middle; font-size:35px" name="uboot2_gross" type="button" value="2.tes U-Boot">
      
       <img src="images\UBoot.png"  alt="U-Boot_2" ></img> 2.tes U-Boot
      
        </button> </td></tr>
      <tr><td><button style="background-color:white; text-align:center; vertical-align:middle; font-size:35px" name="uboot3_gross" type="button" value="3.tes U-Boot">
      
       <img src="images\UBoot.png"  alt="U-Boot_3" ></img> 3.tes U-Boot
      
        </button> </td></tr>
      <tr><td><button style="background-color:white; text-align:center; vertical-align:middle; font-size:35px" name="kreuzer1_gross" type="button" value="1.ter Kreuzer">
      <p>
       <img src="images\Kreuzer.png"  alt="Kreuzer_1" ></img> 1.ter Kreuzer
        
      </p>
        </button></td></tr>
      <tr><td><button style="background-color:white; text-align:center; vertical-align:middle; font-size:35px" name="kreuzer2_gross" type="button" value="2.ter Kreuzer">
      <p>
       <img src="images\Kreuzer.png"  alt="Kreuzer_2" ></img> 2.ter Kreuzer
        
      </p>
        </button></td></tr>
      <tr><td><button style="background-color:white; text-align:center; vertical-align:middle; font-size:35px" name="schlachtschiff_gross" type="button" value="Schlachtschiff">
      <p>
       <img src="images\Schlachtschiff.png"  alt="Schlachtschiff" ></img> Schlachtschiff
        
      </p>
        </button></td></tr>
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
