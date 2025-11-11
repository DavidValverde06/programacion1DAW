package prPractica03;

public class LibreriaMatematica {

	/**
	 * a) Método al que pasándole un número nos devuelva un valor lógico, el cual indicará si el número es primo o no.
	 * @param num
	 * @return
	 * 
	 * COMPROBADO
	 */
	public static boolean esPrimo(int num) {

		int contDivisores=0;

		if (num<=1) {
			return false;
		}
		else {
			for (int cont=2;cont<num;cont++) {
				if (num%cont==0) {
					contDivisores++;
				}
			}
			if (contDivisores>=1) {
				return false;
			}
			else {
				return true;
			}
		}
	}


	/**
	 * b) Método que calcule el factorial de un número, en caso de números negativos debe devolver -1.
	 * @param num
	 * @return
	 * 
	 * COMPROBADO
	 */
	public static long calcularFactorial(int num) {

		long resultado=1;

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
	 * @param num1
	 * @param num2
	 * @return
	 * 
	 * COMPROBADO
	 */
	public static long calcularCombinatorio(int num1, int num2) {

		int numAB;
		long resultado;

		if (num1<num2) {
			int aux=num1;
			num1=num2;
			num2=aux;
		}
		if (num1>=num2 && num1>=0 && num2>=0) {
			numAB=num1-num2;

			// (a b) = a! / b!*(a-b)!
			resultado = calcularFactorial(num1) / (calcularFactorial(num2) * calcularFactorial(numAB));
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
	 * 
	 * COMPROBADO
	 */
	private static int sumaDivisores(int num) {

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
	 * 
	 * COMPROBADO
	 */
	public static boolean esPerfecto(int num) {

		if (num <= 1) {
			return false;
		}

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
	 * 
	 * COMPROBADO
	 */
	public static boolean sonAmigos(int numA, int numB) {

		if (sumaDivisores(numA)==numB && sumaDivisores(numB)==numA) {
			return true;
		}
		else {
			return false;
		}
	}


	/**
	 * f) Método al que se le pasen dos números enteros y nos devuelva el valor verdadero, si ambos números son
	 * primos entre sí, y el valor falso en caso contrario. Dos números son primos entre si cuando el único
	 * divisor común de los dos es uno. Por ejemplo, son primos entre sí, el 5 y 18, 20 y 9, etc…
	 * @param numA
	 * @param numB
	 * @return
	 * 
	 * COMPROBADO
	 */
	public static boolean primosEntreSi(int numA, int numB) {

		if (numA<=0||numB<=0) {
			return false;
		}

		if (LibreriaMatematica.maximoComunDivisorRecursivo(numA, numB)==1) {
			return true;
		}
		else {
			return false;
		}
	}


	/**
	 * g) Método que calcule la función de Euler. La función de euler es el número de enteros positivos inferiores
	 * a dicho número y que son primos con él. Por ejemplo, el euler de 6 es 2, ya que los únicos números
	 * inferiores a él y primos con el son el 1 y el 5; euler(4)=2, euler(8)=4, euler(19)=18, euler(20)=8, …
	 * @param num
	 * @return
	 * 
	 * COMPROBADO
	 */
	public static int funcionEuler(int num) {

		int contEuler=0;

		if (num<0) {
			return contEuler=-1;
		}

		for (int cont=1;cont<num;cont++) {
			if (primosEntreSi(cont, num)) {
				contEuler++;
			}
		}
		return contEuler;
	}


	/**
	 * h) Construir un método que calcule el máximo común divisor (MCD) de dos números a y b de tipo entero, sabiendo que:
	 * MCD (a, b) = a 				si a = b
	 * MCD (a, b) = MCD (a-b, b) 	si a > b
	 * MCD (a, b) = MCD (a, b-a) 	si b > a
	 * @param numA
	 * @param numB
	 * @return
	 * 
	 * COMPROBADO
	 */
	public static int maximoComunDivisor(int numA, int numB) {

		int temporal;

		while(numB != 0) {
			temporal = numB;
			numB = numA % numB;
			numA = temporal;
		}
		return numA;
	}


	/**
	 * i) Hacer otro método que calcule el MCD pero de forma recursiva.
	 * @param numA
	 * @param numB
	 * @return
	 * 
	 * COMPROBADO
	 */
	public static int maximoComunDivisorRecursivo(int numA, int numB) {

		if (numA==numB) {
			return numA;
		}
		if (numA>numB) {
			return maximoComunDivisorRecursivo(numA-numB, numB);
		}
		else {
			return maximoComunDivisorRecursivo(numA, numB-numA);
		}
	}


	/**
	 * j) Escribir dos métodos, uno iterativo y otro recursivo para calcular la serie de Fibonacci para un término n
	 * @param num
	 * @return
	 * 
	 * COMPROBADO
	 */
	public static int fibonacciIterativo(int num) {

		int aux1=1,aux2=1,fibo=2;

		for (int cont=0;cont<num;cont++) {
			aux1=aux2;
			aux2=fibo;
			fibo=aux1+aux2;
		}
		return aux1;
	}

	/**
	 * j) Escribir dos métodos, uno iterativo y otro recursivo para calcular la serie de Fibonacci para un término n,
	 * sabiendo que:
	 * Fib(0)= 1
	 * Fib(1)= 1
	 * aFib(N)= Fib(N-1) + Fib(N-2)
	 * @param num
	 * @return
	 * 
	 * COMPROBADO
	 */
	public static int fibonacciRecursivo(int num) {

		if (num==1) {
			return 1;
		}
		if (num==0) {
			return 1;
		}
		return fibonacciRecursivo(num-1)+fibonacciRecursivo(num-2);
	}

	/**
	 * k) Método recursivo que calcula la potencia de un número A elevado a n, se deben tener en cuenta los
	 * exponentes negativos.
	 * @param base
	 * @param exponente
	 * @return
	 */
	public static int potenciaNumero(int base, int exponente) {

		if () {
			
		}
		if () {
			
		}
	}


	/**
	 * l) Método que calcular la suma de la serie de Fibonacci para un término n de forma recursiva.
	 * @param num
	 * @return
	 */
	public static int sumaFibonacciRecursivo(int num) {

		if (num==1) {
			return 1;
		}
		if (num==0) {
			return 1;
		}
		return
	}

}
