package controlador;

import java.awt.event.*;
import javax.swing.*;
import modelo.*;
import vista.*;

public class Controlador implements ActionListener {

	/**
	 * Variables de instancia
	 */
	private Vista miVista;
	private DialogoInicial miDialogo;
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
	 * Método de la interfaz ActionListener
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
