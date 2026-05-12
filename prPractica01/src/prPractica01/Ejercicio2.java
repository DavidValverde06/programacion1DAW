package prPractica01;

import java.util.Scanner;

/**
 * 2.- Escribir un programa que pida el año actual y el de nacimiento del usuario. Debe calcular su edad,
	   suponiendo que en el año en curso el usuario ya ha cumplido años.
 */

public class Ejercicio2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int anio, anioNacimiento, edad;
		
		System.out.print("Introduce el año actual: ");
		
		anio=sc.nextInt();
		
		System.out.print("Introduce tu año de nacimiento: ");
		
		anioNacimiento=sc.nextInt();
		
		edad=anio-anioNacimiento;
		
		System.out.println("Tienes " + edad + " años.");
		
		sc.close();
	}

}
