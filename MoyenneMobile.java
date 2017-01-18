package marcytial;

import java.util.ArrayList;
import java.util.Date;

public class MoyenneMobile extends Transformation
{
	private int saisonnalite ;
			
	public MoyenneMobile(int saison)
	{
		super("qui a subit une moyenne mobile");
		
		if (saison <= 0)
            {
                throw new IllegalArgumentException("length must be greater than zero");
            }
            this.saisonnalite=saison;
        }
	
		
	@Override
	public void calcul()


	{
		int taille = Serie.getCurrent().getValeur().size()-1;
		int saison;
		double somme = 0;
		ArrayList<Double> resultat = new ArrayList<>();
		ArrayList<Date> date = new ArrayList<>();
		
		if(this.saisonnalite%2 == 0)
		{		
			saison= (this.saisonnalite/2);
			for(int i =saison ;i <= taille-saison ;i++)
			{
				
				for(int j = i-saison ;j <= i-saison+saisonnalite;j++)
				{ 
					if (j == i-saison || j == i-saison+saisonnalite){somme += Serie.getCurrent().getValeur().get(j)/2;}
					else {somme += Serie.getCurrent().getValeur().get(j);}
				}
				date.add(Serie.getCurrent().getDate().get(i));
				somme = somme/saisonnalite;
				resultat.add(somme);
	
			}
			
		}
		else if(this.saisonnalite%2 == 1)
		{
			saison= (int)(this.saisonnalite/2);
			for(int i = saison;i <= taille-saison;i++)
			{
				for(int j = i - saison; j <= i + saison;j++)
				{
					somme += Serie.getCurrent().getValeur().get(j);
				}
				date.add(Serie.getCurrent().getDate().get(i));
				somme = somme/saisonnalite;
				resultat.add(somme);
			}
			
		}
		
		if( Serie.getCurrent() instanceof SerieChronologiqueGraphe)
		{				
			Tools.toDo();
			Serie.setCurrent(new SerieChronologiqueGraphe(Serie.getCurrent().getNom()+this.getNom(),
		 			date,resultat));	
			
		}
		else if( Serie.getCurrent() instanceof SerieChronologiqueTab)
		{
			Tools.toDo();
			Serie.setCurrent(new SerieChronologiqueTab(Serie.getCurrent().getNom()+this.getNom(),
			date,resultat));	
			System.out.println("valeurs : " + Serie.getCurrent().getValeur().size());
			System.out.println("dates :" + Serie.getCurrent().getDate().size());
		}
	
		
	}
}