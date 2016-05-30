package MySQL;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
				stmt.setString(2,legajo.toString());
				stmt.setString(3,puesto);
				
				stmt.executeUpdate();
				
				stmt.close();
			
			}catch (Exception ex){
				
				JOptionPane.showMessageDialog(null, "ERROR: No puede ingresar dos empleados con el mismo legajo");
			}
		}
		
		public void eliminarEmpleado(Integer legajo) throws SQLException{
			
			java.sql.PreparedStatement stmt = this.connection.prepareStatement("DELETE FROM empleados WHERE legajo = ?");
			stmt.setString(1,legajo.toString());
			
			stmt.executeUpdate();
			
			stmt.close();
		}
		
		public ArrayList<String> obtenerDedidacionParaDesarrollador(Integer legajo_desarrollador, String nombre_proyecto,Integer mes ) throws SQLException{
			
			ArrayList<String> dedicaciones = new ArrayList<String>();
			String data,space=" ";
			
			java.sql.PreparedStatement stmt = this.connection.prepareStatement(
					"SELECT empleados.nombre_apellido, empleados.legajo, empleados.puesto, Dedicacion.porcentaje_dedicacion, Proyecto.nombre " +
					"FROM Dedicacion, Proyecto, empleados " +
					"WHERE Dedicacion.empleado = empleados.id_empleado AND Dedicacion.proyecto = Proyecto.id_proyecto AND empleados.legajo = ? AND MONTH(Dedicacion.fecha_carga) = ? AND Proyecto.nombre = ?"
			);
			
			stmt.setString(1,legajo_desarrollador.toString());
			stmt.setString(2,mes.toString());
			stmt.setString(3,nombre_proyecto);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()){
				data = "";
				data = data + (rs.getString("empleados.nombre_apellido")) + space;
				data = data + (rs.getString("empleados.legajo") + space);
				data = data + (rs.getString("empleados.puesto")) + space;
				data = data + (rs.getString("Dedicacion.porcentaje_dedicacion")) + space;
				data = data + (rs.getString("Proyecto.nombre"));
				
				dedicaciones.add(data);
			}
			
			rs.close();
			stmt.close();
			
			return dedicaciones;
		}
		
}
