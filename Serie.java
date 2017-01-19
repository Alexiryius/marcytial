package marcytial;

import java.util.ArrayList; 
import java.util.Date;
import javax.swing.JPanel;

public abstract class Serie
{   
	
	private static Serie current = null ;
	private String nom = "";
	private ArrayList<Date> date ;
	private ArrayList<Double>valeur ;
	
	
	//Constructeur
	Serie()
	{
		
		nom ="no_name";
		date=null;
		valeur=null;
		
		current=this;
		
	}
	Serie(String nom, ArrayList<Date> date, ArrayList<Double> valeur)
	{
		
		this.nom = nom;
		this.date = date;
		this.valeur = valeur;
	
		current=this;
	}
	
	
	//private boolean tableau;
	//private boolean grahique;
	
	abstract public JPanel returnPanel();
	
	
	public String getNom()
	{
		String coco = "";
		for(int i= 0; i< this.nom.length() ;i++){
			coco += nom.charAt(i);
			if (nom.charAt(i) == '/'){
				coco="";
			}	
		}
		
		coco = coco.replaceAll(".csv","");
		return coco;
		
	}
	
	
	public void setNom(String n)
	{
		this.nom = n;
	}
	
	public ArrayList<Date> getDate()
	{
		return this.date;
	}
	
	public ArrayList<Double> getValeur()
	{
		return this.valeur;
	}
	
	public void setValeur(ArrayList<Double> n)
	{
		this.valeur = n;
	}
	
	
	
	public void setDate(ArrayList<Date> bim)
	{
		this.date=bim ;
	}
	public static Serie getCurrent(){
		return current;
	}
	public static void setCurrent(Serie laserie)
	{
		current=laserie;
	}
}
