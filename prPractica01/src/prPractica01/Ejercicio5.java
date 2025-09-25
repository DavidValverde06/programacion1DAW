package prPractica01;

import java.util.Scanner;

/**
 * 5.- Realizar un programa para calcular el valor de la hipotenusa de un triángulo rectángulo aplicando el
	   teorema de Pitágoras. Se pedirán por teclado los dos catetos, y se mostrará por pantalla el resultado
	   de calcular la hipotenusa.
	   
	   a2+b2=c2
 */

public class Ejercicio5 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		double cateto1,cateto2,hipotenusaAlCuadrado,hipotenusa;
		
		System.out.print("Introduce el cateto 1: ");
		
		cateto1=sc.nextDouble();
		
		System.out.print("Introduce el cateto 2: ");
		
		cateto2=sc.nextDouble();
		
		hipotenusaAlCuadrado=Math.pow(cateto1, 2) + Math.pow(cateto2, 2);
		
		System.out.println("Hipotenusa al cuadrado: " + hipotenusaAlCuadrado);
		
		hipotenusa=Math.sqrt(hipotenusaAlCuadrado);
		
		System.out.println("Hipotenusa: " + hipotenusa);
		
		sc.close();
		
	}

}
