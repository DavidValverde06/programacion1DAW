package ligaFutbol;

import java.time.LocalDate;

/**
 * Desarrollar la clase Partido, un partido viene dado por el nombre de dos equipos, la fecha del encuentro
 * del partido, y el resultado, que vendrá representado por una cadena con el siguiente formato:
 * 
 * 				GolesMarcadosEquipoAnfitrion – GolesMaradosEquipoVisitante
 * 		Por ejemplo: 2-2, 12-1, 2-0
 * 
 * No obstante internamente nos interesará almacenar el número de goles marcados por cada equipo.
 * Esta clase debe proporcionar como mínimo los siguientes métodos:
 */
public class Partido {

	/**
	 * Variables de instancia
	 */
	private String nombreEquipo1;
	private String nombreEquipo2;
	private LocalDate fechaPartido;
	// private String resultado; // Esto no es necesario
	private int numGolesMarcadosEquipo1;
	private int numGolesMarcadosEquipo2;

	/**
	 * Constructor
	 */
	public Partido(Equipo nombreEquipo1, Equipo nombreEquipo2, LocalDate fechaPartido, int numGolesMarcadosEquipo1, int numGolesMarcadosEquipo2) {
		this.nombreEquipo1 = nombreEquipo1.getNombreEquipo();
		this.nombreEquipo2 = nombreEquipo2.getNombreEquipo();
		this.fechaPartido = fechaPartido;
		this.numGolesMarcadosEquipo1 = numGolesMarcadosEquipo1;
		this.numGolesMarcadosEquipo2 = numGolesMarcadosEquipo2;
		this.resultado = this.numGolesMarcadosEquipo1 + " - " + this.numGolesMarcadosEquipo2;
	}

	/**
	 * Getter's y setter's
	 */
	public String getNombreEquipo1() {
		return nombreEquipo1;
	}

	public void setNombreEquipo1(String nombreEquipo1) {
		this.nombreEquipo1 = nombreEquipo1;
	}

	public String getNombreEquipo2() {
		return nombreEquipo2;
	}

	public void setNombreEquipo2(String nombreEquipo2) {
		this.nombreEquipo2 = nombreEquipo2;
	}

	public LocalDate getFechaPartido() {
		return fechaPartido;
	}

	public void setFechaPartido(LocalDate fechaPartido) {
		this.fechaPartido = fechaPartido;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public int getNumGolesMarcadosEquipo1() {
		return numGolesMarcadosEquipo1;
	}

	public void setNumGolesMarcadosEquipo1(int numGolesMarcadosEquipo1) {
		this.numGolesMarcadosEquipo1 = numGolesMarcadosEquipo1;
	}

	public int getNumGolesMarcadosEquipo2() {
		return numGolesMarcadosEquipo2;
	}

	public void setNumGolesMarcadosEquipo2(int numGolesMarcadosEquipo2) {
		this.numGolesMarcadosEquipo2 = numGolesMarcadosEquipo2;
	}

	/**
	 * Método que devuelva el resultado del equipo en formato quiniela, es decir, 1, X ó 2. (1 si el equipo
	 * ganador es el anfitrión, X, si han empatado y 2 si el ganador es el visitante).
	 */
	public char resultadoEquipoQuiniela() {
		if (this.numGolesMarcadosEquipo1==this.numGolesMarcadosEquipo2) {
			return 'X';
		}
		else if (this.numGolesMarcadosEquipo1>this.numGolesMarcadosEquipo2) {
			return '1';
		}
		return '2';
	}

	/**
	 * Redefinición de toString cuyo formato de salida debe ser similar al siguiente ejemplo:
	 * 		REAL MADRID 2, ATLETICO DE BILBAO 1
	 */
	@Override
	public String toString() {
		return this.nombreEquipo1.toUpperCase() + " " + this.numGolesMarcadosEquipo1 + ", " + this.nombreEquipo2.toUpperCase() + " " + this.numGolesMarcadosEquipo2;
	}
}
