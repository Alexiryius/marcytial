package marcytial;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel; 
/**

/*

 *
 * @author rogeza
 * 
 */

public class Visuel extends JFrame{
	
	private static final long serialVersionUID = 1L;
	static String[] transfoStrings = { "Moyenne", "Moyenne Mobile", "Regression lineaire", "Box Cox", "logarithm"};
	public static JComboBox<?> transfoList = new JComboBox<Object>(transfoStrings);
	public static JButton undoB = new JButton();
	public static JButton redoB = new JButton();
	public static JButton  save =  new JButton();
	public static JButton bouton = new JButton();
	public static JCheckBox courb = new JCheckBox("Afficher la serie précedente");
	public static JButton tab = new JButton("graphique");
	JLabel label = new JLabel("Outil Marcytial");
	JLabel labelChoix = new JLabel("Appliquez une transformation");
	public static JButton validBouton = new JButton("ok");
	public static JPanel milieuDroite =new JPanel();
    static	JPanel panneauPrinc2  = new JPanel();
    
    
	
	public static void ajouteVis(){
		milieuDroite.removeAll();
		milieuDroite.updateUI();
		milieuDroite.setLayout(new BoxLayout(milieuDroite, BoxLayout.PAGE_AXIS));
	 	milieuDroite.add(Serie.getCurrent().returnPanel());
       	milieuDroite.repaint();
    	

    	
	}
	
	

	public Visuel(){
		

		try {
			
			ImageIcon undo = new ImageIcon("src/marcytial/Undo.png");
		    undoB.setIcon(undo);
		    undoB.setMargin(new Insets(0, 0, 0, 0));
		    undoB.setBackground(Color.white);
		    undoB.setBorder(null);
		    ImageIcon redo = new ImageIcon("src/marcytial/redo.jpg");
		    redoB.setIcon(redo);
		    redoB.setMargin(new Insets(0, 0, 0, 0));
		    redoB.setBackground(Color.white);
		    redoB.setBorder(null);
		    ImageIcon open = new ImageIcon("src/marcytial/ouvrire.jpg");
		    bouton.setIcon(open);
		    bouton.setMargin(new Insets(0, 0, 0, 0));
		    bouton.setBackground(Color.white);
		    bouton.setBorder(null);
		    ImageIcon sauv = new ImageIcon("src/marcytial/save.png");
		    save.setIcon(sauv);
		    save.setMargin(new Insets(0, 0, 0, 0));
		    save.setBackground(Color.white);
		    save.setBorder(null);
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
	    	
	    	label.setBounds(largeur/320,hauteur/90,largeur/10,hauteur/30);
	    	panneauPrinc2.add(label);
	    	save.setBounds(largeur-180,20,50,40);
	    	save.addActionListener(listn.monActionEcouteur);
	    	panneauPrinc2.add(save);
	      	bouton.setBounds(largeur-120,20,50,40);
	      	bouton.addActionListener(listn.monActionEcouteur);
	    	panneauPrinc2.add(bouton);
	      	undoB.setBounds(1100,70,80,20);
	      	undoB.addActionListener(listn.monActionEcouteur);
	    	panneauPrinc2.add(undoB);
	      	redoB.setBounds(1190,70,80,20);
	      	redoB.addActionListener(listn.monActionEcouteur);
	    	panneauPrinc2.add(redoB);
	    	labelChoix.setBounds(338,120,220,22);
	    	panneauPrinc2.add(labelChoix);
	    	transfoList.setBounds(400,157,150,22);
	    	panneauPrinc2.add(transfoList);
	    	validBouton.addActionListener(listn.monActionEcouteur);
	    	validBouton.setBounds(470,194,80,22);
	    	panneauPrinc2.add(validBouton);
	    	milieuDroite.setBounds(576,120,728,500);
	    	panneauPrinc2.add(milieuDroite);
	    	courb.setBounds(576,650,200,25);
	    	courb.addActionListener(listn.monActionEcouteur);
	    	
	    	panneauPrinc2.add(courb);
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
		   
		  } catch (Exception ex) 
		{
		    System.out.println(ex);
		  }
		
		
    	
    	
    	}
	
}





  

