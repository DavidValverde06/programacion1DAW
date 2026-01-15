package bingo;

/**
 * 12.- Crear las clases Bombo, para simular un bombo de n bolas, y Carton, para simular los cartones que se
 * compran en el juego del Bingo.
 * 
 * La clase Bombo debe mantener información sobre si una bola ha salido ya o no, además del número de
 * bolas que tiene inicialmente el bombo, y proporcionar una interfaz que proporcione al menos:
 * 
 * 		- Constructor: debe dar los valores más convenientes a las variables de instancia.
 * 		- extraeBola( ): sacará una bola aleatoriamente del bombo, habrá que tener en cuenta que no se
 * 		puede sacar una bola que ya haya salido anteriormente.
 */

public class Bombo {

	/**
	 * Variables de instancia
	 */
	private boolean haSalidoBola;
	private int numBolasIniciales;
	
	/**
	 * Constructor
	 */
	public Bombo(boolean haSalidoBola, int numBolasIniciales) {
		this.haSalidoBola = haSalidoBola;
		this.numBolasIniciales = numBolasIniciales;
	}
	
	/**
	 * Método extraeBola()
	 * 
	 * sacará una bola aleatoriamente del bombo, habrá que tener en cuenta que no se
	 * puede sacar una bola que ya haya salido anteriormente.
	 */
	public void extraeBola() {
		
	}
}
