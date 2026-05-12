package prPractica02;

import java.util.Scanner;

/**
 * 9. Una empresa maneja códigos numéricos con las siguientes características:
		▪ Cada código consta de 4 dígitos.
		▪ El primero representa una provincia.
		▪ El segundo el tipo de operación.
		▪ Los dos últimos el número de operación.
 */

public class Ejercicio9 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int codigo;
		
		System.out.print("Introduce el código de 4 dígitos: ");
		codigo=sc.nextInt();
		
		if (codigo<=9999&&codigo>=1000) {
			System.out.println("PROVINCIA: " + codigo/1000 +
					 "\nTIPO DE OPERACION: " + codigo/100%10 + 
					 "\nNUMERO DE OPERACION: " + codigo%100);
		}
		else {
			System.out.println("ERRROR. CÓDIGO INVÁLIDO");
		}
		
		sc.close();
	}

}
