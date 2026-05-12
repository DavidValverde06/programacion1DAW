package ejercicioo11;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * 11.- Realiza un programa que traduzca palabras de español a inglés y viceversa. El programa deberá tener
 * para probarlo un interfaz gráfico cuyo diseño se deja libre al alumno. Para almacenar el diccionario de
 * datos el alumno deberá utilizar ficheros. Se deja a elección del alumno el formato del fichero de datos.
 */
public class MainTraductor {

	public static void main(String[] args) {

		// Crear un objeto de la clase Vista
		Vista miVista = new Vista();

		// Crear un objeto de la Clase Controlador
		Controlador ctr = new Controlador(miVista);

		// Llamar al método que da control a los componentes
		miVista.control(ctr);

		// Crearemos un JFrame
		JFrame ventana = new JFrame("Traductor");
		ventana.setIconImage(new ImageIcon("./src/ejercicioo11/traductor_icon.png").getImage());
		ventana.setContentPane(miVista);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.pack();
		// ventana.setSize(250,230);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);

	}

}
