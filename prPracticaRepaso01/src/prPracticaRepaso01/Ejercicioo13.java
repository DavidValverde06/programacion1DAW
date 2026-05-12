package prPracticaRepaso01;

import java.util.Scanner;

/**
 * 13. Diseñar un programa que muestre la suma de los números impares comprendidos entre dos valores
		numéricos enteros y positivos introducidos por teclado.

 */

public class Ejercicioo13 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int primero,segundo,resultado=0;

		System.out.print("Introduce el primer valor: ");
		primero=sc.nextInt();

		System.out.print("Introduce el segundo valor: ");
		segundo=sc.nextInt();

		if (primero<0||segundo<0) {
			System.out.println("Introduce números enteros y positivos");
		}
		else {

			if (segundo<primero) {
				int aux;
				aux=primero;
				primero=segundo;
				segundo=aux;
			}
			
			System.out.println();
			
			for (int cont=primero;cont<segundo;cont++) {
				if (cont%2!=0) {
					System.out.print(cont + " ");
					resultado+=cont;
				}
			}
			
			System.out.println("\nSuma de los números impares: " + resultado);
		}

		sc.close();
	}

}
