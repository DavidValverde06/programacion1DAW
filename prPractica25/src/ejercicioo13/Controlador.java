package ejercicioo13;

import java.awt.event.*;
import java.io.*;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 * 13.- Realizar una aplicación que nos permita “navegar” a través de los directorios del sistema, ofreciendo
 * la siguiente información de cada fichero/directorio seleccionado: si tiene permiso de escritura, si tiene
 * premiso de lectura, si es un directorio o si está oculto.
 */
public class Controlador implements ActionListener {

	/**
	 * Variables de instancia 
	 */
	private Vista miVista;

	/**
	 * Constructor
	 */
	public Controlador(Vista v) {
		miVista = v;
	}

	/**
	 * Método de la interfaz ActionListener()
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			// Obtener la ruta el nombre del archivo o directorio seleccionado
			// en el JComboBox
			String camino = miVista.getRuta().getCanonicalPath() // Devuelve la ruta real de donde esta el archivo
					+ File.separator
					// Añade un separador (/)
					+ miVista.getMiComboFicheros().getSelectedItem();

			// Opcion elegida del JComboBox
			System.out.println(camino);
			miVista.getLabelInformacion().setText(miVista.getMiComboFicheros().getSelectedItem().toString());

			// Actualizar la variable ruta
			miVista.setRuta(new File(camino));

			// Averiguar si la nueva ruta es un fichero o un directorio
			if (miVista.getRuta().isDirectory()) {
				miVista.getMiComboFicheros().setModel(new DefaultComboBoxModel<String>(miVista.getRuta().list()));
			}
			else {
				miVista.getMiComboFicheros().setModel(new DefaultComboBoxModel<String>());
			}

			miVista.getMiComboFicheros().addItem("..");
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(miVista, "Problema al cargar esta carpeta");
		}
		finally {
			miVista.actualizarCheck();
		}
	}

}
