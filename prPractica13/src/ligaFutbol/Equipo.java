package ligaFutbol;

/**
 * Crear la clase Equipo, sobre un equipo interesa almacenar su nombre, el número de los partidos
 * ganados, empatados y perdidos, así como el número de goles a favor (marcados) y de goles en contra
 * (recibidos).
 * Esta clase debe proporcionar como mínimo los siguientes métodos:
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
	public Equipo(String nombreEquipo, int numPartidosGanados, int numPartidosEmpatados, int numPartidosPerdidos,
			int numGolesMarcados, int numGolesRecibidos) {
		this.nombreEquipo = nombreEquipo;
		this.numPartidosGanados = numPartidosGanados;
		this.numPartidosEmpatados = numPartidosEmpatados;
		this.numPartidosPerdidos = numPartidosPerdidos;
		this.numGolesMarcados = numGolesMarcados;
		this.numGolesRecibidos = numGolesRecibidos;
	}

	/**
	 * Getter's y setter's
	 */
	public String getNombreEquipo() {return nombreEquipo;}
	public void setNombreEquipo(String nombreEquipo) {this.nombreEquipo = nombreEquipo;}

	public int getNumPartidosGanados() {return numPartidosGanados;}
	public void setNumPartidosGanados(int numPartidosGanados) {this.numPartidosGanados = numPartidosGanados;}

	public int getNumPartidosEmpatados() {return numPartidosEmpatados;}
	public void setNumPartidosEmpatados(int numPartidosEmpatados) {this.numPartidosEmpatados = numPartidosEmpatados;}

	public int getNumPartidosPerdidos() {return numPartidosPerdidos;}
	public void setNumPartidosPerdidos(int numPartidosPerdidos) {this.numPartidosPerdidos = numPartidosPerdidos;}

	public int getNumGolesMarcados() {return numGolesMarcados;}
	public void setNumGolesMarcados(int numGolesMarcados) {this.numGolesMarcados = numGolesMarcados;}

	public int getNumGolesRecibidos() {return numGolesRecibidos;}
	public void setNumGolesRecibidos(int numGolesRecibidos) {this.numGolesRecibidos = numGolesRecibidos;}

	/**
	 * Método que devuelva el número de partidos jugados.
	 */
	public int numPartidosJugadosTotales() {
		return this.numPartidosEmpatados + this.numPartidosGanados + this.numPartidosPerdidos;
	}

	/**
	 * Método que calcule los puntos acumulados por un equipo.
	 */
	public int numGolesMarcadosAcumulados() {

	}

	/**
	 * Un método de objeto y otro de clase para poder comparar si dos equipos son iguales, se
	 * considerará que dos equipos son iguales si coincide su nombre, sin distinguir entre mayúsculas y
	 * minúsculas.
	 */


	/** • Método/métodos que permitan incrementar en 1 el número de partidos ganados, empatados o
	 * perdidos.
	 */
	public void incrementaNumPartidosGanados() {
		this.numPartidosGanados++;
	}

	public void incrementaNumPartidosEmpatados() {
		this.numPartidosEmpatados++;
	}

	public void incrementaNumPartidosPerdidos() {
		this.numPartidosPerdidos++;
	}

	/** • Método/métodos que permitan incrementar el número de goles a favor o en contra en el número
	 * de goles indicado.
	 */
	public void incrementaNumGolesMarcados(int numIncremento) {
		this.numGolesMarcados+=numIncremento;
	}

	public void incrementaNumGolesRecibidos(int numIncremento) {
		this.numGolesRecibidos+=numIncremento;
	}

	/**
	 * toString redfinido
	 * 
	 * 		ANTEQUERA CF
	 * 			Partidos Jugados: 6
	 * 			Partidos Ganados: 3
	 * 			Partidos Empatados: 2
	 * 			Partidos Perdidos: 1
	 * 			Goles a favor: 10
	 * 			Goles en contra: 3
	 * 			Puntos acumulados: 11
	 */
	@Override
	public String toString() {
		return this.nombreEquipo.toUpperCase() +
				"\n\tPartidos Jugados: " + this.numPartidosJugadosTotales() +
				"\n\tPartidos Ganados: " + this.numPartidosGanados +
				"\n\tPartidos Empatados: " + this.numPartidosEmpatados +
				"\n\tPartidos Perdidos: " + this.numPartidosPerdidos +
				"\n\tGoles a favor: " + this.numGolesMarcados +
				"\n\tGoles en contra: " + this.nombreEquipo +
				"\n\tPuntos acumulados: " + ;
	}

	/**
	 * toStringLineal, que muestre la misma información pero en una sola línea, por ejemplo:
	 * 		6 3 2 1 10 3 11 ANTEQUERA CF
	 */
	public String toStringLineal() {
		return this.numPartidosJugadosTotales() + "\t" + this.numPartidosGanados + "\t" + this.numPartidosEmpatados + "\t" +
				this.numPartidosPerdidos + "\t" + this.numGolesMarcados + "\t" + this.numGolesRecibidos + "\t" +  + "\t" + this.nombreEquipo.toUpperCase();
	}
}
