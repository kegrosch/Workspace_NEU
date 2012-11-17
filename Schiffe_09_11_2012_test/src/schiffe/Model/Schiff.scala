package schiffe.Model

class Schiff(var laenge: Int, var startZelle: Zelle, var zellen: Array[Zelle]) {
 
  def setzen = {
     
    var gesetzt = false
    while (gesetzt == false) {
      //Richtung wird zufällig generiert
      var richtung = scala.util.Random.nextInt(5-0)+0
      richtung = 0
    richtung match{
        //nach oben
        case 0 =>
          if ((startZelle.reihe - laenge) >= 0){
            for(i <- 0 until zellen.length){
            	if(zellen(i).getReihe == (startZelle.reihe-laenge)){
            		if(zellen(i).getSpalte==startZelle.spalte){
            		  zellen(i).setzen(true)
            		}
            	}
            }
            
    	  for(i <- 0 until laenge-1){
    	    for(i <- 0 until zellen.length){
            	if(zellen(i).getReihe == (startZelle.reihe-i)){
            		if(zellen(i).getSpalte==startZelle.spalte){
            		  zellen(i).setzen(true)
            		}
            	}
            }
    	    
    	  }
    	  gesetzt = true
    	  println("Schiff von "+ startZelle.getReihe +" / " + startZelle.getSpalte + " gesetzt!!!!")
          }else{
            gesetzt = false
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