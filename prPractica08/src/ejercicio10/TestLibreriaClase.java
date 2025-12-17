package ejercicio10;

import java.util.Scanner;

public class TestLibreriaClase {

	public static void main(String[] args) {

		byte opcion;

		int[] array = new int [10];
		
		try (Scanner sc = new Scanner(System.in)) {

			do {
				opcion = menu(sc);

				switch (opcion) {
				case 1 -> LibreriaArraysClase.cargaDatosTeclado(sc, array);
				case 2 -> LibreriaArraysClase.cargaDatosAleatorio(array);
				case 3 -> System.out.println(LibreriaArraysClase.toString(array));
//				case 4 -> 
//				case 5 -> 
//				case 6 -> 
//				case 7 ->
//				case 8 -> 
//				case 9 ->
//				case 10 ->
//				case 11 -> 
//				case 12 -> 
//				case 13 -> 
//				case 14 -> 
//				case 15 -> 
//				case 16 ->
				case 17 -> System.out.println("\nSaliendo del programa...");
				default -> System.out.println("Opción no válida");
				}
			}
			while (opcion!=17);
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
		System.out.println("10.- Búsqueda lineal");
		System.out.println("11.- Búsqueda binaria o dicotómica");
		System.out.println("12.- Ordenación por el método de la burbuja");
		System.out.println("13.- Ordenación por el método de inserción");
		System.out.println("14.- Ordenación por el método de selección");
		System.out.println("15.- Ordenación por el método de Shell");
		System.out.println("16.- Desordenar array");
		System.out.println("17.- Salir");
		
		System.out.print("\nElija opción: ");
		opcion = sc.nextByte();
		
		return opcion;
	}

}
