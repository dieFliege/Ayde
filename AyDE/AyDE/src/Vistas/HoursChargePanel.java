package Vistas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import Builder.BasicComponentBuilder;

@SuppressWarnings("serial")
public class HoursChargePanel extends JPanel{

	private JPanel dataPanel;
	
	public HoursChargePanel(){
		
		this.initializeAttribute();
		this.setLayout(new GridBagLayout());
		
		this.construirComponentes();
		this.setBackground(Color.lightGray);
		
		Border border = BorderFactory.createLineBorder(Color.black);
		this.setBorder(BorderFactory.createTitledBorder(border,"Cargar Dedicacion", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
		
		this.setPreferredSize(new Dimension(350,350));
	}	
	
	private void initializeAttribute(){
		
		this.dataPanel = new JPanel();			
		this.dataPanel.setPreferredSize(new Dimension(320,200));
		GridBagLayout layout = new GridBagLayout();		
		this.dataPanel.setLayout(layout);					
	
	}
	
	private void construirComponentes(){
		
		//BasicComponentBuilder builder = new BasicComponentBuilder(this.dataPanel);			
		GridBagConstraints c = new GridBagConstraints();	
		BasicComponentBuilder builder = new BasicComponentBuilder(this.dataPanel);
		
		//Fila 1
		builder.construirLabel("Proyectos:",0,0);
		//Se deben cargar los proyectos segun los que estan en la base de datos
		String[] opciones = {"Alfa","Beta","Gamma","Omega","Elipson"};
		builder.construirCombo(opciones,1,0);
		
		//Fila 2
		builder.construirLabel("Dedicaci�n semanal(%):",0,1);
		builder.construirInputText(1,1);
		
		//Fila 3
		builder.construirLabel("Perioridad:",0,2);
		builder.construirLabel("Semanal",1,2);		
				
		c = this.position(0, 1);
		c.anchor = GridBagConstraints.CENTER;
		c.weighty = 1.0;	
		this.add(this.dataPanel,c);
		
	}
	
	private GridBagConstraints position(int posX, int posY){
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = posX;
		c.gridy = posY;
		c.insets = new Insets(5,5,5,5);
		
		return c;
		
	}
}