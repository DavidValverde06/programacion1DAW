package controlador;

import java.awt.event.*;
import javax.swing.*;
import modelo.*;
import vista.*;

public class Controlador implements ItemListener, ActionListener {

	/**
	 * Variables de instancia
	 */
	private Vista miVista;
	private Inmobiliaria miInmobiliaria;

	/**
	 * Constructor
	 */
	public Controlador(Vista v) {
		this.miVista = v;
		this.miInmobiliaria = new Inmobiliaria();
	}

	// ItemStateChanged (ComboBox)
	@Override
	public void itemStateChanged(ItemEvent e) {

		if (e.getSource() == miVista.getMiComboTipoPropiedad()) {

			TipoPropiedad seleccionado = (TipoPropiedad) miVista.getMiComboTipoPropiedad().getSelectedItem();

			if (seleccionado == TipoPropiedad.VIVIENDA) {

				miVista.getMiComboTipoVivienda().setEnabled(true);
				miVista.getMiComboNumDormitorios().setEnabled(true);
				miVista.getMiComboNumBanios().setEnabled(true);

				miVista.getMiComboTipoTerreno().setEnabled(false);
				miVista.getRbSuministroElecSi().setEnabled(false);
				miVista.getRbSuministroElecNo().setEnabled(false);
				miVista.getRbSuministroAguaSi().setEnabled(false);
				miVista.getRbSuministroAguaNo().setEnabled(false);
				miVista.getRbDisponeViviendaSi().setEnabled(false);
				miVista.getRbDisponeViviendaNo().setEnabled(false);
				return;
			}
			else if (seleccionado == TipoPropiedad.FINCA) {

				miVista.getMiComboTipoVivienda().setEnabled(false);
				miVista.getMiComboNumDormitorios().setEnabled(false);
				miVista.getMiComboNumBanios().setEnabled(false);

				miVista.getMiComboTipoTerreno().setEnabled(true);
				miVista.getRbSuministroElecSi().setEnabled(true);
				miVista.getRbSuministroElecNo().setEnabled(true);
				miVista.getRbSuministroAguaSi().setEnabled(true);
				miVista.getRbSuministroAguaNo().setEnabled(true);
				miVista.getRbDisponeViviendaSi().setEnabled(true);
				miVista.getRbDisponeViviendaNo().setEnabled(true);
				return;
			}
			else {

				miVista.getMiComboTipoVivienda().setEnabled(false);
				miVista.getMiComboNumDormitorios().setEnabled(false);
				miVista.getMiComboNumBanios().setEnabled(false);

				miVista.getMiComboTipoTerreno().setEnabled(false);
				miVista.getRbSuministroElecSi().setEnabled(false);
				miVista.getRbSuministroElecNo().setEnabled(false);
				miVista.getRbSuministroAguaSi().setEnabled(false);
				miVista.getRbSuministroAguaNo().setEnabled(false);
				miVista.getRbDisponeViviendaSi().setEnabled(false);
				miVista.getRbDisponeViviendaNo().setEnabled(false);
				return;
			}
		}
	}

	/**
	 * ActionListener (Botones)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// Botón Guardar
		if (e.getSource() == miVista.getbGuardar()) {

			try {
				int cod = Integer.parseInt(miVista.getTfCodigo().getText());
				double pre = Double.parseDouble(miVista.getTfPrecio().getText());
				double sup = Double.parseDouble(miVista.getTfSuperficie().getText());
				String dir = miVista.getTfDireccion().getText();
				String des = miVista.getTaDescripcion().getText();
				TipoPropiedad tProp = (TipoPropiedad)miVista.getMiComboTipoPropiedad().getSelectedItem();

				Propiedad nuevaPropiedad = null;

				if (tProp == TipoPropiedad.VIVIENDA) {

					TipoVivienda tViv = (TipoVivienda)miVista.getMiComboTipoVivienda().getSelectedItem();
					int dorm = (int)miVista.getMiComboNumDormitorios().getSelectedItem();
					int baño = (int)miVista.getMiComboNumBanios().getSelectedItem();

					nuevaPropiedad = new Vivienda(cod, tProp, sup, des, dir, pre, tViv, baño, dorm);
				} 
				else if (tProp == TipoPropiedad.FINCA) {

					TipoTerreno tTerr = (TipoTerreno)miVista.getMiComboTipoTerreno().getSelectedItem();
					boolean elec = miVista.getRbSuministroElecSi().isSelected();
					boolean agua = miVista.getRbSuministroAguaSi().isSelected();
					boolean disponeViv = miVista.getRbDisponeViviendaSi().isSelected();

					nuevaPropiedad = new FincaRustica(cod, tProp, sup, des, dir, pre, tTerr, elec, agua, disponeViv);
				}

				if (nuevaPropiedad!=null) {
					if (miInmobiliaria.añade(nuevaPropiedad)) {
						JOptionPane.showMessageDialog(miVista, "Se han almacenado los siguientes datos:\n" + nuevaPropiedad.toString());
					}
					else {
						JOptionPane.showMessageDialog(miVista, "Ya existe otra propiedad con este código.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(miVista, "Datos erroneos.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}

		// Botón Consultar
		if (e.getSource() == miVista.getbConsultar()) {

			if (miInmobiliaria.getColeccionPropiedad().isEmpty()) {
				JOptionPane.showMessageDialog(miVista, "No hay propiedades registradas.");
				return;
			}

			String[] codigos = new String[miInmobiliaria.getColeccionPropiedad().size()];

			int cont = 0;
			for (Propiedad p:miInmobiliaria.getColeccionPropiedad()) {
				codigos[cont] = String.valueOf(p.getCodigo());
				cont++;
			}

			Object seleccion = JOptionPane.showInputDialog(miVista,
					"Elije el código de la propiedad a consultar: ",
					"Propiedades disponibles",
					JOptionPane.QUESTION_MESSAGE,
					null,
					codigos,
					null);

			if (seleccion != null) {
				int codSeleccionado = Integer.parseInt(seleccion.toString());
				Propiedad propiedadEncontrada = miInmobiliaria.buscar(codSeleccionado);

				if (propiedadEncontrada != null) {
					miVista.getTfCodigo().setText(String.valueOf(propiedadEncontrada.getCodigo()));
					miVista.getTfPrecio().setText(String.valueOf(propiedadEncontrada.getPrecio()));
					miVista.getTfSuperficie().setText(String.valueOf(propiedadEncontrada.getSuperficie()));
					miVista.getTfDireccion().setText(propiedadEncontrada.getDireccion());
					miVista.getTaDescripcion().setText(propiedadEncontrada.getDescripcion());
					miVista.getMiComboTipoPropiedad().setSelectedItem(propiedadEncontrada.getTipoPropiedad());

					if (propiedadEncontrada instanceof Vivienda) {
						Vivienda v = (Vivienda) propiedadEncontrada;

						miVista.getMiComboTipoVivienda().setSelectedItem(v.getTipoVivienda());
						miVista.getMiComboNumDormitorios().setSelectedItem(v.getNumDormitorios());
						miVista.getMiComboNumBanios().setSelectedItem(v.getNumBanios());

					} 
					else if (propiedadEncontrada instanceof FincaRustica) {
						FincaRustica f = (FincaRustica) propiedadEncontrada;

						miVista.getMiComboTipoTerreno().setSelectedItem(f.getTipoTerreno());

						miVista.getRbSuministroElecSi().setSelected(f.isDisponeLuz());
						miVista.getRbSuministroElecNo().setSelected(!f.isDisponeLuz());

						miVista.getRbSuministroAguaSi().setSelected(f.isDisponeAgua());
						miVista.getRbSuministroAguaNo().setSelected(!f.isDisponeAgua());

						miVista.getRbDisponeViviendaSi().setSelected(f.isDisponeVivienda());
						miVista.getRbDisponeViviendaNo().setSelected(!f.isDisponeVivienda());
					}
				}
			}
		}

		// Botón Borrar
		if (e.getSource() == miVista.getbBorrar()) {

			String textoCodigo = miVista.getTfCodigo().getText();

			if (textoCodigo.isEmpty()) {
				JOptionPane.showMessageDialog(miVista, "Primero debes consultar o escribir el código de una propiedad.");
				return;
			}

			try {
				int cod = Integer.parseInt(textoCodigo);

				int confirmacion = JOptionPane.showConfirmDialog(miVista,
						"¿Está seguro de que desea borrar esta propiedad?",
						"Borrado de propiedades",
						JOptionPane.YES_NO_OPTION);

				if (confirmacion == JOptionPane.YES_OPTION) {
					Propiedad borrada = miInmobiliaria.borra(cod);

					if (borrada != null) {
						JOptionPane.showMessageDialog(miVista, "LA PROPIEDAD HA SIDO BORRADA");

						miVista.getbLimpiar().doClick(); // Llamar al botón limpiar

					}
					else {	
						JOptionPane.showMessageDialog(miVista, "No se pudo borrar. La propiedad no existe.");
					}
				}
				else {
					JOptionPane.showMessageDialog(miVista, "Operación cancelada");
				}
			}
			catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(miVista, "El código debe ser un número entero.");
			}
		}

		// Botón Limpiar
		if (e.getSource() == miVista.getbLimpiar()) {
			miVista.getTfCodigo().setText("");
			miVista.getTfPrecio().setText("0");
			miVista.getTfSuperficie().setText("0");
			miVista.getTfDireccion().setText("");
			miVista.getTaDescripcion().setText("");

			miVista.getMiComboTipoPropiedad().setSelectedIndex(3);
			miVista.getMiComboTipoVivienda().setSelectedIndex(0);
			miVista.getMiComboNumDormitorios().setSelectedIndex(0);
			miVista.getMiComboNumBanios().setSelectedIndex(0);
			miVista.getMiComboTipoTerreno().setSelectedIndex(0);

			miVista.getRbSuministroElecSi().setSelected(true);
			miVista.getRbSuministroAguaSi().setSelected(true);
			miVista.getRbDisponeViviendaSi().setSelected(true);

			miVista.getMiComboTipoVivienda().setEnabled(false);
			miVista.getMiComboNumDormitorios().setEnabled(false);
			miVista.getMiComboNumBanios().setEnabled(false);

			miVista.getMiComboTipoTerreno().setEnabled(true);
			miVista.getRbSuministroElecSi().setEnabled(true);
			miVista.getRbSuministroElecNo().setEnabled(true);
			return;
		}

	}

}
