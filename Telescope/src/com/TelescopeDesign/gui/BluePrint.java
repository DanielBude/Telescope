package com.TelescopeDesign.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;



public class BluePrint extends JPanel{

	// Hier sollten die Entsprechenden Objekte gespeichert sein
	PrimaryMirrorVisualModel priMirror = new PrimaryMirrorVisualModel();
	
	public BluePrint()
	{
		repaint();
		//Define Backgroudcolor
		setBackground(Color.BLUE);
	}
	
	public void paintComponent(Graphics g){
		//Überschreiben des alten Bildes
		super.paintComponent(g);
		priMirror.paintComponent(g);
	

	}
	
}
