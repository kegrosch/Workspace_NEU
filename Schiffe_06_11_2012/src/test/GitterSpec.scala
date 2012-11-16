package test

import org.specs2.mutable._
import schiffe.Gitter
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class GitterSpec extends SpecificationWithJUnit {

  "A new Ausgabe" should {
    val TestGitter = new Gitter(5)

    "have 5 colums" in {
      var size = TestGitter.columns.length
      size must be_==(5)

    }

    "have 5 rows" in {
      var size = TestGitter.rows.length
      size must be_==(5)

    }
    "have 5 time S when a ship is set" in {

      TestGitter.setSchiff(5)
      TestGitter.setSchiff(4)
      TestGitter.setSchiff(3)
      
     

      TestGitter.solve
      println(TestGitter.toString())
      var zaehler = 0

      for (row <- 0 until 5) {
        for (column <- 0 until 5) {
          val value = TestGitter.cell(row, column).value.toString()

          if (value != "S") {} else zaehler = zaehler + 1

        }
      }

      zaehler must be_==(12)

    }

    "have all cell be set when solved" in {
      TestGitter.reset
      TestGitter.solve
      for (row <- 0 until 5; column <- 0 until 5) {
        val value = TestGitter.cell(row, column).value
        value must be_!=("X")
      }
    }

  }

}