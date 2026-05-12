import java.sql.*;

/**
 * Clase que muestra un ejemplo de como crear una par de tablas (Equipos y Jugadores)
 * a una base de datos ya existente
 * 
 * Aclaración, cualquier clase que implemente la interfaz AutoCloseable
 *     (como Connection, Statement, PreparedStatement o ResultSet) es candidata 
 *     perfecta para el try-with-resources.
 * 
 * @author: Rosario Olmedo
 */

public class O2_CrearTablas {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/mibase";
		String usuario = "david";
		String clave   = "1234";
		
		try (Connection conexion = DriverManager.getConnection(url, usuario, clave)) { // try con recursos

			if (conexion!=null) {
				System.out.println("Conexion establecida");
			
				// Llamar a un metodo que crea una tabla llamada equipo
				creaTablaEquipo(conexion, "mibase");
			
				// Llamar a un metodo que crea una tabla llamada Jugador
				creaTablaJugador(conexion, "mibase");
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
	 * @param con: Conexion
	 * @param BDNombre: Nombre de la base de datos
	 * Crea la tabla EQUIPOS
	 */
	public static void creaTablaEquipo(Connection con, String BDNombre) {
		
		String creaTabla = "create table " + BDNombre + ".EQUIPO " +
				"(codEquipo INT NOT NULL PRIMARY KEY, " +
				"nombre varchar(40) NOT NULL, " +
				"estadio varchar(40) NOT NULL, " +
				"poblacion varchar(20) NOT NULL, "+
				"provincia varchar(20) NOT NULL, "+
				"codPostal char(5)) ";
		
		System.out.println(creaTabla);
		
		try (Statement stmt = con.createStatement()){  // try con recursos
			stmt.executeUpdate(creaTabla);
			System.out.println("Tabla EQUIPO creada.");
		}
		catch(SQLException e) {
			printSQLException(e); 
		}
	}
	
	/**
	 * @param con: Conexion
	 * @param BDNombre: Nombre de la base de datos
	 * Crea la tabla JUGADORES
	 */
	public static void creaTablaJugador(Connection con, String BDNombre) {
		
		String creaTabla = "create table " + BDNombre + ".JUGADORES " +
				"(codJugador INT NOT NULL PRIMARY KEY, " +
				"codEquipo INT NOT NULL, " +
				"nombre varchar(40) NOT NULL, " +
				"dorsal int NOT NULL, "+
				"edad int NOT NULL, "+
				"provincia varchar(20) NOT NULL, "+
				"FOREIGN KEY (codEquipo) REFERENCES EQUIPO(codEquipo))";
		
		System.out.println(creaTabla);

		try (Statement stmt = con.createStatement()) {  // try con recursos
			stmt.executeUpdate(creaTabla);
			System.out.println("Tabla JUGADORES creada.");
		}
		catch(SQLException e) {
			printSQLException(e); 
		}
	}
	
	
	
	/**
	 * Método que muestra una descripcion completa de la excepcion
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


