package prPracticaRepaso01;

import java.util.Scanner;

/**
 * 16. Mejorar el ejercicio anterior teniendo en cuenta los años bisiestos. Un año es bisiesto si es
		múltiplo de 4 (p.e. 1988), excepto los múltiplos de 100 que no son bisiestos (p. e. 1800), salvo los
		múltiplos de 400 que si lo son (p. e. 2000).
 */

public class Ejercicioo16 {

	public static void main(String[] args) {

		// Falta hacer el año bisiesto
		
		Scanner sc = new Scanner(System.in);

		int dia,mes,anio;

		System.out.print("Introduce el día: ");
		dia=sc.nextInt();

		System.out.print("Introduce el mes: ");
		mes=sc.nextInt();

		System.out.print("Introduce el año: ");
		anio=sc.nextInt();

		if (dia>31||dia<0 || mes>12||mes<0 || anio<1925||anio>2125) {
			System.out.println("\nFecha incorrecta");
		}
		else {

			if (mes==2 && dia>28) { // FEBRERO TIENE 28 DÍAS
				System.out.println("\nFecha incorrecta");
			}
			else if (mes==4 && dia>30) { // ABRIL TIENE 30 DÍAS
				System.out.println("\nFecha incorrecta");
			}
			else if (mes==6 && dia>30) { // JUNIO TIENE 30 DÍAS
				System.out.println("\nFecha incorrecta");
			}
			else if (mes==9 && dia>30) { // SEPTIEMBRE TIENE 30 DÍAS
				System.out.println("\nFecha incorrecta");
			}
			else if (mes==11 && dia>30) { // NOVIEMBRE TIENE 30 DÍAS
				System.out.println("\nFecha incorrecta");
			}
			else {
				System.out.println("\nFecha correcta");
				System.out.printf("\n%02d/%02d/%04d%n",dia,mes,anio);
			}
		}

		sc.close();
		
	}

}
