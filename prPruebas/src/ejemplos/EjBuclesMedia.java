package ejemplos;

import java.util.Scanner;

/**
 * Cálculo de la media aritmetica de varios valores recogidos de teclado hasta que nos den el valor 0
 */
public class EjBuclesMedia {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Definir las variables locales
		int nota;
		int sumaNotas=0,contNotas=0;

		// -----------------------------------------------------
		// Planteamiento 1 con bucle while y lectura adelantada

		// Lectura de la primera nota --> Lectura adelantada :)
		System.out.print("Introduce una nota: ");
		nota=sc.nextInt();

		// Plantear un bucle while hasta que nos den el valor 0
		while (nota!=0) {

			sumaNotas+=nota;
			contNotas++;

			// Lectura de otra nota
			System.out.print("Introduce una nota: ");
			nota=sc.nextInt();
		}

		System.out.println("\nNota media: " + (float)sumaNotas/contNotas);


		// -----------------------------------------------------
		// Planteamiento 2 con bucle while con una unica lectura
		// -----------------------------------------------------
		nota=-1;
		sumaNotas=0;
		contNotas=-1;

		while (nota!=0) {
			System.out.print("Introduce una nota: ");
			nota=sc.nextInt();

			sumaNotas+=nota;
			contNotas++;
		}

		System.out.println("\nNota media: " + (float)sumaNotas/contNotas);


		// -----------------------------------------------------
		// Planteamiento 3 con do...while
		// -----------------------------------------------------
		
		
		
		// -----------------------------------------------------
		// Planteamiento 4 con un for
		// -----------------------------------------------------
		
		

		sc.close();
	}

}
