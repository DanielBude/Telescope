package com.TelescopeDesign.telescopes;

import com.TelescopeDesign.datamodel.PrimaryMirror;
import com.TelescopeDesign.datamodel.SecondaryMirror;

public class TelescopeModel {
	
	public PrimaryMirror pri;
	public SecondaryMirror sec;
	

	public TelescopeModel()
	{
		pri = new PrimaryMirror();
		sec = new SecondaryMirror();
	}
	
	
}
