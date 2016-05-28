package MySQL;

import java.sql.*;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class ConectionDataBase {
	

	    /**public String db = "ayde";
	    public String url = "jdbc:mysql://localhost/"+db;
	    public String user = "root";
	    public String pass = "aydeadministrator";**/
		public String db = "ayde";
		public String host = "db4free.net";
	    public String url = "jdbc:mysql://"+ host + "/"+ db;
	    public String user = "untref";
	    public String pass = "software2016";
	
	    private Connection connection;

	   public Connection Conectar(){

	       connection = null;

	       try{

	           Class.forName("com.mysql.jdbc.Driver");//"org.gjt.mm.mysql.Driver");

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
		
}
