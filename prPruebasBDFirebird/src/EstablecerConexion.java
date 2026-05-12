import java.sql.*;

public class EstablecerConexion {

	public static void main(String[] args) {
		
		Connection conexion = null;
		try {
			// Registrar la conexión / Levantas el JDBC
			String driver = "org.firebirdsql.jdbc.FBDriver";
			
			Class.forName(driver);
			System.out.println("Conexion registrada");
			
			// Establecer la conexion
			//String url = "jdbc:firebirdsql:localhost/3050:c:\\bd\\mibase.fdb";
	//		String url = "jdbc:firebirdsql:localhost/3050:d:\\MIBASE.FDB";
	//		String url = "jdbc:firebirdsql://[::127.0.0.1]:3050:d://MIBASE.FDB";
			
			String url = "jdbc:firebirdsql:localhost:d:\\MIBASE.FDB:db?encoding=ISO8859_1";
		//	WireCrypt = Enabled
				          
			String usuario = "sysdba";
		//	String clave   = "masterkey";
			String clave   = "root";
			conexion = DriverManager.getConnection(url, usuario, clave);
			
			   
	 		System.out.println("Conexi�n establecida");
		}
		catch (SQLException e1) {
			printSQLException(e1);
		}
		catch (Exception e2) {
			e2.printStackTrace();
		}
		finally {
			try {
				conexion.close();
				System.out.println("Conexion cerrada");
			}
			catch (SQLException e) {
				printSQLException(e);
			}
		}
	}

	
	/**
	 * Metodo que muestra una descripcion completa de la excepcion
	 * que se ha producido
	 * @param ex -- Excepcion SQL generada
	 */
	public static void printSQLException(SQLException ex)
	{
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








