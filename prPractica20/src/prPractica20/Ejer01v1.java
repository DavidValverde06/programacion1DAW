package prPractica20;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

/**
 * A) Como primer ejemplo diseñaremos un interfaz que contenga dos botones y una etiqueta, el control
 * 		de teclado se añadirá sólo a uno de esos dos botones, así cuando el botón que tiene el control de
 * 		teclado tenga el foco (es decir, el que esté activo) imprime todos los caracteres que vayamos
 * 		tecleando sobre la etiqueta hasta que pulsamos el asterisco, momento en el que abandonamos la
 * 		aplicación (System.exit(0)), pero si el botón que tiene el foco no tiene el control del foco, nuestro
 * 		programa no hará nada.
 */
public class Ejer01v1 extends JFrame implements KeyListener {

	private static final long serialVersionUID = 6798046005070034098L;

	// Variables de instancia
	private JButton bPrimero;
	private JButton bSegundo;
	private JLabel etiquetaCaracteres;
	private String cadena;

	// Constructor
	public Ejer01v1() {

		super("Pruebas eventos KeyEvent");

		Container cp = this.getContentPane();

		JPanel panelPrincipal = new JPanel(new BorderLayout());

		bPrimero = new JButton("Primero");
		bSegundo = new JButton("Segundo");
		etiquetaCaracteres = new JLabel(" ");
		cadena = "";

		// Añadir KeyListener al segundo botón para que solo se pueda
		// escribir en la etiqueta cuando el bSegundo tenga el foco
		bSegundo.addKeyListener(this);

		panelPrincipal.add(bPrimero,BorderLayout.NORTH);
		panelPrincipal.add(bSegundo,BorderLayout.SOUTH);

		cp.add(panelPrincipal,BorderLayout.NORTH);
		cp.add(etiquetaCaracteres,BorderLayout.SOUTH);
	}

	public static void main(String[] args) {

		Ejer01v1 ventana = new Ejer01v1();

		// ventana.setResizable(false);

		ventana.pack();

		ventana.setVisible(true);

		ventana.setSize(200,110);

		ventana.setLocationRelativeTo(null);

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		cadena += e.getKeyChar();
		etiquetaCaracteres.setText(cadena);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
