package prPractica02;

import java.util.Scanner;

/**
 * 3. Simplificar el siguiente segmento de algoritmo de forma que se necesiten menos comparaciones:
		si (edad >=65) entonces
			escribir(“Jubilado”)
		si-no
			si (edad < 18) entonces
				escribir(“Menor de edad”)
			si-no
				si ((edad >= 18) Y (edad < 65)) entonces
					escribir(“Activo”)
				fin-si
			fin-si
		fin-si

 */

public class Ejercicio3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce la edad: ");
		int edad=sc.nextInt();
		
		if (edad<1||edad>100) {
			System.out.println("Error, edad no posible");
		}
		else {
			if (edad>=67) {
				System.out.println("Jubilado");
			}
			else {
				if (edad<18) {
					System.out.println("Menor de edad");
				}
				else {
					System.out.println("Activo");
				}
			}
		}
		
		sc.close();
	}

}
