package prPractica02;

import java.util.Scanner;

/**
 * 21. Programa que imprima la tabla de multiplicar de un número entero (entre 1 y 10). 
 */

public class Ejercicioo21 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce un número: ");
		int num=sc.nextInt();
		
		if (num>10||num<1) {
			System.out.println("ERROR. Elige un número entre el 1 y el 10.");
		}
		else {
			System.out.println("\nTABLA DEL " + num);
			for (int cont=0;cont<=10;cont++) {
				System.out.println(num + " x " + cont + " = " + num * cont);
			}
		}
		
		sc.close();
	}

}
