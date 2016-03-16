package com.TelescopeDesign.datamodel;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Observable;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class PropertiesModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ArrayList<String> _tableHeader;
	ArrayList<String> _propertyNames;
	ArrayList<Double> _propertyValues;
	private ArrayList<DataObject> _partsList;

	public PropertiesModel(){			
		
		  _tableHeader = new ArrayList<String>();
		  _tableHeader.add("Telescope Type:");
		  _tableHeader.add("Newton Reflector");
		
			_propertyNames 	= new ArrayList<String>(); 
			_propertyValues = new ArrayList<Double>(); 
			
			_partsList = new ArrayList<DataObject>();		
			_partsList.add(new Tubus(10.0,20.0,1500.0));
			_partsList.add(new PrimaryMirror());
	
			createTable(_partsList);		
		}
	
	private void createTable(ArrayList<DataObject> parts)
	{					
			int  i = 0;
			  for (int p = 0; p< parts.size(); p++ ){
				 
				 _propertyNames.add(i,parts.get(p).getHeader().get(0));				 
				 _propertyValues.add(i,Double.NaN);			//TODO: Something else than NAN
				 i++;				
				  
				 Hashtable<String,Double> property = parts.get(p).getData();
				 
				 for (String key :  property.keySet())
				 {
					 _propertyNames.add(i,key);
					 _propertyValues.add(i, property.get(key));	
					 i++;
				 }	  		  
				 _propertyNames.add(" ");				 
				_propertyValues.add(i,Double.NaN);	
				 i++;
		  }  
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
			{
				return _propertyNames.get(rowIndex);
			}
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
}
