package prPractica02;

import java.util.Scanner;

/**
 * 13. Diseñar un algoritmo que lee un número y un valor entre 1 y 3, y en función de este último calcula:
		1.- El cuadrado del número
		2.- El cubo del número
		3.- La raíz cuadrada del número
 */

public class Ejercicioo13 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		float num;
		int valor;

		System.out.print("Introduce un número: ");
		num=sc.nextFloat();
		System.out.print("Introduce un valor entre 1 y 3: ");
		valor=sc.nextInt();
		if (valor!=1 && valor!=2 && valor!=3) {
			System.out.println("Valor no válido");
		}
		else {
			switch (valor) {
			case 1:
				System.out.println("\nCUADRADO DE UN NÚMERO" +
						"\nResultado: " + Math.pow(num, 2));
				break;
			case 2:
				System.out.println("\nCUBO DE UN NÚMERO" + 
						"\nResultado: " + Math.pow(num, 3));
				break;
			case 3:
				if (num<0) {
					System.out.println("No se puede calcular la raíz cuadrada de un número negativo");
				}
				else {
					System.out.println("\nRAÍZ CUADRADA DE UN NÚMERO" + 
							"\nResultado: " + Math.sqrt(num));
				}
				break;
			default:
				System.out.println("ERROR");
				break;
			}
		}

		sc.close();
	}

}
