package com.TelescopeDesign.telescopes;

public class SecondaryMirror {
	
	private double _radius;
	private double _offset;

	public SecondaryMirror()
	{
		_radius = 4;
		_offset = 0;
	}

	public double getRadius() {
		return _radius;
	}

	public void setRadius(double _radius) {
		this._radius = _radius;
	}

	public double getOffset() {
		return _offset;
	}

	public void setOffset(double _offset) {
		this._offset = _offset;
	}
	
}
