package com.TelescopeDesign.app;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import com.TelescopeDesign.datamodel.PropertiesModel;
import com.TelescopeDesign.gui.MainFrame;
import com.TelescopeDesign.gui.TelescopePrinting;


public class Controller implements TableModelListener{
	
	public PropertiesModel pMod = new PropertiesModel();
	public MainFrame mainframe = new MainFrame(pMod);
	public TelescopePrinting print = new TelescopePrinting();

	public Controller()
	{		
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
	}
	
}
