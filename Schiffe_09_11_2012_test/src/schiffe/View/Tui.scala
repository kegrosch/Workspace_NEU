package schiffe.View
import schiffe.Controller._
import schiffe.util._

class Tui (var controller: Controller) extends Observer {
  controller.add(this)
  printTui
  def update = printTui
  def printTui = {
    println(controller.feld.toString())
//    println("Bitte Anzahl der Zellen angeben")
  }
 def readInput(eingabe: String) = {
   var continue = true
   eingabe match{
     case "q" => continue = false
     case "s" => //Controller.solve
     case "r" => // Controller.reset
     case "set" => 
       var size = controller.feld.size
       size match{
         case 2 => 
           println("Geben Sie die Position Ihres Zerstörers ein")
           var pos = readLine()
           //Schiff mit Länge 2 und Position pos erstellen
           println("Zerstörer wurde bei "+ pos + " gesetzt")
           
         case 5 =>
           println("Geben Sie die Position Ihres 1.ten Zerstörers ein")
           var pos = readLine()
           pos.toList.filter(c => c != ' ').map(c => c.toString.toInt) match{
            case row :: column :: Nil => {
              println("ROW: "+ row + " Column: " + column)
              
                controller.set(row, column)
                printTui
             }
            
            case _ => println("Falsche Eingabe - Geben Sie ZeileSpalte (bsp. 55) ein")
           }
//           var row = pos.subSequence(0,1)
//           var column = pos.subSequence(1,2)
           
//           controller.set(row.toString().toInt, column.toString().toInt)
//           Schiff mit Länge 2 und Position pos erstellen
           println("1.ter Zerstörer wurde bei "+ pos + " gesetzt")
           println("Geben Sie die Position Ihres 2.ten Zerstörers ein")
           pos = readLine()
           //Schiff mit Länge 2 und Position pos erstellen
           println("2.ter Zerstörer wurde bei "+ pos + " gesetzt")
           println("Geben Sie die Position Ihres 3.ten Zerstörers ein")
           pos = readLine()
           //Schiff mit Länge 2 und Position pos erstellen
           println("3.ter Zerstörer wurde bei "+ pos + " gesetzt")
           println("Geben Sie die Position Ihres 1.ten UBoots ein")
           pos = readLine()
           //Schiff mit Länge 3 und Position pos erstellen
           println("1.tes UBoot wurde bei "+ pos + " gesetzt")
           println("Geben Sie die Position Ihres 2.ten UBoots ein")
           pos = readLine()
           //Schiff mit Länge 3 und Position pos erstellen
           println("2.tes UBoot wurde bei "+ pos + " gesetzt")
           println("Geben Sie die Position Ihres Kreuzers ein")
           pos = readLine()
           //Schiff mit Länge 4 und Position pos erstellen
           println("Ihr Kreuzer wurde bei "+ pos + " gesetzt")
       }
       println("Die Schiffe des Computers wurden gesetzt")
       printTui
       
     case "10" => controller.setSize(10)
     case "5" => controller.setSize(5)
     case "2" => controller.setSize(2)
     case _ => //Controller.falseInput
   }
   continue
 } 

}