package code 
package snippet 

import scala.xml.{NodeSeq, Text}
import schiffe._
import net.liftweb.util._
import net.liftweb.common._
import java.util.Date
import code.lib._
import Helpers._

class Feld {
  
var anzahl = Schiffe.controller.getSize
//
//
//def getFeld = "#feld *" #> createFeld(anzahl)
//def getFeld = "#feld *" #> <tr><td>GGGGGG</td><td>HHHHH</td></tr><tr><td>JJJJJ</td><td>KKKKK</td></tr>;




  def createFeld: String = {
  
  <table class="feld">{
         for(i <- 1 to (anzahl-1)) yield{
             <tr>
                 {for(j <- 1 to (anzahl-1)) yield{
                     <td class={"reihe"+i+"spalte"+j + ">"+ i + " / " + j +}</td>}
                     
                  
                
             
                 }
}
}
}
}
                 
              </tr>  
                 }      
                 
                 
                 }</table>
                 
                 

  
  
  }
  
}
