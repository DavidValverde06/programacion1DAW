package claseObjects;

import java.util.Objects;

public class Persona {

	/**
	 * Variables de instancia
	 */
	private String nombre;
	private int edad;
	
	/**
	 * Constructor
	 * @param nombre
	 * @param edad
	 */
	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}
	
	/**
	 * Métodos getter's and setter's
	 */
	public String getNombre() {return nombre;}
	public int getEdad() {return edad;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setEdad(int edad) {this.edad = edad;}
	
	/**
	 * Redefinición de toString
	 */
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	/**
	 * Redefinición de hashCode e equals
	 */
	@Override
	public int hashCode() {
		return Objects.hash(edad, nombre);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return edad == other.edad && Objects.equals(nombre, other.nombre);
	}
	
	
}
