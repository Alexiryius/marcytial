package marcytial;


	import java.io.*;
	import java.util.*;

	public class Reader {
		
		private List < SuiteChrono > liste;
		
		public Reader() {
			liste = new ArrayList < SuiteChrono > ();
			}
		
		public SuiteChrono nbrelignes(int i){
			return liste.get(i);
		}
		
		public int nbreLignes() {
			return liste.size();
			}	
		
		public void lireCSV(String nomFichier) throws FileNotFoundException, IOException 
		{ 
			Scanner sc = new Scanner(new FileReader(nomFichier)); 
			String ligne ;
			SuiteChrono suite;
			while (sc.hasNextLine())
			{
				ligne = sc.nextLine();
				String[] lignes = ligne.split("[;]"); 
				String date = lignes[0];
				double open = Double.parseDouble(lignes[1]);
				double high = Double.parseDouble(lignes[2]);
				double low = Double.parseDouble(lignes[3]);
				double close = Double.parseDouble(lignes[4]);
				suite = new SuiteChrono(date, open, high, low, close); 
				liste.add(suite); 
			}
			sc.close(); 
		}
		
		public SuiteChrono estPlusBas(){
			SuiteChrono plusBas = liste.get(0);
			for (SuiteChrono suite: liste) {
				if(plusBas.getLow()> suite.getLow()){
					plusBas = suite;
				}
			}
			return plusBas;
		}
		
		public SuiteChrono estPlusHaut(){
			SuiteChrono plusEleve = liste.get(0);
			for (SuiteChrono suite: liste) {
				if(suite.getHigh()> plusEleve.getHigh()){
					plusEleve = suite;
				}
			}
			return plusEleve;
		}
		
		public SuiteChrono plusGrandDiffOpenClose(){
			SuiteChrono elever = liste.get(0);
			for (SuiteChrono suite: liste) {
				if(Math.abs(elever.getOpen()-elever.getClose())< Math.abs(suite.getOpen()- suite.getClose())){
					elever = suite;
				}
			}
			return elever;
		}
		
		public SuiteChrono plusGrandDiffHighLow(){
			SuiteChrono elever = liste.get(0);
			for (SuiteChrono suite: liste) {
				if(Math.abs(elever.getHigh()-elever.getLow())< Math.abs(suite.getHigh()- suite.getLow())){
					elever = suite;
				}
			}
			return elever;
		}
	}
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	