package marcytial;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JPanel;

public class SerieChronologiqueGraphe extends Serie implements AffTab {

	public SerieChronologiqueGraphe(){
		super();
	}
	
	public SerieChronologiqueGraphe(ArrayList<Date> tabX,ArrayList<Double> tabY,String name)
	{
		super(name,tabX,tabY);
		
	}

	
	public JPanel retournPanel() {
		// TODO Auto-generated method stub
		return null;
	}
}
