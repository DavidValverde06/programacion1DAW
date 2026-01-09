package arraysObjeto;

/**
 * 17.- Crea una clase Alumno, con información sobre su nombre y su nota media. A continuación define un
 * array de seis alumnos y rellénalo solicitando los datos por teclado. Por último, muestra los datos de los
 * alumnos por pantalla, así como el nombre y la nota del alumno que tiene la nota media más alta.
 */

public class Alumno {

	sin hacer
	
	/**
	 * Variables de instancia
	 */
	private String nombre;
	private float notaMedia;
	
	/**
	 * Constructor
	 */
	public Alumno(String nombre, float notaMedia) {
		this.nombre = nombre;
		this.notaMedia = notaMedia;
	}
	/**
	 * Getter's y setter's
	 */
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getNotaMedia() {
		return notaMedia;
	}
	public void setNotaMedia(float notaMedia) {
		this.notaMedia = notaMedia;
	}
	
	
	public static void main(String[] args) {
		
		String[] arrayAlumnos = new String[6];
		
		
	}
}
