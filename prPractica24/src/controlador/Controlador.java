package controlador;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.JOptionPane;

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
			validar(); // Método que genera el cuadrado mágico
		}
		else if (e.getSource() == miVista.getbGenerar()) {
			generar(); // Método que genera el cuadrado mágico
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
				miVista.getTfCuadradoMagico()[cont1][cont2].setForeground(Color.BLACK);
			}
		}
	}

	/**
	 * Método que genera el cuadrado mágico
	 */
	public void generar() {
		int[][] cuadradoMagico = miCuadrado.generaCuadrado(miVista.getDimension());
		int numCuadrado;

		for (int cont1=0;cont1<miVista.getTfCuadradoMagico().length;cont1++) {
			for (int cont2=0;cont2<miVista.getTfCuadradoMagico().length;cont2++) {

				numCuadrado = cuadradoMagico[cont1][cont2];
				miVista.getTfCuadradoMagico()[cont1][cont2].setText(String.valueOf(numCuadrado));
				miVista.getTfCuadradoMagico()[cont1][cont2].setForeground(Color.BLACK);
			}
		}
	}

	/**
	 * Método que valida que el cuadrado mágico es correcto
	 * @throws MiExcepcion 
	 */
	private void validar() {
		int[][] cuadradoMagico = miCuadrado.generaCuadrado(miVista.getDimension());
		int numEscrito,numComprobado;
		boolean esMagico = true;
		try {

			for (int cont1=0;cont1<miVista.getTfCuadradoMagico().length;cont1++) {
				for (int cont2=0;cont2<miVista.getTfCuadradoMagico().length;cont2++) {

					numEscrito = Integer.valueOf(miVista.getTfCuadradoMagico()[cont1][cont2].getText());
					numComprobado = cuadradoMagico[cont1][cont2];

					if (numComprobado != numEscrito) {
						miVista.getTfCuadradoMagico()[cont1][cont2].setForeground(Color.RED);
						esMagico = false;
					}
				}
			}

			if (esMagico == false) {
				JOptionPane.showMessageDialog(null, "El cuadrado NO es MÁGICO");

			}
			else {
				JOptionPane.showMessageDialog(null, "El cuadrado es MÁGICO");

			}
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(miVista, "Valores erróneos");
		}
	}
}
