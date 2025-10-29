package prPracticaRepaso01;

import java.util.Scanner;

/**
 * 10. Diseña tres programas que dibujen las siguientes figuras, para ello se pedirá la altura del triángulo.
		En estos tres ejemplos la altura del triángulo es 4.
 */

public class Ejercicioo10 {

	public static void main(String[] args) {
		
		pensar mejor
		
		int altura;
		String cadena="";
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce la altura del triángulo: ");
		altura=sc.nextInt();
		
		System.out.println();
		
		for (int cont=0;cont<altura;cont++) {
			System.out.println(cadena+='*');
		}
		
		System.out.println(); // SALTO DE LÍNEA
		
		cadena="";
		
		for (int cont=0;cont<altura;cont++) {
			System.out.println(cadena+=' ');
		}
		
		sc.close();
	}

}
