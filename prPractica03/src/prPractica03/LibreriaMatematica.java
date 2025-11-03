package prPractica03;

public class LibreriaMatematica {

	/**
	 * a) Método al que pasándole un número nos devuelva un valor lógico, el cual indicará si el número es primo o no.
	 * @param num
	 * @return
	 */
	public static boolean esPrimo (int num) {

		int contDivisores=0;

		if (num<1) {
			return false;
		}
		else {
			for (int cont=2;cont<num;cont++) {
				if (num%cont==0) {
					contDivisores++;
				}
			}

			if (contDivisores>=1) {
				return true;
			}
			else {
				return false;
			}
		}
	}


	/**
	 * b) Método que calcule el factorial de un número, en caso de números negativos debe devolver -1.
	 * @param num
	 * @return
	 */
	public static int calcularFactorial(int num) {

		int resultado=1;

		if (num<0) {
			return -1;
		}
		else {
			for (int cont=num;cont>0;cont--) {
				resultado=resultado*cont;
			}
			return resultado;
		}
	}


	/**
	 * c) Método que calcule el combinatorio de dos números dados, se debe tener en cuenta que para poder calcular
	 * el combinatorio de dos números se debe cumplir que a ≥ b, a ≥ 0 y b ≥ 0.
	 * @param numA
	 * @param numB
	 * @return
	 */
	public static int calcularCombinatorio(int numA, int numB) {

		int numAB,resultado;

		if (numA>=numB && numA>=0 && numB>=0) {
			numAB=numA-numB;

			// (a b) = a! / b!*(a-b)!
			resultado = calcularFactorial(numA) / (calcularFactorial(numB) * calcularFactorial(numAB));
			return resultado;
		}
		else {
			return resultado=-1;
		}
	}


	/**
	 * Método privado que calcula la suma de los divisores de un número	
	 * @param num
	 * @return
	 */
	private static int sumaDivisores (int num) {

		int contDivisores=0;

		for (int cont=1;cont<num;cont++) {
			if (num%cont==0) {
				contDivisores+=cont;
			}
		}

		return contDivisores;
	}


	/**
	 * d) Método para comprobar si un número es perfecto. Un número es perfecto cuando la suma de sus divisores
	 * excepto él mismo es igual al propio número. Por ejemplo, son números perfectos 6, 28, 496, …
	 * Os aconsejo que hagáis un método privado, que calcule la suma de los divisores de un número, sin contar
	 * el propio número, este método os servirá tanto para comprobar si un número es perfecto como para los
	 * números amigos. 
	 * @param num
	 * @return
	 */
	public static boolean esPerfecto (int num) {

		if (num==sumaDivisores(num)) {
			return true;
		}
		else {
			return false;
		}
	}


	/**
	 * e) Método que compruebe si dos números son amigos, debe devolver un valor boolean. Dos números son
	 * amigos si la suma de los divisores del primero, excepto él mismo, es igual al segundo número y viceversa.
	 * Por ejemplo, son números amigos 6 y 6, 28 y 28, 220 y 284,…
	 * @param numA
	 * @param numB
	 * @return
	 */
	public static boolean sonAmigos (int numA, int numB) {

		if (sumaDivisores(numA)==numB) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * f) Método al que se le pasen dos números enteros y nos devuelva el valor verdadero, si ambos números son
	 * primos entre sí, y el valor falso en caso contrario. Dos números son primos entre si cuando el único
	 * divisor común de los dos es la unidad. Por ejemplo, son primos entre sí, el 5 y 18, 20 y 9, etc…
	 * @param numA
	 * @param numB
	 * @return
	 */
	public static boolean primosEntreSi (int numA, int numB) {
		
		
	}

}
