package test;

import javax.swing.JFrame;
import controlador.Controlador;
import vista.Vista;

public class MainAgendaMedica {

	public static void main(String[] args) {
		// Crear un objeto de la clase Vista
		Vista miVista = new Vista();

		// Crearemos un JFrame
		JFrame ventana = new JFrame("Consulta médica");

		// Crear un objeto de la Clase Controlador
		Controlador ctr = new Controlador(miVista, ventana);

		// Llamar al método que da control a los componentes
		miVista.control(ctr);

		ventana.setContentPane(miVista);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.pack();
		// ventana.setSize(250,230);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}

}
