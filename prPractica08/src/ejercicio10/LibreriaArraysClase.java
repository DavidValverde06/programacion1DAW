package ejercicio10;

import java.util.Scanner;

/**
 * Librería con métodos de clases para manejar arrays, esta
 * librería incluirá los siguientes métodos:
 *    - Carga de datos de teclado
 *    - Carga de datos aleatoria
 *    - toString
 *    - Elemento máximo del array
 *    - Elemento mínimo del array
 *    - Suma de los elementos del array
 *    - Métodos de búsqueda (lineal y dicotómica o binaria)
 *    - Métodos varios de ordenación (burbuja, selección, inserción y Shell)
 *    - Método que desordene el array
 *    - Método de insertar por posición
 *    - Método de borrar por posición
 *    - Método de borrar por elemento
 *    - Método para borrar todas las apariciones de un elemento
 * 
 * @author profesor
 *
 */

public class LibreriaArraysClase {

	/**
	 * ================
	 * MÉTODOS DE CLASE
	 * ================
	 */
	
	/**
	 * Método Carga de datos de teclado
	 */
	public static void cargaDatosTeclado(Scanner sc,int[] array) {
		for (int cont=0;cont<array.length;cont++) {
			System.out.print("Introduzca el elemento de la posición " + (cont+1) + ": ");
			array[cont]=sc.nextInt();
		}
	}

	/**
	 * Método Carga de datos aleatoria
	 */
	public static void cargaDatosAleatorio(int[] array) {
		for (int cont=0;cont<array.length;cont++) {
			array[cont]=(int)(Math.random()*20)+1; // Números entre 1 y 20
		}
	}

	/**
	 * toString
	 */
	public static String toString(int[] array) {
		String cadena = "Array: ";
		for (int cont=0;cont<array.length;cont++) {
			cadena+=array[cont] + " ";
		}
		return cadena;
	}

	public static String toString2(int[] array) {
		String cadena = "Array: ";
		for (int cont=0;cont<array.length;cont++) {
			if (cont!=array.length-1) {
				cadena+=array[cont] + ",";
			}
			else {
				cadena+=array[cont];
			}
		}
		return cadena;
	}
	
	/**
	 * Método Elemento máximo del array.
	 */
	public static int elementoMax(int[] array) {
		int max=array[0];
		for (int cont=0;cont<array.length;cont++) {
			if (array[cont]>max) {
				max=array[cont];
			}
		}
		return max;
	}

	/**
	 * Método Elemento mínimo del array
	 */
	public static int elementoMin(int[] array) {
		int min=array[0];
		for (int cont=0;cont<array.length;cont++) {
			if (array[cont]<min) {
				min=array[cont];
			}
		}
		return min;
	}

	/**
	 * Método Suma de los elementos del array
	 */
	public static int sumaElementos(int[] array) {
		int sumaElementos=0;
		for (int cont=0;cont<array.length;cont++) {
			sumaElementos+=array[cont];
		}
		return sumaElementos;
	}
}
