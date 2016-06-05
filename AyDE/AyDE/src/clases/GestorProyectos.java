package clases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;

import MySQL.ConectionDataBase;

public class GestorProyectos {
	
	private ArrayList<Proyecto> proyectosActuales;
	private ArrayList<Proyecto> proyectos;
	private ArrayList<Desarrollador> empleados;
	private ConectionDataBase db;
	private java.sql.Connection conexion;	
	
	public GestorProyectos() throws SQLException{
			
		this.inicializar();		
	}
	
	public ConectionDataBase getDB(){
		return this.db;
	}
	
	private void inicializar() throws SQLException{
		
		this.conectarBaseDeDatos();
		this.setEmpleados(this.db.obtenerDesarrolladores());
		this.setProyectos(this.db.obtenerProyectos());
		
		Calendar fecha = new GregorianCalendar();
		int mesActual = fecha.get(Calendar.MONTH) + 1;
		this.proyectosActuales = this.db.obtenerProyectosActuales(mesActual);		
		this.cargarDesarrolladoresParaProyecto(mesActual);
	}
	
	public java.sql.Connection getConexion(){
		return this.conexion;
	}
	
	public ArrayList<Proyecto> getProyectosActuales(){
		return this.proyectosActuales;
	}
	
	public void cargarDesarrolladoresParaProyecto(int mes) throws SQLException{
		
		//Esta hardcodeado para que traiga solo los del mes de enero
		Map<Integer,ArrayList<Desarrollador>> mapa = this.db.obtenerDesarrolladoresPorProyecto(mes);
		ArrayList<Desarrollador> desarrolladores;
					
		for (int i=0; i < this.proyectosActuales.size(); i++){
			
			desarrolladores = mapa.get(this.proyectosActuales.get(i).getId());					
			this.proyectosActuales.get(i).setListaDesarrolladores(desarrolladores);	
			this.cargarEmpleadosEnProyecto(desarrolladores,this.proyectosActuales.get(i));
		}		
	}
	
	private void cargarEmpleadosEnProyecto(ArrayList<Desarrollador> desarrolladores, Proyecto proyecto){
		
			for (int i=0; desarrolladores != null && i < desarrolladores.size(); i++){				
				desarrolladores.get(i).setProyecto(proyecto);									
			}			
	}
	
	private void conectarBaseDeDatos(){
		
		this.db = new ConectionDataBase();		
		this.conexion = db.Conectar();
		
		//JOptionPane.showMessageDialog(null, "Conectado");
	}
	
	public void desconectarBaseDeDatos(){
		try{			
            this.conexion.close();
            
        }catch(SQLException ex){        	
            System.out.println("Error al desconectar ");
        }
	}
	
	public void actualizarDatos(int mes) throws SQLException{
		
		this.proyectosActuales = this.db.obtenerProyectosActuales(mes);		
		this.cargarDesarrolladoresParaProyecto(mes);

	}

	public ArrayList<Desarrollador> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<Desarrollador> empleados) {
		this.empleados = empleados;
	}

	public ArrayList<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(ArrayList<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}
		
}
