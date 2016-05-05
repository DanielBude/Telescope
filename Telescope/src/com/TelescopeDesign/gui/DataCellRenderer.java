package com.TelescopeDesign.gui;

import java.awt.Component;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class DataCellRenderer extends DefaultTableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	DecimalFormat numberFormat = new DecimalFormat("#,###.##;(#,###.##)");
	
	@Override	
	public Component getTableCellRendererComponent(JTable jTable, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

		Component c = super.getTableCellRendererComponent(jTable, value, isSelected, hasFocus, row, column);
		    
	       	JLabel label = (JLabel) c;
	        label.setHorizontalAlignment(JLabel.RIGHT);
	        Number num = (Number) value;
	        System.out.println(num);
            String text = numberFormat.format(num);
            label.setText(text);	  

	return c;

	}
	
}
