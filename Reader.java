package marcytial;


	import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;



public class Reader {
	
	private List <Serie> liste;
	private Serie laserie;
	
	public Reader(String nomfichier,Boolean graphe) throws IOException, ParseException 
	{
		if(graphe)
			{
			laserie= readerCSVGraphe(nomfichier);
			
			}
		else{
			laserie= readerCSVTab(nomfichier);
		}
	}
	
	
					
	public SerieChronologiqueGraphe readerCSVGraphe(String nomFichier) throws IOException, ParseException
	{  
		Serie suite= new SerieChronologiqueGraphe();
		Scanner sc = new Scanner(new FileReader(nomFichier));
		String ligne;
		String[] lignes;
		Date dat;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		String nom = nomFichier;
		ArrayList <Date> date = new ArrayList<Date>();
		ArrayList <Double> valeur = new ArrayList <Double>();
		
		while (sc.hasNextLine()) 
		{
			ligne = sc.nextLine();
			lignes = ligne.split(";"); 
			String dateInString = lignes[1];
			dat = formatter.parse(dateInString);
			date.add(dat);
			valeur.add(Double.parseDouble(lignes[2]));
		}
		
		suite.setDate(date);
		suite.setNom(nom);
		suite.setValeur(valeur);
		sc.close();
		return (SerieChronologiqueGraphe) suite; 
	}
	
	private SerieChronologiqueTab readerCSVTab(String nomFichier) throws IOException, ParseException
	{ 
		Serie suite= new SerieChronologiqueTab();
		Scanner sc = new Scanner(new FileReader(nomFichier));
		String ligne;
		String[] lignes;
		Date dat;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		String nom = nomFichier;
		ArrayList <Date> date = new ArrayList<Date>();
		ArrayList <Double> valeur = new ArrayList <Double>();
		
		while (sc.hasNextLine()) 
		{
			ligne = sc.nextLine();
			lignes = ligne.split(";"); 
			String dateInString = lignes[1];
			dat = formatter.parse(dateInString);
			date.add(dat);
			valeur.add(Double.parseDouble(lignes[2]));
		}
		
		suite.setDate(date);
		suite.setNom(nom);
		suite.setValeur(valeur);
		sc.close();
		return  (SerieChronologiqueTab) suite; 
	}
	
	public void printSuiteLis(Serie suite) {
		for (Serie sc : liste) { 
			System.out.println(sc.getNom() + " | " + sc.getDate()
				     + " | " + sc.getValeur()  );
			}
	
		
	}
	
	public void writeCSV(String nomfichier , Serie suite)throws IOException
	{
		
		FileWriter fw = new FileWriter (nomfichier,true);
		BufferedWriter bw = new BufferedWriter(fw); 
		for (Serie sc : liste)
		{
			fw.write (sc.getNom()+";");
			fw.write (sc.getDate()+";");
			fw.write (sc.getValeur().toString());
			fw.write ("\r\n");
		}
		bw.flush(); 
		bw.close(); 
		fw.close();
	}
	
		
}