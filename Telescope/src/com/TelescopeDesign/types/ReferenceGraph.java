package com.TelescopeDesign.types;

import java.util.ArrayList;

/**
 * @author Michael
 *
 */
public class ReferenceGraph extends ArrayList<Reference> {

	private static final long serialVersionUID = 1L;
	
	ArrayList<Enum<?>> _points;
	Enum<?> _baseReferencePoint;
	
	public ReferenceGraph()
	{
		
	}
	
	public ArrayList<Enum<?>> getReferencePoints()
	{
		return _points;
	}	
	
	/**
	 * adds new reference points to the list and their references to each other
	 * 
	 * @param ref
	 */
	public void addRefernce(Reference ref) 
	{		
		this.add(ref);
		
		if(!_points.contains(ref.getStartPoint()))
			_points.add(ref.getStartPoint());	
		
		if(!_points.contains(ref.getEndPoint()))
			_points.add(ref.getEndPoint());		
	}
	
	public void addReferencePoint(Enum<?> point)
	{
		if(!_points.contains(point))
			_points.add(point);
	}
	
	public Enum<?> getBaseReferencePoint()
	{
		return _baseReferencePoint;
	}
	
	public void setBaseReferencePoint(Enum<?> base)
	{
		_baseReferencePoint = base;
	}
}
