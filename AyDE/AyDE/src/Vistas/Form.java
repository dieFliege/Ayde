package Vistas;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
		this.setContentPane(panelFondo);
		this.getContentPane().setLayout(new GridBagLayout());	
		
	}
	
	public void cambiarPanel(JPanel newPanel){		
		
		this.panelFondo.removeAll();
		
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 200;
		c.gridy = 200;
		c.insets = new Insets(5, 5, 5, 5);
		
		this.panelFondo.add(newPanel,c);

		this.panelFondo.repaint();
		this.panelFondo.updateUI();
	}
	
}