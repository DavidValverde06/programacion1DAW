package ejer02MVC;

import javax.swing.*;

public class MainTest {

	public static void main(String[] args) {

		// Crear un objeto Vista (Diseña el GUI)
		Vista miVista = new Vista();

		// Crear un objeto Controlador (programa los eventos)
		Controlador ctr = new Controlador(miVista);

		// Llamar al método que añade "control" a los componentes
		miVista.control(ctr);

		// Crear el objeto Ventana (JFrame)
		JFrame ventana = new JFrame("Ejer02 MVC");

		// Colocar sobre el panel contenedor la vista (es un JPanel)
		ventana.setContentPane(miVista);

		// Añadir el control de cierre de ventana, pack, ...
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.pack();
		ventana.setVisible(true);
		ventana.setLocationRelativeTo(null);
	}

}
