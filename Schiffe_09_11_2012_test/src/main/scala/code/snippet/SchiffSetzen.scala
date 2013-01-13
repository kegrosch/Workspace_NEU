package code.snippet
import net.liftweb._
import http._
import util.Helpers._
import scala.xml.NodeSeq
import schiffe.Schiffe
import code.comet.SchiffeServer

object SchiffSetzen {
 
  
  def render = {
  var laenge = 0  
  var reihe = 0
  var spalte = 0
  var richtung = 0
  var schiff =""
    var typ =""
      var richt =""
  
  def process(){
    
    if(typ=="set"){
      if(schiff=="Zerstörer"){
        laenge=2
      }else{
        if(schiff=="U-Boot"){
          laenge = 3
        }else{
          if(schiff=="Kreuzer"){
            laenge=4
          }else{
            if(schiff=="Schlachtschiff"){
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
       ChatIn.setSchiffe(laenge, (reihe.toInt-1), (spalte.toInt-1), richtung, (Schiffe.controller.getSize - 1))
    }else{
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
    }
      S.notice("Länge: "+ laenge)
      S.notice("Reihe: "+ reihe)
      
  
   "name=type" #> SHtml.onSubmit(typ = _) &
   "name=schiff" #> SHtml.onSubmit(schiff = _) &
   "name=reihe" #> SHtml.onSubmit(s => asInt(s).foreach(reihe = _)) &
   "name=spalte" #> SHtml.onSubmit(s => asInt(s).foreach(spalte = _)) &
   "name=richtung" #> SHtml.onSubmit(richt = _)
   
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
