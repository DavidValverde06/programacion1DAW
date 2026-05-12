package test;

import javax.swing.*;

import controlador.Controlador;
import vista.Vista;
public class TestMVC {

	public static void main(String[] args) {
		
		Vista miVista = new Vista();	
		Controlador ctr = new Controlador(miVista);
		miVista.control(ctr);
	
		JFrame ventana = new JFrame("Mantenimiento tabla discos");
		ventana.setContentPane(miVista);
		
		// Añadir la barra de MENUS al frame
		ventana.setJMenuBar(miVista.getBarraMenu());
	
		// Añadir el control de cierre de ventana
		ventana.addWindowListener(ctr);
		
		ventana.pack();
		ventana.setVisible(true);
	}

}








