package Vistas;

import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class TableModel extends DefaultTableModel {

	@Override
    public boolean isCellEditable (int fila, int columna) {
       return false;
    }

}

