package marcytial;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Date;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeriesCollection;



public class SerieChronologiqueGraphe extends Serie implements AffTab {
    
	private XYDataset dataset; 
	
	public SerieChronologiqueGraphe(){
		super();
		this.dataset= null;
	}
	
	public SerieChronologiqueGraphe(String nom, ArrayList<Date> date, ArrayList<Double> valeur)
	{
		super(nom,date,valeur);
		this.dataset= this.createDataset();
		
	}

	private boolean isInitialized() {
		return (this.getDate() != null) ;
	}
	
	private XYDataset createDataset() {
		
		
		int taille = this.getDate().size();
		
		TimeSeries series = new TimeSeries( this.getNom() );
		
		for(int i=0;i<taille;i++)
		{
			series.add(new Second (this.getDate().get(i)), this.getValeur().get(i));
		}
		 return new TimeSeriesCollection(series);
	}
	
	
	
	public JPanel returnPanel() {
		
		JPanel contentPane = new JPanel(null);	
		if (isInitialized()) 
		{
			
			int taille = this.getDate().size();
			
			TimeSeries series = new TimeSeries( this.getNom() );
			
			for(int i=0;i<taille;i++)
			{
				series.add(new Second (this.getDate().get(i)), this.getValeur().get(i));
			}
			
		
			
			JFreeChart graph = ChartFactory.createTimeSeriesChart (this.getNom(),"date","valeur", this.dataset,
																true,true,false ) ; 

			ChartPanel chartPanel = new ChartPanel(graph); 
			JScrollPane scrollPane = new JScrollPane(chartPanel);
	        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
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
