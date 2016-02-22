package com.TelescopeDesign.gui;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame
{
	
	public MainWindow()
	{
		this.getContentPane().add(new JLabel("Hello, world!"));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(100, 100);
		this.setVisible(true);
	}
	
}