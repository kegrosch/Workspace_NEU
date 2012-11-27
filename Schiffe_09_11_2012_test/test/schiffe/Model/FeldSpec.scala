package schiffe.Model
import org.specs2.mutable._
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class FeldSpec extends SpecificationWithJUnit{
  "A new Feld" should{
    val feld = new Feld(2)
    
    "Have 2 cells" in{
      var anzahl = feld.zellen.length
      anzahl must be_==(2)
    }
    "return a new Feld with 2 Cells when reset" in{
      var feldNeu = feld.reset
//      var anzahlNeu = feldNeu.zellen.length+1
      feldNeu must beEqualTo(feld)
    }
   }

}




//  "A new Ausgabe" should {
//    val ausgabe = new Ausgabe(2)
//
//    "Have value 2" in {
//      var result = ausgabe.cells.length
//      result must be_==(2)
//
//    }
//
//    "give the rigth string" in {
//      var erg = ausgabe.toString().length();
//      erg must be_==(9)
//    }
//    "the value of the cell shou be setable" in {
//      for (index <- 0 until 2) {
//        var cell = ausgabe.cells(index)
//        cell.assign("S")
//        var erg3 = cell.value
//        erg3 must be_==("S")
//
//      }
//    }
//    "the cell should make the correct string" in {
//      for (index <- 0 until 2) {
//        var cell = ausgabe.cells(index)
//        var erg2 = cell.mkString
//        var value = cell.value
//        erg2 must be_==("(" + index + ", 0) = " + value)
//
//      }
//    }
//    "the cell should be open" in {
//      for (index <- 0 until 2) {
//        var cell = ausgabe.cells(index)
//        cell.assign(" ")
//        var open = cell.isOpen
//        open must be_==(false)
//
//      }
//    }
//
//    "the cell should be closed" in {
//      for (index <- 0 until 2) {
//        var cell = ausgabe.cells(index)
//        cell.assign("S")
//        var erg3 = cell.isOpen
//        erg3 must be_==(true)
//
//      }
//    }
//    "the cell colum should be as the set column" in {
//      val cell2 = new schiffe.Cell(3, 5)
//
//      var cellY = cell2.y
//
//      cellY must be_==(5)
//
//    }
//    "the cell row should be as the set row" in {
//      val cell2 = new schiffe.Cell(3, 5)
//
//      var cellY = cell2.x
//
//      cellY must be_==(3)
//
//    }
//
//  }
//
//}