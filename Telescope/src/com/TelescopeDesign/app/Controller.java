package com.TelescopeDesign.app;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import com.TelescopeDesign.datamodel.PartModel;
import com.TelescopeDesign.gui.MainFrame;
import com.TelescopeDesign.gui.TelescopePrinting;
import com.TelescopeDesign.telescopes.TelescopeModel;


public class Controller implements TableModelListener,TreeSelectionListener {
	
	public PartModel _pMod = new PartModel();
	public TelescopeModel _model = new TelescopeModel();
	
	public MainFrame _mainframe;
	public TelescopePrinting print = new TelescopePrinting();
	

	public Controller()
	{		
		_mainframe = new MainFrame(this);			
		_pMod.addTableModelListener(this);	
		_mainframe.getPartsTree().addTreeSelectionListener(this);
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		
		print.updateData(_pMod);		
		print.repaint();		
	}

	/** This method makes the table visible corresponding to the selection on the Telescope tree.
	 */
	@Override
	public void valueChanged(TreeSelectionEvent event) {
	  _mainframe.updatePropertyTable(event.getPath());	  
	}
	
	
	public TelescopeModel getTelescopeModel()
	{
		return _model;
	}
}
