package marcytial;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*; 
import java.util.Random;
import org.jfree.chart.plot.*; 
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection; 
/**
 *
 * @author rogeza
 */


public class Visuel extends JFrame{

    public Visuel(){
    	Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    	int hauteur = (int)dimension.getHeight();
    	int largeur  = (int)dimension.getWidth();
    	this.setSize(largeur,hauteur);
    	
    	this.setTitle("Projet Marcytial");
    	this.setLocationRelativeTo(null);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	this.setContentPane(new Graphique());
    	System.out.println("le constructeur est executé");
    } 
    
    
    // classe panel ou est represente le graphique
    public class Graphique extends JPanel { 
    	
    	private final Random r = new Random();

    	private XYDataset createDataset() {
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
    	
    	public Graphique(){
    		JFreeChart chart = ChartFactory.createScatterPlot(
    	            "Scatter Plot", // chart title
    	            "X", // x axis label
    	            "Y", // y axis label
    	            createDataset(), // data  ***-----PROBLEM------***
    	            PlotOrientation.VERTICAL,
    	            true, // include legend
    	            true, // tooltips
    	            false // urls
    	            );
    		ChartPanel cPanel = new ChartPanel(chart); 
    		this.add(cPanel); 
    		
    	}
    }
    
    
    
 
    public static void main(String[] args) {
    	Visuel visuel = new Visuel(); 
        visuel.setVisible(true); 
    }
}




  

