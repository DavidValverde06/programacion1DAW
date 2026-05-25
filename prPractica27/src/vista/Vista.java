package vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;

import controlador.*;

public class Vista extends JPanel {

	private static final long serialVersionUID = -5752211613049689258L;

	/**
	 * Variables de instancia
	 */
	private JToolBar tbBarraHerramientas; // Barra de herramientas
	private JMenuBar mbBarraMenu; // Barra de menu
	private JMenu mArchivo,mEdicion,mApariencia,mHerramientas; // Menus
	private JMenuItem miNuevo,miAbrir,miGuardar,miGuardarComo,miSalir; // Archivo
	private JMenuItem miCortar,miCopiar,miPegar; // Edicion
	private JMenuItem miTipoNormal,miItalica,miNegrita; // Apariencia
	private JMenu submTamanio; // Submenu
	private JMenuItem miMuyPequenio,miPequenio,miNormal,miGrande,miMuyGrande; // Opciones Submenu
	private JMenuItem miPasarAMayus, miPasarAMinus; // Herramientas
	private JTextArea taAreaCentral; // Text Area
	private JButton bNuevo,bAbrir,bGuardar,bGuardarComo,bCortar,bCopiar,bPegar,
	bNegrita,bCursiva,bAumentarTamanio,bDisminuirTamanio,bPasarAMayus,bPasarAMinus,
	bCambiarColorFondo,bCambiarColorFuente; // Botones
	private JComboBox<String> cbFuente; // ComboBox
	private JComboBox<Integer> cbTamanioLetra; // ComboBox
	private JLabel labelTextoBuscar;
	private JTextField tfTextoBuscar;
	private JButton bBuscar,bLimpiar;

	/**
	 * Constructor
	 */
	public Vista() {
		/**
		 * El área central de la ventana permite la edición de texto y está implementado con un componente
		 * de “área de texto” (JTextArea). 
		 */
		prepararTextArea();

		/**
		 * Barra de menú
		 */
		prepararMenu();

		/**
		 * Barra de herramientas
		 */
		prepararBarraHerramientas();

		/**
		 * Panel busqueda
		 */
		prepararPanelBusqueda();
	}

	/**
	 * Método prepararPanelBusqueda()
	 */
	private void prepararPanelBusqueda() {
		JPanel panelBusqueda = new JPanel();

		panelBusqueda.setBorder(new CompoundBorder(new TitledBorder("Buscar texto"), null));
		panelBusqueda.setBackground(Color.LIGHT_GRAY);

		labelTextoBuscar = new JLabel("Texto a buscar: ");
		tfTextoBuscar = new JTextField(40);
		bBuscar = new JButton("Buscar");
		bLimpiar = new JButton("Limpiar");

		panelBusqueda.add(labelTextoBuscar);
		panelBusqueda.add(tfTextoBuscar);
		panelBusqueda.add(bBuscar);
		panelBusqueda.add(bLimpiar);

		this.add(panelBusqueda, BorderLayout.SOUTH);
	}

	/**
	 * Método prepararTextArea()
	 */
	private void prepararTextArea() {
		this.setLayout(new BorderLayout());

		taAreaCentral = new JTextArea("Hola amigo");

		JScrollPane panelScroll = new JScrollPane(taAreaCentral);

		this.add(panelScroll, BorderLayout.CENTER);
	}

	/**
	 * Método prepararBarraHerramientas()
	 */
	private void prepararBarraHerramientas() {
		tbBarraHerramientas = new JToolBar();

		bNuevo = new JButton(new ImageIcon("./src/imagenes/nuevo.png"));
		bAbrir = new JButton(new ImageIcon("./src/imagenes/abrir.png"));
		bGuardar = new JButton(new ImageIcon("./src/imagenes/guardar.png"));
		bGuardarComo = new JButton(new ImageIcon("./src/imagenes/guardarComo.png"));
		bCortar = new JButton(new ImageIcon("./src/imagenes/cortar.png"));
		bCopiar = new JButton(new ImageIcon("./src/imagenes/copiar.png"));
		bPegar = new JButton(new ImageIcon("./src/imagenes/pegar.png"));
		bNegrita = new JButton(new ImageIcon("./src/imagenes/negrita.jpg"));
		bCursiva = new JButton(new ImageIcon("./src/imagenes/cursiva.jpg"));
		bAumentarTamanio = new JButton(new ImageIcon("./src/imagenes/aumentar.png"));
		bDisminuirTamanio = new JButton(new ImageIcon("./src/imagenes/disminuir.png"));
		bPasarAMayus = new JButton(new ImageIcon("./src/imagenes/aMayuscula.png"));
		bPasarAMinus = new JButton(new ImageIcon("./src/imagenes/aMinuscula.png"));
		bCambiarColorFondo = new JButton(new ImageIcon("./src/imagenes/colorFondo.jpg"));
		bCambiarColorFuente = new JButton(new ImageIcon("./src/imagenes/colorTexto.jpg"));
		cbFuente = new JComboBox<String>();
		cbTamanioLetra = new JComboBox<Integer>();

		// Fuentes
		String[] fuentes = {"Serif","Comic Sans MS", "Courier New", "Consolas", "Times New Roman", "Arial"};
		for (String f : fuentes) {
			cbFuente.addItem(f);
		}
		cbFuente.setSelectedItem("Serif");

		// Tamaño fuente
		int[] tamanios = {8,10,12,14,16,18,20,24,28,32,36,48,72};
		for (int t : tamanios) {
			cbTamanioLetra.addItem(t);
		}
		cbTamanioLetra.setSelectedItem(12);

		// SetActionCommand
		bNuevo.setActionCommand("Nuevo");
		bAbrir.setActionCommand("Abrir");
		bGuardar.setActionCommand("Guardar");
		bGuardarComo.setActionCommand("Guardar como");
		bCortar.setActionCommand("Cortar");
		bCopiar.setActionCommand("Copiar");
		bPegar.setActionCommand("Pegar");
		bNegrita.setActionCommand("Negrita");
		bCursiva.setActionCommand("Cursiva");
		bAumentarTamanio.setActionCommand("AumentarTamanio");
		bDisminuirTamanio.setActionCommand("DisminuirTamanio");
		bPasarAMayus.setActionCommand("Pasar texto a mayúsculas");
		bPasarAMinus.setActionCommand("Pasar texto a minúsculas");
		bCambiarColorFondo.setActionCommand("CambiarColorFondo");
		bCambiarColorFuente.setActionCommand("CambiarColorFuente");

		// ToolTips
		bNuevo.setToolTipText("Nuevo documento");
		bAbrir.setToolTipText("Abrir archivo");
		bGuardar.setToolTipText("Guardar");
		bGuardarComo.setToolTipText("Guardar como...");
		bCortar.setToolTipText("Cortar (Ctrl+X)");
		bCopiar.setToolTipText("Copiar (Ctrl+C)");
		bPegar.setToolTipText("Pegar (Ctrl+V)");
		bNegrita.setToolTipText("Negrita");
		bCursiva.setToolTipText("Cursiva");
		bAumentarTamanio.setToolTipText("Aumentar tamaño de fuente");
		bDisminuirTamanio.setToolTipText("Disminuir tamaño de fuente");
		bPasarAMayus.setToolTipText("Pasar texto a MAYÚSCULAS");
		bPasarAMinus.setToolTipText("Pasar texto a minúsculas");
		bCambiarColorFondo.setToolTipText("Cambiar color de fondo");
		bCambiarColorFuente.setToolTipText("Cambiar color de fuente");
		cbFuente.setToolTipText("Tipo de fuente");
		cbTamanioLetra.setToolTipText("Tamaño de letra");

		tbBarraHerramientas.add(bNuevo);
		tbBarraHerramientas.add(bAbrir);
		tbBarraHerramientas.add(bGuardar);
		tbBarraHerramientas.add(bGuardarComo);
		tbBarraHerramientas.add(bCortar);
		tbBarraHerramientas.add(bCopiar);
		tbBarraHerramientas.add(bPegar);
		tbBarraHerramientas.add(bNegrita);
		tbBarraHerramientas.add(bCursiva);
		tbBarraHerramientas.add(bAumentarTamanio);
		tbBarraHerramientas.add(bDisminuirTamanio);
		tbBarraHerramientas.add(bPasarAMayus);
		tbBarraHerramientas.add(bPasarAMinus);
		tbBarraHerramientas.add(bCambiarColorFondo);
		tbBarraHerramientas.add(bCambiarColorFuente);
		tbBarraHerramientas.add(cbFuente);
		tbBarraHerramientas.add(cbTamanioLetra);

		this.add(tbBarraHerramientas, BorderLayout.NORTH);
	}

	/**
	 * Método que crea y añade todas las opciones y submenus de a barra de menu del programa
	 */
	private void prepararMenu() {
		mbBarraMenu = new JMenuBar();

		mArchivo = new JMenu("Archivo");
		mEdicion = new JMenu("Edición");
		mApariencia = new JMenu("Apariencia");
		mHerramientas = new JMenu("Herramientas");

		// Archivo
		miNuevo = new JMenuItem("Nuevo");
		miAbrir = new JMenuItem("Abrir");
		miGuardar = new JMenuItem("Guardar");
		miGuardarComo = new JMenuItem("Guardar como");
		miSalir = new JMenuItem("Salir");

		mArchivo.add(miNuevo);
		mArchivo.add(miAbrir);
		mArchivo.add(miGuardar);
		mArchivo.add(miGuardarComo);
		mArchivo.add(miSalir);

		// Edición

		miCortar = new JMenuItem(taAreaCentral.getActionMap().get(DefaultEditorKit.cutAction));
		miCortar.setText("Cortar");
		miCortar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

		miCopiar = new JMenuItem(taAreaCentral.getActionMap().get(DefaultEditorKit.copyAction));
		miCopiar.setText("Copiar");
		miCopiar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));

		miPegar = new JMenuItem(taAreaCentral.getActionMap().get(DefaultEditorKit.pasteAction));
		miPegar.setText("Pegar");
		miPegar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));

		mEdicion.add(miCortar);
		mEdicion.add(miCopiar);
		mEdicion.add(miPegar);

		// Apariencia
		miTipoNormal = new JMenuItem("Normal");
		miItalica = new JMenuItem("Itálica");
		miNegrita = new JMenuItem("Negrita");
		submTamanio = new JMenu("Tamaño");

		miMuyPequenio = new JMenuItem("Muy pequeño");
		miPequenio = new JMenuItem("Pequeño");
		miNormal = new JMenuItem("Tamaño normal");
		miGrande = new JMenuItem("Grande");
		miMuyGrande = new JMenuItem("Muy grande");

		submTamanio.add(miMuyPequenio);
		submTamanio.add(miPequenio);
		submTamanio.add(miNormal);
		submTamanio.add(miGrande);
		submTamanio.add(miMuyGrande);

		mApariencia.add(miTipoNormal);
		mApariencia.add(miItalica);
		mApariencia.add(miNegrita);
		mApariencia.add(submTamanio);

		// Herramientas
		miPasarAMinus = new JMenuItem("Pasar texto a minúsculas");
		miPasarAMayus = new JMenuItem("Pasar texto a mayúsculas");

		mHerramientas.add(miPasarAMinus);
		mHerramientas.add(miPasarAMayus);

		// Barra Menu
		mbBarraMenu.add(mArchivo);
		mbBarraMenu.add(mEdicion);
		mbBarraMenu.add(mApariencia);
		mbBarraMenu.add(mHerramientas);
	}

	public void control(Controlador ctr) {
		// Botones toolbar
		bNuevo.addActionListener(ctr);
		bAbrir.addActionListener(ctr);
		bGuardar.addActionListener(ctr);
		bGuardarComo.addActionListener(ctr);
		bCortar.addActionListener(ctr);
		bCopiar.addActionListener(ctr);
		bPegar.addActionListener(ctr);
		bNegrita.addActionListener(ctr);
		bCursiva.addActionListener(ctr);
		bAumentarTamanio.addActionListener(ctr);
		bDisminuirTamanio.addActionListener(ctr);
		bPasarAMayus.addActionListener(ctr);
		bPasarAMinus.addActionListener(ctr);
		bCambiarColorFondo.addActionListener(ctr);
		bCambiarColorFuente.addActionListener(ctr);

		// MenuItems
		miNuevo.addActionListener(ctr);
		miAbrir.addActionListener(ctr);
		miGuardar.addActionListener(ctr);
		miGuardarComo.addActionListener(ctr);
		miSalir.addActionListener(ctr);
		miCortar.addActionListener(ctr);
		miCopiar.addActionListener(ctr);
		miPegar.addActionListener(ctr);
		miTipoNormal.addActionListener(ctr);
		miItalica.addActionListener(ctr);
		miNegrita.addActionListener(ctr);
		miMuyPequenio.addActionListener(ctr);
		miPequenio.addActionListener(ctr);
		miNormal.addActionListener(ctr);
		miGrande.addActionListener(ctr);
		miMuyGrande.addActionListener(ctr);
		miPasarAMayus.addActionListener(ctr);
		miPasarAMinus.addActionListener(ctr);

		// Panel búsqueda
		bBuscar.addActionListener(ctr);
		bLimpiar.addActionListener(ctr);

		// ComboBox
		cbFuente.addItemListener(ctr);
		cbTamanioLetra.addItemListener(ctr);
	}

	/**
	 * Getter's
	 */
	public JToolBar getTbBarraHerramientas() {
		return tbBarraHerramientas;
	}

	public JMenuBar getMbBarraMenu() {
		return mbBarraMenu;
	}

	public JMenu getmArchivo() {
		return mArchivo;
	}

	public JMenu getmEdicion() {
		return mEdicion;
	}

	public JMenu getmApariencia() {
		return mApariencia;
	}

	public JMenu getmHerramientas() {
		return mHerramientas;
	}

	public JMenuItem getMiNuevo() {
		return miNuevo;
	}

	public JMenuItem getMiAbrir() {
		return miAbrir;
	}

	public JMenuItem getMiGuardar() {
		return miGuardar;
	}

	public JMenuItem getMiGuardarComo() {
		return miGuardarComo;
	}

	public JMenuItem getMiSalir() {
		return miSalir;
	}

	public JMenuItem getMiCortar() {
		return miCortar;
	}

	public JMenuItem getMiCopiar() {
		return miCopiar;
	}

	public JMenuItem getMiPegar() {
		return miPegar;
	}

	public JMenuItem getMiTipoNormal() {
		return miTipoNormal;
	}

	public JMenuItem getMiItalica() {
		return miItalica;
	}

	public JMenuItem getMiNegrita() {
		return miNegrita;
	}

	public JMenu getSubmTamanio() {
		return submTamanio;
	}

	public JMenuItem getMiMuyPequenio() {
		return miMuyPequenio;
	}

	public JMenuItem getMiPequenio() {
		return miPequenio;
	}

	public JMenuItem getMiNormal() {
		return miNormal;
	}

	public JMenuItem getMiGrande() {
		return miGrande;
	}

	public JMenuItem getMiMuyGrande() {
		return miMuyGrande;
	}

	public JTextArea getTaAreaCentral() {
		return taAreaCentral;
	}

	public JButton getbNuevo() {
		return bNuevo;
	}

	public JButton getbAbrir() {
		return bAbrir;
	}

	public JButton getbGuardar() {
		return bGuardar;
	}

	public JButton getbGuardarComo() {
		return bGuardarComo;
	}

	public JButton getbCortar() {
		return bCortar;
	}

	public JButton getbCopiar() {
		return bCopiar;
	}

	public JButton getbPegar() {
		return bPegar;
	}

	public JButton getbNegrita() {
		return bNegrita;
	}

	public JButton getbCursiva() {
		return bCursiva;
	}

	public JButton getbAumentarTamanio() {
		return bAumentarTamanio;
	}

	public JButton getbDisminuirTamanio() {
		return bDisminuirTamanio;
	}

	public JButton getbPasarAMayus() {
		return bPasarAMayus;
	}

	public JButton getbPasarAMinus() {
		return bPasarAMinus;
	}

	public JButton getbCambiarColorFondo() {
		return bCambiarColorFondo;
	}

	public JButton getbCambiarColorFuente() {
		return bCambiarColorFuente;
	}

	public JComboBox<String> getCbFuente() {
		return cbFuente;
	}

	public JComboBox<Integer> getCbTamanioLetra() {
		return cbTamanioLetra;
	}

	public JLabel getLabelTextoBuscar() {
		return labelTextoBuscar;
	}

	public JTextField getTfTextoBuscar() {
		return tfTextoBuscar;
	}

	public JButton getbBuscar() {
		return bBuscar;
	}

	public JButton getbLimpiar() {
		return bLimpiar;
	}

}
