package marcytial;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

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
	
	public JPanel graphPan(){
		JPanel graphPan = new JPanel();
		JPanel panel = new JPanel();
        for (int i = 0; i < 50; i++) {
            panel.add(new JButton("Hello-" + i));
        }
		JScrollPane scrollPane=new JScrollPane(panel);
		graphPan.setSize(new Dimension(500, 500));
		graphPan.add(scrollPane);
		return graphPan;
		
		}
	
	String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
	public JComboBox transfoList = new JComboBox(petStrings);
		
	public JButton undoB = new JButton("undo");
	public JButton redoB = new JButton("redo");
	public JButton bouton = new JButton("...");
	public JButton tab = new JButton("tableau");
	JLabel label = new JLabel("Outil Marcytial");
	public JButton validBouton = new JButton("ok");
	public JPanel GraphPan = new JPanel();
	
	
		
	public Visuel(){
		
		//tableau a tibo
		SerieChronologiqueTab sCT = new SerieChronologiqueTab();
		JPanel pSCT = new JPanel();
		pSCT = sCT.returnPanel();
    
    	
    	Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    	int hauteur = (int)dimension.getHeight();
    	int largeur  = (int)dimension.getWidth();
    	this.setSize(largeur,hauteur);
    	
    	this.setTitle("Projet Marcytial");
    	this.setLocationRelativeTo(null);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	//deux petits bouton
    	JPanel peterPan = new JPanel();
    	peterPan.setLayout(new BoxLayout(peterPan, BoxLayout.LINE_AXIS));
    	peterPan.add(validBouton);
    	peterPan.add(tab);
    	
    	// peterpanel et combobox
    	JPanel choixPan = new JPanel();
    	choixPan.setLayout(new BoxLayout(choixPan, BoxLayout.PAGE_AXIS));
    	choixPan.add(Box.createRigidArea(new Dimension(0,200)));
    	choixPan.add(transfoList);
    	choixPan.add(Box.createRigidArea(new Dimension(0,100)));
    	choixPan.add(peterPan);
    	choixPan.add(Box.createRigidArea(new Dimension(0,600)));
    	
    	// choixpan et graphique
    	JPanel tablPan = new JPanel();
    	tablPan.setLayout(new BoxLayout(tablPan, BoxLayout.LINE_AXIS));
    	tablPan.add(choixPan,BorderLayout.WEST);
    	tablPan.add(pSCT,BorderLayout.CENTER);
    	
    	
    	JPanel entetPan = new JPanel();
    	entetPan.setLayout(new BoxLayout(entetPan, BoxLayout.LINE_AXIS));
    	entetPan.add(label);
    	choixPan.add(Box.createRigidArea(new Dimension(200,10)));
    	entetPan.add(undoB);
    	choixPan.add(Box.createRigidArea(new Dimension(10,10)));
    	entetPan.add(redoB);
    	choixPan.add(Box.createRigidArea(new Dimension(200,10)));
    	entetPan.add(bouton);
    	
    	
    	
    	JPanel remplPan = new JPanel();
    	remplPan.setSize(500, 500);
    	
    	JPanel panneauPrinc = new JPanel();
    	panneauPrinc.setLayout(new BoxLayout(panneauPrinc, BoxLayout.PAGE_AXIS));
    	panneauPrinc.add(entetPan,BorderLayout.CENTER);
    	choixPan.add(Box.createRigidArea(new Dimension(0,20)));
    	panneauPrinc.add(tablPan,BorderLayout.CENTER);
    	choixPan.add(Box.createRigidArea(new Dimension(500,0)));
    	this.setContentPane(panneauPrinc);
    	this.setVisible(true);
    	System.out.println("le constructeur est executé");
    	}
	public static void main(String[] args) {
		Visuel visuel = new Visuel(); 
        visuel.setVisible(true);
    }
}





  

