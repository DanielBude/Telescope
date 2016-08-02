package com.TelescopeDesign.types;

public class Reference {

	Double _x;
	Double _y;
	Enum<?> _pointA;
	Enum<?> _pointB;
	
	public Reference(Enum<?> a, Enum<?> b, double x,double y)
	{
		_x = x;
		_y = y;
		_pointA = a;
		_pointB = b;		
	}
	
	public Double getDistanceX()
	{
		return _x;
	}
	
	public Double getDistanceY()
	{
		return _y;
	}
	
	public Enum<?> getStartPoint()
	{
		return _pointA;
	}
	
	public Enum<?> getEndPoint()
	{
		return _pointB;
	}
}
