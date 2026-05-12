package ligaFutbol;

import java.util.Objects;

/**
 * Crear la clase Equipo, sobre un equipo interesa almacenar su nombre, el número de los partidos
 * ganados, empatados y perdidos, así como el número de goles a favor (marcados) y de goles en contra
 * (recibidos).
 */
public class Equipo {

	/**
	 * Variables de instancia
	 */
	private String nombreEquipo;
	private int numPartidosGanados;
	private int numPartidosEmpatados;
	private int numPartidosPerdidos;
	private int numGolesMarcados;
	private int numGolesRecibidos;

	/**
	 * Constructor
	 */
	public Equipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	/**
	 * Getter's y setter's
	 */
	public String getNombreEquipo() { return nombreEquipo; }
	public void setNombreEquipo(String nombreEquipo) { this.nombreEquipo = nombreEquipo; }

	public int getNumPartidosGanados() { return numPartidosGanados; }
	public int getNumPartidosEmpatados() { return numPartidosEmpatados; }
	public int getNumPartidosPerdidos() { return numPartidosPerdidos; }
	public int getNumGolesMarcados() { return numGolesMarcados; }
	public int getNumGolesRecibidos() { return numGolesRecibidos; }

	/**
	 * Método que devuelva el número de partidos jugados.
	 */
	public int numPartidosJugadosTotales() {
		return this.numPartidosGanados + this.numPartidosEmpatados + this.numPartidosPerdidos;
	}

	/**
	 * Método que calcule los puntos acumulados por un equipo.
	 * 3 puntos por victoria, 1 punto por empate, 0 por derrota
	 */
	public int puntosAcumuladosEquipo() {
		return (this.numPartidosGanados * 3) + this.numPartidosEmpatados;
	}

	/**
	 * equals y hashCode basados en el nombre del equipo
	 */
	@Override
	public int hashCode() {
		return Objects.hash(nombreEquipo.toLowerCase());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Equipo other = (Equipo) obj;
		return Objects.equals(nombreEquipo.toLowerCase(), other.nombreEquipo.toLowerCase());
	}

	/**
	 * Incrementos de partidos
	 */
	public void incrementaNumPartidosGanados() { this.numPartidosGanados++; }
	public void incrementaNumPartidosEmpatados() { this.numPartidosEmpatados++; }
	public void incrementaNumPartidosPerdidos() { this.numPartidosPerdidos++; }

	/**
	 * Incrementos de goles
	 */
	public void incrementaNumGolesMarcados(int numIncremento) { this.numGolesMarcados += numIncremento; }
	public void incrementaNumGolesRecibidos(int numIncremento) { this.numGolesRecibidos += numIncremento; }

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return this.nombreEquipo.toUpperCase() +
				"\n\tPartidos Jugados: " + this.numPartidosJugadosTotales() +
				"\n\tPartidos Ganados: " + this.numPartidosGanados +
				"\n\tPartidos Empatados: " + this.numPartidosEmpatados +
				"\n\tPartidos Perdidos: " + this.numPartidosPerdidos +
				"\n\tGoles a favor: " + this.numGolesMarcados +
				"\n\tGoles en contra: " + this.numGolesRecibidos +
				"\n\tPuntos acumulados: " + this.puntosAcumuladosEquipo();
	}

	/**
	 * toStringLineal
	 */
	public String toStringLineal() {
		return this.numPartidosJugadosTotales() + "\t" +
				this.numPartidosGanados + "\t" +
				this.numPartidosEmpatados + "\t" +
				this.numPartidosPerdidos + "\t" +
				this.numGolesMarcados + "\t" +
				this.numGolesRecibidos + "\t" +
				this.puntosAcumuladosEquipo() + "\t" +
				this.nombreEquipo.toUpperCase();
	}
}