package prPractica03;

public class TestLibreriaMatematica {

	public static void main(String[] args) {

		System.out.print("Método que indica si un número es primo o no: ");
		System.out.println(LibreriaMatematica.esPrimo(2));


		System.out.print("\nMétodo que calcula el factorial de un número: ");
		System.out.println(LibreriaMatematica.calcularFactorial(4));


		System.out.print("\nMétodo que calcula el combinatorio de dos números: ");
		System.out.println(LibreriaMatematica.calcularCombinatorio(4, 2));


		System.out.print("\nMétodo que calcula si un número es perfecto o no: ");
		System.out.println(LibreriaMatematica.esPerfecto(6));


		System.out.print("\nMétodo que calcula si dos números son amigos: ");
		System.out.println(LibreriaMatematica.sonAmigos(220, 284));


		System.out.print("\nMétodo que calcula si dos números son primos entre sí: ");
		System.out.println(LibreriaMatematica.primosEntreSi(5, 18));
		
		
	}

}
