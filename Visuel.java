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
	
	static String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
	public static JComboBox transfoList = new JComboBox(petStrings);
		
	public JButton undoB = new JButton("undo");
	public JButton redoB = new JButton("redo");
	
	public JButton bouton = new JButton("...");
	public static JButton tab = new JButton("tableau");
	JLabel label = new JLabel("Outil Marcytial");
	public static JButton validBouton = new JButton("ok");
	public JPanel GraphPan = new JPanel();
	


	public Visuel(){
		
		
    	Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    	int hauteur = (int)dimension.getHeight();
    	int largeur  = (int)dimension.getWidth();
    	
//    	
//    	
//    	JPanel milieuGauche = new JPanel();
//    	milieuGauche.setBorder(BorderFactory.createLineBorder(Color.black)); 
//    	milieuGauche.setLayout(new BoxLayout(milieuGauche, BoxLayout.PAGE_AXIS));
//    	milieuGauche.add(Box.createRigidArea(new Dimension(0,200)));
//    	//transfoList.setAlignmentX(Component.CENTER_ALIGNMENT);
//    	milieuGauche.add(transfoList);
//    	milieuGauche.add(Box.createRigidArea(new Dimension(0,100)));
//    	//validBouton.setAlignmentX(Component.CENTER_ALIGNMENT);
//    	validBouton.addActionListener(ActionEcoute.monActionEcouteur);
//    	milieuGauche.add(validBouton);
//    	milieuGauche.add(Box.createRigidArea(new Dimension(0,800)));
//    	
//    	JPanel hautMilieuDroite= new JPanel();
//    	hautMilieuDroite.setLayout(new BoxLayout(hautMilieuDroite, BoxLayout.LINE_AXIS));
//    	//undoB.setAlignmentX(Component.LEFT_ALIGNMENT);
//    	hautMilieuDroite.add(undoB);
//    	//redoB.setAlignmentX(Component.LEFT_ALIGNMENT);
//    	hautMilieuDroite.add(redoB);
    	
//    	JPanel milieu = new JPanel();
//    	milieu.setLayout(new BoxLayout(milieu, BoxLayout.LINE_AXIS));
//    	//milieuGauche.setAlignmentX(Component.RIGHT_ALIGNMENT);
//    	milieu.add(milieuGauche);
//    	//milieu.setAlignmentX(Component.RIGHT_ALIGNMENT);
//    	milieu.add(milieuDroite);
//    	
//    	JPanel haut = new JPanel();
//    	haut.setBorder(BorderFactory.createLineBorder(Color.black)); 
//    	haut.setLayout(new BoxLayout(haut, BoxLayout.LINE_AXIS));
//    	haut.add(Box.createRigidArea(new Dimension(60,30)));
//    	//label.setAlignmentX(Component.LEFT_ALIGNMENT);
//    	haut.add(label);
//    	haut.add(Box.createRigidArea(new Dimension(largeur-245,30)));
//    	//bouton.setAlignmentX(Component.RIGHT_ALIGNMENT);
//    	haut.add(bouton);
//    	haut.add(Box.createRigidArea(new Dimension(60,30)));
//    	
    	
//    	JPanel panneauPrinc = new JPanel();
//    	panneauPrinc.setLayout(new BoxLayout(panneauPrinc, BoxLayout.PAGE_AXIS));
//    	//haut.setAlignmentX(Component.TOP_ALIGNMENT);
//    	panneauPrinc.add(haut);
//    	milieuGauche.add(Box.createRigidArea(new Dimension(0,20)));
//    	//haut.setAlignmentX(Component.CENTER_ALIGNMENT);
//    	panneauPrinc.add(milieu);
//    	milieuGauche.add(Box.createRigidArea(new Dimension(500,0)));
//    
//    	this.setContentPane(panneauPrinc);
//    	this.setVisible(true);
    	
    	
    	JPanel milieuDroite = new JPanel();
    	milieuDroite.setLayout(new BoxLayout(milieuDroite, BoxLayout.PAGE_AXIS));
    	milieuDroite.add(Serie.getCurrent().returnPanel());
    	
    	
    	
    	JPanel graphTab = new JPanel();
    
    	graphTab.add(Serie.getCurrent().returnPanel());
    	
    	JPanel panneauPrinc2 = new JPanel();
    	panneauPrinc2.setLayout(null);
    	this.setSize(largeur,hauteur);
    	label.setBounds(20,10,160,30);
    	panneauPrinc2.add(label);
      	bouton.setBounds(largeur-120,20,60,30);
    	panneauPrinc2.add(bouton);
      	undoB.setBounds(1100,70,80,20);
    	panneauPrinc2.add(undoB);
      	redoB.setBounds(1190,70,80,20);
    	panneauPrinc2.add(redoB);
    	transfoList.setBounds(400,120,150,22);
    	panneauPrinc2.add(transfoList);
    	validBouton.setBounds(470,157,80,22);
    	panneauPrinc2.add(validBouton);
    	milieuDroite.setBounds(576,120,728,500);
    	panneauPrinc2.add(milieuDroite);
    	tab.setBounds(1130,650,120,25);
    	tab.addActionListener(ActionEcoute.monActionEcouteur);
    	panneauPrinc2.add(tab);
    	this.setTitle("Projet Marcytial");
    	this.setLocationRelativeTo(null);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	this.setContentPane(panneauPrinc2);
    	this.revalidate();
    	this.setVisible(true);
    	
    	}
	
}





  

