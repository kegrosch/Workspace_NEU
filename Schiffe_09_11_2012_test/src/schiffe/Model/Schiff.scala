package schiffe.Model

class Schiff(var laenge: Int, var startZelle: Zelle, var zellen: Array[Array[Zelle]]) {

  def setzen(richtung: Int, groesse: Int): Boolean = {
    var direction = richtung
    var gesetzt = false
    while (gesetzt == false) {

      direction match {
        //nach oben
        case 0 =>
          if (laenge == 1) {
            if (schiffLaengeKurz == true) {
              return true
            } else {
              return false
            }

          } else {
            if ((((startZelle.reihe) - laenge) + 1) >= 0) {

              if (schiffKontrolleOben == true) {
                for (i <- 0 to laenge - 1) {
                  zellen((startZelle.reihe - i))(startZelle.spalte).setzen(true)
                  
                }
                return true
              }else{
                gesetzt = false
              }

            } else {
              gesetzt = false
            }
          }
        //nach unten  
        case 1 =>
          if (laenge == 1) {
            if (schiffLaengeKurz == true) {
              return true
            } else {
              return false
            }
          } else {
            if ((((startZelle.reihe) + laenge) - 1) <= groesse) {

              if (schiffKontrolleUnten == true) {
                for (i <- 0 to laenge - 1) {
                  zellen((startZelle.reihe + i))(startZelle.spalte).setzen(true)
                  
                }
                return true
              } else {
                gesetzt = false
              }

            } else {
              gesetzt = false
            }
          }

        //nach rechts
        case 2 =>
          if (laenge == 1) {
            if(schiffLaengeKurz == true){
              return true
            }else{
              return false
            }
          } else {
            if ((((startZelle.spalte) + laenge) - 1) <= groesse) {

              if (schiffKontrolleRechts == true) {
                for (i <- 0 to laenge - 1) {
                  zellen((startZelle.reihe))(startZelle.spalte + i).setzen(true)
                  
                }
                return true
              } else {
                gesetzt = false
              }

            } else {
              gesetzt = false
            }
          }

        //nach links
        case 3 =>
          if (laenge == 1) {
            if(schiffLaengeKurz == true){
              return true
            }else{
              return false
            }
          } else {
            if ((((startZelle.spalte) - laenge) + 1) >= 0) {
            	if(schiffKontrolleLinks==true){
            	  for (i <- 0 to laenge - 1) {
            	      zellen((startZelle.reihe))(startZelle.spalte - i).setzen(true)
            	      
            	  }
            	  return true
            	}else{
            	  gesetzt = false
            	}
              

            } else {
              gesetzt = false
            }
          }

        //Falsche Zufallszahl  
        case _ =>
          direction = scala.util.Random.nextInt(3 - 0) + 0
          gesetzt = false
      }
      if (gesetzt == false) {
        direction = scala.util.Random.nextInt(3 - 0) + 0
      }
      
    }
    return gesetzt
  }
  
  def schiffLaengeKurz: Boolean ={
    if(zellen(startZelle.reihe)(startZelle.spalte).getGesetzt==true){
              return false
            }else{
            zellen(startZelle.reihe)(startZelle.spalte).setzen(true)
            return true
            }
            
  }

  def schiffKontrolleOben: Boolean = {
    var frei = true
    for (i <- 0 to laenge - 1) {

      if (zellen((startZelle.reihe - i))(startZelle.spalte).getGesetzt == true) {
        frei = false
        return frei
      } else {
        
        frei = true

      }

    }
    return frei

  }
  def schiffKontrolleUnten: Boolean = {
    var frei = true
    for (i <- 0 to laenge - 1) {
      if (zellen((startZelle.reihe + i))(startZelle.spalte).getGesetzt == true) {
        frei = false
        return frei
      } else {

        
        frei = true
      }

    }
    return frei
  }
  def schiffKontrolleRechts: Boolean = {
    var frei = true
    for (i <- 0 to laenge - 1) {

      if (zellen((startZelle.reihe))(startZelle.spalte + i).getGesetzt == true) {
        frei = false
        return frei
      } else {
        
        frei = true
      }

    }
    return frei
  }
  def schiffKontrolleLinks: Boolean = {
    var frei = true
    for (i <- 0 to laenge - 1) {

      if (zellen((startZelle.reihe))(startZelle.spalte - i).getGesetzt == true) {
        frei = false
        return frei
      } else {

        frei = true
      }

    }
    return frei
  }
    def umfeldKontrolle: Boolean = {

      return true
    }
    //  def zelle(index: Int) = cs(index)
    //  def toIntSet:Set[Int] = cs.filterNot(_.value=="X").map(_.value).toSet
    //  def toIntList:List[Int] = cs.filterNot(_.value=="X").map(_.value).toList
    //  def valid = this.toIntList == this.toIntSet.toList 

  
}