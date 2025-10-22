package ejemplos;

import java.util.Scanner;

public class PruebaStrings {

	public static void main(String[] args) {

		String cadena;
		
		Scanner sc = new Scanner(System.in);
		
		// Prueba método nextLine
		System.out.print("Introduzca una cadena: ");
		cadena = sc.nextLine();
		System.out.println(cadena);
		
		// Prueba método next
		System.out.print("Introduzca otra cadena: ");
		cadena = sc.next();
		System.out.println(cadena);
		
		sc.close();
		
	}

}
