package prExamen03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Taller implements Comparable<Taller>{

	/**
	 * Variables de instancia
	 */
	private String nombreTaller;
	private String ponenteTaller;
	private EnumTematica tematicaTaller;
	private int numMaxAlumnosTaller;
	private List<Asistente> listaAlumnosTaller;

	/**
	 * Constructor
	 */
	public Taller(String nombreTaller, String ponenteTaller, EnumTematica tematicaTaller, int numMaxAlumnosTaller) {
		super();
		this.nombreTaller = nombreTaller;
		this.ponenteTaller = ponenteTaller;
		this.tematicaTaller = tematicaTaller;
		this.numMaxAlumnosTaller = numMaxAlumnosTaller;
		this.listaAlumnosTaller = new ArrayList<>();
	}

	/**
	 * Getter's y setter's
	 */
	public String getNombreTaller() {return nombreTaller;}
	public void setNombreTaller(String nombreTaller) {this.nombreTaller = nombreTaller;}

	public String getPonenteTaller() {return ponenteTaller;}
	public void setPonenteTaller(String ponenteTaller) {this.ponenteTaller = ponenteTaller;}

	public EnumTematica getTematicaTaller() {return tematicaTaller;}
	public void setTematicaTaller(EnumTematica tematicaTaller) {this.tematicaTaller = tematicaTaller;}

	public int getNumMaxAlumnosTaller() {return numMaxAlumnosTaller;}
	public void setNumMaxAlumnosTaller(int numMaxAlumnosTaller) {this.numMaxAlumnosTaller = numMaxAlumnosTaller;}

	public List<Asistente> getListaAlumnosTaller() {return listaAlumnosTaller;}
	public void setListaAlumnosTaller(List<Asistente> listaAlumnosTaller) {this.listaAlumnosTaller = listaAlumnosTaller;}

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return this.nombreTaller + ", Ponente: " + this.ponenteTaller + ", " +
				this.tematicaTaller + " (" + this.numMaxAlumnosTaller + " plazas)";
	}

	/**
	 * "toString" detallado
	 */
	public String toStringDetallado() {
		String cadena="";

		if (this.listaAlumnosTaller.isEmpty()) {
			cadena = "No hay alumnos inscritos todavía";
		}
		else {
			for (Asistente asistente : listaAlumnosTaller) {
				cadena += "\n\t - " + asistente.getNombre() + " (" + asistente.getDni() + ")";
			}
		}
		return toString() +
				"\n\tAlumnos inscritos en este taller: " + cadena;
	}

	/**
	 * Método para apuntar alumnos al taller, siempre que queden plazas
	 * y no estuviera ya apuntado al mismo taller
	 */
	public boolean admitirAlumno(Asistente asis) {
		boolean encontrado = false;
		Iterator<Asistente> it = listaAlumnosTaller.iterator();

		if (this.numMaxAlumnosTaller<1) {
			return false;
		}
		else {
			while (encontrado!=true && it.hasNext()) {
				Asistente asistente = it.next();
				if (asistente.equals(asis)) {
					encontrado=true;
				}
			}
			if (encontrado==true) {
				return false;
			}
			this.numMaxAlumnosTaller--;
			return listaAlumnosTaller.add(asis);
		}

	}

	/**
	 * Método compareTo
	 * 
	 * El orden natural (Comparable), que será 
	 * por nombre del taller, y si este se repite por ponente
	 */
	@Override
	public int compareTo(Taller o) {
		int compara = this.nombreTaller.compareTo(o.getNombreTaller());
		if (compara!=0) // El nombre es diferente
			return compara;

		return this.ponenteTaller.compareTo(o.getPonenteTaller());
	}
}
