package ejercicioo13;

import javax.swing.*;

public class MainEjercicioo13 {

	public static void main(String[] args) {

		// Crear un objeto de la clase Vista
		Vista miVista = new Vista();

//		// Crear un objeto de la Clase Controlador
//		Controlador ctr = new Controlador(miVista);
//
//		// Llamar al método que da control a los componentes
//		miVista.control(ctr);

		// Crearemos un JFrame
		JFrame ventana = new JFrame("Navegación por el sistema de ficheros");

		ventana.setContentPane(miVista);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.pack();
		// ventana.setSize(250,230);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}

}
