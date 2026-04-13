package controlador;

import modelo.*;
import vista.Vista;

public class Controlador {

	/**
	 * Variables de instancia
	 */
	private Vista miVista;
	private Inmobiliaria miInmobiliaria;

	/**
	 * Constructor
	 */
	public Controlador(Vista v) {
		this.miVista = v;
		this.miInmobiliaria = new Inmobiliaria();
	}
}
