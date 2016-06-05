package Vistas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import clases.GestorProyectos;

import listener.ActionListenerSalir;

@SuppressWarnings("serial")
public class Form extends JFrame {
		
	private PanelFondo panelFondo;
	private JPanel panelPrincipal;
	private JButton buttonExit;
	private GestorProyectos gestor;
	
	public GestorProyectos getGestor(){
		return this.gestor;
	}
	
	public JPanel getPanelPrincipal(){
		return this.panelPrincipal;
	}
	public void setPanelPrincipal(JPanel newPanel){
		this.panelPrincipal = newPanel;
	}
	
	public Form() throws SQLException {
	
		this.gestor = new GestorProyectos();
		
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
	
	private void construirBotonSalida(){
		
		this.buttonExit = new JButton("Salida");
		buttonExit.setFocusPainted(false);
		buttonExit.setVisible(false);
		
		Color color = new Color(0,0,51);
		buttonExit.setBackground(color);
		buttonExit.setForeground(Color.white);
		buttonExit.setPreferredSize(new Dimension(100,30));
		
		ActionListenerSalir listener = new ActionListenerSalir(this);
		buttonExit.addActionListener(listener);
		
		ButtonGroup buttons = new ButtonGroup();
		buttons.add(buttonExit);
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(5, 5, 5, 5);
		
		this.panelFondo.add(buttonExit,c);
	}
	
	private void inicializarPanel(){

		this.panelFondo = new PanelFondo();
		this.setContentPane(panelFondo);
		this.getContentPane().setLayout(new GridBagLayout());
		
		this.panelPrincipal = new JPanel();
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(5, 5, 5, 5);
		this.panelFondo.add(this.panelPrincipal,c);		

		this.construirBotonSalida();
		
	}
	
	public void cambiarPanel(JPanel newPanel){		
		
		this.panelPrincipal.removeAll();
		this.panelPrincipal.setBackground(newPanel.getBackground());
		
		this.buttonExit.setVisible(true);
		
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(5, 5, 5, 5);
		
		this.panelPrincipal.add(newPanel,c);

		this.panelPrincipal.repaint();
		this.panelPrincipal.updateUI();
	}
	
	public void exit(){
		this.gestor.desconectarBaseDeDatos();
		System.exit(0);
	}
}