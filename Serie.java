package marcytial;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JPanel;

public abstract class Serie
{   
	
	private static Serie current = null ;
	private  static   int id=0 ;
	private final int num;
	private String nom = "";
	private ArrayList<Date> date ;
	private ArrayList<Double>valeur ;
	private Transformation transformation;	
	
	//Constructeur
	Serie()
	{
		id ++;
		num=id;
		nom ="no_name";
		date=null;
		valeur=null;
		transformation=null;
		current=this;
		
	}
	Serie(String nom, ArrayList<Date> date, ArrayList<Double> valeur)
	{
		id++;
		this.num=id;
		this.nom = nom;
		this.date = date;
		this.valeur = valeur;
		this.transformation = null;
		current=this;
	}
	Serie(String nom, ArrayList<Date> date, ArrayList<Double> valeur, Transformation transformation)
	{
		id++;
		this.num=id;
		this.nom = nom;
		this.date = date;
		this.valeur = valeur;
		this.transformation = transformation;
		current=this;
	}
	
	//private boolean tableau;
	//private boolean grahique;
	
	abstract public JPanel returnPanel();
	
	
	public String getNom()
	{
		return this.nom;
	}
	
	@Override
	public String toString() {
		return "["+this.num+ "]";
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
	
	public Transformation getTransformation()
	{
		return this.transformation;
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
