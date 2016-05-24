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

	Double _scaleFactor;
	JPanel _panel;
	IConvertable _part;
	Double _screenResolution;

	public Converter(JPanel panel, TelescopeModel dataModel) 
	{
		
		 GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
		_panel = panel;		
		_part = (IConvertable) dataModel.getPartModel(TelescopeParts.TUBE);		
		
		_scaleFactor = calculateScaleFactor();
		_screenResolution = calculateResolution(g.getDefaultScreenDevice(), 23.0);
	}
	

	public Double getScale()
	{
		return _screenResolution/calculateScaleFactor();
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
		//TODO Consider Border
		if((_panel.getHeight()/_part.getHeight())< (_panel.getWidth()/_part.getWidth()))
			_scaleFactor = _panel.getHeight()/_part.getHeight();
		else
			_scaleFactor = _panel.getWidth()/_part.getWidth();		
		
		return _scaleFactor; 
	}
	
	private Double calculateResolution(GraphicsDevice device, Double diag)
	{
		Integer screenHeight = device.getDisplayMode().getHeight();
		Integer screenWidth = device.getDisplayMode().getWidth();
		
		Double diagPixel = Math.sqrt(Math.pow(screenHeight,2)+ Math.pow(screenWidth,2));
		
		return diagPixel/(23*25.4);	
	}
	
}
