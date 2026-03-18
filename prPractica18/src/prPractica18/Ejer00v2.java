package prPractica18;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ejer00v2 extends JFrame {

	private static final long serialVersionUID = -1291251851058333018L;

	// Variable de instancia
	private JLabel etiqueta;
	private JButton bSi, bNo;

	// Constructor
	public Ejer00v2() {

		// Poner título a la ventana
		super("Con actionListener");

		// Creo un objeto de tipo container con el método getContentPane()
		Container contentPane = this.getContentPane();

		// Establecer el gestor de esquemas
		contentPane.setLayout(new FlowLayout());

		// Crear los componentes
		bSi = new JButton("Si");
		bNo = new JButton("No");
		etiqueta = new JLabel("Pulsaciones");

		// Añadir los componentes al JFrame
		contentPane.add(etiqueta);
		contentPane.add(bSi);
		contentPane.add(bNo);

		// Añadir control a los botones (enlazar el componente event con
		// la interfaz que lo que programa)
		ControlBoton cb = new ControlBoton();

		bSi.addActionListener(cb);
		bNo.addActionListener(cb);

	}

	public static void main(String[] args) {

		Ejer00v2 ventana = new Ejer00v2();

		// ventana.setResizable(false);

		ventana.pack();

		ventana.setSize(300,100);

		ventana.setVisible(true);

		ventana.setLocationRelativeTo(null);

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Clase interna para programar los eventos de pulsar el botón
	 */
	class ControlBoton implements ActionListener {

		/**
		 * Método de la interfaz ActionListener
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==bSi)
				etiqueta.setText("Si pulsado");
			else
				etiqueta.setText("No pulsado");
		}
	}

}
