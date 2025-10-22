package prPractica01;

import java.util.Scanner;

/**
 * 3.- Realizar un programa que calcule la media aritmética de tres valores que se han leído de teclado, y
	   muestre el resultado por pantalla.
 */

public class Ejercicio3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		double num1,num2,num3,media;
		
		System.out.println("Introduce tres números para calcular su media aritmética: ");
		
		num1=sc.nextInt();
		num2=sc.nextInt();
		num3=sc.nextInt();
		
		media=(num1+num2+num3)/3;
		
		System.out.println("La media aritmética de " + num1 + ", " + num2 + " y " + num3 + " es: " + media);
		
		sc.close();
	}

}
