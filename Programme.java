package marcytial;

import java.io.IOException;
import java.text.ParseException;


public class Programme{
	
	public static void main(String[] args) throws IOException, ParseException {
		
 new Hydrateur();
 new Tools();
 Tools.toDo();
 System.out.println(Serie.getCurrent().getValeur());
 System.out.println(Serie.getCurrent().getDate());
 //Tools.toMoyenne();
 //Tools.toMoyenneMobile();
 System.out.println(Serie.getCurrent().getValeur());
 }
} 