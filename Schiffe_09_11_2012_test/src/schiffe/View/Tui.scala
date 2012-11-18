package schiffe.View
import schiffe.Controller._
import schiffe.Model.Feld
import schiffe.util._
import schiffe.Model.Schiff

class Tui(var controller: Controller) extends Observer {
  controller.add(this)
  printTui
  def update = printTui
  def printTui = {
    println(controller.feld.toString())

  }
  def readInput(eingabe: String) = {
    var continue = true
    eingabe match {
      case "q" => continue = false
      case "s" => //Controller.solve
      case "r" => // Controller.reset
      case "set" =>
        var size = controller.feld.zellen.length
        size match {
          case 2 =>
            println("Geben Sie die Position Ihres Zerstörers ein")
            var pos = readLine()
            //Schiff mit Länge 2 und Position pos erstellen
            println("Zerstörer wurde bei " + pos + " gesetzt")

          case 5 =>
            println("Geben Sie die das 1.te Feld Ihres 1.ten Zerstörers und deren Richtung ein (Reihe/Spalte/Richtung(z.B. 131))")
            println("Richtungen: 0-Oben; 1-Unten; 2-Rechts; 3-Links")
            var pos = readLine()
            
            pos.toList.filter(c => c != ' ').map(c => c.toString.toInt) match {
              case row :: column :: richtung ::Nil => {
                
                    
                   
                    controller.set(2, row, column, richtung)
                    println("1.ter Zerstörer wurde bei " + row + " / " + column + " gesetzt")



              }

              case _ => println("Falsche Eingabe - Geben Sie ZeileSpalte (bsp. 55r) ein")
            }

            //           Schiff mit Länge 2 und Position pos erstellen
            
            println("Geben Sie die das 1.te Feld Ihres 2.ten Zerstörers und deren Richtung ein (Reihe/Spalte/Richtung(z.B. 131))")
            println("Richtungen: 0-Oben; 1-Unten; 2-Rechts; 3-Links")
            pos = readLine()
            pos.toList.filter(c => c != ' ').map(c => c.toString.toInt) match {
              case row :: column :: richtung :: Nil => {
                

                controller.set(2, row, column, richtung)
                println("2.ter Zerstörer wurde bei " + row + " / " + column + " gesetzt")

              }

              case _ => println("Falsche Eingabe - Geben Sie ZeileSpalte (bsp. 55) ein")
            }
            
            //           println("Geben Sie die Position Ihres 3.ten Zerstörers ein")
            //           pos = readLine()
            //           //Schiff mit Länge 2 und Position pos erstellen
            //           println("3.ter Zerstörer wurde bei "+ pos + " gesetzt")
            //           println("Geben Sie die Position Ihres 1.ten UBoots ein")
            //           pos = readLine()
            //           //Schiff mit Länge 3 und Position pos erstellen
            //           println("1.tes UBoot wurde bei "+ pos + " gesetzt")
            //           println("Geben Sie die Position Ihres 2.ten UBoots ein")
            //           pos = readLine()
            //           //Schiff mit Länge 3 und Position pos erstellen
            //           println("2.tes UBoot wurde bei "+ pos + " gesetzt")
            //           println("Geben Sie die Position Ihres Kreuzers ein")
            //           pos = readLine()
            //           //Schiff mit Länge 4 und Position pos erstellen
            //           println("Ihr Kreuzer wurde bei "+ pos + " gesetzt")

            var pcFeld = new Feld(size)
            var pcController = new Controller(pcFeld)
            //Schiffe für Computer setzen
            var schiffGesetzt = false
            for (k <- 1 to 4) {

              while (schiffGesetzt == false) {
                var startReihe = scala.util.Random.nextInt(5 - 1) + 1
                var startSpalte = scala.util.Random.nextInt(5 - 1) + 1
                var ersteZelle = pcFeld.zellen(startReihe)(startSpalte)
                if (ersteZelle.gesetzt == true) {
                  schiffGesetzt = false
                } else {

                  pcController.set(2, startReihe, startSpalte, 5)
                  schiffGesetzt = true

                }
              }
              schiffGesetzt = false
            }

            println("Die Schiffe des Computers wurden gesetzt")
            println("IHR EIGENES SPIELFELD:")
            printTui
            println("DAS SPIELFELD DES COMPUTERS:")
            println(pcFeld.toString())

        }
      case "10" => controller.setSize(10)
      case "5" => controller.setSize(5)
      case "2" => controller.setSize(2)
      case _ => //Controller.falseInput
    }
    continue
  }

}