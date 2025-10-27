package prPracticaRepaso01;

import java.util.Scanner;

/**
 * 7. El recibo de la electricidad se elabora de la siguiente forma:
		- 6 euros de gastos fijos.
		- 1 euro./Kw para los primeros 100 Kw.
		- 80 céntimos/Kw para los siguientes 150 Kw.
		- 70 céntimos/Kw para el resto
		
		Diseñar un programa que lea del teclado los dos últimos valores del contador, y calcule e imprima en
		pantalla el importe total a pagar.
 */

public class Ejercicio7 {

	public static void main(String[] args) {

		ni idea
		
		Scanner sc = new Scanner(System.in);
		
		int valorContador;
		final int GASTOSFIJOS=6;
		
		System.out.print("Introduce los dos últimos valores del contador: ");
		valorContador=sc.nextInt();
		
		if (valorContador<10||valorContador>99) {
			System.out.println("Introduce solo dos cifras");
		}
		else {
			
		}
		
		sc.close();
	}

}
