package prPractica03;

public class TestCalcularFactorial {

	public static void main(String[] args) {

		System.out.print("Método que calcula el factorial de un número: ");
		System.out.println(LibreriaMatematica.calcularFactorial(4));
		
		System.out.print("\nMétodo que calcula el factorial de un número: ");
		System.out.println(LibreriaMatematica.calcularFactorial(3));
		
		System.out.print("\nMétodo que calcula el factorial de un número: ");
		System.out.println(LibreriaMatematica.calcularFactorial(-20));
		
		System.out.print("\nMétodo que calcula el factorial de un número: ");
		System.out.println(LibreriaMatematica.calcularFactorial(-1));
		
	}

}
