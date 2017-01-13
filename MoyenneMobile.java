package marcytial;

import java.util.ArrayList;

public class MoyenneMobile extends Transformation
{
	private int saisonnalite ;
			
	public MoyenneMobile(int saison){
		super("qui a subit une moyenne mobile");
		this.saisonnalite=saison;
	}
	SerieChronologiqueTab moyMobile = new SerieChronologiqueTab();
	
	
	public ArrayList<Double> mmobile()
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
	}

	@Override
	void calcul() {
		// TODO Auto-generated method stub
		
	}
}
