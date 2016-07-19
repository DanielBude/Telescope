package com.TelescopeDesign.blueprint;

import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

import com.TelescopeDesign.converter.Converter;
import com.TelescopeDesign.datamodel.PartModel;
import com.TelescopeDesign.types.Parameter;

public class RealisticPrimaryMirrorPrint extends Area{
	Converter _converter;
	double _diameter;
	double _thickness;	
	double _radius;
	double _hight;
	double _width;
	double _xRef;
	double _yRef;
	
	public RealisticPrimaryMirrorPrint(OpticalAxis optAxis, PartModel data, Converter conv){
		
		 _converter = conv;	
		 
		 _diameter= data.getPropertyValue(Parameter.DIAMETER);
		 _thickness = data.getPropertyValue(Parameter.THICKNESS);
		 _radius = data.getPropertyValue(Parameter.RADIUS);
	
		
		 _width = 0;
		 _hight = _diameter/2;
		 
		 
		 _xRef = - convertPhysicalData(_radius);
		 _yRef = optAxis.getY1();
		 
		createObject();
		
	}

	private void createObject()
	{
	
		 double _alpha = 2*Math.atan((_diameter/2)/_radius)*180/Math.PI;
		 
		 Arc2D.Float arc = new Arc2D.Float(Arc2D.OPEN);
		 arc.setArc(_xRef, _yRef - convertPhysicalData(_radius), 2*convertPhysicalData(_radius),  2*convertPhysicalData(_radius), -_alpha/2, _alpha, Arc2D.OPEN);
		
		 Rectangle2D rec = new Rectangle2D.Double(55,_yRef-convertPhysicalData(_diameter)/2, convertPhysicalData(_thickness), convertPhysicalData(_diameter));
		 		
		 this.add(new Area(rec));
	     this.subtract(new Area(arc));
		
	}

	/**
	 * sets the position of the mirror  
	 * @param x [mm]
	 * @param offset [mm]
	 */	
	
	public void setReference(double x, double y) {		
		_yRef  = y - convertPhysicalData(_radius);
		_xRef  = _converter.getScreenResolution()*x;		
	}
		

	private double convertPhysicalData(double value)
	{
		return  _converter.getScaleFactor()*value;
	}

}
