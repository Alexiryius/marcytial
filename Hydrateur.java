package marcytial;

public class Hydrateur
{
	private Visuel visuel;
	private Reader reader;
	private Serie laSerie;
	private boolean end;
	
   public Hydrateur()
   {
	  visuel= new Visuel();
	  reader= new Reader();
	  laSerie=null;
	  end=false;
   }	
  
   public Hydrateur(Serie nouvelleSerie)
   {
	visuel =new Visuel();
	reader= new Reader();
	laSerie= nouvelleSerie;
	end=false;
   }
  
   public void setLaSerie(Serie nouvelleSerie)
   {
	   this.laSerie=nouvelleSerie;
   }
   public void quitter()
   {
	   this.end=true;
   }
}