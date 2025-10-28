package prPracticaRepaso01;

import java.util.Scanner;

/**
 * 5. Hacer un programa para averiguar la frecuencia relativa con la que saldría cada uno de los números
	  de un dado si lanzáramos éste 1000 veces.
 */

public class Ejercicio5 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		final int NUMTIRADAS = 100;
		int dado,contUno = 0,contDos = 0,contTres = 0,contCuatro = 0,contCinco = 0,contSeis = 0;

		System.out.println("NÚMERO DE TIRADAS: " + NUMTIRADAS);
		
		for (int cont=0;cont<NUMTIRADAS;cont++) {
			dado=(int)(Math.random()*6)+1;
//			System.out.println(dado);

			if (dado==1) {
				contUno++;
			}
			if (dado==2) {
				contDos++;
			}
			if (dado==3) {
				contTres++;
			}
			if (dado==4) {
				contCuatro++;
			}
			if (dado==5) {
				contCinco++;
			}
			if (dado==6) {
				contSeis++;
			}
		}
		
		System.out.println("\nNúmero de veces que ha salido un uno: " + contUno);
		System.out.println("Número de veces que ha salido un dos: " + contDos);
		System.out.println("Número de veces que ha salido un tres: " + contTres);
		System.out.println("Número de veces que ha salido un cuatro: " + contCuatro);
		System.out.println("Número de veces que ha salido un cinco: " + contCinco);
		System.out.println("Número de veces que ha salido un seis: " + contSeis);

		sc.close();
	}

}
