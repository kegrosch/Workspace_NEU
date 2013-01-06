package code
package snippet

import net.liftweb._
import http._
import js._
import JsCmds._
import JE._
import code.comet.SchiffeServer
object ChatIn {

  /**
   * The render method in this case returns a function
   * that transforms NodeSeq => NodeSeq.  In this case,
   * the function transforms a form input element by attaching
   * behavior to the input.  The behavior is to send a message
   * to the ChatServer and then returns JavaScript which
   * clears the input.
   */
  def render = SHtml.onSubmit(s => {
    SchiffeServer ! s
//    SetValById("chat_in", "")
  })
  def neuStarten = SHtml.onSubmit(s =>{
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
}