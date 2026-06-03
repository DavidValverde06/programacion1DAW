package controlador;

import java.awt.event.*;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.*;
import modelo.*;
import vista.*;

public class Controlador implements ActionListener, FocusListener {

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
		else if (e.getSource() == miVista.getbReservar()) {

			String textoFecha = miVista.getTfFechaIni().getText().trim();
			String nombre     = miVista.getTfNombre().getText().trim();
			String dni        = miVista.getTfDNI().getText().trim();
			String tel        = miVista.getTfTel().getText().trim();

			// 1. Nombre y teléfono obligatorios (lo compruebo antes para dar feedback rápido)
			if (nombre.isEmpty() || tel.isEmpty()) {
				JOptionPane.showMessageDialog(miVista, 
						"El nombre y el teléfono son obligatorios", 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			// 2. Fecha correcta
			else if (!LibFechas8.isFechaCorrecta(textoFecha)) {
				JOptionPane.showMessageDialog(miVista, 
						"Fecha de inicio no válida", 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			// 3. Fecha no anterior a hoy
			else if (LibFechas8.convierteStringToLocalDate(textoFecha).isBefore(LocalDate.now())) {
				JOptionPane.showMessageDialog(miVista, 
						"La fecha de reserva no puede ser anterior a la fecha actual", 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			// 4. DNI: vacío está permitido, si tiene algo debe ser válido
			else if (!dni.isEmpty() && !dni.matches("[0-9]{8}[A-Z]")) {
				JOptionPane.showMessageDialog(miVista, 
						"DNI no válido", 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			// 5. Todo correcto -> intentar crear y guardar la reserva
			else {
				try {
					LocalDate fechaIni   = LibFechas8.convierteStringToLocalDate(textoFecha);
					int noches           = Integer.parseInt(miVista.getCbNoches().getSelectedItem().toString());
					String nombreAloj    = miVista.getCbAlojamiento().getSelectedItem().toString();
					Alojamiento alojamiento = miGestor.buscarAlojamiento(nombreAloj);

					Reserva nuevaReserva = new Reserva(alojamiento, textoFecha, noches, nombre, dni, tel);

					boolean añadida = miGestor.añadirReserva(nuevaReserva);

					añadeFilaTabla(nuevaReserva);

					if (!añadida) {
						JOptionPane.showMessageDialog(miVista, 
								"Las fechas elegidas no están disponibles\nSe solapan con otra reserva", 
								"Error", JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(miVista, 
								"Reserva realizada con éxito\n\n" + nuevaReserva.toString(), 
								"Éxito", JOptionPane.INFORMATION_MESSAGE);

						miVista.getbLimpiar().doClick();

					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(miVista, 
							"Error al crear la reserva: " + ex.getMessage(), 
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	private void añadeFilaTabla(Reserva obReserva) {
		String[] fila = new String[7];
		fila[0] = obReserva.getAlojamientoReservado().getNombre();
		fila[1] = LibFechas8.getFechaShort(obReserva.getFechaInicio());
		fila[2] = LibFechas8.getFechaShort(obReserva.getFechaFin());
		fila[3] = Integer.toString(obReserva.getNumNoches());
		fila[4] = obReserva.getNombre();
		fila[5] = obReserva.getDni();
		fila[6] = obReserva.getTelefono();

		miVista.getDatos().addRow(fila); // Añado la fila al DefaultTableModel
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent e) {
		/**
		 * En el momento que el campo Fecha de Inicio, pierda el foco, calcularemos la fecha de fin y el coste de
		 * la reserva (el cual estará en función de la fecha de inicio, el número de noches y el alojamiento).
		 * También recalcularemos el coste cuando se cambie el número de noches o el alojamiento elegido en
		 * sus combos correspondientes. 
		 */
		if (e.getSource()==miVista.getTfFechaIni() ||
				e.getSource()==miVista.getCbNoches() ||
				e.getSource() == miVista.getCbAlojamiento()) {
			try {
				String textoFecha = miVista.getTfFechaIni().getText();

				if (textoFecha.isEmpty() || !LibFechas8.isFechaCorrecta(textoFecha)) return;

				LocalDate fechaIni = LibFechas8.convierteStringToLocalDate(textoFecha);
				int noches = Integer.parseInt(miVista.getCbNoches().getSelectedItem().toString());

				LocalDate fechaFin = LibFechas8.sumaDias(fechaIni, noches);
				miVista.getTfFechaFin().setText(fechaFin.toString());

				String nombreAloj = miVista.getCbAlojamiento().getSelectedItem().toString();
				Alojamiento alojamiento = miGestor.buscarAlojamiento(nombreAloj);

				Reserva reservaTemporal = new Reserva(alojamiento, textoFecha, noches, "temp", "", "000000000");
				double coste = reservaTemporal.precioFinalReserva();

				miVista.getLabelCoste().setText(coste + "€ (Temporada " + reservaTemporal.temporadaReserva() + ")");

			}
			catch (Exception ex) {
				miVista.getTfFechaFin().setText("");
				miVista.getLabelCoste().setText("0");
			}
		}
	}

	public void cerrarAplicacion(JFrame ventana) {
		int opcion = JOptionPane.showConfirmDialog(ventana,
				"¿Desea guardar las reservas en el fichero Reservas.txt?",
				"Cerrar aplicación",
				JOptionPane.YES_NO_OPTION);

		if (opcion == JOptionPane.YES_OPTION) {
			try (PrintWriter pw = new PrintWriter(new FileWriter("Reservas.txt", true))) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
						"EEEE, d 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
				pw.println("\n--- Reservas guardadas el " + LocalDate.now().format(formatter) + " ---");
				for (Reserva r : miGestor.getReservasRealizadas()) {
					pw.println(r.toString());
					pw.println();
				}
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(ventana,
						"Error al guardar: " + ex.getMessage(),
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		ventana.dispose();
	}

}
