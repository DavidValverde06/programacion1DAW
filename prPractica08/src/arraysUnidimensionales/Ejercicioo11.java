package arraysUnidimensionales;

import java.util.Scanner;

/**
 * 11.- Hacer un programa de menú con las siguientes opciones:
 * 	- Suma de dos polinomios de grado N y M.
 * 	- Resta de dos polinomios de grado N y M.
 * 	- Multiplicación de dos polinomios de grado N y M.
 */

public class Ejercicioo11 {

	public static void main(String[] args) {
		byte opcion;

		try (Scanner sc = new Scanner(System.in)) {

			int[] pol1 = cargarPolinomio(sc);
			int[] pol2 = cargarPolinomio(sc);
			int[] polResultado = new int[Math.max(pol1.length, pol2.length)];

			do {
				System.out.print("Polinomio 1: ");
				mostrarPolinomio(pol1);

				System.out.print("Polinomio 2: ");
				mostrarPolinomio(pol2);

				menu();
				System.out.print("\nElija una opción: ");
				opcion = sc.nextByte();
				sc.nextLine();

				switch (opcion) {
				case 1 -> System.out.println("Suma");
				case 2 -> System.out.println("Resta");
				case 3 -> System.out.println("Multiplicación");
				case 4 -> System.out.println("\nSaliendo del programa...");
				default -> System.out.println("Opción no válida");
				}

				if (opcion!=4) {
					System.out.println("\nPulsa Enter para mostrar el menú");
					sc.nextLine(); // Pulsar Enter para mostrar el menú
				}
			}
			while(opcion!=4);
		}
	}

	public static int[] cargarPolinomio(Scanner sc) {
		int grado;

		System.out.print("Introduce el grado del polinomio: ");
		grado = Math.abs(sc.nextInt());

		int[] pol = new int [grado+1];

		for (int cont=grado;cont>=0;cont--) {
			System.out.print("Introduce el grado " + cont + ": ");
			pol[cont]=sc.nextInt();
		}

		System.out.println();

		return pol;
	}

	public static void mostrarPolinomio(int[] polinomio) {
		for (int cont=polinomio.length-1;cont>=0;cont--) {
			System.out.print(polinomio[cont] + "x^" + cont + " ");
		}
		System.out.println();
	}

	public static int[] sumar(int[] pol1, int[] pol2) {

	}


	public static int[] multiplicar(int[] pol1, int[] pol2) {

	}

	public static void menu() {
		System.out.println("\n--- MENÚ ---");
		System.out.println("1.- Suma de dos polinomios de grado N y M");
		System.out.println("2.- Resta de dos polinomios de grado N y M");
		System.out.println("3.- Multiplicación de dos polinomios de grado N y M");
		System.out.println("4.- Salir");
	}
}
