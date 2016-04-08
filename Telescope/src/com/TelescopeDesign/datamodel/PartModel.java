package com.TelescopeDesign.datamodel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import com.TelescopeDesign.types.Property;

public class PartModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	ArrayList<String> _tableHeader;
	String _partName;
	ArrayList<String> _propertyNames;
	ArrayList<Double> _propertyValues;
	
	ArrayList<Property> _property;
	
	public PartModel(){	
		
		  _tableHeader = new ArrayList<String>();
		  _property = new ArrayList<Property>();		  
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
		
		public ArrayList<Property> getProperties()
		{
			return _property;
		}
	
}
