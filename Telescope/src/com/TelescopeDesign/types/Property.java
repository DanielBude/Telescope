package com.TelescopeDesign.types;

public class Property {

	String _propertyName;
	Double _propertyValue;
	
	public Property(String name, Double value)
	{
		_propertyName = name;
		_propertyValue = value;
	}
	
	public Double getValue()
	{
		return _propertyValue;
	}
	
	public String getName()
	{
		return _propertyName;
	}
	
	public void setValue(Double value)
	{
		_propertyValue = value;
	}
	
	public void setName(String value)
	{
		_propertyName = value;
	}
	
	
}
