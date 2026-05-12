package prPractica01;

import java.util.Scanner;

/**
 * 15.- Diseñar un algoritmo que a partir de la base y la altura de un triángulo muestre como resultado su
		superficie. (superficie = b · h / 2).
 */

public class Ejercicioo15 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		double base, altura,superficie;
		
		System.out.print("Introduce la base del triángulo: ");
		base=sc.nextDouble();
		
		System.out.print("Introduce la altura del triángulo: ");
		altura=sc.nextDouble();
		
		superficie=(base*altura/2);
		
		System.out.println("\nLa superficie del triángulo es: " + superficie);
		
		sc.close();
	}

}
