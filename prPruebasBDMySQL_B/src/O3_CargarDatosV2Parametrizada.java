import java.sql.*;


/**
 * Clase que muestra un ejemplo de como "cargar" datos en unas
 * tablas ya existentes en una base de datos
 * 
 * En esta versión la carga de datos se realiza de forma parametrizada
 * para evitar los ataques de hacker mediante "SQL INJECTION"
 * 
 * @author: Rosario Olmedo
 */

public class O3_CargarDatosV2Parametrizada {

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
	
		insertaEquipo(1,"ESTEPONA","MONTERROSO","ESTEPONA","MALAGA","29680", con);
		
		insertaEquipo(2,"ALCORCON","SANTO DOMINGO","ALCORCON","MADRID","28924", con);
		
		insertaEquipo(3,"PORCUNA","SAN CRISTOBAL","PORCUNA","JAEN","23790", con);
		
		System.out.println("Datos cargados en la tabla EQUIPOS.");

	}
	
	
	/**
	 * Método que va insertando los datos de los equipos de forma parametrizada para evitar la Inyección SQL 
	 * @param codigo
	 * @param nombre
	 * @param estadio
	 * @param poblacion
	 * @param provincia
	 * @param codPostal
	 * @param con
	 */
	private static void insertaEquipo(int codigo, String nombre, String estadio, String poblacion, 
									  String provincia, String codPostal, Connection con)  {
		
		try (PreparedStatement ps = con.prepareStatement("INSERT into Equipo VALUES (?,?,?,?,?,?)")){

			ps.setInt(1, codigo);
			ps.setString(2, nombre);
			ps.setString(3, estadio);
			ps.setString(4, poblacion);
			ps.setString(5, provincia);
			ps.setString(6, codPostal);
			
			ps.executeUpdate();
		}
		catch(SQLException e) {
			printSQLException(e);
		}
	}


	/**
	 * Añade datos a la tabla JUGADORES
	 * @param con
	 * @param BDNombre
	 */
	public static void cargaJugadores(Connection con, String BDNombre) {
		
		// Cargando datos del Estepona
		insertaJugador(1,1,"JOSE ANTONIO",1,42,"MALAGA",con);
		insertaJugador(2,1,"IGNACIO",2,62,"MALAGA",con);
		insertaJugador(3,1,"DIEGO",3,20,"CORDOBA",con);
		
		// Cargando datos del Alcorcón
		insertaJugador(4,2,"TURRION",1,37,"MALAGA",con);
		insertaJugador(5,2,"LUIS ABEL",2,37,"GRANADA",con);
		insertaJugador(6,2,"ISAAC",3,40,"MALAGA",con);
		
		// Cargando datos de Porcuna
		insertaJugador(7,3,"JUAN FRANCISCO",1,33,"SEVILLA",con);
		insertaJugador(8,3,"PARRA",2,37,"CORDOBA",con);
		insertaJugador(9,3,"RAUL",3,19,"JAEN",con);
		
		System.out.println("Datos cargados en la tabla JUGADORES.");
	}
	
	
	/**
	 * Método que añade un jugador de forma parametrizada
	 * @param codJugador
	 * @param codEquipo
	 * @param nombre
	 * @param dorsal
	 * @param edad
	 * @param provincia
	 * @param con
	 */
	private static void insertaJugador(int codJugador, int codEquipo, String nombre, int dorsal,
									   int edad, String provincia, Connection con) {

		try (PreparedStatement ps = con.prepareStatement("INSERT into Jugadores VALUES (?,?,?,?,?,?)")){

			ps.setInt(1, codJugador);
			ps.setInt(2, codEquipo);
			ps.setString(3, nombre);
			ps.setInt(4, dorsal);
			ps.setInt(5, edad);
			ps.setString(6, provincia);
			
			ps.executeUpdate();
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


