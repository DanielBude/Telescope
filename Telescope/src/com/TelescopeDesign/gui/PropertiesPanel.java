package com.TelescopeDesign.gui;



import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JTable;


import com.TelescopeDesign.datamodel.PropertiesModel;



public class PropertiesPanel extends JPanel{
	
	
	private static final long serialVersionUID = 1L;

	public PropertiesPanel(PropertiesModel pMod)
	{		

		
		JTable tab = new JTable(pMod);
		tab.setBackground(Color.cyan);
		tab.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
		
		Font tableContentFont = new Font("Arial",Font.PLAIN,12);
		tab.setFont(tableContentFont);
		
		//TODO make the header bold
		//TODO eleminate the NaN Values		
	
			
		this.add(new JScrollPane(tab));		
	}

}
