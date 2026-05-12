/**
 * Ejemplo que muestra información sobre las tablas que hay en la Base de Datos
 * 
 * @author Rosario Olmedo
 */

import java.sql.*;
import java.util.Properties;

public class O6_ConsultaTablas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Usamos un objeto de properties para pasar de una manera 
		// más fácil el user, password
		Properties props = new Properties();		
		props.put("user", "david");
		props.put("password", "1234");

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mibase", props);
				
				// Creamos el objeto para enviar sentencias SQL
				Statement st = con.createStatement();

				// Enviamos una sentencia especial, para listar las tablas disponibles en la BD
				// Almacenamos el resultado para recorrerlo despues
				ResultSet rs = st.executeQuery("SHOW TABLES");
				
				) { // try con recursos (Connection, Statement y ResultSet)
			
			// De esta forma vamos a saber si hay tablas o no
			boolean hayFilas = false;
			while(rs.next()) {
				hayFilas = true;
				System.out.println(rs.getString(1));
			}
			if (!hayFilas) {
				System.out.println("No hay resultados que mostrar");
			}
		} 
		catch (SQLException e) {			
			e.printStackTrace();
		} 
	}
}
