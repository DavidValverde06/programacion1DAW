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
		this.cartasRestantes = 40;
		this.baraja = new boolean[4][10];

		// Rellenar la matriz que simula la baraja con valores boolean
		for (int fil=0;fil<this.baraja.length;fil++) {
			Arrays.fill(this.baraja[fil], true);
		}
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
	 * Método que comprueba si me quedan cartas en la baraja
	 * 
	 * @return --> true, si aún quedan cartas en la baraja
	 * 		   --> false, si no queda ninguna carta en la baraja
	 */
	public boolean quedanCartas() {		
		return this.cartasRestantes>0;
	}

	/**
	 * Método que permite sacar una carta de la baraja
	 * 
	 * @return --> un array con 2 elementos con la fila y la columna
	 *         --> un null si no hay cartas
	 */
	public int[] sacaCarta() {

		// Comprobar si hay cartas
		if (!this.quedanCartas()) {
			return null;
		}

		// Definir un array de 2 elementos para guardar las coordenadas de la carta
		int [] cartaSacada = new int[2];

		do {
			cartaSacada[0] = aleatorio.nextInt(4); // Genera fila entre 0...3
			cartaSacada[1] = aleatorio.nextInt(10); // Genera fila entre 0...9

		}
		while(!this.baraja[cartaSacada[0]][cartaSacada[1]]);

		this.baraja[cartaSacada[0]][cartaSacada[1]]=false;
		
		this.cartasRestantes--;

		return cartaSacada;

	}

	/**
	 * Método que devuelve la puntuación de una carta en el juego de la 7 y media
	 * 
	 * @return --> 1..7 si la carta tiene un valor de 1 a 7
	 *         --> 0,5  si es sota, caballo o rey
	 */
	public float getPuntuacionCarta(int col) {

		if (col<7) {
			return col+1;
		}
		else {
			return 0.5f;
		}
	}

	/**
	 * Método que devuelve una representación tipo String de una carta
	 * @param palo --> Valor de 0 a 3
	 * @param valor --> Valor de 0 a 9
	 * 
	 * @return --> Por ejemplo: 3 de oros, Sota de copas, Rey de bastos, ...
	 */
	public String toStringCarta1(int palo, int valor) {
		String cadena="";

		switch (valor) {
		case 0: 
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6: cadena=(valor+1) + " de "; break;
		case 7: cadena=("Sota de "); break;
		case 8: cadena=("Caballo de "); break;
		case 9: cadena=("Rey de "); break;
		}

		switch (palo) {
		case 0: cadena+="oros"; break;
		case 1: cadena+="copas"; break;
		case 2: cadena+="bastos"; break;
		case 3: cadena+="espadas"; break;
		}

		return cadena;
	}

	public String toStringCarta(int palo, int valor) {
		String cadena="";

		switch (valor) {
		case 0: 
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6: cadena=(valor+1) + " de "; break;
		case 7: cadena=("Sota de "); break;
		case 8: cadena=("Caballo de "); break;
		case 9: cadena=("Rey de "); break;
		}

		switch (palo) {
		case 0: cadena+="oros"; break;
		case 1: cadena+="copas"; break;
		case 2: cadena+="bastos"; break;
		case 3: cadena+="espadas"; break;
		}

		return cadena;
	}

	/**
	 * Redefinición de toString, muestra las cartas restantes
	 */
	@Override
	public String toString() {

		String cadena = "\nEn la baraja quedan " + this.cartasRestantes + " cartas";

		for (int fil=0;fil<this.baraja.length;fil++) {
			for (int col=0;col<this.baraja[fil].length;col++) {
				if (baraja[fil][col]) // Si la carta no ha salido
					cadena+= "\n\t"+this.toStringCarta(fil,col);
			}
		}
		return cadena;
	}	
}
