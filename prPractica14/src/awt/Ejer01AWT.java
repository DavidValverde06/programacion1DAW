package awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;

/**
 * Ejercicio 1 con AWT
 */
public class Ejer01AWT {

	public static void main(String[] args) {

		/**
		 * Crear contenedor
		 */
		Frame f = new Frame("Mi primer GUI");

		/**
		 * Seleccionar un gestor de esquemas para la inserción de los componentes
		 */
//		FlowLayout gestorEsquemas = new FlowLayout;
//		f.setLayout(gestorEsquemas);

		f.setLayout(new FlowLayout());
		
		/**
		 * Crear los componentes adecuados
		 */
		Button bSi = new Button("Si");
		Button bNo = new Button("No");
		Label lNombre = new Label("Nombre");
		
		/**
		 * Agregarlos al contenedor
		 */
		f.add(lNombre);
		f.add(bSi);
		f.add(bNo);
		
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
		f.addWindowListener(new ControlVentana());
	}

}
