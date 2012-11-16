/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 30.10.12
 * Time: 14:23
 * To change this template use File | Settings | File Templates.
 */
package schiffe

class Ausgabe(size: Int) {
  val block = 1
  val cells = new Array[Cell](size)

  for (index <- 0 until size) {
    cells(index) = new Cell(index, 0)
  }

  override def toString = {
    var result = ""
    cells.foreach(cell => result += (if (cell.x % block == 0) "| " else "") + cell.toString + " ")
    result + "|"
  }
}
