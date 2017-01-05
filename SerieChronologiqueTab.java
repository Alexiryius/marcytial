package marcytial;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

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

	@Override
	public JPanel returnPanel() {
		
		JTable tableau = new JTable(new Vector<Double>(this.getValeur()),new Vector<Date>(this.getDate()));
		JScrollPane scrollPane = new JScrollPane(tableau);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(50, 30, 300, 50);
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(500, 400));
        contentPane.add(scrollPane);
        
        return contentPane;
	}
}
