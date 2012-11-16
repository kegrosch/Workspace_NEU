package schiffe

class Print {
	var list = List()
    def ausgeben(cellss: List[Cell], anzahl: Int){
	  println(cellss.length)
	for(k <- 0 to ((anzahl-1)/2)){
          print("  -----")
        }
	  println("")
	  println("|")
	  println("|")
	  
      for(j <- 0 to anzahl-1){
        
        
        var temp = cellss(j)
        print(temp.stat)
        
      }
   }
}