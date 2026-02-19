package ejerClase;

import java.util.*;

public class Grupo {

	/**
	 * Variables de clase
	 */
	String [] arrayNombres = {"Juan", "María", "Sara", "Luis", "Francisco", "Victor", 
			"Ismael", "Noelia", "Andrés", "Silvia", "Samuel", "Natalia"};

	String [] arrayApellidos = {"García", "González", "Moreno", "Lobato", "Cuesta", "Jiménez",
			"Montilla", "Pozo", "Alarcón", "Ruiz", "López", "Figueroa", "Rico"};

	/**
	 * Variables de instancia
	 */
	private int numAleatorio;
	private List<Alumno> listaAlumnos;

	/**
	 * Constructor
	 */
	public Grupo(int numAleatorio) {
		this.numAleatorio = numAleatorio;
		this.listaAlumnos = new ArrayList<>();

		for (int cont=0;cont<50;cont++) {

			float notas = (float)(Math.random()*10)+1; // Notas aleatorias entre 1 y 10			
			String nombre=arrayNombres[(int)(Math.random()*arrayNombres.length)];
			String apellido=arrayApellidos[(int)(Math.random()*arrayApellidos.length)];

			Alumno alumnoRandom = new Alumno(nombre, apellido, notas, notas, notas);
			listaAlumnos.add(alumnoRandom);
		}
	}

	/**
	 * Getter's y setter's
	 */
	public int getNumAleatorio() {return numAleatorio;}
	public void setNumAleatorio(int numAleatorio) {this.numAleatorio = numAleatorio;}

	public List<Alumno> getLista() {return listaAlumnos;}
	public void setLista(List<Alumno> listaAlumnos) {this.listaAlumnos = listaAlumnos;}

	/**
	 * Método que nos devuelva un array clásico con los alumnos suspensos
	 */
	public Alumno[] getSuspensos() {
		Alumno[] alumnosSuspensos = this.listaAlumnos.toArray();
		for (Alumno alumno : this.listaAlumnos) {
			if (alumno.getNotaMedia()<4) {

			}
		}
		return null;
	}

	/**
	 * Método que nos devuelva un conjunto ordenado (SortedSet<>) de los alumnos aprobados,
	 * el orden a seguir será nota (de mayor a menor), en caso de repetirse apellido, y si continúa repitiéndose nombre.
	 */
	public SortedSet<Alumno> getAprobados() {
		SortedSet<Alumno> alumnosAprobados = new TreeSet<>();

		for (Alumno alumno : listaAlumnos) {
			if (alumno.getNotaMedia()>=5) {
				alumnosAprobados.add(alumno);
			}
		}
		return alumnosAprobados;
	}

	/**
	 * toString orden natural
	 */
	@Override
	public String toString() {
		this.listaAlumnos.sort(null);
		return listaAlumnos + "";
	}

}
