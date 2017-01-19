package marcytial;
import marcytial.Visuel; 


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
	    
	    else if (source==Visuel.boutoncurb){
	    	if(Visuel.courb.isSelected()){
	    		Tools.plusieurcourb=true;
	    		Visuel.ajouteVis();
	    	}else{
	    		Tools.plusieurcourb=false;
	    		Visuel.ajouteVis();
	    		
	    	}
	    }
	    else if (source==Visuel.validBouton){
			Visuel.validBouton.setText("OK");
			 if( ((String)Visuel.transfoList.getSelectedItem()).equals("Moyenne"))
			 {
				 Tools.toMoyenne();
				 Visuel.ajouteVis();
			 }
			 else if(((String)Visuel.transfoList.getSelectedItem()).equals("Moyenne Mobile"))
			 {
				 Tools.toMoyenneMobile();
				 Visuel.ajouteVis();
			 }
			 else if(((String)Visuel.transfoList.getSelectedItem()).equals("Regression lineaire"))
			 {
				 Tools.toRegLin();
				 Visuel.ajouteVis();
			 }
			 else if (((String)Visuel.transfoList.getSelectedItem()).equals("Box Cox"))
			 {
				 Tools.toBoxCox();
				 Visuel.ajouteVis();
				 
			 }
			 else if (((String)Visuel.transfoList.getSelectedItem()).equals("logarithm"))
			 {
				 Tools.toTransfoLog();
				 Visuel.ajouteVis(); 
			 }
		}
		
		else if (source==Visuel.undoB){
			Tools.unDo();
			if(Visuel.tab.getText().equals("tableau")){
				Visuel.tab.setText("graphique");
			}
			else{
				Visuel.tab.setText("tableau");
			}
			Visuel.ajouteVis();
			

		}
		else if (source==Visuel.save){
			try {
				Tools.toSave();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			
		else if (source==Visuel.redoB){
		
			Tools.reDo();
			if(Visuel.tab.getText().equals("tableau")){
				Visuel.tab.setText("graphique");
			}
			else{
				Visuel.tab.setText("tableau");
			}
			Visuel.ajouteVis();
			
			
		}
		else if (source==Visuel.bouton){
			  try {
				Tools.toChoose();
				 Visuel.ajouteVis();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  }
	
		
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


