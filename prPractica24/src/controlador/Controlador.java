package controlador;

import java.awt.event.*;
import modelo.*;
import vista.*;

public class Controlador implements ActionListener {

	/**
	 * Variables de instancia
	 */
	private Vista miVista;
	private CuadradoMagico miCuadrado;

	/**
	 * Constructor
	 */
	public Controlador(Vista v) {
		this.miVista = v;
		this.miCuadrado = new CuadradoMagico();
	}

	/**
	 * Método de la interfaz ActionListener (Botones)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == miVista.getbValidar()) {

		}
		else if (e.getSource() == miVista.getbGenerar()) {

		}
		else {
			limpiar(); // Método que limpia el cuadrado mágico
		}
	}

	/**
	 * Método que limpia el cuadrado mágico
	 */
	private void limpiar() {
		for (int cont1=0;cont1<miVista.getTfCuadradoMagico().length;cont1++) {
			for (int cont2=0;cont2<miVista.getTfCuadradoMagico().length;cont2++) {

				miVista.getTfCuadradoMagico()[cont1][cont2].setText("");
			}
		}
	}
}
