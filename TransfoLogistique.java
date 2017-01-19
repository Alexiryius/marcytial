package marcytial;

import java.util.ArrayList;

public class TransfoLogistique extends Transformation
{
	public TransfoLogistique()
	{
		super("Transformation logistique de");
	}
	
	private boolean intervalle()
	{
		boolean inter = true;		
		int taille = Serie.getCurrent().getValeur().size();
		
		for(int i =0; i< taille; i++)
		{
			if((Serie.getCurrent().getValeur().get(i) <= 0) || (Serie.getCurrent().getValeur().get(i) >= 1))
			{
				inter = false;
			}
		}
		
		return inter;
	}
	
	public void calcul()
	{
		if(intervalle())
		{
			int taille2 =Serie.getCurrent().getValeur().size();
			ArrayList<Double> resultat= new ArrayList<>();
			
			for(int i = 0;i < taille2 ;i++)
				{
				resultat.add(Math.log(Serie.getCurrent().getValeur().get(i) / (1 - Serie.getCurrent().getValeur().get(i))));
				}
			if( Serie.getCurrent() instanceof SerieChronologiqueGraphe){
				
				Tools.toDo();
				new SerieChronologiqueGraphe(this.getNom()+ " " +Serie.getCurrent().getNom(),
				 			Serie.getCurrent().getDate(),resultat);	
		
			}
			else
			{
				Tools.toDo();
			    new SerieChronologiqueTab(this.getNom()+ " " +Serie.getCurrent().getNom(),
					 			Serie.getCurrent().getDate(),resultat);	
			}
		}
	}
	
}
