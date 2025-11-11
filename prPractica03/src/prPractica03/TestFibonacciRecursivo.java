package prPractica03;

public class TestFibonacciRecursivo {

	public static void main(String[] args) {

		System.out.println("Método que calcula la serie de Fibonacci de forma recursiva: ");
		for (int cont=0;cont<=10;cont++) {
			System.out.println("Fib(" + cont + "): " + LibreriaMatematica.fibonacciRecursivo(cont));
		}
	}

}
