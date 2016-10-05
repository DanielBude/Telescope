package com.TelescopeDesign.icons;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.image.BufferedImage;
import java.io.File;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Construction extends JPanel {

	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g)
	    {
			super.paintComponent(g);
			this.setPreferredSize(new Dimension(100,getWidth()));
					   
			g.setFont(new Font ("Arial", Font.BOLD, 14));
						
			Label title = new Label("Construction");
			title.setFont(new Font ("Arial", Font.BOLD, 14));
			add(title);	   
			setAlignmentX(CENTER_ALIGNMENT);
			
			g.drawImage(ImagePanel().getScaledInstance(getWidth(), getWidth(), Image.SCALE_SMOOTH ),0,30,null);	     	     
	    }		

	    private BufferedImage image;

	    public BufferedImage ImagePanel() {
	       try {                
	          image = ImageIO.read(new File(".\\icons\\Construction.jpg"));
	          System.out.println("Image wurde gefunden");
	       } catch (IOException ex) {
	            //throw new FileNotFoundException("Image has not been found");
	    	   System.out.println("Image wurde nicht gefunden");
	       }
	       
	       return image;
	    }
	    
}
