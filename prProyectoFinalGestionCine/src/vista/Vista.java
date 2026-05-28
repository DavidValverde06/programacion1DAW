package vista;

import java.awt.event.*;
import javax.swing.*;

public class Vista extends JPanel implements ActionListener {

	private static final long serialVersionUID = -5752211613049689258L;

	/**
	 * Variables de instancia
	 */
	private DialogoInicial miDialogoInicio;
	private JButton bCerrarSesion;

	/**
	 * Constructor
	 */
	public Vista() {
		miDialogoInicio = new DialogoInicial();

		bCerrarSesion = new JButton("Cerrar sesión");

		this.add(bCerrarSesion);
		control();
	}

	/**
	 * Método para dar control a los componentes de la interfaz
	 */
	public void control() {
		bCerrarSesion.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==bCerrarSesion) {

		}
	}

}
