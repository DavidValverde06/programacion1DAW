package test;

import javax.swing.JFrame;

import controlador.Controlador;
import vista.DialogoInicio;
import vista.Vista;

public class MainCuadradoMagico {

	public static void main(String[] args) {

		DialogoInicio dialogo = new DialogoInicio();

		// Crear un objeto de la clase Vista
		Vista miVista = new Vista();

		// Crear un objeto de la Clase Controlador
		//Controlador ctr = new Controlador(miVista);

		// Llamar al método que da control a los componentes
		//miVista.control(ctr);

		// Crearemos un JFrame
		JFrame ventana = new JFrame("Agencia Inmobiliaria");

		ventana.setContentPane(miVista);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.pack();
		// ventana.setSize(250,230);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}

}
