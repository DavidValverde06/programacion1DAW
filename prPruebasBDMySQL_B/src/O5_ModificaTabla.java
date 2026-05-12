import java.sql.*;

/**
 * Clase que muestra un ejemplo de como modificar datos de tablas, concretamente:
 *    -- Modifica el nombre de un equipo
 *    -- Modifica la edad de todos los jugadores
 *    -- Inserta un nuevo jugador
 * 
 * @author: Rosario Olmedo
 */

public class O5_ModificaTabla {
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/mibase";
		String usuario = "david";
		String clave   = "1234";
		
		try (Connection conexion = DriverManager.getConnection(url, usuario, clave)) { // try con recursos

			if (conexion!=null) {
				System.out.println("Conexion establecida");

				// Metodo que modifica una columna en la tabla equipo
				modificaEquipo(conexion, "mibase");

				// Metodo que modifica la edad de los jugadores
				modificaEdadJugadores(conexion, "mibase", 2);

				// Metodo que inserta un nuevo jugador 
				insertaJugador(conexion, "mibase", 10, 2, "PABLO", 4, 25, "CORDOBA"); 
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
	 * Método que modifica el nombre del estadio del equipo de código 1 
	 * @param con
	 * @param BDNombre
	 * @throws SQLException
	 */
	public static void modificaEquipo(Connection con, String BDNombre) {

		try (Statement stmt = con.createStatement()) {

			stmt.executeUpdate("UPDATE " + BDNombre +
					".EQUIPO SET ESTADIO='ALBORAN'" +
					" WHERE codEquipo = 1");
			System.out.println("Equipo actualizado");
		}
		catch(SQLException e) {
			printSQLException(e);
		}
	}

	
	/**
	 * Modifica la tabla JUGADORES, incrementando la edad de los jugadores en 
	 * lo que indique el parámetro "incremento", para ello utiliza ResultSet
	 * @param con
	 * @param BDNombre
	 * @param incremento
	 */
	public static void modificaEdadJugadores(Connection con, String BDNombre, int incremento) {

		int edadJugador; 
		try (Statement stmt = con.createStatement(
					        ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);

			 ResultSet rs = stmt.executeQuery("SELECT * FROM " + BDNombre + ".JUGADORES");
			) { // try con recursos

			while (rs.next()) {
				edadJugador = rs.getInt("EDAD");
				rs.updateInt("EDAD", edadJugador+incremento);
				rs.updateRow();
			}
			System.out.println("Edades actualizadas");
		}
		catch(SQLException e) {
				printSQLException(e);
		}
	}
	
	
	/**
	 * Inserta un nuevo jugador en la Tabla Jugadores-
	 * Los datos del jugador nos llegan como par�metro.
	 * Utiliza para ello un ResultSet
	 * @param con
	 * @param BDNombre
	 * @param codJu
	 * @param codEq
	 * @param nombre
	 * @param dorsal
	 * @param edad
	 */
	public static void insertaJugador(Connection con, String BDNombre, 
			int codJu, int codEq, String nombre, int dorsal, int edad, String provin) {

		try (Statement stmt = con.createStatement(
				ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_UPDATABLE);

				ResultSet rs = stmt.executeQuery("SELECT * FROM " + BDNombre + ".JUGADORES");
			) { // try con recursos

				rs.moveToInsertRow();
				rs.updateInt("codJugador", codJu);
				rs.updateInt("codEquipo", codEq);
				rs.updateString("nombre", nombre);
				rs.updateInt("dorsal", dorsal);
				rs.updateInt("edad", edad);
				rs.updateString("provincia", provin);
				rs.insertRow();
				rs.beforeFirst();
				System.out.println("Jugador añadido");
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
