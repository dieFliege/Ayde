package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import Vistas.CostPanel;
public class ActionListenerActualizarCostos implements ActionListener{

	private CostPanel panel;

	public ActionListenerActualizarCostos(CostPanel panel) {	
		this.panel = panel;
	}

	public void actionPerformed(ActionEvent e) {

			try {
				int mes = this.panel.getComboMeses().getSelectedIndex()+1;
				this.panel.getForm().getGestor().actualizarDatos(mes);
				
				CostPanel panelActualizado = new CostPanel(this.panel.getForm(),mes);
				this.panel.getForm().cambiarPanel(panelActualizado);				
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
	}
	
}
