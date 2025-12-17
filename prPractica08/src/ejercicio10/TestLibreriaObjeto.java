package ejercicio10;

import java.util.Scanner;

public class TestLibreriaObjeto {

	public static void main(String[] args) {

		byte opcion;

		LibreriaArraysObjeto ob = new LibreriaArraysObjeto(8);

		try (Scanner sc = new Scanner(System.in)) {

			do {
				menu();

				System.out.print("\nElija opción: ");
				opcion = sc.nextByte();

				switch (opcion) {
				case 1 -> ob.cargaDatosTeclado(sc);
				case 2 -> ob.cargaDatosAleatorio();
				case 3 -> System.out.println(ob.toString2());
				case 4 -> System.out.println("Valor máximo: " + ob.elementoMax());
				case 5 -> System.out.println("Valor mínimo: " + ob.elementoMin());
				case 6 -> System.out.println("Suma elementos: " + ob.sumaElementos());
//				case 7 ->
//				case 8 -> 
//				case 9 ->
//				case 10 ->
				case 11 -> ob.busquedaDico(ob.getArray(), 1);
				case 12 -> ob.ordenacionBurbuja(ob.getArray());
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
		System.out.println("10.- Búsqueda lineal");
		System.out.println("11.- Búsqueda binaria o dicotómica");
		System.out.println("12.- Ordenación por el método de la burbuja");
		System.out.println("13.- Ordenación por el método de inserción");
		System.out.println("14.- Ordenación por el método de selección");
		System.out.println("15.- Ordenación por el método de Shell");
		System.out.println("16.- Desordenar array");
		System.out.println("17.- Salir");
	}
}
