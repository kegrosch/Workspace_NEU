/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 30.10.12
 * Time: 14:25
 * To change this template use File | Settings | File Templates.
 */

package schiffe


object Schiffe {
  def main(args: Array[String]) {
    var ablauf = true
    var input = ""
    var groesse = ""
    var grid = new Gitter(0)
    while(ablauf == true) {
      println("bitte Anzahl der Zellen angeben")
      groesse = readLine()
      grid = new Gitter(groesse.toInt)
      groesse match {

        case "10" =>  {
          grid.setSchiff(5)
          var j = 4
          for (i <- 2 until 5) {
            for (index <- 0 until i) {
              grid.setSchiff(j)
            }
            j = j - 1
          }
          ablauf = false

        }

        case "5" =>    {
          grid.setSchiff(4)
          grid.setSchiff(3)
          grid.setSchiff(2)
          ablauf = false
        }
        case "2" => {
          grid.setSchiff(2)
          ablauf = false

        }
        case _ => {
          println("Sie haben eine Falsche Größe eingegeben (2, 5, oder 10)")
          ablauf = true
        }
      }
    }
    def spielfertig: Boolean = {
      if (groesse.toInt==10 && grid.zaehler==30)
        true
      else { if (groesse.toInt==5 && grid.zaehler==9)
        true

      else { if (groesse.toInt==2 && grid.zaehler==2) {
        true
      }
      else{
        false
      }
      }
      }
    }


    while (true) {

      println(grid.toString)
      if (spielfertig==true){
        println("Spiel ist fertig")
      }
      println("Enter command: q-Quit; s-Solve; r-reset; set -Zelle Ã¶ffnen ")
      input = readLine()
      input match {

        case "q" => return
        case "s" => grid.solve
        case "r" => grid.reset
        case "set" => {

          var korrekteEingabe = false
          var reihe = ""
          while (korrekteEingabe == false) {
            println("Bitte Reihe von 1 bis Feldgroesse angeben ")
            reihe = readLine();
            if (reihe.toInt >= 1 && reihe.toInt <= groesse.toInt) {
              korrekteEingabe = true

            } else {
              korrekteEingabe = false
              println("Falsche Eingabe! Es wurder keine gültige Reihe eingegeben (zwischen 1 und Feldgroesse)!")
            }
          }
          korrekteEingabe = false
          while (korrekteEingabe == false) {
            println("Bitte Spalte von 1 bis Feldgroesse angeben ")
            var spalte = readLine();
            if (spalte.toInt >= 1 && spalte.toInt <= groesse.toInt) {
              korrekteEingabe = true
              grid.set(reihe.toInt - 1, spalte.toInt - 1)

            } else {
              korrekteEingabe = false
              println("Falsche Eingabe! Es wurder keine gültige Spalte eingegeben (zwischen 1 und Feldgroesse)!")
            }
          }

        }

        case _ => println("Falsches Input!!!")
      }

    }
  }

}

