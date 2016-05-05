package com.kuka.TelescopeDesign.converter;

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

	public Converter(JPanel panel, TelescopeModel _dataModel) {

		
		//Calculate Scale Factor
		IConvertable part = (IConvertable) _dataModel.getPartModel(TelescopeParts.TUBE);
		
		if((panel.getHeight()/part.getHeight())> (panel.getWidth()/part.getWidth()))
			_scaleFactor = panel.getHeight()/part.getHeight();
		else
			_scaleFactor = panel.getWidth()/part.getWidth();
		
		System.out.println(panel.getHeight());
	}
	

	public Double getScaleFactor()
	{
		return _scaleFactor;
	}
	
	public Double getTotalWidth()
	{		
		return 0.0;
	}
	
	public Double getTotalHight()
	{		
		return 0.0;
	}	
	
}
