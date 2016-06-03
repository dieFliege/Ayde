package Vistas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.JTableHeader;

@SuppressWarnings("serial")
public class CostPanel extends JPanel{

	private JScrollPane panelCost;
	
	public CostPanel(){
		
		this.initializeAttribute();
		this.setLayout(new GridBagLayout());
	
		this.construirTablaCostos();
		this.setBackground(Color.pink);

		this.setPreferredSize(new Dimension(350,350));
		
		Border border = BorderFactory.createLineBorder(Color.black);		
		this.setBorder(BorderFactory.createTitledBorder(border,"Tabla de costos de proyectos", TitledBorder.CENTER, TitledBorder.TOP, null, Color.black));
		
	}	
	
	private void initializeAttribute(){
		
		this.panelCost = new JScrollPane();
		this.panelCost.setPreferredSize(new Dimension(300,300));
				
	}
	
	private void construirTablaCostos(){
		
		Object[] total = new Object[2];
		 
		TableModel tabla = new TableModel();// definimos el objeto tableModel
		JTable tablaDeCostos = new JTable();// creamos la instancia de la tabla		
		tablaDeCostos.setModel(tabla); 
		
		tabla.addColumn("Proyecto");
		tabla.addColumn("Costo");	
		
		//Los datos se tiene que calcular segun lo que esta en la base de datos
		total[0] = "Alfa";
		total[1] = "$ 20000";
		
		//Configuraciones de fuente de la tabla
		tablaDeCostos.getTableHeader().setReorderingAllowed(false);
		tablaDeCostos.getColumnModel().getColumn(0).setMaxWidth(150);
		tablaDeCostos.getColumnModel().getColumn(1).setMaxWidth(150);
		this.configurarFuenteTabla(tablaDeCostos);
		tabla.addRow(total);		
		
		this.panelCost.setViewportView(tablaDeCostos);
		
		GridBagConstraints c = this.position(0, 1);
		c.anchor = GridBagConstraints.CENTER;
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
