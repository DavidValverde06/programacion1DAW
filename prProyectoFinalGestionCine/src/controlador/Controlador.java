package controlador;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;
import modelo.*;
import vista.*;

public class Controlador implements ActionListener {

	/**
	 * Variables de instancia
	 */
	private Vista miVista;
	private JFrame miFrame;
	private DAOPelicula miDaoPeli;
	private DAOSesion miDaoSesion;

	/**
	 * Constructor
	 */
	public Controlador(Vista miVista, JFrame miFrame) {
		this.miVista = miVista;
		this.miFrame = miFrame;

		cargarDatosIniciales();

		try {
			this.miDaoPeli = new DAOPelicula();
			this.miDaoSesion = new DAOSesion();
			cargarPelicula(miDaoPeli.getPrimero());
			cargarTablaSesiones();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (MiExcepcion e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método de la interfaz ActionListener
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// ====================
		// 1º pestaña Películas
		// ====================

		// Botón Cerrar Sesión
		if (e.getSource() == miVista.getbCerrarSesion()) {
			cerrarSesion();
		}
		// Botón Primero
		else if (e.getSource()==miVista.getbPrimero()) {
			botonPrimeraPeli();
		}
		// Botón Siguiente
		else if (e.getSource()==miVista.getbSiguiente()) {
			botonSiguientePeli();
		}
		// Botón Anterior
		else if (e.getSource()==miVista.getbAnterior()) {
			botonAnteriorPeli();
		}
		// Botón Último
		else if (e.getSource()==miVista.getbUltimo()) {
			botonUltimaPeli();
		}
		// Ver todas las películas en formato tabla (JTable)
		else if (e.getSource()==miVista.getbVerTodasPelis()) {
			tablaPeliculasFiltrar();
		}
		// Buscar película por ID
		else if (e.getSource()==miVista.getbBuscarPeliId()) {
			buscarPeliPorId();
		}
		// Añadir nueva película
		else if (e.getSource()==miVista.getbNueva()) {

			if (miVista.getbNueva().getText().equals("Nueva")) {
				// Borrar texto de los JTextFields y habilitar componentes para escribir y seleccionar
				miVista.getTfIdPeli().setText("");
				miVista.getTfIdPeli().setEditable(true);

				miVista.getTfTitulo().setText("");
				miVista.getTfTitulo().setEditable(true);

				miVista.getCbGenero().setSelectedIndex(0);
				miVista.getCbGenero().setEnabled(true);

				miVista.getTfDuracion().setText("");
				miVista.getTfDuracion().setEditable(true);

				miVista.getCbClasificacion().setSelectedIndex(0);
				miVista.getCbClasificacion().setEnabled(true);

				miVista.getTfDirector().setText("");
				miVista.getTfDirector().setEditable(true);

				miVista.getTfAnio().setText("");
				miVista.getTfAnio().setEditable(true);

				// Ocultar botones y mostrar solo "Añadir" y "Cancelar"
				miVista.getbNueva().setText("Añadir");

				miVista.getbModificar().setText("Cancelar");
				miVista.getbModificar().setToolTipText("Cancelar operación");

				miVista.getbEliminar().setVisible(false);
			}
			else {
				try {
					int codigo = Integer.valueOf(miVista.getTfIdPeli().getText());
					String titulo = miVista.getTfTitulo().getText();
					EnumGenero genero = (EnumGenero)miVista.getCbGenero().getSelectedItem();
					int duracion = Integer.valueOf(miVista.getTfDuracion().getText());
					EnumClasificacion clasificacion = (EnumClasificacion)miVista.getCbClasificacion().getSelectedItem();
					String director = miVista.getTfDirector().getText();
					int anio = Integer.valueOf(miVista.getTfAnio().getText());

					Pelicula peliAnadir = new Pelicula(codigo, titulo, genero, duracion, clasificacion, director, anio);

					miDaoPeli.insertaPelicula(peliAnadir);
				}
				catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Error, rellene todos los campos correctamente","Error", 0);
					return;
				}
				catch (IllegalArgumentException e1) {
					JOptionPane.showMessageDialog(null, "Error ","Error", 0);
				}
				catch (SQLIntegrityConstraintViolationException e1) {
					JOptionPane.showMessageDialog(null, "El código ya se encuentra en la base de datos","Error", 0);
					return;
				}
				catch (SQLException e1) {
					e1.printStackTrace();
				}

				JOptionPane.showMessageDialog(null, "Película añadida correctamente","Añadir película", 1);
				cancelarPelicula();
			}

		}
		// Modificar la película seleccionada
		else if (e.getSource()==miVista.getbModificar()) {

			if (miVista.getbModificar().getText().equals("Cancelar")) {
				cancelarPelicula();
			}
			else if (miVista.getbModificar().getText().equals("Guardar")) {
				int opcion = JOptionPane.showConfirmDialog(null,"¿Quieres modificar los datos generales de esta película?",
						"Salir",JOptionPane.YES_NO_OPTION);

				if (opcion == JOptionPane.YES_OPTION) {
					try {
						int codigo = Integer.valueOf(miVista.getTfIdPeli().getText());
						String titulo = miVista.getTfTitulo().getText();
						EnumGenero genero = (EnumGenero)miVista.getCbGenero().getSelectedItem();
						int duracion = Integer.valueOf(miVista.getTfDuracion().getText());
						EnumClasificacion clasificacion = (EnumClasificacion)miVista.getCbClasificacion().getSelectedItem();
						String director = miVista.getTfDirector().getText();
						int anio = Integer.valueOf(miVista.getTfAnio().getText());

						Pelicula peliModificar = new Pelicula(codigo, titulo, genero, duracion, clasificacion, director, anio);

						miDaoPeli.modificaPelicula(peliModificar);
					}
					catch (NumberFormatException e1) {
						e1.printStackTrace();
					}
					catch (SQLException e1) {
						e1.printStackTrace();
					}

					JOptionPane.showMessageDialog(null, "Película modificada correctamente","Modificar película", 1);

					cancelarPelicula();
				}
			}
			else {
				// Código se queda inhabilitado
				miVista.getTfIdPeli().setEditable(false);

				// Y los demas campos se activan para modificar la película
				miVista.getTfTitulo().setEditable(true);
				miVista.getCbGenero().setEnabled(true);
				miVista.getTfDuracion().setEditable(true);
				miVista.getTfDirector().setEditable(true);
				miVista.getCbClasificacion().setEnabled(true);
				miVista.getTfAnio().setEditable(true);

				// Ocultar botones / Cambiar botones
				miVista.getbNueva().setVisible(false); 

				miVista.getbModificar().setText("Guardar");

				miVista.getbEliminar().setText("Cancelar");
				miVista.getbEliminar().setToolTipText("Cancelar operación");

			}
		}
		// Eliminar la película seleccionada
		else if (e.getSource()==miVista.getbEliminar()) {

			if (miVista.getbEliminar().getText().equals("Cancelar")) {
				cancelarPelicula();
			}
			else {
				int opcion = JOptionPane.showConfirmDialog(null,"¿Quieres borrar la película \"" + miVista.getTfTitulo().getText() + "\"?",
						"Salir",JOptionPane.YES_NO_OPTION);

				if (opcion == JOptionPane.YES_OPTION) {
					try {
						miDaoPeli.eliminaPelicula(Integer.valueOf(miVista.getTfIdPeli().getText()));
					}
					catch (NumberFormatException e1) {
						e1.printStackTrace();
					}
					catch (SQLException e1) {
						e1.printStackTrace();
					}

					JOptionPane.showMessageDialog(null, "Película eliminada correctamente","Eliminar película", 1);

					cancelarPelicula();
				}

			}
		}

		// ===================
		// 2º pestaña Sesiones
		// ===================

		// Mostrar en la tabla todas las sesiones disponibles
		if (e.getSource() == miVista.getbTodasSesiones()) {
			cargarTablaSesiones();
		}
		else if (e.getSource() == miVista.getbHoySesiones()) {
			try {
				miVista.getTablaSesiones().setModel(miDaoSesion.sesionesDeHoy());
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		// Mostrar en la tabla todas las sesiones de el dia de hoy
		else if (e.getSource() == miVista.getbSesionesDeUnaPeli()) {
			sesionesDeUnaPeli();
		}
		// Mostrar en la tabla todas las sesiones segun el tipo de sala seleccionado
		else if (e.getSource() == miVista.getCbTipoSala()) {
			sesionesTipoSala();
		}
		// Mostrar en la tabla la sesion cuyo id coincida con el id escrito en el JTextField
		else if (e.getSource() == miVista.getbBuscarSesion()) {
			buscarSesionPorId();
		}

		// ===========================
		// 3º pestaña Comprar Entradas
		// ===========================

		// Botón Comprar Entrada
		else if (e.getSource() == miVista.getbComprarEntrada()) {

			int filaSeleccionada = miVista.getTablaSesionesEntradas().getSelectedRow();

			if (filaSeleccionada==-1) {
				JOptionPane.showMessageDialog(miFrame, "Debe seleccionar una sesión de la tabla de la derecha.", "Aviso", JOptionPane.WARNING_MESSAGE);
				return;
			}

			JTable tabla = miVista.getTablaSesionesEntradas();
			String idSesion = tabla.getValueAt(filaSeleccionada, 0).toString();
			String titulo   = tabla.getValueAt(filaSeleccionada, 1).toString();
			String fecha    = tabla.getValueAt(filaSeleccionada, 2).toString();
			String hora     = tabla.getValueAt(filaSeleccionada, 3).toString();
			String sala     = tabla.getValueAt(filaSeleccionada, 4).toString();
			String tipoSala = tabla.getValueAt(filaSeleccionada, 5).toString();
			String precio   = tabla.getValueAt(filaSeleccionada, 6).toString();

			String nombre = miVista.getTfNombreCliente().getText();
			String apellidos = miVista.getTfApellidosCliente().getText();
			String email = miVista.getTfEmailCliente().getText();

			if (nombre.isEmpty() || apellidos.isEmpty() || email.isEmpty()) {
				JOptionPane.showMessageDialog(miFrame, "Debe rellenar todos los datos del cliente.", "Error", 0);
				return;
			}

			String contenidoEntrada =
					"--- ENTRADA CINE ---\n" +
							"Cliente : " + nombre + " " + apellidos + "\n" +
							"Email: " + email + "\n\n" +
							"Pelicula: " + titulo + "\n" +
							"Fecha: " + fecha + "\n" +
							"Hora: " + hora + ":00h\n" +
							"Sala: " + sala + " (" + tipoSala + ")\n" +
							"Precio: " + precio + " EUROS\n\n" +
							"¡Disfrute de la pelicula!";

			String nombreFichero = "./entradas/entrada_" + nombre + "_sesion" + idSesion + ".txt";

			try (BufferedWriter flujoEscritura = new BufferedWriter(new FileWriter(nombreFichero))) {
				flujoEscritura.write(contenidoEntrada);

				JOptionPane.showMessageDialog(miFrame, "¡Entrada comprada con éxito!\nGuardada en la ruta:\n" + nombreFichero, "Compra completada", JOptionPane.INFORMATION_MESSAGE);

				cancelarCompra();
			}
			catch (IOException ex) {
				JOptionPane.showMessageDialog(miFrame, "Error al generar el archivo de entrada: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		// Botón Cancelar Compra
		else if (e.getSource() == miVista.getbCancelarCompra()) {
			cancelarCompra();
		}
	}

	// =======================
	// Métodos del controlador
	// =======================

	private void buscarSesionPorId() {
		try {
			int codigoSesion = Integer.valueOf(miVista.getTfIdSesion().getText());
			miVista.getTablaSesiones().setModel(miDaoSesion.getDatosSesion(codigoSesion));
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "El ID debe ser un número entero", "Error", 0);
		}
	}

	private void sesionesTipoSala() {
		try {
			String tipo = (String) miVista.getCbTipoSala().getSelectedItem();
			miVista.getTablaSesiones().setModel(miDaoSesion.sesionesPorTipoSala(tipo));
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	private void sesionesDeUnaPeli() {
		try {
			String tituloPeli = JOptionPane.showInputDialog(null, "Escribe el título de la película: ");

			if (tituloPeli != null && !tituloPeli.isEmpty()) {
				int idPeli = miDaoPeli.getIdPorTitulo(tituloPeli);
				miVista.getTablaSesiones().setModel(miDaoSesion.sesionesDeUnaPelicula(idPeli));
			}
		}
		catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
		}
	}

	private void buscarPeliPorId() {
		try {
			String tituloPeli = JOptionPane.showInputDialog(null, "Escribe el título de la película: ");
			if (tituloPeli != null && !tituloPeli.isEmpty()) {
				int idPeli = miDaoPeli.getIdPorTitulo(tituloPeli);
				cargarPelicula((miDaoPeli.buscaCodigo(idPeli)));
			}
		}
		catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
		}
		catch (MiExcepcion e1) {
			e1.printStackTrace();
		}
	}

	private void cancelarCompra() {
		miVista.getTfNombreCliente().setText("");
		miVista.getTfApellidosCliente().setText("");
		miVista.getTfEmailCliente().setText("");	    
		miVista.getTablaSesionesEntradas().clearSelection();
	}

	/**
	 * Métodos para la navegación de las películas
	 */
	private void botonUltimaPeli() {
		try {
			cargarPelicula(miDaoPeli.getUltimo());
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		catch (MiExcepcion e1) {
			e1.printStackTrace();
		}
	}

	private void botonAnteriorPeli() {
		try {
			cargarPelicula(miDaoPeli.getAnterior());
		}
		catch (SQLException e1) {
			botonUltimaPeli();
		}
		catch (MiExcepcion e1) {
			e1.printStackTrace();
		}
	}

	private void botonSiguientePeli() {
		try {
			cargarPelicula(miDaoPeli.getSiguiente());
		}
		catch (SQLException e1) {
			botonPrimeraPeli();
		}
		catch (MiExcepcion e1) {
			e1.printStackTrace();
		}
	}

	private void botonPrimeraPeli() {
		try {
			cargarPelicula(miDaoPeli.getPrimero());
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		catch (MiExcepcion e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Método que cierra la sesión (cierra la ventana principal y abre el JDialog)
	 */
	private void cerrarSesion() {
		int opcion = JOptionPane.showConfirmDialog(miFrame,
				"¿Quieres cerrar la sesión?", "Cerrar sesión",
				JOptionPane.YES_NO_OPTION);

		if (opcion == JOptionPane.YES_OPTION) {
			miFrame.setVisible(false);

			DialogoInicial dialogo = miVista.getMiDialogoInicio();

			if (!dialogo.getChRecordarme().isSelected()) {
				dialogo.getTfUsuario().setText("");
				dialogo.getTfPassword().setText("");
			}

			dialogo.setVisible(true);
		}
	}

	/**
	 * Método que vuelve a colocar todo (Botones y ToolTips) tal y como se encuentra al inicio del programa
	 */
	private void cancelarPelicula() {
		botonPrimeraPeli();
		miVista.getTfIdPeli().setEditable(false);
		miVista.getTfTitulo().setEditable(false);
		miVista.getCbGenero().setEnabled(false);
		miVista.getTfDuracion().setEditable(false);
		miVista.getTfDirector().setEditable(false);
		miVista.getCbClasificacion().setEnabled(false);
		miVista.getTfAnio().setEditable(false);

		miVista.getbNueva().setText("Nueva");
		miVista.getbNueva().setToolTipText("Añadir una nueva película");
		miVista.getbNueva().setVisible(true);

		miVista.getbModificar().setText("Modificar");
		miVista.getbModificar().setToolTipText("Modificar la película seleccionada");
		miVista.getbModificar().setVisible(true);

		miVista.getbEliminar().setText("Eliminar");
		miVista.getbEliminar().setToolTipText("Eliminar la película seleccionada");
		miVista.getbEliminar().setVisible(true);;
	}

	/**
	 * Carga una película desde la base de datos a los JTextFields
	 */
	private void cargarPelicula(Pelicula peli) {
		if (peli == null) {
			return;
		}

		miVista.getTfIdPeli().setText(String.valueOf(peli.getCodigo()));
		miVista.getTfTitulo().setText(peli.getTitulo());
		miVista.getCbGenero().setSelectedItem(peli.getGenero());
		miVista.getTfDuracion().setText(String.valueOf(peli.getDuracion()));
		miVista.getCbClasificacion().setSelectedItem(peli.getClasificacion());
		miVista.getTfDirector().setText(peli.getDirector());
		miVista.getTfAnio().setText(String.valueOf(peli.getAnio()));

		ImageIcon cartel = new ImageIcon("./img/" + peli.getTitulo() + ".jpg");

		if (cartel.getIconWidth() == -1) {
			cartel = new ImageIcon("./img/noDisponible.jpg");
		}
		Image escalada = cartel.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH);
		miVista.getEtiquetaCartelPeli().setIcon(new ImageIcon(escalada));
	}

	private void cargarTablaSesiones() {
		try {
			miVista.getTablaSesiones().setModel(miDaoSesion.todasLasSesiones());
			miVista.getTablaSesionesEntradas().setModel(miDaoSesion.todasLasSesiones());
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al cargar sesiones: " + e.getMessage());
		}
	}

	private void tablaPeliculasFiltrar() {
		try {
			JDialog dialogoTablaPelis = new JDialog(miFrame, "Listado de Películas");
			dialogoTablaPelis.setModal(true);
			dialogoTablaPelis.setLayout(new BorderLayout());

			// ComboBox
			JPanel panelFiltro = new JPanel();
			JLabel etiqueta = new JLabel("Filtrar por género: ");
			JComboBox<String> cbGenero = new JComboBox<>();
			cbGenero.addItem("Todos");
			for (EnumGenero g : EnumGenero.values())
				cbGenero.addItem(g.name());
			panelFiltro.add(etiqueta);
			panelFiltro.add(cbGenero);

			// Tabla
			JTable tablaResultados = new JTable();
			JScrollPane panelScroll = new JScrollPane(tablaResultados);
			panelScroll.setPreferredSize(new Dimension(600, 200));

			// Cargar todas al inicio
			List<Pelicula> listaPelis = miDaoPeli.getAll();
			String[] cols = {"ID", "Título", "Género", "Duración (min)", "Clasificación", "Director", "Año"};
			DefaultTableModel modelo = new DefaultTableModel(cols, 0);
			for (Pelicula p : listaPelis)
				modelo.addRow(new Object[]{p.getCodigo(), p.getTitulo(), p.getGenero(), p.getDuracion(), p.getClasificacion(), p.getDirector(), p.getAnio()});
			tablaResultados.setModel(modelo);

			// Listener combo
			cbGenero.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						String seleccion = (String) cbGenero.getSelectedItem();
						if (seleccion.equals("Todos")) {
							DefaultTableModel m = new DefaultTableModel(cols, 0);
							for (Pelicula p : miDaoPeli.getAll())
								m.addRow(new Object[]{p.getCodigo(), p.getTitulo(), p.getGenero(), p.getDuracion(), p.getClasificacion(), p.getDirector(), p.getAnio()});
							tablaResultados.setModel(m);
						} else {
							tablaResultados.setModel(miDaoPeli.datosConsulta(seleccion));
						}
					}
					catch (SQLException ex) {
						ex.printStackTrace();
					}
					catch (MiExcepcion e1) {
						e1.printStackTrace();
					}
				}
			});

			dialogoTablaPelis.add(panelFiltro, BorderLayout.NORTH);
			dialogoTablaPelis.add(panelScroll, BorderLayout.CENTER);

			dialogoTablaPelis.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialogoTablaPelis.pack();
			dialogoTablaPelis.setResizable(false);
			dialogoTablaPelis.setLocationRelativeTo(null);
			dialogoTablaPelis.setVisible(true);

		}
		catch (SQLException e) {
			JOptionPane.showMessageDialog(miFrame, "Error: " + e.getMessage(), "Error", 0);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método que cuenta cuántas peliculas hay en la base de datos, si no hay 
	 * carga todos los datos desde los ficheros y si encuentra peliculas lanza un mensaje por
	 * consola diciendo que ya existen datos en la misma
	 */
	private static void cargarDatosIniciales() {

		try {
			Connection con = ConexionBaseDatos.getConnection();

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM cine.pelicula");

			rs.next();

			int numPeliculas = rs.getInt(1);

			if (numPeliculas == 0) {
				System.out.println("Cargando datos iniciales...");
				CargarTablasProyecto.cargaTablaPeliculas(con);
				CargarTablasProyecto.cargaTablaSalas(con);
				CargarTablasProyecto.cargaTablaSesiones(con);
				CargarTablasProyecto.cargaTablaClientes(con);
				System.out.println("Datos cargados correctamente\n");
			}
			else {
				System.out.println("Datos ya existentes en la base de datos\n");
			}
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
