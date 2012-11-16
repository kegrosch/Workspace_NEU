package schiffe_versenken;



  class Print(){
   var list = List()
    def ausgeben(cells: Seq[Cell]){
      for(i <- 0 to 4){
        var temp = cells(i)
        println(temp.stat)
        
      }
   }
  }
