package prPractica02;

import java.util.Scanner;

/**
 * 54. Diseñar un algoritmo que lee una lista de números enteros terminada en 0, y que encuentre y escriba en
		pantalla la posición de la primera y última ocurrencia del número 12 dentro de la lista. Si el número 12
		no está en la lista, el algoritmo debería escribir 0. Por ejemplo, si el octavo número de la lista es el único
		12, entonces 8 sería la primera y la última posición de las ocurrencias de 12.
 */

public class Ejercicioo54 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num,posicionPrimera=0,posicionUltima=0,contPosiciones=1;

		System.out.print(contPosiciones + " - Introduce un número: ");
		num=sc.nextInt();
		
		while (num!=0) {

			if (num<0) {
				System.out.print("Introduce un número entero");
			}
			else {	
				contPosiciones++;

				if (num==12 && posicionUltima==0) {
					posicionPrimera=contPosiciones;
				}
				if (num==12) {
					posicionUltima=contPosiciones;
				}
			}

			System.out.print(contPosiciones + " - Introduce un número: ");
			num=sc.nextInt();
		}

		System.out.println("\nPrimera posición: " + (posicionPrimera-1));
		System.out.println("Última posición: " + (posicionUltima-1));

		sc.close();
	}

}
