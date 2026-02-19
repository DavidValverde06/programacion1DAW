package ejerClase;

import java.text.DecimalFormat;
import java.util.Objects;

public class Alumno implements Comparable<Alumno> {

	/**
	 * Variables de instancia
	 */
	private String nombre, apellido;
	private float nota1, nota2, nota3;

	/**
	 * Constructor
	 */
	public Alumno(String nombre, String apellido, float nota1, float nota2, float nota3) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
	}

	/**
	 * Método que calcula la nota media del alumno
	 */
	public float getNotaMedia() {
		return (this.nota1+this.nota2+this.nota3)/3.0f;
	}

	/**
	 * Métodos getter's and setter's
	 */
	public String getNombre() {return nombre;}
	public String getApellido() {return apellido;}
	public float getNota1() {return nota1;}
	public float getNota2() {return nota2;}
	public float getNota3() {return nota3;}

	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setApellido(String apellido) {this.apellido = apellido;}
	public void setNota1(float nota1) {this.nota1 = nota1;}
	public void setNota2(float nota2) {this.nota2 = nota2;}
	public void setNota3(float nota3) {this.nota3 = nota3;}

	/**
	 * Redefinición de toString
	 */
	@Override
	public String toString() {
		DecimalFormat ob = new DecimalFormat("0.00"); // Objeto para formatear la salida con 2 decimales
		return this.apellido + ", " + this.nombre + " (" + ob.format(this.getNotaMedia()) + ")\n";
	}

	@Override
	public int compareTo(Alumno o) {
		int compara = this.getApellido().compareTo(o.getApellido());
		if (compara!=0) {
			return compara;
		}
		
		int compara = this.getApellido().compareTo(o.getApellido());
		if (compara!=0) {
			return compara;
		}
		
		return this.nombre.compareTo(o.getNombre());
	}

	

	/**
	 * hashCode / equals
	 */
	@Override
	public int hashCode() {
		return Objects.hash(apellido, nombre, getNotaMedia());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(nombre, other.nombre) && this.getNotaMedia() == other.getNotaMedia();
	}

}
