package marcytial;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JPanel;

public class SerieChronologiqueTab extends Serie implements AffTab  {

	SerieChronologiqueTab(){
		super();
	}
	
	SerieChronologiqueTab(String nom, ArrayList<Date> date, ArrayList<Double> valeur){
		super(nom,date,valeur);
	}

	@Override
	public JPanel retournPanel() {
		// TODO Auto-generated method stub
		return null;
	}
}
