package com.TelescopeDesign.gui;



import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JTable;


import com.TelescopeDesign.datamodel.PropertiesModel;

public class PropertiesPanel extends JPanel{
	
	private JTable _tab;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PropertiesPanel()
	{
		
		PropertiesModel pMod = new PropertiesModel();
		
		JTable _tab = new JTable(pMod);
	
		add(new JScrollPane(_tab));	
	}
	
	public JTable getTable()
	{
		return _tab;
	}
	

}
