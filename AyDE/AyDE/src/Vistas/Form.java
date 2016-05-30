package Vistas;

import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class Form extends JFrame {
		
	private PanelFondo panelFondo;
	private JPanel panelPrincipal;
	
	public JPanel getPanelPrincipal(){
		return this.panelPrincipal;
	}
	public void setPanelPrincipal(JPanel newPanel){
		this.panelPrincipal = newPanel;
	}
	
	public Form() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		this.inicializar();		
	}	
	
	private void construirMenuBar(){
		
		UIManager.put("MenuBar.background", Color.GRAY);
        UIManager.put("Menu.foreground", Color.white);
		
		this.setJMenuBar(new Menu(this));
	}
	
	private void inicializar(){
		
		this.construirMenuBar();						
		this.inicializarPanel();
		
		this.setSize(500,500);
		
		//Centra la Ventana
	    this.setLocationRelativeTo(null);
		
	    this.setTitle("Administracion de proyectos");
		this.setVisible(true);
							
	}
	
	private void inicializarPanel(){
		
		this.panelFondo = new PanelFondo();
		this.getContentPane().add(this.panelFondo,new GridBagLayout());	
		
		this.panelPrincipal = new JPanel();	
		this.panelFondo.add(this.panelPrincipal,new GridBagLayout());
	}
	
	public void cambiarPanel(JPanel newPanel){					
		
		this.panelFondo.removeAll();
		this.setPanelPrincipal(newPanel);
		
		this.panelFondo.add(this.panelPrincipal,new GridBagLayout());
		
		//Este radio button es solo para pruebas HAY QUE BORRARLO
		JRadioButton radioButton = new JRadioButton("Prueba");
		this.panelPrincipal.add(radioButton);
		
		this.panelPrincipal.updateUI();
		this.panelPrincipal.repaint();
		this.repaint();	
	}
	
}