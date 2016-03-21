package com.TelescopeDesign.telescopes;


import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import com.TelescopeDesign.datamodel.PrimaryMirror;
import com.TelescopeDesign.datamodel.SecondaryMirror;

public class TelescopeModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PrimaryMirror pri;
	public SecondaryMirror sec;
	
	private DefaultMutableTreeNode _root, _opticalParts;

	public TelescopeModel()
	{

		_root = new DefaultMutableTreeNode( "Newton Reflector" );
		_opticalParts = new DefaultMutableTreeNode("Primary Mirror");
		
		_root.add(_opticalParts);
		

	}
	
	
	public DefaultMutableTreeNode getTreeModel(){
		
		return _root;
	}
	
}
