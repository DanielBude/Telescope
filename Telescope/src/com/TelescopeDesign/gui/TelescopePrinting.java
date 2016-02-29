package com.TelescopeDesign.gui;

import java.awt.Graphics;

import javax.swing.*;

public class TelescopePrinting extends JPanel
{

	  @Override
	  protected void paintComponent( Graphics g )
	  {
	    super.paintComponent( g );
	    g.drawLine( 10, 10, 100, 50 );
	    g.drawString("Na du alter Sack!", 50, 50);
	  }

}
