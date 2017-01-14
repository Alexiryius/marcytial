package marcytial;
import marcytial.Visuel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEcoute{

public ActionListener monActionEcouteur = new ActionListener() {
	boolean clic = false;	
	public void actionPerformed(ActionEvent e){
		Object source=e.getSource();    
	    if (source==Visuel.tab){
	    	if(clic == false){
	    		Visuel.tab.setText("graphique");
	    		Hydrateur.changBool();
	    		clic = true;
	    	}
	    	else{
	    		Visuel.tab.setText("tableau");
	    		Hydrateur.changBool();
	    		clic = false;
	    	}
	    }
		if (source==Visuel.validBouton){
			Visuel.validBouton.setText("OK");
			 String petName = (String)Visuel.transfoList.getSelectedItem();
			 System.out.println(petName + " choisi");
		}
		//Serie.getCurrent().returnPanel().revalidate();
		//Serie.getCurrent().returnPanel().repaint();
		
	}
	
}
	;
}


