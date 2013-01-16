package code
package comet

import net.liftweb._
import http._
import actor._
import schiffe._
import javax.swing.JOptionPane

/**
 * A singleton that provides chat features to all clients.
 * It's an Actor so it's thread-safe because only one
 * message will be processed at once.
 */
object SchiffeServer extends LiftActor with ListenerManager {
  var anzahlGesetzt = 0
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
def hit(reihe: Int, spalte:Int){

    Schiffe.pccontroller.hit(reihe, spalte)
  }
def setSize(groesse: Int){
    Schiffe.controller.setSize(groesse); Schiffe.pccontroller.setSize(groesse)
  }
  def neuStarten{
    Schiffe.controller.reset
    Schiffe.pccontroller.reset
    anzahlGesetzt=0
  }
  def loesen{
    Schiffe.controller.solve
    Schiffe.pccontroller.solve
  }
  def setSchiff(laenge: Int, reihe:Int, spalte:Int, richtung:Int, groesse:Int){
    Schiffe.controller.set(laenge, reihe, spalte, richtung, groesse)
    anzahlGesetzt = anzahlGesetzt+1
    
    Schiffe.controller.getSize match{
      case 2 => Schiffe.pccontroller.setcomputerschiff2
      case 5 => if(anzahlGesetzt==3) Schiffe.pccontroller.setcomputerschiff5 else{}
      case 10 => if(anzahlGesetzt==10) Schiffe.pccontroller.setcomputerschiff10 else {}
    }
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
