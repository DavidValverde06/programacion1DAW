package prPractica02;

import java.util.Scanner;

/**
 * 45. Hacer un algoritmo para que nos calcule la estadística de una serie de notas introducidas por teclado.
	   La serie finalizará con la introducción del 0, sabiendo que:
 */

public class Ejercicioo45 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		float nota,contTotal=0,contDeficiente=0,contSuficiente=0,contBien=0,contNotable=0,contSobresaliente=0;

		System.out.print("Introduce la nota: ");
		nota=sc.nextFloat();

		while (nota!=0) {

			if (nota<1||nota>10) {
				System.out.println("Introduce una nota válida");
			}
			else if (nota<5) { // Deficiente
				contDeficiente++;
				contTotal++;
			}
			else if (nota<6) { // Suficiente
				contSuficiente++;
				contTotal++;
			}
			else if (nota<7) { // Bien
				contBien++;
				contTotal++;
			}
			else if (nota<9) { // Notable
				contNotable++;
				contTotal++;
			}
			else { // Sobresaliente
				contSobresaliente++;
				contTotal++;
			}

			System.out.print("Introduce la nota: ");
			nota=sc.nextInt();
		}

		if (contDeficiente!=0) {
			System.out.println("\n" + (contDeficiente * 100 / contTotal) + " % de deficientes");
		}
		if (contSuficiente!=0) {
			System.out.println((contSuficiente * 100 / contTotal) + " % de suficientes");	
		}
		if (contBien!=0) {
			System.out.println((contBien * 100 / contTotal) + " % de bien");
		}
		if (contNotable!=0) {
			System.out.println((contNotable * 100 / contTotal) + " % de notables");	
		}
		if (contSobresaliente!=0) {
			System.out.println((contSobresaliente * 100 / contTotal) + " % de sobresalientes");
		}

		sc.close();
	}

}
