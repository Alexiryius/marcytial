package marcytial;

import java.util.ArrayList;

public class RegLineaire extends Transformation
{
	
	public RegLineaire()
	{
		super("Regression lineaire");
	}

	
	public void calcul()
	{
		Moyenne moy = new Moyenne();
		int taille = Serie.getCurrent().getValeur().size();
		ArrayList<Double> resultat = new ArrayList<>();
		
		double somme1 = 0;
		int carre = 0;
		
		for(int i = 0; i < taille; i++)
		{
			somme1 += Serie.getCurrent().getValeur().get(i) * (i + 1);
		}
		double cov = somme1 / taille;
		
		for(int x = 0;x < taille; x++)
		{
			carre += Math.pow(x + 1,2);
		}
		carre /= taille;
		
		double a = (cov - ((taille + 1) / 2) * moy.moyenne()) / (carre - ((taille + 1) / 2));
		
		
		double b = moy.moyenne() - a * ((taille + 1) / 2);
		
		
		
		
		for (int i = 0;i < taille; i++)
		{
			resultat.add(a * (i + 1) + b);
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
				
		
		/* RESTE A AFFICHER LA COURBE Y=aX+b
		 * 
		 * a et b sont corrects
		 * 
		 * elle devrait passer par la moyenne des valeurs 
		 */
		
	}
}
