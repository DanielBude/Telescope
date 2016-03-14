package com.TelescopeDesign.app;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import com.TelescopeDesign.datamodel.PropertiesModel;
import com.TelescopeDesign.gui.MainFrame;
import com.TelescopeDesign.gui.TelescopePrinting;
import com.sun.corba.se.impl.ior.NewObjectKeyTemplateBase;

public class Controller {
	
	public PropertiesModel pMod = new PropertiesModel();
	public MainFrame mainframe = new MainFrame();
	public TelescopePrinting print = new TelescopePrinting();

	
	public Controller()
	{		
		mainframe.getBluePrint().add(print);
		mainframe.getBluePrint().repaint();
		mainframe.repaint();
		mainframe.setVisible(true);
	
		
		
		TableModelListener tml = new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				System.out.println("Tabelle hat sich geändert");
			}
		};
		
		pMod.addTableModelListener(tml);
		
	}


	
}
