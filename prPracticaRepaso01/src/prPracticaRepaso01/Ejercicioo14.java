package prPracticaRepaso01;

import java.util.Scanner;

/**
 * 14. Escribir un programa que lea las temperaturas de 15 observatorios meteorológicos y escriba la
	   temperatura mínima y la temperatura máxima que se han producido.
 */

public class Ejercicioo14 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		final int NUMOBSERVATORIOS=15;
		int temperaturaMax,temperaturaMin,contObservatorio=1,temperaturaMaxFinal=0,temperaturaMinFinal=0,posicionMax=0,posicionMin=0;

		System.out.println("OBSERVATORIO " + contObservatorio);
		System.out.print("Introduce la temperatura máxima: ");
		temperaturaMax=sc.nextInt();

		System.out.print("Introduce la temperatura mínima: ");
		temperaturaMin=sc.nextInt();

		while (contObservatorio<NUMOBSERVATORIOS) {

			if (temperaturaMax<temperaturaMin) {
				int aux;
				aux=temperaturaMax;
				temperaturaMax=temperaturaMin;
				temperaturaMin=aux;
			}

			contObservatorio++;

			if (temperaturaMax>temperaturaMaxFinal) {
				temperaturaMaxFinal=temperaturaMax;
				posicionMax=contObservatorio;
			}

			if (temperaturaMin<temperaturaMinFinal) {
				temperaturaMinFinal=temperaturaMin;
				posicionMin=contObservatorio;
			}

			System.out.println("\nOBSERVATORIO " + contObservatorio);
			System.out.print("Introduce la temperatura máxima: ");
			temperaturaMax=sc.nextInt();

			System.out.print("Introduce la temperatura mínima: ");
			temperaturaMin=sc.nextInt();

		}

		System.out.println("\nTemperatura máxima final: " + temperaturaMaxFinal + "ºC del observatorio " + posicionMax);
		System.out.println("Temperatura mínima final: " + temperaturaMinFinal + "ºC del observatorio " + posicionMin);

		sc.close();
	}

}
