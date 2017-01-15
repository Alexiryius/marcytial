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
	    		Visuel.tab.setText("graphique");
	    		Tools.tabToGraphe();
	    		Visuel.ajouteVis();
	    		clic = true;
	    		
	    	}
	    	else{
	    		Visuel.tab.setText("tableau");
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
			Visuel.ajouteVis();
		
		}
		
		if (source==Visuel.redoB){
			Tools.reDo();
			Visuel.ajouteVis();
			
		}
	
		//Serie.getCurrent().returnPanel().revalidate();
		//Serie.getCurrent().returnPanel().repaint();
		if (Tools.mayIUndo()){
			Visuel.undoB.setEnabled(false);}
		else{
			Visuel.undoB.setEnabled(true);}
		if (Tools.mayIRedo()){
			Visuel.undoB.setEnabled(false);}
		else{
			Visuel.undoB.setEnabled(true);}
	}
	
}
	;
}


