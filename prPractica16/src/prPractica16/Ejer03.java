package prPractica16;

import java.awt.*;
import javax.swing.*;

public class Ejer03 extends JFrame {

	private static final long serialVersionUID = 260667445686422155L;

	public Ejer03() {

		super("Mi calculadora");

		Container contenPane = this.getContentPane();

		//En el norte, un panel con la etiqueta Resultado y con un JTextField.
		JPanel panelNorte = new JPanel();

		JLabel lResultado = new JLabel("Resultado");

		JTextField tfResultado = new JTextField(15);

		panelNorte.add(lResultado);
		panelNorte.add(tfResultado);

		//En el centro un panel con todos los botones, podéis poner los botones en un array, pero si no queréis
		//complicaros de momento, añadirlos uno a uno. Más adelante lo haremos con arrays.
		JPanel panelCentro = new JPanel();
		
		JButton b1 = new JButton("1");
		JButton b1 = new JButton("1");
		JButton b1 = new JButton("1");
		
		JButton b1 = new JButton("1");
		JButton b1 = new JButton("1");
		JButton b1 = new JButton("1");
		
		JButton b1 = new JButton("1");
		JButton b1 = new JButton("1");
		JButton b1 = new JButton("1");
		
		JButton b0 = new JButton("0");
		JButton bPunto = new JButton(".");
		
		//En el sur un panel con los cuatro JRadioButton.
		JPanel panelSur = new JPanel();

		ButtonGroup grupoBotones = new ButtonGroup();

		JRadioButton rbDec = new JRadioButton("Dec");
		JRadioButton rbBin = new JRadioButton("Bin");
		JRadioButton rbHex = new JRadioButton("Hex");
		JRadioButton rbOct = new JRadioButton("Oct");

		grupoBotones.add(rbDec);
		grupoBotones.add(rbBin);
		grupoBotones.add(rbHex);
		grupoBotones.add(rbOct);
		
		panelSur.add(rbDec);
		panelSur.add(rbBin);
		panelSur.add(rbHex);
		panelSur.add(rbOct);

		// Añadir paneles al panel contenedor
		contenPane.add(panelNorte,BorderLayout.NORTH);
		contenPane.add(panelSur,BorderLayout.SOUTH);
	}

	public static void main(String[] args) {

		Ejer03 ventana = new Ejer03();

		//		ventana.setResizable(false);

		ventana.pack();

		ventana.setVisible(true);

		/**
		 * Si queréis que la ventana os salga centrada podéis utilizar este método sobre el objeto JFrame
		 */
		ventana.setLocationRelativeTo(null);

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
