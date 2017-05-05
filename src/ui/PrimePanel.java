package ui;

import java.awt.*;

import javax.swing.*;

import java.lang.Math;

public class PrimePanel extends JPanel{
	
	//will be determined from user input eventually
	private double alpha = Math.PI/6;
	
	private void paintXPrimeAxis(Graphics g){
		int height = (int) (Math.tan(alpha)*400.0);
		g.setColor(Color.RED);
		g.drawLine(0, 400+height, 800, 400-height);
	}
	
	private void paintYPrimeAxis(Graphics g){
		int height = (int) (Math.tan(alpha)*400.0);
		g.setColor(Color.RED);
		g.drawLine(400+height, 0, 400-height, 800);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		paintXPrimeAxis(g);
		paintYPrimeAxis(g);
	}
}
