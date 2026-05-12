package prPractica01;

import java.util.Scanner;

/**
 * 4.- Diseñar una aplicación que calcule la longitud y el área de una circunferencia. Para ello el usuario debe
	   introducir el radio (que puede contender decimales). 
 */

public class Ejercicio4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		double radio,longitud,area;
		
		System.out.print("Introduce el radio de la circunferencia: ");
		
		radio = sc.nextDouble();
		
		longitud= (2*Math.PI*radio);	// longitud = 2 x π x radio
		area= (Math.PI*Math.pow(radio, 2));	// area = π x radio2
		
		System.out.println("La longitud de la circunferencia es: " + longitud);
		System.out.println("El area de la circunferencia: " + area);
		
		sc.close();
		
	}

}
