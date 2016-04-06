package com.TelescopeDesign.datamodel;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.table.AbstractTableModel;

public class PartModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	ArrayList<String> _tableHeader;
	ArrayList<String> _propertyNames;
	ArrayList<Double> _propertyValues;
	
	HashMap<Integer, HashMap<String, Double>> _property = new HashMap<Integer,HashMap<String, Double>>();

	public PartModel(){	
		
		  _propertyNames 	= new ArrayList<String>(); 
		  _propertyValues = new ArrayList<Double>();		  
	}
		
		@Override
		public int getRowCount() {
			return _propertyValues.size();		
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
				return _propertyNames.get(rowIndex);
			else
				return _propertyValues.get(rowIndex);			
		}
		
		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
						
			if(columnIndex == 0)
			 _propertyNames.set(rowIndex, (String) aValue);			
			else
			 _propertyValues.set(rowIndex, (Double) aValue);
			
			fireTableDataChanged();			
		}		
		
		@Override
		public String toString(){
			return "Part Name";			
		}		
	
}
