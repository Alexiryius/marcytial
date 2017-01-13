package marcytial;

import java.util.ArrayList;

public class MoyenneMobile implements Transformations
{
	public ArrayList<Double> moyenneMobile = new ArrayList<Double>();
	SerieChronologiqueTab moyMobile = new SerieChronologiqueTab();
	int saisonnalite = XX//a definir par l'user
	
	public ArrayList<Double> mmobile()
	{
		if(saisonnalite%2 == 0)
		{		
			for(int i = saisonnalite / 2;i < moyMobile.getValeur().size() - saisonnalite / 2;i++)
			{
				
			}
		}
		else
		{
			
		}
		
		return moyenneMobile;
	}
}
