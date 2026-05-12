package _09Scanner;

public class Persona {

	/**
	 * Variables de instancia
	 */
	private String nombre;
	private String dni;
	private int edad;
	
	
	/**
	 * Constructor
	 * @param nombre
	 * @param dni
	 * @param edad
	 */
	public Persona(String nombre, String dni, int edad) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
	}
	
	
	/**
	 * M�todos getter
	 */
	public String getNombre() {return nombre;}
	public String getDni() {return dni;}
	public int getEdad() {return edad;}
	
	/**
	 * M�todos setter
	 */
	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setDni(String dni) {this.dni = dni;}
	public void setEdad(int edad) {this.edad = edad;}


	/**
	 * Redefnici�n de toString
	 */
	@Override
	public String toString() {
		return nombre + ", con dni " + dni + ", y edad " + edad + " años";
	}
	
	
}
