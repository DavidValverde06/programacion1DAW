package prExamen03;

import java.util.*;

public class GestionEvento {

	/**
	 * Variables de instancia
	 */
	private SortedSet<Asistente> conjuntoAsistentes;

	/**
	 * Constructor
	 */
	public GestionEvento() {
		this.conjuntoAsistentes = new TreeSet<>(new ComparatorFechaNombreDNI());
	}

	/**
	 * Getter's y setter`s
	 */
	public SortedSet<Asistente> getConjuntoAsistentes() {return conjuntoAsistentes;}
	public void setConjuntoAsistentes(SortedSet<Asistente> conjuntoAsistentes) {this.conjuntoAsistentes = conjuntoAsistentes;}

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		String cadena = "--- RESUMEN GEEKCON ---" +
				"\nTotal asistentes: " + this.conjuntoAsistentes.size() +
				"\nIngresos totales: " + getIngresosTotales();

		for (Asistente asis : obtenerListadoPorCaja()) {
			cadena += "\n\t" + asis.getNombre() + " - " + asis.calcularPrecioInscripcion() + "€";
		}

		return cadena;
	}

	/**
	 * Método para añadir asistentes
	 */
	public boolean añadirAsistentes(Asistente asis) {
		return this.conjuntoAsistentes.add(asis);
	}

	/**
	 * Método sobrecargado
	 * 
	 * Comprobará si un asistente ya está inscrito o no
	 */
	public boolean compruebaInscripcion(String dni) {
		boolean encontrado=false;
		Iterator<Asistente> it = conjuntoAsistentes.iterator();

		while (encontrado!=true && it.hasNext()) {
			Asistente asistente = it.next();
			if (asistente.getDni().equals(dni)) {
				encontrado=true;
			}
		}
		return encontrado;
	}

	public boolean compruebaInscripcion(Asistente asis) {
		boolean encontrado=false;
		Iterator<Asistente> it = conjuntoAsistentes.iterator();

		while (encontrado!=true && it.hasNext()) {
			Asistente asistente = it.next();
			if (asistente.equals(asis)) {
				encontrado=true;
			}
		}
		return encontrado;
	}

	/**
	 * Método sobrecargado
	 * 
	 * Borrar asistente
	 */
	public boolean borraInscripcion(String dni) {
		boolean encontrado=false;
		Iterator<Asistente> it = conjuntoAsistentes.iterator();

		while (encontrado!=true && it.hasNext()) {
			Asistente asistente = it.next();
			if (asistente.getDni().equals(dni)) {
				conjuntoAsistentes.remove(asistente);
				encontrado=true;
			}
		}
		return encontrado;
	}

	public boolean borraInscripcion(Asistente asis) {
		boolean encontrado=false;
		Iterator<Asistente> it = conjuntoAsistentes.iterator();

		while (encontrado!=true && it.hasNext()) {
			Asistente asistente = it.next();
			if (asistente.equals(asis)) {
				conjuntoAsistentes.remove(asistente);
				encontrado=true;
			}
		}
		return encontrado;
	}

	/**
	 * Método que inscribe un determinado asistente a tres talleres de forma aleatoria y
	 * devuelve una lista de los talleres a los que ha sido inscrito
	 */
//	public List<Taller> inscripcionAleatoria(Asistente asis, AgendaTalleres agenda) {
//		List<Taller> listaTalleres = new ArrayList<>();
//
//
//
//		return listaTalleres;
//	}

	/**
	 * Método que devuelve una colección tipo lista de los asistentes
	 * ordenada de mayor a menor, segun el precio de su inscripción
	 */
	public List<Asistente> obtenerListadoPorCaja() {
		List<Asistente> listadoOrdenado = new ArrayList<>(this.conjuntoAsistentes);
		listadoOrdenado.sort(new ComparatorPrecioInscripcion());
		return listadoOrdenado;
	}

	/**
	 * Método que devuelve la suma total de lo recaudado por las inscripciones
	 */
	public double getIngresosTotales() {
		double ingresosTotales=0;

		for (Asistente asistente : conjuntoAsistentes) {
			ingresosTotales+=asistente.calcularPrecioInscripcion();
		}

		return ingresosTotales;
	}
}
