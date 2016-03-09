package com.TelescopeDesign.datamodel;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class PropertiesModel implements TableModel{

	ArrayList<String> _tableHeader;
	ArrayList<String> _propertyNames;
	ArrayList<Double> _propertyValues;
	private ArrayList<DataObject> _partsList;

	public PropertiesModel(){			
			
			_propertyNames 	= new ArrayList<String>(); 
			_propertyValues = new ArrayList<Double>(); 
			
			_partsList = new ArrayList<DataObject>();		
			_partsList.add(new Tubus(10.0,20.0,1500.0));
	
			createTable(_partsList);				
		}
	
	private void createTable(ArrayList<DataObject> parts)
	{			
			Integer i =0;
			  for (int p = 0; p< parts.size(); p++ ){
				  
				  _tableHeader =(parts.get(i).getHeader());
				  
				 Hashtable<String,Double> property = parts.get(p).getData();

				 
				 for (String key :  property.keySet())
				 {
					 System.out.println(key);
					 setValueAt(key, i, 0);			  
					 setValueAt(property.get(key),i,1);
					 i++;
				 }	  		  
		  }  
	}
		 
		
		@Override
		public int getRowCount() {
			//return _propertyValues.size();
			return 3;
		}
		
		@Override
		public int getColumnCount() {
			return 2;
		}
		
		@Override
		public String getColumnName(int columnIndex) {
			return _tableHeader.get(columnIndex);
		}
		
		@Override
		public Class<?> getColumnClass(int columnIndex) {
			return getValueAt(0,columnIndex).getClass();			
		}
		
		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
//			if(columnIndex == 1)
//				return true;
//			else
//				return false;	
			return true;
		}
		
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {	
			
			if(columnIndex == 0)
				return _propertyNames.get(rowIndex);
			else
				return  _propertyValues.get(rowIndex);
			
		}
		
		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
						
			if(columnIndex == 0)
			 _propertyNames.add(rowIndex, (String) aValue);
			else
			 _propertyValues.add(rowIndex, (Double) aValue);
				
		}
		
		@Override
		public void addTableModelListener(TableModelListener l) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void removeTableModelListener(TableModelListener l) {
			// TODO Auto-generated method stub
			
		}	
}
