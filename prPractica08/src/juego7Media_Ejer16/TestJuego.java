package juego7Media_Ejer16;

import java.util.Scanner;

/**
 * Clase para testear las clases Juego7Media y Jugador para jugar al juego de la 7 y media
 * 
 * JUEGO 7 y MEDIA --> Consiste en ir sacando cartas de una baraja española, por los jugadores para 
 *                     intentar acercarnos lo máximo posible (sin pasarse) a la puntuación de 7 y medio.
 *                     
 *                     Gana el jugador que más se haya aproximado a 7 y medio.
 *                     
 *                     El valor de las cartas es:
 *                     	 * Con cartas de 1 a 7 su valor será el mismo numérico, es decir, un número entre 1 a 7
 *                       * Cartas sota, caballo o rey, el valor de la carta es 0.5
 *                       
 *                       
 * En esta clase vamos a simular el juego de la 7 y media entre dos jugadores, uno será "Pepe", y el otro 
 * el ordenador, en el caso del ordenador generaremos aleatoriamente si continua o no jugando.
 *                     
 */

public class TestJuego {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// Creación de objetos
		Juego7Media obJuego = new Juego7Media();
		Jugador usuario = new Jugador("Pepe");
		Jugador ordenador = new Jugador("Ordenador");

		do {
			System.out.println("\nTurno usuario");
			System.out.println(usuario.jugar(obJuego));
			System.out.println(usuario.toString());
			
			System.out.println("\nTurno ordenador");
			System.out.println(ordenador.jugar(obJuego));
			System.out.println(ordenador.toString());
			
			if (usuario.isContinua()) {
				System.out.print("Usuario tienes "+usuario.getPuntos() + " puntos, �quieres seguir jugando? ");
			
			//	usuario.setContinua(sc.nextLine().charAt(0)=='S');
				usuario.setContinua(sc.nextLine().toUpperCase().charAt(0)=='S');
				
				if (!usuario.isContinua())
					System.out.println("\nEl usuario se planta");
			}
			
			if (ordenador.isContinua()) {
				// Generar aleatoriamente si el ordenador continua jugando o no
				if (ordenador.getPuntos()>6)
					ordenador.setContinua(false);
				else // Puntos <=6
					if (ordenador.getPuntos()<=3)
						ordenador.setContinua(true);
					else
						ordenador.setContinua(Juego7Media.getAleatorio().nextBoolean());
				
				if (!ordenador.isContinua())
					System.out.println("\nEl ordenador se planta");
			}		    
		}
		while ((usuario.getPuntos()<=7.5 || ordenador.getPuntos()<=7.5) &&
			   (usuario.isContinua() || ordenador.isContinua()) &&
			   (obJuego.quedanCartas()));
		
		mostrarResultado(usuario, ordenador);
		
		sc.close();
	}

	/**
	 * M�todo que muestra el resultado del juego por consola
	 * @param usuario
	 * @param ordenador
	 */
	private static void mostrarResultado(Jugador usuario, Jugador ordenador) {
		
		float puntosUsu = usuario.getPuntos();
		float puntosOrd = ordenador.getPuntos();
		
		if (puntosUsu>7.5 && puntosOrd>7.5)
			System.out.println("\nLos dos jugadores se han pasado de 7.5, nadie gana");
		else
			if (puntosUsu==puntosOrd)
				System.out.println("\nLos dos jugadores han empatado con "+
			                         puntosUsu);
			else {
				if (puntosUsu > puntosOrd)
					if (puntosUsu <= 7.5)
						System.out.println("\nGana el USUARIO");
					else
						System.out.println("\nGana el ORDENADOR");
				else
					if (puntosOrd <= 7.5)
						System.out.println("\nGana el ORDENADOR");
					else
						System.out.println("\nGana el USUARIO");
			
				System.out.println("\n\tPuntos ordenador: "+ puntosOrd);
				System.out.println("\n\tPuntos usuario: "+ puntosUsu);
			}
	}
	
	
	

	
}











