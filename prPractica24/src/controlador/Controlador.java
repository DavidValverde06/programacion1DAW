package controlador;

import modelo.*;
import vista.*;

public class Controlador {

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
}
