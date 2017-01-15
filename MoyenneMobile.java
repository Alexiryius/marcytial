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
			saison= this.saisonnalite/2;
			
			for(int i =saison ;i < taille-saison ;i++)
			{
				for(int j = i - saison ;j < i +saison;j++)
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
	
		
	}
}