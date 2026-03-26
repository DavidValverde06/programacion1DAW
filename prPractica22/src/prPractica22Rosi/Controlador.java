package prPractica22Rosi;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Controlador implements ActionListener, KeyListener, FocusListener {

	/**
	 * Variables de instancia
	 */
	private Vista miVista; // Vista
	private ProcesaDatos pd; // Módelo

	/**
	 * Constructor
	 */
	public Controlador(Vista v) {
		this.miVista = v;
		this.pd = new ProcesaDatos(miVista.getTfRdo());
	}

	/**
	 * Métodos de FocusListener (Ganar o perder foco de un botón)
	 */
	@Override
	public void focusGained(FocusEvent e) {
		e.getComponent().setBackground(Color.LIGHT_GRAY);
	}

	@Override
	public void focusLost(FocusEvent e) {
		JButton botonPulsado = (JButton)e.getSource();
		if (botonPulsado.getText().equals(" + ") || botonPulsado.getText().equals(" - ") || 
				botonPulsado.getText().equals(" * ") || botonPulsado.getText().equals(" / ") ||
				botonPulsado.getText().equals(".") || botonPulsado.getText().equals("=")) {
			e.getComponent().setBackground(UIManager.getColor("Button.setBackground"));
		}
		else {
			e.getComponent().setBackground(Color.GREEN);
		}
	}

	/**
	 * Métodos de KeyListener (Pulsar un botón tecleando su valor en el teclado)
	 */
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	/**
	 * Métodod de la interfaz actionListener (Pulsar un botón con el ratón)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {}

}
