package code 
package snippet 

import net.liftweb._
import util._
import Helpers._
import http._
import js.JsCmds._
import schiffe.Controller.Controller
import schiffe.View.Tui
import schiffe.View.GUI
import schiffe.Schiffe


object Feldunktionsleiste {
private object pos extends RequestVar(0)
  private object cnt extends RequestVar(0)

def render = {
  Schiffe.controller.setSize(10)
  }
}