package controlador;

import java.awt.event.*;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import modelo.*;
import vista.*;

public class Controlador implements ActionListener {

	/**
	 * Variables de instancia
	 */
	private Vista miVista;
	private GestorAlojamientos miGestor;

	/**
	 * Constructor
	 */
	public Controlador(Vista miVista) {
		this.miVista = miVista;
		this.miGestor = new GestorAlojamientos("Alojamientos.txt");

		// Cargar los alojamientos, estos los debéis de cargar desde el Controlador
		for (Alojamiento alojamiento : miGestor.getAlojamientosDisponibles()) {
			miVista.getCbAlojamiento().addItem(alojamiento.getNombre());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * En el combo ubicaciones podremos seleccionar “Todas”, en cuyo caso en el combo de alojamientos
		 * aparecerán todos los alojamientos de los que se dispone, o bien seleccionar una determinada
		 * ubicación, lo que hará que en el combo de alojamientos sólo aparezcan los alojamientos de esa
		 * ubicación. 
		 */
		if (e.getSource()==miVista.getCbUbicaciones()) {

			if (miVista.getCbUbicaciones().getSelectedItem()==EnumUbicaciones.Todas) {
				for (Alojamiento alojamiento : miGestor.getAlojamientosDisponibles()) {
					miVista.getCbAlojamiento().addItem(alojamiento.getNombre());
				}
			}
			else {
				miVista.getCbAlojamiento().removeAllItems();
				for (String alojamiento : miGestor.getNombresAlojamientos(miVista.getCbUbicaciones().getSelectedItem().toString())) {
					miVista.getCbAlojamiento().addItem(alojamiento);
				}
			}
		}

		/**
		 * Si pulsamos el botón “Ver detalles”, nos aparecerá información del
		 * alojamiento que esté seleccionado en ese momento en el combo
		 * de alojamientos.
		 */
		else if (e.getSource()==miVista.getbDetalles()) {
			Alojamiento alojamiento = miGestor.buscarAlojamiento(miVista.getCbAlojamiento().getSelectedItem().toString());
			JOptionPane.showMessageDialog(miVista, "DETALLES DEL ALOJAMIENTO\n\n" + alojamiento.toString(), "Información", JOptionPane.INFORMATION_MESSAGE);
		}

		/**
		 * El botón “Limpiar formulario”, dejará la parte de “Datos reserva” sin datos previos en los campos de
		 * texto y label de coste, y con los combo en su primera opción seleccionada.
		 */
		else if (e.getSource()==miVista.getbLimpiar()) {
			miVista.getCbUbicaciones().setSelectedIndex(0);
			miVista.getCbAlojamiento().setSelectedIndex(0);
			miVista.getTfFechaIni().setText("");
			miVista.getCbNoches().setSelectedIndex(0);
			miVista.getTfFechaFin().setText("");
			miVista.getLabelCoste().setText("0");
			miVista.getTfNombre().setText("");
			miVista.getTfDNI().setText("");
			miVista.getTfTel().setText("");
		}

		/**
		 * El botón “Realizar reserva”, nos permitirá guardar una nueva reserva en nuestro gestor de reservas.
		 * Debemos de tener en cuenta que no podremos realizar una reserva si:
		 * 
		 * o La fecha de inicio es anterior a la fecha actual.
		 * 
		 * o Si la fecha de inicio es incorrecta.
		 * 
		 * o Si el DNI es incorrecto, aunque sí podremos dejarlo en blanco.
		 * 
		 * o Si las fechas se solapan con otra reserva previa para el mismo alojamiento.
		 * 
		 * o Los campos nombre y teléfono son obligatorios, no podremos dejarlos en blanco.
		 */
		else if (e.getSource()==miVista.getbReservar()) {
			LocalDate fechaIni = LibFechas8.convierteStringToLocalDate(miVista.getTfFechaIni().getText());

			if (fechaIni.isBefore(LocalDate.now())) {
				JOptionPane.showMessageDialog(miVista, "La fecha de reserva no puede ser anterior a la fecha actual", "Información", JOptionPane.INFORMATION_MESSAGE);
			}
			else if (LibFechas8.isFechaCorrecta(miVista.getTfFechaIni().getText())==false) {
				JOptionPane.showMessageDialog(miVista, "Fecha de inicio no válida", "Información", JOptionPane.INFORMATION_MESSAGE);
			}
			else if (!miVista.getTfDNI().getText().matches("[0-9]{8}[A-Z]{1}") ||
					!miVista.getTfDNI().getText().isEmpty()) {
				JOptionPane.showMessageDialog(miVista, "DNI no válido", "Información", JOptionPane.INFORMATION_MESSAGE);
			}
			//			else if () {
			//				JOptionPane.showMessageDialog(miVista, "Las fechas elegidas no están disponibles\nSe solapan", "Información", JOptionPane.INFORMATION_MESSAGE);
			//			}
			else if (miVista.getTfNombre().getText().isEmpty() || miVista.getTfTel().getText().isEmpty()) {
				JOptionPane.showMessageDialog(miVista, "El nombre y el teléfono son obligatorios", "Información", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
