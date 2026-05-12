import java.sql.*;

/**
 * Clase que muestra un ejemplo de como "cargar" datos en unas
 * tablas ya existentes en una base de datos
 * 
 * @author: Rosario Olmedo
 */
public class O3_CargarDatos {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/mibase";
		String usuario = "david";
		String clave   = "1234";
		
		try (Connection conexion = DriverManager.getConnection(url, usuario, clave)) { // try con recursos

			if (conexion!=null) {
				System.out.println("Conexion establecida");

				// Llamar a un metodo que inserta datos en la tabla Equipos
				cargaEquipos(conexion, "mibase");

				// Llamar a un metodo que inserta datos en la tabla Jugadores
				cargaJugadores(conexion, "mibase");
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
	 * Añade datos a la tabla equipos
	 * @param con
	 * @param BDNombre
	 */
	public static void cargaEquipos(Connection con, String BDNombre) {

		try (Statement stmt = con.createStatement()) { // try con recursos

			stmt.executeUpdate("insert into "+BDNombre+".EQUIPO values ("+
					"1,'ESTEPONA','MONTERROSO','ESTEPONA','MALAGA','29680')");
			
			stmt.executeUpdate("insert into "+BDNombre+".EQUIPO values ("+
					"2,'ALCORCON','SANTO DOMINGO','ALCORCON','MADRID','28924')");
			
			stmt.executeUpdate("insert into "+BDNombre+".EQUIPO values ("+
					"3,'PORCUNA','SAN CRISTOBAL','PORCUNA','JAEN','23790')");
			
			System.out.println("Datos cargados en la tabla EQUIPOS.");
		}
		catch(SQLException e) {
			printSQLException(e);
		}
	}

	

	/**
	 * A�ade datos a la tabla JUGADORES
	 * @param con
	 * @param BDNombre
	 */
	public static void cargaJugadores(Connection con, String BDNombre) {

		try (Statement stmt = con.createStatement()) {

			// Cargando datos de Estepona
			stmt.executeUpdate("insert into "+BDNombre+".JUGADORES values ("+
					"1,1,'JOSE ANTONIO',1,42,'MALAGA')");
			stmt.executeUpdate("insert into "+BDNombre+".JUGADORES values ("+
					"2,1,'IGNACIO',2,62,'MALAGA')");
			stmt.executeUpdate("insert into "+BDNombre+".JUGADORES values ("+
					"3,1,'DIEGO',3,20,'CORDOBA')");

			// Cargando datos de Alcorcón
			stmt.executeUpdate("insert into "+BDNombre+".JUGADORES values ("+
					"4,2,'TURRION',1,37,'MALAGA')");
			stmt.executeUpdate("insert into "+BDNombre+".JUGADORES values ("+
					"5,2,'LUIS ABEL',2,37,'GRANADA')");
			stmt.executeUpdate("insert into "+BDNombre+".JUGADORES values ("+
					"6,2,'ISAAC',3,40,'MALAGA')");
			
			// Cargando datos de Porcuna
			stmt.executeUpdate("insert into "+BDNombre+".JUGADORES values ("+
					"7,3,'JUAN FRANCISCO',1,33,'SEVILLA')");
			stmt.executeUpdate("insert into "+BDNombre+".JUGADORES values ("+
					"8,3,'PARRA',2,37,'CORDOBA')");
			stmt.executeUpdate("insert into "+BDNombre+".JUGADORES values ("+
					"9,3,'RAUL',3,19,'JAEN')");
			
			System.out.println("Datos cargados en la tabla JUGADORES.");
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


