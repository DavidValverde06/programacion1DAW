package juego7Media_Ejer16;

/**
 * Clase para testear las clases Juego7Media y Jugador
 */

public class TestPruebas {

	public static void main(String[] args) {

		// ----------------------------------------------------------
		// Prueba de la clase Juego7Media
		// ----------------------------------------------------------
		// Crear un objeto de tipo Juego7Media
		Juego7Media miJuego = new Juego7Media();

		// Mostrar la baraja completa 
		System.out.println(miJuego.toString());

		// Sacar 4 cartas
		int [] carta1 = miJuego.sacaCarta();
		int [] carta2 = miJuego.sacaCarta();
		int [] carta3 = miJuego.sacaCarta();
		int [] carta4 = miJuego.sacaCarta();

		// Mostrar las cartas anteriores en pantalla
		System.out.println("\n\nCARTAS SACADAS");
		System.out.println(miJuego.toStringCarta(carta1[0],carta1[1]));
		System.out.println(miJuego.toStringCarta(carta2[0],carta2[1]));
		System.out.println(miJuego.toStringCarta(carta3[0],carta3[1]));
		System.out.println(miJuego.toStringCarta(carta4[0],carta4[1]));

		// Mostrar la puntuaci�n de la segunda carta
		System.out.println("Puntos de la segunda carta sacada: "+miJuego.getPuntuacionCarta(carta2[1]));

		// Mostrar la baraja completa (deben faltar en el listado las cartas sacadas) 
		System.out.println(miJuego.toString());


		// ----------------------------------------------------------
		// Prueba de la clase Jugador
		// ----------------------------------------------------------
		Jugador jugador1 = new Jugador();
		System.out.println("Carta sacada 1: "+jugador1.jugar(miJuego));
		System.out.println("Carta sacada 2: "+jugador1.jugar(miJuego));
		System.out.println("Carta sacada 3: "+jugador1.jugar(miJuego));
		System.out.println("Carta sacada 4: "+jugador1.jugar(miJuego));

		System.out.println("Puntos acumulados: "+jugador1.getPuntos());

	}
}
