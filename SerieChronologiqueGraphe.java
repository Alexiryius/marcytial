package marcytial;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class SerieChronologiqueGraphe extends Serie implements AffTab {

	public SerieChronologiqueGraphe(){
		super();
	}
	
	public SerieChronologiqueGraphe(String nom, ArrayList<Date> date, ArrayList<Double> valeur)
	{
		super(nom,date,valeur);
		
	}

	private boolean isInitialized() {
		return (this.getDate() != null) ;
	}
	
	public JPanel returnPanel() {
		
		JPanel contentPane = new JPanel(null);	
		if (isInitialized()) 
		{
			
			int taille = this.getDate().size();
					
			XYSeries courbe = new XYSeries(this.getNom()); 
			for(int i=0;i<taille;i++)
			{
				courbe.add(this.getValeur().get(i),this.getDate().get(i));
			}
			
			XYSeriesCollection xyDataset = new XYSeriesCollection(courbe);
			
			JFreeChart Graph = ChartFactory.createXYLineChart (this.getNom(),"date","valeur",xyDataset,
																PlotOrientation.VERTICAL,true,true,false ) ; 

			JPanel panel = new JPanel();
			JScrollPane scrollPane = new JScrollPane(panel);
	        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
	        scrollPane.setBounds(50, 30, 300, 50);
	       
	        contentPane.add(scrollPane);
        }else {
			JLabel text = new JLabel("Y a rien") ;
			contentPane.add(text) ;
		}
        contentPane.setPreferredSize(new Dimension(500, 400));
        
        
        return contentPane;
	}
}
