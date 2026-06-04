package test;

import javax.swing.*;
import controlador.*;
import vista.*;

public class MainExamen {
	public static void main(String[] args) {

		Vista miVista = new Vista();

		Controlador ctr = new Controlador(miVista);
		miVista.control(ctr);

		JFrame ventana = new JFrame("Viveros Naturaleza y Bonsáis");

		ventana.setContentPane(miVista);
		ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);

		ventana.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				ctr.cerrarAplicacion(ventana);
			}
		});
	}
}
