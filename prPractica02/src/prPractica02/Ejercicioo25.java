package prPractica02;

import java.util.Scanner;

/**
 * 25. Programa que obtenga el cociente y el resto de dos números enteros positivos mediante restas y sumas,
	   no podéis utilizar las operaciones de división (/) y de resto (%).
 */

public class Ejercicioo25 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num1,num2,resultado=0;
		
		System.out.print("Introduce el valor del primer número: ");
		num1=sc.nextInt();
		System.out.print("Introduce el valor del primer número: ");
		num2=sc.nextInt();
		
		System.out.println("\nCociente usando '/': " + (num1/num2));
		System.out.println("Resto usando '%': " + (num1%num2));
		
		
		
		System.out.println("\nCociente sin usar '/': " + resultado);
		System.out.println("Resto sin usar '%': " + resultado);
		
		sc.close();
	}

}
