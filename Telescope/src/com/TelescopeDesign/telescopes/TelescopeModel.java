package com.TelescopeDesign.telescopes;

public class TelescopeModel {
	
	public PrimaryMirror pri;
	public SecondaryMirror sec;
	

	public TelescopeModel()
	{
		pri = new PrimaryMirror();
		sec = new SecondaryMirror();
	}
	
	
}
