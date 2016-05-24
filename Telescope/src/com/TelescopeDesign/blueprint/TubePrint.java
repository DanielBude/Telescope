package com.TelescopeDesign.blueprint;

import java.awt.geom.Rectangle2D;
import com.TelescopeDesign.converter.Converter;
import com.TelescopeDesign.datamodel.PartModel;
import com.TelescopeDesign.types.Parameter;

public class TubePrint extends Rectangle2D{
	Converter _converter;
	double _diaInside;
	double _diaOutside;
	double _length;
	double _hight;
	double _width;
	double _xRef;
	double _yRef;
	double _x;
	double _y;
	
	public TubePrint(PartModel data, Converter conv)
	{
	_converter = conv;
	 _x = 0;
	 _y = 0;	
	
	 _diaInside = data.getPropertyValue(Parameter.DIAMETER_INSIDE);
	 _diaOutside = data.getPropertyValue(Parameter.DIAMETER_OUTSIDE);
	 _length = data.getPropertyValue(Parameter.LENGTH);
	}
	
	@Override
	public Rectangle2D createIntersection(Rectangle2D arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle2D createUnion(Rectangle2D arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int outcode(double arg0, double arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRect(double x, double y, double w, double h) {
		_x = x;
		_y = y;
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
		return _yRef - _hight/2;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void updateData()
	{
		_hight = convertPhysicalData(_diaOutside);
		_width = convertPhysicalData(_length);
	}

	public void setReference(double x, double y) {		
		_yRef  = y;
		_xRef  = _converter.getScreenResolution()*x;		
	}
	
	private double convertPhysicalData(double value)
	{
		return  _converter.getScaleFactor()*value;
	}
}
