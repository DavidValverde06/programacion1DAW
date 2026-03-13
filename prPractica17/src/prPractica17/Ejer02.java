package prPractica17;

import java.awt.*;
import javax.swing.*;

/**
 * 2.- A continuación vamos a diseñar una ventana con un diálogo asociado, ver apartado 5.4.3 del tema 9.
 * Por tanto, en realidad lo que tenemos son dos ventanas la principal, que contiene los botones 1 y 2, y un
 * JDialog, asociado a esta ventana principal. Son dos ventanas independientes. 
 */
public class Ejer02 extends JFrame {

	private static final long serialVersionUID = -3909961153013236127L;

	public Ejer02() {

		super("Título del JFrame");

		Container cp = this.getContentPane();

		JPanel panelPrincipal = new JPanel();

		JButton b1 = new JButton("Botón 1");
		JButton b2 = new JButton("Botón 2");

		panelPrincipal.add(b1);
		panelPrincipal.add(b2);

		cp.add(panelPrincipal);

		/**
		 * Os voy a pasar el código del diálogo para que veáis como se diseña, al crear el JDialog, en el primer
		 * parámetro le estamos especificando de qué ventana depende, y en el último si lo queremos modal o no,
		 * probar a ponerlo a true y a false. Como estáis viendo lleva su propio gestos de esquemas, sus
		 * componentes, ... como una ventana normal, lo único es que depende de otra.
		 */

		// ------------------------------------------------
		// Crear un diálogo asociado a esta ventana (Frame)
		// ------------------------------------------------
		JDialog d = new JDialog(this,"Título de diálogo",false);
		//		JDialog d = new JDialog(this,"Título de diálogo",true);
										// this es el JFrame, he heredado de JFrame

		d.setLayout(new FlowLayout());

		d.add(new JLabel("Esto es una ventana de diálogo"));
		d.add(new JButton("OK"));
		d.pack();
		d.setSize(200, 90);
		d.setResizable(false);
		d.setVisible(true);
		d.setLocationRelativeTo(this);
		//d.setLocation(200,200);

		// Controlar el cierre del diálogo, OJO, se oculta, no se sale de la aplicación
		d.setDefaultCloseOperation(HIDE_ON_CLOSE);

	}

	public static void main(String[] args) {
		Ejer02 ventana = new Ejer02();

		// ventana.setResizable(false);

		ventana.pack();

		ventana.setVisible(true);

		ventana.setSize(400,200);

		ventana.setLocationRelativeTo(null);

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
