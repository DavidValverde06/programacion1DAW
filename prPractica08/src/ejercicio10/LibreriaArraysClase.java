package ejercicio10;

import java.util.Random;
import java.util.Scanner;

/**
 * Librería con métodos de clases para manejar arrays, esta
 * librería incluirá los siguientes métodos:
 *    - Carga de datos de teclado ✓
 *    - Carga de datos aleatoria ✓
 *    - toString ✓
 *    - Elemento máximo del array ✓
 *    - Elemento mínimo del array ✓
 *    - Suma de los elementos del array ✓
 *    - Métodos de búsqueda (lineal y dicotómica o binaria) ✓ 
 *    - Métodos varios de ordenación (burbuja, selección, inserción y Shell) ✓
 *    - Método que desordene el array ✓
 *    - Método de insertar por posición ✓
 *    - Método de borrar por posición ✓
 *    - Método de borrar por elemento ✓
 *    - Método para borrar todas las apariciones de un elemento ✓
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

	/**
	 * =====================
	 * MÉTODOS DE BUSQUEDA
	 * =====================
	 */

	/**
	 * Método de búsqueda lineal
	 */
	public static int busquedaLineal(int[] array,Scanner sc){
		int num,contador=-1;

		System.out.print("Introduce el número que quieres buscar (lineal): "); 
		num = sc.nextInt();
		sc.nextLine();
		do {
			contador++;
		}
		while ((array[contador]!=num) && (contador<(array.length-1)));

		if (array[contador]==num) {
			return contador;
		}
		return -1;
	}

	/**
	 * Método de búsqueda dicotómica o binaria
	 */
	public static int busquedaDico(int[] array,Scanner sc) {

		boolean sw = false;
		int num,mitad,primero=0,ultimo=array.length-1;

		System.out.print("Introduce el número que quieres buscar (binaria): ");
		num = sc.nextInt();
		sc.nextLine(); 

		do {
			mitad = (primero + ultimo)/2;
			if(array[mitad]==num)
				sw = true;
			else if(array[mitad]<num)
				primero = mitad+1;
			else
				ultimo = mitad-1;
		}

		while ((sw == false) && (primero <= ultimo));
		if(sw == false) {
			return -1;
		}
		return mitad;
	}


	/**
	 * =====================
	 * MÉTODOS DE ORDENACIÓN
	 * =====================
	 */

	/**
	 * Método burbuja
	 */
	public static void ordenacionBurbuja(int[] array) {
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

	/**
	 * Método de selección
	 */
	public static void ordenacionSeleccion(int[] array) {
		int posicionMenor,menor;

		for (int cont=0;cont<=array.length-2;cont++) {
			posicionMenor=cont;
			menor = array[cont];

			for (int cont2= cont+1; cont2<=array.length-1; cont2++) {

				if (array[cont2]<menor) {
					posicionMenor = cont2;
					menor = array[cont2];
				}
			}
			array[posicionMenor]=array[cont];
			array[cont]=menor;
		}
	}

	/**
	 * Método de insercción
	 */
	public static void ordenacionInsercion(int[] array) {
		int contador,aux;

		for (int cont=1;cont<(array.length);cont++) {
			aux = array[cont];
			contador = cont-1;

			while ((contador>=0) && (array[contador]>aux)) {
				array[contador+1] = array[contador];
				contador--;
			}

			array[contador+1]=aux;
		}
	}

	/**
	 * Método de Shell
	 */
	public static void ordenacionShell(int[] array) {
		int sw, cont, salto, aux, n;

		n = array.length-1;
		salto = n;

		while (salto != 1) {
			sw = 1;
			salto = salto/2;

			while (sw!=0) {
				cont = 0;
				sw = 0;

				while (cont<=(n-salto)) {

					if (array[cont] > array[cont+salto]) {
						aux = array[cont+salto];
						array[cont+salto] = array[cont];
						array[cont]= aux;
						sw = 1;
					}
					cont++;
				}
			}
		}
	}

	/**
	 * Método que desordene el array
	 */
	public static void desordenarArray(int[] array) {
		Random rand = new Random();
		int posicionRandom,temp;

		for (int cont=0;cont<array.length;cont++) {
			posicionRandom=rand.nextInt(array.length);
			temp=array[cont];

			array[cont] = array[posicionRandom];
			array[posicionRandom] = temp;
		}
	}

	/**
	 * Método de insertar por posición
	 */
	public static void insertarPorPosicion(int[] array, Scanner sc) {
		int posicion,num;

		System.out.print("Introduce la posición donde insertar el número: ");
		posicion = sc.nextInt();

		System.out.print("Introduce el número: ");
		num = sc.nextInt();

		if (posicion>=0 && posicion<array.length) {
			if (array[posicion]==0) {
				array[posicion]=num;
			} 
			else {
				System.out.println("La posición ya está ocupada");
			}
		}
		else {
			System.out.println("Posición fuera de rango");
		}
		sc.nextLine();
	}

	/**
	 * Método de borrar por posición
	 */
	public static void borrarPorPosicion(int[] array, Scanner sc) {
		int posicion;

		System.out.print("Introduce la posición donde borrar el número: ");
		posicion = sc.nextInt();

		if (posicion>=0 && posicion<array.length) {
			for (int cont=posicion;cont<array.length-1;cont++) {
				array[cont]=array[cont+1];
			}
			array[array.length-1]=0;
		} else {
			System.out.println("Posición fuera de rango");
		}

		sc.nextLine();
	}

	/**
	 * Método de borrar por elemento
	 */
	public static void borrarPorElemento(int[] array, Scanner sc) {
		System.out.print("Introduce el número a borrar: ");
		int numBorrar = sc.nextInt();

		boolean encontrado = false;

		for (int cont=0;cont<array.length;cont++) {
			if (!encontrado && array[cont] == numBorrar) {
				encontrado = true;
			}
			if (encontrado && cont < array.length-1) {
				array[cont] = array[cont+1];
			}
		}

		if (encontrado) {
			array[array.length-1] = 0;
		}
		else {
			System.out.println("\nEl número no se encuentra en el array");
		}

		sc.nextLine();
	}

	/**
	 * Método para borrar todas las apariciones de un elemento
	 */
	public static void borrarTodasLasAparicionesElementos(int[] array, Scanner sc) {
		System.out.print("Introduce el número a borrar: ");
		int numBorrar = sc.nextInt();

		int indice=0;

		for (int cont=0;cont<array.length;cont++) {
			if (array[cont] != numBorrar) {
				array[indice] = array[cont];
				indice++;
			}
		}

		while (indice<array.length) {
			array[indice]=0;
			indice++;
		}

		sc.nextLine();
	}
}
