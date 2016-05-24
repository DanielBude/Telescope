package com.TelescopeDesign.converter;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JPanel;

import com.TelescopeDesign.telescopes.TelescopeModel;
import com.TelescopeDesign.types.TelescopeParts;

/**
 * @author Michael
 * This class converts the physical dimensions of telescope parts to 
 * graphical values.
 */
public class Converter {

	private static final double MM_TO_INCH = 0.03937008;
	Double _scaleFactor;
	Double _border;
	JPanel _panel;
	IConvertable _part;
	Double _screenResolution;

	public Converter(JPanel panel, TelescopeModel dataModel) 
	{
		
		 GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
		_panel = panel;		
		_part = (IConvertable) dataModel.getPartModel(TelescopeParts.TUBE);			
		
		_screenResolution = calculateResolution(g.getDefaultScreenDevice(), 23.0);
		_border = 10*_screenResolution;
		_scaleFactor = calculateScaleFactor();
	}
	

	public Double getScale()
	{
		return _screenResolution/calculateScaleFactor();
	}
	public Double getScaleFactor()
	{
		return _scaleFactor;
	}
	
	public Double getScreenResolution()
	{
		return _screenResolution;
	}
	
	
	public Double getTotalWidth()
	{		
		return 0.0;
	}
	
	public Double getTotalHight()
	{		
		return 0.0;
	}	
	
	private Double calculateScaleFactor()
	{
		if(((_panel.getHeight()-2*_border)/_part.getHeight())< ((_panel.getWidth()-2*_border)/_part.getWidth()))
			_scaleFactor = (_panel.getHeight()-2*_border)/_part.getHeight();
		else
			_scaleFactor = (_panel.getWidth()-2*_border)/_part.getWidth();		
		
		return _scaleFactor; 
	}
	
	private Double calculateResolution(GraphicsDevice device, Double diag)
	{
		Integer screenHeight = device.getDisplayMode().getHeight();
		Integer screenWidth = device.getDisplayMode().getWidth();
		
		Double diagPixel = Math.sqrt(Math.pow(screenHeight,2)+ Math.pow(screenWidth,2));
		
		return diagPixel/diag*MM_TO_INCH;	
	}	
}
