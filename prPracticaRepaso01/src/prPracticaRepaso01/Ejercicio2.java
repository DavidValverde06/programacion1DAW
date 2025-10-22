package prPracticaRepaso01;

import java.util.Scanner;

/**
 * 2. Diseñar un programa para determinar si un número entero es múltiplo de 3, 4 o 5.
 */

public class Ejercicio2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num;
		
		System.out.print("Introduce un número entero: ");
		num=sc.nextInt();
		
		while (num<=0) {
			System.out.println("ERROR. Tienes que introducir un número entero");
			System.out.print("\nIntroduce un número entero: ");
			num=sc.nextInt();
		}
		
		if (num%3==0) {
			System.out.println(num + " es múltiplo de 3");
		}
		else if (num%4==0) {
			System.out.println(num + " es múltiplo de 4");
		}
		else if (num%5==0) {
			System.out.println(num + " es múltiplo de 5");
		}
		else {
			System.out.println(num + " no es múltiplo de 3, 4 ni 5");
		}
		sc.close();
	}

}
