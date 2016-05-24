package com.TelescopeDesign.blueprint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.text.DecimalFormat;

import javax.swing.JPanel;

import com.TelescopeDesign.telescopes.TelescopeModel;
import com.TelescopeDesign.types.TelescopeParts;
import com.TelescopeDesign.converter.Converter;

public class NewBluePrint extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5477941012007016953L;
	
	private TelescopeModel _dataModel;
	Converter _physicalToGrapic;
	OpticalAxis _opticalAxis, _opticalSecMirrorAxis;
	TubePrint _tube;
	SecondaryMirrorPrint _secMirror;
	
	DecimalFormat _df2 = new DecimalFormat( "#,###,###,##0.0" );
	
	
	public NewBluePrint(TelescopeModel model)
	{
		_dataModel = model;
		_physicalToGrapic = new Converter(this,_dataModel);
		Color background = new Color(38,104,215);			
		setBackground(background);		
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);	
		Graphics2D g2d = (Graphics2D) g; 	
				
		_opticalAxis = new OpticalAxis(this);
		_opticalSecMirrorAxis = new OpticalAxis(this);
		
		_tube = new TubePrint(_dataModel.getPartModel(TelescopeParts.TUBE));
		_tube.setReference( 50, _opticalAxis.getY1());
		
		_secMirror = new SecondaryMirrorPrint();
		_secMirror.setReference(20,  _opticalAxis.getY1() - 5);
		
		//draw optical axis
		g2d.setColor(Color.WHITE);
		g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 0, new float[]{20,20,3,20}, 0));
		g2d.draw(_opticalAxis);
		
		//draw tube
		g2d.setStroke(new BasicStroke(3,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL));
		g2d.draw(_tube);
		
		//draw secondary mirror			
		g2d.shear(1, 0);
		g2d.setStroke(new BasicStroke(3,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL));
		g2d.draw(_secMirror);		
		g2d.shear(-1, 0);
		
		//write Scale Label
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("Arial", Font.ITALIC, 20));
		
		
		g.drawString("Scale 1 : "+ _df2.format(_physicalToGrapic.getScale()), 20, getHeight()-20);		
		repaint();
	}	
	
	

}
