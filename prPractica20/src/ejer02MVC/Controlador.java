package ejer02MVC;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Controlador implements ItemListener, ListSelectionListener {

	/**
	 * Variables de instancia
	 */
	private Vista miVista;

	/**
	 * Constructor
	 */
	public Controlador(Vista v) {
		this.miVista = v;
	}

	/**
	 * Método del ListSelectionListener para los eventos del JList
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		miVista.getEtiquetaInfo().setForeground(
				miVista.getMapaColores().get(
						miVista.getListaColores().getSelectedValue()));

		miVista.getEtiquetaInfo().setText("Color pintura: " + miVista.getListaColores().getSelectedValue());
	}

	/*
	 * Método de ItemListener para los eventos del JCombBox y los JCheckBox
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		miVista.getEtiquetaInfo().setForeground(Color.blue);

		// Comprobar si el componente que seha activado es el JComboBox
		if (e.getSource() == miVista.getComboNumLlantas()) {
			miVista.getEtiquetaInfo().setText("Número de radios: " + miVista.getComboNumLlantas().getSelectedItem());
			return;
		}

		// Si continuamos en esta línea de código, es porque se ha marcado/desmarcado
		// uno de los check

		// Guardar en variables locales el texto del check y su estado
		String textoCheck = ((JCheckBox)e.getSource()).getText();
		int estadoCheck = e.getStateChange();  // SELECTED o DESELECTED

		// Mostrar en la etiqueta el texto del check activado
		miVista.getEtiquetaInfo().setText(textoCheck);

		// ---------------------------------------------------
		// Programar los check de Llantas, Pintura y Asientos
		if (e.getSource() == miVista.getChLLantasAleacion()) {
			miVista.getComboNumLlantas().setEnabled(estadoCheck == ItemEvent.SELECTED);
		}
		else if (e.getSource() == miVista.getChPintura()) {
			miVista.getScrollColor().setVisible(estadoCheck == ItemEvent.SELECTED);
		}
		else if (e.getSource() == miVista.getChAsientosDeportivos()) {
			miVista.getChTapiceria().setSelected(estadoCheck == ItemEvent.SELECTED);
			miVista.getChTapiceria().setEnabled(estadoCheck == ItemEvent.DESELECTED);
			miVista.getEtiquetaInfo().setText("Asientos deportivos");
		}

	}

}
