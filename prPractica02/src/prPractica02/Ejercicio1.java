package prPractica02;

/**
 * 1. ¿Cómo se podría mejorar el siguiente fragmento de algoritmo?
		si (numero > 0) entonces
			escribe(“Hola”)
			numero = numero + 1
		si-no
			escribe(“Hola”)
			numero = numero - 1
		fin-si
 */

public class Ejercicio1 {

	public static void main(String[] args) {

		int num = 1;
		
		if (num>0) {
			System.out.println("Hola");
			num = num+1;
		}
		else {
			System.out.println("Hola");
			num = num-1;
		}
		
		// Versión optimizada
		System.out.println("Hola");
		if (num>0) {
			num = num+1;
		}
		else {
			num = num-1;
		}
	}

}
