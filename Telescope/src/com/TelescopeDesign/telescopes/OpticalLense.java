package com.TelescopeDesign.telescopes;

public class OpticalLense {
	
	public double _diameter;
	public double _radius;
	
	
	public OpticalLense(double d, double r)
	{
		_diameter = d;
		_radius = r;
	}


	public double get_diameter() {
		return _diameter;
	}


	public void set_diameter(double _diameter) {
		this._diameter = _diameter;
	}


	public double get_radius() {
		return _radius;
	}


	public void set_radius(double _radius) {
		this._radius = _radius;
	}

	
	
}
