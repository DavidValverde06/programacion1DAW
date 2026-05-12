package ejercicio10;

import java.util.Scanner;

/**
 * Clase de testeo de la librería de métodos de clase
 * 
 * @author David Valverde Barea
 */

public class TestLibreriaClase {

	public static void main(String[] args) {

		byte opcion;

		int[] array = new int [10];

		try (Scanner sc = new Scanner(System.in)) {

			do {
				opcion = menu(sc);

				switch (opcion) {
				case 1 -> LibreriaArraysClase.cargaDatosTeclado(sc, array); // Carga de datos desde teclado
				case 2 -> LibreriaArraysClase.cargaDatosAleatorio(array); // Carga de datos aleatoria
				case 3 -> System.out.println(LibreriaArraysClase.toString(array)); // Mostrar array
				case 4 -> System.out.println("Máximo: " + LibreriaArraysClase.elementoMax(array)); // Valor máximo del array
				case 5 -> System.out.println("Mínimo: " + LibreriaArraysClase.elementoMin(array)); // Valor mínimo del array
				case 6 -> System.out.println("Suma: " + LibreriaArraysClase.sumaElementos(array)); // Suma de los elementos del array
				case 7 -> LibreriaArraysClase.insertarPorPosicion(array, sc); // Insertar por posición
				case 8 -> LibreriaArraysClase.borrarPorPosicion(array, sc); // Borrar por posición
				case 9 -> LibreriaArraysClase.borrarPorElemento(array, sc); // Borrar buscando el número
				case 10 -> LibreriaArraysClase.borrarTodasLasAparicionesElementos(array, sc); // Borrar todas las apariciones de un elemento
				case 11 -> System.out.println("Posición encontrada: " + LibreriaArraysClase.busquedaLineal(array, sc)); // Búsqueda lineal
				case 12 -> System.out.println("Posición encontrada: " + LibreriaArraysClase.busquedaDico(array, sc)); // Búsqueda binaria
				case 13 -> LibreriaArraysClase.ordenacionBurbuja(array); // Ordenación por el método de la burbuja
				case 14 -> LibreriaArraysClase.ordenacionInsercion(array); // Ordenación por el método de inserción
				case 15 -> LibreriaArraysClase.ordenacionSeleccion(array); // Ordenación por el método de selección
				case 16 -> LibreriaArraysClase.ordenacionShell(array); // Ordenación por el método de Shell
				case 17 -> LibreriaArraysClase.desordenarArray(array); // Desordenar array
				case 18 -> System.out.println("\nSaliendo del programa..."); // Salida del bucle y fin de programa
				default -> System.out.println("Opción no válida"); // Si se introduce un número no válido mostrara este mensaje
				}

				if (opcion != 18) {
					System.out.println("\nPulsa Enter para mostrar el menú");
					sc.nextLine(); // Pulsar Enter para mostrar el menú
				}
			}
			while (opcion!=18);
		}
	}

	public static byte menu(Scanner sc) {

		byte opcion;

		System.out.println("\n --- MENU DE OPERACIONES ---");
		System.out.println("1.- Carga de datos desde teclado");
		System.out.println("2.- Carga de datos aleatoria");
		System.out.println("3.- Mostrar array");
		System.out.println("4.- Valor máximo del array");
		System.out.println("5.- Valor mínimo del array");
		System.out.println("6.- Suma de los elementos del array");
		System.out.println("7.- Insertar por posición");
		System.out.println("8.- Borrar por posición");
		System.out.println("9.- Borrar buscando el número");
		System.out.println("10.- Borrar todas las apariciones de un elemento");
		System.out.println("11.- Búsqueda lineal");
		System.out.println("12.- Búsqueda binaria o dicotómica");
		System.out.println("13.- Ordenación por el método de la burbuja");
		System.out.println("14.- Ordenación por el método de inserción");
		System.out.println("15.- Ordenación por el método de selección");
		System.out.println("16.- Ordenación por el método de Shell");
		System.out.println("17.- Desordenar array");
		System.out.println("18.- Salir");

		System.out.print("\nElija opción: ");
		opcion = sc.nextByte();
		sc.nextLine();

		return opcion;
	}

}
