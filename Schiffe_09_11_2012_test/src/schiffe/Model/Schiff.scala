package schiffe.Model

class Schiff(var laenge: Int, var startZelle: Zelle, var zellen: Array[Array[Zelle]]) {
 
  def setzen = {
     
    var gesetzt = false
    while (gesetzt == false) {
      //Richtung wird zufällig generiert
      var richtung = scala.util.Random.nextInt(5-0)+0
      richtung = 0
    richtung match{
        //nach oben
        case 0 =>
          if(laenge == 1){
            zellen(startZelle.reihe)(startZelle.spalte).setzen(true)
            gesetzt = true
          }else{
          if ((((startZelle.reihe) - laenge)+1) >= 0){
            
            			//End Zelle auf true setzen
            		  zellen(startZelle.reihe-laenge+1)(startZelle.spalte).setzen(true)
            		
            	
            
            
    	  for(i <- 0 to laenge-1){
    	 
            	
            		  zellen((startZelle.reihe-i))(startZelle.spalte).setzen(true)
            	
            
    	    
    	  }
    	  gesetzt = true
    	  println("Schiff von "+ (startZelle.getReihe.toInt+1) +" / " + (startZelle.getSpalte.toInt+1) + " gesetzt!!!!")
          }else{
            gesetzt = false
          }
      }
        //nach unten  
        case 1 =>
          
        //nach rechts
        case 2 =>
          
        //nach links
        case 3 =>
          
        //Falsche Zufallszahl  
        case _ =>
      }
      if ((startZelle.reihe - laenge) >= 0) {
    	  
      }

      
      
      
      
      

    }

    //  def zelle(index: Int) = cs(index)
    //  def toIntSet:Set[Int] = cs.filterNot(_.value=="X").map(_.value).toSet
    //  def toIntList:List[Int] = cs.filterNot(_.value=="X").map(_.value).toList
    //  def valid = this.toIntList == this.toIntSet.toList 

  }
}