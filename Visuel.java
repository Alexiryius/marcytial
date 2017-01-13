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
		
		//tableau a tibo
		
    	Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    	int hauteur = (int)dimension.getHeight();
    	int largeur  = (int)dimension.getWidth();
    	this.setSize(largeur,hauteur);
    	
    	this.setTitle("Projet Marcytial");
    	this.setLocationRelativeTo(null);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	
    	JPanel milieuGauche = new JPanel();
    	milieuGauche.setBorder(BorderFactory.createLineBorder(Color.black)); 
    	milieuGauche.setLayout(new BoxLayout(milieuGauche, BoxLayout.PAGE_AXIS));
    	milieuGauche.add(Box.createRigidArea(new Dimension(0,200)));
    	transfoList.setAlignmentX(Component.CENTER_ALIGNMENT);
    	milieuGauche.add(transfoList);
    	milieuGauche.add(Box.createRigidArea(new Dimension(0,100)));
    	validBouton.setAlignmentX(Component.CENTER_ALIGNMENT);
    	validBouton.addActionListener(ActionEcoute.monActionEcouteur);
    	milieuGauche.add(validBouton);
    	milieuGauche.add(Box.createRigidArea(new Dimension(0,800)));
    	
    	JPanel hautMilieuDroite= new JPanel();
    	hautMilieuDroite.setLayout(new BoxLayout(hautMilieuDroite, BoxLayout.LINE_AXIS));
    	undoB.setAlignmentX(Component.LEFT_ALIGNMENT);
    	hautMilieuDroite.add(undoB);
    	redoB.setAlignmentX(Component.LEFT_ALIGNMENT);
    	hautMilieuDroite.add(redoB);
    	hautMilieuDroite.add(Box.createRigidArea(new Dimension(200,10)));
    	
    	JPanel milieuDroite = new JPanel();
    	milieuDroite.setBorder(BorderFactory.createLineBorder(Color.black)); 
    	milieuDroite.setLayout(new BoxLayout(milieuDroite, BoxLayout.PAGE_AXIS));
    	hautMilieuDroite.setAlignmentX(Component.CENTER_ALIGNMENT);
    	milieuDroite.add(hautMilieuDroite);
    	//Serie.getCurrent().returnPanel().setAlignmentX(Component.CENTER_ALIGNMENT);
    	//milieuDroite.add(Serie.getCurrent().returnPanel());
    	tab.setAlignmentX(Component.CENTER_ALIGNMENT);
    	tab.addActionListener(ActionEcoute.monActionEcouteur);
    	milieuDroite.add(tab);

    	JPanel milieu = new JPanel();
    	milieu.setLayout(new BoxLayout(milieu, BoxLayout.LINE_AXIS));
    	//milieuGauche.setAlignmentX(Component.RIGHT_ALIGNMENT);
    	milieu.add(milieuGauche);
    	milieu.setAlignmentX(Component.RIGHT_ALIGNMENT);
    	milieu.add(milieuDroite);
    	
    	JPanel haut = new JPanel();
    	haut.setBorder(BorderFactory.createLineBorder(Color.black)); 
    	haut.setLayout(new BoxLayout(haut, BoxLayout.LINE_AXIS));
    	haut.add(Box.createRigidArea(new Dimension(60,30)));
    	label.setAlignmentX(Component.LEFT_ALIGNMENT);
    	haut.add(label);
    	haut.add(Box.createRigidArea(new Dimension(largeur-245,30)));
    	bouton.setAlignmentX(Component.RIGHT_ALIGNMENT);
    	haut.add(bouton);
    	haut.add(Box.createRigidArea(new Dimension(60,30)));
    	
    	
    	JPanel panneauPrinc = new JPanel();
    	panneauPrinc.setLayout(new BoxLayout(panneauPrinc, BoxLayout.PAGE_AXIS));
    	haut.setAlignmentX(Component.TOP_ALIGNMENT);
    	panneauPrinc.add(haut,BorderLayout.CENTER);
    	milieuGauche.add(Box.createRigidArea(new Dimension(0,20)));
    	haut.setAlignmentX(Component.CENTER_ALIGNMENT);
    	panneauPrinc.add(milieu,BorderLayout.CENTER);
    	milieuGauche.add(Box.createRigidArea(new Dimension(500,0)));
    	this.setContentPane(panneauPrinc);
    	this.setVisible(true);
    	System.out.println("le constructeur est executé");
    	}
	
}





  

