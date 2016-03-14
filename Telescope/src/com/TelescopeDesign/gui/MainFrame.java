package com.TelescopeDesign.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class MainFrame extends JFrame
{
	private BluePrint bp = new BluePrint();
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private JTable propertyTable;
    
	public MainFrame()
	{	
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
		
		
		//Placeholder for a Toolbar
		JPanel toolbar = new JPanel();
				
		toolbar.setSize(200, 500);
		getContentPane().add(toolbar, BorderLayout.NORTH);
		
		//PropertyPanel

		getContentPane().add(new PropertiesPanel(), BorderLayout.EAST);
		
	
		
		//DrawingsPanel
		
		
		JTabbedPane drawingPanel = new JTabbedPane();
		drawingPanel.setTabPlacement(JTabbedPane.BOTTOM);
		drawingPanel.setBackground(Color.WHITE);
		
		JPanel spotDiagramm = new JPanel();
		spotDiagramm.setBackground(Color.WHITE);
		
		drawingPanel.addTab("Spot Diagramm", spotDiagramm);
		drawingPanel.addTab("Illumination", new JPanel());

		
		
		//Abberation Panel
		
		JPanel southPanel = new JPanel();
				
		String[] abbHeader = {"Aberrations","Value"};
		
		DefaultTableModel abbModel = new  DefaultTableModel(abbHeader,3);
		JTable abberationsTab = new JTable(abbModel);
		
	

		southPanel.setLayout(new BorderLayout());
		southPanel.add(new JScrollPane(abberationsTab), BorderLayout.EAST);
		southPanel.add(drawingPanel, BorderLayout.CENTER);
		//southPanel.add(propertyPanel, BorderLayout.WEST);
	
		getContentPane().add(southPanel ,BorderLayout.SOUTH);
		
		
		//Visualisation Panel
		
		JTabbedPane tab = new JTabbedPane();
		tab.setTabPlacement(JTabbedPane.BOTTOM);
		tab.add("Blue Print", bp);
		tab.add("Raytracing",new Raytracing());
		getContentPane().add(tab, BorderLayout.CENTER);
				
		this.setSize(getMaximumSize());
		this.setMinimumSize(new Dimension(500,300));
		this.pack();
		this.setVisible(true);	
	}


	public BluePrint getBluePrint()
	{
		return bp;
	}
}