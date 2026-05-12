package prPractica01;

import java.util.Scanner;

/**
 * 13.- Escribir un programa que convierta un número dado en segundos en el equivalente de minutos y
		segundos. 
 */

public class Ejercicioo13 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int segundos;
		
		System.out.print("Introduce un número (segundos): ");
		
		segundos=sc.nextInt();
		
		System.out.println(segundos/60 + " minutos y " + segundos%60 + " segundos");
		
		sc.close();
	}

}
