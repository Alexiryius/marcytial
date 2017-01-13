package marcytial;

import java.util.ArrayList;

public class MoyenneMobilePonderee extends Transformation
{
	private int saisonnalite;
	private double[] ponderations = new double[saisonnalite];
	
	public MoyenneMobilePonderee(int saison, double[] pond)
	{
		super("qui a subit une moyenne mobile ponderee");
		this.saisonnalite=saison;
		this.ponderations = pond;
	}
	
	
	
	
	public void calcul()
	{
		int taille = Serie.getCurrent().getValeur().size();
		double somme = 0;
		ArrayList<Double> resultat = new ArrayList<>();
		
		if(this.saisonnalite%2 == 0)
		{		
			for(int i =0;i < taille;i++)
			{
				for(int j = i - this.saisonnalite / 2;j < i + this.saisonnalite / 2;j++)
				{
					somme += Serie.getCurrent().getValeur().get(j)/saisonnalite;
				}
				resultat.add(somme);
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
		else
		{
			for(int i = 0;i < taille;i++)
			{
				for(int j = i - (this.saisonnalite - 1) / 2; i < i + (this.saisonnalite - 1) / 2;j++)
				{
					somme += Serie.getCurrent().getValeur().get(j)/saisonnalite;
				}
				resultat.add(somme);
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
		// TODO Auto-generated method stub
		
	}
}
