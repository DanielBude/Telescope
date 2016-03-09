package com.TelescopeDesign.datamodel;

import java.util.ArrayList;
import java.util.Hashtable;

	public class SecondaryMirror extends DataObject {

	    private ArrayList<String> _header;
		private Hashtable<String, Double> _properties;
		
		/**
		 * Creates a mirror which is defined by diameter and the angle
		 * @param diameter
		 * @param angle
		 */
		public SecondaryMirror (Double diameter, Double angle) 
		{	_header = new ArrayList<String>();
			_header.add("Secondary Mirror Properties");
			_header.add("");
			
			_properties = new Hashtable<String, Double>();				
			_properties.put("Diameter [mm]", diameter);
			_properties.put("Angle [°]", angle);
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
