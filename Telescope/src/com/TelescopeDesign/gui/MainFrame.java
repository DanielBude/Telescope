package com.TelescopeDesign.gui;

import java.awt.BorderLayout;
import java.util.Collection;
import java.util.Set;

import javax.swing.*;

import com.TelescopeDesign.telescopes.Tube;


public class MainFrame extends JFrame
{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public MainFrame()
	{
		this.getContentPane().add(new JLabel("Hello, world!"));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		this.setTitle("Telescope Designer");
		
	
		JMenuBar  menuBar = new JMenuBar();	
		this.setJMenuBar(menuBar);
		
		JMenu projectMenu = new JMenu("Project");
		projectMenu.add(new JMenuItem("New..."));
		projectMenu.add(new JMenuItem("Save..."));
		projectMenu.add(new JMenuItem("Exit..."));		
		
		menuBar.add(projectMenu);			
		
		
		//Placeholder for more Informations
		JPanel toolbar = new JPanel();
				
		toolbar.setSize(200, 500);
		getContentPane().add(toolbar, BorderLayout.NORTH);
				
//		
//		
//		Tube newtonTube = new Tube(200.0,220.0,1500.0);
//		JTable tubeTable = new JTable();
//		tubeTable.setModel(newtonTube);
//		
//		getContentPane().add(tubeTable, BorderLayout.EAST);
		
		
		JTabbedPane tab = new JTabbedPane();
		tab.setTabPlacement(JTabbedPane.BOTTOM);
		tab.add("Blue Print", new BluePrint());
		tab.add("Raytracing",new Raytracing());
		getContentPane().add(tab, BorderLayout.CENTER);
		
		
		//Placeholder for more Informations
		JPanel placeHolder = new JPanel();
		
		placeHolder.setSize(200, 100);
		getContentPane().add(placeHolder, BorderLayout.SOUTH);		
		
		
	
		
		this.setSize(getMaximumSize());
		this.setVisible(true);
		
	}
	
}