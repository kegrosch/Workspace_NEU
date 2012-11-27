package schiffe.Model
import org.specs2.mutable._
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner


@RunWith(classOf[JUnitRunner])
class SchiffSpec extends SpecificationWithJUnit{
  "A new Feld" should{
    val feld = new Feld(2)
    
    "Have 2 cells" in{
      var anzahl = feld.zellen.length
      anzahl must be_==(2)
    }
}
}