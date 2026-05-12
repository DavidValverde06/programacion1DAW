package prPractica02;

import java.util.Scanner;

/**
 * 26. Hacer un algoritmo que nos sume, los números naturales que sean pares, y menores que un número
	   introducido por teclado.
 */

public class Ejercicioo26 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num,suma=0;
		
		System.out.print("Introduce un número: ");
		num=sc.nextInt();
		
		for (int cont=2;cont<num;cont+=2) {
			suma+=cont;
			System.out.print(cont + " ");
		}
		
		System.out.println("\nSuma: " + suma);
		
		System.out.println();
		
		suma=0;
		
		// Bucle al revés
		if (num%2==0) {
			num-=2;
		}
		else {
			num-=1;
		}
		for (int cont=num;cont>=2;cont-=2) {
			suma+=cont;
			System.out.print(cont + " ");
		}
		
		System.out.println("\nSuma: " + suma);
		
		sc.close();
	}

}
