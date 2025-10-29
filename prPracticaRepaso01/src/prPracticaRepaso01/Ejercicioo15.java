package prPracticaRepaso01;

import java.util.Scanner;

/**
 * 15. Pedir el día, mes y año de una fecha e indicar si la fecha es correcta. Hay que tener en cuenta que
	   existen meses con 28, 30 y 31 días, no se considerarán los años bisiestos, es decir, supondremos
       que febrero siempre tendrá 28 días.
 */

public class Ejercicioo15 {

	public static void main(String[] args) {

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
