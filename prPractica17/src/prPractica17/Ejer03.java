package prPractica17;

import javax.swing.*;

/**
 * 3.- En este GUI, diseñaremos las ventanas que nos abren los diálogos de Abrir un documento / Guardar un
 * documento con el componente JFileChooser. Podéis consultar el apartado 5.12 del tema y la ayuda de
 * Java
 */
public class Ejer03 extends JFrame {

	private static final long serialVersionUID = -3693294239360638393L;

	public Ejer03() {

		// Crear un JFrame
		super("Ventana con diálogo de Abrir/Guardar");

		// Crear un objeto de tipo JFileChooser (ventana de diálogo para
		// mostrar el explorador que permite abrir o guardar un documento)
		JFileChooser fc = new JFileChooser("D:/"); // Poner una ruta válida en vuestro equipo

		// Llamar al método que establece el JFileChooser en modo "abrir"
		//fc.showOpenDialog(this);

		// Llamar al método que establece el JFileChooser en modo "guardar"
		fc.showSaveDialog(this);

		// Poner visible el JFileChooser
		fc.setVisible(true);

		/**
		 * Fijaros que simple es sacar un diálogo de abrir/guardar, la ventana pequeñita que os aparece sin nada,
		 * es la ventana principal, que como no le hemos puesto ningún componente, pues aparece vacía.
		 * Observar la barra de títulos, según si elegís Open/Save, os cambiará el título. Más adelante
		 * aprenderemos a recoger, el nombre del archivo que hayamos puesto, su ruta, ...
		 */
	}

	public static void main(String[] args) {
		Ejer03 ventana = new Ejer03();

		// ventana.setResizable(false);

		ventana.pack();

		// Establecer tamaño y poner visible el JFrame
		ventana.setVisible(true);
		ventana.setSize(200,100);

		ventana.setLocationRelativeTo(null);

		// Programar el cierre de la ventana
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
