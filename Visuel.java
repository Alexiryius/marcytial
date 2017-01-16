package marcytial;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection; 
/**
 *
 * @author rogeza
 * 
 */

//http://stackoverflow.com/questions/11129608/using-repaint-method-with-actionperformed/11131267
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
	
	
	
	static String[] transfoStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
	public static JComboBox transfoList = new JComboBox(transfoStrings);
		
	public static JButton undoB = new JButton("undo");
	public static JButton redoB = new JButton("redo");
	
	public static JButton bouton = new JButton("...");
	public static JButton tab = new JButton("graphique");
	JLabel label = new JLabel("Outil Marcytial");
	JLabel labelChoix = new JLabel("Choisissez la transformation");
	public static JButton validBouton = new JButton("ok");
	public static JPanel milieuDroite =new JPanel();
    static	JPanel panneauPrinc2  = new JPanel();

	
	public static void ajouteVis(){
		milieuDroite.removeAll();
		milieuDroite.updateUI();
		milieuDroite.setLayout(new BoxLayout(milieuDroite, BoxLayout.PAGE_AXIS));
		System.out.println((Serie.getCurrent().getNom()));
    	milieuDroite.add(Serie.getCurrent().returnPanel());
       	milieuDroite.repaint();
    	

    	
	}
	
	

	public Visuel(){
		
    	Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    	int hauteur = (int)dimension.getHeight();
    	int largeur  = (int)dimension.getWidth();	
    	ActionEcoute listn = new ActionEcoute();
    	
    	undoB.setEnabled(false);
    	redoB.setEnabled(false);
    	milieuDroite.setLayout(new BoxLayout(milieuDroite, BoxLayout.PAGE_AXIS));

    	milieuDroite.add(Serie.getCurrent().returnPanel());
    	panneauPrinc2.setLayout(null);

    	this.setSize(largeur,hauteur);
    	label.setBounds(20,10,160,30);
    	panneauPrinc2.add(label);
      	bouton.setBounds(largeur-120,20,60,30);
    	panneauPrinc2.add(bouton);
      	undoB.setBounds(1100,70,80,20);
      	undoB.addActionListener(listn.monActionEcouteur);
    	panneauPrinc2.add(undoB);
      	redoB.setBounds(1190,70,80,20);
      	redoB.addActionListener(listn.monActionEcouteur);
    	panneauPrinc2.add(redoB);
    	labelChoix.setBounds(345,120,220,22);
    	panneauPrinc2.add(labelChoix);
    	transfoList.setBounds(400,157,150,22);
    	panneauPrinc2.add(transfoList);
    	validBouton.addActionListener(listn.monActionEcouteur);
    	validBouton.setBounds(470,194,80,22);
    	panneauPrinc2.add(validBouton);
    	milieuDroite.setBounds(576,120,728,500);
    	panneauPrinc2.add(milieuDroite);
    	tab.setBounds(1130,650,120,25);
    	tab.addActionListener(listn.monActionEcouteur);
    	panneauPrinc2.add(tab);
    	this.setTitle("Projet Marcytial");
    	this.setLocationRelativeTo(null);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	panneauPrinc2.setBackground(Color.LIGHT_GRAY);
    	this.setContentPane(panneauPrinc2);
    	this.revalidate();
    	this.setVisible(true);
    	
    	}
	
}





  

