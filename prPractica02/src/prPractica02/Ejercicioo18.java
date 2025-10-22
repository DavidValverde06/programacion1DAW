package prPractica02;

import java.util.Scanner;

/**
 * 18. Un programa posee tres bucles anidados, cuyas variables de control toman M, N y K valores
	   respectivamente. Determinar cuántas veces se ejecutan las instrucciones del cuerpo del bucle más
	   interno.
 */

public class Ejercicioo18 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int m,n,k,total=0;
		
		System.out.print("Introduce el valor de M: ");
		m=sc.nextInt();
		System.out.print("Introduce el valor de N: ");
		n=sc.nextInt();
		System.out.print("Introduce el valor de K: ");
		k=sc.nextInt();
		
		for (int cont=0;cont<m;cont++) {
			for (int cont2=0;cont2<n;cont2++) {
				for (int cont3=0;cont3<k;cont3++) {
					total++;
				}
			}
		}
		
		System.out.println("\nSe ejecuta un total de " + total + " veces.");
		
		sc.close();
	}

}
