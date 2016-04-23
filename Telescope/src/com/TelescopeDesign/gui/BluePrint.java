package com.TelescopeDesign.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;



public class BluePrint extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8027511465149622621L;
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
