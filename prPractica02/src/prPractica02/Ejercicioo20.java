package prPractica02;

import java.util.Scanner;

/**
 * 20. Desarrolla un programa que resuelva la siguiente serie matemática:
			s(n) = 1 + 1/2 + 1/3 + ... + 1/n
 */

public class Ejercicioo20 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num;
		double resultado=0;
		
		System.out.print("Introduce un número: ");
		num=sc.nextInt();
		
		for (int cont=1;cont<=num;cont++) {
			resultado+=1.0/cont;
		}
		
		System.out.println("Resultado: " + resultado);
		
		sc.close();
	}

}
