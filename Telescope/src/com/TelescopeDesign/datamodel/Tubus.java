package com.TelescopeDesign.datamodel;

import java.util.ArrayList;
import java.util.Hashtable;


public class Tubus extends DataObject {

    private ArrayList<String> _header;
	private Hashtable<String, Double> _properties;
	
	/**
	 * Creates a tubus which is defined by diameter inside, outside and its´s length
	 * @param diaInside
	 * @param diaOutside
	 * @param length
	 */
	public Tubus (Double diaInside, Double diaOutside, Double length) 
	{	_header = new ArrayList<String>();
		_header.add("Tubus");		
		
		_properties = new Hashtable<String, Double>();				
		_properties.put("Diameter inside [mm]", diaInside);
		_properties.put("Diameter outside [mm]", diaOutside);
		_properties.put("length [mm]", length);
	}	


	@Override
	public Hashtable<String, Double> getData() {
		// TODO Auto-generated method stub
		return _properties;
	}

	@Override
	public ArrayList<String> getHeader() {
		return _header;
	}
}

