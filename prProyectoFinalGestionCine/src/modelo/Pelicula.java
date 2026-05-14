package modelo;

import java.util.Objects;

public class Pelicula {

	/**
	 * Variables de instancia
	 */
	private int id_pelicula; // PK
	private String titulo;
	private EnumGenero genero;
	private int duracion; // En minutos
	private EnumClasificacion clasificacion;
	private String director;
	private int anio;

	/**
	 * Constructor
	 */
	public Pelicula(int codigo, String titulo, EnumGenero genero, int duracion,
			EnumClasificacion clasificacion, String director, int anio) {
		this.id_pelicula = codigo;
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
	public int getCodigo() {return id_pelicula;}
	public String getTitulo() {return titulo;}
	public EnumGenero getGenero() {return genero;}
	public int getDuracion() {return duracion;}
	public EnumClasificacion getClasificacion() {return clasificacion;}
	public String getDirector() {return director;}
	public int getAnio() {return anio;}

	// Setter's
	public void setCodigo(int codigo) {this.id_pelicula = codigo;}
	public void setTitulo(String titulo) {this.titulo = titulo;}
	public void setGenero(EnumGenero genero) {this.genero = genero;}
	public void setDuracion(int duracion) {this.duracion = duracion;}
	public void setClasificacion(EnumClasificacion clasificacion) {this.clasificacion = clasificacion;}
	public void setDirector(String director) {this.director = director;}
	public void setAnio(int anio) {this.anio = anio;}

	/**
	 * equals y hashCode
	 */
	@Override
	public int hashCode() {
		return Objects.hash(anio, clasificacion, director, duracion, genero, id_pelicula, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		return anio == other.anio && clasificacion == other.clasificacion && Objects.equals(director, other.director)
				&& duracion == other.duracion && genero == other.genero && id_pelicula == other.id_pelicula
				&& Objects.equals(titulo, other.titulo);
	}

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return "Pelicula [id_pelicula=" + id_pelicula + ", titulo=" + titulo + ", genero=" + genero + ", duracion="
				+ duracion + ", clasificacion=" + clasificacion + ", director=" + director + ", anio=" + anio + "]";
	}

}
