package marcytial;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JPanel;

public class SerieChronologiqueGraphe extends Serie implements AffTab {

	public SerieChronologiqueGraphe(){
		super();
	}
	
	public SerieChronologiqueGraphe(String nom, ArrayList<Date> date, ArrayList<Double> valeur)
	{
		super(nom,date,valeur);
		
	}

	
	public JPanel retournPanel() {
		// TODO Auto-generated method stub
		return null;
	}
}
