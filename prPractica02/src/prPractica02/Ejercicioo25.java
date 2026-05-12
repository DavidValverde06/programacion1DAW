package prPractica02;

import java.util.Scanner;

/**
 * 25. Programa que obtenga el cociente y el resto de dos números enteros positivos mediante restas y sumas,
	   no podéis utilizar las operaciones de división (/) y de resto (%).
 */

public class Ejercicioo25 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int dividendo,divisor,cociente=0,resto=0;

		System.out.print("Introduce el dividendo: ");
		dividendo=sc.nextInt();
		System.out.print("Introduce el divisor: ");
		divisor=sc.nextInt();

		if (divisor==0) {
			System.out.println("No se puede dividir entre 0");
		}
		else {
			System.out.println("\nCociente usando '/': " + (dividendo/divisor));
			System.out.println("Resto usando '%': " + (dividendo%divisor));

			while(dividendo>=divisor) {
				dividendo-=divisor;
				cociente++;
				resto=dividendo;
			}

			System.out.println("\nCociente sin usar '/': " + cociente);
			System.out.println("Resto sin usar '%': " + resto);
		}
		sc.close();
	}

}
