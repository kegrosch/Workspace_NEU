package schiffe

object Start extends App{
  println("Mit wievielen Felder soll gespielt werden?(2; 3; 4; 5; 10)")
  var anzahl = readInt()
  
  
  var cells = List[Cell]()
	for(i <- 0 to anzahl-1){
	  var tempcell = new Cell()
	   cells ::= tempcell
	}
	var print = new Print()
	
	print.ausgeben(cells, anzahl)
	

}