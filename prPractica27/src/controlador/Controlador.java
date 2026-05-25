package controlador;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.*;
import java.util.regex.*;
import javax.swing.*;
import javax.swing.text.*;
import vista.*;

public class Controlador implements ActionListener, ItemListener {

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
	 * Método de la intefaz ItemListener (JComboBox)
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == miVista.getCbTamanioLetra()) {
			Integer seleccionado = (Integer) miVista.getCbTamanioLetra().getSelectedItem();
			miVista.getTaAreaCentral().setFont(new Font(miVista.getTaAreaCentral().getFont().getName(),
					miVista.getTaAreaCentral().getFont().getStyle(),seleccionado));
		}
		else if (e.getSource() == miVista.getCbFuente()) {
			String seleccionado = (String) miVista.getCbFuente().getSelectedItem();
			miVista.getTaAreaCentral().setFont(new Font(seleccionado,miVista.getTaAreaCentral().getFont().getStyle(),
					miVista.getTaAreaCentral().getFont().getSize()));
		}
	}

	/**
	 * Método de la interfaz ActionListener (JButton)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case "Nuevo":
			miVista.getTaAreaCentral().setFont(new Font(miVista.getTaAreaCentral().getFont().getName(), Font.PLAIN, 12));
			miVista.getTaAreaCentral().setBackground(Color.WHITE);
			miVista.getTaAreaCentral().setForeground(Color.BLACK);
			miVista.getTaAreaCentral().setText("");
			miVista.getTfTextoBuscar().setText("");
			miVista.getCbFuente().setSelectedIndex(0);
			miVista.getCbTamanioLetra().setSelectedIndex(2);
			break;


		case "Abrir":
			abrir();
			break;


		case "Guardar":
			guardar();
			break;


		case "Guardar como":
			guardarComo();
			break;


		case "Salir":
			int opcion = JOptionPane.showConfirmDialog(miVista, "¿Quieres salir del programa?");
			if (opcion == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
			else {
				JOptionPane.showMessageDialog(null, "Operación cancelada");
			}
			break;


		case "Cortar":
			miVista.getTaAreaCentral().cut();
			break;


		case "Copiar":
			miVista.getTaAreaCentral().copy();
			break;


		case "Pegar":
			miVista.getTaAreaCentral().paste();
			break;


		case "Negrita":
			miVista.getTaAreaCentral().setFont(new Font(miVista.getTaAreaCentral().getFont().getName(),
					Font.BOLD, miVista.getTaAreaCentral().getFont().getSize()));
			break;


		case "Itálica":
			miVista.getTaAreaCentral().setFont(new Font(miVista.getTaAreaCentral().getFont().getName(),
					Font.ITALIC, miVista.getTaAreaCentral().getFont().getSize()));
			break;


		case "Cursiva":
			miVista.getTaAreaCentral().setFont(new Font(miVista.getTaAreaCentral().getFont().getName(),
					Font.ITALIC, miVista.getTaAreaCentral().getFont().getSize()));
			break;


		case "Normal":
			miVista.getTaAreaCentral().setFont(new Font(miVista.getTaAreaCentral().getFont().getName(),
					Font.PLAIN, miVista.getTaAreaCentral().getFont().getSize()));
			break;


		case "Muy pequeño":
			miVista.getTaAreaCentral().setFont(new Font(miVista.getTaAreaCentral().getFont().getName(),
					miVista.getTaAreaCentral().getFont().getStyle(), 8));
			break;


		case "Pequeño":
			miVista.getTaAreaCentral().setFont(new Font(miVista.getTaAreaCentral().getFont().getName(),
					miVista.getTaAreaCentral().getFont().getStyle(), 10));
			break;


		case"Tamaño normal":
			miVista.getTaAreaCentral().setFont(new Font(miVista.getTaAreaCentral().getFont().getName(),
					miVista.getTaAreaCentral().getFont().getStyle(), 12));
			break;


		case "Grande":
			miVista.getTaAreaCentral().setFont(new Font(miVista.getTaAreaCentral().getFont().getName(),
					miVista.getTaAreaCentral().getFont().getStyle(), 16));
			break;


		case "Muy grande":
			miVista.getTaAreaCentral().setFont(new Font(miVista.getTaAreaCentral().getFont().getName(),
					miVista.getTaAreaCentral().getFont().getStyle(), 20));
			break;


		case "AumentarTamanio":
			miVista.getTaAreaCentral().setFont(new Font(miVista.getTaAreaCentral().getFont().getName(),
					miVista.getTaAreaCentral().getFont().getStyle(),miVista.getTaAreaCentral().getFont().getSize()+1));
			break;


		case "DisminuirTamanio":
			miVista.getTaAreaCentral().setFont(new Font(miVista.getTaAreaCentral().getFont().getName(),
					miVista.getTaAreaCentral().getFont().getStyle(),miVista.getTaAreaCentral().getFont().getSize()-1));
			break;


		case "Pasar texto a mayúsculas":
			miVista.getTaAreaCentral().setText(miVista.getTaAreaCentral().getText().toUpperCase());
			break;


		case "Pasar texto a minúsculas":
			miVista.getTaAreaCentral().setText(miVista.getTaAreaCentral().getText().toLowerCase());
			break;


		case "CambiarColorFondo":
			cambiarColorFondo();
			break;


		case "CambiarColorFuente":
			cambiarColorFuente();
			break;


		case "Buscar":
			buscaTexto();
			break;


		case "Limpiar":
			limpiarTexto();
			break;
		}
	}

	private void abrir() {
		JFileChooser fichero = new JFileChooser();
		int resultado = fichero.showOpenDialog(null);

		if (resultado == JFileChooser.APPROVE_OPTION) {
			File archivo = fichero.getSelectedFile();
			// String ruta = archivo.getAbsolutePath();

			try (BufferedReader flujoLectura = new BufferedReader(new FileReader(archivo))) {
				miVista.getTaAreaCentral().setText(flujoLectura.readAllAsString());
			}
			catch (FileNotFoundException ex) {
				ex.printStackTrace();
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Operación cancelada");
		}
	}

	private void guardar() {
		String nombreFichero = JOptionPane.showInputDialog("Escriba el nombre del fichero");

		try (BufferedWriter flujoEscritura = new BufferedWriter(new FileWriter(new File("./src/" + nombreFichero)))) {
			flujoEscritura.write(miVista.getTaAreaCentral().getText());
			JOptionPane.showMessageDialog(null, "Archivo guardado");
		}
		catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "Error, no se pudo guardar el fichero correctamente");
		}
	}

	private void guardarComo() {
		JFileChooser ficheroGuardar = new JFileChooser();
		int resultadoGuardar = ficheroGuardar.showSaveDialog(null);

		if (resultadoGuardar == JFileChooser.APPROVE_OPTION) {
			File archivo = ficheroGuardar.getSelectedFile();
			// String ruta = archivo.getAbsolutePath();

			try (BufferedWriter flujoEscritura = new BufferedWriter(new FileWriter(new File(archivo.toString())))) {
				flujoEscritura.write(miVista.getTaAreaCentral().getText());
				JOptionPane.showMessageDialog(null, "Archivo guardado");
			}
			catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "Error, no se pudo guardar el fichero correctamente");
			}
		}
	}

	private void cambiarColorFondo() {
		Color colorSeleccionadoFondo = JColorChooser.showDialog(miVista.getTaAreaCentral(), "Elija un color", Color.WHITE);
		if (colorSeleccionadoFondo!=null) {
			miVista.getTaAreaCentral().setBackground(colorSeleccionadoFondo);
		}
	}

	private void cambiarColorFuente() {
		Color colorSeleccionadoFuente = JColorChooser.showDialog(miVista.getTaAreaCentral(), "Elija un color", Color.WHITE);
		if (colorSeleccionadoFuente!=null) {
			miVista.getTaAreaCentral().setForeground(colorSeleccionadoFuente);
		}
	}

	private void limpiarTexto() {
		JTextArea area = miVista.getTaAreaCentral();
		Highlighter h = area.getHighlighter();
		h.removeAllHighlights();
		miVista.getTfTextoBuscar().setText("");
	}

	private void buscaTexto() {
		JTextArea area = miVista.getTaAreaCentral();
		String textoBuscado = miVista.getTfTextoBuscar().getText();

		if (textoBuscado.length() >= 1) {
			// Highlighter --> Esta clase nos ayuda a resaltar texto,
			DefaultHighlighter.DefaultHighlightPainter highlightPainter =
					new DefaultHighlighter.DefaultHighlightPainter(Color.LIGHT_GRAY);

			Highlighter h = area.getHighlighter();
			h.removeAllHighlights(); // Borrar lo que hubiese resaltado
			// Creamos un objeto correspondiente a un determinado patrón (expresión regular)
			// que queremos utilizar en la búsqueda

			Pattern patron = Pattern.compile(textoBuscado);
			// La clase Matcher nos permite comprobar si una determinada cadena de texto
			// cumple con la expresión regular

			Matcher m = patron.matcher(area.getText());
			while (m.find()) { 	// Vamos iterando por el objeto Matcher, buscando la
				// la expresión regular (texto buscado en este caso), y
				// resaltándolo con start() y end()
				try {
					h.addHighlight(m.start(), m.end(), highlightPainter);
				}
				catch (BadLocationException ex) {
					Logger.getLogger(Color.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
		else {
			JOptionPane.showMessageDialog(area, "Indique el texto a buscar");
		}
	}

}
