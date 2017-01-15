package marcytial;
import marcytial.Visuel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

public class ActionEcoute{

public ActionListener monActionEcouteur = new ActionListener() {
	boolean clic = false;	
	
	public void actionPerformed(ActionEvent e){
		Object source=e.getSource();    
	    if (source==Visuel.tab){
	    	if(clic == false){
	    		Visuel.tab.setText("tableau");
	    		Tools.tabToGraphe();
	    		Visuel.ajouteVis();
	    		clic = true;
	    		
	    		
	    	}
	    	else{
	    		Visuel.tab.setText("graphique");
	    		Tools.grapheToTab();
	    		Visuel.ajouteVis();
	    		clic = false;

	    	}
	    }
		if (source==Visuel.validBouton){
			Visuel.validBouton.setText("OK");
			 String petName = (String)Visuel.transfoList.getSelectedItem();
		}
		
		if (source==Visuel.undoB){
			Tools.unDo();
<<<<<<< HEAD
			System.out.println(Serie.getCurrent());
			Visuel.ajouteVis();
			System.out.println("je suis la");

		  
=======
			if(Visuel.tab.getText().equals("tableau")){
				Visuel.tab.setText("graphique");
			}
			else{
				Visuel.tab.setText("tableau");
			}
			
		    Visuel.ajouteVis(); 
>>>>>>> 72d53e978d7e16fcab52dbc0a3b955493564c896
		}
		
		if (source==Visuel.redoB){
		
			Tools.reDo();
			if(Visuel.tab.getText().equals("tableau")){
				Visuel.tab.setText("graphique");
			}
			else{
				Visuel.tab.setText("tableau");
			}
			Visuel.ajouteVis();
			
			
		}
		  if (source==Visuel.bouton){
			  Tools.toChoose();
		  }
	
		//Serie.getCurrent().returnPanel().revalidate();
		//Serie.getCurrent().returnPanel().repaint();
		if (Tools.mayIUndo()){
			Visuel.undoB.setEnabled(false);}
		else{
			Visuel.undoB.setEnabled(true);}
		if (Tools.mayIRedo()){
			Visuel.redoB.setEnabled(false);}
		else{
			Visuel.redoB.setEnabled(true);}

	}
	
}
	;
}


