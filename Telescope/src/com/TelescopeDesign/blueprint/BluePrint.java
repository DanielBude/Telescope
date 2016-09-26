package com.TelescopeDesign.blueprint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

import com.TelescopeDesign.telescopes.TelescopeModel;
import com.TelescopeDesign.types.Reference;
import com.TelescopeDesign.types.TelescopeParts;
import com.TelescopeDesign.converter.Converter;
import com.TelescopeDesign.datamodel.PartModel;
import com.TelescopeDesign.datamodel.PrimaryMirror;
import com.TelescopeDesign.datamodel.SecondaryMirror;
import com.TelescopeDesign.datamodel.Tube;
import com.TelescopeDesign.datamodel.Tube.ReferencePoint;

public class BluePrint extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5477941012007016953L;
	
	private TelescopeModel _dataModel;
	private Converter _physicalToGrapic;
	private OpticalAxis _opticalAxis;
	private TubePrint _tube;
	private PrimaryMirrorPrint _primMirror;
	private SecondaryMirrorPrint _secMirror;
	
	private Double _border = 10.0; //mm
	DecimalFormat _df2 = new DecimalFormat( "#,###,###,##0.0" );
	
	HashMap<Enum<?>, Enum<?>> _graphicalLink;
	
	public enum GraphicReference {ORIGIN};
		
	public BluePrint(TelescopeModel model)
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
		Point _origin = new Point();
				
		// set Origin 
		Integer _originX = (int) (this.getWidth() - _physicalToGrapic.getScreenResolution()*_border);
		Integer _originY = (int) (this.getHeight()/2);	
		_origin.setLocation(_originX, _originY);
		
		_opticalAxis = new OpticalAxis(this);
				
		_tube = new TubePrint(_dataModel.getPartModel(TelescopeParts.TUBE), _physicalToGrapic);
		_tube.setPosition(_dataModel.getPartModel(TelescopeParts.TUBE).getBaseReferencePoint(), _origin);
		//_tube.setReference(tube2Origin);
		_tube.updateData();			
				
		
		_primMirror = new PrimaryMirrorPrint(_dataModel.getPartModel(TelescopeParts.PRIMARY_MIRROR), _physicalToGrapic);
		Reference tube2Primary =_dataModel.getReference(Tube.ReferencePoint.BACK, PrimaryMirror.ReferencePoint.MIRROR_CENTER);		
		_primMirror.setOrigin(_tube.getPosition(Tube.ReferencePoint.BACK));		
		_primMirror.setReference(tube2Primary);				
		_primMirror.updateData();		
		
		_secMirror = new SecondaryMirrorPrint(_dataModel.getPartModel(TelescopeParts.SECONDARY_MIRROR), _physicalToGrapic);
		Reference primary2Secondary =_dataModel.getReference(PrimaryMirror.ReferencePoint.MIRROR_CENTER, SecondaryMirror.ReferencePoint.MIRROR_CENTER);
		_secMirror.setOrigin(_primMirror.getPosition(PrimaryMirror.ReferencePoint.MIRROR_CENTER));
		_secMirror.setReference(primary2Secondary);
		_secMirror.updateData();
		
		
	
		//draw realistic primary mirror
		g2d.setColor(Color.WHITE);
		//g2d.setStroke(new BasicStroke(3,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL));
		RealisticPrimaryMirrorPrint _realPrimary  = new RealisticPrimaryMirrorPrint(_opticalAxis , _dataModel.getPartModel(TelescopeParts.PRIMARY_MIRROR), _physicalToGrapic);
		//_realPrimary.setReference(100, _opticalAxis.getY1());
		g2d.draw(_realPrimary);		
				
		//draw optical axis
		g2d.setColor(Color.WHITE);
		g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 0, new float[]{20,20,3,20}, 0));
		g2d.draw(_opticalAxis);
		
		//draw tube
		g2d.setStroke(new BasicStroke(3,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL));
		g2d.draw(_tube);
				
		//draw primary mirror
		g2d.setStroke(new BasicStroke(3,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL));
		g2d.draw(_primMirror);			
		
		//draw secondary mirror			
//		g2d.shear(1, 0);
		g2d.setStroke(new BasicStroke(3,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL));
		g2d.draw(_secMirror);		
//		g2d.shear(-1, 0);
		
		//print Origin
		g2d.setColor(Color.RED);		
		g2d.setStroke(new BasicStroke(2,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL));
		g2d.draw(new Line2D.Double(_originX-5, _originY, _originX+5, _originY));
		g2d.draw(new Line2D.Double(_originX, _originY-5, _originX, _originY+5));
		
		
		//write Scale Label
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("Arial", Font.ITALIC, 20));		
		
		g.drawString("Scale 1 : "+ _df2.format(_physicalToGrapic.getScale()), 20, getHeight()-20);		
		repaint();
	}	
	
	

}
