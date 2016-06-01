package Vistas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

@SuppressWarnings("serial")
public class CostPanel extends JPanel{

	private JScrollPane panelCost;
	
	public CostPanel(){
		
		this.initializeAttribute();
		this.setLayout(new GridBagLayout());
		
		this.construirTitulo();
		this.construirTablaCostos();
		this.setBackground(Color.pink);

		this.setPreferredSize(new Dimension(350,350));
	}	
	
	private void initializeAttribute(){
		
		this.panelCost = new JScrollPane();
		this.panelCost.setPreferredSize(new Dimension(200,200));
	
	}
	
	private void construirTitulo (){
		
		JLabel title = new JLabel("Tabla de Costos");
		
		GridBagConstraints c = this.position(0, 0);
		c.anchor = GridBagConstraints.NORTH;
		c.weighty = 1.0;
		
		title.setFont(new java.awt.Font("Tahoma", 0, 36));
		this.add(title,c);
		
	}
	
	private void construirTablaCostos(){
		
		Object[] total = new Object[2];
		 
		TableModel tabla = new TableModel();// definimos el objeto tableModel
		JTable tablaDeCostos = new JTable();// creamos la instancia de la tabla
		tablaDeCostos.setModel(tabla); 
		
		tabla.addColumn("Proyecto");
		tabla.addColumn("Costo");	
		
		total[0] = "Alfa";
		total[1] = "$ 20000";
		
		//Configuraciones de fuente de la tabla
		tablaDeCostos.getTableHeader().setReorderingAllowed(true);
		tablaDeCostos.getColumnModel().getColumn(0).setMaxWidth(100);
		tablaDeCostos.getColumnModel().getColumn(1).setMaxWidth(150);
		this.configurarFuenteTabla(tablaDeCostos);
		tabla.addRow(total);		
		
		this.panelCost.setViewportView(tablaDeCostos);
		
		GridBagConstraints c = this.position(0, 1);
		c.anchor = GridBagConstraints.NORTH;
		c.weighty = 1.0;
		this.add(this.panelCost,c);
				 
	}
	
	private GridBagConstraints position(int posX, int posY){
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = posX;
		c.gridy = posY;
		c.insets = new Insets(5, 5, 5, 5);
		
		return c;
		
	}
	
	private void configurarFuenteTabla(JTable table){
		
		Font negrilla = new Font( "Arial",Font.BOLD,12 );
		table.setFont(negrilla);
		JTableHeader th;
		th = table.getTableHeader();
		Font fuente = new Font("Arial", Font.BOLD, 15);
		th.setFont(fuente); 
	}
}
