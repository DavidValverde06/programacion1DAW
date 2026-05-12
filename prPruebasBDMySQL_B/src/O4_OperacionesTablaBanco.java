import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.sql.*;
import java.util.Scanner;

/**
 * Clase que muestra un ejemplo de como crear y cargar con datos desde un
 * fichero la tabla Banco
 * 
 * @author: Rosario Olmedo
 */

public class O4_OperacionesTablaBanco {

	/**
	 * Método principal
	 * @param args
	 */
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/mibase";
		String usuario = "david";
		String clave   = "1234";
		
		try (Connection conexion = DriverManager.getConnection(url, usuario, clave)) { // try con recursos

			if (conexion!=null) {
				System.out.println("Conexion establecida");
				
				// creaTablaBanco(conexion, "mibase");  // Crea la tabla
				// cargaTablaBanco(conexion, "mibase"); // Añade datos
				
				consultaBanco(conexion);             // Consulta los datos
				getMetaData(conexion);               // Obtiene la estructura de la tabla
			}
		}
		
		catch (SQLException e2) {
			printSQLException(e2); 
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * Crea la tabla Banco
	 * @param con: Conexion
	 * @param BDNombre: Nombre de la base de datos
	 */
	public static void creaTablaBanco(Connection con, String BDNombre) 
	{
  	    String creaTabla =
				 "create table " + BDNombre + ".BANCO " +
                 "(client VARCHAR(100) NOT NULL, "  +
                 "password VARCHAR(20) NOT NULL, " +
                 "balance INT NOT NULL, " +
                 " PRIMARY KEY(client))";
   	    
		try (Statement stmt = con.createStatement()){
			stmt.executeUpdate(creaTabla);
			System.out.println("Tabla BANCO creada.");
		}
		catch(SQLException e) {
			printSQLException(e);
		}
	}

		
	/**
	 * Añade datos desde un fichero a la tabla BANCO
	 * @param con
	 * @param BDNombre
	 */
	public static void cargaTablaBanco(Connection con, String BDNombre) {
		
		String client, password;
		int balance;
		
		try (Scanner sc = new Scanner(Path.of("./datos.txt"), StandardCharsets.UTF_8); 
			 Statement stmt = con.createStatement();
			 ) { // try con recursos
			  
		   do {
			   // Lee del fichero los datos de un cliente (nombre, clave, balance)
			   client = sc.nextLine();   
			   password = sc.nextLine();
			   balance = Integer.parseInt(sc.nextLine());           
		       
		       // Forma la sentencia para insertar el cliente obtenido del fichero
		       String sqlString = "insert into "+BDNombre+".BANCO values ("
		                 + "'"+ client + "', '" + password + "', "+ balance + ")";
		       
		       System.out.println("Se ha ejecutado: "+sqlString);
		       
		       // Añade el cliente al fichero
		       stmt.executeUpdate(sqlString);
		       
		       sc.nextLine(); // Lectura de los guiones "------" del fichero
		      }
	  	   while (sc.hasNextLine()); 
		} // end try 
		catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		} 
		catch (IOException e2) {
			System.out.println("Error de E/S");;
		}
		catch (SQLException e1) {
			printSQLException(e1);
		} 
	}

	
	/**
	 * Realiza una consulta de todos los datos de la tabla BANCO
	 * @throws SQLException
	 */
	public static void consultaBanco(Connection con) {
		String sqlString = "SELECT * FROM BANCO";

		try (Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(sqlString);
				) { // try con recursos

			while (rs.next()) {
				// Forma 1 - Obtener los datos a partir de su nombre
				System.out.println(rs.getString("client") + " " + 
						rs.getString("password") + " " +
						rs.getInt("balance"));

				// Forma 2 - Obtener los datos a partir de su posición
				System.out.println(rs.getString(1) + " " + 
						rs.getString(2) + " " +
						rs.getInt(3));
			}     
		} // end try
		catch (SQLException e1) {
			printSQLException(e1);
		} 
	}

	
	/**
	 * Muestra la estructura de la tabla banco
	 * @param con
	 * @throws SQLException
	 */
	public static void getMetaData(Connection con) {

	    String sqlString = "SELECT * FROM BANCO";
	    
	    try (Statement statement = con.createStatement();
	    		ResultSet rs = statement.executeQuery(sqlString);) {

	    	ResultSetMetaData metaData = rs.getMetaData();
	    	int noColumns = metaData.getColumnCount();
	    	for (int i=1; i<=noColumns; i++) {
	    		System.out.println(metaData.getColumnName(i) 
	    				+ " " +
	    				metaData.getColumnType(i));
	    	}
	    } // end try
	    catch (SQLException e1) {
	    	printSQLException(e1);
	    } 
	}

	
	/**
	 * 
	 * Muestra informacion mas detallada sobre una excepcion tipo SQLException
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

