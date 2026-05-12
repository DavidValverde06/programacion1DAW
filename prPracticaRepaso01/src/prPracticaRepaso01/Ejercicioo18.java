package prPracticaRepaso01;

import java.util.Scanner;

/**
 * 18. Implementar una aplicación para calcular datos estadísticos de las edades de los alumnos de un
	   centro educativo. Se introducirán datos hasta que uno de ellos sea negativo, y se mostrará la suma
	   de todas las edades introducidas, la media, el número de alumnos y cuántos son mayores de edad.
 */

public class Ejercicioo18 {

	public static void main(String[] args) {

		int edadAlumno,sumaEdades=0,mediaEdades=0,numAlumnos=0,numAlumnosMayoresEdad=0,numAlumnosMenoresEdad=0;

		Scanner sc = new Scanner(System.in);

		System.out.print("Introduce la edad del alumno: ");
		edadAlumno=sc.nextInt();

		while(edadAlumno>=0) {

			if (edadAlumno>100) {
				System.out.println("\nEdad no válida. Intentalo de nuevo");
			}
			else {
				// Suma todas las edades
				sumaEdades+=edadAlumno;

				// Número de alumnos
				numAlumnos++;

				// Número de alumnos mayores de edad
				if (edadAlumno>=18) {
					numAlumnosMayoresEdad++;
				}
				else {
					numAlumnosMenoresEdad++;
				}
			}
			System.out.print("Introduce la edad del alumno: ");
			edadAlumno=sc.nextInt();

		}

		if (numAlumnos==0) {
			System.out.println("\nNo se han introducido alumnos");
		}
		else {

			// Media de edad
			mediaEdades=sumaEdades/numAlumnos;

			System.out.println("\nSuma total de las edades de los alumnos: " + sumaEdades);
			System.out.println("Número de alumnos: " + numAlumnos + " alumnos");
			System.out.println("Media de edad de los alumnos: " + mediaEdades + " años");
			System.out.println("Número de alumnos mayores de edad: " + numAlumnosMayoresEdad + " alumnos");
			System.out.println("Número de alumnos menores de edad: " + numAlumnosMenoresEdad + " alumnos");

		}

		System.out.println("\nFIN DE PROGRAMA");

		sc.close();
	}

}
