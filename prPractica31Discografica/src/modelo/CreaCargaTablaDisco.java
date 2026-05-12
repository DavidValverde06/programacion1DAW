package modelo;
import java.sql.*;
import java.util.Scanner;
import fechas.LibFechas8;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;


public class CreaCargaTablaDisco {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/discografica";
		String usuario = "admin";
		String clave   = "1234";

		try (Connection conexion = DriverManager.getConnection(url, usuario, clave)){
				
			System.out.println("Conexion establecida");
			
			// Metodo que crea la tabla disco
			creaTablaDiscos(conexion);
			
			// Metodo que carga datos en la tabla disco a partir de un fichero
			cargaTablaDiscos(conexion);
		}
		catch (SQLException e) {
			printSQLException(e);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Crea la tabla DISCOS
	 * @param con: Conexion
	 */
	public static void creaTablaDiscos(Connection con) throws SQLException
	{
		String creaTabla = "create table discografica.discos " +
	                       "(codigo INT NOT NULL PRIMARY KEY, " +
				           "titulo VARCHAR(50) NOT NULL, " +
	                       "autor VARCHAR(50) NOT NULL, " +
				           "fechaPubli DATE, " +
	                       "precio DOUBLE)";

		System.out.println("Se va a ejecutar: "+creaTabla);
		
		try (Statement stmt = con.createStatement()) {
			stmt.executeUpdate(creaTabla);
			System.out.println("Tabla discos creada");
		}
		
	}

		
	/**
	 * A�ade datos desde un fichero a la tabla discos
	 * @param con
	 * @throws SQLException
	 */
	public static void cargaTablaDiscos(Connection con) throws SQLException {

		try (Scanner sc = new Scanner(Path.of("./files/discos.txt"),StandardCharsets.UTF_8)){
			
			while (sc.hasNextLine()) {

				String [] arrayDatos = sc.nextLine().split("-");

				String sqlString = "INSERT INTO discos VALUES (?,?,?,?,?)";
				
				try (PreparedStatement ps = con.prepareStatement(sqlString)) {

					ps.setInt(1, Integer.parseInt(arrayDatos[0])); // Código
					ps.setString(2, arrayDatos[1]); // Título
					ps.setString(3, arrayDatos[2]); // Autor
					ps.setDate(4, Date.valueOf(LibFechas8.convierteStringToLocalDate(arrayDatos[3]))); // Fecha
					ps.setDouble(5, Double.parseDouble(arrayDatos[4])); // Precio

					ps.executeUpdate();
				}
			}
			System.out.println("Discos volcados desde fichero correctamente");
		}
		catch (IOException e) {
			e.printStackTrace();
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
