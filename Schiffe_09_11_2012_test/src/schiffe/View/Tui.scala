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
  var size = controller.feld.zellen.length
  def readInput(eingabe: String) = {
    var continue = true
    eingabe match {
      case "q" => continue = false
      case "s" => //Controller.solve
      case "r" => // Controller.reset
      case "set" =>
        size = controller.feld.zellen.length
        size match {
          case 2 =>

            var gesetzt = false
            while (gesetzt == false) {
              println("Geben Sie die das 1.te Feld Ihres Zerst�rers und deren Richtung ein (Reihe/Spalte/Richtung(z.B. 131))")
              println("Richtungen: 0-Oben; 1-Unten; 2-Rechts; 3-Links")
              var pos = readLine()
              pos.toList.filter(c => c != ' ').map(c => c.toString) match {
                case row :: "," :: column :: "," :: richtung :: Nil => {

                  if (controller.set(2, row.toInt, column.toInt, richtung.toInt, (size - 1))) {
                    println("Zerst�rer wurde bei " + row + " / " + column + " gesetzt")
                    gesetzt = true
                  } else {
                    println("Falsche eingabe der Position (es darf im umfeld von bereits gesetzten Schiffen kein weiteres gesetzte werden")
                    gesetzt = false
                  }
                }

                case _ => println("Falsche Eingabe - Geben Sie ZeileSpalte (bsp. 55r) ein")
              }
            }
            var pcFeld = new Feld(size)
            var pcController = new Controller(pcFeld)
            //Schiffe f�r Computer setzen
            var schiffGesetzt = false

            while (schiffGesetzt == false) {
              var startReihe = scala.util.Random.nextInt(2 - 1) + 1
              var startSpalte = scala.util.Random.nextInt(2 - 1) + 1
              var ersteZelle = pcFeld.zellen(startReihe)(startSpalte)

              if (pcController.set(2, startReihe, startSpalte, 5, (size - 1)) == true) {
                schiffGesetzt = true
              } else {
                schiffGesetzt = false
              }

            }
            schiffGesetzt = false

            println("Die Schiffe des Computers wurden gesetzt")
            println("IHR EIGENES SPIELFELD:")
            printTui
            println("DAS SPIELFELD DES COMPUTERS:")
            println(pcFeld.toString())

          case 5 =>
            var gesetzt = false
            while (gesetzt == false) {
              println("Geben Sie die das 1.te Feld Ihres Kreuzers und deren Richtung ein (Reihe/Spalte/Richtung(z.B. 131))")
              println("Richtungen: 0-Oben; 1-Unten; 2-Rechts; 3-Links")
              var pos = readLine()
              pos.toList.filter(c => c != ' ').map(c => c.toString) match {
                case row :: "," :: column :: "," :: richtung :: Nil => {

                  if (controller.set(4, row.toInt, column.toInt, richtung.toInt, (size - 1))) {
                    println("Kreuzer wurde bei " + row + " / " + column + " gesetzt")
                    gesetzt = true
                  } else {
                    println("Falsche eingabe der Position (es darf im umfeld von bereits gesetzten Schiffen kein weiteres gesetzte werden")
                    gesetzt = false
                  }

                }

                case _ => println("Falsche Eingabe - Geben Sie ZeileSpalte (bsp. 55) ein")
              }
            }
            gesetzt = false
            while (gesetzt == false) {
              println("Geben Sie die das 1.te Feld Ihres U-Boots und deren Richtung ein (Reihe/Spalte/Richtung(z.B. 131))")
              println("Richtungen: 0-Oben; 1-Unten; 2-Rechts; 3-Links")
              var pos = readLine()
              pos.toList.filter(c => c != ' ').map(c => c.toString) match {
                case row :: "," :: column :: "," :: richtung :: Nil => {

                  if (controller.set(3, row.toInt, column.toInt, richtung.toInt, (size - 1))) {
                    println("U-Boot wurde bei " + row + " / " + column + " gesetzt")
                    gesetzt = true
                  } else {
                    println("Falsche eingabe der Position (es darf im umfeld von bereits gesetzten Schiffen kein weiteres gesetzte werden")
                    gesetzt = false
                  }
                }

                case _ => println("Falsche Eingabe - Geben Sie ZeileSpalte (bsp. 55) ein")
              }
            }

            for (i <- 1 to 2) {
              var gesetzt = false
              while (gesetzt == false) {
                println("Geben Sie die das 1.te Feld Ihres " + i + ".ten Zerst�rers und deren Richtung ein (Reihe/Spalte/Richtung(z.B. 131))")
                println("Richtungen: 0-Oben; 1-Unten; 2-Rechts; 3-Links")
                var pos = readLine()

                pos.toList.filter(c => c != ' ').map(c => c.toString) match {
                  case row :: "," :: column :: "," :: richtung :: Nil => {

                    if (controller.set(2, row.toInt, column.toInt, richtung.toInt, (size - 1))) {
                      println(i + ".ter Zerst�rer wurde bei " + row + " / " + column + " gesetzt")
                      gesetzt = true
                    } else {
                      println("Falsche eingabe der Position (es darf im umfeld von bereits gesetzten Schiffen kein weiteres gesetzte werden")
                      gesetzt = false
                    }
                  }

                  case _ => println("Falsche Eingabe - Geben Sie ZeileSpalte (bsp. 55r) ein")
                }
              }
            }
            var pcFeld = new Feld(size)
            var pcController = new Controller(pcFeld)
            //Schiffe f�r Computer setzen
            var schiffGesetzt = false
            while (schiffGesetzt == false) {
              var startReihe = scala.util.Random.nextInt(5 - 1) + 1
              var startSpalte = scala.util.Random.nextInt(5 - 1) + 1
              var ersteZelle = pcFeld.zellen(startReihe)(startSpalte)

              if (pcController.set(4, startReihe, startSpalte, 5, (size - 1)) == true) {
                schiffGesetzt = true
              } else {
                schiffGesetzt = false
              }

            }

            schiffGesetzt = false

            while (schiffGesetzt == false) {
              var startReihe = scala.util.Random.nextInt(5 - 1) + 1
              var startSpalte = scala.util.Random.nextInt(5 - 1) + 1
              var ersteZelle = pcFeld.zellen(startReihe)(startSpalte)

              if (pcController.set(3, startReihe, startSpalte, 5, (size - 1)) == true) {
                schiffGesetzt = true

              } else {
                schiffGesetzt = false

              }
            }
            schiffGesetzt = false

            for (k <- 1 to 2) {

              while (schiffGesetzt == false) {
                var startReihe = scala.util.Random.nextInt(5 - 1) + 1
                var startSpalte = scala.util.Random.nextInt(5 - 1) + 1
                var ersteZelle = pcFeld.zellen(startReihe)(startSpalte)

                if (pcController.set(2, startReihe, startSpalte, 5, (size - 1)) == true) {
                  schiffGesetzt = true

                } else {
                  schiffGesetzt = false

                }
              }
              schiffGesetzt = false
            }

            println("Die Schiffe des Computers wurden gesetzt")
            println("IHR EIGENES SPIELFELD:")
            printTui
            println("DAS SPIELFELD DES COMPUTERS:")
            println(pcFeld.toString())

          case 10 =>
            var gesetzt = false
            while (gesetzt == false) {
              println("Geben Sie die das 1.te Feld Ihres Schlachtschiffes und deren Richtung ein (Reihe/Spalte/Richtung(z.B. 131))")
              println("Richtungen: 0-Oben; 1-Unten; 2-Rechts; 3-Links")
              var pos = readLine()
              pos.toList.filter(c => c != ' ').map(c => c.toString) match {
                case row :: "," :: column :: "," :: richtung :: Nil => {

                  if (controller.set(5, row.toInt, column.toInt, richtung.toInt, (size - 1))) {
                    println("Schlachtschiff wurde bei " + row + " / " + column + " gesetzt")
                    gesetzt = true
                  } else {
                    println("Falsche eingabe der Position (es darf im umfeld von bereits gesetzten Schiffen kein weiteres gesetzte werden")
                    gesetzt = false
                  }
                }

                case _ => println("Falsche Eingabe - Geben Sie ZeileSpalte (bsp. 55) ein")
              }
            }
            for (i <- 1 to 2) {
              var gesetzt = false
              while (gesetzt == false) {
                println("Geben Sie die das 1.te Feld Ihres " + i + ".ten Kreuzers und deren Richtung ein (Reihe/Spalte/Richtung(z.B. 131))")
                println("Richtungen: 0-Oben; 1-Unten; 2-Rechts; 3-Links")
                var pos = readLine()
                pos.toList.filter(c => c != ' ').map(c => c.toString) match {
                  case row :: "," :: column :: "," :: richtung :: Nil => {

                    if (controller.set(4, row.toInt, column.toInt, richtung.toInt, (size - 1))) {
                      println(i + ".ter Kreuzer wurde bei " + row + " / " + column + " gesetzt")
                      gesetzt = true
                    } else {
                      println("Falsche eingabe der Position (es darf im umfeld von bereits gesetzten Schiffen kein weiteres gesetzte werden")
                      gesetzt = false
                    }

                  }

                  case _ => println("Falsche Eingabe - Geben Sie ZeileSpalte (bsp. 55) ein")
                }
              }
            }
            for (i <- 1 to 3) {
              var gesetzt = false
              while (gesetzt == false) {
                println("Geben Sie die das 1.te Feld Ihres " + i + ".ten U-Boots und deren Richtung ein (Reihe/Spalte/Richtung(z.B. 131))")
                println("Richtungen: 0-Oben; 1-Unten; 2-Rechts; 3-Links")
                var pos = readLine()
                pos.toList.filter(c => c != ' ').map(c => c.toString) match {
                  case row :: "," :: column :: "," :: richtung :: Nil => {

                    if (controller.set(3, row.toInt, column.toInt, richtung.toInt, (size - 1))) {
                      println(i + ".tes U-Boot wurde bei " + row + " / " + column + " gesetzt")
                      gesetzt = true
                    } else {
                      println("Falsche eingabe der Position (es darf im umfeld von bereits gesetzten Schiffen kein weiteres gesetzte werden")
                      gesetzt = false
                    }
                  }

                  case _ => println("Falsche Eingabe - Geben Sie ZeileSpalte (bsp. 55) ein")
                }
              }
            }
            for (i <- 1 to 4) {
              var gesetzt = false
              while (gesetzt == false) {
                println("Geben Sie die das 1.te Feld Ihres " + i + ".ten Zerst�rers und deren Richtung ein (Reihe/Spalte/Richtung(z.B. 131))")
                println("Richtungen: 0-Oben; 1-Unten; 2-Rechts; 3-Links")
                var pos = readLine()

                pos.toList.filter(c => c != ' ').map(c => c.toString) match {
                  case row :: "," :: column :: "," :: richtung :: Nil => {

                    if (controller.set(2, row.toInt, column.toInt, richtung.toInt, (size - 1))) {
                      println(i + ".ter Zerst�rer wurde bei " + row + " / " + column + " gesetzt")
                      gesetzt = true
                    } else {
                      println("Falsche eingabe der Position (es darf im umfeld von bereits gesetzten Schiffen kein weiteres gesetzte werden")
                      gesetzt = false
                    }

                  }

                  case _ => println("Falsche Eingabe - Geben Sie ZeileSpalte (bsp. 55r) ein")
                }
              }
            }

            var pcFeld = new Feld(size)
            var pcController = new Controller(pcFeld)
            //Schiffe f�r Computer setzen
            var schiffGesetzt = false
            while (schiffGesetzt == false) {
              var startReihe = scala.util.Random.nextInt(10 - 1) + 1
              var startSpalte = scala.util.Random.nextInt(10 - 1) + 1
              var ersteZelle = pcFeld.zellen(startReihe)(startSpalte)

              if (pcController.set(5, startReihe, startSpalte, 5, (size - 1)) == true) {
                schiffGesetzt = true

              } else {
                schiffGesetzt = false

              }
            }
            schiffGesetzt = false
            for (k <- 1 to 2) {
              while (schiffGesetzt == false) {
                var startReihe = scala.util.Random.nextInt(10 - 1) + 1
                var startSpalte = scala.util.Random.nextInt(10 - 1) + 1
                var ersteZelle = pcFeld.zellen(startReihe)(startSpalte)

                if (pcController.set(4, startReihe, startSpalte, 5, (size - 1)) == true) {
                  schiffGesetzt = true
                } else {
                  schiffGesetzt = false

                }
              }
              schiffGesetzt = false
            }

            for (k <- 1 to 3) {

              while (schiffGesetzt == false) {
                var startReihe = scala.util.Random.nextInt(10 - 1) + 1
                var startSpalte = scala.util.Random.nextInt(10 - 1) + 1
                var ersteZelle = pcFeld.zellen(startReihe)(startSpalte)

                if (pcController.set(3, startReihe, startSpalte, 5, (size - 1)) == true) {
                  schiffGesetzt = true
                } else {
                  schiffGesetzt = false
                }

              }
              schiffGesetzt = false
            }
            for (k <- 1 to 4) {

              while (schiffGesetzt == false) {
                var startReihe = scala.util.Random.nextInt(10 - 1) + 1
                var startSpalte = scala.util.Random.nextInt(10 - 1) + 1
                var ersteZelle = pcFeld.zellen(startReihe)(startSpalte)

                if (pcController.set(2, startReihe, startSpalte, 5, (size - 1)) == true) {

                  schiffGesetzt = true
                } else {
                  schiffGesetzt = false
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