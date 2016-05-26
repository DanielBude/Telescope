package com.TelescopeDesign.blueprint;

import java.awt.geom.Rectangle2D;

import com.TelescopeDesign.converter.Converter;
import com.TelescopeDesign.datamodel.PartModel;
import com.TelescopeDesign.types.Parameter;

public class SecondaryMirrorPrint extends Rectangle2D{

	Converter _converter;
	double _diameter;
	double _thickness;
	
	double _hight;
	double _width;
	double _xRef;
	double _yRef;
	
	
	public SecondaryMirrorPrint(PartModel data, Converter conv)
	{
		
		
	 _xRef = 0;
	 _yRef = 0;
	 _hight = 0;
	 _width = 0;	
	 
	 _converter = conv;
	 
	 
	 _diameter= data.getPropertyValue(Parameter.DIAMETER);
	 _thickness = data.getPropertyValue(Parameter.THICKNESS);
	 	 
	}
	
	@Override
	public Rectangle2D createIntersection(Rectangle2D arg0) {
		
		return null;
	}
	@Override
	public Rectangle2D createUnion(Rectangle2D arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int outcode(double arg0, double arg1) {
				return 0;
	}

	@Override
	public void setRect(double x, double y, double w, double h) {
		_xRef = x;
		_yRef = y;
		_width=  w;
		_hight = h;		
	}

	@Override
	public double getHeight() {		
		return _hight;
	}

	@Override
	public double getWidth() {		
		return _width;
	}

	@Override
	public double getX() {	
		return _xRef;
	}

	@Override
	public double getY() {	
		return _yRef;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public void updateData()
	{
		_hight = convertPhysicalData(_diameter);
		_width = convertPhysicalData(_thickness);
	}


	public void setReference(double x, double offset) {		
		_yRef  = convertPhysicalData(offset) - _hight/2;
		_xRef  = x;		
	}
	
	private double convertPhysicalData(double value)
	{
		return  _converter.getScaleFactor()*value;
	}
}
