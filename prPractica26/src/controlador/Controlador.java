package controlador;

import java.awt.event.*;
import modelo.BilleteTren;
import vista.Vista;

/**
 * Su funcionamiento (controlador) será el siguiente:
 * 
 * - Al elegir el tipo de descuento, debe aparecer el porcentaje que se aplicará de descuento en el precio
 * final del billete, en la etiqueta preparada para tal fin, así como recalcular el precio del billete.
 * 
 * - Si se marca el check “Billete familiar”, el descuento se incrementará en un 25%.
 * 
 * - Al pulsar el botón Calcular se calculará la distancia a recorrer, así como el precio final del billete y se
 * mostrarán ambos datos en sus etiquetas correspondientes.
 * 
 * - Al pulsar sobre el botón Cancelar se inicializará todo el formulario.
 * 
 * - Al pulsar el botón Vender billete, se escribirá en un fichero de texto la información del billete vendido, si
 * es un billete familiar, previamente habrá que pedir el nombre de la persona a la que se vende el billete.
 * A modo de ejemplo nuestro fichero podría ir teniendo el siguiente aspecto:
 */
public class Controlador implements ActionListener{

	/**
	 * Variables de instancia
	 */
	private Vista miVista;
	private BilleteTren miBilleteTren;

	/**
	 * Constructor
	 */
	public Controlador(Vista v) {
		this.miVista = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
