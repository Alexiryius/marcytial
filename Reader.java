package marcytial;


	import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


	public class Reader extends Serie{
		
		private List <Serie> liste;
		
		public Reader() {
			liste = new ArrayList < Serie >();
		}

		public Serie nbrelignes(int i){
			return liste.get(i);
		}
		public int nbrelignes(){
			return liste.size();
		}
		
		public Reader(String nom, ArrayList<Date> date, ArrayList<Double> valeur) {
			super(nom, date, valeur);
			
		}
		
		
		
		public List <Serie> readerCSV(String nomFichier) throws IOException, ParseException
		{ 
			List <Serie> result = new ArrayList <Serie> ();
			Scanner sc = new Scanner(new FileReader(nomFichier));
			String ligne;
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
			Serie suite = null;
			while (sc.hasNextLine()) {
				ligne = sc.nextLine();
				String[] lignes = ligne.split(";"); 
				String nom = lignes[0];
				ArrayList <Date> date = new ArrayList<Date>();
				String dateInString = lignes[1];
				Date dat = formatter.parse(dateInString);
				date.add(dat);
				ArrayList <Double> valeur = new ArrayList <Double>();
				valeur.add(Double.parseDouble(lignes[2]));
				suite = new Reader(nom,date, valeur); 
				result.add(suite);
			}
			sc.close();
			return result; 
		}
		
		public void printSuiteLis(List<Serie> suite) {
			for (int i = 0; i < suite.size(); i++) {
				System.out.println(suite.get(i).getNom() + " | " + suite.get(i).getDate()
				     + " | " + suite.get(i).getValeur()  );
			}
			
		}
		
		
		public void lireCSV(String nomFichier) throws FileNotFoundException, IOException, ParseException 
		{ 
			Scanner sc = new Scanner(new FileReader(nomFichier)); 
			String ligne ;
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
			Serie suite;
			while (sc.hasNextLine())
			{
				ligne = sc.nextLine();
				String[] lignes = ligne.split(";"); 
				String nom = lignes[0];
				ArrayList <Date> date = new ArrayList<Date>();
				String dateInString = lignes[1];
				Date dat = formatter.parse(dateInString);
				date.add(dat);
				ArrayList <Double> valeur = new ArrayList <Double>();
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