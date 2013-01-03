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
      canSet must be_==(true)
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
"Umfeldkontrolle Spalte = erste Spalte & Reihe = erste Reihe Schiff geht nach unten groesse =4 umfeldrechtsschongesetzt " in{
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
"Umfeldkontrolle Spalte != erste Spalte & Spalte != letzte Spalte & Reihe = erste Reihe Schiff geht nach unten groesse =4 umfeldlinksschongesetzt " in{
  var feldNeu = new Feld(5)
  var startZelle1 = feldNeu.zellen(0)(0)
  var startZelle2 = feldNeu.zellen(0)(1)
  var schiff1 = new Schiff(4, startZelle1, feldNeu.zellen)
  var schiff2 = new Schiff(4, startZelle2, feldNeu.zellen)
  schiff1.setzen(1,4)
  schiff2.setzen(1,4)
  var isSet = feldNeu.zellen(0)(1).getGesetzt
  isSet must be_==(false)
}
"Umfeldkontrolle Schiff geht nach unten erste Reihe groesse =4 umfeldlrechtschongesetzt " in{
  var feldNeu = new Feld(5)
  var startZelle1 = feldNeu.zellen(0)(3)
  var startZelle2 = feldNeu.zellen(0)(4)
  var schiff1 = new Schiff(4, startZelle1, feldNeu.zellen)
  var schiff2 = new Schiff(4, startZelle2, feldNeu.zellen)
  schiff1.setzen(1,4)
  schiff2.setzen(1,4)
  var isSet = feldNeu.zellen(0)(4).getGesetzt
  isSet must be_==(false)
}

"Umfeldkontrolle Spalte = erste Spalte & Reihe = erste Reihe Schiff geht nach unten groesse =4 umfelduntenschongesetzt " in{
  var feldNeu = new Feld(5)
  feldNeu.reset
  var startZelle2 = feldNeu.zellen(4)(0)
  var startZelle1 = feldNeu.zellen(0)(0)
  var schiff2 = new Schiff(2, startZelle2, feldNeu.zellen)
  schiff2.setzen(2,4)
  var schiff1 = new Schiff(4, startZelle1, feldNeu.zellen)
  
  schiff1.setzen(1,4)
  var isSet = feldNeu.zellen(2)(0).getGesetzt
  isSet must be_==(false)
}

"Umfeldkontrolle Spalte = erste Spalte & Reihe = erste Reihe Schiff geht nach rechts groesse =4 umfelduntenschongesetzt " in{
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
"Umfeldkontrolle Spalte != erste Spalte & Spalte != letzte Spalte & Reihe = erste Reihe Schiff geht nach rechts  groesse =4 umfeldlinksschongesetzt " in{
  var feldNeu = new Feld(5)
  var startZelle1 = feldNeu.zellen(0)(0)
  var startZelle2 = feldNeu.zellen(0)(1)
  var schiff1 = new Schiff(2, startZelle1, feldNeu.zellen)
  var schiff2 = new Schiff(4, startZelle2, feldNeu.zellen)
  schiff1.setzen(1,4)
  schiff2.setzen(2,4)
  var isSet = feldNeu.zellen(0)(1).getGesetzt
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
"Umfeldkontrolle Spalte = letzte Spalte & Reihe = erste Reihe Schiff geht nach unten" in {
  
}
"Umfeldkontrolle Spalte = letzte Spalte & Reihe = erste Reihe Schiff geht nach links" in{
  
}
"Umfeldkontrolle Spalte != erste Spalte & Spalte != letzte Spalte & Reihe = erste Reihe Schiff geht nach rechts stößt  rechts an" in {
  
}
"Umfeldkontrolle Spalte != erste Spalte & Spalte != letzte Spalte & Reihe = erste Reihe Schiff geht nach Rechts stößt nicht rechts an" in {
  
}
"Umfeldkontrolle Spalte != erste Spalte & Spalte != letzte Spalte & Reihe = erste Reihe Schiff geht nach links stößt nicht links an" in {
  
}
"Umfeldkontrolle Spalte != erste Spalte & Spalte != letzte Spalte & Reihe = erste Reihe Schiff geht nach links stößt links an" in {
  
}
"Spalte = erste Spalte & Reihe = letzte Reihe Schiff geht nach oben " in{
  
}
"Spalte = erste Spalte & Reihe = letzte Reihe Schiff geht nach rechts " in{
  
}
"Spalte = letzte Spalte & Reihe = letzte Reihe Schiff geht nach oben" in {
  
}
"Spalte = letzte Spalte & Reihe = letzte Reihe Schiff geht nach links" in {
  
}
"Spalte != erste Spalte & Spalte != letzte Spalte & Reihe = letzte Reihe Schiff geht nach oben" in {
  
}
"Spalte != erste Spalte & Spalte != letzte Spalte & Reihe = letzte Reihe Schiff geht nach rechts stösst rechts an" in {
  
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