package prPracticaRepaso01;

import java.util.Scanner;

/**
 * 4. Calcular la última cifra del cuadrado de un número y el número de cifras.
 */

public class Ejercicio4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num,cuadrado;
		
		System.out.print("Introduce un número: ");
		num=sc.nextInt();
		
		cuadrado = (int)(Math.pow(num, 2));
		
		System.out.println("Cuadrado de " + num + ": " + cuadrado);
		
		System.out.println("\nÚltima cifra: " + cuadrado%10);
		System.out.println("Número de cifras: " + String.valueOf(cuadrado).length());
		
		sc.close();
	}

}
