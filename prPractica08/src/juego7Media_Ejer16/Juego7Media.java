package juego7Media_Ejer16;

import java.util.Arrays;
import java.util.Random;

/**
 * Clase Juego7Media, en esta clase la baraja la simulamos con una matriz 4x10, donde en 
 * cada fila tendremos las 10 (1,2,3,4,5,6,7, sota, caballo y rey) cartas de cada palo 
 * (oros, copas, bastos y espadas) 
 * 
 *  
 * Este plantemiento evidencia claramente, que necesitaríamos otra clase
 * que sería la clase Carta, ya que estamos mezclado los métodos que trabajan
 * con la baraja (sacaCarta, toString, ...) con métodos de una carta en concreto
 * (puntuacionCarta, toStringCarta, ...)
 * 
 * En futuras revisiones de este ejericio, se deberemos añadir la clase Carta
 * 
 * @author profesor
 */

public class Juego7Media {
	
	/**
	 * Variables de clase
	 */
	private static Random aleatorio;

	/**
	 * Variables de instancia
	 */
	private boolean [][] baraja;  // Matriz que representa la baraja
	private int cartasRestantes;  // Cartas que me quedan por sacar

	
	/**
	 * Inicializador estático
	 */
	static {
		aleatorio = new Random();
	}
	
	
	/**
	 * Constructor
	 */
	public Juego7Media() {
		
	}
	
	/**
	 * Métodos get y set
	 */
	public boolean[][] getBaraja() {return baraja;}

	public int getCartasRestantes() {return cartasRestantes;}

	public void setBaraja(boolean[][] baraja) {
		this.baraja = baraja;
	}

	public void setCartasRestantes(int cartasRestantes) {
		this.cartasRestantes = cartasRestantes;
	}
	
	public static Random getAleatorio() {return aleatorio;}
	
	
	/**
	 * M�todo que comprueba si me quedan cartas en la baraja
	 * @return
	 */
	public boolean quedanCartas() {
		
	}
	
	/**
	 * Método que permite sacar una carta de la baraja
	 * @return --> un array con 2 elementos con la fila y la columna
	 *         --> un null si no hay cartas
	 */
	public int[] sacaCarta() {
		
	}
	
	
	/**
	 * M�todo que devuelve la puntuaci�n de una carta en el juego de la 7 y media
	 * @return --> 1..7 si la carta tiene un valor de 1 a 7
	 *         --> 0,5  si es sota, caballo o rey
	 */
	public float getPuntuacionCarta(int col) {
		
		
	}
	
	/**
	 * Método que devuelve una representació tipo String de una carta
	 * @param palo --> Valor de 0 a 3
	 * @param valor --> Valor de 0 a 9
	 * @return --> Por ejemplo: 3 de oros, Sota de copas, Rey de bastos, ...
	 */
	public String toStrigCarta1(int palo, int valor) {
		
	}
	
	public String toStringCarta(int palo, int valor) {
		
	}
	
	
	/**
	 * Redefinición de toString, muestra las cartas restantes
	 */
	@Override
	public String toString() {

	}
	
}








