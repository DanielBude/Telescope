package com.TelescopeDesign.gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.tree.TreePath;

import com.TelescopeDesign.telescopes.TelescopeModel;
import com.TelescopeDesign.types.TelescopeParts;


public class PropertiesPanel extends JPanel{	
	
	private static final long serialVersionUID = 1L;
	private JTable _tab;
	private TelescopeModel _model;

	public PropertiesPanel(TelescopeModel model)
	{		
	    _model = model;
	    _tab = new JTable(model.getPartModel(TelescopeParts.PRIMARY_MIRROR));
	    setStyle();
				
		_tab.setPreferredScrollableViewportSize(new Dimension(350,150));
		_tab.setFillsViewportHeight(true);
		
		this.add(new JScrollPane(_tab), BorderLayout.SOUTH);
	}
	
	public void changeTable(TreePath path)
	{
		_tab.setModel(_model.getPartModel(path));
	}
	
	private void setStyle()
	{	
		Color tableBackground = new Color(250,250,250);
		
		Font tableContentFont = new Font("Arial",Font.PLAIN,12);
		_tab.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));	
		_tab.setBackground(tableBackground);
		_tab.setFont(tableContentFont);	
	}
}
