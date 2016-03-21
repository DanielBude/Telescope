package com.TelescopeDesign.gui;

import java.awt.Graphics;

import javax.swing.*;

import com.TelescopeDesign.datamodel.PropertiesModel;

public class TelescopePrinting extends JPanel
{
	PrimaryMirrorVisualModel _priMirror = new PrimaryMirrorVisualModel();
	
	
	  @Override
	  protected void paintComponent( Graphics g )
	  {
	    super.paintComponent( g );
	    //g.drawLine( 10, 10, 100, 50 );
	    g.drawString("Na du alter Sack!", 50, 50);
	  }
	  public void updateData(PropertiesModel mod){
		  // make calculations for painting
		  
//		  mod.getPart(TelescopePart.Tube).;
//		  mod.getPart()
	  }
	  
	  public void refresh(){
		  
	  }

}
