package test3
import org.specs2.mutable._
import schiffe._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner


@RunWith(classOf[JUnitRunner])
class AusgabeSpec extends SpecificationWithJUnit {
  

"A new schiffe.Ausgabe" should {
    val ausgabe = new schiffe.Ausgabe(1)
       
    "have value 1" in {
      var result = ausgabe.cells.length 
      result must be_==(2)
      
    }
}
}