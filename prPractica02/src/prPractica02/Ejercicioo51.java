package prPractica02;

/**
 * 51. Generar aleatoriamente una quiniela de una columna, si la probabilidad de que salga 1 es del 50%, la x
	   es del 30% y la del 2 es del 20%.
 */

public class Ejercicioo51 {

	public static void main(String[] args) {

		int quiniela,contUno=0,contDos=0,contX=0;

		for (int cont=1;cont<=15;cont++) {

			quiniela = (int)(Math.random()*10)+1;

			if (quiniela>=1 && quiniela<=5) {
				System.out.println("Encuentro " + cont + ": 1");
				contUno++;
			}
			else if (quiniela>=6 && quiniela<=7) {
				System.out.println("Encuentro " + cont + ": 2");
				contDos++;
			}
			else if (quiniela>=8 && quiniela<=10) {
				System.out.println("Encuentro " + cont + ": x");
				contX++;
			}
			
		}

		System.out.println("\nContador de 1: " + contUno);
		System.out.println("Contador de 2: " + contDos);
		System.out.println("Contador de x: " + contX);
		
	}

}
