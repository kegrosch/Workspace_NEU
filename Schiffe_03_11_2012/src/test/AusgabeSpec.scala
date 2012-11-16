package test
import org.specs2.mutable._

import schiffe.Ausgabe


class AusgabeSpec extends SpecificationWithJUnit{
  
  "A new Ausgabe" should{
    val ausgabe = new Ausgabe(1)
    
    "Have value 1" in {
      var result = ausgabe.cells.length 
      result must be_==(1)
      
    }
  }

}