package marcytial;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SerieChronologiqueTab extends Serie implements AffTab  {

	SerieChronologiqueTab(){
		super();
	}
	
	SerieChronologiqueTab(String nom, ArrayList<Date> date, ArrayList<Double> valeur){
		super(nom,date,valeur);
	}

	private boolean isInitialized() {
		return (this.getDate() != null) ;
	}
	

	public JPanel returnPanel() {
		
        JPanel contentPane = new JPanel(null);	
		if (isInitialized()) {
			int taille =this.getDate().size();
			
			Vector<Object> listDate = new Vector<>(taille);
			Vector<Object> listValeur = new Vector<>(taille);
			
			for(int i =0; i<taille;i++)
			{
				listDate.add(this.getDate().get(i));
				listValeur.add(this.getValeur().get(i));
			
			}
			
			Vector<Vector<Object>> dataVector= new Vector<Vector<Object>>();
				
			dataVector.add(listDate);
			dataVector.add(listValeur);
			
			Vector<String> nameVector= new Vector<String>();
			
			nameVector.addElement("date");
			nameVector.addElement("Valeur");
			
			
			JTable tableau = new JTable(dataVector, nameVector);
			JScrollPane scrollPane = new JScrollPane(tableau);
	        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

	        contentPane.add(scrollPane);
		} else {
			JLabel text = new JLabel("Y a rien") ;
			contentPane.add(text) ;
		}

        contentPane.setBackground(Color.red);
        
        return contentPane;
	}
}
