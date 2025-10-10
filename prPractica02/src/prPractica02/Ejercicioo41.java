package prPractica02;

import java.util.Scanner;

/**
 * 41. Introducir dos números inferiores a 50 y superiores a 0 por teclado. Al más pequeño de ellos lo
	   aumentamos de 5 en 5 y al más grande lo disminuimos de 2 en 2. Imprimir ambas series alternativamente
	   hasta que el menor supere al mayor.
 */

public class Ejercicioo41 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num1,num2,mayor,menor;

		System.out.print("Introduce un número inferior a 50 y mayor a 0: ");
		num1=sc.nextInt();
		System.out.print("Introduce otro número inferior a 50 y mayor a 0: ");
		num2=sc.nextInt();

		if (num1>50||num1<0 || num2>50||num2<0) {
			System.out.println("Introduce números validos");
		}
		else {

			if (num1>num2) {
				mayor=num1;
				menor=num2;

				while (menor<mayor) {

					System.out.println(menor + " " + mayor);

					mayor-=2;
					menor+=5;

				}

				System.out.println(menor + " " + mayor);

			}

			else {
				mayor=num2;
				menor=num1;

				while (menor<mayor) {

					System.out.println(menor + " " + mayor);

					menor+=5;
					mayor-=2;

				}

				System.out.println(menor + " " + mayor);

			}
		}

		System.out.println("\nFIN DE PROGRAMA");

		sc.close();
	}

}
