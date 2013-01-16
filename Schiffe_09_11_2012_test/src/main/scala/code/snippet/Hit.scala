package code.snippet
import net.liftweb._
import util._
import Helpers._
import http._
import js.JsCmds._
import javax.swing.JOptionPane
import code.comet.SchiffeServer

object Hit {
  
def render = {
    // define some variables to put our values into
    var reihe = 0
    var spalte = 0
    // process the form
    def process() {
      // if the age is < 13, display an error
    	
        // otherwise give the user feedback and
        // redirect to the home page
//       var reihe = S.param("reihe") openOr("KEINE REIHE")
//        var spalte = S.param("spalte") openOr ("KEINE SPALTE")
        
     SchiffeServer.hit(reihe+1, spalte+1)
    }
  // associate each of the form elements
    // with a function... behavior to perform when the
    // for element is submitted
    "name=reihe" #> SHtml.onSubmit(s => asInt(s).foreach(reihe = _)) & // set the name
//    // set the age variable if we can convert to an Int
    "name=spalte" #> SHtml.onSubmit(s => asInt(s).foreach(spalte = _)) &
    // when the form is submitted, process the variable
    "type=submit" #> SHtml.onSubmitUnit(process)
  }
}