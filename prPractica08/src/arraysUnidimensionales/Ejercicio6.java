package arraysUnidimensionales;

import java.util.Scanner;

/**
 * 6.- Desarrolla un programa que lea las notas de un determinado examen, y las almacene en un array,
 * mostrando a continuación, la nota media, la nota más alta y la nota más baja. El programa lo primero
 * que solicitará será el número de alumnos que han realizado el examen, y en función de ese valor se
 * definirá el array.
 */

public class Ejercicio6 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int arrayAlumnos[];
		float notaMedia=0;
		int numAlumnos,notaMasAlta,notaMasBaja;

		System.out.print("Introduce el número de alumnos: ");
		numAlumnos=sc.nextInt();

		arrayAlumnos = new int[numAlumnos];

		for (int cont=0;cont<numAlumnos;cont++) {
			System.out.print("Introduce la nota del alumno " + (cont+1) + ": ");
			arrayAlumnos[cont]=sc.nextInt();
			
			if (arrayAlumnos[cont]<0||arrayAlumnos[cont]>10) {
				System.out.println("Nota no válida");
				arrayAlumnos[cont]=0;
			}
		}

		notaMasAlta=arrayAlumnos[0];
		notaMasBaja=arrayAlumnos[0];

		System.out.println("\nNotas de los " + numAlumnos + " alumnos: ");
		for (int cont=0;cont<arrayAlumnos.length;cont++) {
			System.out.print(arrayAlumnos[cont] + " ");

			if (arrayAlumnos[cont]>notaMasAlta) {
				notaMasAlta=arrayAlumnos[cont];
			}
			else if (arrayAlumnos[cont]<notaMasBaja) {
				notaMasBaja=arrayAlumnos[cont];
			}

			notaMedia+=arrayAlumnos[cont];
		}

		System.out.println("\n\nNota mas alta: " + notaMasAlta);
		System.out.println("Nota mas baja: " + notaMasBaja);
		System.out.println("Nota media: " + notaMedia/numAlumnos);


		sc.close();
	}

}
