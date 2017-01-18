package marcytial;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Moyenne extends Transformation
{
	
	
	public Moyenne()
	{
		super(" en moyenne");
	}
	
	

	public void calcul() {
		
		ArrayList<Double> result = new ArrayList<>();
		double moy=0 ;
		int taille = Serie.getCurrent().getValeur().size();

		for(int i = 0;i < taille ;i++)
		{
			moy += Serie.getCurrent().getValeur().get(i);
		}
		moy /= taille;
		
		java.util.Scanner sc;
		DecimalFormat decimalFormat = new DecimalFormat("########.###");
		for(int i = 0;i < taille;i++)
		{
			 String format = decimalFormat.format(moy);
			 sc = new java.util.Scanner(format);
			 double f = sc.nextDouble();
			result.add(f);
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
	
	public double moyenne()
		{
		ArrayList<Double> result = new ArrayList<>();
			double moy=0 ;
			int taille = Serie.getCurrent().getValeur().size();
	
			for(int i = 0;i < taille ;i++)
			{
				moy += Serie.getCurrent().getValeur().get(i);
			}
			moy /= taille;
			
			return moy;
		}

	
	
}


