package prPractica03;

import java.util.Scanner;

public class TestCalcularCombinatorio {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num1,num2;
		System.out.print("Introduce el primer número para calcular el combinatorio: ");
		num1=sc.nextInt();

		System.out.print("Introduce el segundo número para calcular el combinatorio: ");
		num2=sc.nextInt();

		if (LibreriaMatematica.calcularCombinatorio(num1, num2)==-1) {
			System.out.println("No se puede calcular el combinatorio de un número negativo");
		}
		else {
			System.out.println("Combinatorio de " + num1 + " y " + num2 + " es: " + LibreriaMatematica.calcularCombinatorio(num1, num2));
		}

		sc.close();
	}

}
