package marcytial;

public abstract class Serie
{
	private static int ID = 0;
	private String nom = "";
	private ArrayList<Date> date = new ArrayList<Date>();
	private ArrayList<Double>valeur = new ArrayList<Double>();
	private Transformations transformation;	
	
	//Constructeur
	
	Donnees(int ID, String nom, ArrayList<Date> date, ArrayList<Double> valeur, Transformations transformation)
	{
		ID++;
		this.nom = nom;
		this.date = date;
		this.valeur = valeur;
		this.transformation = transformation;
	}
	
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
	
	public ArrayList<Date> getDate()
	{
		return date;
	}
	
	public ArrayList<Double> getValeur()
	{
		return valeur;
	}
	
	public Transformation getTransformation()
	{
		return transformation;
	}
	
	
	
	
	
}
