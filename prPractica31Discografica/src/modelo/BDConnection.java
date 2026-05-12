package modelo;

import java.sql.*;
import java.util.Properties;

/**
 * Esta clase implementa el patrón Singleton para obtener la conexión a la base de datos
 */
public class BDConnection {

	// Variable de clase constante con la ruta de la BD
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/discografica";
	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	
	// Variable de clase con el objeto que tendrá la conexión a la BD
	private static Connection instance = null;
	
	/**
	 * Constructor privado para evitar que puedan crearse objetos de esta clase
	 */
	private BDConnection() {}
	
	
	/**
	 * Método que devuelve una referencia a la conexión, si es la primera vez
	 * que se llama a este método la crea, y si ya se ha llamado previamente,
	 * como la conexión ya existe, simplemente la devuelve
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			// Registrar la conexion / Levantar el JDBC (Opcional)
			Class.forName(DRIVER_NAME);
			System.out.println("Conexion registrada");
			
			// Establecer la conexión
			Properties props = new Properties();
			props.put("user", "admin");
			props.put("password", "1234");
			instance = DriverManager.getConnection(JDBC_URL, props);
		}
		
		return instance;
	}
}



