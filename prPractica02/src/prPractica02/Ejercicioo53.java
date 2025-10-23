package prPractica02;

import java.util.Scanner;

/**
 * 53. Diseñar un algoritmo que determine si la cadena “abc”, aparece en una sucesión de caracteres cuyo final
	   viene dado por un punto. No se lee una cadena, sino caracteres sueltos.

 */

public class Ejercicioo53 {

	public static void main(String[] args) {

		sin hacer
		
		Scanner sc = new Scanner(System.in);

		char caracter;
		String cadena="";

		System.out.print("Teclee un carácter: ");
		caracter=sc.next().charAt(0);

		while (caracter!='.') {

			cadena+=caracter;
			
			System.out.println(cadena);

			System.out.print("Teclee un carácter: ");
			caracter=sc.next().charAt(0);
		}

		sc.close();
	}
}
