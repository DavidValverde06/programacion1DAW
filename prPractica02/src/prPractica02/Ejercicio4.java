package prPractica02;

import java.util.Scanner;

/**
 * 4. Realizar un algoritmo que permita saber si un número es mayor, menor o igual a cero
 */

public class Ejercicio4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		float num;
		
		System.out.print("Introduce un número: ");
		num=sc.nextFloat();
		
		if (num>0) {
			System.out.print(num + " es mayor a 0.");
		}
		else if (num<0) {
			System.out.print(num + " es menor a 0.");
		}
		else if (num==0) {
			System.out.print(num + " es igual a 0.");
		}
		
		System.out.println();
		System.out.println("\nIntroduce un número: " + num);
		
		System.out.println((num>0)?"Mayor a 0":(num<0)?"Menor a 0":"Es igual a 0");
		sc.close();
	}

}
