package ejemplo2;

import java.util.InputMismatchException;
import java.util.Scanner;

/** Clase para probar excepciones
 * 
 *   Utiliza varios bloques catch, uno para controlar las divisiones por cero,
 *   otro para controlar posiciones no válidas en el array y otro para valores no válidos.
 *   
 *   El programa se repetirá hasta que se teclee el valor 10 como posición primero, saltará
 *   la excepción de array desbordado, y después finalizará el programa.
 */

public class Excepcion2 {
	public static void main(String[] args) {

		int posicion=0, valor;
		Scanner sc = new Scanner(System.in);
		do{
			try {
				float[] valores = new float[10];

				System.out.print("Posicion: ");
				posicion = sc.nextInt();

				System.out.print("Valor: ");
				valor = sc.nextInt();

				float auxiliar = 8/valor;

				valores[posicion] = auxiliar;
			}

			catch (ArithmeticException e) {
				System.out.println("Division por cero");
				System.out.println("Motivo del error: " + e.getMessage());
				e.printStackTrace();
				// El método printStackTrace provoca la impresión (en rojo) de un breve mensaje acerca
				// de la excepcion, seguido de la pila de ejecucion de los métodos del programa 
				// (en este caso solo el método main)
			}

			catch(IndexOutOfBoundsException e) {  // Indice fuera del array
				System.out.println("Indice fuera del array");
				e.printStackTrace();
			}

			catch (InputMismatchException e) {
				System.out.println("Debe introducir un valor entero");
			}

			System.out.println("Hola");
			sc.nextLine();

		} 
		while (posicion!=10);

		sc.close();
	}
}