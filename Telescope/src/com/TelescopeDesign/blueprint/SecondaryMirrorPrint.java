package com.TelescopeDesign.blueprint;

import java.awt.geom.Rectangle2D;

public class SecondaryMirrorPrint extends Rectangle2D{

	double _hight;
	double _width;
	double _x;
	double _y;
	
	
	public SecondaryMirrorPrint()
	{
	 _x = 0;
	 _y = 0;
	 
	 _hight = 55;
	 _width = 20;
	 	 
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
		return _x;
	}

	@Override
	public double getY() {	
		return _y;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return true;
	}


	public void setReference(double x, double y) {
		
		_y  = y - _hight/2;
		_x  = x;		
	}
}
