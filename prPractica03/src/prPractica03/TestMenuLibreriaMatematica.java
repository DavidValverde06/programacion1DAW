package prPractica03;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * • 1.Calcular el factorial de un número.
 * • 2.Mostrar el combinatorio de dos números dados.
 * • 3.Visualizar los números primos entre dos números dados.
 * • 4.Visualizar por pantalla los números perfectos que hay entre 2 números dados.
 * • 5.Visualizar por pantalla las parejas de números amigos que hay entre 2 números dados.
 * • 6.Comprobar si dos números son primos entre sí.
 * • 7.Calcular la función de Euler de un número.
 * • 8.Salir.
 */

public class TestMenuLibreriaMatematica {

	// -------------------------------------------------------------------------
	public static void main(String[] args) { // Inicio del main
		// Variables
		int opcion;
		boolean validacion=true;

		Scanner sc = new Scanner(System.in);

		do { // Inicio del bucle do... while
			menu();
			try {
				System.out.print("\nIntroduce una opción del menú: ");
				opcion=sc.nextInt();
				switch (opcion) {
				case 1 -> opcion1(sc);
				case 2 -> opcion2(sc);
				case 3 -> opcion3(sc);
				case 4 -> opcion4(sc);
				case 5 -> opcion5(sc);
				case 6 -> opcion6(sc);
				case 7 -> opcion7(sc);
				case 8 -> {opcion8(sc); validacion=false;}
				default -> System.err.println("\n\tERROR. INTRODUCE UNA OPCIÓN VÁLIDA"); // Controlar error por si se introduce un valor fuera del rango (1-8)
				}
			}
			catch (InputMismatchException e) { // Controlar error por si se introducen carácteres en lugar de números enteros
				System.err.println("\n\tERROR. INTRODUCE UN NÚMERO ENTERO.");
				sc.next();
			}
		}
		while (validacion==true); // Fin del bucle do... while
		System.out.println("\nFIN DE PROGRAMA");
		sc.close();
	} // Fin del main
	// -------------------------------------------------------------------------

	// Menú
	public static void menu() {
		System.out.println("\n=== MENÚ LIBRERÍA MATEMÁTICA ===");
		System.out.println("1. Calcular el factorial de un número.");
		System.out.println("2. Mostrar el combinatorio de dos números dados.");
		System.out.println("3. Visualizar los números primos entre dos números dados.");
		System.out.println("4. Visualizar por pantalla los números perfectos que hay entre 2 números dados.");
		System.out.println("5. Visualizar por pantalla las parejas de números amigos que hay entre 2 números dados.");
		System.out.println("6. Comprobar si dos números son primos entre sí.");
		System.out.println("7. Calcular la función de Euler de un número.");
		System.out.println("8. Salir.");
	}

	// Calcular el factorial de un número.
	public static void opcion1(Scanner sc) {
		int num;
		System.out.print("Introduce un número positivo para calcular el factorial: ");
		num=sc.nextInt();

		System.out.println("\n\t=== RESULTADO ===");
		if (LibreriaMatematica.calcularFactorial(num)==-1) {
			System.out.println("\tNo existe el factorial de números negativos.");
		}
		else {
			System.out.println("\tFactorial de " + num + " es: " + LibreriaMatematica.calcularFactorial(num));
		}

	}

	// Mostrar el combinatorio de dos números dados.
	public static void opcion2(Scanner sc) {
		int num1,num2;
		System.out.print("Introduce el primer número para calcular el combinatorio: ");
		num1=sc.nextInt();

		System.out.print("Introduce el segundo número para calcular el combinatorio: ");
		num2=sc.nextInt();

		System.out.println("\n\t=== RESULTADO ===");
		if (LibreriaMatematica.calcularCombinatorio(num1, num2)==-1) {
			System.out.println("\tNo se puede calcular el combinatorio de un número negativo.");
		}
		else {
			System.out.println("\tCombinatorio de " + num1 + " y " + num2 + " es: " + LibreriaMatematica.calcularCombinatorio(num1, num2));
		}
	}

	// Visualizar los números primos entre dos números dados.
	public static void opcion3(Scanner sc) {
		int num1,num2;
		System.out.print("Introduce el primer número: ");
		num1=sc.nextInt();

		System.out.print("Introduce el segundo número: ");
		num2=sc.nextInt();

		System.out.println("\n\t=== RESULTADO ===");
		System.out.print("\tNúmeros primos entre " + num1 + " y " + num2 + ": ");

		for (int cont=num1;cont<num2;cont++) {
			if (LibreriaMatematica.esPrimo(cont)==true) {
				System.out.print(cont + " ");
			}
		}
		System.out.println();
	}

	// Visualizar por pantalla los números perfectos que hay entre 2 números dados.
	public static void opcion4(Scanner sc) {
		int num1,num2;
		System.out.print("Introduce el primer número: ");
		num1=sc.nextInt();

		System.out.print("Introduce el segundo número: ");
		num2=sc.nextInt();

		System.out.println("\n\t=== RESULTADO ===");
		System.out.print("\tNúmeros perfectos entre " + num1 + " y " + num2 + ": ");

		for (int cont=num1;cont<num2;cont++) {
			if (LibreriaMatematica.esPerfecto(cont)==true) {
				System.out.print(cont + " ");
			}
		}
		System.out.println();
	}

	// Visualizar por pantalla las parejas de números amigos que hay entre 2 números dados.
	public static void opcion5(Scanner sc) {
		int num1,num2;
		System.out.print("Introduce el primer número: ");
		num1=sc.nextInt();

		System.out.print("Introduce el segundo número: ");
		num2=sc.nextInt();

		System.out.println("\n\t=== RESULTADO ===");
		System.out.println("\tParejas de números amigos entre " + num1 + " y " + num2 + ": ");

		for (int cont=num1;cont<num2;cont++) {
			for (int cont2=cont+1;cont2<num2;cont2++) {
				if (LibreriaMatematica.sonAmigos(cont, cont2)) {
					System.out.println("\t" + cont + " y " + cont2);
				}
			}
		}
	}

	// Comprobar si dos números son primos entre sí.
	public static void opcion6(Scanner sc) {
		int num1,num2;
		System.out.print("Introduce el primer número: ");
		num1=sc.nextInt();

		System.out.print("Introduce el segundo número: ");
		num2=sc.nextInt();

		System.out.println("\n\t=== RESULTADO ===");

		System.out.print("\t¿Son " + num1 + " y " + num2 + " números primos entre sí?: " + (LibreriaMatematica.primosEntreSi(num1, num2)?"Verdadero":"Falso") + "\n");

	}

	// Calcular la función de Euler de un número.
	public static void opcion7(Scanner sc) {
		int num;
		System.out.print("Introduce un número para calcular su funcion de Euler: ");
		num=sc.nextInt();

		System.out.println("\n\t=== RESULTADO ===");

		if (LibreriaMatematica.funcionEuler(num)==-1) {
			System.out.println("\tNo se puede calcular la función de Euler de un número negativo.");
		}
		else {
			System.out.print("\tLa función de Euler del número " + num + " es: " + LibreriaMatematica.funcionEuler(num) + "\n");	
		}
	}

	// Salir
	public static void opcion8(Scanner sc) {
		System.out.println("\n\tSaliendo del programa...");
	}
}
