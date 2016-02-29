package com.TelescopeDesign.telescopes;

public class Tube {

	Double _thickness;
	Double _length;
	Double _diaInside;
	Double _diaOutside;
	
	/**
	 * Creates a tubus which is defined by diameter inside, outside and its´s length
	 * @param diaInside
	 * @param diaOutside
	 * @param length
	 */
	public Tube(Double diaInside, Double diaOutside, Double length) 
	{ 
		this._diaInside= diaInside;
		this._diaOutside= diaOutside;
		this._length = length;
		
		this._thickness  = (diaOutside-diaInside)/2;		
	}

	public Double get_thickness() {
		return _thickness;
	}

	public void set_thickness(Double _thickness) {
		this._thickness = _thickness;
	}

	public Double get_length() {
		return _length;
	}

	public void set_length(Double _length) {
		this._length = _length;
	}

	public Double get_diaInside() {
		return _diaInside;
	}

	public void set_diaInside(Double _diaInside) {
		this._diaInside = _diaInside;
	}

	public Double get_diaOutside() {
		return _diaOutside;
	}

	public void set_diaOutside(Double _diaOutside) {
		this._diaOutside = _diaOutside;
	}
	
	
}
