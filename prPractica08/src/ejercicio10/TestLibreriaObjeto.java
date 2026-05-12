package ejercicio10;

import java.util.Scanner;

/**
 * Clase de testeo de la librería de métodos de objeto
 * 
 * @author David Valverde Barea
 */

public class TestLibreriaObjeto {

	public static void main(String[] args) {

		byte opcion;

		LibreriaArraysObjeto ob = new LibreriaArraysObjeto(8);

		try (Scanner sc = new Scanner(System.in)) {

			do {
				menu();

				System.out.print("\nElija una opción: ");
				opcion = sc.nextByte();
				sc.nextLine();

				switch (opcion) {
				case 1 -> ob.cargaDatosTeclado(sc); // Carga de datos desde teclado
				case 2 -> ob.cargaDatosAleatorio(); // Carga de datos aleatoria
				case 3 -> System.out.println(ob.toString()); // Mostrar array			
				case 4 -> System.out.println("Valor máximo: " + ob.elementoMax()); // Valor máximo del array
				case 5 -> System.out.println("Valor mínimo: " + ob.elementoMin()); // Valor mínimo del array				
				case 6 -> System.out.println("Suma elementos: " + ob.sumaElementos()); // Suma de los elementos del array
				case 7 -> ob.insertarPorPosicion(ob.getArray(),sc); // Insertar por posición
				case 8 -> ob.borrarPorPosicion(ob.getArray(), sc); // Borrar por posición
				case 9 -> ob.borrarPorElemento(ob.getArray(), sc); // Borrar buscando el número
				case 10 -> ob.borrarTodasLasAparicionesElementos(ob.getArray(), sc); // Borrar todas las apariciones de un elemento
				case 11 -> System.out.println("Resultado búsqueda lineal: " + ob.busquedaLineal(ob.getArray(),sc)); // Búsqueda lineal
				case 12 -> System.out.println("Resultado búsqueda binaria: " + ob.busquedaDico(ob.getArray(),sc)); // Búsqueda binaria
				case 13 -> ob.ordenacionBurbuja(ob.getArray()); // Ordenación por el método de la burbuja
				case 14 -> ob.ordenacionSeleccion(ob.getArray()); // Ordenación por el método de inserción
				case 15 -> ob.ordenacionInsercion(ob.getArray()); // Ordenación por el método de selección
				case 16 -> ob.ordenacionShell(ob.getArray()); // Ordenación por el método de Shell				
				case 17 -> ob.desordenarArray(ob.getArray()); // Desordenar array
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

	public static void menu() {
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
	}
}
