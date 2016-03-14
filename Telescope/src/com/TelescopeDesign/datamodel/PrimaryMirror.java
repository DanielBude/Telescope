package com.TelescopeDesign.datamodel;

import java.util.ArrayList;
import java.util.Hashtable;

public class PrimaryMirror extends DataObject{
	
	private double _diameter;
	private double _radius;
	private double _thickness;
	private double _focalLength;
	private double _x;
	private double _y;
	
    private ArrayList<String> _header;
	private Hashtable<String, Double> _properties;
	
	
	public PrimaryMirror()
	{
		_diameter = 6;
		_radius = 10;
		_thickness = 20;
		_focalLength = 0.0;
		_x = 200;
		_y = 100;
		
		_header = new ArrayList<String>();
		_header.add("Primary Mirror");
		_header.add("");
		
		_properties = new Hashtable<String, Double>();				
		_properties.put("Diameter [mm]", _diameter);
		_properties.put("Radius [mm]", _radius);
		_properties.put("Thickness [mm]", _thickness);
		_properties.put("Focal lenght [mm]", _focalLength);
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
	public Hashtable<String, Double> getData() {		
		return _properties;
	}

	@Override
	public ArrayList<String> getHeader() {
		return _header;
	}

	
	
}
