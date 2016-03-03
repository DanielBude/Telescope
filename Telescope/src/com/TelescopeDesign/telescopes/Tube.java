package com.TelescopeDesign.telescopes;


import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class Tube implements TableModel {

	
	//HashMap<Integer, HashMap<String, Double>>  _tubeData;
	
	private ArrayList<String> _properties;
	private ArrayList<Double> _values;
	 
	/**
	 * Creates a tubus which is defined by diameter inside, outside and its´s length
	 * @param diaInside
	 * @param diaOutside
	 * @param length
	 */
	public Tube (Double diaInside, Double diaOutside, Double length) 
	{	
		
		_properties = new ArrayList<String>(); 
		_values = new ArrayList<Double>(); 
		
		setValueAt("diameter inside [mm]", 0, 0);
		setValueAt("diameter outside [mm]",1, 0);
		setValueAt("length [mm]",2,0);
		
		setValueAt(diaInside, 0, 1);
		setValueAt(diaOutside, 1, 1);
		setValueAt(length, 2,1);
	}
	
	public 	ArrayList<String> getProperties()
	{
		return _properties;
	}
	
	public 	ArrayList<Double> getValues(){
		return _values;
	}

	@Override
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getColumnName(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int row, int column) {
		
		if(column == 0)
			return _properties.get(row);
		else
			return _values.get(row);
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {		
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object value, int row, int column) {

		if(column == 0)
			_properties.add(row,(String) value);
		else
			_values.add(row, (Double) value);
		
	}
	
	
}
