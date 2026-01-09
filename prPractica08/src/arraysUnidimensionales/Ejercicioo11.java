package arraysUnidimensionales;

import java.util.Scanner;

/**
 * 11.- Hacer un programa de menú con las siguientes opciones:
 * 	- Suma de dos polinomios de grado N y M.
 * 	- Resta de dos polinomios de grado N y M.
 * 	- Multiplicación de dos polinomios de grado N y M.
 */

public class Ejercicioo11 {

	sin hacer
	
	public static void main(String[] args) {
		byte opcion;

		int[] polinomio1 = new int[4];
		int[] polinomio2 = new int[2];

		try (Scanner sc = new Scanner(System.in)) {

			do {
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
				if (opcion != 4) {
					System.out.println("\nPulsa Enter para mostrar el menú");
					sc.nextLine(); // Pulsar Enter para mostrar el menú
				}
			}
			while(opcion!=4);
		}
	}

	public static void menu() {
		System.out.println("\n--- MENÚ ---");
		System.out.println("1.- Suma de dos polinomios de grado N y M");
		System.out.println("2.- Resta de dos polinomios de grado N y M");
		System.out.println("3.- Multiplicación de dos polinomios de grado N y M");
		System.out.println("4.- Salir");
	}
}
