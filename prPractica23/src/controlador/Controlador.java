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

	// Método de la interfaz ItemStateChanged (ComboBox)
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == miVista.getMiComboTipoPropiedad()) {

			TipoPropiedad itemSeleccionado = (TipoPropiedad)miVista.getMiComboTipoPropiedad().getSelectedItem();

			if (itemSeleccionado == TipoPropiedad.VIVIENDA) {
				habilitarPanelVivienda();
			}
			else if (itemSeleccionado == TipoPropiedad.FINCA) {
				habilitarPanelFinca();
			}
			else {
				deshabilitarPanelViviendaFinca();
			}
		}
	}

	/**
	 * Método de la interfaz ActionListener (Botones)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == miVista.getbGuardar()) {
			guardar(); // Botón Guardar
		}
		if (e.getSource() == miVista.getbConsultar()) {
			consultar(); // Botón Consultar
		}
		if (e.getSource() == miVista.getbBorrar()) {
			borrar(); // Botón Borrar
		}
		if (e.getSource() == miVista.getbLimpiar()) {
			limpiar(); // Botón Limpiar
		}
	}

	// ==================== //
	// Métodos del programa //
	// ==================== //

	/**
	 * Método para consultar las propiedades ya creadas al pulsar el botón consultar
	 */
	private void consultar() {
		if (miInmobiliaria.getColeccionPropiedad().isEmpty()) {
			JOptionPane.showMessageDialog(miVista, "No hay propiedades registradas.");
		}
		else {
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
	}

	/**
	 * Método para borrar las propiedades una vez consultadas al pulsar el botón borrar
	 */
	private void borrar() {
		String textoCodigo = miVista.getTfCodigo().getText();

		if (textoCodigo.isEmpty()) {
			JOptionPane.showMessageDialog(miVista, "Primero debes consultar o escribir el código de una propiedad.");
		}
		else {
			try {
				int cod = Integer.parseInt(textoCodigo);

				int confirmacion = JOptionPane.showConfirmDialog(miVista,
						"¿Está seguro de que desea borrar esta propiedad?",
						"Borrado de propiedades",
						JOptionPane.YES_NO_OPTION);

				if (confirmacion == JOptionPane.YES_OPTION) {
					Propiedad borrada = miInmobiliaria.borra(cod);

					if (borrada != null) {
						miVista.getbLimpiar().doClick(); // Llamar al botón limpiar
						JOptionPane.showMessageDialog(miVista, "LA PROPIEDAD HA SIDO BORRADA");
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
	}

	/**
	 * Método para guardar las propiedades del programa al pulsar el botón guardar
	 */
	private void guardar() {
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

				// Crear una propiedad de tipo Vivienda
				nuevaPropiedad = new Vivienda(cod, tProp, sup, des, dir, pre, tViv, baño, dorm);
			} 
			else if (tProp == TipoPropiedad.FINCA) {

				TipoTerreno tTerr = (TipoTerreno)miVista.getMiComboTipoTerreno().getSelectedItem();
				boolean elec = miVista.getRbSuministroElecSi().isSelected();
				boolean agua = miVista.getRbSuministroAguaSi().isSelected();
				boolean disponeViv = miVista.getRbDisponeViviendaSi().isSelected();

				// Crear una propiedad de tipo Finca Rustica
				nuevaPropiedad = new FincaRustica(cod, tProp, sup, des, dir, pre, tTerr, elec, agua, disponeViv); 
			}
			else {
				// Crear una propiedad de cualquier otro tipo
				nuevaPropiedad = new Propiedad(cod, tProp, sup, des, dir, pre);
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

	/**
	 * Método para limpiar el programa al pulsar el botón limpiar
	 */
	private void limpiar() {
		// Panel 1 - Datos generales
		miVista.getTfCodigo().setText("");
		miVista.getMiComboTipoPropiedad().setSelectedIndex(3);
		miVista.getTfPrecio().setText("0");
		miVista.getTfSuperficie().setText("0");
		miVista.getTfDireccion().setText("");
		miVista.getTaDescripcion().setText("");

		// Panel 2 - Datos especificos vivienda
		miVista.getMiComboTipoVivienda().setSelectedIndex(0);
		miVista.getMiComboNumDormitorios().setSelectedIndex(0);
		miVista.getMiComboNumBanios().setSelectedIndex(0);

		miVista.getMiComboTipoVivienda().setEnabled(false);
		miVista.getMiComboNumDormitorios().setEnabled(false);
		miVista.getMiComboNumBanios().setEnabled(false);

		// Panel 3 - Datos especificos finca
		miVista.getMiComboTipoTerreno().setSelectedIndex(0);

		miVista.getRbSuministroElecSi().setSelected(true);
		miVista.getRbSuministroAguaSi().setSelected(true);
		miVista.getRbDisponeViviendaSi().setSelected(true);

		miVista.getMiComboTipoTerreno().setEnabled(true);
		miVista.getRbSuministroElecSi().setEnabled(true);
		miVista.getRbSuministroElecNo().setEnabled(true);
	}

	/**
	 * Método que deshabilita los componentes del panel Vivienda y del panel Finca 
	 */
	private void deshabilitarPanelViviendaFinca() {
		// Panel Especifico Vivienda habilitado
		miVista.getMiComboTipoVivienda().setEnabled(false);
		miVista.getMiComboNumDormitorios().setEnabled(false);
		miVista.getMiComboNumBanios().setEnabled(false);

		// Panel Especifico Finca deshabilitado
		miVista.getMiComboTipoTerreno().setEnabled(false);
		miVista.getRbSuministroElecSi().setEnabled(false);
		miVista.getRbSuministroElecNo().setEnabled(false);
		miVista.getRbSuministroAguaSi().setEnabled(false);
		miVista.getRbSuministroAguaNo().setEnabled(false);
		miVista.getRbDisponeViviendaSi().setEnabled(false);
		miVista.getRbDisponeViviendaNo().setEnabled(false);
	}

	/**
	 * Método que deshabilita los componentes del panel Vivienda y habilita los del panel Finca 
	 */
	private void habilitarPanelFinca() {
		// Panel Especifico Vivienda deshabilitado
		miVista.getMiComboTipoVivienda().setEnabled(false);
		miVista.getMiComboNumDormitorios().setEnabled(false);
		miVista.getMiComboNumBanios().setEnabled(false);

		// Panel Especifico Finca habilitado
		miVista.getMiComboTipoTerreno().setEnabled(true);
		miVista.getRbSuministroElecSi().setEnabled(true);
		miVista.getRbSuministroElecNo().setEnabled(true);
		miVista.getRbSuministroAguaSi().setEnabled(true);
		miVista.getRbSuministroAguaNo().setEnabled(true);
		miVista.getRbDisponeViviendaSi().setEnabled(true);
		miVista.getRbDisponeViviendaNo().setEnabled(true);
	}

	/**
	 * Método que deshabilita los componentes del panel Finca y habilita los del panel Vivienda 
	 */
	private void habilitarPanelVivienda() {
		// Panel Especifico Vivienda deshabilitado
		miVista.getMiComboTipoVivienda().setEnabled(true);
		miVista.getMiComboNumDormitorios().setEnabled(true);
		miVista.getMiComboNumBanios().setEnabled(true);

		// Panel Especifico Finca deshabilitado
		miVista.getMiComboTipoTerreno().setEnabled(false);
		miVista.getRbSuministroElecSi().setEnabled(false);
		miVista.getRbSuministroElecNo().setEnabled(false);
		miVista.getRbSuministroAguaSi().setEnabled(false);
		miVista.getRbSuministroAguaNo().setEnabled(false);
		miVista.getRbDisponeViviendaSi().setEnabled(false);
		miVista.getRbDisponeViviendaNo().setEnabled(false);
	}
}
