package prPractica02;

import java.util.InputMismatchException;
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

		Scanner sc = new Scanner(System.in);

		//		VARIABLES
		int num;
		double resultado=1;
		char opciones;
		boolean finalizarPrograma=true;

		//		LECTURA ADELANTADA
		System.out.print("Introduce la opción: ");
		opciones=sc.next().charAt(0);
		opciones=Character.toLowerCase(opciones); // ESTO CAMBIA LAS MAYUS POR MINUS

		if (opciones!='f' && opciones!='r' && opciones!='c' && opciones!='t') {
			System.out.println("ERROR - Cerrando programa");
		}

		else {

			while (finalizarPrograma != false) {
				switch (opciones) {

				// FACTORIAL DE UN NÚMERO
				case 'f':
					try {
						System.out.print("Introduce un número entero positivo: ");
						num=sc.nextInt();

						if (num<0) {
							System.out.println("El número es negativo, no tiene factorial.");
						}
						else {
							for (int cont=num;cont>0;cont--) {
								resultado=resultado*cont;
							}

							System.out.println("El factorial de " + num + " es: " + (int)resultado);
						}
					}
					catch (InputMismatchException e) {
						System.out.println("ERROR. INTRODUCE UN NÚMERO VÁLIDO");
					}

					System.out.print("\nIntroduce la opción: ");
					opciones=sc.next().charAt(0);
					opciones=Character.toLowerCase(opciones); // ESTO CAMBIA LAS MAYUS POR MINUS

					break;

					// RAIZ CUADRADA DE UN NÚMERO
				case 'r':
					try {
						System.out.print("Introduce un número entero positivo: ");
						num=sc.nextInt();

						if (num<0) {
							System.out.println("ERROR. NÚMERO NEGATIVO");
						}
						else {
							resultado = Math.sqrt(num);
							System.out.println("La raíz cuadrada de " + num + " es " + resultado );
						}
					}
					catch (InputMismatchException e) {
						System.out.println("ERROR. INTRODUCE UN NÚMERO VÁLIDO");
					}

					System.out.print("\nIntroduce la opción: ");
					opciones=sc.next().charAt(0);
					opciones=Character.toLowerCase(opciones); // ESTO CAMBIA LAS MAYUS POR MINUS

					break;

					//		CUADRADO DE UN NUMERO
				case 'c':
					try {
						System.out.print("Introduce un número entero positivo: ");
						num=sc.nextInt();

						if (num<0) {
							System.out.println("ERROR. NÚMERO NEGATIVO");
						}
						else {
							resultado = Math.pow(num,2);
							System.out.println("El cuadrado de " + num + " es " + (int)resultado );
						}
					}
					catch (InputMismatchException e) {
						System.out.println("ERROR. INTRODUCE UN NÚMERO VÁLIDO");
					}

					System.out.print("\nIntroduce la opción: ");
					opciones=sc.next().charAt(0);
					opciones=Character.toLowerCase(opciones); // ESTO CAMBIA LAS MAYUS POR MINUS

					break;

					//		FINALIZAR PROGRAMA
				case 't':
					System.out.println("Cerrando programa...");
					finalizarPrograma=false;

					break;
					
				default:
					System.out.println("ERROR - Cerrando programa...");
					finalizarPrograma=false;

					break;
				}
			}
		}

		System.out.println("\nFIN DE PROGRAMA");

		sc.close();
	}

}
