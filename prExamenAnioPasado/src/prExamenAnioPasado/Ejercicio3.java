package prExamenAnioPasado;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {

		error revisar
		
		Scanner sc = new Scanner(System.in);

		int numTiradas,dado,contTiradas=0,contCincos=0;

		System.out.print("¿Cuántas pruebas quieres realizar para el estudio? ");
		numTiradas=sc.nextInt();

		if (numTiradas<=0) {
			System.out.println("Introduce un número de pruebas válidas");
		}
		else {

			for (int cont=0;cont<numTiradas;cont++) {

				while (contCincos<5) {
					dado=(int)(Math.random()*6)+1;
					System.out.print(dado + " ");
					if (dado==5) {
						contCincos++;
						contTiradas++;
					}
					else {
						contTiradas++;
					}
				}
				
				System.out.println("\nIntento " + cont + ": " + contTiradas + " tiradas");
			}
		}

		sc.close();
	}

}
