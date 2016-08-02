package com.TelescopeDesign.datamodel;

import java.util.ArrayList;
import java.util.EnumSet;

import javax.swing.table.AbstractTableModel;
import com.TelescopeDesign.types.*;


public class PartModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	ArrayList<String> _tableHeader;	
	String _partName;
	EnumSet<Parameter> _parameterSet;
	ReferenceGraph _refGraph;
	ArrayList<Enum<?>> _referencePoints;
	ArrayList<Reference> _reference;
	ArrayList<Property> _property;	
	
	
	
	public PartModel(){		
		
		  _tableHeader = new ArrayList<String>();
		  _property = new ArrayList<Property>();
		  _reference = new ArrayList<Reference>();
		  _refGraph = new ReferenceGraph();
	}
		
	@Override
	public int getRowCount() {
		return _property.size();		
	}
		
	@Override
	public int getColumnCount() {
		return 2;
	}
		
	@Override
	public String getColumnName(int columnIndex) {
		return  _tableHeader.get(columnIndex);		
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {			
		return getValueAt(0,columnIndex).getClass();			
	}
		
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if(columnIndex == 1)
			return true;
		else
			return false;	
	}
		
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {	
		
		if(columnIndex == 0)
			return _property.get(rowIndex).getName();
		else
			return _property.get(rowIndex).getValue();	
	}
		
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		
		if(columnIndex == 0)
			 _property.get(rowIndex).setName((String) aValue);	
		else
			 _property.get(rowIndex).setValue((Double) aValue);
		fireTableDataChanged();			
	}		
		
	@Override
	public String toString(){
		return "Part Name";			
	}		
		
	/**
	 * returns all properties of the part
	 * 
	 * @return 
	 */
	public ArrayList<Property> getProperties()
	{
		return _property;
	}
	
	/**
	 * returns all parameters of the part
	 * @return
	 */
	public EnumSet<Parameter> getParameters() {
		
		for(int i =0; i<_property.size(); i++)
		{
			_parameterSet.add(_property.get(i).getKey());
		}	
		
		return _parameterSet;
	}
	
	/**
	 * returns the value of the specified key
	 * 
	 * @param key
	 * @return 
	 */
	public Double getPropertyValue(Parameter key)
	{		
		for(int i=0; i<_property.size(); i++)
		{
			if(_property.get(i).getKey().equals(key))
				return _property.get(i).getValue();
		}
		
		return null;
	}
	
	/**
	 * Returns a list of references between reference points of one part
	 * @return ArrayList<Reference>
	 */
	public ArrayList<Reference> getPartReferences()
	{
		return _reference;
	}
	
	/**
	 * all defined reference points of the part
	 * @return
	 */
	public ArrayList<Enum<?>> getReferencePoints()
	{		
		return _refGraph.getReferencePoints();
	}
	
	public Enum<?> getBaseReferencePoint()
	{
		return _refGraph.getBaseReferencePoint();
	}
	
	
	public void setBaseReferencePoint(Enum<?> base)
	{
		_refGraph.setBaseReferencePoint(base);
	}
	
	/**
	 * validate if a reference between two points exists within the part
	 * 
	 * @param a - reference point a
	 * @param b - reference point b
	 * @return true if reference exists, false otherwise
	 */
	public boolean existReference(Enum<?> a,Enum<?> b)
	{
		for (Reference ref: _reference)
		{
			if(ref.getStartPoint().equals(a) && ref.getEndPoint().equals(b))
				return true;
			
			if(ref.getStartPoint().equals(b) && ref.getEndPoint().equals(a))
				return true;
		}
		
		return false;
	}

}
