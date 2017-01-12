package marcytial;

import java.util.ArrayList;

public class Moyenne implements Transformations
{
	public ArrayList<Double> valeurMoyenne = new ArrayList<Double>();
	SerieChronologiqueGraphe scg = new SerieChronologiqueGraphe();
	
	public ArrayList<Double> moyenne()	
	{
		double moy = 0;	
		
		for(int i = 0;i < scg.getValeur().size();i++)
			{
				moy += scg.getValeur().get(i);
			}
		
		moy /= scg.getValeur().size();
		
		for(int i = 0;i < scg.getValeur().size();i++)
		{
			valeurMoyenne.add(moy);
		}		
		
		return valeurMoyenne;
	}
	
	
	public SerieChronologiqueGraphe moyenneGraphe = new SerieChronologiqueGraphe("Valeur moyene",scg.getDate(),moyenne());
	
}
