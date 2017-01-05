package marcytial;

public class Hydrateur
{
	private Visuel visuel;
	private Reader reader;
	private Serie laSerie;
	
	
   public Hydrateur()
   {
	  visuel= new Visuel();
	  reader= new Reader();
	  laSerie=null;
	  
   }	
  
   public Hydrateur(Serie nouvelleSerie)
   {
	visuel =new Visuel();
	reader= new Reader();
	laSerie= nouvelleSerie;
	
   }
  
   public void setLaSerie(Serie nouvelleSerie)
   {
	   this.laSerie=nouvelleSerie;
   }
 
}