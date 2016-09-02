package com.TelescopeDesign.datamodel;

import java.util.EnumSet;

import com.TelescopeDesign.types.Parameter;
import com.TelescopeDesign.types.Property;
import com.TelescopeDesign.converter.IConvertable;

public class Tube extends PartModel implements IConvertable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	EnumSet<Parameter> _parameterSet;
	
	public enum ReferencePoint{BACK, FRONT}; 
			
	/**
	 * Creates a tubus which is defined by diameter inside, outside and its´s length
	 * @param diaInside
	 * @param diaOutside
	 * @param length
	 */
	public Tube (Double diaInside, Double diaOutside, Double length) 
	{		
		_partName = "Tube";
		_tableHeader.add(_partName);
		_tableHeader.add("");
		
		_parameterSet = EnumSet.of(Parameter.DIAMETER_INSIDE, Parameter.DIAMETER_OUTSIDE, Parameter.LENGTH);
					
		_property.add(new Property(Parameter.DIAMETER_INSIDE, "Diameter inside [mm]", diaInside));
		_property.add(new Property(Parameter.DIAMETER_OUTSIDE,"Diameter outside [mm]", diaOutside));
		_property.add(new Property(Parameter.LENGTH,"Length [mm]", length));		
		
		setBaseReferencePoint(ReferencePoint.BACK);
	}	
	
	@Override
	public String toString()
	{
		return "Tube";				
	}

	@Override
	public EnumSet<Parameter> getParameters() {
		return _parameterSet;
	}

	@Override
	public Double getHeight() {
		
		for(Property prop: _property)
		{
			if(prop.getKey().equals(Parameter.DIAMETER_OUTSIDE))
				return prop.getValue();
		}
		return null;
	}

	@Override
	public Double getWidth() {
		
		for(Property prop: _property)
		{
			if(prop.getKey().equals(Parameter.LENGTH))
				return prop.getValue();
		}
		return null;
	}
}

