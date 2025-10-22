package prPractica02;

import java.util.Scanner;

/**
 * 52. Simular el lanzamiento de dos monedas un número determinado de tiradas. Calcular cuántas caras y 
	   cuántas cruces han salido, e imprimir el número mayor de tiradas consecutivas con dos caras.
 */

public class Ejercicioo52 {

	public static void main(String[] args) {

		tiene un fallo revisar
		
		Scanner sc = new Scanner(System.in);
		
		int numTiradas,moneda1,moneda2,contCruces=0,contCaras=0,contConsecutivas=0,totalConsecutivas=0;
		
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
			
			if (moneda1==0 && moneda2==0) {
				contConsecutivas++;
				totalConsecutivas = contConsecutivas;
			}
			else if (moneda1==1 && moneda2==0) {
				contConsecutivas++;
				totalConsecutivas = contConsecutivas;
			}
			else {
				contConsecutivas=0;
			}
			
			System.out.println(moneda1 + " " + moneda2);
		}
		
		System.out.println("\nCaras: " + contCaras);
		System.out.println("Cruces: " + contCruces);
		System.out.println("Máximo de caras consecutivas: " + totalConsecutivas);
		
		sc.close();
	}

}
