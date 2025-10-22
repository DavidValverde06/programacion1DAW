package prPractica02;

import java.util.Scanner;

/**
 * 27. Hacer un algoritmo para calcular el factorial de un número natural positivo, se debe tener en cuenta si
       el número no es positivo, ya que no existe el factorial de los números negativos.
 */

public class Ejercicioo27 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num,resultado=1;
		
		System.out.print("Introduce un número entero positivo: ");
		num=sc.nextInt();
		
		if (num<0) {
			System.out.println("El número es negativo, no tiene factorial.");
		}
		else {
			for (int cont=num;cont>0;cont--) {
				resultado=resultado*cont;
			}
			
			System.out.println("El factorial de " + num + " es: " + resultado);
			
			sc.close();
		}
	}

}
