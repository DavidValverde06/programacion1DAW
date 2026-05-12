package prPractica02;

import java.util.Scanner;

/**
 * En esta version vamos a ir generando todos los valores en el intervalo y comprobando si el número es múltiplo de 3, si lo es, una vez
 * si otra vez mno (utilizaremos un boolean)
 */

public class Ejercicioo30v3 {

	public static void main(String[] args) {

		// Variables locales
		int num1,num2;
		boolean sw=true;

		Scanner sc = new Scanner(System.in);

		System.out.print("Número 1: ");
		num1=sc.nextInt();

		System.out.print("Número 2: ");
		num2=sc.nextInt();

		// Version 1
		
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
		for(int cont=num1;cont<num2;cont+=3) { // cont=cont+3
			if (sw==true) {
				System.out.print(cont + " | ");
				sw=false;
			}
			else {
				sw = true;
			}
		}

		System.out.println("\n");
		sw=true;
		
		// Version 2
		
				// Si el valor de num1 es superior al de num2, imtercambiamos las variables
				if (num2<num1) {
					int aux; // aux es una variable local al if
					aux=num1;
					num1=num2;
					num2=aux;
				}

				// Generar 2 valores en el intervalo
				for(int cont=num1;cont<num2;cont+=3) { // cont=cont+3
					if (sw) {
						System.out.print(cont + " | ");
					}
					sw=!sw;
				}


		sc.close();

	}

}
