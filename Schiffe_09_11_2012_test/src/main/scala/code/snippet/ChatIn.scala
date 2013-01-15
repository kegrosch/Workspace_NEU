package code
package snippet

import net.liftweb._
import http._
import js._
import JsCmds._
import JE._
import code.comet.SchiffeServer
import javax.swing.JOptionPane
object ChatIn {

  /**
   * The render method in this case returns a function
   * that transforms NodeSeq => NodeSeq.  In this case,
   * the function transforms a form input element by attaching
   * behavior to the input.  The behavior is to send a message
   * to the ChatServer and then returns JavaScript which
   * clears the input.
   */
  
  def hit = SHtml.onSubmit(s => {
    JOptionPane.showMessageDialog(null,
                                              "SET:  Schiff:",
                                              "Eine Nachricht",                                       
                                              JOptionPane.WARNING_MESSAGE);
    var reihe = S.attr("reihe") openOr "myparam: Y U NO DEFINED!?"
    var spalte = S.attr("spalte") openOr "myparam: Y U NO DEFINED!?"
    SchiffeServer.hit(reihe.toInt, spalte.toInt)
    
  })
    
  
  def render = SHtml.onSubmit(s => {
    SchiffeServer ! s
//    SetValById("chat_in", "")
  })
  def neuStarten = SHtml.onSubmit(s =>{
    SchiffAuswahl.z_klein = false
  SchiffAuswahl.z_mittel = false
  SchiffAuswahl.u_mittel = false
  SchiffAuswahl.k_mittel = false
  SchiffAuswahl.z1 = false
  SchiffAuswahl.z2 = false
  SchiffAuswahl.z3 = false
  SchiffAuswahl.z4 = false
  SchiffAuswahl.u1 = false
  SchiffAuswahl.u2 = false
  SchiffAuswahl.u3 = false
  SchiffAuswahl.k1 = false
  SchiffAuswahl.k2 = false
  SchiffAuswahl.s = false
    SchiffeServer.neuStarten
  })
  def loesen = SHtml.onSubmit(s =>{
    SchiffeServer.loesen
  })
  def groesse2 = SHtml.onSubmit(s =>{
    SchiffeServer.setSize(2)
    
  })
  def groesse5 = SHtml.onSubmit(s =>{
    SchiffeServer.setSize(5)
  })
  def groesse10 = SHtml.onSubmit(s =>{
    SchiffeServer.setSize(10)
  })
  def buttonClicked = SHtml.onSubmit(s =>{
    SchiffeServer.setSize(2)
  })
  def setSchiffe(laenge: Int, reihe:Int, spalte:Int, richtung:Int, groesse:Int) = SHtml.onSubmit(s =>{
    SchiffeServer.setSchiff(2, 1, 1, 0, 4)
    Alert("JJKJKJKJKJ")
  })
def setSchiffen() = SHtml.onSubmit(s =>{
    SchiffeServer.setSchiff(2, 1, 1, 0, 4)
    Alert("JJKJKJKJKJ")
  })
}
