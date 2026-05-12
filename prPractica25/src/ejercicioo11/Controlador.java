package ejercicioo11;

import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class Controlador implements ActionListener {

	/**
	 * Variables de instancia
	 */
	private Vista miVista;
	private TreeMap<String, String> palabras;

	/**
	 * Constructor
	 */
	public Controlador(Vista v) {
		this.miVista = v;
		this.palabras = new TreeMap<>();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Traducir
		traducirPalabras(e);

		// Añadir palabra y traducción
		anadirPalabra(e);

		// Ver listado de las palabras del traductor
		verListado(e);

		// Limpiar programa
		limpiarPrograma(e);

		// Cambiar idioma
		cambiarIdioma(e);

	}

	/**
	 * Método que lee y muestra el fichero
	 * @param e
	 */
	private void verListado(ActionEvent e) {
		if (e.getSource().equals(miVista.getBotonVerFichero())) {

			Path ficheroTraductor = Path.of("./src/ejercicioo11/palabrasTraductor.txt");

			try (BufferedReader flujoLectura = new BufferedReader(
					new FileReader(ficheroTraductor.toFile()))) {

				String cadena = flujoLectura.readAllAsString(); // Método nuevo de Java 25

				// System.out.println((String)cadena);

				JOptionPane.showMessageDialog(miVista, cadena, "Listado de palabras", 1);

			}
			catch (FileNotFoundException ex) {
				System.out.println("Problema al abrir el archivo");
			}
			catch (IOException ex) {
				System.out.println("Error de E/S");
			}
		}
	}

	/**
	 * Método para limpiar el programa
	 * @param e
	 */
	private void limpiarPrograma(ActionEvent e) {
		if (e.getSource().equals(miVista.getBotonLimpiar())) {
			miVista.getTfPalabraParaTraducir().setText("");
			miVista.getTfPalabraTraducida().setText("");
		}
	}

	/**
	 * Método para traducir las palabras mediante ficheros
	 * @param e
	 */
	private void traducirPalabras(ActionEvent e) {
		if (e.getSource().equals(miVista.getBotonTraducir())) {

			String cadena;
			Path ficheroTraductor = Path.of("./src/ejercicioo11/palabrasTraductor.txt");

			try (BufferedReader flujoLectura = new BufferedReader(
					new FileReader(
							ficheroTraductor.toFile()))) {

				while ((cadena = flujoLectura.readLine()) != null) {
					String[] partes = cadena.split("-");

					if (partes.length == 2) {
						palabras.put(partes[0].trim(), partes[1].trim());
					}
				}

				String modo = miVista.getlEtiquetaInfo().getText();
				boolean encontrada = false;

				if (modo.equalsIgnoreCase("Español 🡆 Inglés")) {
					String buscar = miVista.getTfPalabraParaTraducir().getText().trim().toLowerCase();

					if (palabras.containsKey(buscar)) {

						miVista.getTfPalabraTraducida().setText(palabras.get(buscar));
						encontrada = true;
					}
				} 
				else if (modo.equalsIgnoreCase("Inglés 🡆 Español")) {
					String buscar = miVista.getTfPalabraParaTraducir().getText().trim().toLowerCase();

					for (Map.Entry<String, String> entry : palabras.entrySet()) {
						if (entry.getValue().equalsIgnoreCase(buscar)) {
							miVista.getTfPalabraTraducida().setText(entry.getKey());
							encontrada = true;
						}
					}
				}

				if (!encontrada) {
					JOptionPane.showMessageDialog(null, "Palabra no encontrada", "ERROR", JOptionPane.ERROR_MESSAGE);
					miVista.getTfPalabraTraducida().setText("");
				}

			}
			catch (FileNotFoundException ex) {
				JOptionPane.showMessageDialog(null, "No se encuentra el archivo de diccionario");
			}
			catch (IOException ex) {
				System.out.println("Error de E/S");
			}
		}
	}

	/**
	 * Método para cambiar el idioma de la traducción
	 * @param e
	 */
	private void cambiarIdioma(ActionEvent e) {
		if (e.getSource().equals(miVista.getBotonCambiarIdioma()) && miVista.getlEtiquetaInfo().getText().equalsIgnoreCase("Español 🡆 Inglés")) {

			miVista.getlEtiquetaInfo().setText("Inglés 🡆 Español");
			miVista.getPanelEspanol().setBorder(new CompoundBorder(
					new TitledBorder("Inglés"), null));
			miVista.getPanelIngles().setBorder(new CompoundBorder(
					new TitledBorder("Español"), null));

			// De español a inglés
			String aux = miVista.getTfPalabraTraducida().getText(); // dog
			miVista.getTfPalabraTraducida().setText(miVista.getTfPalabraParaTraducir().getText()); // dog --> perro
			miVista.getTfPalabraParaTraducir().setText(aux); // perro --> dog
		}
		else if (e.getSource().equals(miVista.getBotonCambiarIdioma()) && miVista.getlEtiquetaInfo().getText().equalsIgnoreCase("Inglés 🡆 Español")) {

			miVista.getlEtiquetaInfo().setText("Español 🡆 Inglés");
			miVista.getPanelEspanol().setBorder(new CompoundBorder(
					new TitledBorder("Español"), null));
			miVista.getPanelIngles().setBorder(new CompoundBorder(
					new TitledBorder("Inglés"), null));

			// De inglés a español
			String aux = miVista.getTfPalabraParaTraducir().getText(); // perro
			miVista.getTfPalabraParaTraducir().setText(miVista.getTfPalabraTraducida().getText()); // perro --> dog
			miVista.getTfPalabraTraducida().setText(aux); // dog --> perro
		}
	}

	/**
	 * Método para añadir palabras al traductor
	 * @param e
	 */
	private void anadirPalabra(ActionEvent e) {
		if (e.getSource().equals(miVista.getBotonAnadirPalabra())) {

			if (miVista.getTfPalabraParaTraducir().getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Escribe la palabra que vas a añadir en el primer recuadro",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				String palabraPrincipal = miVista.getTfPalabraParaTraducir().getText();

				String palabraTraduccion = JOptionPane.showInputDialog(miVista, "Introduce la traducción de la palabra:", "Añadir palabra",
						JOptionPane.QUESTION_MESSAGE);

				Path ficheroTraductor = Path.of("./src/ejercicioo11/palabrasTraductor.txt");

				if (palabraTraduccion == null) {
					return;
				}

				try (BufferedWriter flujoEscritura = new BufferedWriter(
						new FileWriter(ficheroTraductor.toFile(),true))) {

					flujoEscritura.newLine();
					flujoEscritura.write(palabraPrincipal.toLowerCase());
					flujoEscritura.write("-");
					flujoEscritura.write(palabraTraduccion.toLowerCase());

					JOptionPane.showMessageDialog(miVista, "Palabra añadida");

				}
				catch (NullPointerException ex) {
					ex.printStackTrace();
				}
				catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

}
