package com.TelescopeDesign.telescopes;

public class PrimaryMirror {
	
	private double _diameter;
	private double _radius;
	private double _x;
	private double _y;
	
	
	public PrimaryMirror()
	{
		_diameter = 6;
		_radius = 10;
		_x = 200;
		_y = 100;
	}


	public double getDiameter() {
		return _diameter;
	}


	public void setDiameter(double _diameter) {
		this._diameter = _diameter;
	}


	public double getRadius() {
		return _radius;
	}


	public void setRadius(double _radius) {
		this._radius = _radius;
	}


	public double get_x() {
		return _x;
	}


	public void set_x(double _x) {
		this._x = _x;
	}


	public double get_y() {
		return _y;
	}


	public void set_y(double _y) {
		this._y = _y;
	}

	
	
}
