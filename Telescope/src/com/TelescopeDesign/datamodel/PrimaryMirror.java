package com.TelescopeDesign.datamodel;

import java.util.ArrayList;
import java.util.Hashtable;

public class PrimaryMirror extends PartModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double _diameter;
	private double _radius;
	private double _thickness;
	private double _focalLength;
	private double _x;
	private double _y;	
	
	public PrimaryMirror()
	{
		_diameter = 6;
		_radius = 10;
		_thickness = 20;
		_focalLength = 0.0;	
		_x = 200;
		_y = 100;
		
		_tableHeader = new ArrayList<String>();
		_tableHeader.add("Primary Mirror");
		_tableHeader.add("");		
			
		_propertyNames.add("Diameter [mm]"); 
		_propertyValues.add(_diameter);	
		
		_propertyNames.add("Radius [mm]");
		_propertyValues.add(_radius);
		
		_propertyNames.add("Thickness [mm]");
		_propertyValues.add(_thickness);
		
		_propertyNames.add("Focal lenght [mm]");
		_propertyValues.add(_focalLength);
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

	@Override
	public String toString()
	{
		return "Primary Mirror";
				
	}
}
