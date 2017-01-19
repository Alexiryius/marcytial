package marcytial;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class BoxCox extends Transformation
{
	private double parametre;
	
	public BoxCox(double param)
	{
		super("transformation Box-Cox de");
		this.parametre = param;
	}
	
	public void calcul()
	{
		int taille = Serie.getCurrent().getValeur().size();
		ArrayList<Double> resultat = new ArrayList<>();
		java.util.Scanner sc;
		DecimalFormat decimalFormat = new DecimalFormat("########.###");
		
		if(this.parametre == 0)
		{
			for(int i = 0;i < taille;i++)
			{
				 String format = decimalFormat.format(Math.log(Serie.getCurrent().getValeur().get(i)));
				 sc = new java.util.Scanner(format);
				 double f = sc.nextDouble();
				resultat.add(f);
			}
		}
		else
		{
			for(int i =0;i < taille;i++)
			{
				 String format = decimalFormat.format((Math.pow(Serie.getCurrent().getValeur().get(i), this.parametre) - 1) / this.parametre);
				 sc = new java.util.Scanner(format);
				 double f = sc.nextDouble();
				resultat.add(f);
			}
		}
		if( Serie.getCurrent() instanceof SerieChronologiqueGraphe)
		{				
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
