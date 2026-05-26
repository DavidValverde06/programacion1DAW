package vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import modelo.*;

public class DialogoInicio extends JDialog implements ActionListener {

	private static final long serialVersionUID = -6075707092666802852L;

	/**
	 * Variables de instancia
	 */
	private JTextField tfFicheroLibros,tfFicheroClientes;
	private JButton bCrearBibliotecaDatos,bCrearBibliotecaSinDatos;
	private Biblioteca miBiblio;

	/**
	 * Constructor
	 */
	public DialogoInicio() {

		this.setModal(true);
		this.setTitle("Creación Biblioteca");
		// this.setLayout(new BorderLayout(20,20));

		/**
		 * Panel Principal
		 */
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));

		/**
		 * Métodos para preparar el resto de paneles
		 */
		prepararPanelNorte(panelPrincipal);
		prepararPanelSur(panelPrincipal);
		control();

		/**
		 * Establecer tamaño, pack, ...
		 */
		// this.setLocationRelativeTo(null);
		this.setLocation(458, 220);
		this.setPreferredSize(new Dimension(400,300));
		this.pack();
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);

	}

	/**
	 * Getter's y Setter's
	 */
	public JTextField getTfFicheroLibros() {
		return tfFicheroLibros;
	}

	public JTextField getTfFicheroClientes() {
		return tfFicheroClientes;
	}

	public JButton getbCrearBibliotecaDatos() {
		return bCrearBibliotecaDatos;
	}

	public JButton getbCrearBibliotecaSinDatos() {
		return bCrearBibliotecaSinDatos;
	}

	public Biblioteca getMiBiblio() {
		return miBiblio;
	}

	/**
	 * Método para Preparar el Panel Sur
	 */
	private void prepararPanelSur(JPanel panelPrincipal) {
		JPanel panelSur = new JPanel();
		ponerBordePanel(panelSur, "Creación Biblioteca sin datos previos (en blanco)");

		bCrearBibliotecaSinDatos = new JButton("Crear Biblioteca");

		panelSur.add(bCrearBibliotecaSinDatos);

		panelPrincipal.add(panelSur);

		this.add(panelPrincipal);

		// Panel Vacio
		JPanel panelVacio = new JPanel();
		panelPrincipal.add(panelVacio);
	}

	/**
	 * Método para Preparar el Panel Norte
	 */
	private void prepararPanelNorte(JPanel panelPrincipal) {
		JPanel panelNorte = new JPanel();
		ponerBordePanel(panelNorte, "Creación Biblioteca a partir datos existentes");
		JPanel panelGrid = new JPanel(new GridLayout(2,2,5,5));

		JLabel labelLibros = new JLabel("Nombre fichero libros", JLabel.RIGHT);
		tfFicheroLibros = new JTextField(17);
		JLabel labelClientes = new JLabel("Nombre fichero clientes", JLabel.RIGHT);
		tfFicheroClientes = new JTextField(17);
		bCrearBibliotecaDatos = new JButton("Crear Biblioteca");

		/**
		 * Para ahorrar tiempo ya escribo los ficheros en los JTextField
		 */
		tfFicheroClientes.setText("clientes.txt");
		tfFicheroLibros.setText("libros.txt");

		panelGrid.add(labelLibros);
		panelGrid.add(tfFicheroLibros);
		panelGrid.add(labelClientes);
		panelGrid.add(tfFicheroClientes);
		panelNorte.add(panelGrid);
		panelNorte.add(bCrearBibliotecaDatos);

		panelPrincipal.add(panelNorte);
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
	public void control() {
		bCrearBibliotecaDatos.addActionListener(this);
		bCrearBibliotecaSinDatos.addActionListener(this);
	}

	/**
	 * Método de la interfaz ActionListener
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==bCrearBibliotecaDatos) {
			if (tfFicheroClientes.getText().equals("clientes.txt") && tfFicheroLibros.getText().equals("libros.txt")) {
				miBiblio = new Biblioteca(tfFicheroClientes.getText(), tfFicheroLibros.getText());
				JOptionPane.showMessageDialog(this, "La Biblioteca ha sido creado con datos de fichero");
				this.setVisible(false);
			}
			else {
				JOptionPane.showMessageDialog(this, "Problema al crear la Biblioteca, \nverifique nombre de ficheros","Error",0);
			}
		}
		else if (e.getSource()==bCrearBibliotecaSinDatos) {
			// miBiblio = new Biblioteca(null, null);
			JOptionPane.showMessageDialog(this, "Se ha creado una nueva Biblioteca vacía");
			this.setVisible(false);
		}
	}

}
