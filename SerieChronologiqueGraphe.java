package marcytial;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SerieChronologiqueGraphe extends Serie implements AffTab {

	public SerieChronologiqueGraphe(){
		super();
	}
	
	public SerieChronologiqueGraphe(String nom, ArrayList<Date> date, ArrayList<Double> valeur)
	{
		super(nom,date,valeur);
		
	}

	
	public JPanel retournPanel() {
		
		JPanel panel = new JPanel();
		JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(50, 30, 300, 50);
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(500, 400));
        contentPane.add(scrollPane);
        
        return contentPane;
	}
}
