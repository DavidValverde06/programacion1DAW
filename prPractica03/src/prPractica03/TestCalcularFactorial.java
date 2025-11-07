package prPractica03;

import java.util.Scanner;

public class TestCalcularFactorial {

	public static void main(String[] args) {

		// Variables locales
		int num;
		long resultado;

		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Introduce un número: ");
			num=sc.nextInt();
		}

		resultado=LibreriaMatematica.calcularFactorial(num);

		if (resultado==-1) {
			System.out.println("No existe el factorial de números negativos");
		}
		else {
			System.out.println("Factorial(" + num + ") = " + LibreriaMatematica.calcularFactorial(num));
		}

		System.out.println(); // Salto de línea
		
		for (int cont=0;cont<=10;cont++) {
			if (resultado==-1) {
				System.out.println("No existe el factorial de números negativos");
			}
			else {
				System.out.println("Factorial(" + cont + ") = " + LibreriaMatematica.calcularFactorial(cont));
			}
		}
	}

}
