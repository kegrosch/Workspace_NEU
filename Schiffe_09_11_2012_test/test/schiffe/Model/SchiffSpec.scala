package schiffe.Model
import org.specs2.mutable._
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner


@RunWith(classOf[JUnitRunner])
class SchiffSpec extends SpecificationWithJUnit{
  "A new Schiff" should{
    val feld = new Feld(5)
    val zellen = feld.zellen
    val startZelle = zellen(0)(0)
    val schiff = new Schiff(2, startZelle, zellen)
    
    "Cell Should be set when set (Richtung: oben)" in{
      schiff.setzen(0,4)
      var isSet = zellen(0)(0).getGesetzt
      isSet must be_==(true)
      
      
    }
    
    "Cell should be unset after reset" in{
      feld.reset
      
      var isUnset = feld.zellen(0)(0).getGesetzt
      isUnset must be_==(false)
    }
    "Cell should be set when set (Richtung: unten)" in{
      schiff.setzen(1,4)
      var isSet = zellen(0)(0).getGesetzt
      isSet must be_==(true)
    }
    "Cell should be set when set (Richtung: rechts)" in{
      feld.reset
      schiff.setzen(2,4)
      var isSet = zellen(0)(0).getGesetzt
      isSet must be_==(true)
    }
    "Cell should be set when set (Richtung: links)" in{
      feld.reset
      schiff.setzen(3,4)
      var isSet = zellen(0)(0).getGesetzt 
      isSet must be_==(true)
    }
}
}