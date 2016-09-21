package com.TelescopeDesign.datamodel;

import java.util.EnumSet;

import com.TelescopeDesign.types.Parameter;
import com.TelescopeDesign.types.Property;
import com.TelescopeDesign.types.Reference;

/**
 * Model that describes a concave mirror defined by thickness, radius and diameter  
 */
public class PrimaryMirror extends PartModel{
	
	
	private static final long serialVersionUID = 1L;
	private String _partName;
	private double _diameter;
	private double _radius;
	private double _thickness;
	private double _focalLength;
	
	public enum ReferencePoint{BACKSIDE_BOTTOM, MIRROR_CENTER, MIRROR_TOP}; 
			
	public PrimaryMirror()
	{		
		_partName = "Primary Mirror";
		_diameter = 200;
		_radius = 100;
		_thickness = 30;
		_focalLength = 1500.0;	

		_tableHeader.add(_partName);
		_tableHeader.add("");		

		_property.add(new Property(Parameter.DIAMETER,"Diameter [mm]", _diameter));
		_property.add(new Property(Parameter.RADIUS, "Radius [mm]", _radius));
		_property.add(new Property(Parameter.THICKNESS, "Thickness [mm]", _thickness));
		_property.add(new Property(Parameter.FOCAL_LENGTH,"Focal length [mm]", _focalLength));		
		
		setBaseReferencePoint(ReferencePoint.MIRROR_CENTER);
		_refGraph.add(new Reference(ReferencePoint.BACKSIDE_BOTTOM, ReferencePoint.MIRROR_CENTER,0.0 ,_diameter/2));
		_refGraph.add(new Reference(ReferencePoint.BACKSIDE_BOTTOM, ReferencePoint.MIRROR_TOP, _thickness , _diameter));
	}

	@Override
	public String toString()
	{
		return _partName;				
	}	

}
