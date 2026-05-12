package prPractica02;

import java.util.Locale;
import java.util.Scanner;

/**
 *  Implementar un programa que pida por teclado un número decimal e indique si es un número casi-cero,
	que son aquellos positivos o negativos, que se acercan a 0 por menos de 1 unidad, aunque curiosamente
	el 0 no se considera un número casi cero.
	
	Ejemplos de números casi-cero son el 0,3, el -0,99 o el 0,123;
	algunos números que no se consideran casi-ceros son: el 12,3, el 0 o el -1.
	
	Nota: Recordar que para poder utilizar el punto decimal con la clase Scanner a la hora de recoger valores
	decimales de teclado, tenéis que cambiar el locale por defecto, es decir:

 */

public class Ejercicioo11 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		sc.useLocale(Locale.US); // Para poder utilizar el punto con los decimales
		
		float num;
		
		System.out.print("Introduce un número: ");
		num=sc.nextFloat();
		
		if (num>-1&&num<1&&num!=0) {
			System.out.println("El número es casi cero");
		}
		else {
			System.out.println("El número no es casi cero");
		}
		
		sc.close();
	}

}
