package com.TelescopeDesign.telescopes;

public class Telescope {
	
	public PrimaryMirror pri;
	public SecondaryMirror sec;
	

	public Telescope()
	{
		pri = new PrimaryMirror();
		sec = new SecondaryMirror();
	}
	
	
}
