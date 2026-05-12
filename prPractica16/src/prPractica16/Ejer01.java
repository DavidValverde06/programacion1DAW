package prPractica16;

import java.awt.*;
import javax.swing.*;

public class Ejer01 extends JFrame {

	private static final long serialVersionUID = 6137086986741242863L;

	/**
	 * En este GUI, tendremos un panel con ocho botones colocados en el mismo, este panel estará
	 * contenido en un JScollPane de tamaño (130,110), para el tamaño utilizar el método setPreferredSize,
	 * (setSize, no os va a funcionar en este caso). Y por último el JScrollPane lo colocaremos sobre el panel
	 * contenedor del JFrame, y cuyo gestor de esquemas debe ser FlowLayout. 
	 * 
	 * Una vez que te funcione, anula con comentarios la línea en la que estableces como gestor de
	 * esquemas FlowLayout al contenedor principal, aumenta a continuación el tamaño de tu ventana y
	 * observa como ignora el tamaño del JScrollPane, y todos los botones se van agrandando. El motivo de
	 * esto es que cuando no se especifica gestor de esquemas de un JFrame, por defecto coge
	 * BorderLayout, y si además tampoco especificamos en que zona lo añadimos, lo añade a la zona
	 * central (Center), que ya habéis comprobado en otros ejemplos que es la que se queda con todo el
	 * tamaño al maximizar.
	 */
	public Ejer01() {

		super("Practica 6");

		Container contenPane = this.getContentPane();

		JPanel panelBotones = new JPanel(new GridLayout(4,2));

		// Creación de los botones
		JButton b1 = new JButton("Primero");
		JButton b2 = new JButton("Segundo");
		JButton b3 = new JButton("Tercero");
		JButton b4 = new JButton("Cuarto");
		JButton b5 = new JButton("Quinto");
		JButton b6 = new JButton("Sexto");
		JButton b7 = new JButton("Septimo");
		JButton b8 = new JButton("Octavo");

		/**
		 * Para poder establecerle un Tool Tip a cualquier componente se utiliza el método
		 * setToolTip(“mensaje”), sobre el componente al que se lo queramos asociar.
		 */

		// ToolTips para que al dejar el cursor encima de un botón aparezca un mensaje
		b1.setToolTipText("Botón Primero");
		b2.setToolTipText("Botón Segundo");
		b3.setToolTipText("Botón Tercero");
		b4.setToolTipText("Botón Cuarto");
		b5.setToolTipText("Botón Quinto");
		b6.setToolTipText("Botón Sexto");
		b7.setToolTipText("Botón Septimo");
		b8.setToolTipText("Botón Octavo");

		/**
		 * Si queréis empezar a jugar con colores, aunque no creo que os quede “demasiado bonito”, pero si os
		 * animo a que lo probéis, tenemos dos métodos setForeground, para establecer el color de la fuente, y
		 * setBackground para el color de fondo. Para los colores podéis elegir alguno de los colores básicos
		 * que ya tenéis en la clase color (Color.red, Color.YELLOW, ...), o bien crearnos nuevos colores,
		 * consultar la ayuda de la clase Color.
		 */

		// Utilizar algunos de los colores predefinidos en la clase Color
		b3.setBackground(Color.blue);
		b3.setForeground(Color.white);
		// Crear un color, especificando en rgb
		Color violeta = new Color(134,27,131);
		b1.setBackground(violeta);
		b1.setForeground(new Color(214,185,210));
		// Especificarle el color en Hexadecimal
		b2.setBackground(Color.decode("#DBC380"));

		panelBotones.add(b1);
		panelBotones.add(b2);
		panelBotones.add(b3);
		panelBotones.add(b4);
		panelBotones.add(b5);
		panelBotones.add(b6);
		panelBotones.add(b7);
		panelBotones.add(b8);

		JScrollPane panelScroll = new JScrollPane(panelBotones);

		panelScroll.setPreferredSize(new Dimension(130,110));

		contenPane.setLayout(new FlowLayout());

		contenPane.add(panelScroll);
	}

	public static void main(String[] args) {

		Ejer01 ventana = new Ejer01();

		//		ventana.setResizable(false);

		ventana.pack();

		ventana.setVisible(true);

		/**
		 * Si queréis que la ventana os salga centrada podéis utilizar este método sobre el objeto JFrame
		 */
		ventana.setLocationRelativeTo(null);

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
