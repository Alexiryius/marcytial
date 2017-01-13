package marcytial;

import java.util.ArrayList;

public class BoxCox extends Transformation
{
	private double parametre;
	
	public BoxCox(double param)
	{
		super("Transformation de Box-Cox");
		this.parametre = param;
	}
	
	public void calcul()
	{
		int taille = Serie.getCurrent().getValeur().size();
		ArrayList<Double> resultat = new ArrayList<>();
		
		if(this.parametre == 0)
		{
			for(int i = 0;i < taille;i++)
			{
				resultat.add(Math.log(Serie.getCurrent().getValeur().get(i)));
			}
		}
		else
		{
			for(int i =0;i < taille;i++)
			{
				resultat.add((Math.pow(Serie.getCurrent().getValeur().get(i), this.parametre) - 1) / this.parametre);
			}
		}
		if( Serie.getCurrent() instanceof SerieChronologiqueGraphe)
		{				
			Tools.toDo();
			new SerieChronologiqueGraphe(Serie.getCurrent().getNom()+this.getNom(),
			 			Serie.getCurrent().getDate(),resultat);		
		}
		else
		{
			Tools.toDo();
		    new SerieChronologiqueTab(Serie.getCurrent().getNom()+this.getNom(),
				 			Serie.getCurrent().getDate(),resultat);	
		}
	}
}
