package prPractica02;

import java.util.Scanner;

/**
 * 36. Realizar un programa que cuente los números positivos y negativos que aparezcan en una lista de
	   números que se introducen por teclado. El proceso finalizará introduciendo el número 0
 */

public class Ejercicioo36 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int num=1,contadorPositivos=0,contadorNegativos=0;

		while (num!=0) {
			System.out.print("Introduce un número positivo o negativo: ");
			num=sc.nextInt();
			
			if (num>0) {
				contadorPositivos++;
			}
			if (num<0) {
				contadorNegativos++;
			}
		}

		System.out.println("\nContador de números positivos: " + contadorPositivos);
		System.out.println("Contador de números negativos: " + contadorNegativos);

		sc.close();
	}

}
