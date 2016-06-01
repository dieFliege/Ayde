package Main;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JOptionPane;
import MySQL.ConectionDataBase;
import Vistas.Form;

public class Main {
	
	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		//Form form = new Form();	
		
		ConectionDataBase mysql = new ConectionDataBase();

	    java.sql.Connection cn= mysql.Conectar();

	        if(cn!=null){

	                JOptionPane.showMessageDialog(null, "Conectado");	
	                Map<String, ArrayList<ArrayList<String>>> dedicaciones = mysql.mapaDedicacionPorProyecto();
	                for (int i=0; i < dedicaciones.get("Gamma").size();i++){	                	
	                	System.out.println(dedicaciones.get("Gamma").get(i));	                
	                }
	                try{
	                    cn.close();
	                }catch(SQLException ex){
	                    System.out.println("Error al desconectar "+ex);
	                }
	        }    	     
	}
}
