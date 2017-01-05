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
				suite = new SuiteChrono(date, open); 
				liste.add(suite); 
			}
			sc.close(); 
		}
		public List < SuiteChrono > readCSV(String nomFichier) throws IOException
		{ 
			List < SuiteChrono > result = new ArrayList  < SuiteChrono > ();
			 Scanner sc = new Scanner(new FileReader(nomFichier));
			 String line = null;
			 SuiteChrono suite;
			 sc.nextLine();
			 while (sc.hasNextLine()) {
				 line = sc.nextLine();
			      String[] values = line.split(";");
			      String date = values[0];
			      double open = Double.parseDouble(values[1]);
			      suite = new SuiteChrono(date, open);
			      result.add(suite);
			     
			    }
			    sc.close();
			    return result;
		}
		
		public void writeCSV(String nomfichier , List<SuiteChrono> suite)throws IOException
		{
			
			FileWriter fw = new FileWriter (nomfichier,true);
			BufferedWriter bw = new BufferedWriter(fw); 
			  
			for (int i = 0 ; i< suite.size(); i++)
			{
				fw.write (suite.get(i).getDate()+";");
				fw.write (Double.toString(suite.get(i).getOpen()));
				fw.write ("\r\n");
			}
			bw.flush(); 
			bw.close(); 
			fw.close();
		}
		
		public void print(List < SuiteChrono > liste) { 
			for (SuiteChrono sc : liste) { 
				System.out.println(sc);
			} 
			
		} 
	}

	
	
	
	
	