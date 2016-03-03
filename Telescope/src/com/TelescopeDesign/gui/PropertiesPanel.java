package com.TelescopeDesign.gui;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PropertiesPanel extends JPanel{
	
	private ArrayList<String> properties;
	private ArrayList<Integer> values;
	
	public PropertiesPanel()
	{
		properties = new ArrayList<>();
		getTable();
		
		System.out.println(properties.get(2) + properties.size());
		
		values = new ArrayList<Integer>(properties.size());

		for(Integer index = 0; index < values.size(); index++)
			values.set(index, 0);
		
		String[] props =  new String[properties.size() ];
		getTable().toArray(props);
		
		Integer[] val =  new Integer[getTable().size()];
		values.toArray(val);
		
		String[] head = {"Newton Telescope Properties", "value"};
		
		//JTable tab = new JTable(new DefaultTableModel(head,2));
		
	
		
		
		Object[][] data = new Object[getTable().size()][2];
		
		for (int row = 0; row < 2 ; row++)
		{
				for (int column =0; column<properties.size(); column++)
			{
				System.out.println("row " + row);
				
				if (row == 0)
					data[column][row] = properties.get(column);
				else
					data[column][row] = 0;
					
			}
			
		}
		
		JTable tab = new JTable(data, head);
	
		add(new JScrollPane(tab));	
	}
	
	
	
	private ArrayList<String> getTable()
	{
		properties.add("Tube");
		properties.add("Focal ratio [f/'']");
		properties.add("Aperture [mm]");
		properties.add("");
		properties.add("Primary Mirror");
		properties.add("Secondary Mirror");
	
		return properties;		
	}
	
	

}
