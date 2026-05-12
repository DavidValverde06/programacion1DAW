package prPractica19;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 2.- En este segundo ejercicio, probaremos más eventos de ratón, en este caso los de la interfaz
 * MouseMotionListener, en concreto los de mover el ratón y arrastrarlo (con el botón izquierdo del ratón
 * pulsado). Para ello vamos a diseñar una interfaz muy simple, tan solo añadiremos dos etiquetas (que
 * son los números que veis en la imagen), inicialmente estas etiquetas estarán con el valor “000”, y
 * conforme vayamos moviendo o arrastrando el ratón por el panel contenedor iremos cambiando el color
 * a rojo o azul de estas etiquetas, así como su valor, que serán las coordenadas en las que se encuentra el
 * puntero del ratón.
 * 
 * Para ello programaremos los dos métodos del interfaz MouseMotionListener, en los que iremos
 * cambiando el color del texto de las etiquetas y su contenido con la posiciones X,Y que va tomando el
 * puntero del ratón según el usuario lo va moviendo o arrastrando por el panel contenedor.
 * El componente que en realidad estamos programando es el panel contenedor, por tanto a él le
 * añadiremos el método addMouseMotionListener.
 */
public class Ejer02 extends JFrame implements MouseMotionListener {

	private static final long serialVersionUID = -6506886234074229002L;

	// Variables de instancia
	private JLabel etiqueta1;
	private JLabel etiqueta2;

	// Constructor
	public Ejer02() {

		super("Prueba eventos de movimiento ratón");

		Container cp = this.getContentPane();
		cp.addMouseMotionListener(this);

		JPanel panelPrincipal = new JPanel(new FlowLayout(FlowLayout.LEFT));

		etiqueta1 = new JLabel("000");
		etiqueta2 = new JLabel("000");

		panelPrincipal.add(etiqueta1);
		panelPrincipal.add(etiqueta2);

		cp.add(panelPrincipal,BorderLayout.NORTH);
	}

	public static void main(String[] args) {

		Ejer02 ventana = new Ejer02();

		// ventana.setResizable(false);

		ventana.pack();

		ventana.setVisible(true);

		ventana.setSize(400,150);

		ventana.setLocationRelativeTo(null);

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		etiqueta1.setText(e.getX() + "");
		etiqueta1.setForeground(Color.BLUE);

		etiqueta2.setText(e.getY() + "");
		etiqueta2.setForeground(Color.BLUE);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		etiqueta1.setText(e.getX() + "");
		etiqueta1.setForeground(Color.RED);

		etiqueta2.setText(e.getY() + "");
		etiqueta2.setForeground(Color.RED);
	}

}
