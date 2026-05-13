package modelo;

import java.sql.*;
import java.util.*;
import javax.swing.table.*;

/**
 * Esta clase implementa el patrón DAO con la tabla peliculas, este patrón ofrece 
 * operaciones para interactuar con la base de datos. 
 * 
 * Se encarga de realizar todas las operaciones CRUD es el acrónimo de 
 * "Crear, Leer, Actualizar y Borrar" (del original en inglés: Create, 
 * Read, Update and Delete), que se usa para referirse a las funciones 
 * básicas en bases de datos o la capa de persistencia en un software.
 * 
 * Lo que este patrón pretende principalmente es independizar la aplicación
 * de la forma de acceder a la base de datos.
 */
public class DAOPelicula {

	/**
	 * Variables de instancia
	 */
	private Connection con;   		// Objeto con la conexión a la base de datos
	private Statement stmt;   		// Objeto que permite ejecutar sentencias SQL
	private ResultSet rsNavegar; 	// Resultado de la consulta para navegar por las filas de la tabla

	/**
	 * Constructor
	 * 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public DAOPelicula() throws ClassNotFoundException, SQLException {

		estableceConexion(); 	// Dar valor a la variable con (Connection)
		crearStatement();  		// Dar valor a la variable stmt (Statement)
		crearConsulta();  		// Dar valor a la variable rsNavegar (ResultSet)
	}

	/**
	 * Método que establece la conexión con la base de datos cine
	 * 
	 * @throws MiExcepcion 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void estableceConexion() throws ClassNotFoundException, SQLException {

		this.con = ConexionBaseDatos.getConnection();
		System.out.println("CONEXIÓN ESTABLECIDA");
	}

	/**
	 * Crear el objeto Statement, el cual nos va a permitir ejecutar instrucciones SQL
	 * 
	 * @throws SQLException 
	 */
	public void crearStatement() throws SQLException {

		// con.setAutoCommit(false);

		this.stmt = con.createStatement(
				ResultSet.TYPE_SCROLL_SENSITIVE,  	// Indica que el cursor es bidireccional y que refleja los cambios en la BD
				ResultSet.CONCUR_UPDATABLE);  		// Los datos del ResultSet son actualizables 

		/**
		 * En realidad no necesitamos que los datos del ResultSet sean actualizables, ya
		 * que estamos creando un nuevo objeto Statement (en concreto PreparedStatement)
		 * para realizar las actualizaciones de forma parametrizada, y evitar la SQL Injection
		 */

		// con.commit();
		// con.setAutoCommit(true);
	}

	/**
	 * Método que permite crear la consulta SQL para la navegación (primero, anterior, 
	 * siguiente y último) entre los distintas filas devueltas por la selección
	 *  
	 * @throws SQLException 
	 */
	public void crearConsulta() throws SQLException {

		String sqlString = "SELECT * FROM cine";

		this.rsNavegar = stmt.executeQuery(sqlString);
	}


	/**
	 * Método que cierra la conexión
	 * 
	 * @throws SQLException
	 */
	public void cierraConexion() throws SQLException {
		con.close();

		System.out.println("CONEXIÓN CERRADA");
	}

	/**
	 * Método que cierra el Statement
	 * @throws SQLException 
	 */
	public void cierraStatement() throws SQLException {
		stmt.close();
	}

	/**
	 * Método que recoge una fila o tupla de la tabla de resultados (ResultSet) 
	 * de la consulta, y devuelve con esos datos un objeto tipo Disco
	 * 
	 * Los datos que recoge, son los de la "tupla" en la que se encuentre posicionado
	 * rsNavegar en ese momento
	 * 
	 * @return
	 * @throws SQLException 
	 * @throws MiExcepcion 
	 */
	public Pelicula crearPelicula() throws MiExcepcion, SQLException {
		return new Pelicula(
				rsNavegar.getInt("id_pelicula"),
				rsNavegar.getString("titulo"),
				EnumGenero.valueOf(rsNavegar.getString("genero")),
				rsNavegar.getInt("duracion"),
				EnumClasificacion.valueOf(rsNavegar.getString("clasificacion")),
				rsNavegar.getString("director"),
				rsNavegar.getInt("anio"));
	}

	/**
	 * Método que devuelve el primer registro (tupla) de la consulta
	 * 
	 * @throws SQLException 
	 * @throws MiExcepcion 
	 */
	public Pelicula getPrimero() throws SQLException, MiExcepcion {
		this.rsNavegar.first();
		return this.crearPelicula();
	}

	/**
	 * Metodo que devuelve el ultimo registro (tupla) de la consulta
	 * 
	 * @throws MiExcepcion 
	 */
	public Pelicula getUltimo() throws SQLException, MiExcepcion {
		rsNavegar.last();
		return this.crearPelicula();
	}

	/**	 
	 * Metodo que devuelve el registro siguiente al acual
	 * 
	 * @throws MiExcepcion 
	 */
	public Pelicula getSiguiente() throws SQLException, MiExcepcion {
		rsNavegar.next();
		return this.crearPelicula();
	}

	/**
	 * Metodo que devuelve el registro anterior al actual
	 * 
	 * @throws MiExcepcion 
	 */
	public Pelicula getAnterior() throws SQLException, MiExcepcion {
		rsNavegar.previous();
		return this.crearPelicula();
	}

	/**
	 * Metodo que permite añadir una nueva pelicula (tupla) a la base de datos
	 * 
	 * @param ob -- pelicula que se va a añadir
	 * @throws SQLException
	 */
	public void insertaPelicula(Pelicula ob) throws SQLException {

		PreparedStatement ps = 
				con.prepareStatement("insert into cine.pelicula values (?,?,?,?,?,?,?)");

		ps.setInt(1, ob.getCodigo());
		ps.setString(2, ob.getTitulo());
		ps.setString(3, ob.getGenero().name());      	// enum → String
		ps.setInt(4, ob.getDuracion());
		ps.setString(5, ob.getClasificacion().name()); 	// enum → String
		ps.setString(6, ob.getDirector());
		ps.setInt(7, ob.getAnio());

		ps.executeUpdate();
		ps.close();

		this.crearConsulta();  // Actualizar el resultSet de navegación con el nuevo disco
	}

	/**
	 * Metodo que permite modificar una pelicula existente en la tabla pelicula, la pelicula
	 * con los datos modificados llega como parámetro, se puede modificar todo
	 * excepto el código de la pelicula
	 */
	public void modificaPelicula(Pelicula ob) throws SQLException {

		PreparedStatement ps = con.prepareStatement(
				"UPDATE cine.pelicula SET titulo = ?, genero = ?, duracion = ?, " +
				"clasificacion = ?, director = ?, anio = ? WHERE id_pelicula = ?");

		ps.setString(1, ob.getTitulo());
		ps.setString(2, ob.getGenero().name());
		ps.setInt(3, ob.getDuracion());
		ps.setString(4, ob.getClasificacion().name());
		ps.setString(5, ob.getDirector());
		ps.setInt(6, ob.getAnio());
		ps.setInt(7, ob.getCodigo());

		ps.executeUpdate();
		ps.close();

		// Volver a crear la consulta, para que se actualicen los datos en el resultSet de navegación
		this.crearConsulta();
	}

	/**
	 * Metodo que permite borrar la pelicula cuyo código (id_pelicula) coincide con el que nos
	 * llega como parámetro
	 */
	public void eliminaPelicula(int cod) throws SQLException {

		PreparedStatement ps =
				con.prepareStatement("DELETE FROM cine.pelicula WHERE id_pelicula = ?");

		ps.setInt(1, cod);

		ps.executeUpdate();
		ps.close();

		this.crearConsulta();
	}

	/**
	 * Metodo que devuelve una coleccion con todos las peliculas que hay en la tabla pelicula
	 * 
	 * @throws SQLException
	 * @throws MiExcepcion
	 */
	public List<Pelicula> getAll() throws SQLException, MiExcepcion {

		rsNavegar.beforeFirst(); // Para posicionar la consulta al principio

		List<Pelicula> listaPeliculas = new ArrayList<>();

		while (rsNavegar.next()) {
			listaPeliculas.add(crearPelicula());
		}

		rsNavegar.beforeFirst();

		return listaPeliculas;
	}

	/**
	 * Método que busca una pelicula cuyo codigo coincida con el indicado
	 * 
	 * @param cod
	 * @return
	 * @throws SQLException
	 * @throws MiExcepcion
	 */
	public Pelicula buscaCodigo(int cod) throws SQLException, MiExcepcion {

		PreparedStatement ps = con.prepareStatement("SELECT * FROM cine.pelicula WHERE id_pelicula = ?");
		ps.setInt(1, cod);

		ResultSet rs = ps.executeQuery();

		Pelicula peliculaBuscada = null;

		if (rs.next()) {
			peliculaBuscada = new Pelicula(
					rs.getInt("id_pelicula"),
					rs.getString("titulo"),
					EnumGenero.valueOf(rs.getString("genero")),
					rs.getInt("duracion"),
					EnumClasificacion.valueOf(rs.getString("clasificacion")),
					rs.getString("director"),
					rs.getInt("anio")
					);
		}

		rs.close();
		ps.close();

		return peliculaBuscada;
	}

	// -- Forma 1 --
	public String[][] datosConsulta1(String genero) throws SQLException {

		String consulta = "SELECT * FROM cine.pelicula WHERE genero = '" + genero + "'";

		ResultSet rsConsulta = this.stmt.executeQuery(consulta);

		rsConsulta.last();
		int numFilas = rsConsulta.getRow();
		rsConsulta.first();

		String[][] datos = new String[numFilas][7];

		for (int fila = 0; fila < numFilas; fila++) {
			datos[fila][0] = Integer.toString(rsConsulta.getInt("id_pelicula"));
			datos[fila][1] = rsConsulta.getString("titulo");
			datos[fila][2] = rsConsulta.getString("genero");
			datos[fila][3] = Integer.toString(rsConsulta.getInt("duracion"));
			datos[fila][4] = rsConsulta.getString("clasificacion");
			datos[fila][5] = rsConsulta.getString("director");
			datos[fila][6] = Integer.toString(rsConsulta.getInt("anio"));
			rsConsulta.next();
		}

		this.crearConsulta();
		return datos;
	}

	// -- Forma 2 --
	public DefaultTableModel datosConsulta2(String genero) throws SQLException {

		String consulta = "SELECT * FROM cine.pelicula WHERE genero = '" + genero + "'";

		ResultSet rsConsulta = this.stmt.executeQuery(consulta);
		ResultSetMetaData rsmd = rsConsulta.getMetaData();
		int numColumnas = rsmd.getColumnCount();

		DefaultTableModel datos = new DefaultTableModel();

		for (int i = 1; i <= numColumnas; i++)
			datos.addColumn(rsmd.getColumnLabel(i));

		while (rsConsulta.next()) {
			Object[] tupla = new Object[numColumnas];
			for (int i = 0; i < numColumnas; i++) {
				tupla[i] = rsConsulta.getObject(i + 1);
			}
			datos.addRow(tupla);
		}

		this.crearConsulta();
		return datos;
	}

	/**
	 * Método que muestra una descripcion completa de la excepcion
	 * que se ha producido
	 * 
	 * @param ex -- Excepcion SQL generada
	 */
	public void printSQLException(SQLException ex) {

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
