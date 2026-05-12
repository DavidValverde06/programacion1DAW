package prPractica02;

import java.util.Scanner;

/**
 * 30. Hacer un algoritmo para mostrar por pantalla los números múltiplos de 3 que hay entre dos números
	   determinados, de forma alternativa.
 */

public class Ejercicioo30 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num1,num2;
		
		System.out.print("Introduce el primer número: ");
		num1=sc.nextInt();
		System.out.print("Introduce el segundo número: ");
		num2=sc.nextInt();
		
		System.out.println("\nMultiplos de 3 entre el número " + num1 + " y el " + num2);
		
		for (int cont=num1;cont<=num2;cont++) {
//			System.out.print(cont + " ");
			if (cont%3==0 && cont%2!=0) {
				System.out.print(cont + " | ");
			}
		}
		
		sc.close();
		
	}

}
