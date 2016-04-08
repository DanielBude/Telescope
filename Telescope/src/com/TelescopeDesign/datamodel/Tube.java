package com.TelescopeDesign.datamodel;

import com.TelescopeDesign.types.Property;

public class Tube extends PartModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
			
		_property.add(new Property("Diameter inside [mm]", diaInside));
		_property.add(new Property("Diameter outside [mm]", diaOutside));
		_property.add(new Property("Length [mm]", length));		
	}	

	
	@Override
	public String toString()
	{
		return "Tube";				
	}
}

