package com.TelescopeDesign.telescopes;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import com.TelescopeDesign.datamodel.PartModel;
import com.TelescopeDesign.datamodel.PrimaryMirror;
import com.TelescopeDesign.datamodel.SecondaryMirror;
import com.TelescopeDesign.datamodel.Tube;
import com.TelescopeDesign.types.Property;
import com.TelescopeDesign.types.TelescopeParts;

public class TelescopeModel{

	Map<TelescopeParts, PartModel> _parts;
	ArrayList<Property> _generalTelescopeProperties;
	
	private DefaultMutableTreeNode _telescopeType, 
								   _tube, 
								   _primaryMirror,
								   _secondaryMirror,
								   _mounting,
								   _optics, 
								   _eyepieces, 
								   _nadler, 
								   _ploessel, 
								   _focuser;

	/**
	 * Creates a model of a newtonian telescope with all relevant optical and mechanical components
	 * The model contains objects of the parts and its properties. The parts are organized in a data structure
	 * of a tree.
	 */
	public TelescopeModel()
	{	
		_parts = new HashMap<TelescopeParts, PartModel>();
		_parts.put(TelescopeParts.TUBE, new Tube(1.0,2.0,3.0));
		_parts.put(TelescopeParts.PRIMARY_MIRROR, new PrimaryMirror());
		_parts.put(TelescopeParts.SECONDARY_MIRROR, new SecondaryMirror());
		
		_generalTelescopeProperties = new ArrayList<Property>();
		_generalTelescopeProperties.add(new Property("Focal ratio [f/1]", 0.0));
		_generalTelescopeProperties.add(new Property("Aperture ['']", 0.0));
		_generalTelescopeProperties.add(new Property("Obstruction [%]", 0.0));
		_generalTelescopeProperties.add(new Property("Image field size []", 0.0));		
		
				
		createTelescopeTree();			
	}
	
	private void createTelescopeTree()
	{
		_telescopeType = new DefaultMutableTreeNode( "Newton Reflector" );
		_tube = new DefaultMutableTreeNode(_parts.get(TelescopeParts.TUBE));
		_primaryMirror = new DefaultMutableTreeNode(_parts.get(TelescopeParts.PRIMARY_MIRROR));
		_secondaryMirror = new DefaultMutableTreeNode(_parts.get(TelescopeParts.SECONDARY_MIRROR));
		_optics = new DefaultMutableTreeNode("Optics");
		_mounting = new DefaultMutableTreeNode("Mounting");
		
		_eyepieces = new DefaultMutableTreeNode("Eyepieces");
		_nadler = new DefaultMutableTreeNode("Nadler");
		_ploessel = new DefaultMutableTreeNode("Plössel");
		_focuser = new DefaultMutableTreeNode("Focuser");		
//		
		_optics.add(_tube);
		_optics.add(_primaryMirror);
		_optics.add(_secondaryMirror);
		_telescopeType.add(_optics);
		
		_telescopeType.add(_focuser);
	
		
		_telescopeType.add(_eyepieces);		
		_eyepieces.add(_nadler);
		_eyepieces.add(_ploessel);

		_telescopeType.add(_mounting);	
	}
	
	
	public DefaultMutableTreeNode getTreeModel(){
		return _telescopeType;
	}
	
	/**
	 * Returns the data model of the requested part of the telescope
	 * @param part
	 * @return PartModel
	 */
	public PartModel getPartModel(TreePath path) {
				
		for(TelescopeParts p : _parts.keySet())
		{
			if(_parts.get(p).toString().equals(path.getLastPathComponent().toString()))			
				return _parts.get(p);	
		}
		
		return null;
	}	
	
	/**
	 * Returns the data model of the requested part by the given TelescopePart enumeration
	 * @param part 
	 * @return PartModel
	 */
	public PartModel getPartModel(TelescopeParts part)
	{
		return _parts.get(part);
	}
	
	public void setTelescopeProperty(String name, Double value){
		//TODO
	}
}
