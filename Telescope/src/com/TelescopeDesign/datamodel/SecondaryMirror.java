package com.TelescopeDesign.datamodel;

import com.TelescopeDesign.types.Parameter;
import com.TelescopeDesign.types.Property;

public class SecondaryMirror extends PartModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double _diameter;
	private double _thickness;
	private double _offset;

	public SecondaryMirror()
	{
		_partName = "Secondary Mirror";		
		_thickness = 20.0;
		_diameter = 30.0;
		_offset = 0.0;
		
		_tableHeader.add(_partName);
		_tableHeader.add("");

		_property.add(new Property(Parameter.DIAMETER,"Diameter [mm]", _diameter));
		_property.add(new Property(Parameter.THICKNESS,"Thickness [mm]", _thickness));
		_property.add(new Property(Parameter.OFFSET,"Offset [mm]", _offset));
	}
	
	@Override
	public String toString()
	{
		return _partName;				
	}

}
