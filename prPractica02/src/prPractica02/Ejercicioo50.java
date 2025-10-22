package prPractica02;

import java.util.Scanner;

/**
 * 50. Simular el lanzamiento de una moneda al aire y que pare cuando salgan 3 caras consecutivas. Visualizar
	   el número de tiradas realizadas.
 */

public class Ejercicioo50 {

	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);

		int moneda,contCruz=0,contCara=0;
		
		while (contCara!=3 && contCruz!=3) {
			moneda=(int)(Math.random()*2)+1;

			if (moneda==1) {
				System.out.println("Ha salido --> Cruz\n");
				contCruz++;
				contCara=0;
			}
			else {
				System.out.println("Ha salido --> Cara\n");
				contCara++;
				contCruz=0;
			}
			
		}
		
		if (contCara==3) {
			System.out.println("Ha salido cara " + contCara + " veces consecutivas.");
		}
		else {
			System.out.println("Ha salido cruz " + contCruz + " veces consecutivas.");

		}
		
		System.out.println("\nFIN DE PROGRAMA");
		
		sc.close();
	}

}
