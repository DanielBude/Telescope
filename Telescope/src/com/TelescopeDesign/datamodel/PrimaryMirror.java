package com.TelescopeDesign.datamodel;

import com.TelescopeDesign.types.Parameter;
import com.TelescopeDesign.types.Property;

public class PrimaryMirror extends PartModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private String _partName;
	private double _diameter;
	private double _radius;
	private double _thickness;
	private double _focalLength;
	
	public PrimaryMirror()
	{		
		_partName = "Primary Mirror";
		_diameter = 6;
		_radius = 10;
		_thickness = 20;
		_focalLength = 0.0;	

		_tableHeader.add(_partName);
		_tableHeader.add("");		

		_property.add(new Property(Parameter.DIAMETER,"Diameter [mm]", _diameter));
		_property.add(new Property(Parameter.RADIUS, "Radius [mm]", _radius));
		_property.add(new Property(Parameter.THICKNESS, "Thickness [mm]", _thickness));
		_property.add(new Property(Parameter.FOCAL_LENGTH,"Focal length [mm]", _focalLength));		
	}

	@Override
	public String toString()
	{
		return _partName;				
	}	
}
