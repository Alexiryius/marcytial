package marcytial;


import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;



public class Reader {

	private Serie laserie;
	
	public Reader(String nomfichier,boolean graphe) throws IOException, ParseException 
	{
		if(graphe)
			{
			setLaserie(readerCSVGraphe(nomfichier));
			
			}
		else{
			setLaserie(readerCSVTab(nomfichier));
		}
	}
	
			
	public SerieChronologiqueGraphe readerCSVGraphe(String nomFichier) throws IOException, ParseException
	{  
		Serie suite= new SerieChronologiqueGraphe();
		Scanner sc = new Scanner(new FileReader(nomFichier));
		String[] lignes;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		String nom = nomFichier;
		ArrayList <Date> date = new ArrayList<Date>();
		ArrayList <Double> valeur = new ArrayList <Double>();
		
		while (sc.hasNextLine()) 
		{
			lignes = sc.nextLine().split(";"); 

			date.add(formatter.parse(lignes[0]));
			valeur.add(Double.parseDouble(lignes[1]));

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
		String[] lignes;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		String nom = nomFichier;
		ArrayList <Date> date = new ArrayList<Date>();
		ArrayList <Double> valeur = new ArrayList <Double>();
		
		while (sc.hasNextLine()) 
		{
			lignes = sc.nextLine().split(";"); 
			date.add(formatter.parse(lignes[0]));
			valeur.add(Double.parseDouble(lignes[1]));
		}
		
		suite.setDate(date);
		suite.setNom(nom);
		suite.setValeur(valeur);
		sc.close();
		return (SerieChronologiqueTab) suite; 
	}
	
	public void printSuiteLis(Serie suite) {
		System.out.println(suite.getNom() + " | " + suite.getDate()
				     + " | " + suite.getValeur() );
					
	}
	
	public void writeCSV(String nomfichier , Serie suite)throws IOException
	{
		
		FileWriter fw = new FileWriter (nomfichier,true);
		BufferedWriter bw = new BufferedWriter(fw); 
		
			fw.write (suite.getNom()+";");
			fw.write (suite.getDate()+";");
			fw.write (suite.getValeur().toString());
			fw.write ("\r\n");
	
		bw.flush(); 
		bw.close(); 
		fw.close();
	}
	
	public Serie getLaserie() {
		return laserie;
	}



	public void setLaserie(Serie laserie) {
		this.laserie = laserie;
	}

	
}