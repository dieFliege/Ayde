package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import Vistas.HoursChargePanel;

public class ActionListenerGuardarCambio implements ActionListener {

	private HoursChargePanel panel;

	public ActionListenerGuardarCambio(HoursChargePanel panel) {
		this.panel = panel;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			
			this.panel.saveChanges();
			
		} catch (ParseException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}			
		
}
