package prPractica02;

import java.util.Scanner;

/**
 * 50. Simular el lanzamiento de una moneda al aire y que pare cuando salgan 3 caras consecutivas. Visualizar
	   el número de tiradas realizadas.
 */

public class Ejercicioo50 {

	public static void main(String[] args) {
		
		sin hacer
		
		Scanner sc = new Scanner(System.in);

		int moneda,cont=0;
		boolean lanzarOtraVez=true;
		
		while (lanzarOtraVez) {
			moneda=(int)(Math.random()*2)+1;

			if (moneda==1) {
				System.out.println("Ha salido --> Cruz");
				cont++;
			}
			else {
				System.out.println("Ha salido --> Cara");
				cont++;
			}
			
		}
		
		sc.close();
	}

}
