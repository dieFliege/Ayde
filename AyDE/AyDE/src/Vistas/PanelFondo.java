package Vistas;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelFondo extends JPanel {
	
	public PanelFondo() {
		this.setSize(500,500);
	}
	
	@Override
	public void paintComponent(Graphics g){
			
		Dimension tamanio = this.getSize();
		ImageIcon imagenFondo = new ImageIcon (getClass().getResource("/imagenes/Fondo.png"));
		
		g.drawImage(imagenFondo.getImage(),0,0,tamanio.width,tamanio.height,null);
		this.setOpaque(false);
		
		super.paintComponent(g);
	}
	
}

