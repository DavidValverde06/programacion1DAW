package prPractica02;

import java.util.Scanner;

/**
 * 43. Hacer un algoritmo para que introducido el número de mes lo visualice en letra. Por ejemplo, si nos dan
	   el número 6, escribiremos “Junio”
 */

public class Ejercicioo43 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num;

		System.out.print("Introduce un número de mes: ");
		num=sc.nextInt();

		switch (num) {
		case 1:
			System.out.println("Enero");
			break;
		case 2:
			System.out.println("Febrero");
			break;
		case 3:
			System.out.println("Marzo");
			break;
		case 4:
			System.out.println("Abril");
			break;
		case 5:
			System.out.println("Mayo");
			break;
		case 6:
			System.out.println("Junio");
			break;
		case 7:
			System.out.println("Julio");
			break;
		case 8:
			System.out.println("Agosto");
			break;
		case 9:
			System.out.println("Septiembre");
			break;
		case 10:
			System.out.println("Octubre");
			break;
		case 11:
			System.out.println("Noviembre");
			break;
		case 12:
			System.out.println("Diciembre");
			break;
		default:
			System.out.println("Introduce un número válido.");
			break;
		}

		sc.close();
	}

}
