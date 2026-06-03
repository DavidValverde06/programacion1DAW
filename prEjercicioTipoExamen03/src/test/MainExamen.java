package test;

import javax.swing.*;
import controlador.*;
import vista.*;

public class MainExamen {
	public static void main(String[] args) {
		Vista miVista = new Vista();
		Controlador ctr = new Controlador(miVista);
		miVista.control(ctr);

		JFrame ventana = new JFrame("Gestión de alojamientos");
		ventana.setContentPane(miVista);
		ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // <-- importante
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);

		// Listener de cierre
		ventana.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				ctr.cerrarAplicacion(ventana);
			}
		});
	}
}
