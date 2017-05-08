
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandler implements ActionListener{
	
	private Logic l;
	
	public EventHandler(Logic lg){
		l = lg;
	}
	
	public void actionPerformed(ActionEvent a){
		switch(a.getActionCommand()){
		
		case "quit":
			System.exit(0);
			break;
		
		case "reset":
			//implement
			break;
		
		case "velocity":
			l.getVelocity();
			break;
		}
	}
}