package test;

import javax.swing.*;
import controlador.*;
import vista.*;

public class MainCine {

	public static void main(String[] args) {

		// Crear un objeto de la clase Vista
		Vista miVista = new Vista();

		// Crearemos un JFrame
		JFrame ventana = new JFrame("GESTIÓN CINE");

		ventana.setIconImage(new ImageIcon("./img/iconoCine.png").getImage()); // Icono ventana
		ventana.setContentPane(miVista);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.pack();
		ventana.setResizable(false);
		ventana.setSize(820,420); // Tamaño ventana
		ventana.setLocationRelativeTo(null); // Centrar ventana
		ventana.setVisible(false);

		DialogoInicial dialogo = new DialogoInicial(ventana);
		miVista.setMiDialogoInicio(dialogo);

		// Crear un objeto de la Clase Controlador
		Controlador ctr = new Controlador(miVista, ventana);

		// Llamar al método que da control a los componentes
		miVista.control(ctr);
	}

}
