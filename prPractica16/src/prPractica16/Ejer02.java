package prPractica16;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 2.- En este GUI vamos a diseñar un menú de opciones, para ello primero tenéis que leeros el apartado 5.15.
 * Menús, del Tema 9. Solo se han añadido opciones al menú “Entrada 1”, los otros dos no tienen
 * opciones.
 */
public class Ejer02 extends JFrame {

	private static final long serialVersionUID = 6955004668386504562L;

	Ejer02() {

		super("Mi menú de opciones");

		Container contenPane = new Container();
		JPanel panelPrincipal = new JPanel(new BorderLayout());

		/**
		 * Aunque el orden en el que creéis los componentes no importa, intentad como siempre ser ordenados, y
		 * poner nombre significativos. Yo suelo seguir el siguiente orden:
		 */
		// 1.- Creo la barra de menús (JMenuBar).
		JMenuBar barraMenu = new JMenuBar();

		// 2.- Creo los menús (JMenú).
		JMenu entrada1 = new JMenu("Entrada 1");
		JMenu entrada2 = new JMenu("Entrada 2");
		JMenu ayuda = new JMenu("Ayuda");

		// 3.- Creo las opciones de cada menú (JMenuItem, JCheckBoxMenuItem, un submenú (JMenu), ...)
		JMenuItem itemMenu11 = new JMenuItem("SubEntrada 1.1.");
		JMenuItem itemMenu12 = new JMenuItem("SubEntrada 1.2.");
		JMenu menu13 = new JMenu("SubEntrada 1.3.");

		JMenuItem menuItem131 = new JMenuItem("SubEntrada 1.3.1.");
		JCheckBoxMenuItem menuItem132 = new JCheckBoxMenuItem("SubEntrada 1.3.2.");

		itemMenu12.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));

		// 4.- Añado las entradas a los submenús.
		menu13.add(menuItem131);
		menu13.add(menuItem132);

		// 5.- Añado las entradas a los menús, puede que alguna de esas entradas sea a su vez un menú (así
		//		conseguimos los submenús).
		entrada1.add(itemMenu11);
		entrada1.add(itemMenu12);
		entrada1.add(menu13);

		// 6.- Añado los menús a la barra de menús.
		barraMenu.add(entrada1);
		barraMenu.add(entrada2);
		barraMenu.add(ayuda);

		// 7.- Coloco la barra de menús en el panel contenedor, recordar que es con el método setJMenuBar.

		this.setJMenuBar(barraMenu);

		contenPane.add(panelPrincipal);
	}

	public static void main(String[] args) {

		Ejer02 ventana = new Ejer02();

		ventana.setResizable(false);

		ventana.pack();

		ventana.setSize(400, 200);

		ventana.setVisible(true);

		ventana.setLocationRelativeTo(null);

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
