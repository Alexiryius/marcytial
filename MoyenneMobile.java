package marcytial;

import java.util.ArrayList;

public class MoyenneMobile extends Transformation
{
	private int saisonnalite ;
			
	public MoyenneMobile(int saison)
	{
		super("qui a subit une moyenne mobile");
		this.saisonnalite=saison;
	}
	//SerieChronologiqueTab moyMobile = new SerieChronologiqueTab();
	
	
	/*public ArrayList<Double> mmobile()
	{
		if(this.saisonnalite%2 == 0)
		{		
			for(int i = this.saisonnalite / 2;i < moyMobile.getValeur().size() - this.saisonnalite / 2;i++)
			{
				
			}
		}
		else
		{
			
		}
		
		return moyenneMobile;
	}*/

	@Override
	void calcul()
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
					somme += Serie.getCurrent().getValeur().get(i);
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
					somme += Serie.getCurrent().getValeur().get(i);
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
