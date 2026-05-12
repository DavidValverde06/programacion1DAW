package ligaFutbol;

import java.time.LocalDate;

public class Partido {

	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private LocalDate fechaPartido;
	private int golesLocal;
	private int golesVisitante;

	/**
	 * Constructor
	 */
	public Partido(Equipo equipoLocal, Equipo equipoVisitante, LocalDate fechaPartido, String resultado) {
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.fechaPartido = fechaPartido;

		// Parseamos el resultado "GolesLocal-GolesVisitante"
		String[] partes = resultado.split("-");
		this.golesLocal = Integer.parseInt(partes[0].trim());
		this.golesVisitante = Integer.parseInt(partes[1].trim());
	}

	/**
	 * Getters
	 */
	public Equipo getEquipoLocal() { return equipoLocal; }
	public Equipo getEquipoVisitante() { return equipoVisitante; }
	public LocalDate getFechaPartido() { return fechaPartido; }
	public int getGolesLocal() { return golesLocal; }
	public int getGolesVisitante() { return golesVisitante; }

	/**
	 * Devuelve el resultado tipo quiniela para el equipo indicado
	 * 1 = gana local, X = empate, 2 = gana visitante
	 */
	public String resultadoQuiniela() {
		if (golesLocal > golesVisitante) return "1";
		else if (golesLocal == golesVisitante) return "X";
		else return "2";
	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return equipoLocal.getNombreEquipo().toUpperCase() + " " + golesLocal + ", " +
				equipoVisitante.getNombreEquipo().toUpperCase() + " " + golesVisitante;
	}
}