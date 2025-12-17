package ejercicio10;

import java.util.Scanner;

/**
 * Librería con métodos de objeto para manejar arrays, el array con el 
 * que trabajaremos será variable de instancia.
 * 
 * Esta librería incluirá los siguientes métodos:
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

public class LibreriaArraysObjeto {

	private static final int NUM_ELEM_DEFECTO = 10;

	/**
	 * Variables de instancia
	 */
	private int [] array;

	/**
	 * Constructor
	 */
	public LibreriaArraysObjeto(int numElementos) {
		this.array = new int[numElementos];
	}

	public LibreriaArraysObjeto() {
		//this.array = new int[NUM_ELEM_DEFECTO];
		this(NUM_ELEM_DEFECTO);
	}

	/**
	 * Getter's y setter's
	 */
	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}


	/**
	 * =================
	 * MÉTODOS DE OBJETO
	 * =================
	 */

	/**
	 * Método Carga de datos de teclado
	 */
	public void cargaDatosTeclado(Scanner sc) {
		for (int cont=0;cont<array.length;cont++) {
			System.out.print("Introduzca el elemento de la posición " + (cont+1) + ": ");
			array[cont]=sc.nextInt();
		}
	}

	/**
	 * Método Carga de datos aleatoria
	 */
	public void cargaDatosAleatorio() {
		for (int cont=0;cont<array.length;cont++) {
			array[cont]=(int)(Math.random()*20)+1; // Números entre 1 y 20
		}
	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		String cadena = "Array: ";
		for (int cont=0;cont<array.length;cont++) {
			cadena+=array[cont] + " ";
		}
		return cadena;
	}

	public String toString2() {
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
	public int elementoMax() {
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
	public int elementoMin() {
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
	public int sumaElementos() {
		int sumaElementos=0;
		for (int cont=0;cont<array.length;cont++) {
			sumaElementos+=array[cont];
		}
		return sumaElementos;
	}

	/**
	 * Métodos de búsqueda dicotómica o binaria
	 */
	public void busquedaDico(int[] array, int numeroBuscar) {
		for (int cont=0;cont<array.length;cont++) {

		}
	}

	/**
	 * Método de la burbuja
	 */
	public void ordenacionBurbuja(int[] array) {
		int cont=1,aux;
		boolean ordenado=false;

		while (cont<array.length && ordenado==false) {
			ordenado=true;
			for (int cont2=array.length-1;cont2>=cont;cont2--) {

				if (array[cont2]<array[cont2-1]) {
					aux=array[cont2];
					array[cont2]=array[cont2-1];
					array[cont2-1]=aux;
					ordenado = false;
				}
			}
			cont++;
		}
	}
}
