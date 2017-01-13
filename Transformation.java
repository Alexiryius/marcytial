package marcytial;

public abstract class Transformation {
	
	
	private String nom;
	
	public Transformation(String nom)
	{
	 this.nom=nom;	
	}
    
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	abstract void calcul();
}
