package prPractica02;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 10. Realizar un algoritmo para deducir el mayor de tres valores introducidos por teclado.
 */

public class Ejercicioo10 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num1,num2,num3,primero=0,segundo=0,tercero=0;

		try {
			System.out.print("Introduce un número: ");
			num1=sc.nextInt();

			primero=num1;

			System.out.print("Introduce un número: ");
			num2=sc.nextInt();

			if (num2>primero) {
				primero=num2;
				segundo=num1;
			}
			else {
				primero=num1;
				segundo=num2;
			}

			System.out.print("Introduce un número: ");
			num3=sc.nextInt();

			if (num3>primero) {
				primero=num3;
				segundo=num2;
				tercero=num1;
			}
			else if (num3<primero && num3>segundo){
				tercero=segundo;
				segundo=num3;
			}
			else {
				tercero=num3;
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
