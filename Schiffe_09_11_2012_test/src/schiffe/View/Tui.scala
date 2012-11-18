package schiffe.View
import schiffe.Controller._
import schiffe.Model.Feld
import schiffe.util._
import schiffe.Model.Schiff

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
       var size = controller.feld.zellen.length
       size match{
         case 2 => 
           println("Geben Sie die Position Ihres Zerst�rers ein")
           var pos = readLine()
           //Schiff mit L�nge 2 und Position pos erstellen
           println("Zerst�rer wurde bei "+ pos + " gesetzt")
           
         case 5 =>
           println("Geben Sie die Position Ihres 1.ten Zerst�rers ein")
           var pos = readLine()
           pos.toList.filter(c => c != ' ').map(c => c.toString.toInt) match{
            case row :: column :: Nil => {
              println("ROW: "+ row + " Column: " + column)
              
                controller.set(2, row, column)

             }
            
            case _ => println("Falsche Eingabe - Geben Sie ZeileSpalte (bsp. 55) ein")
           }

//           Schiff mit L�nge 2 und Position pos erstellen
           println("1.ter Zerst�rer wurde bei "+ pos + " gesetzt")
           println("Geben Sie die Position Ihres 2.ten Zerst�rers ein")
           pos = readLine()
           pos.toList.filter(c => c != ' ').map(c => c.toString.toInt) match{
            case row :: column :: Nil => {
              println("ROW: "+ row + " Column: " + column)
              
                controller.set(2, row, column)

             }
            
            case _ => println("Falsche Eingabe - Geben Sie ZeileSpalte (bsp. 55) ein")
           }
           //Schiff mit L�nge 2 und Position pos erstellen
           println("2.ter Zerst�rer wurde bei "+ pos + " gesetzt")
//           println("Geben Sie die Position Ihres 3.ten Zerst�rers ein")
//           pos = readLine()
//           //Schiff mit L�nge 2 und Position pos erstellen
//           println("3.ter Zerst�rer wurde bei "+ pos + " gesetzt")
//           println("Geben Sie die Position Ihres 1.ten UBoots ein")
//           pos = readLine()
//           //Schiff mit L�nge 3 und Position pos erstellen
//           println("1.tes UBoot wurde bei "+ pos + " gesetzt")
//           println("Geben Sie die Position Ihres 2.ten UBoots ein")
//           pos = readLine()
//           //Schiff mit L�nge 3 und Position pos erstellen
//           println("2.tes UBoot wurde bei "+ pos + " gesetzt")
//           println("Geben Sie die Position Ihres Kreuzers ein")
//           pos = readLine()
//           //Schiff mit L�nge 4 und Position pos erstellen
//           println("Ihr Kreuzer wurde bei "+ pos + " gesetzt")
       
       var pcFeld = new Feld(size)
           var pcController = new Controller(pcFeld)
       //Schiffe f�r Computer setzen
       var schiffGesetzt=false
       for(k <- 1 to 4){
         
         while(schiffGesetzt==false){
         var startReihe = scala.util.Random.nextInt(5-1)+1
         var startSpalte = scala.util.Random.nextInt(5-1)+1
         var ersteZelle = pcFeld.zellen(startReihe)(startSpalte)
         if(ersteZelle.gesetzt == true){
           schiffGesetzt = false
         }else{
         
         pcController.set(2,startReihe,startSpalte)
         schiffGesetzt=true
         
         }
       }
         schiffGesetzt=false
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