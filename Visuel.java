package marcytial;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

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
	
	
	
	public JComboBox combo(){
	String[] transfoTitles = new String[] {"transformation 1", "transformation 2", "transformation 3", "transformation 4"};	
	//fenetre combobox choix des transformations
	JComboBox<String> transfoList = new JComboBox<>(transfoTitles);
	return transfoList;
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
	
	
	public JPanel sPlotPan(){
	JPanel sPlotPan = new JPanel();
	//fenetre scatterplot
	
	JFreeChart chart = ChartFactory.createScatterPlot(
	            "Scatter Plot", // chart title
	            "X", // x axis label
	            "Y", // y axis label
	            createDataset(), // data  
	            PlotOrientation.VERTICAL,
	            true, // include legend
	            true, // tooltips
	            false // urls
	            );
	ChartPanel cPanel = new ChartPanel(chart);
	
	
	sPlotPan.add(cPanel);
	return sPlotPan;
	
	}
	
		
	public Visuel(){
    
    	
    	Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    	int hauteur = (int)dimension.getHeight();
    	int largeur  = (int)dimension.getWidth();
    	this.setSize(largeur,hauteur);
    	
    	this.setTitle("Projet Marcytial");
    	this.setLocationRelativeTo(null);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	
    	 JPanel content = new JPanel();
    	    content.setPreferredSize(new Dimension(300, 120));
    	    //On définit le layout manager
    	    content.setLayout(new GridBagLayout());
    	    //L'objet servant à positionner les composants
    	    GridBagConstraints gbc = new GridBagConstraints();
 
    	//https://openclassrooms.com/courses/apprenez-a-programmer-en-java/positionner-des-boutons
        //---------------------------------------------
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        //Celle-ci indique que la cellule se réplique de façon verticale
        gbc.fill = GridBagConstraints.VERTICAL;
        content.add(cell5, gbc);
        //---------------------------------------------
        gbc.gridx = 1;
        gbc.gridheight = 1;
        //Celle-ci indique que la cellule se réplique de façon horizontale
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        content.add(cell6, gbc);
        //---------------------------------------------
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        content.add(cell7, gbc);
        //---------------------------------------------
        gbc.gridx = 3;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        content.add(cell8, gbc);
        //---------------------------------------------
        this.setContentPane(content);
        this.setVisible(true);      

            
    	
    	System.out.println("le constructeur est executé");
    } 



    
    
    
    
 
    public static void main(String[] args) {
    	Visuel visuel = new Visuel(); 
        visuel.setVisible(true); 
    }
}




  

