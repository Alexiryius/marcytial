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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
			
		    Object [][] listData= new Object[taille][2]  ;
			
			
			for(int i =0; i<taille;i++)
			{
				listData[i][0]=this.getDate().get(i);
				listData[i][1]=this.getValeur().get(i);
			
			}
			
			
			
			String[] nameVector= {"date","Valeur"};
			
			
			
			System.out.println(nameVector);
			
			TableModel model = new DefaultTableModel(listData,nameVector);
			JTable tableau = new JTable( model );
			
			JScrollPane scrollPane = new JScrollPane(tableau);
	        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    	scrollPane.setBounds(30, 30, 500, 500);
	        contentPane.add(scrollPane);
		} else {
			JLabel text = new JLabel("Y a rien") ;
			contentPane.add(text) ;
		}
	
        contentPane.setBackground(Color.red);
        
        return contentPane;
	}
}
