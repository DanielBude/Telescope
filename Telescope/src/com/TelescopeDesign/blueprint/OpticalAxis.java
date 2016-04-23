package com.TelescopeDesign.blueprint;


import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class OpticalAxis extends Line2D{

	Graphics2D _graphic;
	Line2D _line;
	Point _startPoint, _endPoint;
	Integer _startX, _startY, _endX, _endY;
	
	BasicStroke _stroke ;
	
	public OpticalAxis(JPanel p)
	{
		Integer border = 20;
	 	_startX = border;
	 	_startY = (int) p.getHeight()/2;
	 	_endX = (int) p.getWidth()-border;
	 	_endY = (int) p.getHeight()/2;

		_startPoint = new Point(_startX, _startY);
		_endPoint = new Point(_endX, _endY);
	}	

	@Override
	public Rectangle2D getBounds2D() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point2D getP1() {		
		return _startPoint;
	}

	@Override
	public Point2D getP2() {		
		return _endPoint;
	}

	@Override
	public double getX1() {		
		return _startX;
	}

	@Override
	public double getX2() {	
		return _endX;
	}

	@Override
	public double getY1() {		
		return _startY;
	}

	@Override
	public double getY2(){		
		return _endY;
	}

	@Override
	public void setLine(double x1, double y1, double x2, double y2) {
		_startX = (int) x1;
		_startY = (int)y1;
		_endX = (int) x2;
		_endY = (int)y2;
	}
}
