package com.TelescopeDesign.app;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import com.TelescopeDesign.datamodel.PropertiesModel;
import com.TelescopeDesign.gui.MainFrame;
import com.TelescopeDesign.gui.TelescopePrinting;
import com.TelescopeDesign.telescopes.TelescopeModel;


public class Controller implements TableModelListener{
	
	public PropertiesModel pMod = new PropertiesModel();
	private TelescopeModel _teleMod;
	public MainFrame mainframe = new MainFrame(pMod);
	public TelescopePrinting print = new TelescopePrinting();
	

	public Controller()
	{		
		
		_teleMod = new TelescopeModel();
		mainframe.getBluePrint().add(print);
		mainframe.getBluePrint().repaint();
		mainframe.repaint();
		mainframe.setVisible(true);
			
		pMod.addTableModelListener(this);		
	}

	@Override
	public void tableChanged(TableModelEvent e) {
	
		System.out.println("Do calulations");		
		System.out.println("Do redraw");
		System.out.println("refresh view");
		System.out.println("=============");
	
		print.updateData(pMod);		
		print.repaint();
		
	}
	
	public DefaultMutableTreeNode getTelescopeModel()
	{
		return _teleMod.getTreeModel();
	}
}
