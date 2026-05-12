package prExamenAnioPasado;

import java.util.Scanner;

/**
 * Realiza un programa que simule el lanzamiento de tres dados. El programa debe mostrar el valor de cada dado, calcular la 
 * suma total y el promedio de los tres valores. Finalmente, debe mostrar un mensaje indicando si los tres dados han sacado 
 * el mismo número.
 */

public class Ejercicio4RepasoExamen {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int dado1,dado2,dado3,numTiradas;
		float suma;
		
		System.out.print("Introduce el número de tiradas: ");
		numTiradas=sc.nextInt();
		
		if (numTiradas<=0) {
			System.out.println("Introduce un número de tiradas válido");
		}
		else {
			
			for (int cont=0;cont<numTiradas;cont++) {
				
				dado1=(int)(Math.random()*6)+1;
				dado2=(int)(Math.random()*6)+1;
				dado3=(int)(Math.random()*6)+1;
				
				System.out.println("\nDado 1: " + dado1);
				System.out.println("Dado 2: " + dado2);
				System.out.println("Dado 3: " + dado3);
				
				suma=dado1+dado2+dado3;
				
				System.out.println("\nSuma de los dados: " + (int)suma);
				System.out.println("Promedio de los dados: " + suma/3.0f);
				
				if (dado1==dado2 && dado2==dado3) {
					System.out.println("Los números de los dados son iguales");
				}
				
			}
		}
		
		sc.close();
	}

}
