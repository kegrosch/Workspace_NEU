package code.snippet
import net.liftweb._
import util._
import Helpers._
import http._
import js.JsCmds._
import javax.swing.JOptionPane

object Hit {
  
  var reihe=0
  var spalte=0
  
  def render = {
    // capture our position on the page
//    val posOnPage = pos.set(pos.is + 1)
"button [onclick]" #> 
    SHtml.ajaxInvoke(() => {
        JOptionPane.showMessageDialog(null,
                                              "SET:  Schiff:",
                                              "Eine Nachricht",                                       
                                              JOptionPane.WARNING_MESSAGE);
    })
  }
//  
//  def render = {
//        "button [onClick]" #>
//        SHtml.onEvent()
//        studentName & // Replace the HTML tag with id="name" to studentName 
//        ".surname" #> surName & // Replace the HTML tag with class=surname to surName 
//        ".clickable [onClick]" #> SHtml.onEvent(onClickCallback) // Append onClick attribute to HTML tag that has "clickable" class, and it will calle onClickCallable in your snippet.
//    }
//
}