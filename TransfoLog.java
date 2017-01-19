package marcytial;

import java.util.ArrayList;
import java.lang.Math;
import java.text.DecimalFormat;

public class TransfoLog extends Transformation
{
	

	public TransfoLog()
	{
		super("transformation logarithmique de");
	}
	
	
	
	public void calcul()	
	{
		int taille =Serie.getCurrent().getValeur().size();
		ArrayList<Double> result= new ArrayList<>();
		java.util.Scanner sc;
		DecimalFormat decimalFormat = new DecimalFormat("########.###");
		
		for(int i = 0;i < taille ;i++)
			{
					 String format = decimalFormat.format(Math.log(Serie.getCurrent().getValeur().get(i)));
					 sc = new java.util.Scanner(format);
					 double f = sc.nextDouble();
					result.add(f);
			
			}
		if( Serie.getCurrent() instanceof SerieChronologiqueGraphe){
			
			Tools.toDo();
			new SerieChronologiqueGraphe(this.getNom()+ " " +Serie.getCurrent().getNom(),
			 			Serie.getCurrent().getDate(),result);	
	
		}
		else
		{
			Tools.toDo();
		    new SerieChronologiqueTab(this.getNom()+ " " +Serie.getCurrent().getNom(),
				 			Serie.getCurrent().getDate(),result);	
		}
	}
	
		
}
