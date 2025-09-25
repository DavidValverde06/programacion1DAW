package prPractica01;

import java.util.Scanner;

/**
 * 6.- Diseña un programa que solicite al usuario su edad, y a continuación indique si es mayor o menor de
	   edad, os podéis ayudar del operador condicional, no se puede utilizar la sentencia condicional if.
 */

public class Ejercicio6 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		byte edad;
		String comprobacion;
		
		System.out.print("Introduce tu edad: ");
		
		edad=sc.nextByte();
		
		comprobacion = (edad<18)?"Menor de edad":"Mayor de edad";
		
//		Con if sería así:
		
//		if (edad<18) {
//			comprobacion="Menor de edad";
//		}
//		else {
//			comprobacion="Mayor de edad";
//		}
		
		System.out.println(comprobacion);
		
		sc.close();
	}

}
