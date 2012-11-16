package schiffe.Model
import scala.math.sqrt
import scala.util.Random

class Feld(zellen: Vector[Zelle]) {
  def this(zeilenlaenge: Int) = this(Vector.fill(zeilenlaenge * zeilenlaenge)(new Zelle(0)))

  val size = sqrt(zellen.size).toInt
//  val blocknum = sqrt(size).toInt
//  def blockAt(row: Int, col: Int) = (col / blocknum) + (row / blocknum) * blocknum
  def indexToRowCol(index: Int) = { val r = index / size; val c = index % size; (r, c) }
  def zelle(row: Int, col: Int) = rows(row).zelle(col)
  def rows(row: Int) = new Schiff(zellen.slice(size * row, size * (row + 1)))
  def allrows = (0 until size).map(i => rows(i))
  def cols(col: Int) = new Schiff((for (row <- 0 until size) yield zelle(row, col)).asInstanceOf[Vector[Zelle]])
  def allcols = (0 until size).map(i => cols(i))
//  def blocks(block: Int) = new Schiff((for (row <- 0 until (size); col <- 0 until size; if blockAt(row, col) == block) yield zelle(row, col)).asInstanceOf[Vector[Zelle]])
//  def allblocks = (0 until size).map(i => blocks(i))
  def set(row: Int, col: Int, value: Int): Feld = new Feld(zellen.updated(size * row + col, new Zelle(value)))
  def unset(row: Int, col: Int): Feld = set(row, col, 0)
//  def available(row: Int, col: Int): Set[Int] = if (zelle(row, col).isSet) Set.empty else (1 to size).toSet -- rows(row).toIntSet -- cols(col).toIntSet -- blocks(blockAt(row, col)).toIntSet
//  def options = for (row <- 0 until size; col <- 0 until size) yield available(row, col)
//  def valid = allrows.forall(house => house.valid) && allcols.forall(house => house.valid) && allblocks.forall(house => house.valid)

  override def toString = {
    val lineseparator = ("+-" + ("-" * size)) *size + "+\n"
    val line = ("| " + ("x" * size)) * size + "|\n"
    var box = "\n" + (lineseparator + (line * (size/2))) * size + lineseparator
    for (row <- 0 until size; col <- 0 until size) {
//      (box = box.replaceFirst("x", zelle(row, col).toString))
      (box = box.replaceAll("x", zelle(row, col).toString))
    }
    box
  }
}