package controlador;

import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelo.*;
import vista.Vista;

public class Controlador implements ActionListener{

	/**
	 * Variables de instancia
	 */
	private Vista miVista;
	private GestorVivero miGestor;

	/**
	 * Cosntructor
	 */
	public Controlador(Vista miVista) {
		this.miVista = miVista;
		this.miGestor = new GestorVivero("Plantas");

		for (Entry<String, Planta> planta : miGestor.getColeccionPlantas().entrySet()) {
			DecimalFormat patron = new DecimalFormat("0.00");

			String[] fila = new String[5]; 

			fila[0] = planta.getValue().getIdPlanta();
			fila[1] = planta.getValue().getNombreComunPlanta();
			fila[2] = String.valueOf(planta.getValue().getStockDisponible());
			fila[3] = String.valueOf(planta.getValue().getPrecioBasePlanta());
			fila[4] = String.valueOf(patron.format(planta.getValue().calcularPrecioVenta()));

			miVista.getModeloTablaCatalogo().addRow(fila); // Añadir datos JTable
			miVista.getModeloCbPlantas().addElement(planta.getKey() + " - " + planta.getValue().getNombreComunPlanta()); // Añadir datos JComboBox
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==miVista.getbInfo()) {
			String[] datos = miVista.getCbPlantas().getSelectedItem().toString().split("-");

			Planta mensaje;
			try {
				mensaje = miGestor.buscarPlanta(datos[0].trim());
				JOptionPane.showMessageDialog(miVista, mensaje.toString(), "Información",
						JOptionPane.INFORMATION_MESSAGE);
			}
			catch (MiExcepcion ex) {
				JOptionPane.showMessageDialog(miVista, ex.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		else if (e.getSource()==miVista.getbAñadirCarrito()) {
			DecimalFormat patron = new DecimalFormat("0.00");

			String[] datos = miVista.getCbPlantas().getSelectedItem().toString().split("-");

			Planta planta;
			try {				
				planta = miGestor.buscarPlanta(datos[0].trim());

				String[] fila = new String[5]; 

				fila[0] = planta.getIdPlanta();
				fila[1] = planta.getNombreComunPlanta();
				fila[2] = String.valueOf(miVista.getCbUnidades().getSelectedItem());
				fila[3] = String.valueOf(planta.getPrecioBasePlanta());
				fila[4] = String.valueOf(patron.format(planta.calcularPrecioVenta()));

				miVista.getModeloTablaCompras().addRow(fila);
			}
			catch (MiExcepcion e1) {
				e1.printStackTrace();
			}


		}
		else if (e.getSource()==miVista.getbCancelarCompra()) {
			miVista.getCbPlantas().setSelectedIndex(0);
			miVista.getCbUnidades().setSelectedIndex(0);
			miVista.getRbTodas().doClick();
			miVista.getTablaCatalogo().clearSelection();
			miVista.getModeloTablaCompras().setRowCount(0);
		}
		else if (e.getSource()==miVista.getbFinalizarCompra()) {
			int opcion = JOptionPane.showConfirmDialog(null,
					"¿Confirmar compra?",
					"Finalización compra",
					JOptionPane.YES_NO_OPTION);

			if (opcion == JOptionPane.YES_OPTION) {

				String nombreCliente = JOptionPane.showInputDialog("Introduce el nombre del cliente: ");

				try (BufferedWriter flujoEscritura = new BufferedWriter(new FileWriter(new File("./files/" + nombreCliente+System.currentTimeMillis() + ".txt")))) {
					DateTimeFormatter formateador = DateTimeFormatter.ofPattern(
							"EEEE, d 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
					flujoEscritura.write(LocalDate.now().format(formateador));
				}
				catch (FileNotFoundException ex) {
					ex.printStackTrace();
				}
				catch (IOException ex) {
					ex.printStackTrace();
				}
			}
			else {
				return;
			}
		}
		else if (e.getSource()==miVista.getRbTodas()) {
			miVista.getModeloTablaCatalogo().setRowCount(0);
			for (Entry<String, Planta> planta : miGestor.getColeccionPlantas().entrySet()) {
				DecimalFormat patron = new DecimalFormat("0.00");

				String[] fila = new String[5]; 

				fila[0] = planta.getValue().getIdPlanta();
				fila[1] = planta.getValue().getNombreComunPlanta();
				fila[2] = String.valueOf(planta.getValue().getStockDisponible());
				fila[3] = String.valueOf(planta.getValue().getPrecioBasePlanta());
				fila[4] = String.valueOf(patron.format(planta.getValue().calcularPrecioVenta()));

				miVista.getModeloTablaCatalogo().addRow(fila); // Añadir datos JTable
			}
		}
		else if (e.getSource()==miVista.getRbPlantaEstandar()) {
			miVista.getModeloTablaCatalogo().setRowCount(0);
			for (Entry<String, Planta> planta : miGestor.getColeccionPlantas().entrySet()) {
				if (planta.getKey().matches("EST[0-9]{3}")) {
					DecimalFormat patron = new DecimalFormat("0.00");

					String[] fila = new String[5]; 

					fila[0] = planta.getValue().getIdPlanta();
					fila[1] = planta.getValue().getNombreComunPlanta();
					fila[2] = String.valueOf(planta.getValue().getStockDisponible());
					fila[3] = String.valueOf(planta.getValue().getPrecioBasePlanta());
					fila[4] = String.valueOf(patron.format(planta.getValue().calcularPrecioVenta()));

					miVista.getModeloTablaCatalogo().addRow(fila); // Añadir datos JTable
				}
			}
		}
		else if (e.getSource()==miVista.getRbBonsai()) {
			miVista.getModeloTablaCatalogo().setRowCount(0);
			for (Entry<String, Planta> planta : miGestor.getColeccionPlantas().entrySet()) {
				if (planta.getKey().matches("BON[0-9]{3}")) {
					DecimalFormat patron = new DecimalFormat("0.00");

					String[] fila = new String[5]; 

					fila[0] = planta.getValue().getIdPlanta();
					fila[1] = planta.getValue().getNombreComunPlanta();
					fila[2] = String.valueOf(planta.getValue().getStockDisponible());
					fila[3] = String.valueOf(planta.getValue().getPrecioBasePlanta());
					fila[4] = String.valueOf(patron.format(planta.getValue().calcularPrecioVenta()));

					miVista.getModeloTablaCatalogo().addRow(fila); // Añadir datos JTable
				}
			}
		}
	}

	public void cerrarAplicacion(JFrame ventana) {
		int opcion = JOptionPane.showConfirmDialog(ventana,
				"¿Desea volcar el catálogo actualizado a archivos?",
				"Volcado datos",
				JOptionPane.YES_NO_OPTION);

		if (opcion == JOptionPane.YES_OPTION) {
			miGestor.vuelcaCatalogoResumen();
		}

		ventana.dispose();
	}
}
