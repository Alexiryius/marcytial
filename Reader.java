package marcytial;


	import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import csv.Serie;
import csv.SerieChronologiqueGraphe;
import csv.SerieChronologiqueTab;


	public class Reader {
		
<<<<<<< HEAD
		
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
=======
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

		
		
		
				
		private SerieChronologiqueGraphe readerCSVGraphe(String nomFichier) throws IOException, ParseException
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
>>>>>>> be93fbbf497654afa13095350c1c8c0cf2c6dfed
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
<<<<<<< HEAD
=======
			}
			
			suite.setDate(date);
			suite.setNom(nom);
			suite.setValeur(valeur);
			sc.close();
			return  (SerieChronologiqueTab) suite; 
		}
		public void printSuiteLis(List<Serie> suite) {
			for (int i = 0; i < suite.size(); i++) {
				System.out.println(suite.get(i).getNom() + " | " + suite.get(i).getDate()
				     + " | " + suite.get(i).getValeur()  );
>>>>>>> be93fbbf497654afa13095350c1c8c0cf2c6dfed
			}
			
			suite.setDate(date);
			suite.setNom(nom);
			suite.setValeur(valeur);
			sc.close();
			return (SerieChronologiqueGraphe) suite; 
		}
		
<<<<<<< HEAD
		private SerieChronologiqueTab readerCSVTab(String nomFichier) throws IOException, ParseException
		{ 
			Serie suite= new SerieChronologiqueTab();
=======
	
		
		
		
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
		
		
		
		public void lireCSV(String nomFichier) throws FileNotFoundException, IOException, ParseException 
		{ 
			Serie suite;
>>>>>>> be93fbbf497654afa13095350c1c8c0cf2c6dfed
			Scanner sc = new Scanner(new FileReader(nomFichier));
			String ligne;
			String[] lignes;
			Date dat;
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
			String nom = nomFichier;
			ArrayList <Date> date = new ArrayList<Date>();
			ArrayList <Double> valeur = new ArrayList <Double>();
			
<<<<<<< HEAD
			while (sc.hasNextLine()) 
=======
			while (sc.hasNextLine())
>>>>>>> be93fbbf497654afa13095350c1c8c0cf2c6dfed
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
		
<<<<<<< HEAD
		public void printSuiteLis(Serie suite) {
			for (Serie sc : liste) { 
				System.out.println(sc.getNom() + " | " + sc.getDate()
					     + " | " + sc.getValeur()  );
				}
=======
		
		
		
		
		
		
		
		public void printSuiteList(List< Serie> suite) {
			  for (int i = 0; i < suite.size(); i++) {
				  System.out.println(suite.get(i).getNom() + " | " + suite.get(i).getDate()
			     + " | " + suite.get(i).getValeur()  );
			  }
			 }
>>>>>>> be93fbbf497654afa13095350c1c8c0cf2c6dfed
		
			
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