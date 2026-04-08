package controlador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import modelo.*;
import vista.*;

public class Controlador implements ItemListener {

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
	@Override
	public void itemStateChanged(ItemEvent e) {

		if (e.getSource() == miVista.getMiComboTipoPropiedad()) {
			
			
		}
	}


}
