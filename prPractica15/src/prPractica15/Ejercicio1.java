package prPractica15;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.*;

public class Ejercicio1 extends JFrame {

	private static final long serialVersionUID = 8111378031366062355L;

	/**
	 * Constructor
	 */
	public Ejercicio1() {

		super("Componentes varios");

		Container contenPane = this.getContentPane();

		JPanel panelAbajo = new JPanel();

		JTextField miTextField = new JTextField(15);

		JCheckBox miCheckBox = new JCheckBox();

		JComboBox<String> miCombo = new JComboBox<>();

		panelAbajo.add(miTextField);
		panelAbajo.add(miCheckBox);
		panelAbajo.add(miCombo);
		
		contenPane.setLayout(new BorderLayout());

		contenPane.add(panelAbajo,BorderLayout.SOUTH);
		
	}

	public static void main(String[] args) {

		Ejercicio1 ventana = new Ejercicio1();

		// Bloquear el redimensionado
		ventana.setResizable(false);
		
		ventana.pack();
		ventana.setVisible(true);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
