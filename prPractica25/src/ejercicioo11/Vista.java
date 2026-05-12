package ejercicioo11;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Vista extends JPanel {

	private static final long serialVersionUID = 1055131542563757194L;

	/**
	 * Variables de instancia
	 */
	private JButton botonTraducir,botonAnadirPalabra,botonCambiarIdioma,botonVerFichero,botonLimpiar;
	private JTextField tfPalabraParaTraducir, tfPalabraTraducida;
	private JLabel lEtiquetaInfo;
	private JPanel panelEspanol,panelIngles;

	/**
	 * Métodos Getter
	 */
	public JButton getBotonTraducir() {return botonTraducir;}
	public JButton getBotonAnadirPalabra() {return botonAnadirPalabra;}
	public JButton getBotonCambiarIdioma() {return botonCambiarIdioma;}
	public JButton getBotonVerFichero() {return botonVerFichero;}
	public JButton getBotonLimpiar() {return botonLimpiar;}
	public JTextField getTfPalabraParaTraducir() {return tfPalabraParaTraducir;}
	public JTextField getTfPalabraTraducida() {return tfPalabraTraducida;}
	public JLabel getlEtiquetaInfo() {return lEtiquetaInfo;}
	public JPanel getPanelEspanol() {return panelEspanol;}
	public JPanel getPanelIngles() {return panelIngles;}

	/**
	 * Constructor
	 */
	public Vista() {

		this.setBorder(new EmptyBorder(10, 10, 10, 10));

		JPanel panelPrincipal = new JPanel(new BorderLayout(10,10));

		// Panel Norte
		JPanel panelNorte = new JPanel();
		lEtiquetaInfo = new JLabel("Español 🡆 Inglés",JLabel.CENTER);
		panelNorte.add(lEtiquetaInfo);

		panelPrincipal.add(panelNorte,BorderLayout.NORTH);

		// Panel Central
		JPanel panelCentral = new JPanel();
		panelEspanol = new JPanel();
		panelIngles = new JPanel();

		tfPalabraParaTraducir = new JTextField(8);
		panelEspanol.setBorder(new CompoundBorder(
				new TitledBorder("Español"), null));

		panelEspanol.add(tfPalabraParaTraducir);

		tfPalabraTraducida = new JTextField(8);
		panelIngles.setBorder(new CompoundBorder(
				new TitledBorder("Inglés"), null));

		tfPalabraTraducida.setEditable(false);
		tfPalabraTraducida.setBackground(Color.WHITE);

		panelIngles.add(tfPalabraTraducida);

		botonCambiarIdioma = new JButton(new ImageIcon("./src/ejercicioo11/awesome-arrow.png"));

		Font fuente = new Font("Comic Sans MS", Font.PLAIN, 20);

		tfPalabraParaTraducir.setFont(fuente);
		tfPalabraTraducida.setFont(fuente);

		panelCentral.add(panelEspanol);
		panelCentral.add(botonCambiarIdioma);
		panelCentral.add(panelIngles);

		panelPrincipal.add(panelCentral,BorderLayout.CENTER);

		// Panel Sur
		JPanel panelSur = new JPanel(new GridLayout(1,2,5,5));
		botonTraducir = new JButton("Traducir");
		botonAnadirPalabra = new JButton("Añadir palabra");
		botonVerFichero = new JButton("Listado");
		botonLimpiar = new JButton("Limpiar");

		panelSur.add(botonTraducir);
		panelSur.add(botonAnadirPalabra);
		panelSur.add(botonVerFichero);
		panelSur.add(botonLimpiar);

		panelPrincipal.add(panelSur,BorderLayout.SOUTH);

		this.add(panelPrincipal);
	}

	/**
	 * Método se encarga de añadir el control de los 
	 * eventos a los componentes
	 */
	public void control(Controlador ctr) {

		// JButton
		this.botonTraducir.addActionListener(ctr);
		this.botonAnadirPalabra.addActionListener(ctr);
		this.botonCambiarIdioma.addActionListener(ctr);
		this.botonVerFichero.addActionListener(ctr);
		this.botonLimpiar.addActionListener(ctr);

	}

}
