package prPractica15;

import java.awt.*;
import javax.swing.*;

public class Ejer01v1 extends JFrame {

	private static final long serialVersionUID = 8111378031366062355L;

	/**
	 * Constructor
	 */
	public Ejer01v1() {

		/**
		 * JFrame
		 */
		super("Componentes varios");

		/**
		 * Panel Contenedor
		 */
		Container contenPane = this.getContentPane();

		/**
		 * Panel Centro
		 */
		JPanel panelCentro = new JPanel(new GridLayout(1,3));

		/**
		 * Panel Izquierdo
		 */
		JPanel panelIzquierdo = new JPanel(new GridLayout(2,1));

		JButton boton1 = new JButton("Botón 1");
		JButton boton2 = new JButton("Botón 2");

		panelIzquierdo.add(boton1,BorderLayout.NORTH);
		panelIzquierdo.add(boton2,BorderLayout.SOUTH);

		panelCentro.add(panelIzquierdo,BorderLayout.WEST);

		/**
		 * Panel Medio
		 */
		JPanel panelMedio = new JPanel(new BorderLayout());

		JLabel etiqueta = new JLabel("Etiqueta");
		JTextArea areaTexto = new JTextArea("Area de texto");
		JScrollPane panelAreaTexto = new JScrollPane(areaTexto);

		panelMedio.add(etiqueta,BorderLayout.NORTH);
		panelMedio.add(panelAreaTexto,BorderLayout.CENTER);

		panelCentro.add(panelMedio,BorderLayout.CENTER);

		/**
		 * Panel Derecho
		 */
		JPanel panelDerecho = new JPanel();

		String [] arrayLista = new String[15];
		for (int i=0; i<arrayLista.length; i++) {
			arrayLista[i] = "Item número "+(i+1);
		}

		JList<String> miLista = new JList<String>(arrayLista);

		JScrollPane panelLista = new JScrollPane(miLista);

		panelDerecho.add(panelLista);

		panelCentro.add(panelDerecho,BorderLayout.EAST);

		/**
		 * Panel Sur
		 */
		JPanel panelSur = new JPanel();

		JTextField campoDeTexto = new JTextField("Campo de texto");
		JCheckBox miCheckBox = new JCheckBox("CheckBox");

		//		String [] arrayProvincias = {"Málaga", "Córdoba", "Jaén", "Cádiz",
		//				"Almería", "Sevilla", "Huelva", "Granada"};
		//		
		//		JComboBox<String> miCombo = new JComboBox<String>(arrayProvincias);

		JComboBox<String> miCombo = new JComboBox<String>();
		for (int cont=1; cont<=10; cont++) {
			miCombo.addItem("Opción: " + cont);
		}
		miCombo.setSelectedIndex(0);

		panelSur.add(campoDeTexto);
		panelSur.add(miCheckBox);
		panelSur.add(miCombo);

		/**
		 * Añadir paneles al Panel Contenedor
		 */
		contenPane.setLayout(new BorderLayout());

		contenPane.add(panelSur,BorderLayout.SOUTH);
		contenPane.add(panelCentro,BorderLayout.CENTER);
	}

	public static void main(String[] args) {

		Ejer01v1 ventana = new Ejer01v1();

		//		ventana.setResizable(false);

		ventana.pack();

		ventana.setVisible(true);

		ventana.setLocationRelativeTo(null);

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
