package marcytial;

import java.util.ArrayList;

public class MoyenneMobile extends Transformation
{
	public MoyenneMobile(){
		super("qui a subit une moyenne mobile");
	}
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
