package controlador;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;
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
public class Controlador implements ActionListener, ItemListener {

	/**
	 * Variables de instancia
	 */
	private Vista miVista;
	private BilleteTren miBilleteTren;
	private int contadorBilletes;

	/**
	 * Constructor
	 */
	public Controlador(Vista v) {
		this.miVista = v;
	}

	/**
	 * Método de la interfaz ActionListener
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// CheckBox
		if (e.getSource()==miVista.getChBilleteFamiliar()) {
			actualizarDescuento();
			calcular();
		}

		// Botones
		if (e.getSource()==miVista.getbCalcular()) {
			calcular();
		}
		else if (e.getSource()==miVista.getbCancelar()) {
			cancelar();
		}
		else if (e.getSource()==miVista.getbVender()) {
			vender();
		}
	}

	/**
	 * Método para vender un billete al pulsar el botón Vender
	 */
	private void vender() {

		if (miBilleteTren == null) {
			JOptionPane.showMessageDialog(miVista, "Primero debes calcular el billete");
			return;
		}

		// Pedir nombre solo al vender si es familiar
		if (miBilleteTren instanceof BilleteTrenFamiliar familiar) {
			String nombre = JOptionPane.showInputDialog(miVista, "Escribe el nombre del familiar");
			familiar.setNombreViajero(nombre);
		}

		try (PrintWriter pw = new PrintWriter(new FileWriter("./src/billetes/billete" + (contadorBilletes+1) + ".txt"))) {
			pw.println(miBilleteTren.toString());
			JOptionPane.showMessageDialog(miVista, "Billete vendido correctamente");
			contadorBilletes++;
		}
		catch (IOException ex) {
			JOptionPane.showMessageDialog(miVista, "Error al escribir el fichero: " + ex.getMessage());
		}
	}

	/**
	 * Método para calcular el billete al pulsar el botón Calcular
	 */
	private void calcular() {
		Punto origen = new Punto(Float.valueOf(miVista.getTfCoordenadaOrigenX().getText()),
				Float.valueOf(miVista.getTfCoordenadaOrigenY().getText()));

		Punto destino = new Punto(Float.valueOf(miVista.getTfCoordenadaDestinoX().getText()),
				Float.valueOf(miVista.getTfCoordenadaDestinoY().getText()));			

		if (miVista.getChBilleteFamiliar().isSelected()) {

			miBilleteTren = new BilleteTrenFamiliar(origen, destino,
					(EnumDescuentos)miVista.getComboDescuentos().getSelectedItem(), "");

			miVista.getLabelNumeroDistancia().setText(String.valueOf(miBilleteTren.getDistancia()));
			miVista.getLabelNumeroPrecioBillete().setText(miBilleteTren.getPrecioString());

		}
		else {
			miBilleteTren = new BilleteTren(origen, destino,
					(EnumDescuentos)miVista.getComboDescuentos().getSelectedItem());

			miVista.getLabelNumeroDistancia().setText(String.valueOf(miBilleteTren.getDistancia()));
			miVista.getLabelNumeroPrecioBillete().setText(miBilleteTren.getPrecioString());
		}
	}

	/**
	 * Método para resetear la vista al pulsar el botón Cancelar
	 */
	private void cancelar() {
		miVista.getTfCoordenadaOrigenX().setText("0");

		miVista.getTfCoordenadaOrigenY().setText("0");

		miVista.getTfCoordenadaDestinoX().setText("0");

		miVista.getTfCoordenadaDestinoY().setText("0");

		miVista.getComboDescuentos().setSelectedIndex(0);

		miVista.getChBilleteFamiliar().setSelected(false);

		miVista.getLabelNumeroDistancia().setText("0.0");

		miVista.getLabelDescuentoBillete().setText("0");

		miVista.getLabelNumeroPrecioBillete().setText("0 € y 0 céntimos");
	}

	/**
	 * Método de la interfaz ItemListener
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {

		if (e.getSource() == miVista.getComboDescuentos()) {
			actualizarDescuento();
			calcular();
		}
	}

	/**
	 * Método para actualizar el descuento
	 */
	private void actualizarDescuento() {
		EnumDescuentos seleccionado = (EnumDescuentos)miVista.getComboDescuentos().getSelectedItem();
		int descuento = seleccionado.getDescuento();

		if (miVista.getChBilleteFamiliar().isSelected()) {
			descuento += 25;
		}

		miVista.getLabelDescuentoBillete().setText(String.valueOf(descuento));
	}

}
