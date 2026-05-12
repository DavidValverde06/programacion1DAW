package prPractica02;

import java.util.Scanner;

/**
 * 46. Con la ayuda de la clase Random, o bien el método random de la clase Math, simular el lanzamiento de
	   una moneda al aire y visualizar por pantalla si ha salido cara o cruz. Repetir el proceso tantas veces como
	   se quiera.
 */

public class Ejercicioo46 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int moneda;
		char seguir;
		boolean lanzarOtraVez=true;


		while (lanzarOtraVez) {

			moneda=(int)(Math.random()*2)+1;

			if (moneda==1) {
				System.out.println("Ha salido --> Cruz");
			}
			else {
				System.out.println("Ha salido --> Cara");
			}

			System.out.print("¿Desea volver a lanzar la moneda (S/N)?: ");
			seguir=sc.nextLine().charAt(0);
			if (seguir=='s') {
				lanzarOtraVez=true;
			}
			else if (seguir=='n') {
				lanzarOtraVez=false;
				System.out.println("\nFIN DE PROGRAMA");
			}
			else {
				lanzarOtraVez=false;
				System.out.println("\nCarácter introducido incorrecto. FINALIZANDO PROGRAMA");
			}

		}
		
		sc.close();
	}

}
