package marcytial;

import java.io.IOException;
import java.text.ParseException;

public class Hydrateur
{
	private Visuel visuel;
	private Reader reader;
	private Serie laSerie;
	
	
   public Hydrateur() throws IOException, ParseException
   {
	  visuel= new Visuel();
	  reader= new Reader("src/marcytial/suiteChrono.csv",true);
	  laSerie=null;
	  
   }	
  
   public Hydrateur(Serie nouvelleSerie) throws IOException, ParseException
   {
	visuel =new Visuel();
	reader= new Reader("src/marcytial/suiteChrono.csv",true);
	laSerie= nouvelleSerie;
	
   }
  
   public void setLaSerie(Serie nouvelleSerie)
   {
	   this.laSerie=nouvelleSerie;
   }
 
}