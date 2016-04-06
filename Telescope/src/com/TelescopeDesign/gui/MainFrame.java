package com.TelescopeDesign.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.TreePath;

import com.TelescopeDesign.calc.Raytracing;
import com.TelescopeDesign.datamodel.PartModel;
import com.TelescopeDesign.telescopes.TelescopeModel;
import com.TelescopeDesign.types.TelescopeParts;



public class MainFrame extends JFrame
{
	private BluePrint bp = new BluePrint();
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private JTree _partsTree;
	JPanel _southPanel = new JPanel();
	JPanel _westPanel = new JPanel();
	PropertiesPanel _propPanel;
	TelescopeModel _model;
    
	public MainFrame(TelescopeModel model)
	{	
		_model = model;
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
		
		//Telescope Parts tree
		_partsTree = new JTree(_model.getTreeModel());
		setStyle();
		
		Border eB = new EmptyBorder(0,5,0,5);
		//Border eB =BorderFactory.createMatteBorder(0, 5, 0, 5, Color.BLACK);
		//Border eB =BorderFactory.createLineBorder(Color.BLACK, 5);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().add(_partsTree);
	    scrollPane.setBorder(eB);
	    
		
		_propPanel = new PropertiesPanel(_model);	
		_westPanel.setLayout(new BorderLayout());
		_westPanel.add(scrollPane,BorderLayout.CENTER);
		_westPanel.add(_propPanel , BorderLayout.SOUTH);
				
		//DrawingsPanel		
		JTabbedPane drawingPanel = new JTabbedPane();
		drawingPanel.setTabPlacement(JTabbedPane.BOTTOM);
		drawingPanel.setBackground(Color.WHITE);
		
		JPanel spotDiagramm = new JPanel();
		spotDiagramm.setBackground(Color.WHITE);		
		drawingPanel.addTab("Spot Diagramm", spotDiagramm);
		drawingPanel.addTab("Illumination", new JPanel());
		
		
		//Abberation Panel				
		String[] abbHeader = {"Aberrations","Value"};
		
		DefaultTableModel abbModel = new  DefaultTableModel(abbHeader,3);
		JTable abberationsTab = new JTable(abbModel);
		
		_southPanel.setLayout(new BorderLayout());
	    _southPanel.add(new JScrollPane(abberationsTab), BorderLayout.EAST);
		_southPanel.add(drawingPanel, BorderLayout.CENTER);
		
	//	getContentPane().add(new JScrollPane(abberationsTab), BorderLayout.EAST);
				
				
		//Visualisation Panel
		
		JPanel tab = new JPanel();
		//tab.setTabPlacement(JTabbedPane.BOTTOM);
		tab.add(new BluePrint());
		//tab.add("Raytracing",new Raytracing());		
		
		getContentPane().add(_southPanel ,BorderLayout.SOUTH);
		getContentPane().add(bp, BorderLayout.CENTER);
		getContentPane().add(toolbar, BorderLayout.NORTH);
		getContentPane().add(_westPanel, BorderLayout.WEST);
				
		this.setSize(getMaximumSize());		
		this.pack();
		this.setVisible(true);	
	}
	
	public JTree getPartsTree(){
		return _partsTree;
	}
	
	public  void updatePropertyTable(TreePath path)
	{		
		_propPanel.changeTable(path);
	}	

	public BluePrint getBluePrint()
	{
		return bp;
	}
	
	private void setStyle()
	{	
		Color tableBackground = new Color(250,250,250);
		_partsTree.setBackground(tableBackground);	
		_partsTree.setPreferredSize(new Dimension(300,100));	
		_partsTree.setBorder(new LineBorder(Color.BLACK));
	}
}