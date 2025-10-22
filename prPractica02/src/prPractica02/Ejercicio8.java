package prPractica02;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 8. Realizar un algoritmo que lea dos valores desde teclado y diga si cualquiera de ellos divide de forma
	  entera al otro
 */

public class Ejercicio8 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num1=0,num2=0;

		try {
		System.out.print("Introduce el valor del primer número: ");
		num1=sc.nextInt();

		System.out.print("Introduce el valor del segundo número: ");
		num2=sc.nextInt();
		}
		catch (InputMismatchException err) {
			System.out.println("Introduce un número");
		}
		if (num1==0||num2==0) {
			System.out.println("No se puede dividir entre 0");
		}
		else {

			if (num1%num2==0) {
				System.out.println(num1 + " divide de forma entera a " + num2);
			}
			else if (num2%num1==0) {
				System.out.println(num2 + " divide de forma entera a " + num1);
			}
			else {
				System.out.println("No se pueden dividir de forma entera");
			}
		}
		sc.close();
	}

}
