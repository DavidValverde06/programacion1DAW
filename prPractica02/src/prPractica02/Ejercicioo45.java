package prPractica02;

import java.util.Scanner;

/**
 * 45. Hacer un algoritmo para que nos calcule la estadística de una serie de notas introducidas por teclado.
	   La serie finalizará con la introducción del 0, sabiendo que:
 */

public class Ejercicioo45 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int nota;

		System.out.print("Introduce la nota: ");
		nota=sc.nextInt();

		while (nota!=0) {

			switch (key) {
			case value ->
			
			
			
			default ->
			throw new IllegalArgumentException("Unexpected value: " + key);
			}
			
			System.out.print("\nIntroduce la nota: ");
			nota=sc.nextInt();
		}
		
		System.out.println("FIN DE PROGRAMA");

		sc.close();
	}

}
