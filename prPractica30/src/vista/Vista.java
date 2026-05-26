package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import controlador.Controlador;

public class Vista extends JPanel {

	private static final long serialVersionUID = -5752211613049689258L;

	/**
	 * Variables de instancia
	 */
	// Pestañas
	private JTabbedPane tabbedPane;
	// Añadir Libros
	private JTextField tfCodigo,tfTitulo,tfEscritor;
	private JTextArea taAreaPersonajes;
	private JButton bAnadirLibro,bCancelarLibro;
	// Añadir Clientes
	private JTextField tfNombreCliente;
	private JButton bAnadirCliente,bCancelarCliente;
	// Libros Disponibles
	private JTextArea taAreaLibros;
	private JButton bActualizarLista;
	// Prestamo Libros
	private JComboBox<String> cbListadoClientesPrestar,cbListadoLibrosPrestar;
	private JButton bPrestar,bCancelarPrestar;
	// Devolucion Libros
	private JComboBox<String> cbListadoClientesDevolver,cbListadoLibrosDevolver;
	private JButton bDevolver,bCancelarDevolver;

	/**
	 * Constructor
	 */
	public Vista() {

		// Crear un objeto de la clase DialogoInicio
		DialogoInicio dialogo = new DialogoInicio();

		// Crear un TabbedPane (pestañas)
		tabbedPane = new JTabbedPane();
		tabbedPane.setBackground(Color.white);

		// A cada pestaña, se le especificará un texto, se le añadirá un panel,
		// y se le pondrá un ToolTip (es opcional) para que se visualice al acercar el ratón,
		// y por último se le ha establecido una imagen (también es opcional)

		// Las pestañas empiezan a numerarse desde 0, 1, 2, ...

		tabbedPane.addTab("Añadir libros", preparaPanelAnadirLibros());
		tabbedPane.setToolTipTextAt(0, "Permite añadir libros a la Biblioteca");
		tabbedPane.setIconAt(0, new ImageIcon("./src/recursos/imagenes/IconoLibros.png"));
		// Lo anterior lo repetiremos por cada pestaña

		tabbedPane.addTab("Añadir clientes", preparaPanelAnadirClientes());
		tabbedPane.setToolTipTextAt(1, "Permite añadir clientes a la Biblioteca");
		tabbedPane.setIconAt(1, new ImageIcon("./src/recursos/imagenes/IconoClientes.png"));

		tabbedPane.addTab("Libros disponibles", preparaPanelLibros());
		tabbedPane.setToolTipTextAt(2, "Permite ver que libros hay en la Biblioteca");
		tabbedPane.setIconAt(2, new ImageIcon("./src/recursos/imagenes/MontonLibros2.png"));

		tabbedPane.addTab("Préstamo de libros", preparaPanelPrestarLibros());
		tabbedPane.setToolTipTextAt(3, "Permite sacar libros de la Biblioteca");
		tabbedPane.setIconAt(3, new ImageIcon("./src/recursos/imagenes/Lector4.png"));

		tabbedPane.addTab("Devolución de libross", preparaPanelDevolverLibros());
		tabbedPane.setToolTipTextAt(4, "Permite devolver libros a la Biblioteca");
		tabbedPane.setIconAt(4, new ImageIcon("./src/recursos/imagenes/MontonLibros4.png"));

		// Añadir el JTabbedPane al panel implícito (this) y cambiar el gestor de esquemas
		this.setLayout(new GridLayout(1, 1));
		// Hay que darle este gestor de esquemas sino pondrá una
		// pestaña debajo de otra en la distribución horizontal
		this.add(tabbedPane);

		// tabbedPane.setTabPlacement(JTabbedPane.LEFT); // Poner las pestañas en vertical

	}

	/**
	 * Panel añadir libros (1º pestaña)
	 */
	private JPanel preparaPanelAnadirLibros() {
		JPanel panelAnadirLibros = new JPanel(new BorderLayout());
		panelAnadirLibros.setBackground(Color.white);
		ponerBordePanel(panelAnadirLibros, "DATOS NUEVO LIBRO");

		JPanel panelCentral = new JPanel(new GridLayout(1,3,5,5));
		panelCentral.setBackground(Color.white);

		JPanel panelCampos = new JPanel(new GridLayout(3,1,5,5));
		panelCampos.setBackground(Color.white);

		tfCodigo = new JTextField();
		tfTitulo = new JTextField();
		tfEscritor = new JTextField();

		tfCodigo.setBorder(new CompoundBorder(
				new EmptyBorder(5,5,5,5),
				new TitledBorder("Código"))
				);

		tfTitulo.setBorder(new CompoundBorder(
				new EmptyBorder(5,5,5,5),
				new TitledBorder("Título"))
				);

		tfEscritor.setBorder(new CompoundBorder(
				new EmptyBorder(5,5,5,5),
				new TitledBorder("Escritor"))
				);

		tfCodigo.setBackground(Color.white);
		tfTitulo.setBackground(Color.white);
		tfEscritor.setBackground(Color.white);

		panelCampos.add(tfCodigo);
		panelCampos.add(tfTitulo);
		panelCampos.add(tfEscritor);

		JPanel panelImagen = new JPanel();
		panelImagen.setBackground(Color.white);
		ImageIcon icono = new ImageIcon("./src/recursos/imagenes/libroAbierto.png");
		JLabel etiquetaImagen = new JLabel(icono);
		etiquetaImagen.setBackground(Color.white);
		panelImagen.add(etiquetaImagen);

		taAreaPersonajes = new JTextArea("<Nombre personajes separados por linea>");
		taAreaPersonajes.setBackground(Color.white);
		taAreaPersonajes.setBorder(new CompoundBorder(
				new EmptyBorder(5,5,5,5),
				new TitledBorder("Personajes"))
				);

		panelCentral.add(panelCampos);
		panelCentral.add(panelImagen);
		panelCentral.add(taAreaPersonajes);

		JPanel panelSur = new JPanel();
		panelSur.setBackground(Color.white);
		bAnadirLibro = new JButton("Añadir");
		bCancelarLibro = new JButton("Cancelar");
		panelSur.add(bAnadirLibro);
		panelSur.add(bCancelarLibro);

		panelAnadirLibros.add(panelCentral, BorderLayout.CENTER);
		panelAnadirLibros.add(panelSur, BorderLayout.SOUTH);

		return panelAnadirLibros;
	}

	/**
	 * Panel añadir clientes (2º pestaña)
	 */
	private JPanel preparaPanelAnadirClientes() {
		JPanel panelAnadirClientes = new JPanel(new FlowLayout());
		panelAnadirClientes.setBackground(Color.white);

		tfNombreCliente = new JTextField(25);
		tfNombreCliente.setBorder(new CompoundBorder(
				new EmptyBorder(5,5,5,5),
				new TitledBorder("Nombre cliente"))
				);
		tfNombreCliente.setBackground(Color.white);		
		bAnadirCliente = new JButton("Añadir");
		bCancelarCliente = new JButton("Cancelar");

		panelAnadirClientes.add(tfNombreCliente);
		panelAnadirClientes.add(bAnadirCliente);
		panelAnadirClientes.add(bCancelarCliente);

		return panelAnadirClientes;
	}

	/**
	 * Panel listado libros (3º pestaña)
	 */
	private JPanel preparaPanelLibros() {
		JPanel panelLibros = new JPanel(new BorderLayout());
		panelLibros.setBackground(Color.white);

		taAreaLibros = new JTextArea();
		JScrollPane panelScroll = new JScrollPane(taAreaLibros);
		panelScroll.setBackground(Color.white);
		taAreaLibros.setBorder(new CompoundBorder(
				new EmptyBorder(5,5,5,5),
				new TitledBorder("Libros disponibles en la biblioteca"))
				);

		panelLibros.add(panelScroll, BorderLayout.CENTER);

		JPanel panelBoton = new JPanel();
		panelBoton.setBackground(Color.white);
		bActualizarLista = new JButton("Actualizar lista");
		panelBoton.add(bActualizarLista);

		panelLibros.add(panelBoton, BorderLayout.SOUTH);

		return panelLibros;
	}

	/**
	 * Panel prestar libros (4º pestaña)
	 */
	private JPanel preparaPanelPrestarLibros() {
		JPanel panelPrestar = new JPanel();
		panelPrestar.setBackground(Color.white);

		JPanel panelPrincipal = new JPanel(new BorderLayout());
		ponerBordePanel(panelPrincipal, "Préstamo de libros");
		panelPrincipal.setBackground(Color.white);

		JPanel panelGrid = new JPanel(new GridLayout(2,2,5,5));
		panelGrid.setBackground(Color.white);
		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(Color.white);

		JLabel labelListadoClientes = new JLabel("Listado de clientes",JLabel.RIGHT);
		cbListadoClientesPrestar = new JComboBox<String>();
		JLabel labelListadoLibros = new JLabel("Listado de libros",JLabel.RIGHT);
		cbListadoLibrosPrestar = new JComboBox<String>();

		bPrestar = new JButton("Prestar");
		bCancelarPrestar = new JButton("Cancelar");

		panelGrid.add(labelListadoClientes);
		panelGrid.add(cbListadoClientesPrestar);
		panelGrid.add(labelListadoLibros);
		panelGrid.add(cbListadoLibrosPrestar);

		panelBotones.add(bPrestar);
		panelBotones.add(bCancelarPrestar);

		panelPrincipal.add(panelGrid, BorderLayout.NORTH);
		panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

		panelPrestar.add(panelPrincipal);

		return panelPrestar;
	}

	/**
	 * Panel devolver libros (5º pestaña)
	 */
	private JPanel preparaPanelDevolverLibros() {
		JPanel panelDevolver = new JPanel();
		panelDevolver.setBackground(Color.white);

		JPanel panelPrincipal = new JPanel(new BorderLayout());
		panelPrincipal.setBackground(Color.white);
		ponerBordePanel(panelPrincipal, "Devolución de libros");

		JPanel panelGrid = new JPanel(new GridLayout(2,2,5,5));
		panelGrid.setBackground(Color.white);
		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(Color.white);

		JLabel labelListadoClientes = new JLabel("Listado de clientes",JLabel.RIGHT);
		cbListadoClientesDevolver = new JComboBox<String>();
		JLabel labelLibrosPrestados = new JLabel("Libros prestados",JLabel.RIGHT);
		cbListadoLibrosDevolver = new JComboBox<String>();

		bDevolver = new JButton("Devolver");
		bCancelarDevolver = new JButton("Cancelar");

		panelGrid.add(labelListadoClientes);
		panelGrid.add(cbListadoClientesDevolver);
		panelGrid.add(labelLibrosPrestados);
		panelGrid.add(cbListadoLibrosDevolver);

		panelBotones.add(bDevolver);
		panelBotones.add(bCancelarDevolver);

		panelPrincipal.add(panelGrid, BorderLayout.NORTH);
		panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

		panelDevolver.add(panelPrincipal);

		return panelDevolver;
	}

	/**
	 * Método Para Poner Bordes Paneles
	 */
	public void ponerBordePanel(JPanel panel, String textoDelBorde) {
		panel.setBorder(new CompoundBorder(
				new EmptyBorder(5,5,5,5),
				new TitledBorder(textoDelBorde))
				);
	}

	/**
	 * Método para dar control a los componentes de la interfaz
	 */
	public void control(Controlador ctr) {
		// Añadir libros
	    bAnadirLibro.addActionListener(ctr);
	    bCancelarLibro.addActionListener(ctr);
	    // Añadir clientes
	    bAnadirCliente.addActionListener(ctr);
	    bCancelarCliente.addActionListener(ctr);
	    // Libros disponibles
	    bActualizarLista.addActionListener(ctr);
	    // Préstamo de libros
	    cbListadoClientesPrestar.addActionListener(ctr);
	    cbListadoLibrosPrestar.addActionListener(ctr);
	    bPrestar.addActionListener(ctr);
	    bCancelarPrestar.addActionListener(ctr);
	    // Devolución de libros
	    cbListadoClientesDevolver.addActionListener(ctr);
	    cbListadoLibrosDevolver.addActionListener(ctr);
	    bDevolver.addActionListener(ctr);
	    bCancelarDevolver.addActionListener(ctr);
	}
	
}
