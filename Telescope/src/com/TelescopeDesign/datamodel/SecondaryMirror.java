package com.TelescopeDesign.datamodel;

import com.TelescopeDesign.types.Property;

public class SecondaryMirror extends PartModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double _radius;
	private double _offset;

	public SecondaryMirror()
	{
		_partName = "Secondary Mirror";
		_radius = 4.0;
		_offset = 0.0;
		
		_tableHeader.add(_partName);
		_tableHeader.add("");

		_property.add(new Property("Radius [mm]", _radius));
		_property.add(new Property("Offset [mm]", _offset));
	}
	
	@Override
	public String toString()
	{
		return _partName;				
	}
	
}
