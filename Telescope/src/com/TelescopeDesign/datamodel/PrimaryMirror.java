package com.TelescopeDesign.datamodel;

import java.util.ArrayList;
import java.util.Hashtable;

public class PrimaryMirror extends DataObject {

    private ArrayList<String> _header;
	private Hashtable<String, Double> _properties;
	
	/**
	 * Creates a tubus which is defined by diameter and the radius
	 * @param diameter
	 * @param radius
	 */
	public PrimaryMirror (Double diameter, Double radius) 
	{	_header = new ArrayList<String>();
		_header.add("Primary Mirror Properties");
		_header.add("");
		
		_properties = new Hashtable<String, Double>();				
		_properties.put("Diameter [mm]", diameter);
		_properties.put("Radius   [mm]", radius);
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
