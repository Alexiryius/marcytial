package marcytial;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jfree.chart.*; 
import org.jfree.chart.plot.*; 
import org.jfree.data.*;
import org.jfree.data.general.DefaultPieDataset; 
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
    	
    	public Graphique(){
    		DefaultPieDataset pieDataset = new DefaultPieDataset(); 
    		pieDataset.setValue("Valeur1", new Integer(35)); 
    		pieDataset.setValue("Valeur2", new Integer(10)); 
    		pieDataset.setValue("Valeur3", new Integer(50)); 
    		pieDataset.setValue("Valeur4", new Integer(5)); 

    		JFreeChart pieChart = ChartFactory.createPieChart("Test camembert", pieDataset, true, true, true); 
    		ChartPanel cPanel = new ChartPanel(pieChart); 
    		this.add(cPanel); 
    		
    		
    	}
    }
    
 
    public static void main(String[] args) {
    	Visuel visuel = new Visuel(); 
        visuel.setVisible(true); 
    }
}




  

