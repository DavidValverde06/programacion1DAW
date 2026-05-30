package test;

import javax.swing.*;
import controlador.*;
import vista.*;

public class MainCine {

	public static void main(String[] args) {

		// Crear un objeto de la clase Vista
		Vista miVista = new Vista();

		// Crear un objeto de la Clase Controlador
		Controlador ctr = new Controlador(miVista);

		// Llamar al método que da control a los componentes
		miVista.control(ctr);

		// Crearemos un JFrame
		JFrame ventana = new JFrame("Cine");

		ventana.setIconImage(new ImageIcon("./img/iconoCine.png").getImage()); // Icono ventana
		ventana.setContentPane(miVista);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.pack();
		ventana.setSize(820,350); // Tamaño ventana
		ventana.setLocationRelativeTo(null); // Centrar ventana

		ventana.setVisible(false);
		// ventana.setVisible(true); // Mostrar ventana

		DialogoInicial dialogo = new DialogoInicial(ventana);
		miVista.setMiDialogoInicio(dialogo);
	}

}
