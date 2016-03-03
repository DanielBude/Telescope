package com.TelescopeDesign.app;

import com.TelescopeDesign.gui.MainFrame;
import com.TelescopeDesign.gui.TelescopePrinting;
import com.TelescopeDesign.telescopes.TelescopeModel;

public class Controller {
	
	public TelescopeModel tele = new TelescopeModel();
	public MainFrame mainframe = new MainFrame();
	public TelescopePrinting print = new TelescopePrinting();

	
	public Controller()
	{
		mainframe.getBluePrint().add(print);
		mainframe.getBluePrint().repaint();
		mainframe.repaint();
		mainframe.setVisible(true);
	}
	
	
}
