package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import controlador.*;

public class Vista extends JPanel {

	private static final long serialVersionUID = -5752211613049689258L;

	/**
	 * Variables de instancia
	 */
	private DialogoInicial miDialogoInicio;

	// Cabecera
	private JButton bCerrarSesion;

	// Pestañas
	private JTabbedPane tabbedPane;

	// Pelis
	private JLabel etiquetaCartelPeli;
	private JTextField tfIdPeli,tfTitulo,tfDuracion,tfClasificacion,tfDirector,tfAnio;
	private JButton bNueva,bModificar,bEliminar,bPrimero,bUltimo,bAnterior,bSiguiente;

	// Sesiones
	private JButton bTodasSesiones,bHoySesiones,bBuscarSesion;
	private JTextField tfIdSesion;
	private JComboBox<String> cbTipoSala;
	private JTable tablaSesiones;

	// Entradas
	private JTextField tfNombreCliente,tfApellidosCliente,tfEmailCliente;
	private JButton bComprarEntrada,bCancelarCompra;
	private JTable tablaSesionesEntradas;

	/**
	 * Variables de clase
	 */
	private static Color FONDO_COLOR = new Color(220, 195, 170);
	private static Color CABECERA_COLOR = new Color(84, 26, 26);
	private static Color COMPONENTE_COLOR = new Color(241, 226, 209);
	private static Color FUENTE_COLOR = Color.WHITE;

	/**
	 * Constructor
	 */
	public Vista() {
		this.setLayout(new BorderLayout());
		this.setBackground(FONDO_COLOR);

		JPanel panelSuperior = preparaPanelCabecera(); 	  // Cabecera
		JPanel panelCentral = prepararPanelJTabbedPane(); // JTabbedPane

		this.add(panelSuperior, BorderLayout.NORTH);
		this.add(panelCentral, BorderLayout.CENTER);
	}

	/**
	 * Métodos Getter y Setter
	 */
	public DialogoInicial getMiDialogoInicio() {return miDialogoInicio;}
	public void setMiDialogoInicio(DialogoInicial miDialogoInicio) {this.miDialogoInicio = miDialogoInicio;}
	public JButton getbCerrarSesion() {return bCerrarSesion;}
	public void setbCerrarSesion(JButton bCerrarSesion) {this.bCerrarSesion = bCerrarSesion;}
	public JTabbedPane getTabbedPane() {return tabbedPane;}
	public void setTabbedPane(JTabbedPane tabbedPane) {this.tabbedPane = tabbedPane;}
	public JLabel getEtiquetaCartelPeli() {return etiquetaCartelPeli;}
	public void setEtiquetaCartelPeli(JLabel etiquetaCartelPeli) {this.etiquetaCartelPeli = etiquetaCartelPeli;}
	public JTextField getTfIdPeli() {return tfIdPeli;}
	public void setTfIdPeli(JTextField tfIdPeli) {this.tfIdPeli = tfIdPeli;}
	public JTextField getTfTitulo() {return tfTitulo;}
	public void setTfTitulo(JTextField tfTitulo) {this.tfTitulo = tfTitulo;}
	public JTextField getTfDuracion() {return tfDuracion;}
	public void setTfDuracion(JTextField tfDuracion) {this.tfDuracion = tfDuracion;}
	public JTextField getTfClasificacion() {return tfClasificacion;}
	public void setTfClasificacion(JTextField tfClasificacion) {this.tfClasificacion = tfClasificacion;}
	public JTextField getTfDirector() {return tfDirector;}
	public void setTfDirector(JTextField tfDirector) {this.tfDirector = tfDirector;}
	public JTextField getTfAnio() {return tfAnio;}
	public void setTfAnio(JTextField tfAnio) {this.tfAnio = tfAnio;}
	public JButton getbNueva() {return bNueva;}
	public void setbNueva(JButton bNueva) {this.bNueva = bNueva;}
	public JButton getbModificar() {return bModificar;}
	public void setbModificar(JButton bModificar) {this.bModificar = bModificar;}
	public JButton getbEliminar() {return bEliminar;}
	public void setbEliminar(JButton bEliminar) {this.bEliminar = bEliminar;}
	public JButton getbPrimero() {return bPrimero;}
	public void setbPrimero(JButton bPrimero) {this.bPrimero = bPrimero;}
	public JButton getbUltimo() {return bUltimo;}
	public void setbUltimo(JButton bUltimo) {this.bUltimo = bUltimo;}
	public JButton getbAnterior() {return bAnterior;}
	public void setbAnterior(JButton bAnterior) {this.bAnterior = bAnterior;}
	public JButton getbSiguiente() {return bSiguiente;}
	public void setbSiguiente(JButton bSiguiente) {this.bSiguiente = bSiguiente;}
	public JButton getbTodasSesiones() {return bTodasSesiones;}
	public void setbTodasSesiones(JButton bTodasSesiones) {this.bTodasSesiones = bTodasSesiones;}
	public JButton getbHoySesiones() {return bHoySesiones;}
	public void setbHoySesiones(JButton bHoySesiones) {this.bHoySesiones = bHoySesiones;}
	public JButton getbBuscarSesion() {return bBuscarSesion;}
	public void setbBuscarSesion(JButton bBuscarSesion) {this.bBuscarSesion = bBuscarSesion;}
	public JTextField getTfIdSesion() {return tfIdSesion;}
	public void setTfIdSesion(JTextField tfIdSesion) {this.tfIdSesion = tfIdSesion;}
	public JComboBox<String> getCbTipoSala() {return cbTipoSala;	}
	public void setCbTipoSala(JComboBox<String> cbTipoSala) {this.cbTipoSala = cbTipoSala;}
	public JTable getTablaSesiones() {return tablaSesiones;}
	public void setTablaSesiones(JTable tablaSesiones) {this.tablaSesiones = tablaSesiones;}
	public JTextField getTfNombreCliente() {return tfNombreCliente;}
	public void setTfNombreCliente(JTextField tfNombreCliente) {this.tfNombreCliente = tfNombreCliente;}
	public JTextField getTfApellidosCliente() {return tfApellidosCliente;}
	public void setTfApellidosCliente(JTextField tfApellidosCliente) {this.tfApellidosCliente = tfApellidosCliente;}
	public JTextField getTfEmailCliente() {return tfEmailCliente;}
	public void setTfEmailCliente(JTextField tfEmailCliente) {this.tfEmailCliente = tfEmailCliente;}
	public JButton getbComprarEntrada() {return bComprarEntrada;}
	public void setbComprarEntrada(JButton bComprarEntrada) {this.bComprarEntrada = bComprarEntrada;}
	public JButton getbCancelarCompra() {return bCancelarCompra;}
	public void setbCancelarCompra(JButton bCancelarCompra) {this.bCancelarCompra = bCancelarCompra;}
	public JTable getTablaSesionesEntradas() {return tablaSesionesEntradas;}
	public void setTablaSesionesEntradas(JTable tablaSesionesEntradas) {this.tablaSesionesEntradas = tablaSesionesEntradas;}

	// ======== //
	// CABECERA //
	// ======== //

	/**
	 * Método que crea la cabecera de la aplicación
	 */
	private JPanel preparaPanelCabecera() {
		JPanel panelSuperior = new JPanel(new BorderLayout());
		panelSuperior.setBorder(new EmptyBorder(10, 15, 10, 15));
		panelSuperior.setBackground(CABECERA_COLOR); 

		JPanel panelCabecera = new JPanel(new BorderLayout());
		panelCabecera.setBackground(CABECERA_COLOR);

		JLabel etiquetaUsuario = new JLabel("Usuario: admin");
		etiquetaUsuario.setForeground(FUENTE_COLOR);

		JLabel etiquetaNombreProgama = new JLabel("GESTIÓN CINE", JLabel.CENTER);
		etiquetaNombreProgama.setForeground(FUENTE_COLOR);
		etiquetaNombreProgama.setFont(new Font("Garamond", Font.BOLD, 24));

		bCerrarSesion = new JButton("Cerrar sesión");

		panelCabecera.add(etiquetaUsuario, BorderLayout.WEST); 
		panelCabecera.add(etiquetaNombreProgama, BorderLayout.CENTER);
		panelCabecera.add(bCerrarSesion, BorderLayout.EAST);

		panelSuperior.add(panelCabecera, BorderLayout.CENTER);
		return panelSuperior;
	}

	// =========== //
	// JTABBEDPANE //
	// =========== //

	/**
	 * Método que crea el JTabbedPane (pestañas)
	 */
	private JPanel prepararPanelJTabbedPane() {
		JPanel panelCentral = new JPanel(new BorderLayout());
		panelCentral.setBorder(new EmptyBorder(10, 15, 10, 15));
		panelCentral.setBackground(FONDO_COLOR);

		tabbedPane = new JTabbedPane();
		// tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBackground(COMPONENTE_COLOR);

		// Gestión Peliculas
		tabbedPane.addTab("Gestión Peliculas", preparaPanelGestionPelis());
		tabbedPane.setToolTipTextAt(0, "Permite la gestión de las peliculas del cine");
		tabbedPane.setIconAt(0, new ImageIcon("./img/iconoPelis.png"));

		// Gestión Sesiones
		tabbedPane.addTab("Sesiones Disponibles", preparaPanelGestionSesiones());
		tabbedPane.setToolTipTextAt(1, "Permite consultar las sesiones disponibles en el cine");
		tabbedPane.setIconAt(1, new ImageIcon("./img/iconoSesiones.png"));

		// Comprar Entradas
		tabbedPane.addTab("Comprar Entradas", preparaPanelComprarEntradas());
		tabbedPane.setToolTipTextAt(2, "Permite realizar la compra de las entradas");
		tabbedPane.setIconAt(2, new ImageIcon("./img/iconoEntrada.png"));

		panelCentral.add(tabbedPane, BorderLayout.CENTER);
		panelCentral.setLayout(new GridLayout(1, 1));

		return panelCentral;
	}

	// ================= //
	// GESTIÓN PELÍCULAS //
	// ================= //

	/**
	 * Método que prepara el panel de la gestión de las películas
	 */
	private JPanel preparaPanelGestionPelis() {
		JPanel panelPelis = new JPanel(new BorderLayout());
		panelPelis.setBorder(new EmptyBorder(10, 15, 10, 15));
		// panelPelis.setBackground(COMPONENTE_COLOR_1);

		// Panel Central
		JPanel panelCentral = panelCentral();

		// Panel Sur
		JPanel panelSur = panelSur();

		// Añadir Paneles al Panel Pelis
		panelPelis.add(panelCentral, BorderLayout.CENTER);
		panelPelis.add(panelSur, BorderLayout.SOUTH);

		return panelPelis;
	}

	private JPanel panelCentral() {
		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.X_AXIS));
		// JPanel panelCentral = new JPanel(new GridLayout(1,2,10,10));

		// Panel Cartel Película
		JPanel panelCartelPeli = panelCartelPelicula();

		// Panel Datos Generales
		JPanel panelDatosGenerales = panelDatosGenerales();

		panelCentral.add(panelCartelPeli);
		panelCentral.add(panelDatosGenerales);
		return panelCentral;
	}

	private JPanel panelSur() {
		JPanel panelSur = new JPanel(new BorderLayout());

		// Botones Navegación
		JPanel panelBotonesNav = new JPanel();
		bPrimero = new JButton("|<");
		bAnterior = new JButton("<<");
		bSiguiente = new JButton(">>");
		bUltimo = new JButton(">|");

		panelBotonesNav.add(bPrimero);
		panelBotonesNav.add(bAnterior);
		panelBotonesNav.add(bSiguiente);
		panelBotonesNav.add(bUltimo);

		// Botones CRUD
		JPanel panelBotonesCRUD = new JPanel();
		bNueva = new JButton("Nueva");
		bModificar = new JButton("Modificar");
		bEliminar = new JButton("Eliminar");

		panelBotonesCRUD.add(bNueva);
		panelBotonesCRUD.add(bModificar);
		panelBotonesCRUD.add(bEliminar);

		panelSur.add(panelBotonesNav,BorderLayout.WEST);
		panelSur.add(panelBotonesCRUD,BorderLayout.EAST);
		return panelSur;
	}

	private JPanel panelCartelPelicula() {
		JPanel panelCartelPeli = new JPanel(new BorderLayout());
		ponerBordePanel(panelCartelPeli, "Cartel película");

		ImageIcon cartelOriginal = new ImageIcon("./img/michael_cartelera.jpg");

		etiquetaCartelPeli = new JLabel("Poner imagen",JLabel.CENTER);
		// etiquetaCartelPeli = new JLabel(cartelOriginal,JLabel.CENTER);

		panelCartelPeli.add(etiquetaCartelPeli);
		return panelCartelPeli;
	}

	private JPanel panelDatosGenerales() {
		JPanel panelDatosGenerales = new JPanel(new GridLayout(6,2,5,5));
		ponerBordePanel(panelDatosGenerales, "Datos generales");

		JLabel etiquetaIdPeli = new JLabel("ID: ");
		tfIdPeli = new JTextField(10);

		JLabel etiquetaTituloPeli = new JLabel("Titulo: ");
		tfTitulo = new JTextField(10);

		JLabel etiquetaDuracionPeli = new JLabel("Duración (minutos): ");
		tfDuracion = new JTextField(10);

		JLabel etiquetaClasificacionPeli = new JLabel("Clasificación: ");
		tfClasificacion = new JTextField(10);

		JLabel etiquetaDirectorPeli = new JLabel("Director: ");
		tfDirector = new JTextField(10);

		JLabel etiquetaAnioPeli = new JLabel("Año: ");
		tfAnio = new JTextField(10);

		JTextField[] arrayJTextFields = {tfIdPeli,tfTitulo,tfDuracion,tfClasificacion,tfDirector,tfAnio};
		for (JTextField textfield : arrayJTextFields) {
			textfield.setEnabled(false);
		}

		panelDatosGenerales.add(etiquetaIdPeli);
		panelDatosGenerales.add(tfIdPeli);

		panelDatosGenerales.add(etiquetaTituloPeli);
		panelDatosGenerales.add(tfTitulo);

		panelDatosGenerales.add(etiquetaDuracionPeli);
		panelDatosGenerales.add(tfDuracion);

		panelDatosGenerales.add(etiquetaClasificacionPeli);
		panelDatosGenerales.add(tfClasificacion);

		panelDatosGenerales.add(etiquetaDirectorPeli);
		panelDatosGenerales.add(tfDirector);

		panelDatosGenerales.add(etiquetaAnioPeli);
		panelDatosGenerales.add(tfAnio);
		return panelDatosGenerales;
	}

	// ================ //
	// GESTIÓN SESIONES //
	// ================ //

	/**
	 * Método que prepara el panel de la gestión de las sesiones
	 */
	private JPanel preparaPanelGestionSesiones() {
		JPanel panelSesiones = new JPanel(new BorderLayout());
		panelSesiones.setBorder(new EmptyBorder(10, 15, 10, 15));
		// panelSesiones.setBackground(COMPONENTE_COLOR_1);

		JPanel panelSur = new JPanel(new BorderLayout());

		JPanel panelBotonesIzquierda = new JPanel();

		bTodasSesiones = new JButton("Todas las sesiones");
		bHoySesiones = new JButton("Sesiones de hoy");

		panelBotonesIzquierda.add(bTodasSesiones);
		panelBotonesIzquierda.add(bHoySesiones);

		JPanel panelBotonesDerecha = new JPanel();

		JLabel etiquetaIdSesion = new JLabel("ID de la sesión: ",JLabel.RIGHT);
		tfIdSesion = new JTextField(3);
		JLabel etiquetaTipoSala = new JLabel("Tipo de sala: ");
		cbTipoSala = new JComboBox<String>();
		bBuscarSesion = new JButton("Buscar");

		panelBotonesDerecha.add(etiquetaIdSesion);
		panelBotonesDerecha.add(tfIdSesion);
		panelBotonesDerecha.add(etiquetaTipoSala);
		panelBotonesDerecha.add(cbTipoSala);
		panelBotonesDerecha.add(bBuscarSesion);

		panelSur.add(panelBotonesIzquierda,BorderLayout.WEST);
		panelSur.add(panelBotonesDerecha,BorderLayout.EAST);

		// JTable
		String[] nombreColumnas = {"id_sesion", "id_pelicula", "id_sala", "fecha", "hora", "precio"};
		String[][] datos = new String[10][6];

		for (int i = 0; i < datos.length; i++)
			for (int j = 0; j < datos[i].length; j++)
				datos[i][j] = "";

		tablaSesiones = new JTable(datos, nombreColumnas);

		TableColumnModel columnModel = tablaSesiones.getColumnModel();

		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		columnModel.getColumn(0).setCellRenderer(tcr);
		columnModel.getColumn(1).setCellRenderer(tcr);
		columnModel.getColumn(5).setCellRenderer(tcr);

		columnModel.getColumn(0).setPreferredWidth(100);
		columnModel.getColumn(1).setPreferredWidth(100);
		columnModel.getColumn(2).setPreferredWidth(100);
		columnModel.getColumn(3).setPreferredWidth(100);
		columnModel.getColumn(4).setPreferredWidth(100);
		columnModel.getColumn(5).setPreferredWidth(100);

		JScrollPane panelScroll = new JScrollPane(tablaSesiones);
		// panelScroll.setPreferredSize(new Dimension(800, 200));

		panelSesiones.add(panelScroll,BorderLayout.CENTER);
		panelSesiones.add(panelSur,BorderLayout.SOUTH);

		return panelSesiones;
	}

	// ================ //
	// COMPRAR ENTRADAS //
	// ================ //

	private JPanel preparaPanelComprarEntradas() {
		JPanel panelEntradas = new JPanel(new BorderLayout());
		panelEntradas.setBorder(new EmptyBorder(10, 15, 10, 15));
		// panelEntradas.setBackground(COMPONENTE_COLOR_1);

		JPanel panelCentral = new JPanel(new GridLayout(1,2,5,5));

		JPanel panelDatosCliente = new JPanel(new GridLayout(3,2,10,10));
		ponerBordePanel(panelDatosCliente, "Datos cliente");

		JLabel etiquetaNombreCliente = new JLabel("Nombre: ");
		tfNombreCliente = new JTextField(10);

		JLabel etiquetaApellidosCliente = new JLabel("Apellidos: ");
		tfApellidosCliente = new JTextField(10);

		JLabel etiquetaEmailCliente = new JLabel("Email: ");
		tfEmailCliente = new JTextField(10);

		panelDatosCliente.add(etiquetaNombreCliente);
		panelDatosCliente.add(tfNombreCliente);
		panelDatosCliente.add(etiquetaApellidosCliente);
		panelDatosCliente.add(tfApellidosCliente);
		panelDatosCliente.add(etiquetaEmailCliente);
		panelDatosCliente.add(tfEmailCliente);

		panelCentral.add(panelDatosCliente);

		JPanel panelSesionesDisponibles = new JPanel(new BorderLayout());
		ponerBordePanel(panelSesionesDisponibles, "Sesiones disponibles");

		String[] nombreColumnas = {"id_sesion", "id_pelicula", "id_sala", "fecha", "hora", "precio"};
		String[][] datos = new String[8][6];

		for (int i = 0; i < datos.length; i++)
			for (int j = 0; j < datos[i].length; j++)
				datos[i][j] = "";

		tablaSesionesEntradas = new JTable(datos, nombreColumnas);

		TableColumnModel columnModel = tablaSesionesEntradas.getColumnModel();

		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		columnModel.getColumn(0).setCellRenderer(tcr);
		columnModel.getColumn(1).setCellRenderer(tcr);
		columnModel.getColumn(5).setCellRenderer(tcr);

		columnModel.getColumn(0).setCellRenderer(tcr);
		columnModel.getColumn(1).setCellRenderer(tcr);
		columnModel.getColumn(5).setCellRenderer(tcr);

		columnModel.getColumn(0).setPreferredWidth(50);
		columnModel.getColumn(1).setPreferredWidth(50);
		columnModel.getColumn(2).setPreferredWidth(50);
		columnModel.getColumn(3).setPreferredWidth(40);
		columnModel.getColumn(4).setPreferredWidth(40);
		columnModel.getColumn(5).setPreferredWidth(40);

		JScrollPane panelScroll = new JScrollPane(tablaSesionesEntradas);
		// panelScroll.setPreferredSize(new Dimension(800, 200));

		panelSesionesDisponibles.add(panelScroll);

		panelCentral.add(panelSesionesDisponibles);

		JPanel panelSur = new JPanel();
		bComprarEntrada = new JButton("COMPRAR ENTRADA");
		bCancelarCompra = new JButton("CANCELAR");

		panelSur.add(bComprarEntrada);
		panelSur.add(bCancelarCompra);

		panelEntradas.add(panelCentral,BorderLayout.CENTER);
		panelEntradas.add(panelSur,BorderLayout.SOUTH);

		return panelEntradas;
	}

	/**
	 * Método Para Poner Bordes Paneles
	 */
	public void ponerBordePanel(JPanel panel, String textoDelBorde) {
		TitledBorder titledBorder = new TitledBorder(textoDelBorde);
		panel.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5),titledBorder));
	}

	/**
	 * Método para dar control a los componentes de la interfaz
	 */
	public void control(Controlador ctr) {
		bCerrarSesion.addActionListener(ctr);
		bPrimero.addActionListener(ctr);
		bAnterior.addActionListener(ctr);
		bSiguiente.addActionListener(ctr);
		bUltimo.addActionListener(ctr);
		bNueva.addActionListener(ctr);
		bModificar.addActionListener(ctr);
		bEliminar.addActionListener(ctr);
		bTodasSesiones.addActionListener(ctr);
		bHoySesiones.addActionListener(ctr);
		cbTipoSala.addActionListener(ctr);
		bBuscarSesion.addActionListener(ctr);
		bComprarEntrada.addActionListener(ctr);
		bCancelarCompra.addActionListener(ctr);
	}

}
