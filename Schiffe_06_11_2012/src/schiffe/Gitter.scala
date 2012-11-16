/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 30.10.12
 * Time: 14:18
 * To change this template use File | Settings | File Templates.
 */
package schiffe
import scala.math.sqrt
class Gitter (size: Int) {
  val block = 1
  val sr = sqrt(size).toInt
  var cells = Array.ofDim[Cell](size, size)
  var rows = new Array[Ausgabe](size)
  var columns = new Array[Ausgabe](size)
  var zaehler = 0

  for (index <- 0 until size) {
    rows(index) = new Ausgabe(size)
    columns(index) = new Ausgabe(size)

  }

  for (row <- 0 until size; column <- 0 until size) {
    cells(row)(column) = new Cell(row, column)
    rows(row).cells(column) = cell(row, column)
    columns(column).cells(row) = cell(row, column)

  }
  def reset = {
    for (row <- 0 until size; column <- 0 until size) {
      cell(row, column).assign(" ")
      cell(row,column).besetzt=false
      cell(row,column).offen=false
    }
  }

  def solve = {
    for (row <- 0 until size; column <- 0 until size) {
      if(cell(row,column).offen==false ){
        cell(row,column).offen=true
        if (cell(row, column).besetzt == true){
          cell(row, column).assign("S")
        }
        else
          cell(row, column).assign("O")
      }

    }
  }

  def cell(r: Int, c: Int) = cells(r)(c)
  def lineseparator = ("+-" + "--")*size  + "+\n"

  def set(row: Int, column: Int) = {
    if (!cell(row,column).besetzt) {
      cell(row, column).assign("O")
      cell(row,column).offen= true
    }
    else {
      cell(row, column).assign("X")
      cell(row,column).offen= true
      zaehler = zaehler +1
    }
  }

  def setSchiff (schiffsgroesse: Int)= {
    var besetzt =false
    do {
      var direction =scala.util.Random.nextInt(4)
      direction match{
        case 0 =>
          
          var randomRow = scala.util.Random.nextInt(size)
          var randomColumn = scala.util.Random.nextInt(size)
        if (randomRow -schiffsgroesse-1 <0) {
            besetzt= false
          }
        else {
          var stopit = false
            for (index <- 0 until schiffsgroesse) {
              if (cell(randomRow- index,randomColumn).besetzt==true)
                stopit = true
          }
          if (stopit == true)
               besetzt= false

          else{
            for (index <- 0 until schiffsgroesse) {
              cell(randomRow- index,randomColumn).besetzt= true
              besetzt =true
            }
          }

        }
          

        case 1 =>
          var randomRow = scala.util.Random.nextInt(size)
          var randomColumn = scala.util.Random.nextInt(size)
          if (randomRow +schiffsgroesse-1 >size-1) {
            besetzt= false
          }
          else {

            var stopit = false
             for (index <- 0 until schiffsgroesse) {
              if (cell(randomRow +index,randomColumn).besetzt== true)
              stopit= true
             }
              if (stopit == true)
               besetzt =false

              else{
                for (index <- 0 until schiffsgroesse) {
                cell(randomRow +index,randomColumn).besetzt= true
                besetzt =true
              }
              }

            }

        case 2 =>
          var randomRow = scala.util.Random.nextInt(size)
          var randomColumn = scala.util.Random.nextInt(size)
          if (randomColumn +schiffsgroesse-1 >size-1) {
            besetzt= false
          }
          else {
            var stopit = false
             for (index <- 0 until schiffsgroesse) {
              if  (cell(randomRow ,randomColumn + index).besetzt== true)
                stopit = true
             }

            if (stopit ==true)
            besetzt = false

              else {
                for (index <- 0 until schiffsgroesse) {
                cell(randomRow ,randomColumn + index).besetzt= true
                besetzt =true
              }
              }
            }



        case 3 =>
          var randomRow = scala.util.Random.nextInt(size)
          var randomColumn = scala.util.Random.nextInt(size)
          if (randomColumn -schiffsgroesse-1 <0) {
           besetzt= false
          }
          else {
            var stopit =false
               for (index <- 0 until schiffsgroesse){
               if (cell(randomRow ,randomColumn - index).besetzt== true)
               stopit =true
             }
            if (stopit==true )
               besetzt = false
              else{
                for (index <- 0 until schiffsgroesse) {

                cell(randomRow ,randomColumn - index).besetzt= true
                besetzt =true
              }
              }
            }

            }



    }   while (!besetzt)



  }



  override def toString = {
    var result =""
    columns.foreach(house => result+= (if (house.cells(0).y % block == 0) lineseparator else "" ) + house.toString() + "\n")
    result + lineseparator
  }


}
