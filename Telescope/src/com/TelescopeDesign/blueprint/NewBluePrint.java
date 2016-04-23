package com.TelescopeDesign.blueprint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import com.TelescopeDesign.telescopes.TelescopeModel;
import com.TelescopeDesign.types.TelescopeParts;

public class NewBluePrint extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5477941012007016953L;
	
	TelescopeModel _dataModel;
	Double _scaleFactor;
	OpticalAxis _opticalAxis;
	TubePrint _tube;
	
	public NewBluePrint(TelescopeModel model)
	{
		_dataModel = model;
		Color background = new Color(38,104,215);			
		setBackground(background);		
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);	
		Graphics2D g2d = (Graphics2D) g; 	
		_opticalAxis = new OpticalAxis(this);
		_tube = new TubePrint();
		_tube.setReference( 50, _opticalAxis.getY1());
		
		g2d.setColor(Color.WHITE);
		g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 0, new float[]{20,20,3,20}, 0));
		g2d.draw(_opticalAxis);
		
		g2d.setStroke(new BasicStroke(3,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL));
		g2d.draw(_tube);
		
		repaint();
	}	
	
	private void calculateScaleFactor()
	{
		_scaleFactor =  0.0;
	}
	
	private Double getTotalWidth()
	{		
		return 0.0;
	}
	
	private Double getTotalHight()
	{		
		return 0.0;
	}
	
}
