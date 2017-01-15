package marcytial;

import java.util.ArrayList;

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
		int taille = Serie.getCurrent().getValeur().size();
		int saison;
		double somme = 0;
		ArrayList<Double> resultat = new ArrayList<>();
		
		if(this.saisonnalite%2 == 0)
		{		
			
			for(int i =saisonnalite-1 ;i < taille ;i++)
			{
				for(int j = i - saisonnalite-1 ; j < i ;j++)
				{
					somme += Serie.getCurrent().getValeur().get(j)/saisonnalite;
				}
				resultat.add(somme);
			}
		
		}
		else
		{
			for(int i = saisonnalite-1 ;i < taille;i++)
			{
				for(int j = i - saisonnalite-1 ; j < i ;j++)
				{
					somme += Serie.getCurrent().getValeur().get(j)/saisonnalite;
				}
				resultat.add(somme);
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
