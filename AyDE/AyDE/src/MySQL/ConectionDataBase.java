package MySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import clases.Desarrollador;
import clases.Proyecto;

public class ConectionDataBase {
	
		public String db = "ayde";
		public String host = "db4free.net";
	    public String url = "jdbc:mysql://"+ host + "/"+ db;
	    public String user = "untref";
	    public String pass = "software2016";
	
	    private Connection connection;

	   public Connection Conectar(){

	       connection = null;

	       try{
	    	   
	           Class.forName("com.mysql.jdbc.Driver");
	           connection = DriverManager.getConnection(this.url, this.user, this.pass);	
	           
	       }catch(Exception ex){
	    	   
	    	   JOptionPane.showMessageDialog(null, ex);	    	  
	       }

	       return connection;
	   }
	
		public void imprimirTablaDeEmpleados() throws SQLException{
			
			java.sql.PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM empleados");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()){
				System.out.println("Nombre: "+ rs.getString("nombre_apellido"));
				System.out.println("Legajo: "+ rs.getString("legajo"));
				System.out.println("Puesto: "+ rs.getString("puesto"));
				System.out.println("Sueldo: "+ rs.getString("sueldo"));
			}
			
			rs.close();
			stmt.close();
		}
		
		public void insertarEmpleado(String nombre_apellido, Integer legajo, String puesto) throws SQLException{
			
			try{
				java.sql.PreparedStatement stmt = this.connection.prepareStatement("INSERT INTO empleados (nombre_apellido, legajo, puesto) VALUES (?, ? ,?)");
				stmt.setString(1,nombre_apellido);
				stmt.setInt(2,legajo);
				stmt.setString(3,puesto);
				
				stmt.executeUpdate();
				
				stmt.close();
			
			}catch (Exception ex){
				
				JOptionPane.showMessageDialog(null, "ERROR: No puede ingresar dos empleados con el mismo legajo");
			}
		}
		
		public void insertarDedicacionEmpleado(Integer idEmpleado, String dedicacion,Date date,Integer id_proyecto) throws SQLException{
			
			try{
				java.sql.PreparedStatement stmt = this.connection.prepareStatement("INSERT INTO Dedicacion (empleado, porcentaje_dedicacion, fecha_carga, proyecto) VALUES (?, ?, ?, ?)");
				stmt.setInt(1,idEmpleado);
				stmt.setInt(2,Integer.parseInt(dedicacion.toString()));
				stmt.setDate(3,date);
				stmt.setInt(4,id_proyecto);
				
				stmt.executeUpdate();
				
				stmt.close();
			
			}catch (Exception ex){
				
				JOptionPane.showMessageDialog(null, "ERROR: No se pudo cargar la dedicacion" + ex);
			}
		}
		
		public void eliminarEmpleado(Integer legajo) throws SQLException{
			
			java.sql.PreparedStatement stmt = this.connection.prepareStatement("DELETE FROM empleados WHERE legajo = ?");
			stmt.setString(1,legajo.toString());
			
			stmt.executeUpdate();
			
			stmt.close();
		}	
		
		public Map<Integer,ArrayList<Desarrollador>> obtenerDesarrolladoresPorProyecto(int mes) throws SQLException{
			
			Map<Integer,ArrayList<Desarrollador>> empleados = new HashMap<Integer,ArrayList<Desarrollador>>();
			Desarrollador desarrollador;
			java.sql.PreparedStatement stmt = this.connection.prepareStatement( "SELECT SUM(Dedicacion.porcentaje_dedicacion), empleados.*, Dedicacion.proyecto " +
					"FROM Dedicacion, empleados " +
					"WHERE empleados.id_empleado = Dedicacion.empleado and MONTH(Dedicacion.fecha_carga) = ? "+		
					"GROUP BY Dedicacion.proyecto, empleados.id_empleado");
			
			stmt.setInt(1,mes);
			int id;
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()){
				
				desarrollador = new Desarrollador();
				id = Integer.parseInt((rs.getString("Dedicacion.proyecto")));
				
				desarrollador.setId(Integer.parseInt((rs.getString("id_empleado"))));
				desarrollador.setNombre((rs.getString("nombre_apellido")));
				desarrollador.setLegajo(Integer.parseInt(rs.getString("legajo")));
				desarrollador.setPuesto(rs.getString("puesto"));
				desarrollador.setDedicacion(Integer.parseInt(rs.getString("SUM(Dedicacion.porcentaje_dedicacion)")));
				desarrollador.ingresarSalario(Integer.parseInt(rs.getString("sueldo")));
				
				if (!empleados.keySet().contains(id)){					
					empleados.put(id, new ArrayList<Desarrollador>());
				}
				
				empleados.get(id).add(desarrollador);
			}
			
			rs.close();
			stmt.close();
			
			return empleados;
		}
		
		public ArrayList<Desarrollador> obtenerDesarrolladores() throws SQLException{
			
			ArrayList<Desarrollador> empleados = new ArrayList<Desarrollador>();
			Desarrollador desarrollador;
			java.sql.PreparedStatement stmt = this.connection.prepareStatement( "SELECT * FROM empleados");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()){
				
				desarrollador = new Desarrollador();
				
				desarrollador.setId(Integer.parseInt((rs.getString("id_empleado"))));
				desarrollador.setNombre((rs.getString("nombre_apellido")));
				desarrollador.setLegajo(Integer.parseInt(rs.getString("legajo")));
				desarrollador.setPuesto(rs.getString("puesto"));				
				desarrollador.ingresarSalario(Integer.parseInt(rs.getString("sueldo")));
	
				empleados.add(desarrollador);
			}
			
			rs.close();
			stmt.close();
			
			return empleados;
		}
		
		private ArrayList<Proyecto> cargaDeProyectos(java.sql.PreparedStatement stmt) throws SQLException{
			
			ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
			Proyecto proyecto;
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()){
				
				proyecto = new Proyecto();
				
				proyecto.setNombre((rs.getString("nombre")));
				proyecto.setId(Integer.parseInt(rs.getString("id_proyecto")));
				
				proyectos.add(proyecto);
			}
			
			rs.close();
			stmt.close();
			
			return proyectos;
		}
		
		public ArrayList<Proyecto> obtenerProyectos() throws SQLException{
						
			java.sql.PreparedStatement stmt = this.connection.prepareStatement( "SELECT * FROM Proyecto");
			
			return this.cargaDeProyectos(stmt);
		}
		
		public ArrayList<Proyecto> obtenerProyectosActuales(int mes) throws SQLException{
			
			
			java.sql.PreparedStatement stmt = this.connection.prepareStatement( "SELECT DISTINCT Proyecto.* FROM Dedicacion, Proyecto WHERE Dedicacion.proyecto = Proyecto.id_proyecto AND MONTH(Dedicacion.fecha_carga) = ? ");						
			stmt.setInt(1,mes);
			
			return this.cargaDeProyectos(stmt);
		}	
		
}
