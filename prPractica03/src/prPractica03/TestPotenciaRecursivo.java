package prPractica03;

import java.util.Scanner;

public class TestPotenciaRecursivo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int base,exponente;

		System.out.print("Introduce la base: ");
		base=sc.nextInt();
		System.out.print("Introduce el exponente: ");
		exponente=sc.nextInt();

		if (LibreriaMatematica.potenciaNumero(base, exponente)==-1) {
			System.out.println("No se puede calcular la potencia de un exponente negativo.");
		}
		else {
			System.out.println("Potencia de " + base + "^" + exponente + ": " + LibreriaMatematica.potenciaNumero(base, exponente));
		}

		sc.close();
	}

}
