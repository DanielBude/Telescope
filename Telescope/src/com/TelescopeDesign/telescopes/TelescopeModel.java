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
	
	private DefaultMutableTreeNode _root, _tube, _primaryMirror, _secondaryMirror;

	public TelescopeModel()
	{

		_root = new DefaultMutableTreeNode( "Newton Reflector" );
		_tube = new DefaultMutableTreeNode("Tube");
		_primaryMirror = new DefaultMutableTreeNode("Primary Mirror");
		_secondaryMirror = new DefaultMutableTreeNode("Secondary Mirror");
		
		_root.add(_tube);
		_root.add(_primaryMirror);
		_root.add(_secondaryMirror);
		

	}
	
	
	public DefaultMutableTreeNode getTreeModel(){
		
		return _root;
	}
	
}
