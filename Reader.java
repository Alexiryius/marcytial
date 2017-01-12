package marcytial;


	import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


	public class Reader extends Serie{
		
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
		public void printSuiteLis(List<Serie> suite) {
			for (int i = 0; i < suite.size(); i++) {
				System.out.println(suite.get(i).getNom() + " | " + suite.get(i).getDate()
				     + " | " + suite.get(i).getValeur()  );
			}
			
		}
		
	
		
		
		
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
		
		
		
		public void lireCSV(String nomFichier) throws FileNotFoundException, IOException, ParseException 
		{ 
			Serie suite;
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
				suite = new Reader(nom,date, valeur); 
				liste.add(suite); 
			}
			sc.close(); 
		}
		
		
		
		
		
		
		
		
		public void printSuiteList(List< Serie> suite) {
			  for (int i = 0; i < suite.size(); i++) {
				  System.out.println(suite.get(i).getNom() + " | " + suite.get(i).getDate()
			     + " | " + suite.get(i).getValeur()  );
			  }
			 }
		
		public Serie readCSV(String nomFichier) throws IOException, ParseException
		{ 
			Scanner sc = new Scanner(new FileReader(nomFichier)); 
			String ligne ;
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
			Serie suite = null;
			while (sc.hasNextLine())
			{
				ligne = sc.nextLine();
				String[] lignes = ligne.split("[;]"); 
				String nom = lignes[0];
				ArrayList <Date> date = new ArrayList<Date>();
				String dateInString = lignes[1];
				Date dat = formatter.parse(dateInString);
				date.add(dat);
				ArrayList <Double> valeur = new ArrayList <Double>();
				valeur.add(Double.parseDouble(lignes[2]));
				suite = new Reader(nom,date, valeur); 
				System.out.println(suite);
			}
			sc.close(); 
			return suite;
		}
		public void writeCSV(String nomfichier , List<Serie> suite)throws IOException
		{
			
			FileWriter fw = new FileWriter (nomfichier,true);
			BufferedWriter bw = new BufferedWriter(fw); 
			
			for (int i = 0 ; i< suite.size(); i++)
			{
				fw.write (suite.get(i).getNom()+";");
				fw.write (suite.get(i).getDate()+";");
				fw.write (suite.get(i).getValeur().toString());
				fw.write ("\r\n");
			}
			bw.flush(); 
			bw.close(); 
			fw.close();
		}
}