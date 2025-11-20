package ejercicioRecursividad;

import java.util.Scanner;

/**
 * Realiza un método recursivo que calcule la suma de los dígitos de un número que podrá ser tanto positivo como negativo.
 */
public class Ejercicio3Recursividad {

	public static int sumaDigitos(int num) {
		num=Math.abs(num);
		
		if (num<10) {
			return num;
		}
		
		// Es con los signos al reves
		// return num/10 + sumaDigitos(num%10);
		return num%10 + sumaDigitos(num/10);
	}
	
	public static void main(String[] args) {

		int num;

		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce un número negativo o positivo: ");
		num=sc.nextInt();
		
		System.out.println("Suma digitos de " + num + " es " + sumaDigitos(num));
		
		System.out.println("Suma digitos de " + 1234 + " es " + sumaDigitos(1234));
		System.out.println("Suma digitos de " + -1234 + " es " + sumaDigitos(-1234));
		System.out.println("Suma digitos de " + 765439 + " es " + sumaDigitos(765439));
		System.out.println("Suma digitos de " + 7 + " es " + sumaDigitos(7));
		
		sc.close();
	}

}
