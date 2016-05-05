package com.TelescopeDesign.gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Menu()
	{		
		JMenu projectMenu = new JMenu("Project");
		projectMenu.add(new JMenuItem("New..."));
		projectMenu.add(new JMenuItem("Save..."));
		projectMenu.add(new JMenuItem("Exit..."));		
		
		JMenu settingsMenu = new JMenu("Settings");
		settingsMenu.add(new JMenuItem("Look & Feel"));
		settingsMenu.add(new JMenuItem("Units"));
		
		
		this.add(projectMenu);	
		this.add(settingsMenu);		
	}
	
}
