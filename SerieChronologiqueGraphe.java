package marcytial;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Date;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleInsets;




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

	
	
	private XYDataset createDataset() {
		
		
		int taille = this.getDate().size();
		
		TimeSeries series = new TimeSeries( this.getNom() );
		
		for(int i=0;i<taille;i++)
		{
			series.add(new Second (this.getDate().get(i)), this.getValeur().get(i));
		}
		 return new TimeSeriesCollection(series);
	}
	
	private void setDataset(){
		
		int taille1 = this.getDate().size();
		int taille2 = Tools.undo.peek().getDate().size();
		TimeSeries seriesn2 = new TimeSeries( Tools.undo.peek().getNom() );
		
		for(int i=0;i<taille2;i++)
		{
			seriesn2.add(new Second (Tools.undo.peek().getDate().get(i)), Tools.undo.peek().getValeur().get(i));
		}
		
		TimeSeries series = new TimeSeries( this.getNom() );
		
		for(int i=0;i<taille1;i++)
		{
			series.add(new Second (this.getDate().get(i)), this.getValeur().get(i));
		}
		TimeSeriesCollection joe = new TimeSeriesCollection();
		joe.addSeries(seriesn2);
		joe.addSeries(series);
		this.dataset= joe ;
	}
	
	public JPanel returnPanel() {
		JPanel contentPane = new JPanel(null);	
		
		if(! Tools.mayIUndo()){
			
			contentPane.setBackground(Color.red);
			setDataset();
			JFreeChart graph = ChartFactory.createTimeSeriesChart (this.getNom(),"date","valeur", this.dataset,
																true,true,false ) ;
			graph.setBorderVisible(false);
			
		        
			
		    ChartPanel chartPanel = new ChartPanel(graph); 
			JScrollPane scrollPane = new JScrollPane(chartPanel);
		      
		     scrollPane.setBounds(0, 0, 728, 500);
		     contentPane.add(scrollPane);
	
	        contentPane.setPreferredSize(new Dimension(500, 400));
		}else{
			
			contentPane.setBackground(Color.red);
			JFreeChart graph = ChartFactory.createTimeSeriesChart (this.getNom(),"date","valeur", this.dataset,
																	true,true,false ) ; 
			ChartPanel chartPanel = new ChartPanel(graph); 
			JScrollPane scrollPane = new JScrollPane(chartPanel);
		      
		    scrollPane.setBounds(0, 0, 728, 500);
		    contentPane.add(scrollPane);

	        contentPane.setPreferredSize(new Dimension(500, 400));
		}
       
        return contentPane;
	}
}
