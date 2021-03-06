package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.*;

@SuppressWarnings("serial")
public class BackgroundPanel extends JPanel{
	
	private int xSize = 800;
	private int ySize = 800;
	private Font axisLabel = new Font("calibri", Font.PLAIN, 20);
	
	public BackgroundPanel(){}
	
	private void paintXAxis(Graphics g, int xWidth){
		int xCenter = xWidth/2;
		g.setColor(Color.black);
		g.drawLine(xCenter, 0, xCenter, ySize);
		
		g.setFont(axisLabel);
		g.drawString("x", 15, 390);
	}
	
	private void paintYAxis(Graphics g, int yWidth){
		int yCenter = yWidth/2;
		g.setColor(Color.black);
		g.drawLine(0, yCenter, xSize, yCenter);

		g.setFont(axisLabel);
		g.drawString("ct", 380, 17);
	}
	
	//allow for rescaling at some point
	private void paintGraphPaper(Graphics g){
		int iter = 800/20;
		int boxX = xSize/20;
		int boxY = ySize/20;
		//need better solution here
		g.setColor(Color.cyan);
		for(int i = 0; i<xSize; i+=iter){
			
			g.drawLine(0, i, xSize, i);
			g.drawLine(i, 0, i, ySize);
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		paintGraphPaper(g);
		paintXAxis(g, xSize);
		paintYAxis(g, ySize);
	}
}
