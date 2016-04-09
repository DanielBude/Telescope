package com.TelescopeDesign.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;



public class BluePrint extends JPanel{

	// Hier sollten die Entsprechenden Objekte gespeichert sein
	PrimaryMirrorVisualModel priMirror = new PrimaryMirrorVisualModel();
	
	public BluePrint()
	{
		repaint();
		//Define Backgroudcolor
		Color background = new Color(38,104,215);
		setBackground(background);

	}
	
	public void paintComponent(Graphics g){
		//Überschreiben des alten Bildes
		super.paintComponent(g);
		priMirror.paintComponent(g);
	

	}
	
}
