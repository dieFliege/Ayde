package Vistas;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import clases.Proyecto;

@SuppressWarnings("serial")
class FormatoTablaCostos extends DefaultTableCellRenderer
{
	@Override
    public Component getTableCellRendererComponent(JTable jTable1,Object value,boolean selected, boolean focused, int row, int column)
    { 
        super.getTableCellRendererComponent(jTable1, value, selected, focused, row, column);
                
        if (value.getClass() == Proyecto.class && ((Proyecto)value).esCapacitacion()) 
        {           	        	
        	this.setOpaque(true);
        	this.setBackground(Color.RED);
        	this.setForeground(Color.WHITE);
        }else{
        	
        	this.setOpaque(true);
            this.setBackground(Color.WHITE);
            this.setForeground(Color.BLACK);
        }
		return this;
    }
}