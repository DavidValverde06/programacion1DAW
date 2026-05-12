package prPractica02;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 15. Programa que lea 3 números de teclado y los muestre en pantalla de forma ordenada.
 */

public class Ejercicioo15 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num1,num2,num3,tercero=0,segundo=0,primero=0;

		try {
			System.out.print("Introduce el primer número: ");
			num1=sc.nextInt();

			tercero=num1;

			System.out.print("Introduce el segundo número: ");
			num2=sc.nextInt();

			if (num2>tercero) {
				tercero=num2;
				segundo=num1;
			}
			else {
				tercero=num1;
				segundo=num2;
			}

			System.out.print("Introduce el tercer número: ");
			num3=sc.nextInt();

			if (num3>tercero) {
				tercero=num3;
				segundo=num2;
				primero=num1;
			}
			else if (num3<tercero && num3>segundo){
				primero=segundo;
				segundo=num3;
			}
			else {
				primero=num3;
			}


			System.out.println("\n1º: " + primero);
			System.out.println("2º: " + segundo);
			System.out.println("3º: " + tercero);
		}
		catch (InputMismatchException e) {
			System.out.println("\nERROR. NO HAS INTRODUCIDO UN NÚMERO");
		}

		sc.close();
	}

}
