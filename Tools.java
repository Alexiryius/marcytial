package marcytial;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Stack;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public  class Tools {
		
	private static Stack<Serie> undo = new Stack<Serie>();
	private static Stack<Serie> redo = new Stack<Serie>();
	
// fonction qui est utiliser lors de la selection du fichier
// ou lors de la selection d'une courbe
	public static void  transmOGraphe()
	{
		
	}

	public static  boolean mayIUndo(){
		return undo.empty();
	}
	
	public static  boolean mayIRedo(){
		return redo.empty();
	}
// fonction qui vide la pile undo et remplie la pile redo 
//renvoie null si la pile est vide 	
	public static void  unDo()
	{
		
		
		 redo.push(Serie.getCurrent());
		 Serie.setCurrent(undo.pop());	
		
	
		
	}
	
// fonction qui vide la file redo et remplie la file undo 
// renvoi null si la pile est vide
	
	public static void reDo()
	{
		
		if(redo.empty())return;
		undo.push(Serie.getCurrent());
		Serie.setCurrent( redo.pop());
	
		
		
	}
	
// fonction qui empile su la pile undo a chaque action	
	public static void toDo()
	{
	
	 undo.push(Serie.getCurrent());	
	 redo.clear();
	}
   
	public static  void grapheToTab()
	{
		toDo();
		new SerieChronologiqueTab(Serie.getCurrent().getNom(),
		Serie.getCurrent().getDate(),Serie.getCurrent().getValeur());
		
		
	}
	
	public static void tabToGraphe()
	{
		toDo();
		new SerieChronologiqueGraphe(Serie.getCurrent().getNom(),
		Serie.getCurrent().getDate(),Serie.getCurrent().getValeur());
		
	}
	
	public static void toTransfoLog()
	{
		TransfoLog tr = new TransfoLog();
		tr.calcul();
	}
	
	public static void toMoyenne()
	{
		Moyenne tr = new Moyenne();
		tr.calcul();
	}
	
	public static void toMoyenneMobile()
	{
		 String value1 = JOptionPane.showInputDialog("Avec quel saisonalité ? (entier attendu)");
		 Integer value2 = Integer.parseInt(value1);
		 MoyenneMobile penis  = new MoyenneMobile((int)value2);
		 System.out.println(value2);
		 penis.calcul();
	}
  
	public static void toChoose() throws IOException, ParseException
	{
		JFileChooser fileChooser = new JFileChooser();
	
		int returnValue = fileChooser.showOpenDialog(null);
		 if (returnValue == JFileChooser.APPROVE_OPTION) {
	          File selectedFile = fileChooser.getSelectedFile();
	        new Reader(selectedFile.getName(),true);
	        }
		
	}

	
	}

