package com.TelescopeDesign.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class PrimaryMirrorVisualModel {

	double _factor; // Factor in Abhängigkeit der der Größe von BluePrint
	double _radius; // Radius des Spiegels in Zentimetern
	int _x; // X-Koordinate
	int _y; // Y-Koordinate, Grundlinie muss definiert werden (Mitte von BluePrint)
	
	public PrimaryMirrorVisualModel()
	{
		_radius = 100; // default
		_factor = 1;
		_x = 1000;
		_y = 200;
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g; // Ändern in 2D-Zeichnung
        g2.setStroke(new BasicStroke(2)); // Linienstärke
        
		
		g2.setColor( Color.WHITE );
		g2.drawArc(_x, _y, 10, (int)(2*_radius*_factor), -90, 180);
		
		g2.drawLine(_x, _y, _x+20, _y);
		g2.drawLine(_x, _y+(int)(2*_radius*_factor), _x+20, _y+(int)(2*_radius*_factor));
		g2.drawLine(_x+20, _y, _x+20, _y+(int)(2*_radius*_factor));
		
	}
	
	public double getFactor() {
		return _factor;
	}

	public void setFactor(double factor) {
		_factor = factor;
	}

	public double getRadius() {
		return _radius;
	}

	public void setRadius(double radius) {
		_radius = radius;
	}
	
	public double getx() {
		return _x;
	}

	public void setx(int x) {
		_x = x;
	}

	public double gety() {
		return _y;
	}

	public void sety(int y) {
		_y = y;
	}
}
