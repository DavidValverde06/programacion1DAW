package prPractica02;

import java.util.Scanner;

/**
 * 14. Diseñar un algoritmo para leer las longitudes de los lados de un triángulo y determine que tipo de
	   triángulo es, de acuerdo a los siguientes casos: suponiendo que A es el mayor de los lados y que B y C
	   corresponden a los otros 2 lados:
		Si A >= B + C No es un triángulo
		Si A² = B² + C² Triángulo rectángulo
		Si A² > B² + C² Triángulo obtusángulo
		Si A² < B² + C² Triángulo acutángulo
 */

public class Ejercicioo14 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		float ladoA,ladoB,ladoC;
		
		System.out.print("Introduce la longitud del lado A: ");
		ladoA=sc.nextFloat();
		System.out.print("Introduce la longitud del lado B: ");
		ladoB=sc.nextFloat();
		System.out.print("Introduce la longitud del lado C: ");
		ladoC=sc.nextFloat();
		
		if (ladoA >= ladoB + ladoC) {
			System.out.println("\nNo es un triángulo.");
		}
		else if (Math.pow(ladoA, 2) == (Math.pow(ladoB, 2))+Math.pow(ladoC, 2)) {
			System.out.println("\nTriángulo rectángulo.");
		}
		else if (Math.pow(ladoA, 2) > (Math.pow(ladoB, 2))+Math.pow(ladoC, 2)) {
			System.out.println("\nTriángulo acutángulo.");
		}
		else if (Math.pow(ladoA, 2) < (Math.pow(ladoB, 2))+Math.pow(ladoC, 2)) {
			System.out.println("\nTriángulo rectángulo.");
		}
		
		sc.close();
	}

}
