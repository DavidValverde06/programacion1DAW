package controlador;

import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import modelo.*;
import vista.*;

public class Controlador implements ActionListener, FocusListener {

	/**
	 * Variables de instancia
	 */
	private Vista miVista;
	private Biblioteca miBiblio;

	/**
	 * Constructor
	 */
	public Controlador(Vista miVista) {
		this.miVista = miVista;
		this.miBiblio = miVista.getDialogo().getMiBiblio();

		// Cargar JTextArea y JComboBox Libros
		for (Libro libro : miBiblio.getLibrosDisponibles()) {
			miVista.getTaAreaLibros().append(libro.toString() + "\n");
			miVista.getCbListadoLibrosPrestar().addItem(libro.getTitulo());
		}

		// Cargar JComboBox Clientes
		for (Usuario usuario : miBiblio.getUsuariosBiblioteca()) {
			miVista.getCbListadoClientesPrestar().addItem(usuario.getNombreUsuario());
			miVista.getCbListadoClientesDevolver().addItem(usuario.getNombreUsuario());
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 1º pestaña
		if (e.getSource()==miVista.getbAnadirLibro()) {
			botonAnadirLibros();
		}
		else if (e.getSource()==miVista.getbCancelarLibro()) {
			miVista.getTfCodigo().setText("");
			miVista.getTfTitulo().setText("");
			miVista.getTfEscritor().setText("");
			miVista.getTaAreaPersonajes().setText("<Nombre personajes separados\npor líneas>");
		}

		// 2º pestaña
		if (e.getSource()==miVista.getbAnadirCliente()) {
			botonAnadirClientes();
		}
		else if (e.getSource()==miVista.getbCancelarCliente()) {
			miVista.getTfNombreCliente().setText("");
		}

		// 3º pestaña
		if (e.getSource()==miVista.getbActualizarLista()) {
			miVista.getTaAreaLibros().setText("");
			for (Libro libro : miBiblio.getLibrosDisponibles()) {
				miVista.getTaAreaLibros().append(libro.toString() + "\n");
			}
		}

		// 4º pestaña
		if (e.getSource()==miVista.getbPrestar()) {
			String clientePrestar = miVista.getCbListadoClientesPrestar().getSelectedItem().toString();
			String libroPrestar = miVista.getCbListadoLibrosPrestar().getSelectedItem().toString();
			String usuario;
			if (miBiblio.prestarLibro(libroPrestar, clientePrestar) == true) {
				miVista.getCbListadoLibrosPrestar().removeItem(libroPrestar);
				miVista.getCbListadoLibrosDevolver().removeAllItems();
				usuario = miVista.getCbListadoClientesDevolver().getSelectedItem().toString();
				for (Libro libroUsuario : miBiblio.getLibrosUsuario(usuario)) {
					miVista.getCbListadoLibrosDevolver().addItem(libroUsuario.getTitulo());
				}
				JOptionPane.showMessageDialog(miVista, "El libro " + libroPrestar + " se ha prestado al cliente " + clientePrestar, "Préstamo de libros", 1);
			}
			else {
				JOptionPane.showMessageDialog(miVista, "No se ha podido prestar el libro seleccionado", "Error al prestar libro", 0);
			}
		}
		else if (e.getSource()==miVista.getbCancelarPrestar()) {
			miVista.getCbListadoClientesPrestar().setSelectedIndex(0);
			miVista.getCbListadoLibrosPrestar().setSelectedIndex(0);
		}

		// 5º pestaña
		if (e.getSource()==miVista.getbDevolver()) {
			String clienteDevolver = miVista.getCbListadoClientesDevolver().getSelectedItem().toString();
			String libroDevolver = miVista.getCbListadoLibrosDevolver().getSelectedItem().toString();
			if (miBiblio.devolverLibro(libroDevolver, clienteDevolver) == true) {
				miVista.getCbListadoLibrosDevolver().removeItem(libroDevolver);
				for (Libro libro : miBiblio.getLibrosDisponibles()) {
					miVista.getCbListadoLibrosPrestar().addItem(libro.getTitulo());
				}
				JOptionPane.showMessageDialog(miVista, "El libro " + libroDevolver + " ha sido devuelto", "Devolución de libros", 1);
			}
			else {
				JOptionPane.showMessageDialog(miVista, "No se ha podido devolver el libro seleccionado", "Error al devolver libro", 0);
			}
		}
		else if (e.getSource()==miVista.getbCancelarDevolver()) {
			miVista.getCbListadoClientesDevolver().setSelectedIndex(0);
			miVista.getCbListadoLibrosDevolver().setSelectedIndex(0);
		}

		// Rellenar JComboBox de los libros de los clientes
		if (e.getSource()==miVista.getCbListadoClientesDevolver()) {
			miVista.getCbListadoLibrosDevolver().removeAllItems();
			String usuario = miVista.getCbListadoClientesDevolver().getSelectedItem().toString();
			for (Libro libroUsuario : miBiblio.getLibrosUsuario(usuario)) {
				miVista.getCbListadoLibrosDevolver().addItem(libroUsuario.getTitulo());
			}
		}
	}

	private void botonAnadirClientes() {
		String nombreCliente = miVista.getTfNombreCliente().getText();
		Usuario usuarioAnadir = new Usuario(nombreCliente);

		if (nombreCliente.isBlank()) {
			JOptionPane.showMessageDialog(miVista, "Escribe el usuario que quieras añadir", "Error al añadir cliente", 0);
		}
		else {
			if (miBiblio.altaUsuario(usuarioAnadir) == true) {
				miVista.getCbListadoClientesPrestar().addItem(usuarioAnadir.getNombreUsuario());
				miVista.getCbListadoClientesDevolver().addItem(usuarioAnadir.getNombreUsuario());
				miVista.getTfNombreCliente().setText("");
				JOptionPane.showMessageDialog(miVista, "Cliente añadido a la biblioteca", "Añadir clientes", 1);
			}
			else {
				JOptionPane.showMessageDialog(miVista, "El usuario " + nombreCliente + " ya se encuentra registrado", "Error al añadir cliente", 0);
			}
		}
	}

	private void botonAnadirLibros() {
		try {
			DecimalFormat formateador = new DecimalFormat("0000");
			String codigo = miVista.getTfCodigo().getText();

			codigo = formateador.format(Integer.valueOf(codigo));

			String titulo = miVista.getTfTitulo().getText();
			String escritor = miVista.getTfEscritor().getText();
			ArrayList<String> listaPersonajes = new ArrayList<>(Arrays.asList(miVista.getTaAreaPersonajes().getText().split("\n")));

			if (titulo.isBlank() || escritor.isBlank()) {
				throw new NumberFormatException();
			}
			else {
				Libro libroAnadir = new Libro(codigo, titulo, escritor, listaPersonajes);
				if (miBiblio.altaLibro(libroAnadir) == true) {
					miVista.getCbListadoLibrosPrestar().addItem(libroAnadir.getTitulo());
					miVista.getTfCodigo().setText("");
					miVista.getTfTitulo().setText("");
					miVista.getTfEscritor().setText("");
					miVista.getTaAreaPersonajes().setText("<Nombre personajes separados\npor líneas>");
					JOptionPane.showMessageDialog(miVista, "Libro añadido a la biblioteca", "Añadir libros", 1);
				}
				else {
					JOptionPane.showMessageDialog(miVista, "El código " + codigo + " ya se encuentra registrado", "Error al añadir libros", 0);
				}
			}
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(miVista, "Rellena los datos del libro a añadir", "Error", 0);
		}
	}

	@Override
	public void focusGained(FocusEvent e) {  // Foco ganado
		JTextArea campoSeleccionado = ((JTextArea)e.getSource());

		if (campoSeleccionado.getText().equals("<Nombre personajes separados\npor líneas>"))				
			campoSeleccionado.setText("");
	}

	public void focusLost(FocusEvent e) {   // Foco perdido
		JTextArea tfActivo = (JTextArea)(e.getSource());

		if (tfActivo.getText().equals(""))				
			tfActivo.setText("<Nombre personajes separados\npor líneas>");
	}

}
