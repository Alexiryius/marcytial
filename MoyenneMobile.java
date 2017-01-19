package marcytial;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

public class MoyenneMobile extends Transformation
{
	private int saisonnalite ;
			
	public MoyenneMobile(int saison)
	{
		super("moyenne mobile de");
		
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
		double somme;
		ArrayList<Double> resultat = new ArrayList<>();
		ArrayList<Date> date = new ArrayList<>();
		java.util.Scanner sc;
		DecimalFormat decimalFormat = new DecimalFormat("########.###");
		
			saison= (int)(this.saisonnalite/2);
			for(int i =saison ;i <= taille-saison ;i++)
			{
				somme = 0;
				if(this.saisonnalite%2 == 0){
					for(int j = i-saison ;j <= i-saison+saisonnalite;j++)
					{ 
						if (j == i-saison || j == i-saison+saisonnalite){somme += Serie.getCurrent().getValeur().get(j)/2/saisonnalite;}
						else {somme += Serie.getCurrent().getValeur().get(j)/saisonnalite;}
					}
				}
				else if(this.saisonnalite%2 == 1)
				{
					for(int j = i - saison; j <= i + saison;j++)
					{
						somme +=  (Serie.getCurrent().getValeur().get(j)/saisonnalite);
					}
				}
				date.add(Serie.getCurrent().getDate().get(i));
				 String format = decimalFormat.format(somme);
				 sc = new java.util.Scanner(format);
				 double f = sc.nextDouble();
				resultat.add(f);
	
			}
			
			
			
		
		
		if( Serie.getCurrent() instanceof SerieChronologiqueGraphe)
		{				
			Tools.toDo();
			Serie.setCurrent(new SerieChronologiqueGraphe(this.getNom()+ " " +Serie.getCurrent().getNom(),
		 			date,resultat));	
			
		}
		else if( Serie.getCurrent() instanceof SerieChronologiqueTab)
		{
			Tools.toDo();
			Serie.setCurrent(new SerieChronologiqueTab(this.getNom()+ " " +Serie.getCurrent().getNom(),
			date,resultat));	
			System.out.println("valeurs : " + Serie.getCurrent().getValeur().size());
			System.out.println("dates :" + Serie.getCurrent().getDate().size());
		}
	
		
	}
}