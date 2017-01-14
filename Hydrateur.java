package marcytial;

import java.io.IOException;
import java.text.ParseException;

public class Hydrateur
{
	private Visuel visuel;
	private Reader reader;
	private Serie laSerie;
	public static boolean graphe = false;
	
	
   public Visuel getVisuel() {
		return visuel;
	}

	public void setVisuel(Visuel visuel) {
		this.visuel = visuel;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public Serie getLaSerie() {
		return laSerie;
	}
	
	public static void changBool(){
		graphe =!graphe;
	}

public Hydrateur() throws IOException, ParseException
   {

	 

	  reader= new Reader("src/marcytial/suiteChrono.csv",graphe);

	  laSerie=reader.getLaserie();
	  visuel= new Visuel();
	 
   }	
  
   public Hydrateur(Serie nouvelleSerie) throws IOException, ParseException
   {

	

	reader= new Reader("src/marcytial/suiteChrono.csv",true);

	laSerie= nouvelleSerie;
	visuel =new Visuel();
	
   }
  
   public void setLaSerie(Serie nouvelleSerie)
   {
	   this.laSerie=nouvelleSerie;
   }
 
   
}