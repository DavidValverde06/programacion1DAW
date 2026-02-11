package ejemplo1;

import java.util.InputMismatchException;
import java.util.Scanner;

/** Clase para probar excepciones

   - Captura las excepciones:
 * "ArithmeticException", aunque esta excepción no es necesario tratarla en alguno
          caso puede resultar conveniente, en este ejemplo, nos sirve para controlar
          la división por cero
 * "InputMismatchException", por si lo que se teclea uno es una valor correcto


   - Implementa un bucle sin fin que recoge un valor entero suministrado por el usuario
     y lo utiliza como denominador en una división. 

   - El motivo de utilizar un bucle sin fin en este ejemplo, es para que podáis probar 
     de forma con diferentes valores, provocando las dos excepciones (división por cero o
     valor no válido). Así comprobaréis cómo se activa el mecanismo de las excepciones.
 **/

public class Excepcion1 {
	public static void main(String[] args) {

		int valor;
		float auxiliar;

		try (Scanner sc = new Scanner(System.in)) {
			// System.out.println("Prueba " + (5/0));
			do {
				try {
					System.out.print("Introduzca valor numérico: ");
					valor = sc.nextInt();
					auxiliar = 8/valor;
					System.out.println(auxiliar);
				}
				catch (ArithmeticException e) {
					System.out.println("Division por cero");
				}
				catch (InputMismatchException e) {
					System.out.println("Debe introducir un valor entero");
				}
				finally {
					sc.nextLine();
					System.out.println("Despues del catch");
				}

			} 
			while (true);
		}

	}
}
