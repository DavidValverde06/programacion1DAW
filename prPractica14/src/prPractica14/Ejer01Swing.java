package prPractica14;

import java.awt.*;
import javax.swing.*;

/**
 * Ejercicio 1 con AWT
 */
public class Ejer01Swing {

	public static void main(String[] args) {

		/**
		 * Crear contenedor
		 */
		JFrame f = new JFrame("Mi primer GUI");

		/**
		 * Crear panel contenedor
		 */
		Container contenPane = f.getContentPane();

		/**
		 * Seleccionar un gestor de esquemas para la inserción de los componentes
		 */
		contenPane.setLayout(new FlowLayout());

		/**
		 * Crear los componentes adecuados
		 */
		JButton bSi = new JButton("Si");
		JButton bNo = new JButton("No");
		JLabel lNombre = new JLabel("Nombre");

		/**
		 * Agregarlos al contenedor
		 */
		contenPane.add(lNombre);
		contenPane.add(bSi);
		contenPane.add(bNo);

		/**
		 * Pedir ajuste de los componentes al contenedor
		 */
		f.pack();

		/**
		 * Dimensionar el contenedor(opcional)
		 */
		f.setSize(400,200);

		/**
		 * Mostrar el contenedor
		 */
		f.setVisible(true);

		/**
		 * Programar el evento de cierre de ventana
		 */
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setLocationRelativeTo(null);
	}

}
