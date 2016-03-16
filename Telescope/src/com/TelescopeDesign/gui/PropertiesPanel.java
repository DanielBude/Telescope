package com.TelescopeDesign.gui;



import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import com.TelescopeDesign.datamodel.PropertiesModel;

public class PropertiesPanel extends JPanel{
	
	
	private static final long serialVersionUID = 1L;

	public PropertiesPanel(PropertiesModel pMod)
	{		
		JTabbedPane propTab = new JTabbedPane();		
		propTab.add("Tube",new JScrollPane(new JTable(pMod)));	
		propTab.add("Primary Mirror",new JScrollPane(new JTable(pMod)));
		propTab.add("Secondary Mirror",new JScrollPane(new JTable(pMod)));	
		propTab.add("EyePieces",new JScrollPane(new JTable(pMod)));
		propTab.add("Mounting",new JScrollPane(new JTable(pMod)));	
		propTab.add("Primary Mirror",new JScrollPane(new JTable(pMod)));
		propTab.add("Secondary Mirror",new JScrollPane(new JTable(pMod)));	
		
		
		this.add(propTab);		
	}

}
