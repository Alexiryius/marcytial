package marcytial;

import java.util.ArrayList;

public class RegLineaire extends Transformation
{
	
	public RegLineaire()
	{
		super("Régression linéaire");
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
				
		
		// RESTE A AFFICHER LA COURBE
		
	}
}
