package com.TelescopeDesign.telescopes;


import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class Tube implements TableModel {

	
	//HashMap<Integer, HashMap<String, Double>>  _tubeData;
	
	ArrayList<String> _properties;
	ArrayList<Double> _values;
	 
	/**
	 * Creates a tubus which is defined by diameter inside, outside and its´s length
	 * @param diaInside
	 * @param diaOutside
	 * @param length
	 */
	public Tube (Double diaInside, Double diaOutside, Double length) 
	{			
		setValueAt("diameter inside [mm]", 1, 1);
		setValueAt("diameter outside [mm]",2, 1);
		setValueAt("length [mm]",3,1);
		
		setValueAt(diaInside, 1, 2);
		setValueAt(diaOutside, 2, 2);
		setValueAt(length, 3,2);
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
			_properties.set(row,(String) value);
		else
			_values.set(row, (Double) value);
		
	}
	
	
}
