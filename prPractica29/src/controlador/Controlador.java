package controlador;

import java.awt.event.*;
import vista.Vista;

/**
 * C) Una vez que tenemos el modelo (clases anteriores) definido y probado (probar en consola el
 * funcionamiento correcto del mismo), vamos a diseñar un interfaz gráfico de usuario siguiendo el
 * Modelo Vista Controlador, cuyo aspecto inicial será como el que se muestra en la imagen 1 de la
 * siguiente página, y cuyo funcionamiento será el siguiente:
 * 
 * a. Si pulsamos sobre el radio de Tipo de cita y seleccionamos Urgente, se habilitará el ComboBox de
 * Prioridades, en caso de cita Normal, dicho combo estará deshabilitado.
 * 
 * b. Si se pulsa el botón “Añadir cita”, se recogerán los datos del
 * paciente y se añadirá a nuestra agenda. Tras lo cual nos
 * mostrará un pequeño mensaje como el que se muestra en la
 * imagen.
 * 
 * c. Si se pulsa el botón “Cancelar”, se limpiará todo el formulario
 * y se dejará como al principio.
 * 
 * d. Si se pulsa el botón “Ver lista citas”, nos mostrará todos las citas de nuestra agenda en un
 * formato similar al que se muestra en la imagen 2 que tenéis un poco más abajo. Se facilita el
 * método que proporciona el JTable con todos los datos de las citas recogidas en vuestra colección
 * (puede que tengáis que ajustar los nombres de algún método a los de vuestro modelo).
 * Imagen 1: Aspecto inicial del GUI
 * Imagen 2: Formato del listado de citas
 * 
 * e. Por último al pulsar el botón de cierre de nuestra
 * aplicación, debemos preguntar si desea volcar los datos
 * que actualmente se encuentran en la colección a un
 * fichero. En caso afirmativo los iremos añadiendo al
 * fichero Citas.txt, primero se añadirá la fecha actual y a
 * continuación las citas (podéis usar el formato de toString
 * para guardar las citas, cada cita en una fila nueva).
 */
public class Controlador implements ActionListener, ItemListener{

	/**
	 * Variables de instancia
	 */
	private Vista miVista;

	/**
	 * Constructor
	 */
	public Controlador(Vista miVista) {
		this.miVista = miVista;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		/**
		 * c. Si se pulsa el botón “Cancelar”, se limpiará todo el formulario
		 * y se dejará como al principio.
		 */
		if (e.getSource()==miVista.getbCancelar()) {
			System.out.println("Cancelar");
		}
	}

}
