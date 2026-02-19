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
 * 
 * • Constructor.
 * 
 * • Métodos get.
 * 
 * • Método que devuelva el resultado del equipo en formato quiniela, es decir, 1, X ó 2. (1 si el equipo
 * ganador es el anfitrión, X, si han empatado y 2 si el ganador es el visitante).
 * 
 * • Redefinición de toString cuyo formato de salida debe ser similar al siguiente ejemplo:
 * 		REAL MADRID 2, ATLETICO DE BILBAO 1
 */
public class Partido {

	/**
	 * Variables de instancia
	 */
	private String nombreEquipo1;
	private String nombreEquipo2;
	private LocalDate fechaPartido;
	private String resultado;

	/**
	 * Constructor
	 */
	
}
