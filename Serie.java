package marcytial;

public abstract class Serie
{
	private int ID = 0;
	private String nom = "";
	private boolean aUneOrigine = false;
	private Serie origine = null;
	private boolean aUneFille = false;
	private Serie fille = null;	
	
	//private boolean tableau;
	//private boolean grahique;
	
	
	
	public int getID()
	{
		return ID;
	}
	
	public String getNom()
	{
		return nom;
	}
	
	public void setNom(String n)
	{
		nom = n;
	}
	
	public Serie getOrigine()
	{
		if(aUneOrigine)
			return this.origine;
		return null;
	}
	
	public setOrigine(Serie serie)
	{
		//if(aUneFille)
		//{
			origine = serie;
			aUneOrigine = true;
		//}
	}
	
	
	
	
}
