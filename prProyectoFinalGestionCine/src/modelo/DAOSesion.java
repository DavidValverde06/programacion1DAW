package modelo;

import java.sql.*;
import javax.swing.table.*;

public class DAOSesion {

	/**
	 * Variables de instancia
	 */
	private Connection con;
	private Statement stmt;

	/**
	 * Constructor
	 */
	public DAOSesion() throws ClassNotFoundException, SQLException {
		this.con = ConexionBaseDatos.getConnection();
		this.stmt = con.createStatement(
				ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
	}

	/**
	 * Devuelve todas las sesiones con datos de pelicula y sala
	 * Para mostrar al usuario antes de elegir
	 */
	public DefaultTableModel todasLasSesiones() throws SQLException {

		String consulta =
				"SELECT s.id_sesion, p.titulo, s.fecha, s.hora, sa.num_sala, sa.tipo, s.precio " +
						"FROM cine.sesion s " +
						"JOIN cine.pelicula p ON s.id_pelicula = p.id_pelicula " +
						"JOIN cine.sala sa ON s.id_sala = sa.id_sala " +
						"ORDER BY s.fecha, s.hora";

		return ejecutarConsulta(consulta);
	}

	/**
	 * Devuelve los datos completos de una sesion concreta por su ID
	 * Usado para generar la entrada
	 */
	public DefaultTableModel getDatosSesion(int idSesion) throws SQLException {

		String consulta =
				"SELECT s.id_sesion, p.titulo, s.fecha, s.hora, sa.num_sala, sa.tipo, s.precio " +
						"FROM cine.sesion s " +
						"JOIN cine.pelicula p ON s.id_pelicula = p.id_pelicula " +
						"JOIN cine.sala sa ON s.id_sala = sa.id_sala " +
						"WHERE s.id_sesion = " + idSesion;

		return ejecutarConsulta(consulta);
	}

	/**
	 * Consulta 1 - Sesiones de una pelicula concreta
	 * JOIN entre sesion, pelicula y sala
	 */
	public DefaultTableModel sesionesDeUnaPelicula(int idPelicula) throws SQLException {
		String consulta =
				"SELECT s.id_sesion, p.titulo, s.fecha, s.hora, sa.num_sala, sa.tipo, s.precio " +
						"FROM cine.sesion s " +
						"JOIN cine.pelicula p ON s.id_pelicula = p.id_pelicula " +
						"JOIN cine.sala sa ON s.id_sala = sa.id_sala " +
						"WHERE s.id_pelicula = " + idPelicula;

		return ejecutarConsulta(consulta);
	}

	/**
	 * Consulta 2 - Sesiones de hoy
	 * JOIN entre sesion, pelicula y sala
	 */
	public DefaultTableModel sesionesDeHoy() throws SQLException {

		String consulta =
				"SELECT s.id_sesion, p.titulo, s.fecha, s.hora, sa.num_sala, sa.tipo, s.precio " +
						"FROM cine.sesion s " +
						"JOIN cine.pelicula p ON s.id_pelicula = p.id_pelicula " +
						"JOIN cine.sala sa ON s.id_sala = sa.id_sala " +
						"WHERE s.fecha = CURDATE()";

		return ejecutarConsulta(consulta);
	}

	/**
	 * Consulta 3 - Sesiones por tipo de sala
	 * JOIN entre sesion, pelicula y sala
	 */
	public DefaultTableModel sesionesPorTipoSala(String tipoSala) throws SQLException {

		String consulta =
				"SELECT s.id_sesion, p.titulo, s.fecha, s.hora, sa.num_sala, sa.tipo, s.precio " +
						"FROM cine.sesion s " +
						"JOIN cine.pelicula p ON s.id_pelicula = p.id_pelicula " +
						"JOIN cine.sala sa ON s.id_sala = sa.id_sala " +
						"WHERE sa.tipo = '" + tipoSala + "'";

		return ejecutarConsulta(consulta);
	}

	/**
	 * Metodo privado reutilizable para ejecutar cualquier consulta
	 * y devolver un DefaultTableModel
	 */
	private DefaultTableModel ejecutarConsulta(String consulta) throws SQLException {

		ResultSet rs = stmt.executeQuery(consulta);
		ResultSetMetaData rsmd = rs.getMetaData();
		int numColumnas = rsmd.getColumnCount();

		DefaultTableModel datos = new DefaultTableModel();

		for (int cont = 1; cont <= numColumnas; cont++)
			datos.addColumn(rsmd.getColumnLabel(cont));

		while (rs.next()) {
			Object[] tupla = new Object[numColumnas];
			for (int cont = 0; cont < numColumnas; cont++)
				tupla[cont] = rs.getObject(cont + 1);
			datos.addRow(tupla);
		}

		return datos;
	}

	public void cierraConexion() throws SQLException {
		con.close();
	}
}