package prPractica01;

import java.util.Scanner;

/**
 * 1.- Hacer un programa que pida al usuario su edad, y muestre la edad que tendrá el próximo año.
 */

public class Ejercicio1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		byte edad;
		
		System.out.print("Introduce tu edad: ");
		
		edad=sc.nextByte();
		
		System.out.println("El año que viene tendrás " + (edad+=1) + " años.");
		
		sc.close();
	}

}
