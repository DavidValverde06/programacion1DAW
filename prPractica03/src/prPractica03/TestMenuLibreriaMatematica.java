package prPractica03;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * • Calcular el factorial de un número.
 * • Mostrar el combinatorio de dos números dados.
 * • Visualizar los números primos entre dos números dados.
 * • Visualizar por pantalla los números perfectos que hay entre 2 números dados.
 * • Visualizar por pantalla las parejas de números amigos que hay entre 2 números dados.
 * • Comprobar si dos números son primos entre sí.
 * • Calcular la función de Euler de un número.
 * • Salir.
 */

public class TestMenuLibreriaMatematica {

	public static void main(String[] args) {

		int numA,numB,opcion=0;
		boolean validacion=true;

		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("\n=== MENÚ LIBRERÍA MATEMÁTICA ===");
			System.out.println("1. Calcular el factorial de un número.");
			System.out.println("2. Mostrar el combinatorio de dos números dados.");
			System.out.println("3. Visualizar los números primos entre dos números dados.");
			System.out.println("4. Visualizar por pantalla los números perfectos que hay entre 2 números dados.");
			System.out.println("5. Visualizar por pantalla las parejas de números amigos que hay entre 2 números dados.");
			System.out.println("6. Comprobar si dos números son primos entre sí.");
			System.out.println("7. Calcular la función de Euler de un número.");
			System.out.println("8. Salir.");

			try {
				System.out.print("\nIntroduce una opción del menú: ");
				opcion=sc.nextInt();
			}
			catch (InputMismatchException e) {
				System.out.println("ERROR. INTRODUCE UN NÚMERO ENTERO.");
				sc.next();
			}

			switch (opcion) {
			case 1 -> { // Calcular el factorial de un número.
				System.out.print("\nIntroduce un número positivo para calcular el factorial: ");
				numA=sc.nextInt();

				System.out.println("Factorial de " + numA + ": " + LibreriaMatematica.calcularFactorial(numA));
			}

			case 2 -> { // Mostrar el combinatorio de dos números dados.
				System.out.print("Introduce el primer número para calcular el combinatorio: ");
				numA=sc.nextInt();

				System.out.print("Introduce el segundo número para calcular el combinatorio: ");
				numB=sc.nextInt();

				System.out.println(LibreriaMatematica.calcularCombinatorio(numA, numB));
			}

			case 3 -> { // Visualizar los números primos entre dos números dados.
				System.out.print("Introduce el primer número: ");
				numA=sc.nextInt();

				System.out.print("Introduce el segundo número: ");
				numB=sc.nextInt();

				for (int cont=numA;cont<numB;cont++) {
					if (LibreriaMatematica.esPrimo(cont)==true) {
						System.out.print(cont + " ");
					}
				}
				System.out.println();
			}

			case 4 -> { // Visualizar por pantalla los números perfectos que hay entre 2 números dados.
				System.out.print("Introduce el primer número: ");
				numA=sc.nextInt();

				System.out.print("Introduce el segundo número: ");
				numB=sc.nextInt();

				for (int cont=numA;cont<numB;cont++) {
					if (LibreriaMatematica.esPerfecto(cont)==true) {
						System.out.print(cont + " ");
					}
				}
				System.out.println();
			}

			case 5 -> { // Visualizar por pantalla las parejas de números amigos que hay entre 2 números dados.
				System.out.print("Introduce el primer número: ");
				numA=sc.nextInt();

				System.out.print("Introduce el segundo número: ");
				numB=sc.nextInt();

				for (int cont=numA;cont<numB;cont++) {
					if (LibreriaMatematica.sonAmigos(numA, numB)) {
						System.out.print(cont + " ");
					}
				}
				System.out.println();
			}

			case 6 -> { // Comprobar si dos números son primos entre sí.
				System.out.print("Introduce el primer número: ");
				numA=sc.nextInt();

				System.out.print("Introduce el segundo número: ");
				numB=sc.nextInt();

				System.out.println(LibreriaMatematica.primosEntreSi(numA, numB));

			}

			case 7 -> { // Calcular la función de Euler de un número.
				System.out.print("Introduce un número para calcular su funcion de Euler: ");
				numA=sc.nextInt();

				System.out.println(LibreriaMatematica.funcionEuler(numA));
			}

			case 8 -> { // Salir
				validacion=false;
				System.out.println("Saliendo...");
			}

			default -> System.out.println("Introduce una opción válida");
			}
		}
		while (validacion==true);

		System.out.println("\nFIN DE PROGRAMA");

		sc.close();
	}

}
