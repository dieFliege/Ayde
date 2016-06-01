package Vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Menu extends JMenuBar implements ActionListener{

	private Form form;
	private JMenu menuAcciones;
	
	public Menu(Form form){
		this.form = form;
		menuAcciones = new JMenu("Acciones");
		this.construirMenuBar();
	}
	
	private void construirMenuBar(){		       
		
		this.form.setLayout(null);              
        
        this.construirMenuAcciones();
        this.add(this.menuAcciones);
        this.setVisible(true);
	}
	
	private void construirMenuAcciones(){
		
		//menu=new JMenu("Acciones");
        
        JMenuItem mi0=new JMenuItem("Cargar Horas");
        mi0.addActionListener( this);
        this.menuAcciones.add(mi0);
        
        JMenuItem mi1=new JMenuItem("Costos de proyectos");
        mi1.addActionListener(this);
        this.menuAcciones.add(mi1);
	}
	
	public void actionPerformed(ActionEvent e) {
		 
		if (e.getSource() == this.menuAcciones.getItem(0)){
			//this.form.cambiarPanel(new Costos(this.form));
			//Ejemplo: 
			this.form.cambiarPanel(new JPanel());			
			System.out.println("Se selecciono menu de carga horas");
		}
		
		if (e.getSource() == this.menuAcciones.getItem(1)){
			//this.form.cambiarPanel(new Cargas(this.form));
			System.out.println("Se selecciono menu de costos de proyecto");
			//Ejemplo
			this.form.getPanelPrincipal().removeAll();
			this.form.getPanelPrincipal().repaint();
			this.form.getPanelPrincipal().updateUI();
			this.form.repaint();
		}		
	 }	
}
