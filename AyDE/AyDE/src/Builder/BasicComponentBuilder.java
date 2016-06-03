package Builder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class BasicComponentBuilder {

		private JPanel panel;		

		
public BasicComponentBuilder(JPanel panel){

	this.setPanel(panel);
		
}

public JRadioButton construirRadioButton(String nombre, int posX, int posY){
	
	JRadioButton radioButton = new JRadioButton(nombre);
	
	GridBagConstraints c = new GridBagConstraints();
	c.anchor = GridBagConstraints.CENTER;
	c.gridx = posX;
	c.gridy = posY;
	c.insets = new Insets(5, 5, 5, 5);
	
	radioButton.setFocusPainted(false);	
	this.panel.add(radioButton, c);
	
	return radioButton;
}


public JButton construirButton(String nombre, int posX, int posY){
	
	JButton button = new JButton(nombre);
	
	GridBagConstraints c = new GridBagConstraints();
	c.anchor = GridBagConstraints.CENTER;
	c.gridx = posX;
	c.gridy = posY;
	c.insets = new Insets(5, 5, 5, 5);
	
	button.setFocusPainted(false);
	this.panel.add(button, c);
	
	return button;
}


public JTextField construirInputText(int posX, int posY){
	
	JTextField input =new JTextField();
	Border border = LineBorder.createGrayLineBorder();
	
	input.setHorizontalAlignment(SwingConstants.CENTER);
	input.setBackground(Color.white);
	input.setOpaque(true);
	input.setBorder(border);
	
	GridBagConstraints c = new GridBagConstraints();
	c.anchor = GridBagConstraints.WEST;
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = posX;
	c.gridy = posY;
	c.insets = new Insets(5, 5, 5, 5);
	
	input.setPreferredSize(new Dimension(75,30));
	this.panel.add(input,c);
	
	return input;
}

public JComboBox<String> construirCombo(String[] opciones,int posX,int posY){
	
	JComboBox<String> combo = new JComboBox<String>(opciones);
	Border border = LineBorder.createGrayLineBorder();
	
	combo.setBackground(Color.white);
	combo.setOpaque(true);
	combo.setBorder(border);
	combo.setSelectedIndex(0);//Por defecto el combo se crea con el primer elemento seleccionado

	GridBagConstraints c = new GridBagConstraints();
	c.anchor = GridBagConstraints.WEST;
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = posX;
	c.gridy = posY;
	c.insets = new Insets(5, 5, 5, 5);
	
	combo.setPreferredSize(new Dimension(75,30));
	this.panel.add(combo,c);
	
	return combo;
}

public JLabel construirLabel(String nombre,int posX, int posY){
	
	Border border = LineBorder.createGrayLineBorder();
	
	JLabel label = new JLabel(nombre);
	
	label.setHorizontalAlignment(SwingConstants.CENTER);
	label.setBackground(Color.white);
	label.setOpaque(true);
	label.setBorder(border);
	
	GridBagConstraints c = new GridBagConstraints();
	c.anchor = GridBagConstraints.EAST;
	c.fill = GridBagConstraints.HORIZONTAL;
	c.weightx = 1.0;
	c.gridx = posX;
	c.gridy = posY;
	c.insets = new Insets(5, 5, 5, 5);
	

	label.setPreferredSize(new Dimension(75,30));
	this.panel.add(label,c);
	
	return label;	
	
}


public JPanel getPanel() {
	return panel;
}


public void setPanel(JPanel panel) {
	this.panel = panel;
}
	
}
