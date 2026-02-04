package ejercicio3;

import java.util.Objects;

/**
 * 2. Definir la clase Libro que guardará la siguiente información sobre los libros de una biblioteca:
 * 	autor: String
 * 	titulo: String
 * 	estado: boolean (tomará el valor false si el libro está prestado y true si está en la biblioteca)
 * 
 * Definir un interfaz a la clase libro con los siguientes métodos:
 * 	✓ libro(String a, String t, boolean e). Constructor que inicializa los variables de instancia de
 * un objeto de la clase libro.
 * 	✓ Métodos get, set y toString.
 * 	✓ Método equals, dos libros serán iguales si coincide su título y su autor.
 * 
 * Una vez definido el interfaz, probarlo con el siguiente algoritmo: ...
 */

public class Libro implements Comparable<Libro>{

	/*
	 * Variables de instancia
	 */
	private String autor;
	private String titulo;
	private boolean estado;

	/*
	 * Constructor
	 */
	public Libro(String autor, String titulo, boolean estado) {
		this.autor = autor;
		this.titulo = titulo;
		this.estado = estado;
	}

	/*
	 * Getter's y setter's
	 */
	public String getAutor() {
		return autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public boolean getEstado() {
		return estado;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	/*
	 * Método toString
	 */
	@Override
	public String toString() {
		String estadoTexto = estado?"Disponible":"Prestado";
		return "Título del libro: " + this.titulo +
				"\nAutor: " + this.autor +
				"\nEstado: " + estadoTexto;
	}

	/**
	 * Método equals, dos libros serán iguales si coincide su título y su autor.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(autor, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return this.autor.equalsIgnoreCase(other.getAutor()) &&
			   this.titulo.equalsIgnoreCase(other.getTitulo());
	}

	@Override
	public int compareTo(Libro o) {
		int compara = this.getAutor().compareTo(o.getAutor());
		
		if (compara!=0) // Los autores son diferentes
			return compara;
		
		return this.getTitulo().compareTo(o.getTitulo());
	}
}
