package schiffe.Model
import org.specs2.mutable._
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner


@RunWith(classOf[JUnitRunner])
class SchiffSpec extends SpecificationWithJUnit{
  "A new Schiff" should{
    var feld = new Feld(5)
    var zellen = feld.zellen
    var startZelle = zellen(0)(0)
    var schiff = new Schiff(1, startZelle, zellen)
    
    "Cell Should be set when set (Richtung: oben)" in{
      schiff.setzen(0,4)
      var isSet = zellen(0)(0).getGesetzt
      isSet must be_==(true)
       }
    
   
    "Cell should be set when set (Richtung: unten)" in{
      schiff.setzen(1,4)
      var isSet = zellen(0)(0).getGesetzt
      isSet must be_==(true)
    }
    "Cell should be set when set (Richtung: rechts)" in{
      feld.reset
      schiff.setzen(2,4)
      var isSet = zellen(0)(0).getGesetzt
      isSet must be_==(true)
    }
    "Cell should be set when set (Richtung: links)" in{
      
      feld.reset
      schiff.setzen(3,4)
      var isSet = zellen(0)(0).getGesetzt 
      isSet must be_==(true)
    }
    "Cant set ship when already set" in{
      feld.reset
      schiff.setzen(0,4)
      var isAlreadySet = schiff.setzen(0,4)
      isAlreadySet must be_==(false)
    }
    "Ship is set when set" in{
      var feldNeu = feld.reset
      
      var langSchiff = new Schiff(2, startZelle, feldNeu.zellen)
      var canSet = langSchiff.setzen(0,4)
      canSet must be_==(true)
      
    }
    "Ship is set when set (nach oben)" in{
      var startZelleUnten = zellen(4)(1)
      var untenSchiff = new Schiff(2, startZelleUnten, zellen)
      var canSet = untenSchiff.setzen(0,4)
      canSet must be_==(false)
    }
    "cant set if a ship is set nearby (nach oben)" in{
      var startZelle1 = zellen(4)(1)
      var startZelle2 = zellen(4)(2)
      var schiff1 = new Schiff(2, startZelle1, zellen)
      var schiff2 = new Schiff(2, startZelle2, zellen)
      schiff1.setzen(0,4)
      var canSet = schiff2.setzen(0,4)
      canSet must be_==(false)
    }
    "cant set if a ship is set in the cells already (oben)" in{
      var startZelle1 = zellen(4)(1)
      var startZelle2 = zellen(3)(1)
      var schiff1 = new Schiff(2, startZelle1, zellen)
      var schiff2 = new Schiff(2, startZelle2, zellen)
      schiff2.setzen(0,4)
      var canSet = schiff1.setzen(0,4)
      canSet must be_==(false)
    }
    
    "if ship is short and cell is already set(direction:oben)" in{
      var feldShort = new Feld(5)
      var startZelleShort1 = zellen(4)(0)
      var startZelleShort2 = zellen(4)(0)
      var schiff1 = new Schiff(1, startZelleShort1, feldShort.zellen)
      var schiff2 = new Schiff(1, startZelleShort2, feldShort.zellen)
      schiff1.setzen(0,4)
      var canSet = schiff2.setzen(0,4)
      canSet must be_==(false)
    }
    
    //unten
    "if ship is short and cell is already set(direction:down)" in{
      var feldShort = new Feld(5)
      var startZelleShort1 = zellen(0)(0)
      var startZelleShort2 = zellen(0)(0)
      var schiff1 = new Schiff(1, startZelleShort1, feldShort.zellen)
      var schiff2 = new Schiff(1, startZelleShort2, feldShort.zellen)
      schiff1.setzen(1,4)
      var canSet = schiff2.setzen(1,4)
      canSet must be_==(false)
    }
    
    "if ship is not short and is not longer than size of feld(direction: down)" in{
    var feldNeu = new Feld(5)
    feld.reset
    var startZelleNeu = zellen(1)(1)
    var schiffNeu = new Schiff(2, startZelleNeu, feldNeu.zellen)
    var canSet = schiffNeu.setzen(1,4)
    canSet must be_==(true)
    }
    
    "if ship is not short and is longer than size of feld(direction: down)"in{
    var feldNeu = new Feld(5)
    feld.reset
    var startZelleNeu = zellen(1)(1)
    var schiffNeu = new Schiff(6, startZelleNeu, feldNeu.zellen)
    var canSet = schiffNeu.setzen(1,4)
    canSet must be_==(false)
      
    }
    
    "if the cells of the ship are not already set(direction: down)"in{
      var feldNeu = new Feld(5)
      var startZelle1 = zellen(3)(1)
      var schiff1 = new Schiff(2, startZelle1, feldNeu.zellen)
      var canSet = schiff1.setzen(1,4)
      canSet must be_==(true)
      
    }
    
    "if the cells of the ship are already set(direction: down)"in{
      var feldNeu = new Feld(5)
      var startZelle1 = zellen(1)(1)
      var startZelle2 = zellen(1)(1)
      var schiff1 = new Schiff(2, startZelle1, feldNeu.zellen)
      var schiff2 = new Schiff(2, startZelle2, feldNeu.zellen)
      schiff1.setzen(1,4)
      var canSet = schiff2.setzen(1,4)
      canSet must be_==(false)
    }
    
    "if there is no other ship nearby(direction: down)"in{
      var feldNeu = new Feld(5)
      var startZelle1 = zellen(1)(1)
      var schiff1 = new Schiff(2, startZelle1, feldNeu.zellen)
      var canSet = schiff1.setzen(1,4)
      canSet must be_==(true)
    }
    
    "if there is an other ship nearby(direction: down)"in{
      var feldNeu = new Feld(5)
      var startZelle1 = zellen(1)(1)
      var startZelle2 = zellen(1)(2)
      var schiff1 = new Schiff(2, startZelle1, feldNeu.zellen)
      var schiff2 = new Schiff(2, startZelle2, feldNeu.zellen)
      schiff1.setzen(1,4)
      var canSet = schiff2.setzen(1,4)
      canSet must be_==(false)
    }
    
    //rechts
    "if ship is short and cell is already set(direction:right)"in{
      var feldShort = new Feld(5)
      var startZelleShort1 = zellen(0)(0)
      var startZelleShort2 = zellen(0)(0)
      var schiff1 = new Schiff(1, startZelleShort1, feldShort.zellen)
      var schiff2 = new Schiff(1, startZelleShort2, feldShort.zellen)
      schiff1.setzen(2,4)
      var canSet = schiff2.setzen(2,4)
      canSet must be_==(false)
      
    }
    
    "if ship is not short and is not longer than size of feld(direction: right)"in{
    var feldNeu = new Feld(5)
    feld.reset
    var startZelleNeu = zellen(1)(1)
    var schiffNeu = new Schiff(2, startZelleNeu, feldNeu.zellen)
    var canSet = schiffNeu.setzen(2,4)
    canSet must be_==(true)
      
    }
    
    "if ship is not short and is longer than size of feld(direction: right)" in{
     var feldNeu = new Feld(5)
    feld.reset
    var startZelleNeu = zellen(3)(3)
    var schiffNeu = new Schiff(6, startZelleNeu, feldNeu.zellen)
    var canSet = schiffNeu.setzen(2,4)
    canSet must be_==(false) 
      
    }
    
    "if the cells of the ship are not already set(direction: right)" in{
     var feldNeu = new Feld(5)
      var startZelle1 = zellen(1)(1)
      var schiff1 = new Schiff(2, startZelle1, feldNeu.zellen)
      var canSet = schiff1.setzen(2,4)
      canSet must be_==(true) 
      
    }
    
    "if the cells of the ship are already set(direction: right)" in{
      var feldNeu = new Feld(5)
      var startZelle1 = zellen(1)(1)
      var startZelle2 = zellen(1)(1)
      var schiff1 = new Schiff(2, startZelle1, feldNeu.zellen)
      var schiff2 = new Schiff(2, startZelle2, feldNeu.zellen)
      schiff1.setzen(2,4)
      var canSet = schiff2.setzen(2,4)
      canSet must be_==(false)
      
    }
    
    "if there is no other ship nearby(direction: right)" in{
      var feldNeu = new Feld(5)
      var startZelle1 = zellen(1)(1)
      var schiff1 = new Schiff(2, startZelle1, feldNeu.zellen)
      var canSet = schiff1.setzen(2,4)
      canSet must be_==(true)}
    
    "if there is an other ship nearby(direction: right)" in{
      var feldNeu = new Feld(5)
      var startZelle1 = zellen(1)(1)
      var startZelle2 = zellen(1)(2)
      var schiff1 = new Schiff(2, startZelle1, feldNeu.zellen)
      var schiff2 = new Schiff(2, startZelle2, feldNeu.zellen)
      schiff1.setzen(2,4)
      var canSet = schiff2.setzen(2,4)
      canSet must be_==(false)
      }
    
    //left
    "if ship is short and cell is already set(direction:left)" in{
      var feldShort = new Feld(5)
      var startZelleShort1 = zellen(2)(2)
      var startZelleShort2 = zellen(2)(2)
      var schiff1 = new Schiff(1, startZelleShort1, feldShort.zellen)
      var schiff2 = new Schiff(1, startZelleShort2, feldShort.zellen)
      schiff1.setzen(3,4)
      var canSet = schiff2.setzen(3,4)
      canSet must be_==(false)
      }
    
    "if ship is not short and is not longer than size of feld(direction: left)" in{
    var feldNeu = new Feld(5)
    feld.reset
    var startZelleNeu = zellen(3)(3)
    var schiffNeu = new Schiff(2, startZelleNeu, feldNeu.zellen)
    var canSet = schiffNeu.setzen(3,4)
    canSet must be_==(true)
      
    }
    
    "if ship is not short and is longer than size of feld(direction: left)" in{
    var feldNeu = new Feld(5)
    feld.reset
    var startZelleNeu = zellen(3)(3)
    var schiffNeu = new Schiff(6, startZelleNeu, feldNeu.zellen)
    var canSet = schiffNeu.setzen(3,4)
    canSet must be_==(false)   
      
    }
    
    "if the cells of the ship are not already set(direction: left)" in{
      var feldNeu = new Feld(5)
      var startZelle1 = zellen(4)(1)
      var schiff1 = new Schiff(2, startZelle1, feldNeu.zellen)
      var canSet = schiff1.setzen(3,4)
      canSet must be_==(true) 
      
    }
    
    "if the cells of the ship are already set(direction: left)" in{
      var feldNeu = new Feld(5)
      var startZelle1 = zellen(4)(4)
      var startZelle2 = zellen(4)(4)
      var schiff1 = new Schiff(2, startZelle1, feldNeu.zellen)
      var schiff2 = new Schiff(2, startZelle2, feldNeu.zellen)
      schiff1.setzen(3,4)
      var canSet = schiff2.setzen(3,4)
      canSet must be_==(false)
      
    }
    
    "if there is no other ship nearby(direction: left)" in{
      var feldNeu = new Feld(5)
      var startZelle1 = zellen(3)(3)
      var schiff1 = new Schiff(2, startZelle1, feldNeu.zellen)
      var canSet = schiff1.setzen(3,4)
      canSet must be_==(true) 
      
    }
    
    "if there is an other ship nearby(direction: left)" in{
      var feldNeu = new Feld(5)
      var startZelle1 = zellen(3)(4)
      var startZelle2 = zellen(2)(4)
      var schiff1 = new Schiff(2, startZelle1, feldNeu.zellen)
      var schiff2 = new Schiff(2, startZelle2, feldNeu.zellen)
      schiff1.setzen(3,4)
      var canSet = schiff2.setzen(3,4)
      canSet must be_==(false)  
      
    }
    
    "if the random direction is wrong" in{
      
      var canSet = schiff.setzen(4,4)
      canSet must be_==(false)  
    }
    
    "it is possible to set one ship up one ship down" in{
      var feldNeu = new Feld(5)
      var startZelle1 = zellen(0)(0)
      var startZelle2 = zellen(4)(4)
      var schiff1 = new Schiff(4, startZelle1, feldNeu.zellen)
      var schiff2 = new Schiff(2, startZelle2, feldNeu.zellen)
      schiff1.setzen(1,4)
      var canSet = schiff2.setzen(0,4)
      canSet must be_==(true)  
    }
    
    "it is possible to set one ship right one ship left" in{
      var feldNeu = new Feld(5)
      var startZelle1 = zellen(0)(0)
      var startZelle2 = zellen(4)(4)
      var schiff1 = new Schiff(4, startZelle1, feldNeu.zellen)
      var schiff2 = new Schiff(2, startZelle2, feldNeu.zellen)
      schiff1.setzen(2,4)
      var canSet = schiff2.setzen(3,4)
      canSet must be_==(true)  
    }
    "it is possible to set one ship down one ship right" in{
      var feldNeu = new Feld(5)
      var startZelle1 = zellen(0)(0)
      var startZelle2 = zellen(2)(4)
      var schiff1 = new Schiff(4, startZelle1, feldNeu.zellen)
      var schiff2 = new Schiff(2, startZelle2, feldNeu.zellen)
      schiff1.setzen(1,4)
      var canSet = schiff2.setzen(2,4)
      canSet must be_==(true)  
    }
    
    "it is possible to set one ship down one ship left" in{
      var feldNeu = new Feld(5)
      var startZelle1 = zellen(0)(0)
      var startZelle2 = zellen(2)(4)
      var schiff1 = new Schiff(4, startZelle1, feldNeu.zellen)
      var schiff2 = new Schiff(2, startZelle2, feldNeu.zellen)
      schiff1.setzen(1,4)
      var canSet = schiff2.setzen(3,4)
      canSet must be_==(true)  
    }
    
    "it is possible to set one ship up one ship left" in{
      var feldNeu = new Feld(5)
      var startZelle1 = zellen(4)(4)
      var startZelle2 = zellen(2)(2)
      var schiff1 = new Schiff(4, startZelle1, feldNeu.zellen)
      var schiff2 = new Schiff(2, startZelle2, feldNeu.zellen)
      schiff1.setzen(0,4)
      var canSet = schiff2.setzen(3,4)
      canSet must be_==(true)  
    }
    
    "it is possible to set one ship up one ship right" in{
      var feldNeu = new Feld(5)
      var startZelle1 = zellen(4)(4)
      var startZelle2 = zellen(2)(0)
      var schiff1 = new Schiff(4, startZelle1, feldNeu.zellen)
      var schiff2 = new Schiff(2, startZelle2, feldNeu.zellen)
      schiff1.setzen(0,4)
      var canSet = schiff2.setzen(2,4)
      canSet must be_==(true)  
    }
 "Umfeldkontrolle Spalte = erste Spalte & Reihe = erste Reihe Schiff geht nach unten schiffsgroesse =2 feld=2 stösst unten an umfeldrechtsschongesetzt " in{
  var feldNeu = new Feld(2)
  var startZelle1 = feldNeu.zellen(0)(0)
  var startZelle2 = feldNeu.zellen(0)(1)
  var schiff2 = new Schiff(2, startZelle2, feldNeu.zellen)
  var schiff1 = new Schiff(2, startZelle1, feldNeu.zellen)
  schiff2.setzen(1,1)
  schiff1.setzen(1,1)
  var isSet = feldNeu.zellen(0)(0).getGesetzt
  isSet must be_==(false)
}

 
"Umfeldkontrolle Spalte = erste Spalte & Reihe = erste Reihe Schiff geht nach unten schiffsgroesse =4 stösst unten nicht an umfeldrechtsschongesetzt " in{
  var feldNeu = new Feld(5)
  var startZelle1 = feldNeu.zellen(0)(0)
  var startZelle2 = feldNeu.zellen(0)(1)
  var schiff2 = new Schiff(4, startZelle2, feldNeu.zellen)
  var schiff1 = new Schiff(4, startZelle1, feldNeu.zellen)
  schiff2.setzen(1,4)
  schiff1.setzen(1,4)
  var isSet = feldNeu.zellen(0)(0).getGesetzt
  isSet must be_==(false)
}
/*Zeile 266 soll überprüft werden*/
"Umfeldkontrolle Spalte = erste Spalte & Reihe = erste Reihe Schiff geht nach unten schiffsgroesse =4 stösst unten nicht an umfelduntenschongesetzt " in{
  var feldNeu = new Feld(5)
  var startZelle2 = feldNeu.zellen(4)(0)
  var schiff2 = new Schiff(2, startZelle2, feldNeu.zellen)
  schiff2.setzen(2,4)
  var startZelle1 = feldNeu.zellen(0)(0)
  var schiff1 = new Schiff(4, startZelle1, feldNeu.zellen)
  var canSet = schiff1.setzen(1,4)
  canSet must be_==(true)
}
"Umfeldkontrolle Spalte = erste Spalte & Reihe = erste Reihe Schiff geht nach unten groesse =4 stosst unten nicht an umfelduntenschongesetzt " in{
  feld.reset
  var startZelle2 = feld.zellen(4)(0)
  var startZelle1 = feld.zellen(0)(0)
  var schiff2 = new Schiff(2, startZelle2, feld.zellen)
  schiff2.setzen(2,4)
  var schiff1 = new Schiff(4, startZelle1, feld.zellen)
  schiff1.setzen(1,4)
  var isSet = feld.zellen(2)(0).getGesetzt
  isSet must be_==(false)
}
"Umfeldkontrolle Spalte = erste Spalte & Reihe = erste Reihe Schiff geht nach rechts groesse =4 stösst rechts nichts an umfelduntenschongesetzt " in{
  var feldNeu = new Feld(5)
  var startZelle1 = feldNeu.zellen(0)(0)
  var startZelle2 = feldNeu.zellen(1)(0)
  var schiff2 = new Schiff(4, startZelle2, feldNeu.zellen)
  var schiff1 = new Schiff(4, startZelle1, feldNeu.zellen)
  schiff2.setzen(2,4)
  schiff1.setzen(2,4)
  var isSet = feldNeu.zellen(0)(0).getGesetzt
  isSet must be_==(false)
}
"Umfeldkontrolle Spalte = erste Spalte & Reihe = erste Reihe Schiff geht nach rechts groesse =4 umfeldrechtsschongesetzt " in{
  var feldNeu = new Feld(5)
  feldNeu.reset
  var startZelle2 = feldNeu.zellen(0)(4)
  var startZelle1 = feldNeu.zellen(0)(0)
  var schiff2 = new Schiff(2, startZelle2, feldNeu.zellen)
  schiff2.setzen(1,4)
  var schiff1 = new Schiff(4, startZelle1, feldNeu.zellen)
  schiff1.setzen(2,4)
  var isSet = feldNeu.zellen(0)(2).getGesetzt
  isSet must be_==(false)
}
/*
"Umfeldkontrolle Spalte = erste Spalte & Reihe = erste Reihe Schiff geht nach rechts groesse =4 umfeldrechtsschongesetzt " in{
  var feldNeu = new Feld(5)
  var startZelle1 = feldNeu.zellen(0)(0)
  var startZelle2 = feldNeu.zellen(0)(4)
  var schiff2 = new Schiff(4, startZelle2, feldNeu.zellen)
  var schiff1 = new Schiff(4, startZelle1, feldNeu.zellen)
  schiff2.setzen(1,4)
  schiff1.setzen(2,4)
  var isSet = feldNeu.zellen(0)(0).getGesetzt
  isSet must be_==(false)
}*/



"Umfeldkontrolle Spalte = letzte Spalte & Reihe = erste Reihe Schiff geht nach unten groesse=4 stösst links nicht an umfeldlinksschongesetzt" in {
  var feldNeu = new Feld(5)
  feldNeu.reset
  var startZelleEigentlicherSchiff = feldNeu.zellen(0)(4)
  var startZelleHilfsschiff = feldNeu.zellen(0)(3)
  var EigentlicherSchiff= new Schiff(4,startZelleEigentlicherSchiff, feldNeu.zellen )
  var Hilfsschiff =new Schiff(4, startZelleHilfsschiff, feldNeu.zellen )
  Hilfsschiff.setzen(1,4)
  var isSet=EigentlicherSchiff.setzen(1,4)
  //var isSet = feldNeu.zellen(1)(4).getGesetzt
  isSet must be_==(false)
  
}

"Umfeldkontrolle Spalte = letzte Spalte & Reihe = erste Reihe Schiff geht nach unten groesse=4 stösst links nicht an umfeldluntenschongesetzt" in {
  var feldNeu = new Feld(5)
  feldNeu.reset
  var startZelleEigentlicherSchiff = feldNeu.zellen(0)(4)
  var startZelleHilfsschiff = feldNeu.zellen(4)(4)
  var EigentlicherSchiff= new Schiff(4,startZelleEigentlicherSchiff, feldNeu.zellen )
  var Hilfsschiff =new Schiff(2, startZelleHilfsschiff, feldNeu.zellen )
  Hilfsschiff.setzen(3,4)
  EigentlicherSchiff.setzen(1,4)
  var isSet = feldNeu.zellen(1)(4).getGesetzt
  isSet must be_==(false)
  
}
"Umfeldkontrolle Spalte = letzte Spalte & Reihe = erste Reihe Schiff geht nach unten groesse=5 stösst links an umfeldluntenschongesetzt" in {
  var feldNeu = new Feld(5)
  feldNeu.reset
  var startZelleEigentlicherSchiff = feldNeu.zellen(0)(4)
  var startZelleHilfsschiff = feldNeu.zellen(4)(4)
  var EigentlicherSchiff= new Schiff(5,startZelleEigentlicherSchiff, feldNeu.zellen )
  var Hilfsschiff =new Schiff(2, startZelleHilfsschiff, feldNeu.zellen )
  Hilfsschiff.setzen(3,4)
  EigentlicherSchiff.setzen(1,4)
  var isSet = feldNeu.zellen(1)(4).getGesetzt
  isSet must be_==(false)
  
}

"Umfeldkontrolle Spalte = letzte Spalte & Reihe = erste Reihe Schiff geht nach links groesse = 4 umfelduntenschongesetzt" in{
  var feldNeu = new Feld(5)
  feldNeu.reset
  var startZelleEigentlicherSchiff = feldNeu.zellen(0)(4)
  var startZelleHilfsschiff = feldNeu.zellen(1)(4)
  var EigentlicherSchiff= new Schiff(4,startZelleEigentlicherSchiff, feldNeu.zellen )
  var Hilfsschiff =new Schiff(4, startZelleHilfsschiff, feldNeu.zellen )
  Hilfsschiff.setzen(3,4)
  EigentlicherSchiff.setzen(3,4)
  var isSet = feldNeu.zellen(0)(3).getGesetzt
  isSet must be_==(false)
}
"Umfeldkontrolle Spalte = letzte Spalte & Reihe = erste Reihe Schiff geht nach links groesse = 4 umfeldlinksschongesetzt" in{
  var feldNeu = new Feld(5)
  feldNeu.reset
  var startZelleEigentlicherSchiff = feldNeu.zellen(0)(4)
  var startZelleHilfsschiff = feldNeu.zellen(0)(0)
  var EigentlicherSchiff= new Schiff(4,startZelleEigentlicherSchiff, feldNeu.zellen )
  var Hilfsschiff =new Schiff(4, startZelleHilfsschiff, feldNeu.zellen )
  Hilfsschiff.setzen(1,4)
  EigentlicherSchiff.setzen(3,4)
  var isSet = feldNeu.zellen(0)(3).getGesetzt
  isSet must be_==(false)
}

"Umfeldkontrolle Spalte != erste Spalte & Spalte != letzte Spalte & Reihe = erste Reihe Schiff geht nach unten stößt unten an umfeldlinksschongesetzt" in {
  var feldNeu = new Feld(5)
  feldNeu.reset
  var startZelleEigentlicherSchiff = feldNeu.zellen(0)(3)
  var startZelleHilfsschiff = feldNeu.zellen(0)(2)
  var EigentlicherSchiff= new Schiff(5,startZelleEigentlicherSchiff, feldNeu.zellen )
  var Hilfsschiff =new Schiff(4, startZelleHilfsschiff, feldNeu.zellen )
  Hilfsschiff.setzen(1,4)
  EigentlicherSchiff.setzen(1,4)
  var isSet = feldNeu.zellen(0)(3).getGesetzt
  isSet must be_==(false)
}

"Umfeldkontrolle Spalte != erste Spalte & Spalte != letzte Spalte & Reihe = erste Reihe Schiff geht nach unten stößt unten an umfeldrechtschongesetzt" in {
  var feldNeu = new Feld(5)
  feldNeu.reset
  var startZelleEigentlicherSchiff = feldNeu.zellen(0)(3)
  var startZelleHilfsschiff = feldNeu.zellen(0)(4)
  var EigentlicherSchiff= new Schiff(5,startZelleEigentlicherSchiff, feldNeu.zellen )
  var Hilfsschiff =new Schiff(4, startZelleHilfsschiff, feldNeu.zellen )
  Hilfsschiff.setzen(1,4)
  EigentlicherSchiff.setzen(1,4)
  var isSet = feldNeu.zellen(0)(3).getGesetzt
  isSet must be_==(false)
}

"Umfeldkontrolle Spalte != erste Spalte & Spalte != letzte Spalte & Reihe = erste Reihe Schiff geht nach rechts stößt  rechts an umfeld untengesetzt" in {
  var feldNeu = new Feld(5)
  feldNeu.reset
  var startZelleEigentlicherSchiff = feldNeu.zellen(0)(3)
  var startZelleHilfsschiff = feldNeu.zellen(1)(3)
  var EigentlicherSchiff= new Schiff(2,startZelleEigentlicherSchiff, feldNeu.zellen )
  var Hilfsschiff =new Schiff(2, startZelleHilfsschiff, feldNeu.zellen )
  Hilfsschiff.setzen(2,4)
  EigentlicherSchiff.setzen(2,4)
  var isSet = feldNeu.zellen(0)(3).getGesetzt
  isSet must be_==(false)
}

"Umfeldkontrolle Spalte != erste Spalte & Spalte != letzte Spalte & Reihe = erste Reihe Schiff geht nach rechts stößt  rechts an umfeld  links gesetzt" in {
  var feldNeu = new Feld(5)
  feldNeu.reset
  var startZelleEigentlicherSchiff = feldNeu.zellen(0)(3)
  var startZelleHilfsschiff = feldNeu.zellen(0)(2)
  var EigentlicherSchiff= new Schiff(2,startZelleEigentlicherSchiff, feldNeu.zellen )
  var Hilfsschiff =new Schiff(2, startZelleHilfsschiff, feldNeu.zellen )
  Hilfsschiff.setzen(1,4)
  EigentlicherSchiff.setzen(2,4)
  var isSet = feldNeu.zellen(0)(3).getGesetzt
  isSet must be_==(false)
}
"Umfeldkontrolle Spalte != erste Spalte & Spalte != letzte Spalte & Reihe = erste Reihe Schiff geht nach Rechts stößt nicht rechts an umfeld unten gesetzt " in {
  var feldNeu = new Feld(5)
  feldNeu.reset
  var startZelleEigentlicherSchiff = feldNeu.zellen(0)(1)
  var startZelleHilfsschiff = feldNeu.zellen(1)(1)
  var EigentlicherSchiff= new Schiff(2,startZelleEigentlicherSchiff, feldNeu.zellen )
  var Hilfsschiff =new Schiff(2, startZelleHilfsschiff, feldNeu.zellen )
  Hilfsschiff.setzen(2,4)
  EigentlicherSchiff.setzen(2,4)
  var isSet = feldNeu.zellen(0)(1).getGesetzt
  isSet must be_==(false)
}
"Umfeldkontrolle Spalte != erste Spalte & Spalte != letzte Spalte & Reihe = erste Reihe Schiff geht nach Rechts stößt nicht rechts an umfeld links gesetzt " in {
  var feldNeu = new Feld(5)
  feldNeu.reset
  var startZelleEigentlicherSchiff = feldNeu.zellen(0)(1)
  var startZelleHilfsschiff = feldNeu.zellen(0)(0)
  var EigentlicherSchiff= new Schiff(2,startZelleEigentlicherSchiff, feldNeu.zellen )
  var Hilfsschiff =new Schiff(2, startZelleHilfsschiff, feldNeu.zellen )
  Hilfsschiff.setzen(1,4)
  EigentlicherSchiff.setzen(2,4)
  var isSet = feldNeu.zellen(0)(1).getGesetzt
  isSet must be_==(false)
}
"Umfeldkontrolle Spalte != erste Spalte & Spalte != letzte Spalte & Reihe = erste Reihe Schiff geht nach Rechts stößt nicht rechts an umfeld rechts gesetzt " in {
  var feldNeu = new Feld(5)
  feldNeu.reset
  var startZelleEigentlicherSchiff = feldNeu.zellen(0)(1)
  var startZelleHilfsschiff = feldNeu.zellen(0)(2)
  var EigentlicherSchiff= new Schiff(2,startZelleEigentlicherSchiff, feldNeu.zellen )
  var Hilfsschiff =new Schiff(2, startZelleHilfsschiff, feldNeu.zellen )
  Hilfsschiff.setzen(1,4)
  EigentlicherSchiff.setzen(2,4)
  var isSet = feldNeu.zellen(0)(1).getGesetzt
  isSet must be_==(false)
}



"Umfeldkontrolle Spalte != erste Spalte & Spalte != letzte Spalte & Reihe = erste Reihe Schiff geht nach links stößt nicht links an umfelduntengesetzt " in {
  var feldNeu = new Feld(5)
  feldNeu.reset
  var startZelleEigentlicherSchiff = feldNeu.zellen(0)(3)
  var startZelleHilfsschiff = feldNeu.zellen(1)(3)
  var EigentlicherSchiff= new Schiff(2,startZelleEigentlicherSchiff, feldNeu.zellen )
  var Hilfsschiff =new Schiff(2, startZelleHilfsschiff, feldNeu.zellen )
  Hilfsschiff.setzen(3,4)
  EigentlicherSchiff.setzen(3,4)
  var isSet = feldNeu.zellen(0)(3).getGesetzt
  isSet must be_==(false)
}
"Umfeldkontrolle Spalte != erste Spalte & Spalte != letzte Spalte & Reihe = erste Reihe Schiff geht nach links stößt nicht links an umfelduntennicht gesetzt " in {
  var feldNeu = new Feld(5)
  feldNeu.reset
  var startZelleEigentlicherSchiff = feldNeu.zellen(0)(2)
  var EigentlicherSchiff= new Schiff(2,startZelleEigentlicherSchiff, feldNeu.zellen )
  EigentlicherSchiff.setzen(3,4)
  var isSet = feldNeu.zellen(0)(2).getGesetzt
  isSet must be_==(true)
}
"Umfeldkontrolle Spalte != erste Spalte & Spalte != letzte Spalte & Reihe = erste Reihe Schiff geht nach links stößt nicht links an umfeld links gesetzt " in {
  var feldNeu = new Feld(5)
  feldNeu.reset
  var startZelleHilfsschiff = feldNeu.zellen(0)(1)
  var Hilfsschiff =new Schiff(2, startZelleHilfsschiff, feldNeu.zellen )
  Hilfsschiff.setzen(1,4)
  var startZelleEigentlicherSchiff = feldNeu.zellen(0)(2)
  var EigentlicherSchiff= new Schiff(2,startZelleEigentlicherSchiff, feldNeu.zellen )
  EigentlicherSchiff.setzen(3,4)
  var isSet = feldNeu.zellen(0)(2).getGesetzt
  isSet must be_==(false)
}
"Umfeldkontrolle Spalte != erste Spalte & Spalte != letzte Spalte & Reihe = erste Reihe Schiff geht nach links stößt nicht links an umfeld rechts gesetzt " in {
  var feldNeu = new Feld(5)
  feldNeu.reset
  var startZelleHilfsschiff = feldNeu.zellen(0)(3)
  var Hilfsschiff =new Schiff(2, startZelleHilfsschiff, feldNeu.zellen )
  Hilfsschiff.setzen(1,4)
  var startZelleEigentlicherSchiff = feldNeu.zellen(0)(2)
  var EigentlicherSchiff= new Schiff(2,startZelleEigentlicherSchiff, feldNeu.zellen )
  EigentlicherSchiff.setzen(3,4)
  var isSet = feldNeu.zellen(0)(2).getGesetzt
  isSet must be_==(false)
}
"Umfeldkontrolle Spalte != erste Spalte & Spalte != letzte Spalte & Reihe = erste Reihe Schiff geht nach links stößt links an umfelduntengesetzt" in {
  var feldNeu = new Feld(5)
  feldNeu.reset
  var startZelleHilfsschiff = feldNeu.zellen(1)(2)
  var Hilfsschiff =new Schiff(3, startZelleHilfsschiff, feldNeu.zellen )
  Hilfsschiff.setzen(3,4)
  var startZelleEigentlicherSchiff = feldNeu.zellen(0)(2)
  var EigentlicherSchiff= new Schiff(3,startZelleEigentlicherSchiff, feldNeu.zellen )
  EigentlicherSchiff.setzen(3,4)
  var isSet = feldNeu.zellen(0)(2).getGesetzt
  isSet must be_==(false)
}
"Umfeldkontrolle Spalte != erste Spalte & Spalte != letzte Spalte & Reihe = erste Reihe Schiff geht nach links stößt links an umfeldlinksgesetzt" in {
  var feldNeu = new Feld(5)
  feldNeu.reset
  var startZelleHilfsschiff = feldNeu.zellen(0)(1)
  var Hilfsschiff =new Schiff(1, startZelleHilfsschiff, feldNeu.zellen )
  Hilfsschiff.setzen(3,4)
  var startZelleEigentlicherSchiff = feldNeu.zellen(0)(2)
  var EigentlicherSchiff= new Schiff(3,startZelleEigentlicherSchiff, feldNeu.zellen )
  EigentlicherSchiff.setzen(3,4)
  var isSet = feldNeu.zellen(0)(2).getGesetzt
  isSet must be_==(false)
}
/*Es soll überprüfen if ((zellen(startZelle.getReihe)(startZelle.getSpalte - 1).getGesetzt) == true) {
                    return false
                  } else {
                    return okay
                  } Zeile 463
                  warum tut er das nicht????*/
"Umfeldkontrolle Spalte != erste Spalte & Spalte != letzte Spalte & Reihe = erste Reihe Schiff geht nach links stößt links an umfeldlinksgesetzt2" in {
  var feldNeu = new Feld(5)
  feldNeu.reset
  var startZelleHilfsschiff = feldNeu.zellen(0)(1)
  var Hilfsschiff =new Schiff(1, startZelleHilfsschiff, feldNeu.zellen )
  Hilfsschiff.setzen(3,4)
  var startZelleEigentlicherSchiff = feldNeu.zellen(0)(2)
  var EigentlicherSchiff= new Schiff(3,startZelleEigentlicherSchiff, feldNeu.zellen )
  var isSet = EigentlicherSchiff.setzen(3,4)
  isSet must be_==(false)
}
"Spalte = erste Spalte & Reihe = letzte Reihe Schiff geht nach oben stosst oben an umfeldrechtsgesetzt" in{
  var feldNeu = new Feld(2)
  feldNeu.reset
  var startZelleHilfsschiff = feldNeu.zellen(1)(1)
  var Hilfsschiff =new Schiff(2, startZelleHilfsschiff, feldNeu.zellen )
  Hilfsschiff.setzen(0,1)
  var startZelleEigentlicherSchiff = feldNeu.zellen(1)(0)
  var EigentlicherSchiff= new Schiff(2,startZelleEigentlicherSchiff, feldNeu.zellen )
  var isSet = EigentlicherSchiff.setzen(0,1)
  isSet must be_==(false)
  
}
"Spalte = erste Spalte & Reihe = letzte Reihe Schiff geht nach oben stosst oben an umfeldnichtgesetzt" in{
  var feldNeu = new Feld(2)
  feldNeu.reset
  
  var startZelleEigentlicherSchiff = feldNeu.zellen(1)(0)
  var EigentlicherSchiff= new Schiff(2,startZelleEigentlicherSchiff, feldNeu.zellen )
  var isSet = EigentlicherSchiff.setzen(0,1)
  isSet must be_==(true)
  
}
/* warum funktioniert es nicht?? Zeile 516
"Spalte = erste Spalte & Reihe = letzte Reihe Schiff geht nach oben stosst oben nicht an umfeld oben gesetzt" in{
  var feldNeu = new Feld(5)
  feldNeu.reset
  var startZelleHilfsschiff = feldNeu.zellen(1)(0)
  var Hilfsschiff =new Schiff(2, startZelleHilfsschiff, feldNeu.zellen )
  Hilfsschiff.setzen(2,4)
  var startZelleEigentlicherSchiff = feldNeu.zellen(4)(0)
  var EigentlicherSchiff= new Schiff(3,startZelleEigentlicherSchiff, feldNeu.zellen )
  var isSet = EigentlicherSchiff.setzen(0,4)
  isSet must be_==(false)
  
}
*/

"Spalte = erste Spalte & Reihe = letzte Reihe Schiff geht nach rechts stosstrechts an umfeld oben schon gesetzt" in{
  var feldNeu = new Feld(2)
  feldNeu.reset
  var startZelleHilfsschiff = feldNeu.zellen(0)(0)
  var Hilfsschiff =new Schiff(2, startZelleHilfsschiff, feldNeu.zellen )
  Hilfsschiff.setzen(2,1)
  var startZelleEigentlicherSchiff = feldNeu.zellen(1)(0)
  var EigentlicherSchiff= new Schiff(2,startZelleEigentlicherSchiff, feldNeu.zellen )
  var isSet = EigentlicherSchiff.setzen(2,1)
  isSet must be_==(false)
}
"Spalte = erste Spalte & Reihe = letzte Reihe Schiff geht nach rechts stosstrechts an umfeld oben nicht gesetzt" in{
  var feldNeu = new Feld(2)
  feldNeu.reset
  var startZelleEigentlicherSchiff = feldNeu.zellen(1)(0)
  var EigentlicherSchiff= new Schiff(2,startZelleEigentlicherSchiff, feldNeu.zellen )
  var isSet = EigentlicherSchiff.setzen(2,1)
  isSet must be_==(true)
}
/*es sollte eigentlich Zeile 535 überprüfen*/
"Spalte = erste Spalte & Reihe = letzte Reihe Schiff geht nach rechts stosstrechts an umfeld rechts gesetzt" in{
  var feldNeu = new Feld(2)
  feldNeu.reset
  var startZelleHilfsschiff = feldNeu.zellen(1)(1)
  var Hilfsschiff =new Schiff(1, startZelleHilfsschiff, feldNeu.zellen )
  Hilfsschiff.setzen(2,1)
  var startZelleEigentlicherSchiff = feldNeu.zellen(1)(0)
  var EigentlicherSchiff= new Schiff(2,startZelleEigentlicherSchiff, feldNeu.zellen )
  var isSet = EigentlicherSchiff.setzen(2,1)
  isSet must be_==(false)
}
/*das soll Zeile 542 überprüfen*/
"Spalte = erste Spalte & Reihe = letzte Reihe Schiff geht nach rechts stosstrechts nicht an umfeld oben schon gesetzt" in{
  var feldNeu = new Feld(5)
  feldNeu.reset
  var startZelleHilfsschiff = feldNeu.zellen(3)(0)
  var Hilfsschiff =new Schiff(2, startZelleHilfsschiff, feldNeu.zellen )
  Hilfsschiff.setzen(2,4)
  var startZelleEigentlicherSchiff = feldNeu.zellen(4)(0)
  var EigentlicherSchiff= new Schiff(3,startZelleEigentlicherSchiff, feldNeu.zellen )
  EigentlicherSchiff.setzen(2,4)
  var isSet= feldNeu.zellen(4)(2).getGesetzt
  isSet must be_==(false)
}
"Spalte = erste Spalte & Reihe = letzte Reihe Schiff geht nach rechts stosstrechts nicht an umfeld nicht gesetzt" in{
  var feldNeu = new Feld(5)
  feldNeu.reset
  var startZelleEigentlicherSchiff = feldNeu.zellen(4)(0)
  var EigentlicherSchiff= new Schiff(3,startZelleEigentlicherSchiff, feldNeu.zellen )
  EigentlicherSchiff.setzen(2,4)
  var isSet= feldNeu.zellen(4)(2).getGesetzt
  isSet must be_==(true)
}
/*warum funktioniert es nicht?????? Zeile 550*/
/*"Spalte = erste Spalte & Reihe = letzte Reihe Schiff geht nach rechts stosstrechts nicht an umfeld rechts gesetzt" in{
  var feldNeu = new Feld(5)
  feldNeu.reset
  var startZelleHilfsschiff = feldNeu.zellen(4)(3)
  var Hilfsschiff =new Schiff(1, startZelleHilfsschiff, feldNeu.zellen )
  Hilfsschiff.setzen(0,4)
  var startZelleEigentlicherSchiff = feldNeu.zellen(4)(0)
  var EigentlicherSchiff= new Schiff(3,startZelleEigentlicherSchiff, feldNeu.zellen )
  EigentlicherSchiff.setzen(2,4)
  var isSet= feldNeu.zellen(4)(1).getGesetzt
  isSet must be_==(false)
}*/
"Spalte = letzte Spalte & Reihe = letzte Reihe Schiff geht nach oben stösst nicht oben an umfeld links schon gesetzt" in {
  var feldNeu = new Feld(5)
  feldNeu.reset
  var startZelleHilfsschiff = feldNeu.zellen(4)(3)
  var Hilfsschiff =new Schiff(1, startZelleHilfsschiff, feldNeu.zellen )
  Hilfsschiff.setzen(0,4)
  var startZelleEigentlicherSchiff = feldNeu.zellen(4)(4)
  var EigentlicherSchiff= new Schiff(4,startZelleEigentlicherSchiff, feldNeu.zellen )
  EigentlicherSchiff.setzen(0,4)
  var isSet= feldNeu.zellen(4)(4).getGesetzt
  isSet must be_==(false)
}
/*
"Spalte = letzte Spalte & Reihe = letzte Reihe Schiff geht nach oben stösst  oben an umfeld links schon gesetzt" in {
  var feldNeu = new Feld(2)
  feldNeu.reset
  var startZelleHilfsschiff = feldNeu.zellen(1)(0)
  var Hilfsschiff =new Schiff(2, startZelleHilfsschiff, feldNeu.zellen )
  Hilfsschiff.setzen(0,1)
  var startZelleEigentlicherSchiff = feldNeu.zellen(1)(1)
  var EigentlicherSchiff= new Schiff(2,startZelleEigentlicherSchiff, feldNeu.zellen )
  EigentlicherSchiff.setzen(0,1)
  var isSet= feldNeu.zellen(1)(1).getGesetzt
  isSet must be_==(false)
}*/
"Spalte = letzte Spalte & Reihe = letzte Reihe Schiff geht nach links umfeld oben schon gesetzt" in {
  var feldNeu = new Feld(2)
  feldNeu.reset
  var startZelleHilfsschiff = feldNeu.zellen(0)(1)
  var Hilfsschiff =new Schiff(2, startZelleHilfsschiff, feldNeu.zellen )
  Hilfsschiff.setzen(3,1)
  var startZelleEigentlicherSchiff = feldNeu.zellen(1)(1)
  var EigentlicherSchiff= new Schiff(4,startZelleEigentlicherSchiff, feldNeu.zellen )
  EigentlicherSchiff.setzen(3,1)
  var isSet= feldNeu.zellen(1)(1).getGesetzt
  isSet must be_==(false)
}
"Spalte != erste Spalte & Spalte != letzte Spalte & Reihe = letzte Reihe Schiff geht nach oben" in {
  
}
"Spalte != erste Spalte & Spalte != letzte Spalte & Reihe = letzte Reihe Schiff geht nach rechts stösst rechts an" in {
  var feldNeu = new Feld(5)
  feldNeu.reset
  var startZelleHilfsschiff = feldNeu.zellen(3)(4)
  var Hilfsschiff =new Schiff(1, startZelleHilfsschiff, feldNeu.zellen )
  Hilfsschiff.setzen(0,1)
  var startZelleEigentlicherSchiff = feldNeu.zellen(4)(4)
  var EigentlicherSchiff= new Schiff(2,startZelleEigentlicherSchiff, feldNeu.zellen )
  EigentlicherSchiff.setzen(2,1)
  var isSet= feldNeu.zellen(4)(4).getGesetzt
  isSet must be_==(false)
}
"Spalte != erste Spalte & Spalte != letzte Spalte & Reihe = letzte Reihe Schiff geht nach rechts stösst nicht rechts an" in {
  
}
"Spalte != erste Spalte & Spalte != letzte Spalte & Reihe = letzte Reihe Schiff geht nach links stösst links an" in {
  
}
"Spalte != erste Spalte & Spalte != letzte Spalte & Reihe = letzte Reihe Schiff geht nach links stösst nicht links an" in {
  
}
"Spalte = erste Spalte & Reihe != erste Reihe & Reihe != letzte Reihe geht nach oben stösst oben nicht an" in{
  }

"Spalte = erste Spalte & Reihe != erste Reihe & Reihe != letzte Reihe geht nach oben stösst oben an" in{
  }
"Spalte = erste Spalte & Reihe != erste Reihe & Reihe != letzte Reihe geht nach unten stösst unten nicht an" in{
  }

"Spalte = erste Spalte & Reihe != erste Reihe & Reihe != letzte Reihe geht nach unten stösst unten an" in{
  }
"Spalte = erste Spalte & Reihe != erste Reihe & Reihe != letzte Reihe geht nach rechts" in{
  }
"Spalte = letzte Spalte & Reihe != erste Reihe & Reihe != letzte Reihe Schiff geht nach oben stösst oben an" in{
}
"Spalte = letzte Spalte & Reihe != erste Reihe & Reihe != letzte Reihe Schiff geht nach oben stösst obennicht an" in{
  
}
"Spalte = letzte Spalte & Reihe != erste Reihe & Reihe != letzte Reihe Schiff geht nach unten stösst unten an" in{
}
"Spalte = letzte Spalte & Reihe != erste Reihe & Reihe != letzte Reihe Schiff geht nach unten  stösst unten nicht an" in{
  
}
"Spalte = letzte Spalte & Reihe != erste Reihe & Reihe != letzte Reihe Schiff geht nach links" in{
  
}
"Spalte != erste Spalte & Spalte != letzte Spalte & Reihe != erste Reihe & Reihe != letzte Reihe Schiff geht nach oben stösst oben an" in {
  
}
"Spalte != erste Spalte & Spalte != letzte Spalte & Reihe != erste Reihe & Reihe != letzte Reihe Schiff geht nach oben stösst oben nicht an" in {
  
}
"Spalte != erste Spalte & Spalte != letzte Spalte & Reihe != erste Reihe & Reihe != letzte Reihe Schiff geht nach unten stösst unten an" in {
  
}
"Spalte != erste Spalte & Spalte != letzte Spalte & Reihe != erste Reihe & Reihe != letzte Reihe Schiff geht nach unten stösst unten nicht an" in {
  
}
"Spalte != erste Spalte & Spalte != letzte Spalte & Reihe != erste Reihe & Reihe != letzte Reihe Schiff geht nach rechts stösst rechts an" in {
  
}
"Spalte != erste Spalte & Spalte != letzte Spalte & Reihe != erste Reihe & Reihe != letzte Reihe Schiff geht nach rechts stösst rechts nicht an" in {
  
}
"Spalte != erste Spalte & Spalte != letzte Spalte & Reihe != erste Reihe & Reihe != letzte Reihe Schiff geht nach links stösst links an" in {
  
}
"Spalte != erste Spalte & Spalte != letzte Spalte & Reihe != erste Reihe & Reihe != letzte Reihe Schiff geht nach links stösst links nicht an" in {
  
}

    "if the ship is not setable" in{}
}
}