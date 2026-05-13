package modelo;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class CargarTablasProyecto {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/cine";
		String usuario = "admin";
		String clave   = "admin";

		try (Connection conexion = DriverManager.getConnection(url, usuario, clave)) {

			System.out.println("CONEXION A LA BASE DE DATOS ESTABLECIDA\n");

			// Metodo que carga datos en la tabla pelicula a partir de un fichero
			cargaTablaPeliculas(conexion);

			// Metodo que carga datos en la tabla sala a partir de un fichero
			cargaTablaSalas(conexion);

			// Metodo que carga datos en la tabla sesion a partir de un fichero
			cargaTablaSesiones(conexion);

			// Metodo que carga datos en la tabla cliente a partir de un fichero
			cargaTablaClientes(conexion);
		}
		catch (SQLException e) {
			printSQLException(e);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Añade datos desde un fichero a la tabla peliculas
	 */
	public static void cargaTablaPeliculas(Connection con) throws SQLException {

		try (Scanner sc = new Scanner(Path.of("./files/peliculas.txt"),StandardCharsets.UTF_8)){

			while (sc.hasNextLine()) {

				String [] arrayDatos = sc.nextLine().split("-");

				String sqlString = "INSERT INTO pelicula VALUES (?,?,?,?,?,?,?)";

				try (PreparedStatement ps = con.prepareStatement(sqlString)) {

					ps.setInt(1, Integer.parseInt(arrayDatos[0])); 	// id_pelicula
					ps.setString(2, arrayDatos[1]); 				// titulo
					ps.setString(3, arrayDatos[2]); 				// genero
					ps.setInt(4 , Integer.parseInt(arrayDatos[3])); // duracion
					ps.setString(5, arrayDatos[4]); 				// clasificacion
					ps.setString(6, arrayDatos[5]); 				// director
					ps.setInt(7, Integer.parseInt(arrayDatos[6])); 	// anio

					ps.executeUpdate();
				}
			}

			System.out.println("PELICULAS VOLCADAS DESDE EL FICHERO CORRECTAMENTE");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Añade datos desde un fichero a la tabla salas
	 */
	public static void cargaTablaSalas(Connection con) throws SQLException {

		try (Scanner sc = new Scanner(Path.of("./files/salas.txt"), StandardCharsets.UTF_8)) {

			while (sc.hasNextLine()) {

				String[] arrayDatos = sc.nextLine().split(";");

				String sqlString = "INSERT INTO cine.sala VALUES (?,?,?,?)";

				try (PreparedStatement ps = con.prepareStatement(sqlString)) {

					ps.setInt(1, Integer.parseInt(arrayDatos[0]));    // id_sala
					ps.setInt(2, Integer.parseInt(arrayDatos[1]));    // num_sala
					ps.setInt(3, Integer.parseInt(arrayDatos[2]));    // capacidad
					ps.setString(4, arrayDatos[3]);                   // tipo

					ps.executeUpdate();
				}
			}

			System.out.println("SALAS VOLCADAS DESDE EL FICHERO CORRECTAMENTE");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Añade datos desde un fichero a la tabla sesiones
	 */
	public static void cargaTablaSesiones(Connection con) throws SQLException {

		try (Scanner sc = new Scanner(Path.of("./files/sesiones.txt"), StandardCharsets.UTF_8)) {

			while (sc.hasNextLine()) {

				String[] arrayDatos = sc.nextLine().split(";");

				String sqlString = "INSERT INTO cine.sesion VALUES (?,?,?,?,?,?)";

				try (PreparedStatement ps = con.prepareStatement(sqlString)) {

					ps.setInt(1, Integer.parseInt(arrayDatos[0]));           // id_sesion
					ps.setInt(2, Integer.parseInt(arrayDatos[1]));           // id_pelicula
					ps.setInt(3, Integer.parseInt(arrayDatos[2]));           // id_sala
					ps.setDate(4, Date.valueOf(arrayDatos[3]));              // fecha
					ps.setInt(5, Integer.parseInt(arrayDatos[4]));           // hora
					ps.setDouble(6, Double.parseDouble(arrayDatos[5]));      // precio

					ps.executeUpdate();
				}
			}

			System.out.println("SESIONES VOLCADAS DESDE EL FICHERO CORRECTAMENTE");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Añade datos desde un fichero a la tabla clientes
	 */
	public static void cargaTablaClientes(Connection con) throws SQLException {

		try (Scanner sc = new Scanner(Path.of("./files/clientes.txt"), StandardCharsets.UTF_8)) {

			while (sc.hasNextLine()) {

				String[] arrayDatos = sc.nextLine().split(";");

				String sqlString = "INSERT INTO cine.cliente VALUES (?,?,?,?,?)";

				try (PreparedStatement ps = con.prepareStatement(sqlString)) {

					ps.setInt(1, Integer.parseInt(arrayDatos[0]));    // id_cliente
					ps.setInt(2, Integer.parseInt(arrayDatos[1]));    // id_sesion
					ps.setString(3, arrayDatos[2]);                   // nombre
					ps.setString(4, arrayDatos[3]);                   // apellidos
					ps.setString(5, arrayDatos[4]);                   // email

					ps.executeUpdate();
				}
			}

			System.out.println("CLIENTES VOLCADOS DESDE EL FICHERO CORRECTAMENTE");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método que muestra una descripcion completa de la excepcion
	 * que se ha producido
	 * 
	 * @param ex -- Excepcion SQL generada
	 */
	public static void printSQLException(SQLException ex) {

		ex.printStackTrace(System.err);
		System.err.println("SQLState: " + ex.getSQLState());
		System.err.println("Error code: " + ex.getErrorCode());
		System.err.println("Message: " + ex.getMessage());
		Throwable t = ex.getCause();

		while (t!=null) {
			System.out.println("Cause: " + t);
			t = t.getCause();
		}
	}

}
