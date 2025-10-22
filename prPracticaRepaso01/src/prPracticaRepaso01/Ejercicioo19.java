package prPracticaRepaso01;

import java.util.Scanner;

/**
 * 19. Realizar el “juego de la suma”, que consiste en que aparezcan dos números aleatorios (comprendidos
	   entre 1 y 99), que el usuario tiene que sumar. La aplicación debe indicar si el resultado de la operación
	   es correcto o incorrecto.
 */

public class Ejercicioo19 {

	public static void main(String[] args) {

		int num1,num2,resultadoSuma,intentoUsuario,contIntentos=1;

		num1=(int)(Math.random()*99)+1;
		num2=(int)(Math.random()*99)+1;

		resultadoSuma=num1+num2;

		System.out.println("JUEGO DE LA SUMA");
		System.out.println("\nLos números son " + num1 + " y " + num2);

		Scanner sc = new Scanner(System.in);

		do {

			System.out.print("Introduce la suma de los números anteriores: ");
			intentoUsuario=sc.nextInt();

			if (intentoUsuario!=resultadoSuma) {
				System.out.println("\nResultado incorrecto");
				contIntentos++;
			}
			else {
				System.out.println("\nResultado correcto");
			}

		}
		while (intentoUsuario!=resultadoSuma);

		System.out.println("\n" + num1 + " + " + num2 + " = " + resultadoSuma);
		
		System.out.println("\nHas averiguado el resultado en " + contIntentos + " intentos.");

		sc.close();
	}

}
