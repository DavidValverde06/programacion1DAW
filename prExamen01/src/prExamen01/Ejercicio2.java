package prExamen01;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		final int NUMLANZAMIENTOSDISCO=3;
		int numAtletas,mejorAtleta=0;
		double lanzamiento,mejorLanzamiento=0;

		System.out.print("¿Cuántos atletas participarán en la prueba? ");
		numAtletas=sc.nextInt();

		for (int cont=1;cont<=numAtletas;cont++) {

			System.out.print("\nLanzamiento del atleta " + cont + ": ");

			for (int cont2=0;cont2<NUMLANZAMIENTOSDISCO;cont2++) {

				lanzamiento=(Math.random()*31)+50; // Número aleatorio entre 50 y 80 con decimales

				if (lanzamiento>mejorLanzamiento) {
					mejorLanzamiento=lanzamiento;
					mejorAtleta=cont;
				}

				System.out.print(lanzamiento + "  ");
			}

		}

		System.out.println("\n\nMejor lanzamiento: " + mejorLanzamiento + " metros, realizado por el atleta " + mejorAtleta);

		sc.close();

	}

}
