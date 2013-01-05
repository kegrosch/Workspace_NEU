package code
package comet

import net.liftweb._
import http._
import util._
import Helpers._
import scala.swing.Reactor
import schiffe._
import schiffe.Controller._
import schiffe.Controller.CellChanged
import Schiffe.controller._
import schiffe.Controller.CellChanged
import schiffe.Controller.CellChanged




/**
 * The screen real estate on the browser will be represented
 * by this component.  When the component changes on the server
 * the changes are automatically reflected in the browser.
 */
class FeldRenderer extends CometActor with CometListener with Reactor{

  listenTo(Schiffe.controller)
import schiffe.Controller._
  reactions += {
    //case e: GridSizeChanged => resize(e.newSize)
    
  case CellChanged => reRender()
  
  }
  private var status: String = "" // private state

  /**
   * When the component is instantiated, register as
   * a listener with the ChatServer
   */
  def registerWith = SchiffeServer

  
  /**
   * The CometActor is an Actor, so it processes messages.
   * In this case, we're listening for Vector[String],
   * and when we get one, update our private state
   * and reRender() the component.  reRender() will
   * cause changes to be sent to the browser.
   */
  override def lowPriority = {
    case command: String => reRender()
  }

  /**
   * Put the messages in the li elements and clear
   * any elements that have the clearable class.
   */
  def render = {
    "#status *" #> status
  }
}
