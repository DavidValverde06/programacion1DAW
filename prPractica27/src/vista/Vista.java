package vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
	private JColorChooser cchEscogerColor; // ColorChooser
	private JLabel labelTextoBuscar;
	private JTextField tfTextoBUscar;
	private JButton bBuscar,bLimpiar;

	/**
	 * Constructor
	 */
	public Vista() {

		/**
		 * El área central de la ventana permite la edición de texto y está implementado con un componente
		 * de “área de texto” (JTextArea). 
		 */
		JPanel panelCentral = new JPanel(new BorderLayout());
		JScrollPane panelScroll = new JScrollPane();
		taAreaCentral = new JTextArea(10,10);
		panelScroll.add(taAreaCentral);
		panelCentral.add(panelScroll);

		this.add(panelCentral, BorderLayout.CENTER);

		/**
		 * Barra de menú
		 */
		prepararMenu();

		/**
		 * Barra de herramientas
		 */
		tbBarraHerramientas = new JToolBar();

		bNuevo = new JButton();
		bAbrir = new JButton();
		bGuardar = new JButton();
		bGuardarComo = new JButton();
		bCortar = new JButton();
		bCopiar = new JButton();
		bPegar = new JButton();
		bNegrita = new JButton();
		bCursiva = new JButton();
		bAumentarTamanio = new JButton();
		bDisminuirTamanio = new JButton();
		bPasarAMayus = new JButton();
		bPasarAMinus = new JButton();
		bCambiarColorFondo = new JButton();
		bCambiarColorFuente = new JButton();
		cbFuente = new JComboBox<String>();
		cbTamanioLetra = new JComboBox<Integer>();

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

		this.add(tbBarraHerramientas);

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
		miCortar = new JMenuItem("Cortar");
		miCopiar = new JMenuItem("Copiar");
		miPegar = new JMenuItem("Pegar");

		miCortar.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

		miCopiar.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));

		miPegar.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));

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
		miNormal = new JMenuItem("Normal");
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

	public JColorChooser getCchEscogerColor() {
		return cchEscogerColor;
	}

	public JLabel getLabelTextoBuscar() {
		return labelTextoBuscar;
	}

	public JTextField getTfTextoBUscar() {
		return tfTextoBUscar;
	}

	public JButton getbBuscar() {
		return bBuscar;
	}

	public JButton getbLimpiar() {
		return bLimpiar;
	}
}
