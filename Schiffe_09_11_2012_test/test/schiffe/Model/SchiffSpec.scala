package schiffe.Model
import org.specs2.mutable._
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner


@RunWith(classOf[JUnitRunner])
class SchiffSpec extends SpecificationWithJUnit{
  "A new Schiff" should{
    val feld = new Feld(2)
    val zellen = feld.zellen
    val startZelle = new Zelle(0,0)
    val schiff = new Schiff(2, startZelle, zellen)
    
    "Have 2 cells" in{
      var anzahl = feld.zellen.length
      anzahl must be_==(2)
    }
}
}