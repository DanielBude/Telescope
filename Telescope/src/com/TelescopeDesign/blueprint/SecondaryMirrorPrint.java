package com.TelescopeDesign.blueprint;

import java.awt.Point;
import java.awt.geom.Rectangle2D;

import com.TelescopeDesign.blueprint.PrimaryMirrorPrint.GraphicReference;
import com.TelescopeDesign.converter.Converter;
import com.TelescopeDesign.datamodel.PartModel;
import com.TelescopeDesign.datamodel.PrimaryMirror;
import com.TelescopeDesign.datamodel.SecondaryMirror;
import com.TelescopeDesign.interfaces.PartPrintInterface;
import com.TelescopeDesign.types.Parameter;
import com.TelescopeDesign.types.Reference;

public class SecondaryMirrorPrint extends Rectangle2D implements PartPrintInterface {

	Converter _converter;
	Point _root;
	Reference _origin;
	double _diameter;
	double _thickness;
	double _offset;
	double _hight;
	double _width;
	double _xRef;
	double _yRef;

	public SecondaryMirrorPrint(PartModel data, Converter conv) {
		_diameter = data.getPropertyValue(Parameter.DIAMETER);
		_thickness = data.getPropertyValue(Parameter.THICKNESS);
		_offset = data.getPropertyValue(Parameter.OFFSET);
		
		_root = new Point(0,0);
		 _origin = new Reference(GraphicReference.ORIGIN, SecondaryMirror.ReferencePoint.MIRROR_CENTER, _thickness,_diameter/2);

		_xRef = 0;
		_yRef = 0;

		_width = 0;
		_hight = _diameter / 2;

		_converter = conv;

	}

	@Override
	public Rectangle2D createIntersection(Rectangle2D arg0) {

		return null;
	}

	@Override
	public Rectangle2D createUnion(Rectangle2D arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int outcode(double arg0, double arg1) {
		return 0;
	}

	@Override
	public void setRect(double x, double y, double w, double h) {
		_xRef = x;
		_yRef = y;
		_width = w;
		_hight = h;
	}

	@Override
	public double getHeight() {
		return _hight;
	}

	@Override
	public double getWidth() {
		return _width;
	}

	@Override
	public double getX() {
		return _xRef;
	}

	@Override
	public double getY() {
		return _yRef;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return true;
	}

	public void updateData() {
		_hight = convertPhysicalData(_diameter);
		_width = convertPhysicalData(_thickness);
	}

	private double convertPhysicalData(double value) {
		return _converter.getScaleFactor() * value;
	}

	@Override
	public Point getPosition(Enum<?> rP) {
		Point p = new Point();
		
		if (rP.equals(SecondaryMirror.ReferencePoint.MIRROR_CENTER)) {
			p.setLocation(_xRef, _yRef);
		}

		return p;
	}

	@Override
	public void setReference(Reference r) {
		
		_xRef = _root.getX() + convertPhysicalData(r.getDistanceX() - _origin.getDistanceX());
		_yRef = _root.getY() + convertPhysicalData(r.getDistanceY() - _origin.getDistanceY());
	}

	@Override
	public void setOrigin(Point o) {
		_root.setLocation(o.getX(), o.getY());	  
		
	}
}
