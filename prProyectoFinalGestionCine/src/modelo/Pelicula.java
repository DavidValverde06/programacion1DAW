package modelo;

public class Pelicula {

	/**
	 * Variables de instancia
	 */
	private String titulo;
	private EnumGenero genero;
	private int duracion; // En minutos
	private EnumClasificacion clasificacion;
	private String director;
	private int anio;

	/**
	 * Constructor
	 */
	public Pelicula(String titulo, EnumGenero genero, int duracion, EnumClasificacion clasificacion, String director, int anio) {
		this.titulo = titulo;
		this.genero = genero;
		this.duracion = duracion;
		this.clasificacion = clasificacion;
		this.director = director;
		this.anio = anio;
	}

	/**
	 * Métodos Getter's y Setter's
	 */
	// Getter's
	public String getTitulo() {return titulo;}
	public EnumGenero getGenero() {return genero;}
	public int getDuracion() {return duracion;}
	public EnumClasificacion getClasificacion() {return clasificacion;}
	public String getDirector() {return director;}
	public int getAnio() {return anio;}

	// Setter's
	public void setTitulo(String titulo) {this.titulo = titulo;}
	public void setGenero(EnumGenero genero) {this.genero = genero;}
	public void setDuracion(int duracion) {this.duracion = duracion;}
	public void setClasificacion(EnumClasificacion clasificacion) {this.clasificacion = clasificacion;}
	public void setDirector(String director) {this.director = director;}
	public void setAnio(int anio) {this.anio = anio;}

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return titulo + "\nGenero: " + genero + "\nDuracion en minutos: " + duracion + " minutos\nClasificación por edades: "
				+ clasificacion + "\nDirector: " + director + "\nAño de estreno: " + anio;
	}
}
