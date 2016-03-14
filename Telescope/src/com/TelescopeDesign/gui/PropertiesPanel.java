package com.TelescopeDesign.gui;



import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import com.TelescopeDesign.datamodel.PropertiesModel;

public class PropertiesPanel extends JPanel implements TableModelListener{
	
	private JTable _tab;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PropertiesPanel()
	{
		PropertiesModel pMod = new PropertiesModel();
		JTable _tab = new JTable(pMod);
		pMod.addTableModelListener(this);
	
		add(new JScrollPane(_tab));	
	}
	
	public JTable getTable()
	{
		return _tab;
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		System.out.println("Geht");
	}
	

}
