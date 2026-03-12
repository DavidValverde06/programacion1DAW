package prPractica17;

import javax.swing.*;

/**
 * 4.- En el ejercicio 2 de esta práctica, hemos aprendido a diseñar JDialog, que son esas ventanitas
 * emergentes, que nos suelen dar algún aviso, pedirnos algún dato, ... Este tipo de diálogos tendremos
 * que crearlos cuando necesitemos lanzar un diálogo al usuario, que no se adapte a los que ya nos ofrece
 * el componente JOptionPane, que nos permite lanzar diálogos de un forma mucho más sencilla que con
 * JDialog. Consultar el apartado 5.11 del tema, y la ayuda de Java para aclararos con este componente.
 * 
 * A continuación os paso un ejemplo, con pruebas varias de creación de JOptionPane, veréis que se os van
 * a ir sucediendo una serie de ventanas de diálogo una detrás de la otra. Anular con comentarios aquellas
 * que no queráis que os aparezca. Observar el código y probar a cambiar cosas sobre el ejemplo. Es una
 * forma muy fácil como estáis comprobando de lanzar diálogos al usuario.
 * 
 * El primer parámetro que estáis viendo a null en todos los ejemplos se refiere a la ventana de la que
 * dependería del diálogo (JFrame), como en este ejemplo no hay ninguna por eso está a null. Más
 * adelante si pondremos nuestro objeto JFrame.
 */
public class Ejer04 {

	public static void main(String[] args) {

		// ------------------------------------------------------------
		// Pruebas del método showMessageDialog (muestra un mensaje al usuario)
		// ------------------------------------------------------------
		JOptionPane.showMessageDialog(null, "Hola que tal");

		JOptionPane.showMessageDialog(null, "Hola",
				"Título mensaje", JOptionPane.ERROR_MESSAGE);

		JOptionPane.showMessageDialog(null,
				"Hola, que tal estáis",
				"Título mensaje",
				JOptionPane.PLAIN_MESSAGE,
				new ImageIcon("C:/Users/david/Downloads/81MJUW7iUaL.jpg"));

		// ------------------------------------------------------------
		// Pruebas del método showConfirmDialog
		// ------------------------------------------------------------
		JOptionPane.showConfirmDialog(null, "¿Estamos en primavera?");
		int resp = JOptionPane.showConfirmDialog(null,
				"¿Estamos en primavera?",
				"Titulo de la ventana",
				JOptionPane.YES_NO_OPTION);
		System.out.println(resp);
		if (resp == JOptionPane.YES_OPTION)
			JOptionPane.showMessageDialog(null,"Que bien, ya llegó la alergia");
		else
			JOptionPane.showMessageDialog(null,"Ohhhhhhhh");

		// ------------------------------------------------------------
		// Pruebas del método showOptionDialog
		// ------------------------------------------------------------
		Object [] opciones = {"OK", "Bien", "HOLA"};
		JOptionPane.showOptionDialog(null,
				"Selecciona una respuesta",
				"Titulo de la ventana",
				JOptionPane.OK_OPTION,
				JOptionPane.INFORMATION_MESSAGE,
				null,
				opciones,
				opciones[2]);

		// ------------------------------------------------------------
		// Pruebas del método showInputDialog
		// ------------------------------------------------------------
		String nombre = JOptionPane.showInputDialog("¿Cómo te llamas?");
		JOptionPane.showMessageDialog(null,
				"Hola, " + nombre.toUpperCase(),
				"Bienvenido",
				JOptionPane.PLAIN_MESSAGE,
				new ImageIcon("Duke.png"));

		Object [] diasSemana = {"Lunes","Martes","Miércoles","Jueves","Viernes"};

		Object respDia = JOptionPane.showInputDialog(null,
				"Elije tu día favorito: ",
				"Titulo de la ventana",
				JOptionPane.QUESTION_MESSAGE,
				null,
				diasSemana,
				diasSemana[3]);
		System.out.println(respDia);
	}

}
