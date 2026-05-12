package prPractica02;

/**
 * 48. Simular 100 tiradas de 2 dados y contar las veces que entre los dos suman 10. 
 */

public class Ejercicioo48 {

	public static void main(String[] args) {

		int dado1,dado2,resultado=0;

		for (int cont=0;cont<=100;cont++) {
			dado1=(int)(Math.random()*6)+1;
			System.out.print(dado1 + "-");

			dado2=(int)(Math.random()*6)+1;
			System.out.print(dado2 + "  ");

			if (dado1+dado2==10) {
				resultado++;
			}

		}

		System.out.println("\n\nTotal de veces que suman 10: " + resultado);

	}

}
