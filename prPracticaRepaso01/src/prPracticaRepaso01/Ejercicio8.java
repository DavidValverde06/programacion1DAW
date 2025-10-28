package prPracticaRepaso01;

import java.util.Scanner;

/**
 * 8. Escribir un programa que lea las edades de los empleados de una empresa mientras la edad leída sea
	  distinta de cero y calcule cuántos jóvenes (menores de 22 años), maduros (entre 22 y 50 años) y
	  mayores (aquellos con más de 50 años) hay, mostrando el resultado en pantalla. En aquellos casos en
	  los que se lea una edad no correcta (negativa o fuera del intervalo de 18 a 65 años) se escribirá un
	  mensaje de error en pantalla y se leerá otra edad.
 */

public class Ejercicio8 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int edadEmpleados,contJovenes=0,contMayores=0,contMaduros=0;
		
		System.out.print("Introduce la edad del empleado: ");
		edadEmpleados=sc.nextInt();
		
		while (edadEmpleados!=0) {
			
			if (edadEmpleados<18||edadEmpleados>65) {
				System.out.println("Edad fuera del intervalo\n");
			}
			else {
				if (edadEmpleados<22) { // Jóvenes
					contJovenes++;
				}
				else if (edadEmpleados>50) { // Mayores
					contMayores++;
				}
				else { // Maduros
					contMaduros++;
				}
			}
			
			System.out.print("Introduce la edad del empleado: ");
			edadEmpleados=sc.nextInt();
		}
		
		System.out.println("\nNúmero de empleados jóvenes: " + contJovenes);
		System.out.println("Número de empleados maduros: " + contMaduros);
		System.out.println("Número de empleados mayores: " + contMayores);
		
		sc.close();
	}

}
