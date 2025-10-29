package prPractica02;

import java.util.Scanner;

/**
 * 52. Simular el lanzamiento de dos monedas un número determinado de tiradas. Calcular cuántas caras y 
	   cuántas cruces han salido, e imprimir el número mayor de tiradas consecutivas con dos caras.
 */

public class Ejercicioo52 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int numTiradas,moneda1,moneda2,contCruces=0,contCaras=0,contConsecutivasCara=0,
				totalConsecutivasCara=0,contConsecutivasCruz=0,totalConsecutivasCruz=0;

		System.out.print("Cuántas tiradas va a realizar: ");
		numTiradas=sc.nextInt();

		for (int cont=0;cont<numTiradas;cont++) {
			moneda1=(int)(Math.random()*2); // LOS 0 REPRESENTAN CARAS
			moneda2=(int)(Math.random()*2); // LOS 1 REPRESENTAN CRUZ

			if (moneda1==0) {
				contCaras++;
			}
			else {
				contCruces++;
			}

			if (moneda2==0) {
				contCaras++;
			}
			else {
				contCruces++;
			}

			System.out.println(moneda1 + " " + moneda2);

			if (moneda1==0 && moneda2==0) {
				contConsecutivasCara++;
				if (contConsecutivasCara>totalConsecutivasCara) {
					totalConsecutivasCara = contConsecutivasCara;
				}
			}
			else if (moneda1==1 && moneda2==1) {
				contConsecutivasCruz++;
				if (contConsecutivasCruz>totalConsecutivasCruz) {
					totalConsecutivasCruz = contConsecutivasCruz;
				}
			}
			else {
				contConsecutivasCara=0;
				contConsecutivasCruz=0;
			}

		}

		System.out.println("\nCaras: " + contCaras);
		System.out.println("Cruces: " + contCruces);
		if (totalConsecutivasCara>totalConsecutivasCruz) {
			System.out.println("Máximo de caras consecutivas: " + totalConsecutivasCara);
		}
		else {
			System.out.println("Máximo de caras consecutivas: " + totalConsecutivasCruz);
		}
		sc.close();
	}

}
