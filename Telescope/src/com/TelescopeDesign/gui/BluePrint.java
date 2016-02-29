package com.TelescopeDesign.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;



public class BluePrint extends JPanel{

	// Hier sollten die Entsprechenden Objekte gespeichert sein
	
	
	public BluePrint()
	{
		repaint();
		//Define Backgroudcolor
		//setBackground(Color.BLUE);
	}
	
	public void paintComponent(Graphics g){
		//Überschreiben des alten Bildes
		super.paintComponent(g);
		
		//Viereck zeichnen
		g.drawRect(20, 20, 50, 50);
		
		//Ausgefülltes Viereck zeichnen
		g.setColor(Color.RED);
		g.fillRect(20, 80, 50, 80);
		
		//Zeichnen eines Polygons
		int[] xCoords = {120,145,170};
		int[] yCoords = {70,20,70};
		g.fillPolygon(
			xCoords, 
			yCoords, 
			xCoords.length);
		
		//Rand des Polygons
		g.setColor(Color.BLACK);
		g.drawPolygon(
			xCoords, 
			yCoords, 
			xCoords.length);
		
		//Kreis- bzw. Kreisbogen zeichnen
		g.setColor(
			new Color(255, 255, 0));
		g.fillArc(
			220, 20, 100, 100, 45, 200);
		
		//Rand des Kreises zeichnen
		g.setColor(
			Color.BLACK);
		g.drawArc(
			220, 20, 100, 100, 0, 360);
		
		//Oval zeichnen
		g.drawOval(
			370, 20, 100, 150);
		
		g.drawArc(300, 300, 15, 150, -90, 180);
		g.drawLine(307, 300, 320, 300);
		g.drawLine(307, 450, 320, 450);
		g.drawLine(320, 300, 320, 450);
	}
	
}
