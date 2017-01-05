package marcytial;

import java.util.Stack;

public  class Tools {

	
// fonction qui est utiliser lors de la selection du fichier
// ou lors de la selection d'une courbe
	public static void  transmerOGraphe()
	{
		
	}

// fonction qui vide la pile undo et remplie la pile redo 
//renvoie null si la pile est vide 	
	public static Serie  unDo(Stack<Serie> undo, Stack<Serie> redo, Serie serieActuelle )
	{
		if(undo.empty())return null;
		
		 redo.push(serieActuelle);	
		 return (Serie)undo.peek();	
		
	}
	
// fonction qui vide la file redo et remplie la file undo 
// renvoi null si la pile est vide
	public static Serie reDo(Stack<Serie> undo, Stack<Serie> redo, Serie serieActuelle)
	{
		if(redo.empty())return null;
		undo.push(serieActuelle);
		return (Serie)redo.peek();
		
	}
	
// fonction qui empile su la pile undo a chaque action	
	public static void toDo(Stack<Serie> undo ,Serie  serieActurelle)
	{
	 undo.push(serieActurelle);	
	}
   
	public static SerieChronologiqueGraphe grapheToTab(SerieChronologiqueGraphe laSerie)
	{
	
		 return SerieChronologiqueTab nouvelleSerie = new SerieChronologiqueTab(laserie.getX,laserie.getY,laSerie.getnom);
	}
	
	public static SerieChronologiqueGraphe tabToGraphe(SerieChronologiqueTab laSerie)
	{
		return SerieChronologiqueGraphe nouvelleSerie = new SerieChonologiqueGraphe(laserie.getX,laserie.getY,laSerie.getnom);
		
	}
}
