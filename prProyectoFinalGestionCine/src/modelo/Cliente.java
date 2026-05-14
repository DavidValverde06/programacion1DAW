package modelo;

public class Cliente {

	/**
	 * Variables de instancia
	 */
	private int id_cliente; // PK
	private int id_sesion; // FK
	private String nombre;
	private String apellido;
	private String email;

	/**
	 * Constructor
	 */
	public Cliente(int codigo, int id_sesion, String nombre, String apellido, String email) {
		this.id_cliente = codigo;
		this.id_sesion = id_sesion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}

	/**
	 * Métodos Getter's y Setter's
	 */
	// Getter's
	public int getCodigo() {return id_cliente;}
	public int getId_sesion() {return id_sesion;}
	public String getNombre() {return nombre;}
	public String getApellido() {return apellido;}
	public String getEmail() {return email;}

	// Setter's
	public void setCodigo(int codigo) {this.id_cliente = codigo;}
	public void setId_sesion(int id_sesion) {this.id_sesion = id_sesion;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setApellido(String apellido) {this.apellido = apellido;}
	public void setEmail(String email) {this.email = email;}

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", id_sesion=" + id_sesion + ", nombre=" + nombre + ", apellido="
				+ apellido + ", email=" + email + "]";
	}
}
