package marcytial;

import java.util.ArrayList;
import java.util.Date;

public abstract class Serie
{
	private static Serie current = null ;
	private static int id = 0;
	private String nom = "";
	private ArrayList<Date> date ;
	private ArrayList<Double>valeur ;
	private Transformations transformation;	
	
	//Constructeur
	Serie()
	{
		id ++;
		nom ="no_name";
		date=null;
		valeur=null;
		transformation=null;
		current=this;
		
	}
	Serie(String nom, ArrayList<Date> date, ArrayList<Double> valeur)
	{
		id++;
		this.nom = nom;
		this.date = date;
		this.valeur = valeur;
		this.transformation = null;
		current=this;
	}
	Serie(String nom, ArrayList<Date> date, ArrayList<Double> valeur, Transformations transformation)
	{
		id++;
		this.nom = nom;
		this.date = date;
		this.valeur = valeur;
		this.transformation = transformation;
		current=this;
	}
	
	//private boolean tableau;
	//private boolean grahique;
	
	
	
	public int getId()
	{
		return this.id;
	}
	
	public String getNom()
	{
		return this.nom;
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
	
	public Transformations getTransformation()
	{
		return this.transformation;
	}
	
	public void setValeur(ArrayList<Double> bim)
	{
		this.valeur=bim ;
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
