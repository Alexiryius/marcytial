package marcytial;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;

import javax.swing.JFileChooser;


public class Programme{
	
	public static void main(String[] args) throws IOException, ParseException {
		
 new Hydrateur();

 String pattern = "######.##";
 DecimalFormat decimalFormat = new DecimalFormat(pattern);
 String format = decimalFormat.format(456789.123);
 System.out.println(Double.parseDouble(format));	
 //new Tools();
 //System.out.println(Serie.getCurrent().getValeur());
 //System.out.println(Serie.getCurrent().getDate());
 //Tools.toMoyenne();
 //Tools.toMoyenneMobile();
 //System.out.println(Serie.getCurrent().getValeur());

 }
} 