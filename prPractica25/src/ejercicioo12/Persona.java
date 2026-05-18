package ejercicioo12;

import java.io.Serializable;

public class Persona implements Serializable{

	private static final long serialVersionUID = -3210185430730009955L;
	
	/**
	 * Variables de instancia
	 */
	private String nombre;
	private String apellido;
	private String telefono;

	/**
	 * Constructor
	 */
	public Persona(String nombre, String apellido, String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}

	/**
	 * Getter's y setter's
	 */
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return nombre + "," + apellido + "," + telefono;
	}
}
