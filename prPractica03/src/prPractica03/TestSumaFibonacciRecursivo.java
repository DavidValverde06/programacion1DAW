package prPractica03;

public class TestSumaFibonacciRecursivo {

	public static void main(String[] args) {

		for (int cont=0;cont<=10;cont++) {
			System.out.println("Suma Fib("+cont+"): " + LibreriaMatematica.sumaFibonacciRecursivo(cont));
		}
	}

}
