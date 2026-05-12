package modelo;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import fechas.LibFechas8;

/**
 * Esta clase implementa el patrón DAO con la tabla Discos, este patrón ofrece 
 * operaciones para interactuar con la base de datos. 
 * 
 * Se encarga de realizar todas las operaciones CRUD es el acrónimo de 
 * "Crear, Leer, Actualizar y Borrar" (del original en inglés: Create, 
 * Read, Update and Delete), que se usa para referirse a las funciones 
 * básicas en bases de datos o la capa de persistencia en un software.
 * 
 * Lo que este patrón pretende principalmente es independizar la aplicación
 * de la forma de acceder a la base de datos.
 * 
 */

public class DAODisco {

	/**
	 * Variables de instancia
	 */
	private Connection con;   // Objeto con la conexión a la BD
	private Statement stmt;   // Objeto que permite ejecutar sentencias SQL
	private ResultSet rsNavegar; // Resultado de la consulta para navegar por las filas de la tabal
	
	
	/**
	 * Constructor
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public DAODisco() throws ClassNotFoundException, SQLException {
		
		this.estableceConexion();  // Dar valor a la variable con (Connection)
		
		this.crearStatement();  // Dar valor a la variable stmt (Statement)
		
		this.crearConsulta();  // Dar valor a la variable rsNavegar (ResultSet)
		
	}

	/**
	 * Método que establece la conexión con la BD 
	 * (Os dejo dos posibles plantamientos, los dos son igual de válidos)
	 * @throws MiExcepcion 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void estableceConexion() throws ClassNotFoundException, SQLException {
		
		this.con = BDConnection.getConnection();
		System.out.println("Conexión establecida");
	}

/*	public void estableceConexion() throws MiExcepcion {
		
		try {
			this.con = BDConnection.getConnection();
		} 
		catch (ClassNotFoundException | SQLException e) {
			throw new MiExcepcion(e.getMessage());
		}
		System.out.println("Conexión establecida");
	}
	*/
	
	
	/**
	 * Crear el objeto Statement, el cual nos va a permitir ejecutar instrucciones SQL
	 * @throws SQLException 
	 */
	public void crearStatement() throws SQLException {
//		con.setAutoCommit(false);
		
		this.stmt = con.createStatement(
						ResultSet.TYPE_SCROLL_SENSITIVE,  // Indica que el cursor es bidireccional
						                                  // y que refleja los cambios en la BD
						ResultSet.CONCUR_UPDATABLE);  // Los datos del ResultSet son actualizables 

		// En realidad no necesitamos que los datos del ResultSet sean actualizables, ya
		// que estamos creando un nuevo objeto Statement (en concreto PreparedStatement)
		// para realizar las actualizaciones de forma parametrizada, y evitar la SQL Injection 
	//	con.commit();
	//	con.setAutoCommit(true);
	}
	
	/**
	 * Método que permite crear la consulta SQL para la navegación (primero, anterior, 
	 * siguiente y último) entre los distintas filas devueltas por la selección
	 *  
	 * @throws SQLException 
	 */
	public void crearConsulta() throws SQLException {
		String sqlString = "SELECT * FROM DISCOS";
		
		this.rsNavegar = stmt.executeQuery(sqlString);
	}
	
	/**
	 * Método que cierra la conexión
	 * @throws SQLException
	 */
	public void cierraConexion() throws SQLException {
		con.close();
		System.out.println("Conexión cerrada");
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
	public Disco crearDisco() throws MiExcepcion, SQLException {
		return new Disco(
					rsNavegar.getInt("codigo"), 
					rsNavegar.getString("titulo"),
					rsNavegar.getString("autor"),
					LibFechas8.transformaFecha(
							rsNavegar.getDate("fechaPubli")
							   .toLocalDate()
							   .toString()),
					
					rsNavegar.getDouble("precio"));
	}

		
	/**
	 * Método que devuelve el primer registro (tupla) de la consulta
	 * @return
	 * @throws SQLException 
	 * @throws MiExcepcion 
	 */
	public Disco getPrimero() throws SQLException, MiExcepcion {
		
		this.rsNavegar.first();
		return this.crearDisco();
	}
	
	/**
	 * Metodo que devuelve el ultimo registro (tupla) de la consulta 
	 * @throws MiExcepcion 
	 */
	public Disco getUltimo() throws SQLException, MiExcepcion {
		rsNavegar.last();
		return this.crearDisco();
	}
	
	/**	 
	 * Metodo que devuelve el registro siguiente al acual
	 * @throws MiExcepcion 
	 */
	public Disco getSiguiente() throws SQLException, MiExcepcion {
		rsNavegar.next();
		return this.crearDisco();
	}
		
	/**
	 * Metodo que devuelve el registro anterior al actual
	 * @throws MiExcepcion 
	 */
	public Disco getAnterior() throws SQLException, MiExcepcion {
		rsNavegar.previous();
		return this.crearDisco();
	}
	
	/**
	 * Metodo que permite añadir un nuevo disco (tupla) a la BD
	 * @param ob -- disco que se va a añadir
	 * @throws SQLException
	 */
	public void insertaDisco(Disco ob) throws SQLException {
		
		PreparedStatement ps = 
				con.prepareStatement("insert into Discografica.discos values (?,?,?,?,?)");

		ps.setInt(1,ob.getCodigo());
		ps.setString(2, ob.getTitulo());
		ps.setString(3, ob.getAutor());
		ps.setDate(4, Date.valueOf(ob.getFechaPubli()));
		ps.setDouble(5,ob.getPrecio());
		
		ps.executeUpdate();
		ps.close();
	
		this.crearConsulta();  // Actualizar el resultSet de navegación con el nuevo disco
	}
	
	
	/**
	 * Metodo que permite modificar un disco existente en la talba disco, el disco
	 * con los datos modificados llega como par�metro, se puede modificar todo
	 * excepto el c�digo del disco
	 */
	public void modificaDisco(Disco ob) throws SQLException {
		
		PreparedStatement ps = con.prepareStatement(
				"UPDATE discos SET titulo = ?, autor = ?, fechaPubli = ?, precio = ? WHERE codigo = ?");
		
		ps.setString(1, ob.getTitulo());
		ps.setString(2, ob.getAutor());
		ps.setDate(3, Date.valueOf(ob.getFechaPubli()));
		ps.setDouble(4,ob.getPrecio());
		ps.setInt(5,ob.getCodigo());
		
		ps.executeUpdate();
		ps.close();
		
		// Volver a crear la consulta, para que se actualicen los datos en el resultSet de navegaci�n
		this.crearConsulta();		
	}
	
	
	/**
	 * Metodo que permite borrar el disco cuyo código coincide con el que nos
	 * llega como parámetro
	 */
	public void eliminaDisco(int cod) throws SQLException{
		PreparedStatement ps = 
				con.prepareStatement("DELETE FROM discos WHERE codigo = ?");
		
		ps.setInt(1, cod);

		ps.executeUpdate();
		ps.close();

		// Volver a crear la consulta, para actualizar los datos del resultset de navegación
		this.crearConsulta();
	}

	
	/**
	 * Metodo que devuelve una coleccion con todos los discos que hay en la tabla discos
	 * @return
	 * @throws SQLException
	 * @throws MiExcepcion
	 */
	public List<Disco> getAll() throws SQLException, MiExcepcion {
	
		rsNavegar.beforeFirst(); // Para posicionar la consulta al principio
		
		List<Disco> listaDiscos = new ArrayList<>();

		while (rsNavegar.next()) {
			listaDiscos.add(crearDisco());
		}

		rsNavegar.beforeFirst();
		
		return listaDiscos;
	}
	
	
	/**
	 * Método que busca un disco cuyo codigo coincida con el indicado
	 * @param cod
	 * @return
	 * @throws SQLException
	 * @throws MiExcepcion
	 */
	public Disco buscaCodigo(int cod) throws SQLException, MiExcepcion {

		PreparedStatement ps = con.prepareStatement("SELECT * FROM discos WHERE codigo = ?");
		ps.setInt(1, cod);

		ResultSet rs = ps.executeQuery();

		Disco discoBuscado = null;

		if (rs.next()) {
			discoBuscado = 
					new Disco(
							rs.getInt("codigo"),
							rs.getString("titulo"),
							rs.getString("autor"),
							LibFechas8.transformaFecha(rsNavegar.getDate("fechaPubli").toLocalDate().toString()),
							rs.getDouble("precio"));
		}

		rs.close();
		ps.close();

		return discoBuscado;

	}
	
	/**
	 * --- FORMA 1 -----
	 * Método que devuelve una matriz con una matriz que contiene el 
	 * resultado de una consulta
	 * @return
	 * @throws SQLException
	 */
	public String[][] datosConsulta1() throws SQLException{
		
		// Crear la consulta, mejor parametrizarla si la fecha se le va a pedir al usuario
		java.sql.Date fechaDateConsulta = Date.valueOf(LocalDate.of(2010, 01, 01));
		String consulta = "select * from discos where fechaPubli>'"+fechaDateConsulta+"'";
	
		ResultSet rsConsulta = null;  
		rsConsulta = this.stmt.executeQuery(consulta);
		
		// Averiguar el numero de filas devueltas
		rsConsulta.last();
		int numFilas = rsConsulta.getRow();
		rsConsulta.first();
		
		// Ir volcando cada fila en una fila de la matriz
		String [][]datos = new String[numFilas][5];
		
		for(int fila = 0; fila < numFilas; fila++){
			datos[fila][0] = Integer.toString(rsConsulta.getInt("codigo"));
			datos[fila][1] = rsConsulta.getString("titulo");
			datos[fila][2] = rsConsulta.getString("autor");
			datos[fila][3] = LibFechas8.transformaFecha(
									rsConsulta.getDate("fechaPubli").toLocalDate().toString());
			datos[fila][4] = Double.toString(rsConsulta.getDouble("precio"));
			rsConsulta.next();
		}
		
		this.crearConsulta();
		
		return datos;
	}
	
	/**
	 * --- FORMA 2 ----

	 * Método que devuelve un objeto DefaultTableModel
	 * que contiene el resultado de una consulta
	 * @return
	 * @throws SQLException
	 */
	public DefaultTableModel datosConsulta2() throws SQLException{
		// Crear la consulta, mejor parametrizarla si la fecha se le va a pedir al usuario
		java.sql.Date fechaDateConsulta = Date.valueOf(LocalDate.of(2010, 01, 01));
		String consulta = "select * from discos where fechaPubli>'"+fechaDateConsulta+"'";
	
		ResultSet rsConsulta = this.stmt.executeQuery(consulta);
			
		// Obtener un objeto ResultSetMetaData, para obtener informacion de la tabla
		ResultSetMetaData rsmd = rsConsulta.getMetaData();
		
		// Obtener el n�mero de columnas de esta consulta
		int numColumnas = rsmd.getColumnCount();
	
		// Crear un objeto DefaultTableModel, para guardar el resultado de la consulta
		DefaultTableModel datos = new DefaultTableModel();
		
		// Establecer los nombres de las columnas, esto hay que hacerlo antes
		// de añadir las filas de datos, sino no saldran datos ¿?
		// Primera forma
			  for (int i=1; i<=numColumnas; i++)
					datos.addColumn(rsmd.getColumnLabel(i));
		
		// Segunda forma
			//String [] nombreColumnas = {"Código","Título","Autor","Fecha","Precio"};
			//datos.setColumnIdentifiers(nombreColumnas);
		
		// Añadir los datos 	
		while (rsConsulta.next()) {
			Object [] tupla = new Object[numColumnas];
			for (int i=0; i<numColumnas; i++) {
				if (i==3) // Fecha
					tupla[i] = LibFechas8.transformaFecha(
									rsConsulta.getDate("fechaPubli").toLocalDate().toString());
				else
					tupla[i] = rsConsulta.getObject(i+1);
			}
		//	System.out.println("Tupla"+Arrays.toString(tupla));
			datos.addRow(tupla);
		}
		
		this.crearConsulta();
		return datos; 
	}
	
	/**
	 * Método que muestra una descripcion completa de la excepcion
	 * que se ha producido
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

