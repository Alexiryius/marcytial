package marcytial;

import java.util.Stack;

public  class Tools {
		
	private static Stack<Serie> undo = new Stack<Serie>();
	private static Stack<Serie> redo = new Stack<Serie>();
	
// fonction qui est utiliser lors de la selection du fichier
// ou lors de la selection d'une courbe
	public static void  transmOGraphe()
	{
		
	}

	public static  boolean mayIUndo(){
		return undo.isEmpty();
	}
// fonction qui vide la pile undo et remplie la pile redo 
//renvoie null si la pile est vide 	
	public static void  unDo()
	{
		if(undo.empty())return;
		 redo.push(Serie.getCurrent());
		 Serie.setCurrent((Serie)undo.peek());	
		
	}
	
// fonction qui vide la file redo et remplie la file undo 
// renvoi null si la pile est vide
	
	public static void reDo()
	{
		if(redo.empty())return;
		undo.push(Serie.getCurrent());
		Serie.setCurrent( (Serie)redo.peek());
		
	}
	
// fonction qui empile su la pile undo a chaque action	
	public static void toDo()
	{
	 undo.push(Serie.getCurrent());	
	 redo.clear();
	}
   
	public static SerieChronologiqueTab grapheToTab(SerieChronologiqueGraphe laSerie)
	{
		SerieChronologiqueTab nouvelleSerie = new SerieChronologiqueTab(laSerie.getNom(),laSerie.getDate(),laSerie.getValeur());
		
		return nouvelleSerie;
	}
	
	public static SerieChronologiqueGraphe tabToGraphe(SerieChronologiqueTab laSerie)
	{
		SerieChronologiqueGraphe nouvelleSerie = new SerieChronologiqueGraphe(laSerie.getNom(),laSerie.getDate(),laSerie.getValeur());
		return nouvelleSerie;
	}
}
