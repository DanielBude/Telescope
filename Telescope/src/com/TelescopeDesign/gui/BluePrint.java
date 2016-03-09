package com.TelescopeDesign.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.IndexColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JScrollPane;



public class BluePrint extends JPanel {

	Image image;
	// Hier sollten die Entsprechenden Objekte gespeichert sein
	PrimaryMirrorVisualModel priMirror = new PrimaryMirrorVisualModel();
	
	public BluePrint()
	{
		repaint();
		//Define Backgroudcolor
		setBackground(Color.WHITE);
	}
	
	public void initializeBackground() {
        
        String imgPfad = "blueprint.jpg";
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        image = toolkit.getImage(imgPfad);
	}
	
	public void paintComponent(Graphics g){
		//Überschreiben des alten Bildes
		super.paintComponent(g);
		// Hintergrund zeichnen
		initializeBackground();
	    if (image != null)
	    	g.drawImage(image, 0, 0, this);
		priMirror.paintComponent(g);
		
	

	}
}
