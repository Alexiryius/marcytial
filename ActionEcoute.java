package marcytial;
import marcytial.Visuel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEcoute{

static ActionListener monActionEcouteur = new ActionListener() {
	boolean clic = false;	
	
	public void actionPerformed(ActionEvent e){
		Object source=e.getSource();    
	    if (source==Visuel.tab){
	    	if(clic == false){
	    		Visuel.tab.setText("graphique");
	    		clic = true;
	    	}
	    	else{
	    		Visuel.tab.setText("tableau");
	    		clic = false;
	    	}
	    }
		if (source==Visuel.validBouton){
			Visuel.validBouton.setText("OK");
			 String petName = (String)Visuel.transfoList.getSelectedItem();
			 System.out.println(petName + " choisi");
		}
		
		
	}
}
	;
}


