package ui;

import code.*;

public class Logic {

	private GUI ui;
	
	public void addObserver(GUI userint){
		ui = userint;
	}
	
	public void updatePrimePanel(){
		GUI._prime.repaint();
	}
	
	public void setVelocity(double v){
		SpecRel.velocity = v;
		updatePrimePanel();
	}
	
	public void getVelocity(){
		setVelocity(ui.getVelocityInput());
	}
	
}
