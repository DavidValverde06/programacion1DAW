package prPractica02;

import java.util.Scanner;

public class Ejercicioo30v4 {

	public static void main(String[] args) {

		// Variables locales
		int num1,num2;

		Scanner sc = new Scanner(System.in);

		System.out.print("Número 1: ");
		num1=sc.nextInt();

		System.out.print("Número 2: ");
		num2=sc.nextInt();

		// Version 2

		// Si el valor de num1 es superior al de num2, imtercambiamos las variables
		if (num2<num1) {
			int aux; // aux es una variable local al if
			aux=num1;
			num1=num2;
			num2=aux;
		}

		// Buscar el primer múltiplo de 3
		while ((num1%3)!=0) {
			num1++;
		}

		// Generar 2 valores en el intervalo
		for(int cont=num1;cont<num2;cont+=6) { // cont=cont+3
			System.out.print(cont + " | ");
		}

		sc.close();
		
	}

}
