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
	
	@Override
	public JPanel returnPanel() {
        JPanel contentPane = new JPanel(null);	
		if (isInitialized()) {
			Vector<Date> listDate = new Vector<>(this.getDate());
			Vector<Double> listValeur = new Vector<>(this.getValeur());
			JTable tableau = new JTable(listDate, listValeur);
			JScrollPane scrollPane = new JScrollPane(tableau);
	        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
	        scrollPane.setBounds(50, 30, 300, 50);
	        contentPane.add(scrollPane);
		} else {
			JLabel text = new JLabel("Y a rien") ;
			contentPane.add(text) ;
		}
		contentPane.setSize(new Dimension(50, 50));
        contentPane.setPreferredSize(new Dimension(50, 50));
        contentPane.setBackground(Color.BLUE);
        
        return contentPane;
	}
}
