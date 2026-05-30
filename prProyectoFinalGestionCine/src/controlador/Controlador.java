package controlador;

import java.awt.event.*;
import modelo.*;
import vista.*;

public class Controlador implements ActionListener {

	/**
	 * Variables de instancia
	 */
	private Vista miVista;
	private DAOPelicula miDaoPeli;
	private DAOSesion miDaoSesion;

	/**
	 * Constructor
	 */
	public Controlador(Vista miVista) {
		this.miVista = miVista;
		this.miDaoPeli = miDaoPeli;
		this.miDaoSesion = miDaoSesion;
	}

	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
