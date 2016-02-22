package com.TelescopeDesign.gui;

import javax.swing.*;

public class MainWindow extends JFrame
{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public MainWindow()
	{
		this.getContentPane().add(new JLabel("Hello, world!"));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar  menuBar = new JMenuBar();
		JMenu projectMenu = new JMenu("Project");
		
		projectMenu.add(new JMenuItem("New..."));
		projectMenu.add(new JMenuItem("Save..."));
		projectMenu.add(new JMenuItem("Exit..."));		
		
		
		menuBar.add(projectMenu);			
		
		this.setJMenuBar(menuBar);
		
		this.setSize(getMaximumSize());
		this.setVisible(true);
		
	}
	
}