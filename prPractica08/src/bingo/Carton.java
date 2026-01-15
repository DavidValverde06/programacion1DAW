package bingo;

/**
 * 12.- Crear las clases Bombo, para simular un bombo de n bolas, y Carton, para simular los cartones que se
 * compran en el juego del Bingo.
 * 
 * La clase Carton debe mantener información sobre los 15 números que contiene cada cartón, así como
 * del número de bolas que tiene inicialmente el bombo con el que juegan, y del número de aciertos que
 * se tiene en cada momento. Deberá proporcionar una interfaz con al menos:
 * 
 * 		- Constructor: inicializará las variables de instancia y generará un cartón con 15 números diferentes
 * 		de forma aleatoria (teniendo en cuenta el tamaño del bombo).
 * 		- existeNumero(n): comprobará si en el cartón existe el número n.
 * 		- compruebaNumero(n): si existe en el cartón el número n incrementará el número de aciertos del
 * 		cartón.
 * 		- quedanNumeros( ): devuelve true si todavía quedan números sin acertar en el cartón y false si el
 * 		cartón está completo.
 */

public class Carton {

	/**
	 * Variables de instancia
	 */
	private int[] numerosCarton;
	private Bombo numBolasIniciales;
	private int numAciertos;

	/**
	 * Constructor
	 */
	public Carton(int[] numerosCarton, Bombo numBolasIniciales, int numAciertos) {
		this.numerosCarton = numerosCarton;
		this.numBolasIniciales = numBolasIniciales;
		this.numAciertos = numAciertos;
	}

	/**
	 * Método existeNumero(n)
	 * 
	 * comprobará si en el cartón existe el número n.
	 */
	public boolean existeNumero() {

	}

	/**
	 * Método compruebaNumero(n)
	 * 
	 * si existe en el cartón el número n incrementará el número de aciertos del
	 * cartón.
	 */
	public boolean compruebaNumero() {
		
	}

	/**
	 * Método quedanNumeros()
	 * 
	 * devuelve true si todavía quedan números sin acertar en el cartón y false si el
	 * cartón está completo.
	 */
	public boolean quedanNumero() {

	}
}
