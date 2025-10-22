package prPractica02;

/**
 * 29. Hacer un algoritmo para mostrar por pantalla 100 veces de una forma alternativa: Hola, Adiós.
 */

public class Ejercicioo29 {

	public static void main(String[] args) {

		for (int cont=1;cont<=100;cont++) {
			if (cont%2==0) {
				System.out.println(cont + ": Adiós");
			}
			else {
				System.out.println(cont + ": Hola");
			}
		}
	}

}
