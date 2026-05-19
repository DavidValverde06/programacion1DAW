package controlador;

import java.awt.event.*;

import javax.swing.JOptionPane;

import modelo.*;
import vista.*;

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
public class Controlador implements ActionListener, ItemListener{

	seguir

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

		if (e.getSource()==miVista.getbCalcular()) {

			Punto origen = new Punto(Float.valueOf(miVista.getTfCoordenadaOrigenX().getText()),
					Float.valueOf(miVista.getTfCoordenadaOrigenY().getText()));

			Punto destino = new Punto(Float.valueOf(miVista.getTfCoordenadaDestinoX().getText()),
					Float.valueOf(miVista.getTfCoordenadaDestinoY().getText()));			

			if (miVista.getChBilleteFamiliar().isSelected()) {

				String nombreFamiliar = JOptionPane.showInputDialog(miVista, "Escribe el nombre del familiar");

				BilleteTrenFamiliar billeteFamiliar = new BilleteTrenFamiliar(origen, destino,
						(EnumDescuentos)miVista.getComboDescuentos().getSelectedItem(), nombreFamiliar);

			}
			else {

				BilleteTren billeteNormal = new BilleteTren(origen, destino,
						(EnumDescuentos)miVista.getComboDescuentos().getSelectedItem());
			}
		}
		else if (e.getSource()==miVista.getbCancelar()) {
			cancelar();
		}
		else if (e.getSource()==miVista.getbVender()) {

		}
	}

	private void cancelar() {
		miVista.getTfCoordenadaOrigenX().setText("0");
		miVista.getTfCoordenadaOrigenY().setText("0");
		miVista.getTfCoordenadaDestinoX().setText("0");
		miVista.getTfCoordenadaDestinoY().setText("0");
		miVista.getComboDescuentos().setSelectedIndex(0);
		miVista.getChBilleteFamiliar().setSelected(false);
		miVista.getLabelNumeroDistancia().setText("0.00");
		miVista.getLabelDescuentoBillete().setText("0");
		miVista.getLabelDescuentoBillete().setText("0");
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		if (e.getSource()==miVista.getComboDescuentos()) {
			EnumDescuentos itemSeleccionado = (EnumDescuentos)miVista.getComboDescuentos().getSelectedItem();
			miVista.getLabelDescuentoBillete().setText(String.valueOf(itemSeleccionado.getDescuento()));
		}
	}

}
