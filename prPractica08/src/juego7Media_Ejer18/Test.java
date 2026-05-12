package juego7Media_Ejer18;

public class Test {

	public static void main(String[] args) {

		// ---------------------------------------------
		// Prueba de la clase Carta
		// ---------------------------------------------
		Carta c1 = new Carta(EnumPalo.OROS, (byte)10);

		System.out.println(c1);

		Carta c2 = new Carta(EnumPalo.COPAS, (byte)7);

		System.out.println(c2);

		System.out.println();

		System.out.println(c1.getPuntos7Media());
		System.out.println(c2.getPuntos7Media());

		System.out.println();

		Carta c3 = new Carta(EnumPalo.COPAS, (byte)7);

		if (c2.equals(c3)) {
			System.out.println("Son iguales");
		}
		else {
			System.out.println("Son distintas");
		}

		if (c1.equals(c3)) {
			System.out.println("Son iguales");
		}
		else {
			System.out.println("Son distintas");
		}

		System.out.println();

		// ---------------------------------------------
		// Prueba de la clase Carta
		// ---------------------------------------------
		Baraja miBaraja = new Baraja();
		System.out.println(miBaraja.toString());

		System.out.println("\nCarta 1 sacada: " + miBaraja.sacaCarta());
		System.out.println("Carta 2 sacada: " + miBaraja.sacaCarta());
		System.out.println("Carta 3 sacada: " + miBaraja.sacaCarta());

		System.out.println();

		System.out.println(miBaraja.toString());
		System.out.println();
		
		// ---------------------------------------------
		// Recorrer el array de cartas con un bucle for-each
		// ---------------------------------------------
		for (Carta elemento: miBaraja.getMiBaraja()) {
			System.out.println(elemento.toString());
		}
	}

}
