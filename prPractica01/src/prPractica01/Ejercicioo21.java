package prPractica01;

import java.util.Scanner;

/**
 * 21.- Una empresa que gestiona un parque acuático nos solicita una aplicación que les ayude a calcular el
		importe que hay que cobrar en la taquilla por la compra de una serie de entradas (cuyo número será
		introducido por el usuario). Existen dos tipos de entradas: infantiles, que cuestan 15.50€, y de adultos
		que cuestan 20€.
		
		En el caso de que el importe total sea igual o superior a 100€, se aplicará automáticamente un bono
		descuento del 5%
 */

public class Ejercicioo21 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		final float ENTRADASINFANTILES=15.50f;
		final float ENTRADASADULTOS=20.00f;
		final float DESCUENTO=0.05f;
		
		float importeInfantiles,importeAdultos,importeTotal;
		int numEntradasInfantiles,numEntradasAdultos;
		
		System.out.print("Número de entradas infantiles: ");
		numEntradasInfantiles=sc.nextInt();
		
		System.out.print("Número de entradas adultos: ");
		numEntradasAdultos=sc.nextInt();
		
		importeInfantiles=ENTRADASINFANTILES*numEntradasInfantiles;
		importeAdultos=ENTRADASADULTOS*numEntradasAdultos;
		
		importeTotal=importeInfantiles+importeAdultos;
		
		System.out.println("\n(Importe total sin descuento): " + importeTotal + " €.");
		
		importeTotal= (importeTotal>=100)?(importeTotal=importeTotal-(importeTotal*DESCUENTO)):(importeTotal);
		
		System.out.println("\nImporte entradas infantiles: " + importeInfantiles + " €.");
		System.out.println("Importe entradas adultos: " + importeAdultos + " €.");
		System.out.println("Importe total: " +  importeTotal + " €.");
		
		sc.close();
		
	}

}
