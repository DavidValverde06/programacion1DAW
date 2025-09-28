package ejemplos;

import java.util.Locale;
import java.util.Scanner;

/**
 * Ejemplo de lectura de diferentes tipos de datos
 */
public class Ejemplo4 {

	public static void main(String[] args) {

		// Definir variables locales
		int num1=9,num2=10;
		byte edad;
		short sueldo;
		long poblacionMundial=10000000000L;
		
		float altura;
		double valorDouble;
		
		// Crear un objeto Scanner para recoger valores de teclado
		Scanner sc = new Scanner(System.in);
		
		// Cambiar el locale al Inglés
		sc.useLocale(Locale.ENGLISH);
		
		// Recoger varios datos de teclado
		System.out.print("Dime tu edad: ");
		edad = sc.nextByte();
		
		System.out.print("Dime tu sueldo: ");
		sueldo = sc.nextShort();
		
		altura = 1.78f;
		altura = (float)1.78;
		
		System.out.print("Dime tu altura: ");
		altura=sc.nextFloat();
		
		System.out.println("Tu altura es " + altura);
		
		valorDouble=232.87766;
		System.out.print("Dime un valor double: ");
		valorDouble=sc.nextDouble();
		System.out.println("Valor double: " + valorDouble);
		
		System.out.println("\n" + num1);
		System.out.println(num2);
		System.out.println(edad);
		System.out.println(sueldo);
		System.out.println(poblacionMundial);
		
		// Cerrar objeto Scanner
		sc.close();
	}

}
