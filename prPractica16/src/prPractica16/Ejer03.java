package prPractica16;

import java.awt.*;
import javax.swing.*;

public class Ejer03 extends JFrame {

	private static final long serialVersionUID = 260667445686422155L;

	public Ejer03() {

		super("Mi calculadora");

		Container contenPane = this.getContentPane();
		contenPane.setLayout(new BorderLayout(15,15));

		//En el norte, un panel con la etiqueta Resultado y con un JTextField.
		JPanel panelNorte = new JPanel();

		JLabel lResultado = new JLabel("Resultado");

		JTextField tfResultado = new JTextField(15);

		panelNorte.add(lResultado);
		panelNorte.add(tfResultado);

		//En el centro un panel con todos los botones, podéis poner los botones en un array, pero si no queréis
		//complicaros de momento, añadirlos uno a uno. Más adelante lo haremos con arrays.
		JPanel panelCentro = new JPanel(new GridLayout(4,4));

		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton bMas = new JButton("+");

		JButton b4 = new JButton("4");
		JButton b5 = new JButton("5");
		JButton b6 = new JButton("6");
		JButton bMenos = new JButton("-");

		JButton b7 = new JButton("7");
		JButton b8 = new JButton("8");
		JButton b9 = new JButton("9");
		JButton bMultiplicar = new JButton("*");

		JButton b0 = new JButton("0");
		JButton bPunto = new JButton(".");
		JButton bIgual = new JButton("=");
		JButton bDividir = new JButton("/");

		panelCentro.add(b1);
		panelCentro.add(b2);
		panelCentro.add(b3);
		panelCentro.add(bMas);
		panelCentro.add(b4);
		panelCentro.add(b5);
		panelCentro.add(b6);
		panelCentro.add(bMenos);
		panelCentro.add(b7);
		panelCentro.add(b8);
		panelCentro.add(b9);
		panelCentro.add(bMultiplicar);
		panelCentro.add(b0);
		panelCentro.add(bPunto);
		panelCentro.add(bIgual);
		panelCentro.add(bDividir);

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

		// Panel Oeste y Este
		/**
		 * Y al este y oeste, aunque esto es un arreglo un poco “chapuzas”, dos etiquetas con espacios en
		 * blanco. Más adelante, os explicaré como poner bordes, y uno de los bordes es un borde vacío, por
		 * tanto podemos conseguir ese espaciado.
		 */
		contenPane.add(new JLabel("           "),BorderLayout.EAST);
		contenPane.add(new JLabel("           "),BorderLayout.WEST);

		// Añadir paneles al panel contenedor
		contenPane.add(panelNorte,BorderLayout.NORTH);
		contenPane.add(panelSur,BorderLayout.SOUTH);
		contenPane.add(panelCentro,BorderLayout.CENTER);
	}

	public static void main(String[] args) {

		Ejer03 ventana = new Ejer03();

		ventana.setResizable(false);

		ventana.pack();

		ventana.setVisible(true);

		/**
		 * Si queréis que la ventana os salga centrada podéis utilizar este método sobre el objeto JFrame
		 */
		ventana.setLocationRelativeTo(null);

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
