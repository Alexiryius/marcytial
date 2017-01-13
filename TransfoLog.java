package marcytial;

import java.util.ArrayList;
import java.lang.Math;

public class TransfoLog extends Transformation
{
	

	public TransfoLog()
	{
		super("a l'échelle logarithmique");
	}
	
	
	
	public void calcul()	
	{
		int taille =Serie.getCurrent().getValeur().size();
		ArrayList<Double> result= new ArrayList<>();
		
		for(int i = 0;i < taille ;i++)
			{
			result.add(Math.log(Serie.getCurrent().getValeur().get(i)));
			}
		if( Serie.getCurrent() instanceof SerieChronologiqueGraphe){
			
			Tools.toDo();
			new SerieChronologiqueGraphe(Serie.getCurrent().getNom()+this.getNom(),
			 			Serie.getCurrent().getDate(),result);	
	
		}
		else
		{
			Tools.toDo();
		    new SerieChronologiqueTab(Serie.getCurrent().getNom()+this.getNom(),
				 			Serie.getCurrent().getDate(),result);	
		}
	}
	
		
}
