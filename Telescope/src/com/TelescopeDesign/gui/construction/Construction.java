package com.TelescopeDesign.gui.construction;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Construction extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void paintComponent(Graphics g)
    {
		super.paintComponent(g);
		setPreferredSize(new Dimension(getMaximumSize().width,getParent().getParent().getHeight()/2));		
		setBorder(BorderFactory.createEtchedBorder());
		setLayout(new BorderLayout());
		
//		GridLayout  gl = new GridLayout();
//		gl.setColumns(2);
//		gl.setRows(2);
		
		
		Container header = new JPanel();	
		header.setLayout(new BorderLayout());
		JLabel title = new JLabel("Telescope Characterics:");		
		title.setFont(new Font("Arial", Font.BOLD, 18));
		header.add(title, BorderLayout.WEST);
		
	
		Container characteristics = new JPanel();		
		GridLayout  cgl = new GridLayout(0,4,0,0);
		
//		cgl.setColumns(2);
//		cgl.setRows(6);
//		cgl.setHgap(2);
//		cgl.setVgap(2);
		characteristics.setLayout(cgl);	

		JLabel obstructionLabel = new JLabel("Obstruction:");
		obstructionLabel.setFont(new Font("Arial", Font.ITALIC, 14));
		characteristics.add(obstructionLabel);
		
		JTextField obstructionValue = new JTextField("26%");		
		obstructionValue.setFont(new Font("Arial", Font.ITALIC, 14));
		characteristics.add(obstructionValue);		
		
		JLabel magnificianLabel  = new JLabel("Maximal Magnifician :");
		magnificianLabel.setFont(new Font("Arial", Font.ITALIC, 14));
		characteristics.add(magnificianLabel);
		
		JTextField magnificianValue = new JTextField("250");		
		magnificianValue.setFont(new Font("Arial", Font.ITALIC, 14));
		characteristics.add(magnificianValue);
		
		
		JLabel focalRatioLabel  = new JLabel("Focial Ratio :");
		focalRatioLabel.setFont(new Font("Arial", Font.ITALIC, 14));
		characteristics.add(focalRatioLabel);			
		
		JTextField focalRatioValue = new JTextField("f/10");		
		focalRatioValue.setFont(new Font("Arial", Font.ITALIC, 14));
		characteristics.add(focalRatioValue);
		
		JLabel sphericalAbberationLabel  = new JLabel("Spherical Aberration :");
		sphericalAbberationLabel.setFont(new Font("Arial", Font.ITALIC, 14));
		characteristics.add(sphericalAbberationLabel);			
		
		JTextField sphericalAbberationValue = new JTextField("lambda/2");		
		sphericalAbberationValue.setFont(new Font("Arial", Font.ITALIC, 14));
		characteristics.add(sphericalAbberationValue);
		
		add(header, BorderLayout.NORTH);
		add(characteristics,BorderLayout.CENTER);
		
		setVisible(true);
    }	
}
