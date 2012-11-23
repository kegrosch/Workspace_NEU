package schiffe.Model

class Schiff(var laenge: Int, var startZelle: Zelle, var zellen: Array[Array[Zelle]]) {

  def setzen(richtung: Int, groesse: Int): Boolean = {
    var direction = richtung
    var gesetzt = false
    var zaehler = 0;
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
              } else {
                gesetzt = false
                zaehler = zaehler + 1
              }

            } else {
              gesetzt = false
              zaehler = zaehler + 1
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
                
                
                if(umfeldKontrolle(groesse, direction)==true){
                
                
                for (i <- 0 to (laenge - 1)) {
                  zellen((startZelle.reihe + i))(startZelle.spalte).setzen(true)

                }
                return true
              }else {
                gesetzt = false
                zaehler = zaehler + 1
              }
              } else {
                gesetzt = false
                zaehler = zaehler + 1
              }

            } else {
              gesetzt = false
              zaehler = zaehler + 1
            }
          }

        //nach rechts
        case 2 =>
          if (laenge == 1) {
            if (schiffLaengeKurz == true) {
              return true
            } else {
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
                zaehler = zaehler + 1
              }

            } else {
              gesetzt = false
              zaehler = zaehler + 1
            }
          }

        //nach links
        case 3 =>
          if (laenge == 1) {
            if (schiffLaengeKurz == true) {
              return true
            } else {
              return false
            }
          } else {
            if ((((startZelle.spalte) - laenge) + 1) >= 0) {
              if (schiffKontrolleLinks == true) {
                for (i <- 0 to laenge - 1) {
                  zellen((startZelle.reihe))(startZelle.spalte - i).setzen(true)

                }
                return true
              } else {
                gesetzt = false
                zaehler = zaehler + 1
              }

            } else {
              gesetzt = false
              zaehler = zaehler + 1
            }
          }

        //Falsche Zufallszahl  
        case _ =>
          direction = scala.util.Random.nextInt(3 - 0) + 0
          gesetzt = false
      }
      if (gesetzt == false) {
        if (zaehler >= 15) {
          return false
        }
        direction = scala.util.Random.nextInt(3 - 0) + 0
      }

    }
    return true
  }

  def schiffLaengeKurz: Boolean = {
    if (zellen(startZelle.reihe)(startZelle.spalte).getGesetzt == true) {
      return false
    } else {
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
    for (i <- 0 to (laenge - 1)) {
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
  def umfeldKontrolle(groesse: Int, richtung: Int): Boolean = {
    var okay = true

    startZelle.getReihe match {
      case 0 => //Reihe = erste Reihe
        startZelle.getSpalte match {
          case 0 => //Spalte = erste Spalte & Reihe = erste Reihe
            richtung match {
              case 1 => //Schiff geht nach unten
                for (i <- 0 to laenge) {
                  if((zellen(startZelle.getReihe+i)(startZelle.getSpalte+1).getGesetzt)==true){
                    return false
                  }else{
                    okay = true
                  }
                }
                if(((zellen(startZelle.getReihe+laenge)(startZelle.getSpalte).getGesetzt)==true)){
                  return false
                }else{
                  if((zellen(startZelle.getReihe+laenge)(startZelle.getSpalte+1).getGesetzt)==true){
                	  return false
                  }else{
                    return okay
                  }
                }
              case 2 => //Schiff geht nach rechts
                 for (i <- 0 to laenge) {
                   if((zellen(startZelle.getReihe+1)(startZelle.getSpalte+i).getGesetzt)==true){
                    return false
                  }else{
                    okay = true
                  }
                 
                 }
                 if(((zellen(startZelle.getReihe)(startZelle.getSpalte+laenge).getGesetzt)==true)){
                  return false
                }else{
                  if((zellen(startZelle.getReihe+1)(startZelle.getSpalte+laenge).getGesetzt)==true){
                	  return false
                  }else{
                    return okay
                  }
                }
                
            }
          case `groesse` => //Spalte = letzte Spalte & Reihe = erste Reihe
            richtung match {
              case 1 => //Schiff geht nach unten
                for (i <- 0 to laenge) {
                  if((zellen(startZelle.getReihe+i)(startZelle.getSpalte-1).getGesetzt)==true){
                    return false
                  }else{
                    okay = true
                  }
                }
                if(((zellen(startZelle.getReihe+laenge)(startZelle.getSpalte).getGesetzt)==true)){
                  return false
                }else{
                  if((zellen(startZelle.getReihe+laenge)(startZelle.getSpalte-1).getGesetzt)==true){
                	  return false
                  }else{
                    return okay
                  }
                }
                
              case 3 => //Schiff geht nach links
                for (i <- groesse to (groesse-laenge)) {
                   if((zellen(startZelle.getReihe+1)(i).getGesetzt)==true){
                    return false
                  }else{
                    okay = true
                  }
                 
                 }
                 if(((zellen(startZelle.getReihe)(startZelle.getSpalte-laenge).getGesetzt)==true)){
                  return false
                }else{
                  if((zellen(startZelle.getReihe+1)(startZelle.getSpalte-laenge).getGesetzt)==true){
                	  return false
                  }else{
                    return okay
                  }
                }
                
            }
          case _ => //Spalte != erste Spalte & Spalte != letzte Spalte & Reihe = erste Reihe
            richtung match {
              case 1 => // Schiff geht nach unten
                 for (i <- 0 to laenge) {
                    if((zellen(startZelle.getReihe+i)(startZelle.getSpalte-1).getGesetzt)==true){
                    return false
                  }else{
                     if((zellen(startZelle.getReihe+i)(startZelle.getSpalte+1).getGesetzt)==true){
                    return false
                  }else{
                    okay = true
                  }
                    okay = true
                  }
                 }
                 if((zellen(startZelle.getReihe+laenge)(startZelle.getSpalte-1).getGesetzt)==true){
                	  return false
                  }else{
                    if((zellen(startZelle.getReihe+laenge)(startZelle.getSpalte+1).getGesetzt)==true){
                	  return false
                  }else{
                    if((zellen(startZelle.getReihe+laenge)(startZelle.getSpalte).getGesetzt)==true){
                    	return false
                    }else{
                      return okay
                    }
                  }
                  }
              case 2 => // Schiff geht nach rechts
                //überprüfen ob rechts anstößt
              case 3 => // Schiff geht links
                //überprüfen ob links anstößt
            }
        }
      case `groesse` => // Reihe = letzte Reihe
        startZelle.getSpalte match {
          case 0 => //Spalte = erste Spalte & Reihe = letzte Reihe
            richtung match {
              case 0 => //Schiff geht nach oben
              case 2 => //Schiff geht nach rechts
            }
          case `groesse` => //Spalte = letzte Spalte & Reihe = letzte Reihe
            richtung match {
              case 0 => //Schiff geht nach oben
              case 3 => //Schiff geht nach links
            }
          case _ => //Spalte != erste Spalte & Spalte != letzte Spalte & Reihe = letzte Reihe
            richtung match {
              case 0 => // Schiff geht nach oben
              case 2 => // Schiff geht nach rechts
                //überprüfen ob rechts anstößt
                
              case 3 => // Schiff geht links
                //überprüfen ob links anstößt
            }
        }
      case _ => // Reihe != erste Reihe & Reihe != letzte Reihe
        startZelle.getSpalte match {
          case 0 => //Spalte = erste Spalte & Reihe != erste Reihe & Reihe != letzte Reihe
            richtung match {
              case 0 => //Schiff geht nach oben
                //überprüfen ob oben anstößt
                
              case 1 => // Schiff geht nach unten
                //überprüfen ob unten anstößt
                
              case 2 => //Schiff geht nach rechts
            }
          case `groesse` => //Spalte = letzte Spalte & Reihe != erste Reihe & Reihe != letzte Reihe
            richtung match {
              case 0 => //Schiff geht nach oben
                // überprüfen ob oben anstößt
                
              case 1 => // Schiff geht nach unten
                //überprüfen ob unten anstößt
                
              case 3 => //Schiff geht nach links
            }
          case _ => //Spalte != erste Spalte & Spalte != letzte Spalte & Reihe != erste Reihe & Reihe != letzte Reihe
            richtung match {
              case 0 => // Schiff geht nach oben
                //überprüfen ob oben anstößt
                
              case 1 => // SChiff geht nach unten
                //überprüfen ob unten anstößt
                
              case 2 => // Schiff geht nach rechts
                //überprüfen ob rechts anstößt
                
              case 3 => // Schiff geht links
                //überprüfen ob links anstößt
            }
        }
    }

    return true
  }
  //  def zelle(index: Int) = cs(index)
  //  def toIntSet:Set[Int] = cs.filterNot(_.value=="X").map(_.value).toSet
  //  def toIntList:List[Int] = cs.filterNot(_.value=="X").map(_.value).toList
  //  def valid = this.toIntList == this.toIntSet.toList 

}