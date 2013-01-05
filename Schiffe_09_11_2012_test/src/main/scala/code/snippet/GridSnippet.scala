package code.snippet

import net.liftweb._
import util._
import Helpers._
import http._
import js.JsCmds._

import schiffe._

class GridSnippet {
   def render = {
      <table class="grid">{
         for (row <- 0 until Sudoku.controller.gridSize) yield {
             <tr>
                  { for (column <- 0 until Sudoku.controller.gridSize) yield {
                     <td class={"lift:CellSnippet?row="+row+"&column="+column}></td>
                     }
                  
                  }
             </tr>
         }
     }
     </table>
   }           
}