package marcytial;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Reader {
private String chemin;
	
	public Reader(String filePath) {
		super();
		this.chemin = filePath;
	}
		
	public String [] OuvrirFichier() throws IOException 
	{
		FileReader fr = new FileReader(chemin);
		BufferedReader buffer= new BufferedReader (fr);
		int nblignes = compterLignes(); 
		String [] donne = new String [nblignes];
		for (int i=0; i<nblignes;i++)
		{
			donne [i]= buffer.readLine();
		}
		buffer.close();
		return donne;
		
	}

	public String[] OuvrirFile() throws IOException
	{
		 File file = new File(chemin);
		 Scanner imputstream = new Scanner(file);
		 imputstream.next();
		 String [] values = null;
		 while(imputstream.hasNext())
		 {
			 String data = imputstream.next();
			 values = data.split(";");
		 }
		 imputstream.close();
		 return values;
	}
		
	public int compterLignes() throws IOException
	{
		FileReader fr = new FileReader(chemin);
		BufferedReader bf= new BufferedReader (fr);
		String lignes = null ;
		int nblignes = 0; 
		while ((lignes = bf.readLine())!= null)
		{
			nblignes++;
		}
		
		bf.close();
		return nblignes;
		
	}
	
	public SuiteChrono creationSuite(String[] timesSeries) throws ParseException 
	{ 
		String dt = timesSeries[0];
		DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		Date date = format.parse(dt);
		Double valeur = Double.parseDouble(timesSeries[1]);
	 
		return new SuiteChrono(date, valeur);
	} 



	
}

