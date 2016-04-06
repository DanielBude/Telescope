package com.TelescopeDesign.datamodel;

import java.util.ArrayList;

public class SecondaryMirror extends PartModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double _radius;
	private double _offset;

	public SecondaryMirror()
	{
		_radius = 4.0;
		_offset = 0.0;
		
		_tableHeader = new ArrayList<String>();
		_tableHeader.add("Secondary Mirror");
		_tableHeader.add("");
		
		_propertyNames.add("Radius [mm]"); 
		_propertyValues.add(_radius);	
		
		_propertyNames.add("Offset [mm]");
		_propertyValues.add(_offset);		
	}

	public double getRadius() {
		return _radius;
	}

	public void setRadius(double _radius) {
		this._radius = _radius;
	}

	public double getOffset() {
		return _offset;
	}

	public void setOffset(double _offset) {
		this._offset = _offset;
	}
	
	@Override
	public String toString()
	{
		return "Secondary Mirror";				
	}
	
}
