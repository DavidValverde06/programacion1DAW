package arraysObjeto;

import java.util.Objects;

/**
 * 17.- Crea una clase Alumno, con información sobre su nombre y su nota media. A continuación define un
 * array de seis alumnos y rellénalo solicitando los datos por teclado. Por último, muestra los datos de los
 * alumnos por pantalla, así como el nombre y la nota del alumno que tiene la nota media más alta.
 */
public class Alumno2 {
	/**
	 * Variables de instancia
	 */
	private String nombre;
	private int edad;

	/**
	 * Constructor
	 */
	public Alumno2(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	/**
	 * Getter's y setter's
	 */
	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return this.nombre + " (" + this.edad + ")\n";
	}

	/**
	 * equals y hashCode
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
		Alumno2 other = (Alumno2) obj;
		return edad == other.edad && Objects.equals(nombre, other.nombre);
	}
}
