package prPractica02;

import java.util.Scanner;

/**
 * 35. Hacer un algoritmo que calcule el valor de un número combinatorio a partir de dos valores, a y b, que
	   se introducen por teclado, aplicando la siguiente fórmula:

	   (a b) = a! / b!*(a-b)

	    Se debe tener en cuenta que para poder calcular el combinatorio de dos números se debe cumplir que
		a ≥ b, a ≥ 0 y b ≥ 0.

		UTILIZO METODOS PARA EL CALCULO DEL FACTORIAL

 */

public class Ejercicioo35v2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		double numA,numB,numAB,factorialA=1,factorialB=1,factorialAB=1,resultado,numero,resultadoFacto;

		System.out.print("Introduce el valor de A: ");
		numA=sc.nextDouble();

		System.out.print("Introduce el valor de B: ");
		numB=sc.nextDouble();

		if (numA>=numB && numA>=0 && numB>=0) {

			factorialA=factorial(numA);

			factorialB=factorial(numB);

			numAB=numA-numB;

			factorialAB=factorial(numAB);


			//			(a b) = a! / b!*(a-b)!

			resultado = factorialA / (factorialB * factorialAB);

			System.out.println("\nEl factorial de " + numA + " es: " + factorialA);
			System.out.println("El factorial de " + numB + " es: " + factorialB);

			System.out.println("\nEl combinatorio de " + numA + " sobre " + numB + " es: " + resultado);

		}
		else {
			System.out.println("Error, no se puede calcular el combinatorio de " + numA + " y " + numB);
		}

		numero=-4;
		resultadoFacto= factorial(numero);
		
		if (resultadoFacto==-1) {
			System.out.println("\nError, existe el factorial de números negativos");
		}
		else {
			System.out.println("\nFactorial(" + numero + "): " + resultadoFacto);
		}


		sc.close();
	}

	/**
	 * Calcula el factorial de un número n, recibido como parámetro
	 * 
	 * Factorial(0) = 1
	 * Factorial(n) = n x (n-1) x (n-2) ....x 1
	 * No existe el factorial de números negativos
	 * 
	 * @param numA --> parámetro al que se calculará el factorial
	 * @return --> valor devuelto por el método, en este caso el factorial calculado
	 * 		   --> si num es negativo, vamos a devolver -1
	 */
	public static double factorial(double num) {

		// Variables locales al método
		double facto=1;
		if (num<0) {
			return -1;
		}
		else {
			for (double cont=num;cont>0;cont--) {
				facto=facto*cont;
			}
		}
		return facto;
	}

}
