package ui;

import java.awt.*;
import code.*;

import javax.swing.*;

public class PrimePanel extends JPanel{
	
	private Font axisLabel = new Font("calibri", Font.PLAIN, 20);
	
	private void paintXPrimeAxis(Graphics g){
		int height = (int) (SpecRel.velocity*400.0);
		g.setColor(Color.RED);
		g.drawLine(0, 400+height, 800, 400-height);
		
		g.setFont(axisLabel);
		g.drawString("x'", 780, (400-height) + 30);
	}
	
	private void paintYPrimeAxis(Graphics g){
		int height = (int) (SpecRel.velocity*400.0);
		g.setColor(Color.RED);
		g.drawLine(400+height, 0, 400-height, 800);
		
		g.setFont(axisLabel);
		g.drawString("ct'", (400+height) - 30, 20);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		paintXPrimeAxis(g);
		paintYPrimeAxis(g);
	}
}
