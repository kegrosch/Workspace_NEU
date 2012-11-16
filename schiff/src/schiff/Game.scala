package schiff
object Game extends App{


  
  var cells = List(Cell)()
	for(i <- 0 to 4){
	  var tempcell = new Cell()
	   cells:+ tempcell
	}
	var print = new Print()
	
	print.ausgeben(cells)
	
	
	

}