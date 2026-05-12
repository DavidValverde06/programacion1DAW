package prPractica02;

/**
 * 19. ¿Qué rango de valores pueden tomar X e Y para garantizar que el siguiente algoritmo termina?
		A= X
		B = Y
		repetir
			repetir-mientras (A > B)
		A = A – B
			fin-repetir
		repetir-mientras (B > A)
			B = B – A
		fin-repetir
		mientras (A != B)

 */

public class Ejercicioo19 {

	public static void main(String[] args) {

		int A = 1;
		int B = 2;
		
		System.out.println("A: " + A);
		System.out.println("B: " + B);
		
		do {
			A=A-B;
		}
		while (A>B);
		
		do {
			B=B-A;
		}
		while (A!=B);
		
		System.out.println("\nA: " + A);
		System.out.println("B: " + B);
	}

}
