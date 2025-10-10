package prPractica02;

import java.util.Scanner;

/**
 * 45. Hacer un algoritmo para que nos calcule la estadística de una serie de notas introducidas por teclado.
	   La serie finalizará con la introducción del 0, sabiendo que:
 */

public class Ejercicioo45 {

	public static void main(String[] args) {

		sin hacer

		Scanner sc = new Scanner(System.in);

		int nota;

		System.out.print("Introduce la nota: ");
		nota=sc.nextInt();

		if (nota<0||nota>10) {
			System.out.println("ERROR. Nota no válida");
		}
		else if (nota>=0&&nota<3) {
			System.out.println("Muy deficiente");
		}
		else if (nota>=3&&nota<5) {
			System.out.println("Insuficiente");
		}
		else if (nota>=5&&nota<6) {
			System.out.println("Suficiente");
		}
		else if (nota>=6&&nota<7) {
			System.out.println("Bien");
		}
		else if (nota>=7&&nota<9) {
			System.out.println("Notable");
		}
		else {
			System.out.println("Sobresaliente");
		}

		sc.close();
	}

}
