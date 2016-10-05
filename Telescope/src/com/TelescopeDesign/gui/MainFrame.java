package com.TelescopeDesign.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Rectangle;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.TreePath;

import com.TelescopeDesign.app.Controller;
import com.TelescopeDesign.blueprint.BluePrint;
import com.TelescopeDesign.gui.construction.Construction;
import com.TelescopeDesign.icons.BluePrintIcon;
import com.TelescopeDesign.icons.FoucaultIcon;
import com.TelescopeDesign.icons.RayTracingIcon;
import com.TelescopeDesign.icons.SpotDiagrammIcon;
import com.TelescopeDesign.telescopes.TelescopeModel;

public class MainFrame extends JFrame
{
	private BluePrint _bp;
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private JTree _partsTree;
	JPanel _southPanel = new JPanel();
	JPanel _westPanel = new JPanel();
	JPanel _eastPanel = new JPanel();
	PropertiesPanel _propPanel;
	TelescopeModel _model;
    
	public MainFrame(Controller _ctrl)
	{	
		_model = _ctrl.getTelescopeModel();
		
		_bp = new BluePrint(_model);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		this.setTitle("Telescope Designer");
			
		//create MenuBar
		this.setJMenuBar(new Menu());
		
		//Placeholder for a Toolbar
		JPanel toolbar = new JPanel();				
		toolbar.setSize(200, 500);
		
		//Telescope Parts tree
		_partsTree = new JTree(_model.getTreeModel());
		setStyle();
		
		Border eB = new EmptyBorder(0,5,0,5);		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().add(_partsTree);
	    scrollPane.setBorder(eB);
			
		_propPanel = new PropertiesPanel(_model);	
		_eastPanel.setLayout(new BorderLayout());
		_eastPanel.add(scrollPane,BorderLayout.CENTER);
		_eastPanel.add(_propPanel , BorderLayout.SOUTH);
				
		//DrawingsPanel		
		JTabbedPane drawingPanel = new JTabbedPane();
		drawingPanel.setTabPlacement(JTabbedPane.BOTTOM);
		drawingPanel.setBackground(Color.WHITE);
		
		JPanel spotDiagramm = new JPanel();
		spotDiagramm.setBackground(Color.WHITE);		
		drawingPanel.addTab("Spot Diagramm", spotDiagramm);
		drawingPanel.addTab("Illumination", new JPanel());
		
		JPanel construction = new Construction();
		//_southPanel.setPreferredSize(getMaximumSize());
		GridLayout constructionGridLayout = new GridLayout();
//		constructionGridLayout.setColumns(5);
//		constructionGridLayout.setRows(5);
		_southPanel.setLayout(constructionGridLayout);
		_southPanel.add(construction);
		
		
		//Abberation Panel				
//		String[] abbHeader = {"Aberrations","Value"};
//		
//		DefaultTableModel abbModel = new  DefaultTableModel(abbHeader,5);
//		JTable abberationsTab = new JTable(abbModel);

		GridLayout gl = new GridLayout();
		gl.setRows(6);
		gl.setColumns(1);	
		gl.setHgap(30);
		gl.setVgap(10);
		
		_westPanel.setBorder(BorderFactory.createEtchedBorder());
		_westPanel.setLayout(gl);
		_westPanel.setAlignmentX(CENTER_ALIGNMENT);
		
		_westPanel.add(new BluePrintIcon());	 
	    _westPanel.add(new SpotDiagrammIcon());
	    _westPanel.add(new RayTracingIcon());
	    _westPanel.add(new Label("Image Abberations"));
	    _westPanel.add(new FoucaultIcon());	    
		_westPanel.setVisible(true);
	
		JPanel centerPanel = new JPanel();		
		BorderLayout bL = new BorderLayout();//		
		centerPanel.setLayout(bL);
		
		//Visualisation Panel
		
		
		// centerNorth.add(_bp,BorderLayout.CENTER);
		 centerPanel.add(_bp, BorderLayout.CENTER);
	     centerPanel.add(construction, BorderLayout.SOUTH);
		 centerPanel.doLayout();
	     
		//getContentPane().add(_southPanel ,BorderLayout.SOUTH);
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		getContentPane().add(toolbar, BorderLayout.NORTH);
		getContentPane().add(_eastPanel, BorderLayout.EAST);
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
		return _bp;
	}
	
	private void setStyle()
	{	
		Color tableBackground = new Color(250,250,250);
		_partsTree.setBackground(tableBackground);	
		_partsTree.setPreferredSize(new Dimension(300,100));	
		_partsTree.setBorder(new LineBorder(Color.BLACK));
	}
}