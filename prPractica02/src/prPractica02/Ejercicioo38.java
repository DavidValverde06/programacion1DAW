package prPractica02;

import java.util.Scanner;

/**
 * 38. Realizar un algoritmo con un menú de 4 opciones. La selección de cada opción se realizará usando una
	   variable de tipo carácter. Cada una de las opciones realizará las siguientes tareas:

		F: Calculará el factorial.
		R: Calculará la raíz cuadrada de un número si es positivo y si es negativo, dará un
		mensaje de error.
		C: Calculará el cuadrado de un número.
		T: Finalizará el algoritmo.

	El proceso se estará repitiendo hasta que el usuario elija la opción T de Finalización del algoritmo
 */

public class Ejercicioo38 {

	public static void main(String[] args) {

		sin hacer
		
		Scanner sc = new Scanner(System.in);

		int num,resultado=0;
		char opciones;

		System.out.print("Introduce la opción: ");
		opciones=sc.next().charAt(0);

		switch (opciones) {
//		FACTORIAL
		case 'F':
			
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
			}
			break;
			
		case 'R':

			break;
		case 'C':

			break;
		case 'T':

			break;
		default:
			break;
		}
	}

}
