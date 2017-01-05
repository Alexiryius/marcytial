package marcytial;

import java.util.ArrayList;
import java.util.Date;

public abstract class Serie
{
	private static int id = 0;
	private String nom = "";
	private ArrayList<Date> date = new ArrayList<Date>();
	private ArrayList<Double>valeur = new ArrayList<Double>();
	private Transformations transformation;	
	
	//Constructeur
	Serie()
	{
		id ++;
		nom ="no_name";
		date=null;
		valeur=null;
		transformation=null;
		
	}
	Serie(String nom, ArrayList<Date> date, ArrayList<Double> valeur)
	{
		id++;
		this.nom = nom;
		this.date = date;
		this.valeur = valeur;
		this.transformation = null;
	}
	Serie(String nom, ArrayList<Date> date, ArrayList<Double> valeur, Transformations transformation)
	{
		id++;
		this.nom = nom;
		this.date = date;
		this.valeur = valeur;
		this.transformation = transformation;
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
	
	public Transformations getTransformation()
	{
		return this.transformation;
	}
	
	
	
	
	
}
