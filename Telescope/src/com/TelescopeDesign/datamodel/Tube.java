package com.TelescopeDesign.datamodel;

import java.util.ArrayList;
import java.util.Hashtable;


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
		_tableHeader = new ArrayList<String>();
		_tableHeader.add("Tube");
		_tableHeader.add("");
		
		_propertyNames.add("Diameter inside [mm]"); 
		_propertyValues.add(diaInside);	
		
		_propertyNames.add("Diameter outside [mm]");
		_propertyValues.add(diaOutside);
		
		_propertyNames.add("length [mm]");
		_propertyValues.add(length);		
	}	

	
	@Override
	public String toString()
	{
		return "Tube";				
	}
}

