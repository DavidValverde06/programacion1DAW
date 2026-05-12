package controlador;
/**
 * Clase que va a programar los eventos
 * 
 */

import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

import fechas.LibFechas8;
import modelo.*;
import vista.*;


public class Controlador extends WindowAdapter
				         implements ActionListener, MouseListener {

	/**
	 * Variables de instancia
	 */
	private Vista miVista;
	private DAODisco miModelo;
	
	/**
	 * Constructor
	 */
	public Controlador(Vista v) {
		miVista = v;
		
		try {
			// Crear el modelo
			miModelo = new DAODisco();
		    	
			// Mostrar el primer disco
			this.muestraDisco(miModelo.getPrimero());
		}
		catch (SQLException e) {
			JOptionPane.showMessageDialog(miVista, "Problema SQL");
			System.exit(0);
		}
		catch (NullPointerException e) {
			JOptionPane.showMessageDialog(miVista, "Problema al cargar la BD");
			System.exit(0);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(miVista, "El programa se debe reiniciar");
			e.printStackTrace();
		}
	}

	
	/**
	 * Método de la clase WindowsAdapter
	 */
	public void windowClosing(WindowEvent e) {
		
		try {
			miModelo.cierraStatement();
			miModelo.cierraConexion();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.exit(0);
	}
	
	/**
	 * Método de la interfaz ActionListener
	 */
	public void actionPerformed(ActionEvent arg0) {
		
		if (arg0.getSource()==miVista.getbNuevo())
			procesoNuevo();
		else if (arg0.getSource()==miVista.getbGuardar())
			procesoGuardar();
		else if (arg0.getSource()==miVista.getbCancelar())
			procesoCancelar();
		else if (arg0.getSource()==miVista.getbModificar())
			procesoModificar();
		else if (arg0.getSource()==miVista.getbEliminar())
			procesoEliminar();
		else // Opción de menú
			try {
				new Consulta1(miModelo.datosConsulta1());
		//		new Consulta2(miModelo.datosConsulta2());
			}
			catch (SQLException e1) {
				//e1.printStackTrace();
				JOptionPane.showMessageDialog(miVista, "Problema al crear la consulta");
			}	
	}
	
	
	/**
	 * Métodos de la interfaz MouseListener
	 *    En el método mouseClicked programaremos los botones de
	 *    navegación por las distintas tuplas
	 */
	public void mouseClicked(MouseEvent arg0) {
		JButton botonPulsado = (JButton)arg0.getSource();
		
		// Controlamos que si los botones estaban deshabilitados
		// que no haga nada
		if (!botonPulsado.isEnabled()) return;
		
		try {
			if (botonPulsado.getActionCommand().equals("Primero"))
				this.muestraDisco(miModelo.getPrimero());	
			else if (botonPulsado.getActionCommand().equals("Anterior"))
				this.muestraDisco(miModelo.getAnterior());
			else if (botonPulsado.getActionCommand().equals("Siguiente"))
				this.muestraDisco(miModelo.getSiguiente());
			else  // Ultimo
				this.muestraDisco(miModelo.getUltimo());
		}
		catch (MiExcepcion e) {
			JOptionPane.showMessageDialog(miVista, e.getMessage());
		}
		catch (SQLException e) {
			
		//	System.out.println("Estoy en siguiente - anterior");
			
			try {
				// Si se ha pulsado el boton "Siguiente" o el boton "Anterior"
				// y se ha producido una excepcion, es porque no puede avanzar 
				// en la direccion que lo intenta ya que no hay mas registros. 
				// 
				// Para evitar que avance o retroceda de forma  "ficticia", y se 
				// quede donde estamos hacemos lo que viene a continuacion.
				// 
				// Problema: si por ejemplo el ultimo es el 7 y estando en el le 
				// doy 3 veces a "siguiente", despues tendra que pulsar otras 3 veces
				// para poder retroceder. Con el siguiente arreglo esto no sucedera.
				if (botonPulsado.getActionCommand().equals("Siguiente"))
					miModelo.getAnterior();
				else if (botonPulsado.getActionCommand().equals("Anterior"))
					miModelo.getSiguiente();
			}
			catch (MiExcepcion e1) {
				JOptionPane.showMessageDialog(miVista, e1.getMessage());
			}
			catch (SQLException e1) {
				miModelo.printSQLException(e);
				JOptionPane.showMessageDialog(miVista, "Problema SQL");
			}
			
		}
				
	}
	
	
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
	
	
	/**
	 * -----------------------------------------------------------------
	 * 			Metodos privados del controlador
	 * -----------------------------------------------------------------
	 */
	
	/**
	 * Método que muetra los datos de un disco en el formulario 
	 */
	private void muestraDisco(Disco ob) {
		
		miVista.getTfCodigo().setText(Integer.toString(ob.getCodigo()));
		miVista.getTfTitulo().setText(ob.getTitulo());
		miVista.getTfAutor().setText(ob.getAutor());
		miVista.gettfFechaPubli().setText(LibFechas8.getFechaShort(ob.getFechaPubli()));
		miVista.getTfPrecio().setText(Double.toString(ob.getPrecio()));
	}
	
	
	/**
	 * Método que permite añadir un nuevo disco
	 */
	private void procesoNuevo() {
		
		// Habilitar/Deshabilitar los botones de operaciones
		miVista.getbNuevo().setEnabled(false);
		miVista.getbGuardar().setEnabled(true);
		miVista.getbModificar().setEnabled(false);
		miVista.getbEliminar().setEnabled(false);
		miVista.getbCancelar().setEnabled(true);
		
		activacionAvance(false);
		activacionEntradaDatos(true);
		limpiarEntradaDatos();
	}
	
	/**
	 * Método que activa/desactiva los botones de avance
	 */
	private void activacionAvance(boolean estado) {
		
		miVista.getbPrimero().setEnabled(estado);
		miVista.getbSiguiente().setEnabled(estado);
		miVista.getbAnterior().setEnabled(estado);
		miVista.getbUltimo().setEnabled(estado);
	}
	
	/**
	 * Habilita o deshabilita los campos de texto de entrada de datos
	 */
	public void activacionEntradaDatos(boolean estado)
	{
		miVista.getTfCodigo().setEditable(estado);
		miVista.getTfAutor().setEditable(estado);
		miVista.getTfTitulo().setEditable(estado);
		miVista.gettfFechaPubli().setEditable(estado);
		miVista.getTfPrecio().setEditable(estado);
	}
	
	/**
	 * Limpia los textField de entrada de datos
	 */
	public void limpiarEntradaDatos()
	{
		miVista.getTfCodigo().setText("");
		miVista.getTfAutor().setText("");
		miVista.getTfTitulo().setText("");
		miVista.gettfFechaPubli().setText("");
		miVista.getTfPrecio().setText("");
	}
	
	/**
	 * Este metodo permitira guardar o modificar un disco
	 */
	private void procesoGuardar() {
		try {
			// Crearnos un objeto tipo Disco con los datos que hay en el formulario
			Disco miDisco = new Disco(
					Integer.parseInt(miVista.getTfCodigo().getText()),
					miVista.getTfTitulo().getText(),
					miVista.getTfAutor().getText(),
					miVista.gettfFechaPubli().getText(),
					Double.parseDouble(miVista.getTfPrecio().getText()));
			
			if (miVista.getbGuardar().getText().equals("Guardar")) { // Alta de nuevo disco
				miModelo.insertaDisco(miDisco);
				JOptionPane.showMessageDialog(miVista,"Disco almacenado");
			}
			else {  // Modificación de disco
				miModelo.modificaDisco(miDisco);
				JOptionPane.showMessageDialog(miVista,"Disco modificado");
			}
			
			procesoCancelar(); 
		}
		catch (SQLException e) {
			//miModelo.printSQLException(e);
			JOptionPane.showMessageDialog(miVista, "Error al grabar los datos, puede\n"
											     + "que los datos ya existan.\n"
											     + "Compruebe que el código del disco no exista.");
			try { // Si se produce una excepcion cierra la consulta
				miModelo.crearConsulta();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(miVista, "Datos erróneos");
		}
		catch (MiExcepcion e) {
			JOptionPane.showMessageDialog(miVista, "Fecha errónea\nFormato válido dd/mm/aaaa");
		}
		
	}
	
	/**
	 * Este metodo se encarga de dejar el formulario como estaba al principio
	 */
	private void procesoCancelar() {
		try {
			this.muestraDisco(miModelo.getPrimero());
		}
		catch (MiExcepcion e) {
			JOptionPane.showMessageDialog(miVista, e.getMessage());
		}
		catch (SQLException e) {
			//miModelo.printSQLException(e);
			JOptionPane.showMessageDialog(miVista, "Problema SQL");
		}
		
		activacionAvance(true);   // Activar los botones de avance
		activacionEntradaDatos(false);  // Poner no editables los JTextField
		
		// Habilitar/Deshabilitar los botones de operaciones
		miVista.getbNuevo().setEnabled(true);
		miVista.getbGuardar().setEnabled(false);
		miVista.getbModificar().setEnabled(true);
		miVista.getbEliminar().setEnabled(true);
		miVista.getbCancelar().setEnabled(true);
		
		// Cambiar el texto al boton "Guardar" por si tenia "Guardar Cambios"
		miVista.getbGuardar().setText("Guardar");
	}
	
	
	/**
	 * Método que prepara la apliacion para modificar
	 */
	private void procesoModificar() {
		
		// Habilitar/Deshabilitar los botones de operaciones
		miVista.getbNuevo().setEnabled(false);
		miVista.getbGuardar().setEnabled(true);
		miVista.getbModificar().setEnabled(false);
		miVista.getbEliminar().setEnabled(false);
		miVista.getbCancelar().setEnabled(true);
		
		activacionAvance(false);  // Desactivar botones de avance
		activacionEntradaDatos(true);  // Poner editables los JTextField
		miVista.getTfCodigo().setEditable(false);  // Poner no editable el codigo
		miVista.getbGuardar().setText("Guardar cambios");
	}
	
	
	/**
	 * Método que permite porder eliminar un disco
	 */
	private void procesoEliminar() {
		
		int resp = JOptionPane.showConfirmDialog(
				miVista, 
				"¿Está seguro de querer elimnar el disco actual?");
		if (resp==JOptionPane.YES_OPTION) {
			try {
				miModelo.eliminaDisco(Integer.parseInt(miVista.getTfCodigo().getText()));
				JOptionPane.showMessageDialog(miVista, "El disco ha sido borrado");
				procesoCancelar();
			}
			catch(SQLException e) {
			//	miModelo.printSQLException(e);
				JOptionPane.showMessageDialog(miVista, "Error al borrar los datos");
			}
		}
		else {
			JOptionPane.showMessageDialog(miVista, "Eliminación cancelada");
		}
	}
}
