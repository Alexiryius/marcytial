package marcytial;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JFileChooser;


public class Programme{
	
	public static void main(String[] args) throws IOException, ParseException {
		
 new Hydrateur();
 JFileChooser fileChooser = new JFileChooser();
	int returnValue = fileChooser.showOpenDialog(null);
	 if (returnValue == JFileChooser.APPROVE_OPTION) {
       File selectedFile = fileChooser.getSelectedFile();
       System.out.println(selectedFile.getName());}
 //new Tools();

 //System.out.println(Serie.getCurrent().getValeur());
 //System.out.println(Serie.getCurrent().getDate());
 //Tools.toMoyenne();
 Tools.toMoyenneMobile();
 //System.out.println(Serie.getCurrent().getValeur());
 }
} 