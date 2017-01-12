package marcytial;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.xy.XYDataset;


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
	

	XYDataset createDataset() {
		Random r = new Random();
	    XYSeriesCollection result = new XYSeriesCollection();
	    XYSeries series = new XYSeries("Random");
	    for (int i = 0; i <= 100; i++) {
	        double x = r.nextDouble();
	        double y = r.nextDouble();
	        series.add(x, y);
	    }
	    result.addSeries(series);
	    return result;
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
			
		
			
			JFreeChart graph = ChartFactory.createTimeSeriesChart (this.getNom(),"date","valeur",(XYDataset) series,
																true,true,false ) ; 

			ChartPanel chartPanel = new ChartPanel(graph); 
			JScrollPane scrollPane = new JScrollPane(chartPanel);
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
