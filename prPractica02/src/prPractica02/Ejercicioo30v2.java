package prPractica02;

import java.util.Scanner;

/**
 * En esta version vamos a ir generando todos los valores en el intervalo y comprobando si el número es múltiplo de 3, si lo es, una vez
 * si otra vez no (utilizaremos un boolean)
 */

public class Ejercicioo30v2 {

	public static void main(String[] args) {

		// Variables locales
		int num1,num2;
		boolean sw=true;

		Scanner sc = new Scanner(System.in);

		System.out.print("Número 1: ");
		num1=sc.nextInt();

		System.out.print("Número 2: ");
		num2=sc.nextInt();

		// Si el valor de num1 es superior al de num2, imtercambiamos las variables
		if (num2<num1) {
			int aux; // aux es una variable local al if
			aux=num1;
			num1=num2;
			num2=aux;
		}

		// Versión 1
		for(int cont=num1;cont<num2;cont++) {
			if (cont%3==0) { // Hemos encontrado un múltiplo de 3
				if (sw==true) {
					System.out.print(cont + " | ");
					sw=false;
				}
				else {
					sw = true;
				}
			}
		}
		
		System.out.println("\n");
		sw=true;
		
		// Versión 2
		for(int cont=num1;cont<num2;cont++) {
			if (cont%3==0) { // Hemos encontrado un múltiplo de 3
				if (sw) {
					System.out.print(cont + " | ");
				}
				
				sw=!sw; // niego lo que tenga
			}
		}


		sc.close();

	}

}
