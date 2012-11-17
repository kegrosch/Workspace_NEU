package schiffe.Model

import scala.math.sqrt
import scala.util.Random

class Feld(anzahl: Int) {
  
  var zellen = new Array[Zelle](anzahl*anzahl)
  var anzahlZellen = anzahl*anzahl-1
  var zaehler = 0
 //Zellen generieren
  while(zaehler < anzahlZellen){
  for(i <- 0 until anzahl){
    for(j <- 0 until anzahl){
      zellen(zaehler) = new Zelle(i,j)
      zaehler= zaehler+1
    }
  }
  }

  
      val size = sqrt(zellen.size).toInt
//  val blocknum = sqrt(size).toInt
//  def blockAt(row: Int, col: Int) = (col / blocknum) + (row / blocknum) * blocknum
//  def indexToRowCol(index: Int) = { val r = index / size; val c = index % size; (r, c) }
  def zelle(row: Int, col: Int) = (row, col)
//  def rows(row: Int) = new Schiff(zellen.slice(size * row, size * (row + 1)))
//  def allrows = (0 until size).map(i => rows(i))
//  def cols(col: Int) = new Schiff((for (row <- 0 until size) yield zelle(row, col)).asInstanceOf[Vector[Zelle]])
//  def allcols = (0 until size).map(i => cols(i))
//  def blocks(block: Int) = new Schiff((for (row <- 0 until (size); col <- 0 until size; if blockAt(row, col) == block) yield zelle(row, col)).asInstanceOf[Vector[Zelle]])
//  def allblocks = (0 until size).map(i => blocks(i))
  def set(row: Int, col: Int) = {
   var feld = new Feld(anzahl)
    for(i <- 0 until anzahlZellen){
      if(zellen(i).getReihe == row){
//        println("REIHEEEEEEEEEEEEEEEEEE")
        if(zellen(i).getSpalte==col){
      
        var zell = zellen(i)
        var schiff = new Schiff(2, zell, zellen) 
        schiff.setzen
//        println("NNNNNNNNNNNN")
        
//        var feld = (zellen.updated(i, zell.gesetzt=true))
//        
//        return feld
        }
      }else{
//        feld
//        println("OOOOOOOOOOOOO")
      }
      
    }
//   println("PPPPPPPPPP")
//    feld
    
     
//    schiff.setzen
    
  
  
  
  
   
   
 
  }
//  def unset(row: Int, col: Int): Feld = set(row, col)
//  def available(row: Int, col: Int): Set[Int] = if (zelle(row, col).isSet) Set.empty else (1 to size).toSet -- rows(row).toIntSet -- cols(col).toIntSet -- blocks(blockAt(row, col)).toIntSet
//  def options = for (row <- 0 until size; col <- 0 until size) yield available(row, col)
//  def valid = allrows.forall(house => house.valid) && allcols.forall(house => house.valid) && allblocks.forall(house => house.valid)

  override def toString = {
    val lineseparator = ("+-" + ("-" * (size/2))) *size + "+\n"
    val line = ("| " + "x") * size + "|\n"
    var box = "\n" + (lineseparator + (line)) * size + lineseparator
    for (row <- 0 until size; col <- 0 until size) {
      (box = box.replaceFirst("x", zellen(row).gesetzt.toString()))
      (box = box.replaceAll("x", zellen(row).gesetzt.toString))
      (box = box.replaceFirst("false", "  "))
      (box = box.replaceAll("false", "  "))
      (box = box.replaceFirst("true", "X "))
      (box = box.replaceAll("true", "X "))
    }
    box
  }
}