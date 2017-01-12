package marcytial;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.lang.Math;

public class TransfoLog implements Transformations
{
	//private Serie serieTransfoLog;
	public ArrayList<Double> valeurLog = new ArrayList<Double>();
	SerieChronologiqueTab sct = new SerieChronologiqueTab();
	//SerieChronologiqueGraphe scg = new SerieChronologiqueGraphe();
	
	public ArrayList<Double> transfoLog()	
	{
			
		
		for(int i = 0;i < sct.getValeur().size();i++)
			{
				valeurLog.add(Math.log(sct.getValeur().get(i)));
			}
		return valeurLog;
	}
	
	/*public ArrayList<Double> transfoLog(Serie serie)
	{
		
		
		
		return transfoLog(serie);
	}*/
	
	public SerieChronologiqueTab transfoLogTab = new SerieChronologiqueTab("Série transformée Log",sct.getDate(),transfoLog());
	public SerieChronologiqueGraphe transfoLogGraphe = new SerieChronologiqueGraphe("Série transformée Log",sct.getDate(),transfoLog());
	
}
