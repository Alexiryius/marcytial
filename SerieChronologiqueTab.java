package marcytial;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SerieChronologiqueTab extends Serie implements AffTab  {

	public SerieChronologiqueTab(){
		super();
	}
	
	public SerieChronologiqueTab(String nom, ArrayList<Date> date, ArrayList<Double> valeur){
		super(nom,date,valeur);
	}
 
	
	public JPanel returnPanel() {
		
        JPanel contentPane = new JPanel(null);	
		//if (isInitialized()) {
			int taille =this.getDate().size();
			
			Object[][] listData = new Object[taille][2];
			
			for(int i =0; i<taille;i++)
			{
				listData[i][1]= this.getValeur().get(i);
				listData[i][0]=this.getDate().get(i);
			}
			
				
			String[] nameVector= {"date","Valeur"};
			
			
			JTable tableau = new JTable(listData, nameVector);
			JScrollPane scrollPane = new JScrollPane(tableau);
	        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    	scrollPane.setBounds(0, 0, 728, 500);
	        contentPane.add(scrollPane);
//		} else {
//			
//			contentPane.setColor); ;
//		}
        return contentPane;
	}
}
