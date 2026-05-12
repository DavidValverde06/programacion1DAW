import java.sql.*;

/**
 * Clase que muestra un ejemplo de como establecer la conexión con una BD
 * En este caso utilizamos un try con recursos, así Java se encarga del cierre automático
 * 
 * Aclaración, cualquier clase que implemente la interfaz AutoCloseable
 *     (como Connection, Statement, PreparedStatement o ResultSet) es candidata 
 *     perfecta para el try-with-resources.
 * 
 * @author: Rosario Olmedo
 */

public class O1_EstablecerConexionV2 {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/mibase";
					// localhost: direccion de la maquina donde reside la base de datos
		   			// 3306: puerto donde escucha la BD
					// mibase, es el normbre de mi BD
		
		String usuario = "david";
		String clave   = "1234";
		


		try (Connection conexion = DriverManager.getConnection(url, usuario, clave)) {
			 
			if (conexion!=null) {
				System.out.println("Conexion establecida");
				// Aquí van nuestras operaciones sobre la BD (Statements, ResultSets, etc.)
			}
			
		}
		catch (SQLException e1) {
			printSQLException(e1);
		}
		catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	
	/**
	 * Método que muestra una descripción completa de la excepcion
	 * que se ha producido
	 * @param ex -- Excepcion SQL generada
	 */
	public static void printSQLException(SQLException ex) {
		
		ex.printStackTrace(System.err);
		System.err.println("SQLState: "+ex.getSQLState());
		System.err.println("Error code: "+ex.getErrorCode());
		System.err.println("Message: "+ex.getMessage());
		Throwable t = ex.getCause();
		while (t!=null) {
			System.out.println("Cause: "+t);
			t = t.getCause();
		}
	}
}
