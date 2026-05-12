package prPractica19;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * 1.- Diseña la interfaz gráfica que se muestra a continuación, y en la que vamos a probar eventos de ratón
 * (MouseEvent) de la interfaz MouseListener. El diseño del GUI, como estáis viendo es bien simple,
 * tenemos un botón, y una etiqueta debajo cuyo texto se encuentra centrado.
 */
public class Ejer01 extends JFrame implements MouseListener{

	private static final long serialVersionUID = 8034555756383155569L;

	// Variables de instancia
	private JButton boton;
	private JLabel etiqueta;

	// Constructor
	public Ejer01() {

		super("Prueba eventos de raton");

		Container cp = this.getContentPane();

		JPanel panelPrincipal = new JPanel(new BorderLayout());
		JPanel panelCentral = new JPanel();

		boton = new JButton("Bienvenido");
		boton.setPreferredSize(new Dimension(100, 100));
		panelCentral.add(boton);

		boton.setBorder(new CompoundBorder(null, new BevelBorder(BevelBorder.RAISED)));
		panelCentral.setBorder(new EmptyBorder(10,10,10,10));

		etiqueta = new JLabel("Presiona el botón",JLabel.CENTER);

		/**
		 *  En primer lugar, lo que vamos a programar, en este ejemplo, es el botón, por tanto a nuestro botón
		 *  será al que le añadiremos el addMouseListener.
		 */
		boton.addMouseListener(this);

		panelPrincipal.add(panelCentral,BorderLayout.CENTER);
		panelPrincipal.add(etiqueta,BorderLayout.SOUTH);

		cp.add(panelPrincipal);
	}

	public static void main(String[] args) {

		Ejer01 ventana = new Ejer01();

		// ventana.setResizable(false);

		ventana.pack();

		ventana.setVisible(true);

		ventana.setSize(400,200);

		ventana.setLocationRelativeTo(null);

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * En la etiqueta iremos mostrando una pequeña descripción de lo que ha ocurrido, es decir, del evento
	 * que se ha generado, por ejemplo, “Entró en el botón con el ratón”, “Botón pulsado en la posición
	 * X,Y”, “Botón pulsado y soltado (clicked), ... También os recomiendo que el mismo texto que hayáis
	 * puesto en la etiqueta, también lo escribáis en la consola, ya que habrá eventos que se solapen
	 * (pulsar, soltar y pulsar y soltar), y no os va a dar tiempo a ver lo que pongáis en la etiqueta
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		etiqueta.setText("Botón pulsado y soltado (clicked)");
	}

	/**
	 * Inicialmente el color del botón será el color por defecto de los botones, pero cuando el puntero del
	 * ratón se coloque sobre el botón, cambiaremos el color del mismo, por ejemplo a verde claro, y
	 * cuando salga del botón, el color de fondo del mismo lo volveremos a cambiar, por ejemplo a verde
	 * oscuro.
	 * 
	 * Para sacar las coordenadas en las que se encuentra el puntero del ratón tenéis los métodos getX() y
	 * getY(), sobre el evento generado (MouseEvent).
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		etiqueta.setText("Botón presionado en la posición " + e.getX() + "," + e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		etiqueta.setText("Botón soltado en la posición " + e.getX() + "," + e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		boton.setBackground(Color.GREEN);
		etiqueta.setText("Entro en el botón con el ratón");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		boton.setBackground(Color.YELLOW);
		etiqueta.setText("Salgo del botón con el ratón");
	}

}
