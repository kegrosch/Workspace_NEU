package code
package comet

import net.liftweb._
import http._
import actor._
import schiffe._

/**
 * A singleton that provides chat features to all clients.
 * It's an Actor so it's thread-safe because only one
 * message will be processed at once.
 */
object SchiffeServer extends LiftActor with ListenerManager {
//  private var status = "Welcome to Sudoku" // private state
//
//  /**
//   * When we update the listeners, what message do we send?
//   * We send the msgs, which is an immutable data structure,
//   * so it can be shared with lots of threads without any
//   * danger or locking.
//   */
//  def createUpdate = status
//
//  /**
//   * process messages that are sent to the Actor.  In
//   * this case, we're looking for Strings that are sent
//   * to the ChatServer.  We append them to our Vector of
//   * messages, and then update all the listeners.
//   */
//  override def lowPriority = {
//    case s: String =>  {
//      Schiffe.userTui.readInput(s)
//      status = Schiffe.controller.statusText
//      updateListeners()
//    }
//  }
  private var msgs = Vector("Welcome") // private state

  /**
   * When we update the listeners, what message do we send?
   * We send the msgs, which is an immutable data structure,
   * so it can be shared with lots of threads without any
   * danger or locking.
   */
  def createUpdate = msgs
def setSize(groesse: Int){
    Schiffe.controller.setSize(groesse); Schiffe.pccontroller.setSize(groesse)
  }
  def neuStarten{
    Schiffe.controller.reset
    Schiffe.pccontroller.reset
  }
  def loesen{
    Schiffe.controller.solve
    Schiffe.pccontroller.solve
  }
  /**
   * process messages that are sent to the Actor.  In
   * this case, we're looking for Strings that are sent
   * to the ChatServer.  We append them to our Vector of
   * messages, and then update all the listeners.
   */
  override def lowPriority = {
//    case s: String => msgs :+= s; updateListeners()
    case s: String => Schiffe.userTui.readInput(s); msgs :+= s;updateListeners(); 
  }
}
