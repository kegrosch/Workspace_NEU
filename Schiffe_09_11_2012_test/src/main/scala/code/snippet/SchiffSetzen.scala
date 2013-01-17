package code.snippet
import net.liftweb._
import http._
import util.Helpers._
import scala.xml.NodeSeq
import schiffe.Schiffe
import code.comet.SchiffeServer
import javax.swing.JOptionPane
import net.liftweb.http.js.JE.JsRaw
import net.liftweb.http.js.JsCmds.SetHtml
import net.liftweb.http.js.JsCmds.Replace
import net.liftweb.http.js._
import JsCmds._
import net.liftweb.http.js.JSArtifacts
import net.liftweb.http.js.JSArtifacts

object SchiffSetzen {
 var laenge = 0  
  var reihe = 0
  var spalte = 0
  var richtung = 0
  var schiff =""
    var typ =""
      var richt =""
  
  def render = {
  
  
  def process(){
      
    
    if(typ=="set"){
      if(schiff=="Zerstörer"){
        Schiffe.controller.getSize match{
          case 2 =>{ SchiffAuswahl.z_klein = true; Replace(("z_klein"), <input type="hidden"/>)}
          case 5 =>{ SchiffAuswahl.z_mittel = true; JsHideId("schifffSetzen")}
          case 10 => {
            if(SchiffAuswahl.z1==false){
              SchiffAuswahl.z1 = true
            		  Replace("z1", <input type="hidden"/>)
            }else{
              if(SchiffAuswahl.z2==false){
                SchiffAuswahl.z2=true
                Replace(("z2"), <input type="hidden"/>)
              }else{
                if(SchiffAuswahl.z3==false){
                  SchiffAuswahl.z3=true
                  Replace(("z3"), <input type="hidden"/>)
                }else{
                  SchiffAuswahl.z4=true
                  Replace(("z4"), <input type="hidden"/>)
                }
              }
            }
          }
        }
        laenge=2
      }else{
        if(schiff=="U-Boot"){
          Schiffe.controller.getSize match{
          case 5 => {SchiffAuswahl.u_mittel = true; Replace(("u_mittel"), <input type="hidden"/>)}
          case 10 => {
            if(SchiffAuswahl.u1==false){
              SchiffAuswahl.u1 = true
            }else{
              if(SchiffAuswahl.u2==false){
                SchiffAuswahl.u2=true
              }else{
                SchiffAuswahl.u3=true                
              }
            }
          }
        }
          laenge = 3
        }else{
          if(schiff=="Kreuzer"){
            Schiffe.controller.getSize match{
            case 5 => SchiffAuswahl.k_mittel = true
            case 10 => {
            if(SchiffAuswahl.k1==false){
              SchiffAuswahl.k1 = true
            }else{              
                SchiffAuswahl.k2=true              
            }
          }
        }
            laenge=4
          }else{
            if(schiff=="Schlachtschiff"){
              SchiffAuswahl.s = true
              laenge=5
            }else{
              S.error("FALSCHES SCHIFF EINGEGEBEN")
            }
          }
        }
      }
      
      if(richt=="oben"){
        richtung=0
      }else{
        if(richt=="unten"){
          richtung=1
        }else{
          if(richt=="rechts"){
            richtung=2
          }else{
            if(richt=="links"){
              richtung=3
            }else{
              S.error("FALSCHE RICHTUNG!")
            }
          }
        }
      }
                                     
                                              
//       ChatIn.setSchiffe(laenge, (reihe.toInt-1), (spalte.toInt-1), richtung, (Schiffe.controller.getSize - 1))
//       ChatIn.setSchiffen()
       SchiffeServer.setSchiff(laenge, (reihe.toInt), (spalte.toInt), richtung, (Schiffe.controller.getSize - 1))
//      SchiffeServer.setSchiff(3, 1, 1, 0, 4)
    }else{
      JOptionPane.showMessageDialog(null,
                                              "FALSCH - Hit wurde eingegeben",
                                              "Eine Nachricht",                                       
                                              JOptionPane.WARNING_MESSAGE);
      //HIT
    }
//      typ match{
//        case "set" => {
//          schiff match{
//            case "Zerstörer" =>
//              laenge = 2
//            case "U-Boot" =>
//              laenge = 3
//            case "Kreuzer" =>
//              laenge = 4
//            case "Schlachtschiff" =>
//              laenge = 5
//          }
//          richt match{
//          case "oben" =>
//            richtung = 2
//          case "unten" =>
//            richtung = 1
//          case "rechts" =>
//            richtung = 2
//          case "links" =>
//            richtung = 3
//        }
         
//         SchiffeServer.setSchiff(laenge, (reihe.toInt-1), (spalte.toInt-1), richtung, (Schiffe.controller.getSize - 1))
//        }
//        case "hit" => 
    
//      S.notice("Länge: "+ laenge)
//      S.notice("Reihe: "+ reihe)
//      S.redirectTo("/")
  
}
  
   "name=typ" #> SHtml.onSubmit(typ = _) &
   "name=schiff" #> SHtml.onSubmit(schiff = _) &
   "name=reihe" #> SHtml.onSubmit(s => asInt(s).foreach(reihe = _)) &
   "name=spalte" #> SHtml.onSubmit(s => asInt(s).foreach(spalte = _)) &
   "name=richtung" #> SHtml.onSubmit(richt = _)&   
   "type=submit" #> SHtml.onSubmitUnit(process)
   
    
}
}   
 

//    for {
//      r <- S.request if r.post_? 
//      typ <- S.param("type") 
//      schiff <- S.param("schiff") 
//      reihe <- S.param("reihe")
//      spalte <- S.param("spalte")
//      richtung <- S.param("richtung")
//    } 
//      typ match{
//        case "set" => 
//          schiff match{
//            case "Zerstörer" =>
//              var laenge = 2
//            case "U-Boot" =>
//              var laenge = 3
//            case "Kreuzer" =>
//              var laenge = 4
//            case "Schlachtschiff" =>
//              var laenge = 5
//          }
//        richtung match{
//          case "oben" =>
//            var richtungSchiff = 2
//          case "unten" =>
//            var richtungSchiff = 1
//          case "rechts" =>
//            var richtungSchiff = 2
//          case "links" =>
//            var richtungSchiff = 3
//        }

//          
//        case "hit" =>
//      }
//      
//   
//
//    in
//  
//}
