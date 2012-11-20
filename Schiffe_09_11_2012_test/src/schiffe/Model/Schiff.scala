package schiffe.Model

class Schiff(var laenge: Int, var startZelle: Zelle, var zellen: Array[Array[Zelle]]) {

  def setzen(richtung: Int, groesse: Int) = {
    var direction = richtung
    var gesetzt = false
    while (gesetzt == false) {

      direction match {
        //nach oben
        case 0 =>
          if (laenge == 1) {
            zellen(startZelle.reihe)(startZelle.spalte).setzen(true)
            gesetzt = true
          } else {
            if ((((startZelle.reihe) - laenge) + 1) >= 0) {



              for (i <- 0 to laenge - 1) {

                zellen((startZelle.reihe - i))(startZelle.spalte).setzen(true)

              }
              gesetzt = true

            } else {
              gesetzt = false
            }
          }
        //nach unten  
        case 1 =>
          if (laenge == 1) {
            zellen(startZelle.reihe)(startZelle.spalte).setzen(true)
            gesetzt = true
          } else {
            if ((((startZelle.reihe) + laenge) - 1) <= groesse) {



              for (i <- 0 to laenge - 1) {

                zellen((startZelle.reihe + i))(startZelle.spalte).setzen(true)

              }
              gesetzt = true

            } else {
              gesetzt = false
            }
          }

        //nach rechts
        case 2 =>
          if (laenge == 1) {
            zellen(startZelle.reihe)(startZelle.spalte).setzen(true)
            gesetzt = true
          } else {
            if ((((startZelle.spalte) + laenge) - 1) <= groesse) {



              for (i <- 0 to laenge - 1) {

                zellen((startZelle.reihe))(startZelle.spalte + i).setzen(true)

              }
              gesetzt = true

            } else {
              gesetzt = false
            }
          }

        //nach links
        case 3 =>
          if (laenge == 1) {
            zellen(startZelle.reihe)(startZelle.spalte).setzen(true)
            gesetzt = true
          } else {
            if ((((startZelle.spalte) - laenge) + 1) >= 0) {

              for (i <- 0 to laenge - 1) {

                zellen((startZelle.reihe))(startZelle.spalte - i).setzen(true)

              }
              gesetzt = true

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

    def umfeldKontrolle: Boolean = {

      return true
    }
    //  def zelle(index: Int) = cs(index)
    //  def toIntSet:Set[Int] = cs.filterNot(_.value=="X").map(_.value).toSet
    //  def toIntList:List[Int] = cs.filterNot(_.value=="X").map(_.value).toList
    //  def valid = this.toIntList == this.toIntSet.toList 

  }
}